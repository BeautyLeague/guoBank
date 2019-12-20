package com.guobank.service.impl;


import com.guobank.dao.impl.SelectDao;
import com.guobank.entity.Bankcard;
import com.guobank.entity.User;
import com.guobank.service.ISelectService;

public class SelectService implements ISelectService {
    Bankcard bankCard=new Bankcard();
    SelectDao selectDao=new SelectDao();

    @Override
    public Bankcard SelectPrice(String bankId,double money) throws Exception {
        Bankcard shouCard = selectDao.SelectBankID(bankId);

        return selectDao.SelectPrice(bankId,money);
    }

    @Override
    public User SelectName(String bankId) throws Exception {
        return selectDao.SelectName(bankId);
    }

    @Override
    public Bankcard SelectBankID(String bankId) throws Exception {
        return selectDao.SelectBankID(bankId);
    }

}
