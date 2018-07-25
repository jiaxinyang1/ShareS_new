package com.hakurei;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class UpLoadFileToServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String fileNumber=request.getParameter("data");
        String GroupNumber=(String) request.getSession().getAttribute("checkGroupId");
        JSONArray array =JSONArray.fromObject(fileNumber);
        List<FileList> lsit_buffer =JSONArray.toList(array,new FileList(),new JsonConfig());

        for (int i=0;i<lsit_buffer.size();i++)
        {
            GroupFile newGroupFile = new GroupFile();
            newGroupFile.setGroupId(GroupNumber);
            newGroupFile.setGroupFileNumber(lsit_buffer.get(i).getFileNo());

            DataManage.groupFile.Insert(newGroupFile);

        }
        DataManage.groupFile.getList().clear();
        DataManage.groupFile.Find();

        request.getRequestDispatcher("GroupSpace.jsp").forward(request,response);

    }
}
