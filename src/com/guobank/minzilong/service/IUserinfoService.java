package com.guobank.minzilong.service;


import com.guobank.minzilong.entity.Userinfo;

import java.util.List;

public interface IUserinfoService {
	public List<Userinfo> queryUserinfolisList() throws Exception;
  
	 public void addUserinfoService(Userinfo userinfo)throws Exception;
}
