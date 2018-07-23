package com.hakurei;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    public RegisterServlet()
    {

    }
    @Override
    public void init(){
        DataManage.init();

    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
        req.getRequestDispatcher("ShareSpace0.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("username"));
        User user =new User();
        user.setUserName(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setPhoneNumber(req.getParameter("phone"));
        user.setName(user.getUserName());
        user.setLevel(1);
        user.setAuthority(1);
        user.setCredit(1);
        DataManage.userData.Insert(user);

    }

}
