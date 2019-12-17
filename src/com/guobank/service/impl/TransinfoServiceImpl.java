package com.guobank.service.impl;


import com.guobank.dao.TransinfoDao;
import com.guobank.dao.impl.TransinfoDaoImpl;
import com.guobank.entity.Transinfo;
import com.guobank.service.TransinfoService;
import com.guobank.util.Page;

import java.sql.SQLException;
import java.util.List;

/**
* @Project: MyBank
* @Package com.guobank.service.impl
* @Descriptio
/**
* @Project: MyBank
* @Package com.guobank.service.impl
* @Description: TODO
* @author : pengliang
* @date Date : 2019年11月19日 8:45
* @version V1.0
*/

public class TransinfoServiceImpl implements TransinfoService{

   private TransinfoDao transinfoDao = new TransinfoDaoImpl();
    @Override
    public Page<Transinfo> queryTransinfo(Integer pageNo) throws SQLException {
        return transinfoDao.queryTransinfo(pageNo);
    }


    @Override
    public Page<Transinfo> queryTransinfoByType(String typeName,Integer pageNo) throws SQLException {
        return transinfoDao.queryTransinfoByType(typeName,pageNo);
    }

    @Override
    public Page<Transinfo> queryTransinfoByDate(String startDate, String endDate,Integer pageNo) throws SQLException {
        return transinfoDao.queryTransinfoByDate(startDate,endDate,pageNo);

    }


    @Override
    public void addTransInfo(Transinfo transinfo) throws SQLException {
        transinfoDao.addTransInfo(transinfo);
    }
}
