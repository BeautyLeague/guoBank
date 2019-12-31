package com.guobank.service;

import javax.xml.crypto.Data;
import java.util.Date;

public interface ItransService {
    //转账
    public Boolean update(Float money, String bankID,Integer userId, Integer pass, String card) throws Exception;

    //添加转账记录
    public Boolean Add(String bankCardId,String card, Float transMoney, String transInfo) throws Exception;

}
