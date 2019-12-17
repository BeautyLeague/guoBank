package com.guobank.service;


import com.guobank.entity.Bankcard;
import com.guobank.entity.User;

public interface ISelectService {
    //查询余额
    public Bankcard SelectPrice(String bankId, double money) throws Exception ;

    //查询姓名
    public User SelectName(String bankId) throws Exception ;

    //查询银行卡
    public Bankcard SelectBankID(String bankId) throws Exception ;


}
