package com.guobank.guopeng.dao.impl;

import com.guobank.dao.BaseDao;
import com.guobank.guopeng.dao.IUserInfoDao;
import com.guobank.guopeng.entity.UserInfo;

import java.sql.ResultSet;



public class UserInfoDao extends BaseDao implements IUserInfoDao {

	@Override
	public UserInfo SelcetUserInfo(String userName) throws Exception {
		String sql="select * from userinfo where userName=?";
		ResultSet rs = super.query(sql,new Object[]{userName});
		UserInfo userInfo=new UserInfo();
		while (rs.next()) {
			userInfo.setAge(rs.getInt("age"));
			userInfo.setBornDate(rs.getDate("bornDate"));
			userInfo.setId(rs.getString("id"));
			userInfo.setLeven(rs.getInt("leven"));
			userInfo.setPwd(rs.getString("pwd"));
			userInfo.setSex(rs.getString("sex"));
			userInfo.setUserId(rs.getInt("userId"));
			userInfo.setUserName(rs.getString("userName"));
		}
		return userInfo;
	}

	@Override
	public void DeleteUserInfo(String userName) throws Exception {
		String sql="DELETE FROM userinfo WHERE userName=?";
		super.executeUpdate(sql,new Object[]{userName});
	}

	public  UserInfo userById(int userId)throws Exception {
		String sql="select * from userinfo where userId=?";
		ResultSet rs = super.query(sql,new Object[]{userId});
		UserInfo userInfo=new UserInfo();
		while (rs.next()) {
			userInfo.setAge(rs.getInt("age"));
			userInfo.setBornDate(rs.getDate("bornDate"));
			userInfo.setId(rs.getString("id"));
			userInfo.setLeven(rs.getInt("leven"));
			userInfo.setPwd(rs.getString("pwd"));
			userInfo.setSex(rs.getString("sex"));
			userInfo.setUserId(rs.getInt("userId"));
			userInfo.setUserName(rs.getString("userName"));
			userInfo.setPho(rs.getString("pho"));
		}
		return userInfo;
	}
}
