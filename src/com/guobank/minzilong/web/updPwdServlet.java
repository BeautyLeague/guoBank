package com.guobank.minzilong.web;

import com.guobank.minzilong.service.IUserinfoService;
import com.guobank.minzilong.service.impl.UserinfoServlce;
import com.guobank.wanzehao.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updPwdServlet")
public class updPwdServlet extends HttpServlet {
    private IUserinfoService iUserinfoService=new UserinfoServlce();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pwd2=request.getParameter("pwd2");
        String pho=request.getParameter("pho");
        UserInfo userInfo=new UserInfo();
        userInfo.setPwd(pwd2);
        userInfo.setPho(pho);
        try{
            this.iUserinfoService.updepwd(userInfo);
            request.getSession().removeAttribute("uname");
            request.setAttribute("message","修改成功！请重新登录！");
            request.getRequestDispatcher("/wanzehao/index.jsp").forward(request, response);
            //response.sendRedirect("/mingzilongqueryUserinfoServlet");
           // request.getRequestDispatcher("/minzilong/pass.jsp").forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
