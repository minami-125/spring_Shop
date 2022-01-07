package com.spring.shop.notice;

public class Notice {

	private int ni_no;
	private String ni_title;
	private String ni_content;
	private String ni_instate;
	private String ni_writer;
	
	public Notice() {
		
	}

	public Notice(int ni_no, String ni_title, String ni_content, String ni_instate, String ni_writer) {
		super();
		this.ni_no = ni_no;
		this.ni_title = ni_title;
		this.ni_content = ni_content;
		this.ni_instate = ni_instate;
		this.ni_writer = ni_writer;
	}

	public int getNi_no() {
		return ni_no;
	}

	public void setNi_no(int ni_no) {
		this.ni_no = ni_no;
	}

	public String getNi_title() {
		return ni_title;
	}

	public void setNi_title(String ni_title) {
		this.ni_title = ni_title;
	}

	public String getNi_content() {
		return ni_content;
	}

	public void setNi_content(String ni_content) {
		this.ni_content = ni_content;
	}

	public String getNi_instate() {
		return ni_instate;
	}

	public void setNi_instate(String ni_instate) {
		this.ni_instate = ni_instate;
	}

	public String getNi_writer() {
		return ni_writer;
	}

	public void setNi_writer(String ni_writer) {
		this.ni_writer = ni_writer;
	}
	
	
	
}
