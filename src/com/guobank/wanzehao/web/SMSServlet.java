package com.guobank.wanzehao.web;

import com.guobank.wanzehao.util.HttpClientUtil;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class SMSServlet extends HttpServlet {
	public String Uid="J饮多佐";
	public String key="d41d8cd98f00b204e980";
	HttpClientUtil httpClientUtil=new HttpClientUtil();//创建对象
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String phone = request.getParameter("phone");
		System.out.println(phone);
		// 生成随机验证码
//		Integer smsCode = ((int) ((Math.random() * 9 + 1) * 100000));
//		String smsText = "验证码：" + smsCode;
		// 调用方法然后强制转换类型
//		Integer result = Integer.parseInt(httpClientUtil.ClientUtil(phone,
//				smsText, Uid, key));
		 Integer result=1;
		 Integer smsCode=123123;
		if (result > 0) {
			System.out.println("成功发送短信");

			// 将验证码响应到客户端
			//String rs = JSON.toJSONString(smsCode);
			response.getWriter().write(smsCode.toString());
		} else {
			response.getWriter().write(result);
			System.out.println("发送失败！" + result);
		}
	}
}
