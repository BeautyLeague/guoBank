package com.guobank.guopeng.dao;


import com.guobank.guopeng.entity.OpenAccount;

public interface IOpenAccountDao {
	//开户
	public void InsertOpenAccount(String bankCardId, int cardTypeId,int userId, double monery, int password, String address)throws Exception;
	
	//挂失
	public void UpdateBankCardId(String bankCardId)throws Exception;
	
	
	public OpenAccount SelectBankCardId(String bankCardId)throws Exception;
	
	public void  DeleteBankCardId(String bankCardId)throws Exception;
}
