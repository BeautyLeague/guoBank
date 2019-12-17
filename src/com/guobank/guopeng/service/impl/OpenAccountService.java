package com.guobank.guopeng.service.impl;


import com.guobank.guopeng.dao.IOpenAccountDao;
import com.guobank.guopeng.dao.impl.OpenAccountDao;
import com.guobank.guopeng.entity.OpenAccount;
import com.guobank.guopeng.entity.UserInfo;
import com.guobank.guopeng.service.IOpenAccountService;
import com.guobank.guopeng.service.IUserInfoService;

public class OpenAccountService implements IOpenAccountService {

	private IOpenAccountDao iOpenAccount=new OpenAccountDao();
	private IUserInfoService infoService=new UserInfoService();
	public void InsertOpenAccount(String bankCardId, int cardTypeId,
								  int userId,double monery,int password, String address) throws Exception {
		// TODO Auto-generated method stub
		this.iOpenAccount.InsertOpenAccount(bankCardId, cardTypeId,userId, monery, password, address);
	}
	@Override
	public void UpdateBankCardId(String bankCardId) throws Exception {
		OpenAccount openAccount = SelcetBankCardId(bankCardId);
		if(openAccount!=null&&openAccount.getBankCardId()!=null){
			this.iOpenAccount.UpdateBankCardId(bankCardId);
		}else{
			throw new Exception("没有该银行卡请重新输入卡号");
		}
		
	}
	@Override
	public OpenAccount SelcetBankCardId(String bankCardId) throws Exception {
		return this.iOpenAccount.SelectBankCardId(bankCardId);
	}
	@Override
	public void DeleteBankCardId(String userName, String bankCardId)
			throws Exception {
		OpenAccount openAccount = SelcetBankCardId(bankCardId);
		//判断此卡号是否为空
		if(openAccount!=null&&openAccount.getBankCardId()!=null){
			UserInfo selcetUserInfo = infoService.SelcetUserInfo(userName);
			//判断此用户信息是否为空
			System.out.println(selcetUserInfo.getUserName());
			if(selcetUserInfo!=null&&selcetUserInfo.getUserName().equals(userName)){
				//执行销户
				this.iOpenAccount.DeleteBankCardId(bankCardId);
			}else {
				throw new Exception("没有此用户，请重新输入。");
			}
		}else{
			throw new Exception("没有该银行卡请重新输入卡号");
		}
		
	}

}
