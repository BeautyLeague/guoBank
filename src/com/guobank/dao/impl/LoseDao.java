package com.guobank.dao.impl;

import com.guobank.dao.BaseDao;
import com.guobank.dao.ILoseDao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoseDao extends BaseDao implements ILoseDao {
    @Override
    public void Lose(String bankCardId) throws Exception {
        String sql="update bankcard set is_ds=1 where bankCardId=?";
        super.executeUpdate(sql,new Object[]{bankCardId});
    }
}
