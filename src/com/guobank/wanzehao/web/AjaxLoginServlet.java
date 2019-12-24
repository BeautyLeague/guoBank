package com.guobank.wanzehao.web;

import com.guobank.wanzehao.entity.UserInfo;
import com.guobank.wanzehao.service.IUserInfoService;
import com.guobank.wanzehao.service.impl.UserInfoService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AjaxLoginServlet extends HttpServlet {

    private IUserInfoService iUserInfoService = new UserInfoService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String load = request.getParameter("username");
		String pwd = request.getParameter("password");
		System.out.println(load);
		System.out.println(pwd);
		String result=null;
		try {
			String uname = iUserInfoService.is_Load(load, pwd);
			UserInfo userInfo = new UserInfo();
			userInfo=iUserInfoService.queryUserInfo(load);
			result="登录成功";
			
			request.getSession().setAttribute("uname", uname);
			request.getSession().setAttribute("user", userInfo);
		} catch (Exception e) {
			result=e.getMessage();
			e.printStackTrace();
			
		}finally{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			System.out.println(result);
			out.write(result);
			out.close();
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
