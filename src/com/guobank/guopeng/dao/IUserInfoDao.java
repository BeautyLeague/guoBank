package com.guobank.guopeng.dao;


import com.guobank.guopeng.entity.UserInfo;

public interface IUserInfoDao {
	//用户查询
	public UserInfo SelcetUserInfo(String userName)throws Exception;
	//用户删除
	public void DeleteUserInfo(String userName)throws Exception ;
}
