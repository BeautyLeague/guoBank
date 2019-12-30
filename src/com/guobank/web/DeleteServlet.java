package com.guobank.web;

import com.guobank.service.IAdminLogin;
import com.guobank.service.impl.AdminLoginService;
import com.guobank.util.EmailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private IAdminLogin adminLogin=new AdminLoginService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        try {
            String email = request.getParameter("adminEmail");
            boolean flag = adminLogin.deleteById(email);
            if(!flag){
                new Thread(new EmailUtil(email,"激活失败,有疑问请找郭鹏","郭氏银行: 管理员账户激活信息")).start();
            }
            response.getWriter().print(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
