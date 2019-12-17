package com.guobank.web;



import com.guobank.service.ItransService;
import com.guobank.service.impl.TransService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    private ItransService itransService = new TransService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        try{
            String ka=request.getParameter("ka");
            Float money=new Float(request.getParameter("money"));
            String card=request.getParameter("card");
            String transInfos=request.getParameter("transInfos");
            itransService.Add(ka,card, money, transInfos);
            response.getWriter().write("添加转账记录成功！");
        }catch (Exception e){
            response.getWriter().write(e.getMessage());
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
