package com.guobank.guopeng.service.impl;


import com.guobank.guopeng.dao.impl.UserInfoDao;
import com.guobank.guopeng.entity.UserInfo;
import com.guobank.guopeng.service.IUserInfoService;

public class UserInfoService implements IUserInfoService {
	private UserInfoDao userInfoDao=new UserInfoDao();
	@Override
	public UserInfo SelcetUserInfo(String userName) throws Exception {
		return this.userInfoDao.SelcetUserInfo(userName);
	}

	@Override
	public void DeleteUserInfo(String userName) throws Exception {
		UserInfo selcetUserInfo = userInfoDao.SelcetUserInfo(userName);
		if(selcetUserInfo!=null&&selcetUserInfo.getUserName()!=null){
			this.userInfoDao.DeleteUserInfo(userName);
		}else{
			throw new Exception("没有该用户信息");
		}
	}

}
