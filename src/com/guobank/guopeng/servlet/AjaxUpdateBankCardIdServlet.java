package com.guobank.guopeng.servlet;

import com.guobank.guopeng.service.IOpenAccountService;
import com.guobank.guopeng.service.impl.OpenAccountService;
import com.guobank.wanzehao.entity.UserInfo;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AjaxUpdateBankCardIdServlet extends HttpServlet {
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
		String phone = request.getParameter("phone");
		 String result="";
		 try {
			 UserInfo user = (UserInfo) request.getSession().getAttribute("user");
			 Integer userId=	user.getUserId();
			 String updateBankCardId = iOpenAccountService.UpdateBankCardId(bankCardId,phone,userId);
			 if (updateBankCardId=="电话号码不一致") {
				 result="电话号码不一致";
			 }
			 else if (updateBankCardId=="挂失成功") {
				 result="挂失成功";
			 }
			 else{
				 result="银行卡已挂失";
			 }
		} catch (Exception e) {
			e.printStackTrace();
			result="没有此银行卡号请重新输入";
		}
		 response.getWriter().write(result);
	}
}
