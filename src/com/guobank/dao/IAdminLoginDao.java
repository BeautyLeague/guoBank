package com.guobank.dao;

public interface IAdminLoginDao {

    public void Login(String adminEmail,String adminPwd)throws Exception;
}
