package com.guobank.guopeng.entity;

import java.util.Date;

//银行开户实体类
public class OpenAccount {
	private String bankCardId;//银行卡号
	private  int cardTypeId;//卡类型
	private  int userid;//用户
	private double monery;//开户金额
	private int password;//支付密码
	private int is_ds;//是否挂失
	private String address;//开户地址
	private Date date;//开户时间
	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getBankCardId() {
		return bankCardId;
	}
	public void setBankCardId(String bankCardId) {
		this.bankCardId = bankCardId;
	}
	public int getCardTypeId() {
		return cardTypeId;
	}
	public void setCardTypeId(int cardTypeId) {
		this.cardTypeId = cardTypeId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public double getMonery() {
		return monery;
	}
	public void setMonery(double monery) {
		this.monery = monery;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getIs_ds() {
		return is_ds;
	}
	public void setIs_ds(int is_ds) {
		this.is_ds = is_ds;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
