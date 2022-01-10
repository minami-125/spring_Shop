package com.spring.shop.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.PageGenerator;
import com.spring.shop.login.MemberMapper;

@Service
public class NoticeDAO {
	
	@Autowired
	SqlSession ss;
	
	@Autowired
	PageGenerator pg; 
	
	public int uploadNotice(Notice n) {
		return ss.getMapper(NoticeMapper.class).uploadNotice(n);
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
