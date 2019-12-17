package com.guobank.guopeng.service;


import com.guobank.guopeng.entity.OpenAccount;

public interface IOpenAccountService {
	public void InsertOpenAccount(String bankCardId, int cardTypeId,int userId, double monery, int password, String address)throws Exception;
	
	public void UpdateBankCardId(String bankCardId)throws Exception;
	
	public OpenAccount SelcetBankCardId(String bankCardId)throws Exception;
	
	public void DeleteBankCardId(String userName, String bankCardId)throws Exception;
}
