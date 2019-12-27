package com.guobank.web;

import com.guobank.service.IAdminLogin;
import com.guobank.service.impl.AdminLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private IAdminLogin adminLogin=new AdminLoginService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            String email=request.getParameter("email");
            String pwd=request.getParameter("pwd");
            adminLogin.Login(email,pwd);
            response.getWriter().write("登录成功");
        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
            response.getWriter().write("账号未激活");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
