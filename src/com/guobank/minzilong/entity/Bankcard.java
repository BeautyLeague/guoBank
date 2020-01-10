package com.guobank.minzilong.entity;

import java.util.Date;

public class Bankcard {
    public String bankCardId;//卡号
    public int cardTypeId; //卡号类型
    public int is_ds; //是否挂失
    public String address;//地址
    public Date date;//日期
    public int userId;//用户id

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

}
