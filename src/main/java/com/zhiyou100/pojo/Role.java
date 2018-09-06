package com.zhiyou100.pojo;

public class Role {
	private Integer rId;
	private String rName;
	private String rDesc;
	public Role(Integer rId, String rName, String rDesc) {
		super();
		this.rId = rId;
		this.rName = rName;
		this.rDesc = rDesc;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrDesc() {
		return rDesc;
	}
	public void setrDesc(String rDesc) {
		this.rDesc = rDesc;
	}
	
}
