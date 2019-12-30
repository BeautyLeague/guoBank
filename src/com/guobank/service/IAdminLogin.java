package com.guobank.service;

import com.guobank.entity.AdminInfo;

import java.sql.SQLException;
import java.util.List;

public interface IAdminLogin {

    //管理员登录
    public Boolean Login(String adminEmail,String adminPwd)throws Exception;

    //显示想要注册为管理员的用户申请
    public List<AdminInfo> query()throws SQLException;

    public boolean deleteById(String adminEmail)throws SQLException;

}
