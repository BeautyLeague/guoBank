package com.guobank.wanzehao.dao.impl;

import com.guobank.dao.BaseDao;
import com.guobank.wanzehao.dao.IUserInfoDao;
import com.guobank.wanzehao.entity.UserInfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserInfoDao extends BaseDao implements IUserInfoDao {

	@Override
	public List<UserInfo> queryUserInfos() throws Exception {
		String sql="select * from userinfo";
		
		ResultSet rs = super.executeQuery(sql, null);
		
		List<UserInfo> userInfos=new ArrayList<UserInfo>();
		
		while (rs.next()) {
			
			UserInfo userInfo=new UserInfo();
			
			userInfo.setUserId(rs.getInt("userId"));
			userInfo.setAge(rs.getInt("age"));
			userInfo.setBornDate(rs.getDate("bornDate"));
			userInfo.setId(rs.getString("id"));
			userInfo.setLeven(rs.getInt("leven"));
			userInfo.setPho(rs.getString("pho"));
			userInfo.setPwd(rs.getString("pwd"));
			userInfo.setUserName(rs.getString("userName"));
			userInfo.setSex(rs.getString("sex"));
			
			userInfos.add(userInfo);
			
		}
		return userInfos;

	}

	@Override
	public void addUserInfo(UserInfo uInfo) throws Exception {
		
        String sql="insert into userinfo(userId,userName,pwd,pho) values(null,?,?,?)";
		
		super.executeUpdate(sql, new Object[]{uInfo.getUserName(),uInfo.getPwd(),uInfo.getPho()});
		
	}

	@Override
	public UserInfo queryUserInfo(String load) throws Exception {
		
		String sql="select * from userinfo where 1=1 ";
		
		if(load.length()==11){
			
			sql=sql+" and pho=? ";
		}else {
			sql=sql+" and id=? ";
		}
		
		ResultSet rs=super.executeQuery(sql, new Object[]{load});
		UserInfo userInfo=new UserInfo();
		if(rs.next())
		{
			
			userInfo.setUserId(rs.getInt("userId"));
			userInfo.setAge(rs.getInt("age"));
			userInfo.setBornDate(rs.getDate("bornDate"));
			userInfo.setId(rs.getString("id"));
			userInfo.setLeven(rs.getInt("leven"));
			userInfo.setPho(rs.getString("pho"));
			userInfo.setPwd(rs.getString("pwd"));
			userInfo.setUserName(rs.getString("userName"));
			userInfo.setSex(rs.getString("sex"));
		}
		
		return userInfo;
	}

	
}
