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
 *
 */
@WebServlet(name = "addInfoServlet")
public class addInfoServlet extends HttpServlet {
    private ILoanInfoService iLoanInfoService = new LoanInfoService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result="";
        try {
            String cardid = request.getParameter("bank");
            double money = Double.valueOf(request.getParameter("money"));
            UserInfo userInfo = (UserInfo)request.getSession().getAttribute("user");
            Integer userid=userInfo.getUserId();
            result = iLoanInfoService.shengji(cardid,money,userid);
            userInfo.setLeven(userInfo.getLeven()+1);
            System.out.println(userInfo.getLeven());
            request.getSession().setAttribute("user",userInfo);
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
