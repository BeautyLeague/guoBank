package com.guobank.service.impl;

import com.guobank.dao.IAdminLoginDao;
import com.guobank.dao.impl.AdminLoginDao;
import com.guobank.service.IAdminLogin;

public class AdminLoginService implements IAdminLogin {
    private IAdminLoginDao loginDao=new AdminLoginDao();
    @Override
    public void Login(String adminEmail, String adminPwd) throws Exception {
        loginDao.Login(adminEmail,adminPwd);
    }
}
