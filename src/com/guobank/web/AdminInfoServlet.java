package com.guobank.web;

import com.guobank.entity.AdminInfo;
import com.guobank.service.AdminInfoService;
import com.guobank.service.impl.AdminInfoSerciceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: guoBank
 * @Package ${PACKAGE_NAME}
 * @Descriptio /**
 * @Project: guoBank
 * @Package ${PACKAGE_NAME}
 * @Description: TODO
 * @date Date : 2019年12月26日 9:22
 */
public class AdminInfoServlet extends HttpServlet {
    private AdminInfoService adminInfoService = new AdminInfoSerciceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            if("checkEmail".equals(request.getParameter("action"))){
                response.getWriter().print(adminInfoService.checkEmail(request.getParameter("email")));
            }else if("register".equals(request.getParameter("action"))){
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                //解析request，将form表单的各个字段封装为FileItem对象
              List<FileItem> fileItems = upload.parseRequest(request);
                AdminInfo adminInfo = new AdminInfo();
              for (FileItem fileItem:fileItems){
                  //不是文件类型
                  if(fileItem.isFormField()){
                          Field field = AdminInfo.class.getDeclaredField(fileItem.getFieldName());
                          field.setAccessible(true);
                          field.set(adminInfo,fileItem.getString());
                  }else{
                      //是文件类型
                        adminInfo.setAdminPortrait(fileItem.getInputStream());
                  }
              }
              response.getWriter().println(adminInfoService.adminRegister(adminInfo));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
