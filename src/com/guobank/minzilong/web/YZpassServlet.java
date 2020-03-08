package com.guobank.minzilong.web;

import com.guobank.liukongfu.service.ILoanInfoService;
import com.guobank.liukongfu.service.impl.LoanInfoService;
import com.guobank.wanzehao.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *验证支付密码
 */
@WebServlet(name = "YZpassServlet")
public class YZpassServlet extends HttpServlet {
    private ILoanInfoService iLoanInfoService = new LoanInfoService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result="";
        try {
            UserInfo user=(UserInfo)request.getSession().getAttribute("user");
            String userid = user.getUserId().toString();
            String cardid = request.getParameter("bank");
            String pwd =request.getParameter("pass");
            result = iLoanInfoService.isPwd(cardid, pwd, userid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(result);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
