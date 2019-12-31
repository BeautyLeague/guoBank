package com.guobank.dao;

import com.guobank.entity.Bankcard;

import java.sql.SQLException;


/**
 * @author : pengliang
 * @version V1.0
 * @Project: MyBank
 * @Package com.guobank.dao
 * @Descriptio /**
 * @Project: MyBank
 * @Package com.guobank.dao
 * @Description: TODO
 * @date Date : 2019年11月08日 14:26
 */
public interface BankcardDao {
    Bankcard getBankcardById(String bankCardId) throws Exception;//通过银行卡号获取
    boolean updateBankcardNyByObject(Bankcard bankcard)throws SQLException;//通过实体类对象更新
    Bankcard getBankcardByUserIdAndBankCardId(String bankCard,Integer userId)throws Exception;
}
