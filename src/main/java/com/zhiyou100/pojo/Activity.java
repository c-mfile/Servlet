package com.zhiyou100.pojo;

import java.sql.Date;

public class Activity {
	private Integer aId;
	private Date aDate;
	private String aTheme;
	private String aContet;
	private String aSite;
	private Integer aCost;
	private String aOrganizer;
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public Date getaDate() {
		return aDate;
	}
	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}
	public String getaTheme() {
		return aTheme;
	}
	public void setaTheme(String aTheme) {
		this.aTheme = aTheme;
	}
	public String getaContet() {
		return aContet;
	}
	public void setaContet(String aContet) {
		this.aContet = aContet;
	}
	public String getaSite() {
		return aSite;
	}
	public void setaSite(String aSite) {
		this.aSite = aSite;
	}
	public Integer getaCost() {
		return aCost;
	}
	public void setaCost(Integer aCost) {
		this.aCost = aCost;
	}
	public String getaOrganizer() {
		return aOrganizer;
	}
	public void setaOrganizer(String aOrganizer) {
		this.aOrganizer = aOrganizer;
	}
	public Activity(Integer aId, Date aDate, String aTheme, String aContet, String aSite, Integer aCost,
			String aOrganizer) {
		super();
		this.aId = aId;
		this.aDate = aDate;
		this.aTheme = aTheme;
		this.aContet = aContet;
		this.aSite = aSite;
		this.aCost = aCost;
		this.aOrganizer = aOrganizer;
	}
	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
