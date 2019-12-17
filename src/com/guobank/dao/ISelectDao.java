package com.guobank.dao;



import com.guobank.entity.Bankcard;
import com.guobank.entity.User;

import javax.jws.soap.SOAPBinding;

public interface ISelectDao {
    //查询余额
    public Bankcard SelectPrice(String bankId, double money) throws Exception ;

    //查询姓名
    public User SelectName(String bankId) throws  Exception;

    //查询银行卡是否存在
    public Bankcard SelectBankID(String bankId) throws Exception ;

}
