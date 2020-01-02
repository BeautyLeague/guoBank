package com.guobank.wanzehao.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {

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

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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


	@Override
	public String toString() {
		return "UserInfo{" +
				"userId=" + userId +
				", pwd='" + pwd + '\'' +
				", userName='" + userName + '\'' +
				", sex='" + sex + '\'' +
				", age=" + age +
				", leven=" + leven +
				", pho='" + pho + '\'' +
				", id='" + id + '\'' +
				", bornDate=" + bornDate +
				'}';
	}
}
