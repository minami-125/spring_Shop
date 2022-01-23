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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.PageGenerator;

@Service
@Transactional
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
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req; // req에 파일이 저장되어 있음
		System.out.println("!!!!!!!!!!!!!!!!!!!");
		System.out.println(mr.getFile("file"));
		System.out.println("!!!!!!!!!!!!!!!!!!!");
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			ss.getMapper(NoticeMapper.class).uploadNotice(n);
			if(mr.getFile("file") != null) {
				try {
					MultipartFile f = mr.getFile("file");
					fileSize = f.getSize();
					name = f.getOriginalFilename(); //업로드 파일명
					File destination = File.createTempFile("F_" + System.currentTimeMillis(), name.substring(name.lastIndexOf(".")), saveDir); //업로드 파일의 가명
					fileSavedName = destination.getName();
					FileCopyUtils.copy(f.getInputStream(), new FileOutputStream(destination)); //웹서버에 업로드
					param.put("name", name);
					param.put("fileSavedName", fileSavedName);
					param.put("fileSize", fileSize);
					try {
						param.put("board_id", n.getNi_no());
						int rst = ss.getMapper(NoticeMapper.class).addFile(param);
						System.out.println("!!!!!!!!!!!FILE UPLOAD " + rst);
					} catch (Exception e) {
						e.printStackTrace();
						File delFile = new File(path + "/" + fileSavedName );
						delFile.delete();
					}
				} catch (Exception e) {
					System.out.println("파일 업로드할떄 문제생김");
				}
			}
			return 1;
		}catch (Exception e) {
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
		
		//파일만 수정 or 게시글만 수정
		//기존 파일 삭제
//		String path = req.getSession().getServletContext().getRealPath("resources/file");
//		File saveDir = new File(path);
		
		return ss.getMapper(NoticeMapper.class).updateNotice(n);
	}
	
	@Transactional
	public int deleteNotice(HttpServletRequest req) {
		
		//서버에서 삭제 
		//디비에서 삭제 
		//게시글에서 삭제
		System.out.println(req.getParameter("saved_file_name"));
		System.out.println(req.getParameter("file_name"));
		System.out.println(req.getParameter("ni_no"));
		String fileSavedName = req.getParameter("saved_file_name");
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		System.out.println("DAO path:"+path);
		
		int ni_no = Integer.parseInt(req.getParameter("ni_no"));

		try {
			//서버 삭제
			File delFile = new File(path + "/" + fileSavedName );
			delFile.delete();
				
			if(!delFile.exists()) {
				//DB 삭제
				ss.getMapper(NoticeMapper.class).deleteFile(ni_no);
				return ss.getMapper(NoticeMapper.class).deleteNotice(ni_no);
			}else {
				System.out.println("DB 삭제 실패");
				return 0;
			}
		}catch (Exception e) {
			System.out.println("서버 삭제 실패");
			return 0;
		}
			
	}
}
