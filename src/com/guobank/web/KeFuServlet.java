package com.guobank.web;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: webSocket
 * @Package ${PACKAGE_NAME}
 * @Descriptio /**
 * @Project: webSocket
 * @Package ${PACKAGE_NAME}
 * @Description: TODO
 * @date Date : 2020年02月16日 21:15
 */
@WebServlet(name = "KeFuServlet")
public class KeFuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        if("getAllUserRequest".equals(request.getParameter("action"))){
            response.getWriter().write(JSON.toJSONStringWithDateFormat(KeFuWebSocket.requests,"YYYY年MM月dd日 HH:mm:ss"));
        }
    }
}
