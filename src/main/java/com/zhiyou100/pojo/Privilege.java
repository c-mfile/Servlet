package com.zhiyou100.pojo;

public class Privilege {
	private Integer pId;
	private String pName;
	private String pSourceName;
	private String pSourceUrl;
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpSourceName() {
		return pSourceName;
	}
	public void setpSourceName(String pSourceName) {
		this.pSourceName = pSourceName;
	}
	public String getpSourceUrl() {
		return pSourceUrl;
	}
	public void setpSourceUrl(String pSourceUrl) {
		this.pSourceUrl = pSourceUrl;
	}
	public Privilege(Integer pId, String pName, String pSourceName, String pSourceUrl) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pSourceName = pSourceName;
		this.pSourceUrl = pSourceUrl;
	}
	public Privilege() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
