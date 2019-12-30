package com.guobank.minzilong.web;


import com.guobank.minzilong.entity.Bankcard;
import com.guobank.minzilong.service.IBankcardService;
import com.guobank.minzilong.service.IUserinfoService;
import com.guobank.minzilong.service.impl.BankcardService;
import com.guobank.minzilong.service.impl.UserinfoServlce;
import com.guobank.wanzehao.entity.UserInfo;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.*;

@WebServlet(name = "queryUserServlet")
public class queryUserServlet extends HttpServlet {
    private IUserinfoService iUserinfoService=new UserinfoServlce();
    private IBankcardService iBankcardService=new BankcardService();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            UserInfo userInfo = (UserInfo)request.getSession().getAttribute("user");
            Integer userid=userInfo.getUserId();
            List<Bankcard> bankList=this.iBankcardService.queryBanklist(userid);
            UserInfo userinfo=this.iUserinfoService.querUser(userid);
            request.setAttribute("bankList",bankList);
            request.setAttribute("userinfo",userinfo);
          //response.sendRedirect("/minzilong/userinfo.jsp");
           request.getRequestDispatcher("/minzilong/userinfo.jsp").forward(request,response);
     }catch(Exception e){
            e.printStackTrace();
        }
    }
}
