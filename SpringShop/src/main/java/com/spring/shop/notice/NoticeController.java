package com.spring.shop.notice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeDAO nDAO;

	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(HttpServletRequest req) {
		req.setAttribute("content", "notice/notice.jsp");

		
		return "home";
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
	
	//리스트 출력
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String print(Notice n, HttpServletRequest req) {
		
		//Notice printNotice = nDAO.printNotice(n);
		
		
		
		return "home"; 
	}
	
	//글 출력
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Notice n, HttpServletRequest req) {
		
		req.setAttribute("ni_no", 10);
		n.setNi_no(10);
		
		Notice printNotice = nDAO.printNotice(n);
		System.out.println("여기 컨트롤러임"+n.getNi_no());

		req.setAttribute("details", printNotice);
		
		req.setAttribute("content", "notice/read.jsp");
		
		return "home";
	}
	
	//글 수정
	
	
	//글 삭제
	
	
}
