package com.guobank.service.impl;



import com.guobank.dao.impl.SelectDao;
import com.guobank.dao.impl.transterMoneyDao;
import com.guobank.entity.Bankcard;
import com.guobank.service.ItransService;



public class TransService implements ItransService {
    Bankcard bankCard=new Bankcard();
    SelectDao selectDao = new SelectDao();
    com.guobank.dao.impl.transterMoneyDao transterMoneyDao=new transterMoneyDao();


    @Override
    public Boolean update(Float money, String bankID,Integer userId,Integer pass,String card) throws Exception {
        Bankcard zhuanCard = selectDao.SelectBankID(bankID,userId);
        Bankcard shouCard = selectDao.SelectBankIDs(card);
        if(!zhuanCard.getPass().equals(pass)){
            throw new Exception("密码错误");
        }
        if(zhuanCard.getMoney() < money){
            throw new Exception("金额不足");
        }
        if(zhuanCard.getIs_Ds().equals(1)){
            throw  new Exception("卡号"+bankID+"已挂失，无法进行转账");
        }
        if(shouCard.getIs_Ds().equals(1)){
            throw  new Exception("卡号"+card+"已挂失，无法进行转账");
        }
        zhuanCard.setMoney(zhuanCard.getMoney()-money);
        shouCard.setMoney(shouCard.getMoney()+money);
        transterMoneyDao.update(zhuanCard);
        transterMoneyDao.update(shouCard);

        return true;
    }

    @Override
    public Boolean Add( String bankCardId,String card, Float transMoney, String transInfo) throws Exception {
        return transterMoneyDao.Add(bankCardId,card,transMoney,transInfo);
    }
}
