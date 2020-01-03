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
	UserInfo userInfo=null;
	public String InsertOpenAccount(String bankCardId, int cardTypeId,
								  int userId,double monery,int password, String address,String phone) throws Exception {
		// TODO Auto-generated method stub
		userInfo=infoService.userById(userId);
		if (userInfo.getPho().equals(phone)){
			this.iOpenAccount.InsertOpenAccount(bankCardId, cardTypeId,userId, monery, password, address);
			return "开户成功";
		}else{
			return "电话号码不一致";
		}
	}
	@Override
	public String UpdateBankCardId(String bankCardId,String phone,int userId) throws Exception {
		OpenAccount openAccount = SelcetBankCardId(bankCardId);
		String result;
		userInfo=infoService.userById(userId);
		if(openAccount!=null&&openAccount.getBankCardId()!=null){
			if (!userInfo.getPho().equals(phone)){
				return "电话号码不一致";
			}
			if (openAccount.getIs_ds()==0) {
				this.iOpenAccount.UpdateBankCardId(bankCardId);
				result="挂失成功";
			}else{
				result="银行卡已挂失";
			}
		}else{
			throw new Exception("没有该银行卡请重新输入卡号");
		}
		return result;
	}
	@Override
	public OpenAccount SelcetBankCardId(String bankCardId) throws Exception {
		return this.iOpenAccount.SelectBankCardId(bankCardId);
	}
	@Override
	public String DeleteBankCardId(String userName, String bankCardId,String phone,int userId)
			throws Exception {
		OpenAccount openAccount = SelcetBankCardId(bankCardId);
		userInfo=infoService.userById(userId);
		//判断此卡号是否为空
		if(openAccount!=null&&openAccount.getBankCardId()!=null){
			UserInfo selcetUserInfo = infoService.SelcetUserInfo(userName);
			//判断此用户信息是否为空
			System.out.println(selcetUserInfo.getUserName());
			if (!userInfo.getPho().equals(phone)){
				return "电话号码不一致";
			}
			if(selcetUserInfo!=null&&selcetUserInfo.getUserName().equals(userName)){
				//执行销户
				this.iOpenAccount.DeleteBankCardId(bankCardId);
				return "销户成功";
			}else {
			 throw 	new Exception("没有此用户，请重新输入。");
			}
		}else{
			throw 	new Exception("没有该银行卡请重新输入卡号");
		}
		
	}

}
