package com.guobank.minzilong.dao;



import com.guobank.wanzehao.entity.UserInfo;

import java.util.List;

public interface IUserinfoDao {
  //查询用户信息
  public List<UserInfo> queryUserinfo()throws Exception;

  //修改用户信息
  public void addUserinfo(UserInfo userinfo)throws Exception;

  //使用id查询用户信息
  public UserInfo querUser(int userid)throws Exception;

  //使用电话号码修改密码
  public void updepwd(UserInfo userInfo)throws Exception;

  //使用id修改电话号码
  public void updatePath(String path, Integer id) throws  Exception;

}
