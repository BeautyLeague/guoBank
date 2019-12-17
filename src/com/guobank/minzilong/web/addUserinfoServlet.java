package com.guobank.minzilong.web;

import com.guobank.minzilong.entity.Userinfo;
import com.guobank.minzilong.service.IUserinfoService;
import com.guobank.minzilong.service.impl.UserinfoServlce;

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
	      try {
	      	   System.out.println(1);
	    	  request.setCharacterEncoding("utf-8");
	          String userName=request.getParameter("userName");
	          String sex=request.getParameter("sex");
	          Integer age=new Integer(request.getParameter("age"));
	          System.out.println(request.getParameter("leven"));
	          System.out.println(request.getParameter("leven"));
	          Integer leven=new Integer(request.getParameter("leven"));
	          String pho=request.getParameter("pho");
	          String id=request.getParameter("id");
	          String bornDate=request.getParameter("bornDate");
	       
		
	       Date date = java.sql.Date.valueOf(bornDate);
	       Userinfo userinfo=new Userinfo();
	       userinfo.setUserName(userName);
	       userinfo.setSex(sex);
	       userinfo.setAge(age);
	       userinfo.setLeven(leven);
	       userinfo.setPho(pho);
	       userinfo.setId(id);
	       userinfo.setBornDate(date);
	       
	       System.out.println(userinfo);
	     
			this.iUserinfoService.addUserinfoService(userinfo);
			request.getSession().setAttribute("user",userinfo);
			request.getRequestDispatcher("/wanzehao/index.jsp").forward(request, response);
	 }catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		request.setAttribute("message","修改失败！");
		request.getRequestDispatcher("/minzilong/userinfo.jsp").forward(request, response);
	 }
}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
			}

}
