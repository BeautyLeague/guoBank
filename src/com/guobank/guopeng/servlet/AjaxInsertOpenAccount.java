package com.guobank.guopeng.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.guobank.guopeng.service.IOpenAccountService;
import com.guobank.guopeng.service.impl.OpenAccountService;
import com.guobank.wanzehao.entity.UserInfo;


public class AjaxInsertOpenAccount extends HttpServlet {
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
		 int code = ((int) ((Math.random() * 9 + 1) * 100000));
		 int Code = ((int) ((Math.random() * 9 + 1) * 100000));
		 String bankCardId="642888"+code+Code;//银行卡号


		 String address=request.getParameter("address");
		 double monery=Double.parseDouble(request.getParameter("monery"));
		 int password=Integer.parseInt(request.getParameter("password"));
		String phone = request.getParameter("phone");
		int cardTypeId=Integer.parseInt(request.getParameter("cardTypeId"));
		 System.out.println(bankCardId+","+address+","+password+","+monery+","+cardTypeId);
		// String result="";
		 String id="";

		try {
			UserInfo user = (UserInfo) request.getSession().getAttribute("user");
			Integer userId=	user.getUserId();
			System.out.println(userId);
			String type = iOpenAccountService.InsertOpenAccount(bankCardId, cardTypeId, userId, monery, password, address, phone);
			if (type=="开户成功"){
				id=bankCardId;
			}else{
				id=type;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		String CardId=JSON.toJSONString(id);
		response.getWriter().write(CardId);
	}
}
