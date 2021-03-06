package com.guobank.service;

import com.guobank.entity.AdminInfo;

import java.io.InputStream;
import java.sql.SQLException;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: guoBank
 * @Package com.guobank.service
 * @Descriptio /**
 * @Project: guoBank
 * @Package com.guobank.service
 * @Description: TODO
 * @date Date : 2019年12月26日 9:32
 */
public interface AdminInfoService {
    boolean checkEmail(String email)throws Exception;
    boolean adminRegister(AdminInfo adminInfo)throws SQLException;
    InputStream getAdminPortrait(String email)throws Exception;
    boolean activationAdmin(String email)throws Exception;
    AdminInfo getAdminInfo(String email)throws Exception;
    boolean updateAdminInfoName(String email,String name)throws Exception;
    boolean updateAdminPortrait(String email,InputStream is)throws Exception;
    boolean updateAdminEmail(String newEmail,String oldEmail)throws SQLException;
}
