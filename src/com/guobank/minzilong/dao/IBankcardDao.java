package com.guobank.minzilong.dao;

import com.guobank.minzilong.entity.Bankcard;
import com.guobank.minzilong.util.Page;
import java.util.List;

/**
 * 银行卡号业务类
 */
public interface IBankcardDao {
    //查询用户名下所有卡号
    public List<Bankcard>queryBanklist(int userId)throws Exception;

   //卡号页面分页
   public Page<Bankcard> queryAllNews(Page<Bankcard> page, Integer userId)throws Exception;

}
