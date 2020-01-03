package com.guobank.guopeng.servlet;

import com.guobank.guopeng.service.IOpenAccountService;
import com.guobank.guopeng.service.impl.OpenAccountService;
import com.guobank.wanzehao.entity.UserInfo;

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
		String phone = request.getParameter("phone");
		System.out.println(phone);
		 String result="";
		 try {
			 UserInfo user = (UserInfo) request.getSession().getAttribute("user");
			 Integer userId=	user.getUserId();
			 String type = iOpenAccountService.DeleteBankCardId(userName, bankCardId, phone, userId);
			 if (type=="销户成功"){
				 result="销户成功";
			 }else if(type=="电话号码不一致"){
				 result="电话号码不一致";
			 }else if(type=="没有此用户，请重新输入。"){
				 result="没有此用户，请重新输入。";
			 }else{
				 result="没有该银行卡请重新输入卡号";
			 }

		} catch (Exception e) {
			e.printStackTrace();
			result="销户失败";
		}
		 response.getWriter().write(result);
	}
}
