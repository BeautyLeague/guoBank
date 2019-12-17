package com.guobank.liukongfu.entity;

import java.util.Date;

public class UserInfo {

	//�û�Id
	private Integer userId;
	//�û�����
	private String pwd;
	//�û�����
	private String userName;
	//�û��Ա�
	private String sex;
	//�û�����
	private Integer age;
	//�û��ȼ�
	private Integer leven;
	//�û��绰����
	private String pho;
	//�û����֤��
	private String id;
	//�û���������
	private Date bornDate;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
		
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getLeven() {
		return leven;
	}
	public void setLeven(Integer leven) {
		this.leven = leven;
	}
	public String getPho() {
		return pho;
	}
	public void setPho(String pho) {
		this.pho = pho;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	
}
