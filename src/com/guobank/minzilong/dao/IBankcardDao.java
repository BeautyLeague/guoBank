package com.guobank.minzilong.dao;

import com.guobank.minzilong.entity.Bankcard;
import com.guobank.minzilong.util.Page;
import java.util.List;

public interface IBankcardDao {
    //查询用户名下的所有卡号
    public List<Bankcard>queryBanklist(int userId)throws Exception;

    public Page<Bankcard> queryAllNews(Page<Bankcard> page, Integer userId)throws Exception;
    //public Bankcard queryBank(int userId)throws Exception;
}
