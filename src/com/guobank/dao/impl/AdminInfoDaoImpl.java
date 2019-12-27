package com.guobank.dao.impl;

import com.guobank.dao.AdminInfoDao;
import com.guobank.dao.BaseDao;
import com.guobank.entity.AdminInfo;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.ResultSet;
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
 * @date Date : 2019年12月26日 9:27
 */
public class AdminInfoDaoImpl extends BaseDao implements AdminInfoDao {
    @Override
    public AdminInfo queryByEmail(String email) throws Exception {
        String sql = "select * from admininfo where adminemail = ?";
        ResultSet rs = super.executeQuery(sql,new Object[]{email});
        AdminInfo adminInfo = null;
        while (rs.next()){
            adminInfo = new AdminInfo();
            for (Field field: AdminInfo.class.getDeclaredFields()) {
                field.setAccessible(true);
                if(field.getType() == InputStream.class){
                    adminInfo.setAdminPortrait(rs.getAsciiStream("AdminPortrait"));
                }else{
                field.set(adminInfo,rs.getObject(field.getName()));
                }
            }
        }
        System.out.println(adminInfo);
        return adminInfo;
    }


    @Override
    public boolean saveAdminInfo(AdminInfo adminInfo) throws SQLException {
        String sql = "insert into adminInfo values(?,?,?,?)";
        return !super.execute(sql,new Object[]{adminInfo.getAdminEmail(),adminInfo.getAdminPwd(),adminInfo.getAdminName(),adminInfo.getAdminPortrait()});
    }
}
