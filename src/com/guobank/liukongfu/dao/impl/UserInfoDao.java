package com.guobank.liukongfu.dao.impl;

import com.guobank.dao.BaseDao;
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

	@Override
	public void updateLeven(Integer id) throws Exception {
		String sql="update userinfo set leven=leven+1 where userid=?";

		super.executeUpdate(sql,new  Object[]{id});
	}

	@Override
	public int querygs(String cardId) throws Exception {
		Integer gs=0;
		String sql = "select * from bankcard where bankCardId=?";

		ResultSet rs = super.executeQuery(sql, new Object[] { cardId });

		while (rs.next()) {

			gs = rs.getInt("is_ds");
		}

		return gs;
	}

}
