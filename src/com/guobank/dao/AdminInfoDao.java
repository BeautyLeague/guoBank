package com.guobank.dao;

import com.guobank.entity.AdminInfo;

import java.sql.SQLException;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: guoBank
 * @Package com.guobank.dao.impl
 * @Descriptio /**
 * @Project: guoBank
 * @Package com.guobank.dao.impl
 * @Description: TODO
 * @date Date : 2019年12月26日 9:25
 */
public interface AdminInfoDao {
    AdminInfo queryByEmail(String email)throws Exception;
    boolean saveAdminInfo(AdminInfo adminInfo)throws SQLException;
    boolean updateActivation(String email,Integer activation)throws SQLException;
    boolean updateAdmin(AdminInfo adminInfo) throws Exception;
}
