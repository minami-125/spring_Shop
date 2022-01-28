package com.spring.shop.gallery;

public class Gallery {
	
	private int ga_no;
	private String ga_title;
	private String ga_content;
	private String ga_instate;
	private String ga_writer;
	
	private String file_name;
	private String saved_file_name;
	
	public Gallery() {
		
	}

	

	public Gallery(int ga_no, String ga_title, String ga_content, String ga_instate, String ga_writer, String file_name,
			String saved_file_name) {
		super();
		this.ga_no = ga_no;
		this.ga_title = ga_title;
		this.ga_content = ga_content;
		this.ga_instate = ga_instate;
		this.ga_writer = ga_writer;
		this.file_name = file_name;
		this.saved_file_name = saved_file_name;
	}



	public int getGa_no() {
		return ga_no;
	}

	public void setGa_no(int ga_no) {
		this.ga_no = ga_no;
	}

	public String getGa_title() {
		return ga_title;
	}

	public void setGa_title(String ga_title) {
		this.ga_title = ga_title;
	}

	public String getGa_content() {
		return ga_content;
	}

	public void setGa_content(String ga_content) {
		this.ga_content = ga_content;
	}

	public String getGa_instate() {
		return ga_instate;
	}

	public void setGa_instate(String ga_instate) {
		this.ga_instate = ga_instate;
	}

	public String getGa_writer() {
		return ga_writer;
	}

	public void setGa_writer(String ga_writer) {
		this.ga_writer = ga_writer;
	}



	public String getFile_name() {
		return file_name;
	}



	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}



	public String getSaved_file_name() {
		return saved_file_name;
	}



	public void setSaved_file_name(String saved_file_name) {
		this.saved_file_name = saved_file_name;
	}
	
	

}
