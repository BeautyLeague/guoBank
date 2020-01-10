package com.guobank.minzilong.service.impl;


import com.guobank.minzilong.dao.IUserinfoDao;
import com.guobank.minzilong.dao.impl.userinfoDao;
import com.guobank.minzilong.service.IUserinfoService;
import com.guobank.wanzehao.entity.UserInfo;

import java.util.List;

public class UserinfoServlce implements IUserinfoService {
   private IUserinfoDao iUserinfoDao=new userinfoDao();
   //查询用户信息
	@Override
	public List<UserInfo> queryUserinfolisList() throws Exception {
		// TODO Auto-generated method stub
		return this.iUserinfoDao.queryUserinfo();

	}

	//修改用户信息
	@Override
	public void addUserinfoService(UserInfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		 this.iUserinfoDao.addUserinfo(userinfo);
	}

	//使用id查询用户信息
	@Override
	public UserInfo querUser(int userid) throws Exception {
		return this.iUserinfoDao.querUser(userid);
	}

	//使用电话号码修改密码
	@Override
	public void updepwd(UserInfo userInfo) throws Exception {
		this.iUserinfoDao.updepwd(userInfo);
	}

}
