package com.guobank.liukongfu.web;

import com.guobank.liukongfu.entity.LoanInfo;
import com.guobank.liukongfu.service.ILoanInfoService;
import com.guobank.liukongfu.service.impl.LoanInfoService;
import com.guobank.wanzehao.entity.UserInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class loanMoneyServlet extends HttpServlet {

	ILoanInfoService iLoanInfoService = new LoanInfoService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String result="";
		try {
			LoanInfo loanInfo = new LoanInfo();
			
			String bankcardId = request.getParameter("bankcardId");
			String money =request.getParameter("money");				
			Integer bankDate = Integer.valueOf(request.getParameter("loadDate"));
			UserInfo user=(UserInfo)request.getSession().getAttribute("user");
			Integer userid =user.getUserId();
			
			loanInfo.setCards(bankcardId);
			loanInfo.setUserId(userid);
			loanInfo.setLoanMoney(Double.valueOf(money));
			loanInfo.setLoanDate(new Date());
			loanInfo.setBackDate(bankDate);
			loanInfo.setThisDate(new Date());
			loanInfo.setIs_loan(0);

			
			result= iLoanInfoService.addLoanInfo(user.getLeven(),loanInfo);
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

		doGet(request, response);

	}

}
