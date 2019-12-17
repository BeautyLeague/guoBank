package com.guobank.liukongfu.web;

import com.guobank.liukongfu.service.ILoanInfoService;
import com.guobank.liukongfu.service.impl.LoanInfoService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MoneyServlet extends HttpServlet {

	ILoanInfoService iLoanInfoService = new LoanInfoService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String result="";
		try {
			String cardid = request.getParameter("cards");
			double money = Double.valueOf(request.getParameter("money"));
			result = iLoanInfoService.getMoney(cardid, money);
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
