package com.guobank.service;

public interface ILoseService {

    //管理员冻结卡号
    public void Lose(String bankCardId)throws Exception;

    //管理员解冻卡号
    public void Thaw(String bankCardId)throws Exception;

}
