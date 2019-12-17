package com.guobank.liukongfu.web;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.guobank.liukongfu.entity.LoanInfo;
import com.guobank.wanzehao.entity.UserInfo;
import com.guobank.liukongfu.service.ILoanInfoService;
import com.guobank.liukongfu.service.impl.LoanInfoService;


public class QueryLoanInfoServlet extends HttpServlet {

	private ILoanInfoService iLoanInfoService = new LoanInfoService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setContentType("text/html;charset=utf-8");
		try {
			UserInfo user = (UserInfo)request.getSession().getAttribute("user");
			System.out.println(user);
			System.out.println(user.getId());
			String userid =user.getUserId().toString();
			List<LoanInfo> loanInfos = iLoanInfoService.queryLoanInfos(userid);
			String result = JSON.toJSONStringWithDateFormat(loanInfos,"yyyy-MM-dd");
			response.getWriter().write(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
