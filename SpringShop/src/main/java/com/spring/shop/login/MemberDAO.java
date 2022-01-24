package com.spring.shop.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {
	@Autowired
	SqlSession ss;
	
	public int joinMember(Member m) { //DB연동 유무가 int값으로 반환
		//공백 제거
		String id = m.getMi_id();
		id = id.trim();
		System.out.println(id);
		m.setMi_id(id);
		
		return ss.getMapper(MemberMapper.class).joinMember(m); //LoginController.java의 rst에 연동 유무 return
		//ss.getMapper(MemberMapper.class)는 MyBatis를 사용하기 위한 문법		
	}
	
	public Member loginMember(Member m) { //입력받은 데이터 값 Member에 저장
		 return ss.getMapper(MemberMapper.class).loginMember(m);
	}
	
	public int idCheck(HttpServletRequest req) {
		String id = req.getParameter("username");
		return ss.getMapper(MemberMapper.class).idCheck(id);
	}
	
	public int updateMember(Member m) {
		return ss.getMapper(MemberMapper.class).updateMember(m);
	}
	
	public int deleteMember(Member m) {
		return ss.getMapper(MemberMapper.class).deleteMember(m);
	}

}
