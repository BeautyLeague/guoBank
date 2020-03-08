package com.guobank.minzilong.service.impl;

import com.guobank.minzilong.dao.IBankcardDao;
import com.guobank.minzilong.dao.impl.BankcardDao;
import com.guobank.minzilong.entity.Bankcard;
import com.guobank.minzilong.service.IBankcardService;
import com.guobank.minzilong.util.Page;

import java.util.List;

public class BankcardService implements IBankcardService {
    private IBankcardDao iBankcardDao=new BankcardDao();
    //查询用户名下所有卡号
    @Override
    public List<Bankcard> queryBanklist(int userId) throws Exception {
        return this.iBankcardDao.queryBanklist(userId);
    }

    @Override
    public Bankcard queryBank(int userId) throws Exception {
        return null;
    }

   //卡号页面分页
    @Override
    public Page<Bankcard> queryAllNews(Page<Bankcard> page,Integer userId) throws Exception {
        return this.iBankcardDao.queryAllNews(page,userId);
    }

}
