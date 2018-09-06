package com.zhiyou100.pojo;

import java.sql.Date;

public class Lessee {
	private Integer lId;
	private String lName;
	private String lTel;
	private Character lSex;
	private String lNativePlace;
	private String lIdcade;
	private Date lAddtime;
	public Lessee(Integer lId, String lName, String lTel, Character lSex, String lNativePlace, String lIdcade, Date lAddtime) {
		super();
		this.lId = lId;
		this.lName = lName;
		this.lTel = lTel;
		this.lSex = lSex;
		this.lNativePlace = lNativePlace;
		this.lIdcade = lIdcade;
		this.lAddtime = lAddtime;
	}
	public Lessee() {
	}
	public Integer getlId() {
		return lId;
	}
	public void setlId(Integer lId) {
		this.lId = lId;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getlTel() {
		return lTel;
	}
	public void setlTel(String lTel) {
		this.lTel = lTel;
	}
	public Character getlSex() {
		return lSex;
	}
	public void setlSex(Character lSex) {
		this.lSex = lSex;
	}
	public String getlNativePlace() {
		return lNativePlace;
	}
	public void setlNativePlace(String lNativePlace) {
		this.lNativePlace = lNativePlace;
	}
	public String getlIdcade() {
		return lIdcade;
	}
	public void setlIdcade(String lIdcade) {
		this.lIdcade = lIdcade;
	}
	public Date getlAddtime() {
		return lAddtime;
	}
	public void setlAddtime(Date lAddtime) {
		this.lAddtime = lAddtime;
	}
	@Override
	public String toString() {
		return "Lessee [lId=" + lId + ", lName=" + lName + ", lTel=" + lTel + ", lSex=" + lSex + ", lNativePlace="
				+ lNativePlace + ", lIdcade=" + lIdcade + ", lAddtime=" + lAddtime + "]";
	}
	
	

}
