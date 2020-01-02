package com.guobank.dao.impl;

import com.guobank.dao.BaseDao;
import com.guobank.dao.TransinfoDao;
import com.guobank.entity.Trandstype;
import com.guobank.entity.Transinfo;
import com.guobank.util.Page;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: MyBank
 * @Package com.guobank.dao.impl
 * @Descriptio /**
 * @Project: MyBank
 * @Package com.guobank.dao.impl
 * @Description: TODO
 * @date Date : 2019年11月19日 8:51
 */
public class TransinfoDaoImpl extends BaseDao implements TransinfoDao {
    private Page<Transinfo> transinfoPage = new Page<>();

    @Override
    public Page<Transinfo> queryTransinfo(Integer pageNo,Integer userId) throws SQLException {
        transinfoPage.setPageNo(pageNo);
        String sql = "SELECT tinfo.*,ttype.typeName FROM `transinfo` as tinfo inner JOIN trandstype as ttype on tinfo.typeId=ttype.typeId  where bankcardid in (SELECT bankcard.bankcardid FROM bankcard  inner JOIN userinfo on bankcard.userId = userinfo.userId where userinfo.userid = ?)   ORDER BY tinfo.trandsDate desc limit " + ((transinfoPage.getPageNo() - 1) * transinfoPage.getPageCount()) + "," + (transinfoPage.getPageCount());
        System.out.println(sql);
        String sqlCount = "SELECT count(1) as count FROM `transinfo` as tinfo inner JOIN trandstype as ttype on tinfo.typeId=ttype.typeId  where bankcardid in (SELECT bankcard.bankcardid FROM bankcard  inner JOIN userinfo on bankcard.userId = userinfo.userId where userinfo.userid = ?) ";
        ResultSet rs = super.query(sql,new Object[]{userId});

        try {
            transinfoPage.setTotalCount(queryCount(super.query(sqlCount, new Object[]{userId})));
            add(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transinfoPage;
    }


    @Override
    public Page<Transinfo> queryTransinfoByType(String typeName, Integer pageNo,Integer userId) throws SQLException {
        transinfoPage.setPageNo(pageNo);
        String sql = "SELECT tinfo.*,ttype.typeName FROM `transinfo` as tinfo inner JOIN trandstype as ttype on tinfo.typeId=ttype.typeId where typeName= ?  and  bankcardid in (SELECT bankcard.bankcardid FROM bankcard  inner JOIN userinfo on bankcard.userId = userinfo.userId where userinfo.userid = ?)  ORDER BY tinfo.trandsDate desc limit " + ((transinfoPage.getPageNo() - 1) * transinfoPage.getPageCount()) + "," + (transinfoPage.getPageCount());
        String sqlCount = "SELECT count(1) as count FROM `transinfo` as tinfo inner JOIN trandstype as ttype on tinfo.typeId=ttype.typeId where typeName= ? and  bankcardid in (SELECT bankcard.bankcardid FROM bankcard  inner JOIN userinfo on bankcard.userId = userinfo.userId where userinfo.userid = ?) ";
        ResultSet rs = super.query(sql, new Object[]{typeName,userId});
        try {
            transinfoPage.setTotalCount(queryCount(super.query(sqlCount, new Object[]{typeName,userId})));
            add(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transinfoPage;
    }

    @Override
    public Page<Transinfo> queryTransinfoByDate(String startDate, String endDate, Integer pageNo,Integer userId) throws SQLException {
        transinfoPage.setPageNo(pageNo);
        String sql = "SELECT tinfo.*,ttype.typeName FROM `transinfo` as tinfo inner JOIN trandstype as ttype on tinfo.typeId=ttype.typeId where trandsDate>= ? and trandsDate<= ? and  bankcardid in (SELECT bankcard.bankcardid FROM bankcard  inner JOIN userinfo on bankcard.userId = userinfo.userId where userinfo.userid = ?)  ORDER BY tinfo.trandsDate desc limit " + ((transinfoPage.getPageNo() - 1) * transinfoPage.getPageCount()) + "," + (transinfoPage.getPageCount());
        String sqlCount = "SELECT count(1) as count FROM `transinfo` as tinfo inner JOIN trandstype as ttype on tinfo.typeId=ttype.typeId where trandsDate>= ? and trandsDate<= ? and  bankcardid in (SELECT bankcard.bankcardid FROM bankcard  inner JOIN userinfo on bankcard.userId = userinfo.userId where userinfo.userid = ?) ";
        ResultSet rs = super.query(sql, new Object[]{startDate, endDate,userId});
        List<Transinfo> transinfos = null;
        System.out.println(startDate);
        System.out.println(endDate);
        try {
            transinfoPage.setTotalCount(queryCount(super.query(sqlCount, new Object[]{startDate, endDate,userId})));
            add(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transinfoPage;
    }


    private void add(ResultSet rs) throws Exception {
        List<Transinfo> transinfos = new ArrayList<>();
        while (rs.next()) {
            Transinfo transinfo = new Transinfo();
            Trandstype trandstype = new Trandstype();
            for (Field field : Transinfo.class.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.getType() == Trandstype.class) {
                    for (Field field1 : Trandstype.class.getDeclaredFields()) {
                        field1.setAccessible(true);
                        field1.set(trandstype, rs.getObject(field1.getName()));
                    }
                    field.set(transinfo, trandstype);
                } else {
                    field.set(transinfo, rs.getObject(field.getName()));
                }


            }
            transinfos.add(transinfo);
        }
        transinfoPage.setResultList(transinfos);
    }


    private Integer queryCount(ResultSet rs)throws Exception{
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }


    @Override
    public void addTransInfo(Transinfo transinfo) throws SQLException {
        String sql = "insert into transinfo values(default,(select typeid from trandstype where typeName = ?),?,now(),?,?)";
        super.execute(sql,new Object[]{transinfo.getTrandstype().getTypeName(),transinfo.getBankcardid(),transinfo.getTrandsmoney(),transinfo.getTrandsinfos()});
    }


    @Override
    public List<String[]> queryStatisticsWithin3Months() throws SQLException {
        String sql = "select td.typeName,sum(trandsmoney) as sumMoney ,MONTH(trandsDate) as month from transinfo as ti,trandstype as td where td.typeId = ti.typeId and  td.typeid in(1,2,4) and date_format(ti.trandsDate,'%y-%m') > date_format(DATE_SUB(CURDATE(), INTERVAL 3 MONTH),'%y-%m') GROUP BY DATE_FORMAT(trandsDate,'%Y%m'),td.typeid ORDER BY td.typeid,trandsDate\n";
        ResultSet rs = super.executeQuery(sql,null);
        List<String[]> stringList = new ArrayList<>();
        while (rs.next()){
            String[] strings = new String[3];
            strings[0] = rs.getString("typeName");
            strings[1] = rs.getString("sumMoney");
            strings[2] = rs.getString("month");

            stringList.add(strings);
        }
        return stringList;
    }

    @Override
    public List<String[]> queryUserInformationWithin3Months() throws SQLException {
        String sql = "select rt.TypeName as typename ,count(1) as count ,MONTH(r.RecordDate) as month from record as r,recordtype  as rt where r.RecordTypeId = rt.RecordTypeId and rt.RecordTypeId in(1,2,3) and date_format(r.RecordDate,'%y-%m') > date_format(DATE_SUB(CURDATE(), INTERVAL 3 MONTH),'%y-%m') GROUP BY DATE_FORMAT(r.RecordDate,'%Y%m') , rt.RecordTypeId ORDER BY rt.RecordTypeId , r.RecordDate";
        ResultSet rs = super.executeQuery(sql,null);
        
        List<String[]> stringList = new ArrayList<>();
        while (rs.next()){
            String[] strings = new String[3];
            strings[0] = rs.getString("typename");
            strings[1] = rs.getString("count");
            strings[2] = rs.getString("month");
            stringList.add(strings);
        }
        return stringList;
    }
}
