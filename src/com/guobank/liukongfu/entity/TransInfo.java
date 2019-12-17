package com.guobank.liukongfu.entity;

import java.util.Date;

public class TransInfo {

	//������ϢId
	private Integer trandsId;
	//��������
	private Integer typeId;
	//�������п���
	private String bankCardId;
	//����ʱ��
	private Date trandsDate;
	//���׽��
	private double trandsMoney;
	//���ױ�ע
	private String trandsInfos;
	public Integer getTrandsId() {
		return trandsId;
	}
	public void setTrandsId(Integer trandsId) {
		this.trandsId = trandsId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getBankCardId() {
		return bankCardId;
	}
	public void setBankCardId(String bankCardId) {
		this.bankCardId = bankCardId;
	}
	public Date getTrandsDate() {
		return trandsDate;
	}
	public void setTrandsDate(Date trandsDate) {
		this.trandsDate = trandsDate;
	}
	public double getTrandsMoney() {
		return trandsMoney;
	}
	public void setTrandsMoney(double trandsMoney) {
		this.trandsMoney = trandsMoney;
	}
	public String getTrandsInfos() {
		return trandsInfos;
	}
	public void setTrandsInfos(String trandsInfos) {
		this.trandsInfos = trandsInfos;
	}
}
