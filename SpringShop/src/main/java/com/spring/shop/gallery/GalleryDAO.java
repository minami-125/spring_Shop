package com.spring.shop.gallery;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.PageGenerator;

@Service
public class GalleryDAO {
	
	@Autowired
	SqlSession ss;
	
	@Autowired
	PageGenerator pg;
	
	public int uploadGallery(Gallery g, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		File saveDir = new File(path);
		long galfileSize = 0;
		String galSavedName = "";
		String galName = "";
		
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		List<MultipartFile> files = mr.getFiles("files");
		Map<String, Object> param = new HashMap<String, Object>();
		for (MultipartFile m : files) {
			System.out.println(m.getOriginalFilename());
		}
		try {
			ss.getMapper(GalleryMapper.class).uploadGallery(g);
			if(mr.getFile("files") != null) {
				for(MultipartFile m: files) {
					galfileSize = m.getSize();
					System.out.println("FILE SIZE "+galfileSize);
					galName = m.getOriginalFilename();
					System.out.println("GALLERY NAME "+galName);
					File dest = File.createTempFile("F_"+System.currentTimeMillis(), galName.substring(galName.lastIndexOf(".")),saveDir);
					galSavedName = dest.getName();
					System.out.println("SAVE FILE NAME "+galSavedName);
					FileCopyUtils.copy(m.getInputStream(), new FileOutputStream(dest));
					param.put("galfileSize", galfileSize);
					param.put("galSavedName", galSavedName);
					param.put("galName", galName);
					try {
						param.put("board_id", g.getGa_no());
						System.out.println("Gallery Num: "+g.getGa_no());
						int rst = ss.getMapper(GalleryMapper.class).addFiles(param);
					}catch(Exception e) {
						e.printStackTrace();
						File delFile = new File(path+"/"+galSavedName);
						delFile.delete();
					}
				}
			}else {
				System.out.println("galDAO if else");
			}
			return 1;
		}catch (Exception e){
			System.out.println("try catch");
			return 0;
		}
		
	}

	public int updateGallery(Gallery g, HttpServletRequest req) {
		return ss.getMapper(GalleryMapper.class).updateGallery(g);
	}
	
	public Map<String, Object> readGallery(HttpServletRequest req) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		int all = ss.getMapper(GalleryMapper.class).count();
		int pageCnt = Integer.parseInt(req.getParameter("pageCnt"));
		int curPage = Integer.parseInt(req.getParameter("curPage"));
		
		System.out.println("count all gallery "+all);
		
		Map<String, Object> param = pg.generatePagingParam(all, pageCnt, curPage);
		List<Gallery> gal = ss.getMapper(GalleryMapper.class).readGallery(param);
		
		result.put("paging", param);
		result.put("list", gal);
		
		return result;
	}
	
	public Map<String, Object> printGallery(Gallery g) {
		
		Map<String, Object> galFiles = new HashMap<String, Object>();
		Gallery gf = ss.getMapper(GalleryMapper.class).printGallery(g);
		galFiles.put("show", gf);
		if(gf != null) {
			int num = gf.getGa_no();
			
		}
		
		return galFiles;
	}
}
