package com.zhiyou100.pojo;

public class User {
	private Integer uId;
	private String uUsername;
	private String uPassword;
	private String uName;
	private String uTel;
	private String uStatus;
	public User(Integer uId, String uUsername, String uPassword, String uName, String uTel, String uStatus) {
		super();
		this.uId = uId;
		this.uUsername = uUsername;
		this.uPassword = uPassword;
		this.uName = uName;
		this.uTel = uTel;
		this.uStatus = uStatus;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getuUsername() {
		return uUsername;
	}
	public void setuUsername(String uUsername) {
		this.uUsername = uUsername;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	public String getuStatus() {
		return uStatus;
	}
	public void setuStatus(String uStatus) {
		this.uStatus = uStatus;
	}
	

}
