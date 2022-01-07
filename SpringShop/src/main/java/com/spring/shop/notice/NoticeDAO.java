package com.spring.shop.notice;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.login.MemberMapper;

@Service
public class NoticeDAO {
	
	@Autowired
	SqlSession ss;
	
	public int uploadNotice(Notice n) {
		return ss.getMapper(NoticeMapper.class).uploadNotice(n);
	}
	
	public Notice printNotice(Notice n) {
		return ss.getMapper(NoticeMapper.class).printNotice(n);
	}
}
