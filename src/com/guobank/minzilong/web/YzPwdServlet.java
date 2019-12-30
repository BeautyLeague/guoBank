package com.guobank.minzilong.web;

import com.guobank.wanzehao.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
@WebServlet(name = "YzPwdServlet")
public class YzPwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String result="";
        try {
            String pass = request.getParameter("pwd");
            UserInfo user=(UserInfo)request.getSession().getAttribute("user");
            if(user.getPwd().equals(pass)){
                result="1";
            }else{
                result="0";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(result);
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
