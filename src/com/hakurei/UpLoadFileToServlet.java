package com.hakurei;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpLoadFileToServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String fileNumber=request.getParameter("file_data");
        String GroupNumber=(String) request.getSession().getAttribute("checkGroupId");
        GroupFile newGroupFile = new GroupFile();
        newGroupFile.setGroupId(GroupNumber);
        newGroupFile.setGroupFileNumber(fileNumber);

        DataManage.groupFile.Insert(newGroupFile);
        DataManage.groupFile.getList().clear();
        DataManage.groupFile.Find();

        request.getRequestDispatcher("GroupSpace.jsp").forward(request,response);

    }
}
