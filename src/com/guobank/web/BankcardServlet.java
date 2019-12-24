package com.guobank.web;

import com.guobank.dao.BankcardDao;
import com.guobank.entity.Bankcard;
import com.guobank.service.impl.BankcardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: MyBank
 * @Package ${PACKAGE_NAME}
 * @Descriptio /**
 * @Project: MyBank
 * @Package ${PACKAGE_NAME}
 * @Description: TODO
 * @date Date : 2019年11月08日 14:41
 */
public class BankcardServlet extends HttpServlet {
   private BankcardServiceImpl bankcardService = new BankcardServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //判断卡号是否存在
        if ("inspectBankcardId".equals(request.getParameter("action"))) {
            try {

                Bankcard bankcard = bankcardService.getBankcardById(request.getParameter("bankCardId"));
                if (bankcard== null) {
                    response.getWriter().write("该卡号不存在");
                } else if(bankcard.getIs_Ds()==1){
                    response.getWriter().write("该卡号已挂失");
                } else{
                    response.getWriter().write("true");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //存钱
        } else if ("deposit".equals(request.getParameter("action"))) {
            Bankcard bankcard = new Bankcard();
            bankcard.setBankCardid(request.getParameter("bankcardId"));
            bankcard.setPass(new Integer(request.getParameter("pwd")));
            bankcard.setMoney(new Float(request.getParameter("money")));

            try {
               Bankcard newBankcard =  bankcardService.depositByObject(bankcard);
                response.getWriter().write("存款成功,当前余额为:"+newBankcard.getMoney());
            } catch (Exception e) {
                response.getWriter().write(e.getMessage());
            }
            //取钱
        }else if("takeMoney".equals(request.getParameter("action"))){
            Bankcard bankcard = new Bankcard();
            bankcard.setBankCardid(request.getParameter("bankcardId"));
            bankcard.setPass(new Integer(request.getParameter("pwd")));
            bankcard.setMoney(new Float(request.getParameter("money")));

            try {
                Bankcard newBankcard =  bankcardService.tackMoney(bankcard);
                response.getWriter().write("取款成功,当前余额为:"+newBankcard.getMoney());
            } catch (Exception e) {
                response.getWriter().write(e.getMessage());
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
