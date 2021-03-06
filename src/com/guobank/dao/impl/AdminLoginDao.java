package com.guobank.dao.impl;

import com.guobank.dao.BaseDao;
import com.guobank.dao.IAdminLoginDao;
import com.guobank.entity.AdminInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminLoginDao  extends BaseDao implements IAdminLoginDao {
    @Override
    public AdminInfo Login(String adminEmail) throws Exception {
        String sql="Select * from admininfo where adminEmail=?";
        ResultSet rs=super.executeQuery(sql,new Object[]{adminEmail});
        AdminInfo adminInfo=null;

        while (rs.next()){
            adminInfo=new AdminInfo();
            adminInfo.setAdminEmail(rs.getString("adminEmail"));
            adminInfo.setAdminPwd(rs.getString("adminpwd"));
            adminInfo.setAdminName(rs.getString("adminname"));
            adminInfo.setActivation(rs.getInt("activation"));
        }
       return adminInfo;
    }

    @Override
    public List<AdminInfo> query() throws SQLException {

        String sql="Select * from admininfo where activation=0 ";
        ResultSet rs=super.executeQuery(sql,null);
        AdminInfo adminInfo=null;
        List<AdminInfo> list=new ArrayList<AdminInfo>();
        while (rs.next()){
            adminInfo=new AdminInfo();
            adminInfo.setAdminEmail(rs.getString("adminEmail"));
            adminInfo.setAdminPwd(rs.getString("adminpwd"));
            adminInfo.setAdminName(rs.getString("adminname"));
            adminInfo.setActivation(rs.getInt("activation"));
            list.add(adminInfo);
        }
        return list;
    }

    @Override
    public boolean deleteById(String adminEmail) throws SQLException {
        return super.execute("delete from admininfo where adminEmail = ?", new Object[]{adminEmail});

    }
}
