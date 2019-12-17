package com.guobank.minzilong.entity;

import java.io.Serializable;
import java.util.Date;

public class Userinfo implements Serializable{
	private int userId;
	private String userName;
	private String sex;
	private  Integer age;
	private Integer leven;
	private String pho;
	private String id;
	private Date bornDate;
	
	public int getuserId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId = userId;
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
