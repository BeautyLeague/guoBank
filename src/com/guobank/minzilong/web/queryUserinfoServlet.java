package com.guobank.minzilong.web;


import com.guobank.minzilong.service.IUserinfoService;
import com.guobank.minzilong.service.impl.UserinfoServlce;
import com.guobank.wanzehao.entity.UserInfo;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class queryUserinfoServlet extends HttpServlet {
  private IUserinfoService iUserinfoService=new UserinfoServlce();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=Utf-8");
//      String username=request.getParameter("name");
//      String sex=request.getParameter("sex");
//      String age=request.getParameter("age");
//      Integer leven=new Integer(request.getParameter("grade"));
//      Integer pho=new Integer(request.getParameter("phone"));
//      String id=request.getParameter("id");
//      String bornDate=request.getParameter("date");
//      SimpleDateFormat mat = new SimpleDateFormat("yyyy-MM-dd");
//      Date md = null;
//		String userId=request.getParameter("userId");
//		Integer iduu=Integer.parseInt(userId);
		
	  try {
	 // request.setAttribute("username", username);
		List<UserInfo> userinfo1=this.iUserinfoService.queryUserinfolisList();

		request.setAttribute("userinfo1",request.getSession().getAttribute("user"));
		UserInfo userInfo;
		userInfo = (UserInfo) request.getSession().getAttribute("user");
		request.setAttribute("userinfo1",userInfo);
		request.getRequestDispatcher("/minzilong/userlist.jsp").forward(request, response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
