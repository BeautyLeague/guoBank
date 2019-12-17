package com.guobank.web;

import com.alibaba.fastjson.JSON;
import com.guobank.entity.Trandstype;
import com.guobank.entity.Transinfo;
import com.guobank.service.TransinfoService;
import com.guobank.service.impl.TransinfoServiceImpl;
import com.guobank.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: MyBank
 * @Package ${PACKAGE_NAME}
 * @Descriptio /**
 * @Project: MyBank
 * @Package ${PACKAGE_NAME}
 * @Description: TODO
 * @date Date : 2019年11月19日 9:07
 */
public class TransinfoServlet extends HttpServlet {
    private TransinfoService transinfoService = new TransinfoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Integer pageNo = request.getParameter("pageNo")==null?1:Integer.valueOf(request.getParameter("pageNo"));
        if("query".equals(request.getParameter("action")) ){
            try {
                Page<Transinfo> transinfoList = transinfoService.queryTransinfo(pageNo);
                response.getWriter().write(JSON.toJSONStringWithDateFormat(transinfoList,"YYYY年MM月dd日 HH点mm分ss秒"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if("queryByType".equals(request.getParameter("action"))){
            String typeName = request.getParameter("typeName");
            try {
                Page<Transinfo> transinfoList = transinfoService.queryTransinfoByType(typeName,pageNo);
                response.getWriter().write(JSON.toJSONStringWithDateFormat(transinfoList,"YYYY年MM月dd日 HH点mm分ss秒"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if("queryByDate".equals(request.getParameter("action"))){
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            startDate+=" 00:00:00";
            endDate+=" 23:59:59";
            try {
                Page<Transinfo> transinfoList = transinfoService.queryTransinfoByDate(startDate,endDate,pageNo);
                response.getWriter().write(JSON.toJSONStringWithDateFormat(transinfoList,"YYYY年MM月dd日 HH点mm分ss秒"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if("addTransInfo".equals(request.getParameter("action"))){
            Transinfo transinfo = new Transinfo();
            transinfo.setTrandstype(new Trandstype(){{setTypeName(request.getParameter("typeName"));}});
            transinfo.setBankcardid(request.getParameter("bankcardId"));
            transinfo.setTrandsmoney(Float.valueOf(request.getParameter("money")));
            transinfo.setTrandsinfos(request.getParameter("trandsInfo"));
            System.out.println(transinfo);
            try {
                transinfoService.addTransInfo(transinfo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
