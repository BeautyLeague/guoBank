package com.guobank.dao.impl;



import com.guobank.dao.BaseDao;
import com.guobank.dao.ISelectDao;
import com.guobank.entity.Bankcard;
import com.guobank.entity.User;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class SelectDao extends BaseDao implements ISelectDao {

    //查询余额方法
    @Override
    public Bankcard SelectPrice(String bankId, double money) throws Exception {
        String sql = "select money from bankCard where bankCardId=? ";
        ResultSet rs = super.executeQuery(sql, new Object[]{bankId});
        List<Bankcard> list = new ArrayList<Bankcard>();
        Bankcard bankCard = new Bankcard();
        while (rs.next()) {
            bankCard.setMoney(rs.getFloat("money"));
            list.add(bankCard);
        }
        return bankCard;
    }

    //查找姓名
    @Override
    public User SelectName(String bankId) throws Exception {
        String sql="SELECT username FROM userinfo where userId=(SELECT userId FROM bankcard WHERE bankcardid=?)";
        ResultSet rs=super.executeQuery(sql,new Object[]{bankId});
        List<User> list=new ArrayList<User>();
        User user=new User();

        while (rs.next()){
            user.setUserName(rs.getString("username"));
            list.add(user);
        }
        System.out.println(user);
        return user;
    }

    @Override
    public Bankcard SelectBankID(String bankId) throws Exception {
        String sql = "select * from bankCard where bankCardid = ?";
        ResultSet rs = super.executeQuery(sql,new Object[]{bankId});
        Bankcard bankCard = null;
        if (rs.next()) {
            bankCard  = new Bankcard();
            bankCard.setBankCardid(rs.getString("bankCardid"));
            bankCard.setMoney(rs.getFloat("money"));
            bankCard.setAddress(rs.getString("address"));
            bankCard.setCardTypeid(rs.getInt("cardtypeid"));
            bankCard.setDate(rs.getDate("date"));
            bankCard.setIs_Ds(rs.getInt("is_ds"));
            bankCard.setPass(rs.getInt("pass"));
            bankCard.setUserid(rs.getInt("userid"));
        }
        return bankCard;
    }

}
