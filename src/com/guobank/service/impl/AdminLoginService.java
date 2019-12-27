package com.guobank.service.impl;

import com.guobank.dao.IAdminLoginDao;
import com.guobank.dao.impl.AdminLoginDao;
import com.guobank.entity.AdminInfo;
import com.guobank.service.IAdminLogin;

public class AdminLoginService implements IAdminLogin {

    private IAdminLoginDao loginDao = new AdminLoginDao();
    @Override
    public Boolean Login(String adminEmail,String adminPwd) throws Exception {

        AdminInfo adminInfo=loginDao.Login(adminEmail);
        if(adminInfo==null){
            throw new Exception("该用户不存在");
        }else if(!adminInfo.getAdminPwd().equals(adminPwd)){
            throw new Exception("密码错误");
        }else if(adminInfo.getActivation()==1) {
            throw new Exception("该用户未激活，请等待管理员激活后登录");
        }else{
            return true;
        }
    }
}
