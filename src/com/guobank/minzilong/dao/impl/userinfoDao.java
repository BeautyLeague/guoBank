package com.guobank.minzilong.dao.impl;

import com.guobank.minzilong.dao.BaseDao;
import com.guobank.minzilong.dao.IUserinfoDao;
import com.guobank.minzilong.entity.Userinfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class userinfoDao extends BaseDao implements IUserinfoDao {
  
	
	@Override
	public List<Userinfo> queryUserinfo()throws Exception {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM userinfo  ";
		ResultSet rst=super.executeQuery(sql, new Object[] {});
		List<Userinfo> userlist=new ArrayList<Userinfo>();
		while (rst.next()) {
		   Userinfo  userinfo2=new Userinfo();
			userinfo2.setUserName(rst.getString("userName"));
			userinfo2.setSex(rst.getString("sex"));
			userinfo2.setAge(rst.getInt("age"));
			userinfo2.setLeven(rst.getInt("leven"));
			userinfo2.setPho(rst.getString("pho"));
			userinfo2.setId(rst.getString("id"));
			userinfo2.setBornDate(rst.getDate("bornDate"));
			userlist.add(userinfo2);
		}
		return userlist;
	}

	@Override
	public void addUserinfo(Userinfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		String sql="UPDATE userinfo SET userName=?,sex=?,age=?,leven=?,pho=?,id=?,bornDate=? WHERE pho=?";
		
		super.executeUpdate(sql, new Object[] {userinfo.getUserName()
				                               ,userinfo.getSex()
				                               ,userinfo.getAge()
				                               ,userinfo.getLeven()
				                               ,userinfo.getPho()
				                               ,userinfo.getId()
				                               ,userinfo.getBornDate()
				                               ,userinfo.getPho()});
	}
}
