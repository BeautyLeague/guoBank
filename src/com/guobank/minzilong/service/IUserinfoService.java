package com.guobank.minzilong.service;




import com.guobank.wanzehao.entity.UserInfo;

import java.util.List;

public interface IUserinfoService {
	//查询用户信息
	public List<UserInfo> queryUserinfolisList() throws Exception;

	//修改用户信息
	public void addUserinfoService(UserInfo userinfo)throws Exception;

	//使用id查询用户信息
	public UserInfo querUser(int userid) throws Exception;

	//使用电话号码修改密码
	public void updepwd(UserInfo userInfo) throws Exception;

}
