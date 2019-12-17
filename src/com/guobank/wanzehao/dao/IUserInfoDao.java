package com.guobank.wanzehao.dao;


import com.guobank.wanzehao.entity.UserInfo;

import java.util.List;

public interface IUserInfoDao {

	public List<UserInfo> queryUserInfos() throws Exception;
	
	public void addUserInfo(UserInfo uInfo) throws Exception;
	
	public UserInfo queryUserInfo(String load) throws Exception;
}
