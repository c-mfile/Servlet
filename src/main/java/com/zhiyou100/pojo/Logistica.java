package com.zhiyou100.pojo;

import java.sql.Date;

public class Logistica {
	private Integer laId;
	private String laName;
	private String laIdcard;
	private String laTel;
	private String laSex;
	private String laDept;
	private Date laAddTime;
	private Integer laSalary;
	public Logistica() {
	}
	
	public String getLaIdcard() {
		return laIdcard;
	}

	public void setLaIdcard(String laIdcard) {
		this.laIdcard = laIdcard;
	}

	
	public Integer getLaId() {
		return laId;
	}
	public void setLaId(Integer laId) {
		this.laId = laId;
	}
	public String getLaName() {
		return laName;
	}
	public void setLaName(String laName) {
		this.laName = laName;
	}

	public String getLaTel() {
		return laTel;
	}

	public void setLaTel(String laTel) {
		this.laTel = laTel;
	}

	public Logistica(Integer laId, String laName, String laIdcard, String laTel, String laSex, String laDept,
			Date laAddTime, Integer laSalary, String laHogar) {
		super();
		this.laId = laId;
		this.laName = laName;
		this.laIdcard = laIdcard;
		this.laTel = laTel;
		this.laSex = laSex;
		this.laDept = laDept;
		this.laAddTime = laAddTime;
		this.laSalary = laSalary;
		this.laHogar = laHogar;
	}

	public String getLaSex() {
		return laSex;
	}
	public void setLaSex(String laSex) {
		this.laSex = laSex;
	}
	public String getLaDept() {
		return laDept;
	}
	public void setLaDept(String laDept) {
		this.laDept = laDept;
	}
	public Date getLaAddTime() {
		return laAddTime;
	}
	public void setLaAddTime(Date laAddTime) {
		this.laAddTime = laAddTime;
	}
	public Integer getLaSalary() {
		return laSalary;
	}
	public void setLaSalary(Integer laSalary) {
		this.laSalary = laSalary;
	}
	public String getLaHogar() {
		return laHogar;
	}
	public void setLaHogar(String laHogar) {
		this.laHogar = laHogar;
	}
	private String laHogar;
	
	

}
