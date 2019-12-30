package com.guobank.minzilong.service.impl;

import com.guobank.minzilong.dao.IBankcardDao;
import com.guobank.minzilong.dao.impl.BankcardDao;
import com.guobank.minzilong.entity.Bankcard;
import com.guobank.minzilong.service.IBankcardService;

import java.util.List;

public class BankcardService implements IBankcardService {
    private IBankcardDao iBankcardDao=new BankcardDao();
    @Override
    public List<Bankcard> queryBanklist(int userId) throws Exception {
        return this.iBankcardDao.queryBanklist(userId);
    }

    @Override
    public Bankcard queryBank(int userId) throws Exception {
        return null;
    }
}