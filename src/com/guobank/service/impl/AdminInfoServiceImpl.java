package com.guobank.service.impl;

import com.guobank.dao.AdminInfoDao;
import com.guobank.dao.impl.AdminInfoDaoImpl;
import com.guobank.entity.AdminInfo;
import com.guobank.service.AdminInfoService;

import java.io.InputStream;
import java.sql.SQLException;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: guoBank
 * @Package com.guobank.service.impl
 * @Descriptio /**
 * @Project: guoBank
 * @Package com.guobank.service.impl
 * @Description: TODO
 * @date Date : 2019年12月26日 9:33
 */
public class AdminInfoServiceImpl implements AdminInfoService {
    private AdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
    @Override
    public boolean checkEmail(String email) throws Exception {
        return adminInfoDao.queryByEmail(email) != null ;
    }

    @Override
    public InputStream getAdminPortrait(String email) throws Exception {
        return adminInfoDao.queryByEmail(email).getAdminPortrait();
    }

    @Override
    public boolean adminRegister(AdminInfo adminInfo) throws SQLException {
        return adminInfoDao.saveAdminInfo(adminInfo);
    }


    @Override
    public boolean activationAdmin(String email) throws Exception {
        return !adminInfoDao.updateActivation(email,1);
    }

    @Override
    public AdminInfo getAdminInfo(String email) throws Exception {
        return adminInfoDao.queryByEmail(email);
    }
}
