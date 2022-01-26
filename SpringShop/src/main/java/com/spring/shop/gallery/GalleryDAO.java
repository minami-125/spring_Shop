package com.spring.shop.gallery;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		List<MultipartFile> files = mr.getFiles("files");
		for (MultipartFile m : files) {
			System.out.println(m.getOriginalFilename());
		}
		
		
		
		return ss.getMapper(GalleryMapper.class).uploadGallery(g);
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
	
	public Gallery printGallery(Gallery g) {
		return ss.getMapper(GalleryMapper.class).printGallery(g);
	}
}
