package com.guobank.minzilong.dao;


import com.guobank.minzilong.entity.Userinfo;

import java.util.List;

public interface IUserinfoDao {
  public List<Userinfo> queryUserinfo()throws Exception;
  
  public void addUserinfo(Userinfo userinfo)throws Exception;
  
}
