package com.guobank.service;

import com.guobank.entity.AdminInfo;
public interface IAdminLogin {

    public Boolean Login(String adminEmail,String adminPwd)throws Exception;

}
