package com.hakurei;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoSearchPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = (String) request.getSession().getAttribute("user");
        String search_content=request.getParameter("title");
        request.getSession().setAttribute("title",search_content);


        if (name!=null)
        {
            request.getRequestDispatcher("ShareSpace1.1.jsp").forward(request,response);
        }
        else
         request.getRequestDispatcher("ShareSpace0.1.jsp").forward(request,response);

    }
}
