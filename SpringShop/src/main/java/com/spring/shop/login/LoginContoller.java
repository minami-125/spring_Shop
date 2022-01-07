package com.spring.shop.login;

import java.io.Console;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginContoller {
	
	@Autowired
	MemberDAO mDAO;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		req.setAttribute("content", "login/login.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(HttpServletRequest req) {
		req.setAttribute("content", "login/signup.jsp");
		return "home";
	}
	
	//signup
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String insertSign(Member m, HttpServletRequest req) {
		int rst = mDAO.joinMember(m);
		if(rst >= 1) { //rst>=1: DB연동 됨
			req.setAttribute("MSG", "회원가입성공"); //login.jsp로 메세지 전송
		}else {
			req.setAttribute("MSG", "회원가입실패");
		}
		req.setAttribute("content", "login/login.jsp");
		return "home";

	}
	
	//login
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String sucLogin(Member m, HttpServletRequest req) {
		
		Member loginMember = mDAO.loginMember(m);
		if(loginMember != null) { 
			req.getSession().setAttribute("loginMember", loginMember); //session에 로그인한 회원 정보 저장
			req.setAttribute("MSG", "로그인 성공");
			req.setAttribute("content", "main.jsp");
		}else {
			req.setAttribute("MSG", "로그인 실패");
			req.setAttribute("content", "login/login.jsp");
		}
		return "home";
	}
	
	//mypage
	@RequestMapping(value="/mypage", method = RequestMethod.GET)
	public String mypage(Member m, HttpServletRequest req) {
		req.setAttribute("content", "login/signup.jsp");
		return "home";
	}
	
	//logout
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		req.setAttribute("content", "main.jsp");
		
		return "home";
	}
	
	//update
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Member m, HttpServletRequest req) {
		int rst = mDAO.updateMember(m);
		if(rst >= 1) {
			req.setAttribute("MSG", "업데이트 완료");
			Member loginMember = mDAO.loginMember(m);
			req.getSession().setAttribute("loginMember", loginMember); //session에 업데이트한 회원 정보 저장
		}else {
			req.setAttribute("MSG", "업데이트 실패");
		}
		req.setAttribute("content", "login/signup.jsp");
		
		return "home";
	}

	//delete
	@RequestMapping(value="/drop", method = RequestMethod.GET)
	public String deletePost(Member m, HttpServletRequest req) {

		int rst = mDAO.deleteMember(m);
//		System.out.println(req.getParameter("mi_id"));
	
		if(rst >= 1) {
			req.setAttribute("MSG", "탈퇴 성공");
			req.getSession().invalidate();
			req.setAttribute("content", "main.jsp");
		}else {
			req.setAttribute("MSG", "탈퇴 실패");
			req.setAttribute("MSG", "login/signup.jsp");
		}
		
		return "home";
	}
	
}
