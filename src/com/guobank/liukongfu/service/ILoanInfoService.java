package com.guobank.liukongfu.service;


import com.guobank.liukongfu.entity.LoanInfo;
import com.guobank.liukongfu.util.Page;

import java.util.List;

public interface ILoanInfoService {

	public String addLoanInfo(Integer leven, LoanInfo loaninfo) throws Exception;
	
	public String yzCardId(String userId, String cardId) throws Exception;
	
	public Page<LoanInfo> queryLoanInfos(Page<LoanInfo> page, String userid) throws Exception;
	
	public String getMoney(String cardId, double money) throws Exception;
	
	public String isPwd(String cardid, String pwd, String userid) throws Exception;
	
	public String huankuan(String cardid, double money, Integer loanid) throws Exception;

	public String shengji(String cardid, double money, Integer id) throws Exception;
}
