package com.guobank.minzilong.web;

import com.guobank.liukongfu.service.ILoanInfoService;
import com.guobank.liukongfu.service.impl.LoanInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
@WebServlet(name = "UpdateMoneyServlet")
public class UpdateMoneyServlet extends HttpServlet {
    ILoanInfoService iLoanInfoService = new LoanInfoService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result="";
        try {
            String cardid = request.getParameter("bank");
            double money = Double.valueOf(request.getParameter("money"));
            result = iLoanInfoService.getMoney(cardid, money);
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
