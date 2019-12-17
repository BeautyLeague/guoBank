package com.guobank.wanzehao.web;

import com.guobank.wanzehao.service.IUserInfoService;
import com.guobank.wanzehao.service.impl.UserInfoService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AjaxYZPhoServlet extends HttpServlet {

	IUserInfoService iUserInfoService = new UserInfoService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String result="";
		try {
			String pho = request.getParameter("pho");
			
			result = iUserInfoService.yzPho(pho);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(result);
			out.close();
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
