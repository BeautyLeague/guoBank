package com.guobank.web;



import com.guobank.service.ItransService;
import com.guobank.service.impl.TransService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TransMoneyServlet")
public class TransMoneyServlet extends HttpServlet {
    private ItransService itransService = new TransService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        try {
            String ka = request.getParameter("ka");
            String card = request.getParameter("card");
            Integer pass = new Integer(request.getParameter("pwd"));
            Float money = new Float(request.getParameter("money"));
            itransService.update(money, ka, pass, card);
            response.getWriter().write("转账成功");
        } catch (Exception e) {

            response.getWriter().write(e.getMessage());
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
