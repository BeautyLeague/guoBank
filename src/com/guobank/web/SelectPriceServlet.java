package com.guobank.web;



import com.guobank.entity.Bankcard;
import com.guobank.service.ISelectService;
import com.guobank.service.impl.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "SelectServlet")
public class SelectPriceServlet extends HttpServlet {
    private ISelectService iSelectService=new SelectService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try{
        String bankId=request.getParameter("card");
            Bankcard bankCard =  iSelectService.SelectPrice(bankId,0);
            response.getWriter().write(bankCard.getMoney()+"");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
