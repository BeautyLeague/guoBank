package com.guobank.service.impl;

import com.guobank.dao.BankcardDao;
import com.guobank.dao.impl.BankcardDaoImpl;
import com.guobank.entity.Bankcard;
import com.guobank.service.BankcardService;

import java.sql.SQLException;

/**
* @Project: MyBank
* @Package com.guobank.service.impl
* @Descriptio
/**
* @Project: MyBank
* @Package com.guobank.service.impl
* @Description: TODO
* @author : pengliang
* @date Date : 2019年11月07日 9:13
* @version V1.0
*/


public class BankcardServiceImpl implements BankcardService {
    private BankcardDao bankcardDao = new BankcardDaoImpl();
    @Override
    public Bankcard getBankcardById(String bankCardId) throws Exception {
        return bankcardDao.getBankcardById(bankCardId);
    }


    @Override
    public Bankcard depositByObject(Bankcard bankcard) throws Exception {
        Bankcard newBankcard = bankcardDao.getBankcardById(bankcard.getBankCardid());
        if(!(newBankcard.getPass().equals(bankcard.getPass()))){
            throw new Exception("密码错误");
        }else{
            try {
                newBankcard.setMoney(newBankcard.getMoney()+bankcard.getMoney());
                bankcardDao.updateBankcardNyByObject(newBankcard);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new Exception("出现异常,请稍后再试");
            }
        }
        return newBankcard;
    }


    @Override
    public Bankcard tackMoney(Bankcard bankcard) throws Exception {
        Bankcard newBankcard = bankcardDao.getBankcardById(bankcard.getBankCardid());
        if(!(newBankcard.getPass().equals(bankcard.getPass()))){
            throw new Exception("密码错误");
        }else{
            try {
                if(newBankcard.getMoney() < bankcard.getMoney()){
                    throw new Exception("金额不足");
                }
                newBankcard.setMoney(newBankcard.getMoney()-bankcard.getMoney());
                updateByObject(newBankcard);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new Exception("出现异常,请稍后再试");
            }
        }
        return newBankcard;
    }

    private void updateByObject(Bankcard bankcard)throws SQLException{
        bankcardDao.updateBankcardNyByObject(bankcard);
    }

    @Override
    public Bankcard getBankcardByUserIdAndBankCardId(String bankCard, Integer userId) throws Exception {
        return bankcardDao.getBankcardByUserIdAndBankCardId(bankCard,userId);
    }
}
