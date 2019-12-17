package com.guobank.liukongfu.web;

import com.guobank.wanzehao.entity.UserInfo;
import com.guobank.liukongfu.service.ILoanInfoService;
import com.guobank.liukongfu.service.impl.LoanInfoService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class IsPassServlet extends HttpServlet {

	private ILoanInfoService iLoanInfoService = new LoanInfoService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result="";
		try {
			UserInfo user=(UserInfo)request.getSession().getAttribute("user");
			String userid = user.getUserId().toString();
			String cardid = request.getParameter("cardid");
			String pwd = request.getParameter("pwd");
			result = iLoanInfoService.isPwd(cardid, pwd, userid);
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
