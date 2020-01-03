package com.guobank.guopeng.service;


import com.guobank.guopeng.entity.OpenAccount;

public interface IOpenAccountService {
	public String InsertOpenAccount(String bankCardId, int cardTypeId,int userId, double monery, int password, String address,String phone)throws Exception;
	
	public String UpdateBankCardId(String bankCardId,String phone,int userId)throws Exception;
	
	public OpenAccount SelcetBankCardId(String bankCardId)throws Exception;
	
	public String DeleteBankCardId(String userName, String bankCardId,String phone,int userId)throws Exception;

}
