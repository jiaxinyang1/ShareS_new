package com.hakurei;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileListServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.service(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uesr=(String)request.getSession().getAttribute("user");
        List user_list =new ArrayList<FileList>();
        for (int i=0;i<DataManage.fileData.getList().size();i++)
        {
            if (uesr.equals(DataManage.fileData.getList().get(i).getUploader()))
                user_list.add(DataManage.fileData.getList().get(i));
        }
        String str= "{\"code\": 0,\"msg\": \"\",\"count\": 1000,\"data\":";
        str+=JSONArray.fromObject(user_list);
        str+="}";
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(str);


    }
}
