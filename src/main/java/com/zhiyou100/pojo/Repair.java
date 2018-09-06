package com.zhiyou100.pojo;

import java.sql.Date;

public class Repair {
	private Integer reId;
	private Integer rMessage;
	private Integer rPrincipal;
	private String rExplain;
	private Date rTime;
	private String rResult;
	private String rRemark;
	public Integer getReId() {
		return reId;
	}
	public void setReId(Integer reId) {
		this.reId = reId;
	}
	
	public Integer getrMessage() {
		return rMessage;
	}
	public void setrMessage(Integer rMessage) {
		this.rMessage = rMessage;
	}
	public Integer getrPrincipal() {
		return rPrincipal;
	}
	public void setrPrincipal(Integer rPrincipal) {
		this.rPrincipal = rPrincipal;
	}
	public String getrExplain() {
		return rExplain;
	}
	public void setrExplain(String rExplain) {
		this.rExplain = rExplain;
	}
	public Date getrTime() {
		return rTime;
	}
	public void setrTime(Date rTime) {
		this.rTime = rTime;
	}
	public String getrResult() {
		return rResult;
	}
	public void setrResult(String rResult) {
		this.rResult = rResult;
	}
	public String getrRemark() {
		return rRemark;
	}
	public void setrRemark(String rRemark) {
		this.rRemark = rRemark;
	}
	public Repair(Integer reId, Integer rMessage, Integer rPrincipal, String rExplain, Date rTime, String rResult,
			String rRemark) {
		super();
		this.reId = reId;
		this.rMessage = rMessage;
		this.rPrincipal = rPrincipal;
		this.rExplain = rExplain;
		this.rTime = rTime;
		this.rResult = rResult;
		this.rRemark = rRemark;
	}
	public Repair() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
