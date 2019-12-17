package com.guobank.dao;


import com.guobank.entity.Bankcard;

public interface ItransferMoney {

    //转账
    public Boolean update(Bankcard bankCard) throws Exception;

    //添加
    public Boolean Add(String bankCardId,String card, Float transMoney, String transInfo) throws Exception;
}
