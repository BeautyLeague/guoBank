package com.guobank.minzilong.dao.impl;

import com.guobank.dao.BaseDao;
import com.guobank.minzilong.dao.IUserinfoDao;
import com.guobank.wanzehao.entity.UserInfo;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class userinfoDao extends BaseDao implements IUserinfoDao {
  
	
	@Override
	public List<UserInfo> queryUserinfo()throws Exception {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM userinfo  ";
		ResultSet rst=super.executeQuery(sql, new Object[] {});
		List<UserInfo> userlist=new ArrayList<UserInfo>();
		while (rst.next()) {
		   UserInfo userinfo2=new UserInfo();
			userinfo2.setUserId(rst.getInt("userId"));
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
	public void addUserinfo(UserInfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		String sql="UPDATE userinfo SET userName=?,sex=?,age=?,leven=?,pho=?,bornDate=? WHERE pho=?";
		
		super.executeUpdate(sql, new Object[] {userinfo.getUserName()
				                               ,userinfo.getSex()
				                               ,userinfo.getAge()
				                               ,userinfo.getLeven()
				                               ,userinfo.getPho()
				                               ,userinfo.getBornDate()
				                               ,userinfo.getPho()});
	}

	@Override
	public UserInfo querUser(int userid) throws Exception {
		String sql="SELECT * FROM userinfo where userId=?";
		ResultSet rst=super.executeQuery(sql, new Object[] {userid});
		UserInfo  userinfo2=new UserInfo();
		while (rst.next()) {
			userinfo2.setUserName(rst.getString("userName"));
			userinfo2.setSex(rst.getString("sex"));
			userinfo2.setAge(rst.getInt("age"));
			userinfo2.setLeven(rst.getInt("leven"));
			userinfo2.setPho(rst.getString("pho"));
			userinfo2.setId(rst.getString("id"));
			userinfo2.setBornDate(rst.getDate("bornDate"));
			userinfo2.setUserId(rst.getInt("userId"));
			userinfo2.setPwd(rst.getString("pwd"));
		}
		return userinfo2;
	}

	@Override
	public void updepwd(UserInfo userInfo) throws Exception {
		 String sql="UPDATE userinfo SET pwd=? WHERE pho=? ";
		 super.executeUpdate(sql,new Object[]{
		 		          userInfo.getPwd(),
				          userInfo.getPho()
		 });
	}

	@Override
	public void updatePath(String path,Integer id) throws Exception {
		String sql="update userinfo set path=? where userid=?";
		super.executeUpdate(sql,new Object[]{path,id});
	}


//	@Override
//	public String ispwd(String pwd, String userid) throws Exception {
//		return null;
//	}


}
