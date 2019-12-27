package com.guobank.dao.impl;

import com.guobank.dao.BaseDao;
import com.guobank.dao.IAdminLoginDao;

public class AdminLoginDao  extends BaseDao implements IAdminLoginDao {
    @Override
    public void Login(String adminEmail,String adminPwd) throws Exception {
        String sql="Select * from admininfo where adminEmail=? and adminpwd=? and activation=?";
        super.executeQuery(sql,new Object[]{adminEmail,adminPwd,0});
    }
}
