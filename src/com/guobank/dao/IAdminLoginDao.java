package com.guobank.dao;

import com.guobank.entity.AdminInfo;

public interface IAdminLoginDao {

    public AdminInfo Login(String adminEmail)throws Exception;
}
