package com.guobank.wanzehao.dao.impl;

import com.guobank.dao.BaseDao;
import com.guobank.wanzehao.dao.IUserInfoDao;
import com.guobank.wanzehao.entity.UserInfo;
import sun.java2d.Surface;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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
			userInfo.setPath(rs.getString("path"));
			userInfos.add(userInfo);
			
		}
		return userInfos;

	}

	@Override
	public void addUserInfo(UserInfo uInfo) throws Exception {
		
        String sql="insert into userinfo(userId,bornDate,age,sex,userName,leven,pwd,pho,Id,path) values(null,?,?,?,?,?,?,?,?,?)";
		
		super.executeUpdate(sql, new Object[]{new Date(),0,"男",uInfo.getUserName(),uInfo.getLeven(),uInfo.getPwd(),uInfo.getPho(),uInfo.getId(),"../tximg/three.png"});
		
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
			userInfo.setPath(rs.getString("path"));
		}
		
		return userInfo;
	}

	@Override
	public void updatePass(String userId) throws Exception {
		String sql="update userInfo set pwd='123456' where pho=?";
		super.executeUpdate(sql,new Object[]{userId});
	}

	@Override
	public void addRecord() throws Exception {
		String sql="insert into record value(null,1,?)";
		super.executeUpdate(sql,new Object[]{new Date()});
	}


}
