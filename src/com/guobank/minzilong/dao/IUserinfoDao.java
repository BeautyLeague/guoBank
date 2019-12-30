package com.guobank.minzilong.dao;



import com.guobank.wanzehao.entity.UserInfo;

import java.util.List;

public interface IUserinfoDao {
  public List<UserInfo> queryUserinfo()throws Exception;
  public void addUserinfo(UserInfo userinfo)throws Exception;
  public UserInfo querUser(int userid)throws Exception;
  public void updepwd(UserInfo userInfo)throws Exception;
  public void updatePath(String path, Integer id) throws  Exception;
//  public String ispwd(String pwd,String userid) throws Exception;
}
