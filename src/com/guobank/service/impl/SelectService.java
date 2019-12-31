package com.guobank.service.impl;


import com.guobank.dao.impl.SelectDao;
import com.guobank.entity.Bankcard;
import com.guobank.entity.User;
import com.guobank.service.ISelectService;

public class SelectService implements ISelectService {
    Bankcard bankCard=new Bankcard();
    SelectDao selectDao=new SelectDao();

    @Override
    public Bankcard SelectPrice(String bankId,double money,Integer userId) throws Exception {
        Bankcard shouCard = selectDao.SelectBankID(bankId,userId);

        return selectDao.SelectPrice(bankId,money, userId);
    }

    @Override
    public User SelectName(String bankId) throws Exception {
        return selectDao.SelectName(bankId);
    }

    @Override
    public Bankcard SelectBankID(String bankId,Integer userId) throws Exception {
        return selectDao.SelectBankID(bankId,userId);
    }

    @Override
    public Bankcard SelectBankIDs(String bankId) throws Exception {
        return selectDao.SelectBankIDs(bankId);
    }

}
