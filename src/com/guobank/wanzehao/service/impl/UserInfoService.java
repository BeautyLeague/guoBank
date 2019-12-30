package com.guobank.wanzehao.service.impl;


import com.guobank.wanzehao.dao.IUserInfoDao;
import com.guobank.wanzehao.dao.impl.UserInfoDao;
import com.guobank.wanzehao.entity.UserInfo;
import com.guobank.wanzehao.service.IUserInfoService;

import java.util.List;

public class UserInfoService implements IUserInfoService {

	private IUserInfoDao iUserInfoDao = new UserInfoDao();

	public String is_Load(String lond, String pwd) throws Exception {

		String uname = null;

		List<UserInfo> list = iUserInfoDao.queryUserInfos();
		
		for (UserInfo userInfo : list) {

			if (userInfo.getPwd().equals(pwd) && userInfo.getPho().equals(lond)
					|| userInfo.getPwd().equals(pwd)
					&& userInfo.getId().equals(lond)) {
				uname = userInfo.getUserName();
				break;
			}

		}

		if (uname == null) {
			for (UserInfo userInfo : list) {
				if (userInfo.getPho().equals(lond)
						|| userInfo.getId().equals(lond)) {
					throw new Exception("密码输入错误！！！");
				}
			}

			throw new Exception("账号输入错误！！！");
		}

		return uname;
	}

	@Override
	public void addUserInfo(UserInfo uInfo) throws Exception {
		
		iUserInfoDao.addUserInfo(uInfo);
	}

	@Override
	public String yzPho(String pho) throws Exception {
		List<UserInfo> list = iUserInfoDao.queryUserInfos();
		String result="成功";
		
		for (UserInfo userInfo : list) {
			if(userInfo.getPho().equals(pho))
			{
				result="失败";
			}
		}
		
		return result;
	}

	@Override
	
	public String getPwd(String pho) throws Exception {
		String pwd="";
		List<UserInfo> list = iUserInfoDao.queryUserInfos();
		
		for (UserInfo userInfo : list) {
			if(userInfo.getPho().equals(pho))
			{
				pwd=userInfo.getPwd();
				break;
			}
		}
		
		
		return pwd;
	}

	@Override
	public UserInfo queryUserInfo(String load) throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo= iUserInfoDao.queryUserInfo(load);
		return userInfo;
	}

}
