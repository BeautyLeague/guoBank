package com.guobank.minzilong.service;

import com.guobank.minzilong.entity.Bankcard;
import com.guobank.minzilong.util.Page;

import java.util.List;

public interface IBankcardService {
    //查询用户名下所有卡号
    public List<Bankcard> queryBanklist(int userId) throws Exception;

    //使用用户id查询信息
    public Bankcard queryBank(int userId)throws Exception;

    //卡号页面分页
    public Page<Bankcard> queryAllNews(Page<Bankcard> page, Integer userId)throws Exception;
}
