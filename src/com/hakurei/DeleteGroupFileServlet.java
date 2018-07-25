package com.hakurei;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteGroupFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO Auto-generated method stub
        String fileNumber =(String) request.getParameter("fileNumber");
        String GroupNumber=(String) request.getSession().getAttribute("checkGroupId");

        for (int i=0;i<DataManage.groupFile.getList().size();i++)
        {
            if ((fileNumber.equals(DataManage.groupFile.getList().get(i).getGroupFileNumber()))&&(GroupNumber.equals(DataManage.groupFile.getList().get(i).getGroupId())))
            {

                DataManage.groupFile.Delete(DataManage.groupFile.getList().get(i));

            }
        }

        request.getRequestDispatcher("GroupSpace.jsp").forward(request,response);

    }
}
