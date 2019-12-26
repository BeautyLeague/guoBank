package com.guobank.service.impl;

import com.guobank.dao.AdminInfoDao;
import com.guobank.dao.impl.AdminInfoDaoImpl;
import com.guobank.entity.AdminInfo;
import com.guobank.service.AdminInfoService;

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
public class AdminInfoSerciceImpl implements AdminInfoService {
    private AdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
    @Override
    public boolean checkEmail(String email) throws Exception {
        return adminInfoDao.queryByEmail(email) != null;
    }

    @Override
    public boolean adminRegister(AdminInfo adminInfo) throws SQLException {
        return adminInfoDao.saveAdminInfo(adminInfo);
    }
}
