package com.guobank.entity;

import java.util.Date;
import java.util.List;

/**
 * @描述:
 * @author: 杨昆
 * @CreateTime: 2019/11/4 10:41
 */
public class User {
    private String userName;            //用户姓名
    private String userID;              //用户Id
    private Integer pwd;              //密码
    private String sex;              //性别
    private  Integer age;              //年龄
    private  Integer leven;              //等级
    private  Integer pho     ;         //电话
    private  Integer id     ;         //身份证号
    private Date date  ;         //出生日期

    public List<Bankcard> getBankcard() {
        return bankcard;
    }

    public void setBankcard(List<Bankcard> bankcard) {
        this.bankcard = bankcard;
    }

    private List<Bankcard> bankcard;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Integer getPwd() {
        return pwd;
    }

    public void setPwd(Integer pwd) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
