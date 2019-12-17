package com.guobank.liukongfu.dao.impl;

import com.guobank.liukongfu.dao.BaseDao;
import com.guobank.liukongfu.dao.IUserInfoDao;
import com.guobank.liukongfu.entity.UserInfo;

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
	
}
