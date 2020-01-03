package com.guobank.liukongfu.dao.impl;

import com.guobank.dao.BaseDao;
import com.guobank.liukongfu.dao.ILoanInfoDao;
import com.guobank.liukongfu.entity.BankCard;
import com.guobank.liukongfu.entity.LoanInfo;
import com.guobank.liukongfu.entity.TransInfo;
import com.guobank.liukongfu.util.Page;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LoanInfoDao extends BaseDao implements ILoanInfoDao {

	@Override
	public void addLoanInfo(LoanInfo loanInfo) throws Exception {
		String sql = "insert into loaninfo value(null,?,?,?,?,?,?,?,?,?,?)";

		super.executeUpdate(
				sql,
				new Object[] { loanInfo.getUserId(), loanInfo.getLoanMoney(),
						loanInfo.getLoanDate(), loanInfo.getBackDate(),
						loanInfo.getlMoney(), loanInfo.getAllMoney(),
						loanInfo.getRate(),loanInfo.getIs_loan(),
						loanInfo.getThisDate(),loanInfo.getCards() });
	}

	@Override
	public List<BankCard> cardIds(String userid) throws Exception {
		String sql = "select * from bankcard where userId=?";

		ResultSet rs = super.executeQuery(sql, new Object[] { userid });

		List<BankCard> cardids = new ArrayList<BankCard>();

		while (rs.next()) {
			BankCard bankCard = new BankCard();

			bankCard.setBankCardId(rs.getString("bankCardId"));
			bankCard.setAddress(rs.getString("address"));
			bankCard.setCardTypeId(rs.getInt("cardTypeId"));
			bankCard.setDate(rs.getDate("Date"));
			bankCard.setIs_ds(rs.getInt("is_ds"));
			bankCard.setMoney(rs.getDouble("Money"));
			bankCard.setPass(rs.getString("pass"));
			bankCard.setUserId(rs.getInt("userId"));

			cardids.add(bankCard);
		}

		return cardids;
	}

	@Override
	public Page<LoanInfo> queryLoanInfos(Page<LoanInfo> page,String userid) throws Exception {
		String sql = "select * from loaninfo where userId=? order by loanDate desc limit ?,?";

		ResultSet rs = super.executeQuery(sql, new Object[] { userid,(page.getPageNo() - 1) * page.getPageCount(),
				page.getPageCount()  });

		List<LoanInfo> loanInfo = new ArrayList<LoanInfo>();

		while (rs.next()) {
			LoanInfo loanInfo2 = new LoanInfo();

			loanInfo2.setLoanId(rs.getInt("loanId"));
			loanInfo2.setUserId(rs.getInt("userid"));
			loanInfo2.setLoanMoney(rs.getDouble("loanMoney"));
			loanInfo2.setLoanDate(rs.getTimestamp("loanDate"));
			loanInfo2.setBackDate(rs.getInt("backDate"));
			loanInfo2.setlMoney(rs.getDouble("lmoney"));
			loanInfo2.setAllMoney(rs.getDouble("allmoney"));
			loanInfo2.setRate(rs.getDouble("rate"));
			loanInfo2.setThisDate(rs.getTimestamp("thisDate"));

			loanInfo2.setIs_loan(rs.getInt("is_loan"));
			loanInfo2.setCards(rs.getString("cards"));
			
			loanInfo.add(loanInfo2);
		}

		//构造page对象
		page.setResultList(loanInfo);//
		page.setTotalCount(this.getTotalNews(userid));//设置总记录数
		return page;
	}

	private Long getTotalNews(String id) throws Exception {
		String sql = "select count(1) from loanInfo where userId=?";
		ResultSet rs = super.executeQuery(sql, new Object[] {id});

		//循环遍历，构建数据集合
		Long total = 0L;
		while (rs.next()) {
			total = rs.getLong(1);
		}

		return total;
	}

	@Override
	public void addTransInfo(TransInfo trInfo) throws Exception {
		String sql ="insert into transinfo value(default,?,?,?,?,?)";
		
		super.executeUpdate(sql, new Object[]{trInfo.getTypeId(),trInfo.getBankCardId(),trInfo.getTrandsDate(),trInfo.getTrandsMoney(),trInfo.getTrandsInfos()});
	}

	@Override
	public void updateBankMoney(double money,String cardId) throws Exception {
		String sql="update bankcard set Money=? where bankCardId=?";
		
		super.executeUpdate(sql, new Object[]{money,cardId});
	}

	@Override
	public double queryMoney(String cardID) throws Exception {
		String sql = "select * from bankcard where bankCardId=?";

		ResultSet rs = super.executeQuery(sql, new Object[] { cardID });

		double money=0;
		while (rs.next()) {
			
			money=rs.getDouble("Money");
		}

		return money;
	}
	public void updateis_hk(Integer loanid) throws Exception {
		String sql="update loaninfo set is_loan = 1 where loanId = ?";

		super.executeUpdate(sql, new Object[]{loanid});
	}


}
