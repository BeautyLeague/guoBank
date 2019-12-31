package com.guobank.web;

import com.guobank.service.ISelectService;
import com.guobank.service.impl.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BankIdsServlet")
public class BankIdsServlet extends HttpServlet {
    private ISelectService iSelectService = new SelectService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String bankid = request.getParameter("card");
            if(iSelectService.SelectBankIDs(bankid)==null ){
                response.getWriter().print("false");
            } else{
                response.getWriter().print("true");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
