package com.guobank.minzilong.dao.impl;


import com.guobank.dao.BaseDao;
import com.guobank.minzilong.dao.IBankcardDao;
import com.guobank.minzilong.entity.Bankcard;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankcardDao extends BaseDao implements IBankcardDao {
    @Override
    public List<Bankcard> queryBanklist(int userId) throws Exception {
        String sql="SELECT * FROM bankcard where userId=?";
        ResultSet rst=super.executeQuery(sql,new Object[]{userId});
        List<Bankcard> banklist=new ArrayList<Bankcard>();
        while(rst.next()){
            Bankcard bankcard=new Bankcard();
            bankcard.setUserId(rst.getInt("userId"));
            bankcard.setBankCardId(rst.getString("bankCardId"));
            bankcard.setCardTypeId(rst.getInt("cardTypeId"));
            bankcard.setIs_ds(rst.getInt("is_ds"));
            bankcard.setAddress(rst.getString("address"));
            bankcard.setDate(rst.getDate("date"));
            banklist.add(bankcard);
        }
        return banklist;
    }

//    @Override
//    public Bankcard queryBank(int userId) throws Exception {
//        String sql="SELECT * FROM bankcard where userId=？";
//        ResultSet rst=super.executeQuery(sql,new Object[]{userId});
//        List<Bankcard> banklist1=new ArrayList<Bankcard>();
//        while(rst.next()){
//            Bankcard bankcard=new Bankcard();
//            bankcard.setBankCardId(rst.getString("bankCardId"));
//            bankcard.setCardTypeId(rst.getInt("cardTypeId"));
//            bankcard.setIs_ds(rst.getInt("is_ds"));
//            bankcard.setAddress(rst.getString("address"));
//            bankcard.setDate(rst.getDate("date"));
//            banklist1.add(bankcard);
//        }
//        return banklist1;
//    }

}
