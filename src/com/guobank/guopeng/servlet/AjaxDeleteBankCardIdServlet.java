package com.guobank.guopeng.servlet;

import com.guobank.guopeng.service.IOpenAccountService;
import com.guobank.guopeng.service.impl.OpenAccountService;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AjaxDeleteBankCardIdServlet extends HttpServlet {
	private IOpenAccountService iOpenAccountService=new OpenAccountService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 String bankCardId = request.getParameter("bankCardId");
		 String userName=request.getParameter("userName");
		 String result="";
		 try {
			iOpenAccountService.DeleteBankCardId(userName, bankCardId);
			result="销户成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="销户失败";
		}
		 response.getWriter().write(result);
	}
}
