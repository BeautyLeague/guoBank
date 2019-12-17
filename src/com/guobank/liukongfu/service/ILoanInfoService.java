package com.guobank.liukongfu.service;


import com.guobank.liukongfu.entity.LoanInfo;

import java.util.List;

public interface ILoanInfoService {

	public String addLoanInfo(Integer leven, LoanInfo loaninfo) throws Exception;
	
	public String yzCardId(String userId, String cardId) throws Exception;
	
	public List<LoanInfo> queryLoanInfos(String userid) throws Exception;
	
	public String getMoney(String cardId, double money) throws Exception;
	
	public String isPwd(String cardid, String pwd, String userid) throws Exception;
	
	public String huankuan(String cardid, double money,Integer loanid) throws Exception;
}
