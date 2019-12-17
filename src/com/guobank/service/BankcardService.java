package com.guobank.service;

import com.guobank.entity.Bankcard;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: MyBank
 * @Package com.guobank.service
 * @Descriptio /**
 * @Project: MyBank
 * @Package com.guobank.service
 * @Description: TODO
 * @date Date : 2019年11月22日 15:33
 */
public interface BankcardService {
    Bankcard getBankcardById(String bankCardId) throws Exception;
    Bankcard depositByObject(Bankcard bankcard) throws Exception;
    Bankcard tackMoney(Bankcard bankcard) throws Exception;
}
