package com.hakurei;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class ChangeNiceNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type =request.getParameter("type");
        String user=(String )request.getSession().getAttribute("user");
        String newName= request.getParameter("newusername");
        User userBuffer = new User();

            for (int i=0;i<DataManage.userData.getList().size();i++)
            {
                if (user.equals(DataManage.userData.getList().get(i).getEmail()))
                {
                    userBuffer.setUserName(DataManage.userData.getList().get(i).getUserName());
                    userBuffer.setEmail(DataManage.userData.getList().get(i).getEmail());
                    userBuffer.setPhoneNumber(DataManage.userData.getList().get(i).getPhoneNumber());
                    userBuffer.setAuthority(DataManage.userData.getList().get(i).getAuthority());
                    userBuffer.setLevel(DataManage.userData.getList().get(i).getLevel());
                    userBuffer.setCredit(DataManage.userData.getList().get(i).getCredit());
                    userBuffer.setPassword(DataManage.userData.getList().get(i).getPassword());
                    userBuffer.setName(newName);
                    DataManage.userData.Delete(DataManage.userData.getList().get(i));
                    DataManage.userData.Insert(userBuffer);
                }
            }

            request.getSession().setAttribute("nickname",newName);
            request.getRequestDispatcher("ShareSpace1.jsp").forward(request,response);


    }
}
