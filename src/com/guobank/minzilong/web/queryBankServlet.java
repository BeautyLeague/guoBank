package com.guobank.minzilong.web;

import com.guobank.minzilong.entity.Bankcard;
import com.guobank.minzilong.service.IBankcardService;
import com.guobank.minzilong.service.impl.BankcardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "queryBankServlet")
public class queryBankServlet extends HttpServlet {
    private IBankcardService iBankcardService=new BankcardService();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        Integer userid=Integer.parseInt(request.getParameter("userId"));
        try {
            List<Bankcard> bankList=this.iBankcardService.queryBanklist(userid);
            request.setAttribute("bankList",bankList);
            request.getRequestDispatcher("/minzilong/account.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
