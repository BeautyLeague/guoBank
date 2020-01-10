package com.guobank.minzilong.dao.impl;


import com.guobank.dao.BaseDao;
import com.guobank.minzilong.dao.IBankcardDao;
import com.guobank.minzilong.entity.Bankcard;
import com.guobank.minzilong.util.Page;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankcardDao extends BaseDao implements IBankcardDao {
    //查询用户名下的所有卡号
    @Override
    public List<Bankcard> queryBanklist(int userId) throws Exception {
        String sql="SELECT * FROM bankcard where userId=?";
        ResultSet rst=super.executeQuery(sql,new Object[]{userId});
        List<Bankcard> banklist=new ArrayList<Bankcard>();
        while(rst.next()){
            Bankcard bankcard=new Bankcard();
            bankcard.setUserId(rst.getInt("userId"));
            bankcard.setBankCardId(rst.getString("bankCardId"));
            bankcard.setCardTypeId(rst.getInt("cardTypeId"));
            bankcard.setIs_ds(rst.getInt("is_ds"));
            bankcard.setAddress(rst.getString("address"));
            bankcard.setDate(rst.getDate("date"));
            banklist.add(bankcard);
        }
        return banklist;
    }

    //卡号页面分页
    @Override
    public Page<Bankcard> queryAllNews(Page<Bankcard> page,Integer userId) throws Exception {
        String sql = "select * from Bankcard where userId=? limit ?,?";
        ResultSet rs = super.executeQuery(sql,
                new Object[] {userId,(page.getPageNo()-1) * page.getPageCount(),
                        page.getPageCount()});
        List<Bankcard> banklist = new ArrayList<Bankcard>();
        while (rs.next()) {
            Bankcard bankcard = new Bankcard();
            bankcard.setBankCardId(rs.getString("bankCardId"));
            bankcard.setCardTypeId(rs.getInt("cardTypeId"));
            bankcard.setIs_ds(rs.getInt("is_ds"));
            bankcard.setAddress(rs.getString("address"));
            bankcard.setDate(rs.getDate("date"));
            bankcard.setUserId(rs.getInt("userId"));
            banklist.add(bankcard);
        }
        // 构造page对象
        page.setResultList(banklist);// 设置每页记录数
        page.setTotalCount(getTotalRole(userId));// 设置总记录數
        return page;
    }

    /**
     * 获取记录数
     *
     * @return
     * @throws Exception
     */
    private Long getTotalRole(Integer userid) throws Exception {
        String sql = "select count(1) from Bankcard WHERE userid=? ";
        ResultSet rs = super.query(sql, new Object[]{userid});
        // 循环遍历，构建数据集合
        Long total = 0l;
        while (rs.next()) {
            total = rs.getLong(1);
        }
        return total;
    }

}
