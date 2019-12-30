package com.guobank.liukongfu.service.impl;

import com.guobank.liukongfu.dao.ILoanInfoDao;
import com.guobank.liukongfu.dao.IUserInfoDao;
import com.guobank.liukongfu.dao.impl.LoanInfoDao;
import com.guobank.liukongfu.dao.impl.UserInfoDao;
import com.guobank.liukongfu.entity.BankCard;
import com.guobank.liukongfu.entity.LoanInfo;
import com.guobank.liukongfu.entity.TransInfo;
import com.guobank.liukongfu.service.ILoanInfoService;
import com.guobank.liukongfu.util.Page;

import java.text.DecimalFormat;

import java.util.Date;
import java.util.List;


public class LoanInfoService implements ILoanInfoService {

	ILoanInfoDao iLoanInfoDao = new LoanInfoDao();

	@Override
	public String addLoanInfo(Integer leven, LoanInfo loaninfo)
			throws Exception {

		double rate = 0;
		switch (leven) {
		case 1:
			rate = 5 + 0.2 * loaninfo.getBackDate();
			break;
		case 2:
			rate = 4.98 + 0.198 * loaninfo.getBackDate();
			break;
		case 3:
			rate = 4.96 + 0.196 * loaninfo.getBackDate();
			break;
		case 4:
			rate = 4.94 + 0.194 * loaninfo.getBackDate();
			break;
		case 5:
			rate = 4.82 + 0.192 * loaninfo.getBackDate();
			break;
		}
		
		double lMoney = (rate * loaninfo.getLoanMoney() * loaninfo
				.getBackDate()) / 100;
		double allMoney = lMoney + loaninfo.getLoanMoney();
		double money=lMoney/loaninfo.getBackDate();
		
		
		DecimalFormat df = new DecimalFormat("#.000");
		String sallMoney=df.format(allMoney);
		String srate=df.format(rate);
		lMoney=Double.valueOf(df.format(lMoney));
		allMoney=Double.valueOf(df.format(allMoney));
		rate=Double.valueOf(df.format(rate));
		
		loaninfo.setlMoney(lMoney);
		loaninfo.setAllMoney(allMoney);
		loaninfo.setRate(rate);

		String result = "恭喜您贷款成功！贷款金额:" + loaninfo.getLoanMoney() + ",贷款年限为:"
				+ loaninfo.getBackDate() + "年,年利率为：" + srate + "%,每年因还利息:"+money+"元,到期因还:"+sallMoney+"元";

		//��Ӵ�����Ϣ
		iLoanInfoDao.addLoanInfo(loaninfo);
		
		//��ӽ�����Ϣ
		TransInfo transInfo = new TransInfo();
		transInfo.setTypeId(4);
		transInfo.setTrandsMoney(loaninfo.getLoanMoney());
		transInfo.setTrandsDate(loaninfo.getLoanDate());
		transInfo.setTrandsInfos(result);
		transInfo.setBankCardId(loaninfo.getCards());
		iLoanInfoDao.addTransInfo(transInfo);

		//�޸����п����
		double bankMoney= iLoanInfoDao.queryMoney(loaninfo.getCards());
		bankMoney=bankMoney+loaninfo.getLoanMoney();
        iLoanInfoDao.updateBankMoney(bankMoney, loaninfo.getCards());
		
		return result;
	}

	@Override
	public String yzCardId(String userId, String cardId) throws Exception {

		List<BankCard> cardIdStrings = iLoanInfoDao.cardIds(userId);
		String is_card = "false";
		for (BankCard bankCard : cardIdStrings) {
			if (bankCard.getBankCardId().equals(cardId)) {
				if (bankCard.getCardTypeId() == 1) {
					is_card = "is";
				} else {
					is_card = "true";
				}
			}
		}

		return is_card;
	}

	@Override
	public Page<LoanInfo> queryLoanInfos(Page<LoanInfo> page, String userid) throws Exception {
		
		return iLoanInfoDao.queryLoanInfos(page,userid);
	}

	@Override
	public String getMoney(String cardId,double money) throws Exception {
		double lmoney=iLoanInfoDao.queryMoney(cardId);
		String result="";
		if(lmoney<money)
		{
			result="false";
		}else{
			result="true";
		}
		return result;
	}

	@Override
	public String isPwd(String cardid,String pwd,String userid) throws Exception {
		
		List<BankCard> list =iLoanInfoDao.cardIds(userid);
		String pwds ="";
		String result="";
		for (BankCard bankCard : list) {
			if(bankCard.getBankCardId().equals(cardid))
			{
				pwds=bankCard.getPass();
			}
			
		}
		if(pwds.equals(pwd))
		{
			result="支付密码输入正确";
		}else {
			result="支付密码输入错误";
		}
		
		return result;
	}

	@Override
	public String huankuan(String cardid, double money,Integer loanid) throws Exception {

		String result="";

		//修改银行卡金额
		double bankMoney= iLoanInfoDao.queryMoney(cardid);
		bankMoney=bankMoney-money;
		iLoanInfoDao.updateBankMoney(bankMoney, cardid);
		result="恭喜你还款成功！总共还款"+money+"元,银行卡"+cardid+"还剩"+bankMoney+"元";
		//添加交易信息
		TransInfo transInfo = new TransInfo();
		transInfo.setTypeId(5);
		transInfo.setTrandsMoney(money);
		transInfo.setTrandsDate(new Date());
		transInfo.setTrandsInfos(result);
		transInfo.setBankCardId(cardid);
		iLoanInfoDao.addTransInfo(transInfo);

		iLoanInfoDao.updateis_hk(loanid);

		return result;
	}
	IUserInfoDao iUserInfoDao = new UserInfoDao();
	@Override
	public String shengji(String cardid, double money,Integer id) throws Exception {
		String result="";

		//修改银行卡金额
		double bankMoney= iLoanInfoDao.queryMoney(cardid);
		bankMoney=bankMoney-money;
		iLoanInfoDao.updateBankMoney(bankMoney, cardid);
		result="恭喜您升级成功！银行卡"+cardid+"还剩"+bankMoney+"元";
		//添加交易信息
		TransInfo transInfo = new TransInfo();
		transInfo.setTypeId(7);
		transInfo.setTrandsMoney(money);
		transInfo.setTrandsDate(new Date());
		transInfo.setTrandsInfos(result);
		transInfo.setBankCardId(cardid);
		iLoanInfoDao.addTransInfo(transInfo);
		iUserInfoDao.updateLeven(id);

		return result;
	}

}
