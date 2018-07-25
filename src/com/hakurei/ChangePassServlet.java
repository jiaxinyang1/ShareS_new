package com.hakurei;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user=(String )request.getSession().getAttribute("user");


        //修改密码
            String oldPassword =request.getParameter("pass0");
            String newPassword =request.getParameter("pass1");
            User userBuffer = new User();

            for (int i=0;i<DataManage.userData.getList().size();i++)
            {
                if (user.equals(DataManage.userData.getList().get(i).getEmail()))
                {
                    userBuffer.setUserName(DataManage.userData.getList().get(i).getUserName());
                    userBuffer.setEmail(DataManage.userData.getList().get(i).getEmail());
                    userBuffer.setName(DataManage.userData.getList().get(i).getName());
                    userBuffer.setPhoneNumber(DataManage.userData.getList().get(i).getPhoneNumber());
                    userBuffer.setAuthority(DataManage.userData.getList().get(i).getAuthority());
                    userBuffer.setLevel(DataManage.userData.getList().get(i).getLevel());
                    userBuffer.setCredit(DataManage.userData.getList().get(i).getCredit());
                    userBuffer.setPassword(newPassword);
                    DataManage.userData.Delete(DataManage.userData.getList().get(i));
                    DataManage.userData.Insert(userBuffer);
                }
            }
        DataManage.userData.getList().clear();
        DataManage.userData.Find();
        request.getRequestDispatcher("ShareSpace1.jsp").forward(request,response);
    }



}
