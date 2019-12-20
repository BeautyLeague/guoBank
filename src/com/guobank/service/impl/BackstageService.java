package com.guobank.service.impl;

import com.guobank.dao.IBackstageDao;
import com.guobank.dao.impl.BackstageDao;
import com.guobank.entity.User;
import com.guobank.service.IBackstageService;

import java.sql.SQLException;
import java.util.List;

public class BackstageService implements IBackstageService {
    private IBackstageDao backstageDao=new BackstageDao();

    @Override
    public List<User> query() throws SQLException {
        return backstageDao.query();
    }
}
