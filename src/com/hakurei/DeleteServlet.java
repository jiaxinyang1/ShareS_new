package com.hakurei;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO Auto-generated method stub
        String fileNumber =(String) request.getParameter("fileNumber");
        System.out.println(fileNumber);

        for (int i=0;i<DataManage.fileData.getList().size();i++)
        {
            if (fileNumber.equals(DataManage.fileData.getList().get(i).getFileNo()))
            {
                DataManage.fileData.Delete(DataManage.fileData.getList().get(i));

            }
        }

    }
}
