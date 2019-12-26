package com.guobank.web;

import com.guobank.service.ILoseService;
import com.guobank.service.impl.LoseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoseServlet")
public class LoseServlet extends HttpServlet {
    private ILoseService loseService = new LoseService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        try {
            String bankcardId = request.getParameter("bankcardId");
            loseService.Lose(bankcardId);
            response.getWriter().write("冻结成功");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
