package com.guobank.dao.impl;

import com.guobank.dao.BankcardDao;
import com.guobank.dao.BaseDao;
import com.guobank.entity.Bankcard;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: MyBank
 * @Package com.guobank.dao.impl
 * @Descriptio /**
 * @Project: MyBank
 * @Package com.guobank.dao.impl
 * @Description: TODO
 * @date Date : 2019年11月08日 14:27
 */
public class BankcardDaoImpl extends BaseDao implements BankcardDao {
    @Override
    public Bankcard getBankcardById(String bankCardId) throws Exception {
        String sql = "select * from bankcard where bankCardId = ?";
        ResultSet rs = super.query(sql,new Object[]{bankCardId});
        Bankcard bankcard = null;
        if(rs.next()){
            bankcard = new Bankcard();
            for (Field field : Bankcard.class.getDeclaredFields()){
                field.setAccessible(true);
                field.set(bankcard,rs.getObject(field.getName()));
            }
        }
        return bankcard;
    }

    @Override
    public boolean updateBankcardNyByObject(Bankcard bankcard) throws SQLException {
        String sql = "update bankcard set cardTypeId = ? , userId = ? , Money = ?, pass = ? , is_ds = ? , address = ? , Date = ? where bankCardId = ?";
        return super.execute(sql,new Object[]{bankcard.getCardTypeid(),bankcard.getUserid()
                ,bankcard.getMoney(),bankcard.getPass(),bankcard.getIs_Ds(),
                bankcard.getAddress(),bankcard.getDate(),bankcard.getBankCardid()});

    }


    @Override
    public Bankcard getBankcardByUserIdAndBankCardId(String bankCard, Integer userId) throws Exception{
        String sql = "select * from bankcard where bankCardId = ? and userid = ?";
        ResultSet rs = super.query(sql,new Object[]{bankCard,userId});
        Bankcard bankcard = null;
        if(rs.next()){
            bankcard = new Bankcard();
            for (Field field : Bankcard.class.getDeclaredFields()){
                field.setAccessible(true);
                field.set(bankcard,rs.getObject(field.getName()));
            }
        }
        return bankcard;
    }
}
