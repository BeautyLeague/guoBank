package com.guobank.liukongfu.web;

import com.guobank.liukongfu.dao.IUserInfoDao;
import com.guobank.liukongfu.dao.impl.UserInfoDao;
import com.guobank.wanzehao.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "isGSServlet")
public class isGSServlet extends HttpServlet {
    IUserInfoDao userInfoDao = new UserInfoDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String result="";
        try {
            String cardid = request.getParameter("bankCardId");
            Integer gs=userInfoDao.querygs(cardid);
            if(gs==0){
                result = "true";
            }else{
                result = "false";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(result);
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
