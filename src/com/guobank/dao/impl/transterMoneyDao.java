package com.guobank.dao.impl;



import com.guobank.dao.BaseDao;
import com.guobank.dao.ItransferMoney;
import com.guobank.entity.Bankcard;



public class transterMoneyDao extends BaseDao implements ItransferMoney {
    @Override
    public Boolean update(Bankcard
                                      bankCard) throws Exception {
        String sql = "Update bankcard set money=?, cardtypeid=?, userid=?,pass=?," +
                "is_ds=?,address=?,date=? where bankcardid=?  ";

        Boolean b = super.executeUpdate(sql, new Object[]{bankCard.getMoney(),
                bankCard.getCardTypeid(), bankCard.getUserid(), bankCard.getPass(),
                bankCard.getIs_Ds(), bankCard.getAddress(), bankCard.getDate(), bankCard.getBankCardid()});
        return b;
    }

    @Override
    public Boolean Add( String bankCardId, String card, Float transMoney, String transInfo) throws Exception {

        String sql = "Insert into transInfo values(default,3,?,now(),?,?)";


        String sqls = "Insert into transInfo values(default,6,?,now(),?,?)";
        if(!super.executeUpdate(sql, new Object[]{ bankCardId, transMoney, transInfo}) && !super.executeUpdate(sqls, new Object[]{ card, transMoney, transInfo})){
            return true;
        }
        return false;

    }
}
