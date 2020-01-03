package com.guobank.minzilong.service;

import com.guobank.minzilong.entity.Bankcard;
import com.guobank.minzilong.util.Page;

import java.util.List;

public interface IBankcardService {
    public List<Bankcard> queryBanklist(int userId) throws Exception;

    public Bankcard queryBank(int userId)throws Exception;


    public Page<Bankcard> queryAllNews(Page<Bankcard> page, Integer userId)throws Exception;
}
