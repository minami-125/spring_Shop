package com.spring.shop.gallery;

import java.util.List;
import java.util.Map;

public interface GalleryMapper {
	
	public int uploadGallery(Gallery g);

	public List<Gallery> readGallery(Map<String, Object> param);
	
	public int count();
	
	public int updateGallery(Gallery g);
	
	public Gallery printGallery(Gallery g);
	
	public abstract int addFiles(Map<String, Object> param);

}
