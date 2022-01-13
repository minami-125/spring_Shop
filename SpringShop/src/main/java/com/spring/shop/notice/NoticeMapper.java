package com.spring.shop.notice;

import java.util.List;
import java.util.Map;

public interface NoticeMapper {
	
	public int uploadNotice(Notice n);
	
	public Notice printNotice(Notice n);

	public List<Notice> allNotice(Map<String, Object> param);
	
	//ÃÑ °Ô½Ã±Û ¼ö
	public int totalCnt();
	
	public int updateNotice(Notice n);
	
	public int deleteNotice(Notice n);
	
	public abstract int addFile(Map<String, Object> param);

	public abstract int deleteFile(Map<String, Object> param);
	
}
