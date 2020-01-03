package com.guobank.minzilong.web;


import com.guobank.minzilong.service.IUserinfoService;
import com.guobank.minzilong.service.impl.UserinfoServlce;
import com.guobank.wanzehao.entity.UserInfo;

import java.io.IOException;

import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class addUserinfoServlet extends HttpServlet {

	private IUserinfoService iUserinfoService=new UserinfoServlce();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String userName=request.getParameter("userName");
			String sex=request.getParameter("sex");
			Integer age=new Integer(request.getParameter("age"));
			System.out.println(request.getParameter("leven"));
			System.out.println(request.getParameter("leven"));
			Integer leven=new Integer(request.getParameter("leven"));
			String pho=request.getParameter("pho");
			String bornDate=request.getParameter("bornDate");
			Date date = java.sql.Date.valueOf(bornDate);

			UserInfo userInfo1=(UserInfo)request.getSession().getAttribute("user");
			userInfo1.setUserName(userName);
			userInfo1.setSex(sex);
			userInfo1.setAge(age);
			userInfo1.setLeven(leven);
			userInfo1.setPho(pho);
			userInfo1.setBornDate(date);

			UserInfo userinfo=new UserInfo();
			userinfo.setUserName(userName);
			userinfo.setSex(sex);
			userinfo.setAge(age);
			userinfo.setLeven(leven);
			userinfo.setPho(pho);
			userinfo.setBornDate(date);


			this.iUserinfoService.addUserinfoService(userinfo);
			request.getSession().setAttribute("user",userInfo1);
			request.getRequestDispatcher("/mingzilongCloseuserinfoServlet").forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message","修改失败！");
			request.getRequestDispatcher("/minbzilong/userinfo.jsp").forward(request, response);
		}
	}

}
