package com.spring.shop.gallery;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GalleryController {
	
	@Autowired
	GalleryDAO gDAO;

	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String gallery(HttpServletRequest req) {
		req.setAttribute("content", "gallery/gallery.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/gawrite", method = RequestMethod.GET)
	public String gawrite(HttpServletRequest req) {
		req.setAttribute("content", "gallery/gawrite.jsp");
		return "home";
	}
	
	//리스트
	@RequestMapping(value = "/getGalleryList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> galleryList(HttpServletRequest req){
		Map<String, Object> readGallery = gDAO.readGallery(req);
		return readGallery;
	}

	//글 입력
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(Gallery g, HttpServletRequest req) {
		
		int rst = gDAO.uploadGallery(g, req);
		if(rst>=1) {
			req.setAttribute("MSG", "업로드 성공");
			req.setAttribute("content", "gallery/galread.jsp");
		}else {
			req.setAttribute("MSG", "업로드 실패");
			req.setAttribute("content", "gallery/gawrite.jsp");
		}
		
		return "home";
	}
	
	
}
