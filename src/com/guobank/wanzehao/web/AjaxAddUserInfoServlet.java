package com.guobank.wanzehao.web;

import com.guobank.wanzehao.dao.IUserInfoDao;
import com.guobank.wanzehao.dao.impl.UserInfoDao;
import com.guobank.wanzehao.entity.UserInfo;
import com.guobank.wanzehao.service.IUserInfoService;
import com.guobank.wanzehao.service.impl.UserInfoService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AjaxAddUserInfoServlet extends HttpServlet {

	IUserInfoService iUserInfoService = new UserInfoService();
	IUserInfoDao iUserInfoDao = new UserInfoDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result ="";
		try {
			request.setCharacterEncoding("UTF-8");response.setCharacterEncoding("UTF-8");

			String uname=request.getParameter("uname");
			String cardId = request.getParameter("cardId");
			String pwd = request.getParameter("pwd");
			String pho = request.getParameter("pho");


			UserInfo uInfo = new UserInfo();
			uInfo.setUserName(uname);
			uInfo.setPwd(pwd);
			uInfo.setPho(pho);
			uInfo.setLeven(1);
			uInfo.setId(cardId);
			iUserInfoService.addUserInfo(uInfo);
			iUserInfoDao.addRecord();
			result="注册成功";
		} catch (Exception e) {
			result="注册失败";
			e.printStackTrace();
		}finally{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(result);
			out.close();
		}
	}

}
