package com.guobank.wanzehao.web;

import com.guobank.wanzehao.dao.IUserInfoDao;
import com.guobank.wanzehao.dao.impl.UserInfoDao;
import com.guobank.wanzehao.service.IUserInfoService;
import com.guobank.wanzehao.service.impl.UserInfoService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AjaxGetPwdServlet extends HttpServlet {

	private IUserInfoDao iUserInfoDao = new UserInfoDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           String result ="";
		try {
			String pho = request.getParameter("pho");
			iUserInfoDao.updatePass(pho);
			result ="密码已经重置为'123456',请尽快登录修改密码！";
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
