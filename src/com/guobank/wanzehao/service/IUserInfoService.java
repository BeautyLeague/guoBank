package com.guobank.wanzehao.service;


import com.guobank.wanzehao.entity.UserInfo;

public interface IUserInfoService {

	public String is_Load(String uname, String pwd) throws Exception;
	
	public void addUserInfo(UserInfo uInfo) throws Exception;
	
	public String yzPho(String pho) throws Exception;
	
	public String getPwd(String pho) throws Exception;
	
	public UserInfo queryUserInfo(String load) throws Exception;
}
