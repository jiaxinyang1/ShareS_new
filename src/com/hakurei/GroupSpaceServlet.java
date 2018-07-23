package com.hakurei;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GroupSpaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          System.out.println("GroupSpacedoGet");
        //  if(request.getSession().getAttribute("username")!=null)
        request.getRequestDispatcher("GroupSpace.jsp").forward(request, response);
         // else request.getRequestDispatcher("ShareSpace0.jsp").forward(request, response);

    }
}
