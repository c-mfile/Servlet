package com.zhiyou100.pojo;

import java.sql.Date;

public class Contract {
	private Integer cId;
	private Integer hId;
	private Integer lId;
	private Date cDate;
	private Date cStartTime;
	private Date cEndTime;
	private Integer cAlquliter;
	private String cPay;
	private Integer cDeptsito;
	private Integer cPaynum;
	private String cName;
	private Integer cStatus;
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public Integer gethId() {
		return hId;
	}
	public void sethId(Integer hId) {
		this.hId = hId;
	}
	public Integer getlId() {
		return lId;
	}
	public void setlId(Integer lId) {
		this.lId = lId;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public Date getcStartTime() {
		return cStartTime;
	}
	public void setcStartTime(Date cStartTime) {
		this.cStartTime = cStartTime;
	}
	public Date getcEndTime() {
		return cEndTime;
	}
	public void setcEndTime(Date cEndTime) {
		this.cEndTime = cEndTime;
	}
	public Integer getcAlquliter() {
		return cAlquliter;
	}
	public void setcAlquliter(Integer cAlquliter) {
		this.cAlquliter = cAlquliter;
	}
	public String getcPay() {
		return cPay;
	}
	public void setcPay(String cPay) {
		this.cPay = cPay;
	}
	public Integer getcDeptsito() {
		return cDeptsito;
	}
	public void setcDeptsito(Integer cDeptsito) {
		this.cDeptsito = cDeptsito;
	}
	public Integer getcPaynum() {
		return cPaynum;
	}
	public void setcPaynum(Integer cPaynum) {
		this.cPaynum = cPaynum;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Integer getcStatus() {
		return cStatus;
	}
	public void setcStatus(Integer cStatus) {
		this.cStatus = cStatus;
	}
	public Contract(Integer cId, Integer hId, Integer lId, Date cDate, Date cStartTime, Date cEndTime,
			Integer cAlquliter, String cPay, Integer cDeptsito, Integer cPaynum, String cName, Integer cStatus) {
		super();
		this.cId = cId;
		this.hId = hId;
		this.lId = lId;
		this.cDate = cDate;
		this.cStartTime = cStartTime;
		this.cEndTime = cEndTime;
		this.cAlquliter = cAlquliter;
		this.cPay = cPay;
		this.cDeptsito = cDeptsito;
		this.cPaynum = cPaynum;
		this.cName = cName;
		this.cStatus = cStatus;
	}
	public Contract() {
	}
	
	
}
