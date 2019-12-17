package com.guobank.liukongfu.entity;

import java.util.Date;

public class BankCard {

	//���п���
	private String bankCardId;
	//���п�����id
	private Integer cardTypeId;
	//�û�id
	private Integer userId;
	//�������
	private double Money;
	//֧������
	private String pass;
	//�Ƿ��ʧ
	private Integer is_ds;
	//������ַ
	private String address;
	//����ʱ��
	private Date date;
	public String getBankCardId() {
		return bankCardId;
	}
	public void setBankCardId(String bankCardId) {
		this.bankCardId = bankCardId;
	}
	public Integer getCardTypeId() {
		return cardTypeId;
	}
	public void setCardTypeId(Integer cardTypeId) {
		this.cardTypeId = cardTypeId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public double getMoney() {
		return Money;
	}
	public void setMoney(double money) {
		Money = money;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Integer getIs_ds() {
		return is_ds;
	}
	public void setIs_ds(Integer is_ds) {
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
