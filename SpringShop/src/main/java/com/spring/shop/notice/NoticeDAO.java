package com.spring.shop.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
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
public class NoticeDAO {
	
	@Autowired
	SqlSession ss;
	
	@Autowired
	PageGenerator pg; 
	
	public int uploadNotice(Notice n, HttpServletRequest req) throws IOException {
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		File saveDir = new File(path);
		long fileSize = 0;
		String fileSavedName = "";
		String name = "";
		
		//폴더 있는지 확인 후 없으면 생성
		if(!saveDir.exists()) { //saveDir이 없으면
			saveDir.mkdirs();   //상위 폴더까지 생성
		}
		
		try {
			// 파일이 서버에 잘 올라갔는지 확인 -> try catch 
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req; // req에 파일이 저장되어 있음
			MultipartFile f = mr.getFile("file");
			fileSize = f.getSize();
			name = f.getOriginalFilename(); //업로드 파일명
			File destination = File.createTempFile("F_" + System.currentTimeMillis(), name.substring(name.lastIndexOf(".")), saveDir); //업로드 파일의 가명
			fileSavedName = destination.getName();
			FileCopyUtils.copy(f.getInputStream(), new FileOutputStream(destination)); //웹서버에 업로드
			try {
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("name", name);
				param.put("fileSavedName", fileSavedName);
				param.put("fileSize", fileSize);
				int filerst = ss.getMapper(NoticeMapper.class).addFile(param);
				if(filerst > 0) {
					return ss.getMapper(NoticeMapper.class).uploadNotice(n);
				}else {
					return 0;
				}
			} catch (Exception e) {
				// db통신 실패했으니 서버에 방금 올린거 지워야겠고..
				File delFile = new File(path + "/" + fileSavedName );
				delFile.delete();
				return 0;
			}
		} catch (Exception e) {
			System.out.println("파일업로드 실패..");
			return 0;
		}
		// 이 정보들 boardAttach에 넣어야..
		// notice_info에도 넣어야. -> myBatis selectKey 사용
		// boardID -> max(ni_no) + 1
	}
	
	public Notice printNotice(Notice n) {
		return ss.getMapper(NoticeMapper.class).printNotice(n);
	}
	
	public Map<String, Object> allNotice(HttpServletRequest req){
		Map<String, Object> result = new HashMap<String, Object>();
		
		int totalCnt = ss.getMapper(NoticeMapper.class).totalCnt();
		int pagePerCnt = Integer.parseInt(req.getParameter("pagePerCnt"));
		int curPage = Integer.parseInt(req.getParameter("curPage"));
		
		Map<String, Object> param = pg.generatePagingParam(totalCnt, pagePerCnt, curPage);
		List<Notice> list = ss.getMapper(NoticeMapper.class).allNotice(param);
		
		result.put("paging", param);
		result.put("list", list);
		return result;
	}
	
	public int updateNotice(Notice n) {
		return ss.getMapper(NoticeMapper.class).updateNotice(n);
	}
	
	public int deleteNotice(Notice n) {
		return ss.getMapper(NoticeMapper.class).deleteNotice(n);
	}
}
