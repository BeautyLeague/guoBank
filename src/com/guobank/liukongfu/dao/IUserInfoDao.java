package com.guobank.liukongfu.dao;


import com.guobank.liukongfu.entity.UserInfo;

import java.util.List;

public interface IUserInfoDao {

	
	public List<UserInfo> queryUserInfos() throws Exception;
}
