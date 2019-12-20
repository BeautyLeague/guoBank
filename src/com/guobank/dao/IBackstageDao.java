package com.guobank.dao;

import com.guobank.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IBackstageDao {

    public List<User> query()throws SQLException;

}
