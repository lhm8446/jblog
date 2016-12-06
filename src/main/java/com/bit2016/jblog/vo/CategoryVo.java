package com.bit2016.jblog.vo;

public class CategoryVo {
	
	private Long no;
	private String name;
	private String des;
	private String regDate;
	private Long userNo;
	private Long postNo;
	
	public Long getPostNo() {
		return postNo;
	}
	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", des=" + des + ", regDate=" + regDate + ", userNo="
				+ userNo + ", postNo=" + postNo + "]";
	}
	

}
