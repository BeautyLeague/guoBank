package com.guobank.guopeng.entity;

import java.util.Date;

//用户信息实体类
public class UserInfo {
	private Integer userId; //用户id
	private String pwd; //用户密码
	private String sex;	//性别
	private Integer age;	//年龄
	private Integer leven;	//信用等级
	private Integer pho;	//电话
	private String id;	//身份证号
	private Date bornDate;	//用户注册时间
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	public Integer getPho() {
		return pho;
	}
	public void setPho(Integer pho) {
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
