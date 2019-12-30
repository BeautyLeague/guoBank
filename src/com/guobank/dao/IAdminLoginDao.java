package com.guobank.dao;

import com.guobank.entity.AdminInfo;
import com.guobank.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IAdminLoginDao {

    //后台登录
    public AdminInfo Login(String adminEmail)throws Exception;

    //显示想要注册为管理员的用户申请
    public List<AdminInfo> query()throws SQLException;

    public boolean deleteById(String adminEmail)throws SQLException;

}
