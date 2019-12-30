package com.guobank.minzilong.service;

import com.guobank.minzilong.entity.Bankcard;

import java.util.List;

public interface IBankcardService {
    public List<Bankcard> queryBanklist(int userId) throws Exception;

    public Bankcard queryBank(int userId)throws Exception;
}
