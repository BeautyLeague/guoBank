package com.guobank.minzilong.service;




import com.guobank.wanzehao.entity.UserInfo;

import java.util.List;

public interface IUserinfoService {
	public List<UserInfo> queryUserinfolisList() throws Exception;
  
	public void addUserinfoService(UserInfo userinfo)throws Exception;

	public UserInfo querUser(int userid) throws Exception;

	public void updepwd(UserInfo userInfo) throws Exception;

}
