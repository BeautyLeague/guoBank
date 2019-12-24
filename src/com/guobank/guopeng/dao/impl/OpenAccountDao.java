package com.guobank.guopeng.dao.impl;

import com.guobank.guopeng.dao.BaseDao;
import com.guobank.guopeng.dao.IOpenAccountDao;
import com.guobank.guopeng.entity.OpenAccount;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;



public class OpenAccountDao extends BaseDao implements IOpenAccountDao {

	@Override
	public void InsertOpenAccount(String bankCardId, int cardTypeId,
								  int userId,double monery, int password, String address) throws Exception {
		String sql="insert bankcard VALUES(?,?,?,?,?,?,?,?)";
		String sqlRecord="INSERT into record VALUES(DEFAULT,?,?);";
		super.executeUpdate(sql,new Object[]{bankCardId,cardTypeId,userId,monery,password,0,address,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())});
		super.executeUpdate(sqlRecord,new Object[]{2,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())});
	}


	@Override
	public void UpdateBankCardId(String bankCardId) throws Exception {
		String sql="update bankcard set is_ds=? where bankCardId=?";
		String sqlRecord="INSERT into record VALUES(DEFAULT,?,?);";
		super.executeUpdate(sql,new Object[]{1,bankCardId});
		super.executeUpdate(sqlRecord,new Object[]{4,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())});
	}

	@Override
	public OpenAccount SelectBankCardId(String bankCardId) throws Exception {
		String sql="select * from bankcard where bankCardId=?";
		ResultSet rs = super.query(sql,new Object[]{bankCardId});
		OpenAccount openAccount = new OpenAccount();
		while (rs.next()) {
			openAccount.setAddress(rs.getString("address"));
			openAccount.setBankCardId(rs.getString("bankCardId"));
			openAccount.setCardTypeId(rs.getInt("cardTypeId"));
			openAccount.setDate(rs.getDate("Date"));
			openAccount.setIs_ds(rs.getInt("is_ds"));
			//openAccount.setMonery(rs.getFloat("Monery"));
			openAccount.setPassword(rs.getInt("pass"));
			openAccount.setUserid(rs.getInt("userId"));
		}
		return openAccount;
	}

	@Override
	public void DeleteBankCardId(String bankCardId) throws Exception {
		String sql="DELETE from bankcard where bankCardId=?";
		String sqlRecord="INSERT into record VALUES(DEFAULT,?,?);";
		super.executeUpdate(sql,new Object[]{bankCardId});
		super.executeUpdate(sqlRecord,new Object[]{3,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())});
	}

}
