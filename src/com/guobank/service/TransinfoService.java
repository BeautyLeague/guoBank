package com.guobank.service;

import com.guobank.entity.Transinfo;
import com.guobank.util.Page;

import java.sql.SQLException;
import java.util.List;

/**
* @Project: MyBank
* @Package com.guobank.service
* @Descriptio
/**
* @Project: MyBank
* @Package com.guobank.service
* @Description: TODO
* @author : pengliang
* @date Date : 2019年11月19日 8:45
* @version V1.0
*/

public interface TransinfoService{
    Page<Transinfo> queryTransinfo(Integer pageNo,Integer userId)throws SQLException;
    Page<Transinfo> queryTransinfoByType(String typeName,Integer pageNo,Integer userId)throws SQLException;
    Page<Transinfo> queryTransinfoByDate(String startDate,String endDate,Integer pageNo,Integer userId)throws SQLException;
    List<String[]> queryStatisticsWithin3Months()throws SQLException;
    List<String[]> queryUserInformationWithin3Months()throws SQLException;
    void addTransInfo(Transinfo transinfo)throws SQLException;
}
