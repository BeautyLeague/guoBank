package com.guobank.entity;

import java.util.Date;


/**
* @Project: MyBank
* @Package com.domain
* @Descriptio
/**
* @Project: MyBank
* @Package com.domain
* @Description: TODO
* @author : pengliang
* @date Date : 2019年11月07日 9:13
* @version V1.0
*/

public class Bankcard {
    private String bankCardid;

    private Integer cardTypeid;

    private Integer userid;

    private Float money;

    private Integer pass;

    private Integer is_Ds;

    private String address;

    private Date date;

    public String getBankCardid() {
        return bankCardid;
    }

    public void setBankCardid(String bankCardid) {
        this.bankCardid = bankCardid;
    }

    public Integer getCardTypeid() {
        return cardTypeid;
    }

    public void setCardTypeid(Integer cardTypeid) {
        this.cardTypeid = cardTypeid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getIs_Ds() {
        return is_Ds;
    }

    public void setIs_Ds(Integer is_Ds) {
        this.is_Ds = is_Ds;
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

    @Override
    public String toString() {
        return "Bankcard{" +
                "bankCardid='" + bankCardid + '\'' +
                ", cardTypeid=" + cardTypeid +
                ", userid=" + userid +
                ", money=" + money +
                ", pass=" + pass +
                ", is_Ds=" + is_Ds +
                ", address='" + address + '\'' +
                ", date=" + date +
                '}';
    }
}