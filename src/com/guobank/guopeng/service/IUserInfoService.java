package com.guobank.guopeng.service;


import com.guobank.guopeng.entity.UserInfo;

public interface IUserInfoService {
		//用户查询
		public UserInfo SelcetUserInfo(String userName)throws Exception;
		//用户删除
		public void DeleteUserInfo(String userName)throws Exception ;

		public  UserInfo userById(int userId)throws Exception;
}
