package com.guobank.entity;

import java.io.InputStream;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: guoBank
 * @Package com.guobank.entity
 * @Descriptio /**
 * @Project: guoBank
 * @Package com.guobank.entity
 * @Description: TODO
 * @date Date : 2019年12月26日 9:25
 */
public class AdminInfo {
    private String adminEmail;
    private String adminPwd;
    private String adminName;
    private InputStream adminPortrait;


    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public InputStream getAdminPortrait() {
        return adminPortrait;
    }

    public void setAdminPortrait(InputStream adminPortrait) {
        this.adminPortrait = adminPortrait;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "adminEmail='" + adminEmail + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPortrait=" + adminPortrait +
                '}';
    }
}
