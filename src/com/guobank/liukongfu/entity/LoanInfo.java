package com.guobank.liukongfu.entity;

import java.util.Date;

public class LoanInfo {

	//������ϢId
	private Integer loanId;
	//�û�Id
	private Integer userId;
	//������
	private double loanMoney;
	//��������
	private Date loanDate;
	//������ʱ��
	private int backDate;
	//���ں�Ӧ������
	private double lMoney;
	//ʵ�ʻ�����
	private double allMoney;
	//������
	private double rate;
	//�Ƿ񻹿�
	private Integer is_loan;
	//��������
	private Date thisDate;
	//�������п�
	private String cards;
	public String getCards() {
		return cards;
	}
	public void setCards(String cards) {
		this.cards = cards;
	}
	public Integer getIs_loan() {
		return is_loan;
	}
	public void setIs_loan(Integer is_loan) {
		this.is_loan = is_loan;
	}
	public Date getThisDate() {
		return thisDate;
	}
	public void setThisDate(Date thisDate) {
		this.thisDate = thisDate;
	}
	
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public double getLoanMoney() {
		return loanMoney;
	}
	public void setLoanMoney(double loanMoney) {
		this.loanMoney = loanMoney;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public int getBackDate() {
		return backDate;
	}
	public void setBackDate(int backDate) {
		this.backDate = backDate;
	}
	public double getlMoney() {
		return lMoney;
	}
	public void setlMoney(double lMoney) {
		this.lMoney = lMoney;
	}
	public double getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(double allMoney) {
		this.allMoney = allMoney;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
}
