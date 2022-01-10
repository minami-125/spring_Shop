package com.spring.shop.notice;

import java.io.Console;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shop.login.Member;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeDAO nDAO;

	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(Notice n, HttpServletRequest req) {
		req.setAttribute("content", "notice/notice.jsp");
		return "home";
	}
	
	//list 출력
	@RequestMapping(value = "/getNoticeList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> noticeList(HttpServletRequest req) {
		Map<String, Object> allNotice = nDAO.allNotice(req);
		return allNotice;
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload(HttpServletRequest req) {
		req.setAttribute("content", "notice/write.jsp");
		return "home";
	}

	
	//글 입력
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(Notice n, HttpServletRequest req) {
		int rst = nDAO.uploadNotice(n);
		if(rst >= 1) {
			req.setAttribute("MSG", "업로드 성공");
			req.setAttribute("content", "notice/notice.jsp");
		}else {
			req.setAttribute("MSG", "업로드 실패");
			req.setAttribute("content", "notice/write.jsp");
		}
		
		return "home";
	}
	
	//글 출력
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Notice n, HttpServletRequest req) {
		
		Notice one = nDAO.printNotice(n);
		req.setAttribute("selectOne", one);
		req.setAttribute("content", "notice/read.jsp");
		
		return "home";
	}
	
	//글 수정
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Notice n, HttpServletRequest req) {
		
		int rst = nDAO.updateNotice(n);
		if(rst >= 1) {
			req.setAttribute("MSG", "업데이트 완료");
			Notice printNotice = nDAO.printNotice(n);
			req.getSession().setAttribute("printNotice", printNotice); //session에 업데이트한 회원 정보 저장
			
		}else {
			req.setAttribute("MSG", "업데이트 실패");
		}
		req.setAttribute("content", "notice/read.jsp");
		
		return "home";
	}

	//글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteNotice(Notice n, HttpServletRequest req) {
		
		int rst = nDAO.deleteNotice(n);
		
		if(rst >= 1) {
			req.setAttribute("MSG", "삭제 성공");
			req.setAttribute("content", "notice/notice.jsp");
		}else {
			req.setAttribute("MSG", "삭제 실패");
			req.setAttribute("MSG", "notice/read.jsp");
		}
		
		return "home";
	}
	
	
}
