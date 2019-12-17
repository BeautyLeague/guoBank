package com.guobank.minzilong.service.impl;


import com.guobank.minzilong.dao.IUserinfoDao;
import com.guobank.minzilong.dao.impl.userinfoDao;
import com.guobank.minzilong.entity.Userinfo;
import com.guobank.minzilong.service.IUserinfoService;

import java.util.List;

public class UserinfoServlce implements IUserinfoService {
   private IUserinfoDao iUserinfoDao=new userinfoDao();

@Override
public List<Userinfo> queryUserinfolisList() throws Exception {
	// TODO Auto-generated method stub
	return this.iUserinfoDao.queryUserinfo();
	
}

@Override
public void addUserinfoService(Userinfo userinfo) throws Exception {
	// TODO Auto-generated method stub
	 this.iUserinfoDao.addUserinfo(userinfo);
}

}
