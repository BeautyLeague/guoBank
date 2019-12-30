package com.guobank.web;

import com.alibaba.fastjson.JSON;
import com.guobank.entity.AdminInfo;
import com.guobank.entity.User;
import com.guobank.service.IAdminLogin;
import com.guobank.service.impl.AdminLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAdminServlet")
public class SelectAdminServlet extends HttpServlet {
    private IAdminLogin adminLogin=new AdminLoginService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        try{
            List<AdminInfo> admin = adminLogin.query();
            response.getWriter().print(JSON.toJSONString(admin));

        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
