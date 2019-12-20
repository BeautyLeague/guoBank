package com.guobank.service;

import com.guobank.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IBackstageService {

    public List<User> query()throws SQLException;

}
