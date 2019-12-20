package com.guobank.dao.impl;

import com.guobank.dao.BaseDao;
import com.guobank.dao.IBackstageDao;
import com.guobank.entity.Bankcard;
import com.guobank.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BackstageDao extends BaseDao implements IBackstageDao {
    @Override
    public List<User> query() throws SQLException {
        String sql="select userinfo.userid, userinfo.username ,userinfo.sex,bankcard.bankcardid,bankcard.money,bankcard.address,userinfo.age,userinfo.bornDate from userinfo inner join bankcard on userinfo.userid=bankcard.userid ORDER BY userinfo.userId";
        ResultSet rs=super.query(sql,null);
        List<User> users=new ArrayList<User>();
        Integer userId = null;

        while (rs.next()){
            if(userId!=null  &&  userId.equals(rs.getInt("userid"))){
                Bankcard bankcard = new Bankcard();
                bankcard.setBankCardid(rs.getString("bankcardid"));
                bankcard.setAddress(rs.getString("address"));
                users.get(users.size()-1).getBankcard().add(bankcard);
            }else {
                User user=new User();
                Bankcard bankcard = new Bankcard();
                bankcard.setBankCardid(rs.getString("bankcardid"));
                bankcard.setAddress(rs.getString("address"));
                userId = rs.getInt("userid");
                user.setId(rs.getInt("userid"));
                user.setBankcard(new ArrayList<Bankcard>(){{add(bankcard);}});
                users.add(user);
            }
        }
        return users;
    }
}
