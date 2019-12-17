package com.guobank.liukongfu.dao;


import com.guobank.liukongfu.entity.BankCard;
import com.guobank.liukongfu.entity.LoanInfo;
import com.guobank.liukongfu.entity.TransInfo;

import java.util.List;

public interface ILoanInfoDao {

	public void addLoanInfo(LoanInfo loanInfo) throws Exception;
	
	public List<BankCard> cardIds(String userid) throws Exception;
	
	public List<LoanInfo> queryLoanInfos(String userid) throws Exception;
	
	public void addTransInfo(TransInfo trInfo) throws Exception;
	
	public void updateBankMoney(double money, String cardId) throws Exception;
	
	public double queryMoney(String cardID) throws Exception;

	public void updateis_hk(Integer loanid) throws Exception;
}
