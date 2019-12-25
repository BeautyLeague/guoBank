package com.guobank.dao;

import com.guobank.entity.Transinfo;
import com.guobank.util.Page;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: MyBank
 * @Package com.guobank.dao
 * @Descriptio /**
 * @Project: MyBank
 * @Package com.guobank.dao
 * @Description: TODO
 * @date Date : 2019年11月19日 8:51
 */
public interface TransinfoDao {
    Page<Transinfo> queryTransinfo(Integer pageNo)throws SQLException;
    Page<Transinfo> queryTransinfoByType(String typeName,Integer pageNo)throws SQLException;
    Page<Transinfo> queryTransinfoByDate(String startDate,String endDate,Integer pageNo)throws SQLException;

    List<String[]> queryStatisticsWithin3Months()throws SQLException;
    List<String[]> queryUserInformationWithin3Months()throws SQLException;





    void addTransInfo(Transinfo transinfo)throws SQLException;
}
