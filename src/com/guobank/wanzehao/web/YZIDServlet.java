package com.guobank.wanzehao.web;

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
@WebServlet(name = "YZIDServlet")
public class YZIDServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result="";
        response.setCharacterEncoding("UTF-8");
        try {
            UserInfo userInfo = (UserInfo)request.getSession().getAttribute("user");
            String Id = request.getParameter("cardId");
            if(Id.equals(userInfo.getId())){
                result="true";
            }else{
                result="false";
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
