package com.guobank.web;

import com.alibaba.fastjson.JSON;
import com.guobank.entity.User;
import com.guobank.service.IBackstageService;
import com.guobank.service.impl.BackstageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BackstageServlet")
public class BackstageServlet extends HttpServlet {
    private IBackstageService backstageService = new BackstageService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
                try {
                   List<User> user = backstageService.query();
                    response.getWriter().print(JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd"));

                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
