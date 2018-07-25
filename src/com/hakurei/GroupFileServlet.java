package com.hakurei;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GroupFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String groupName =request.getParameter("groupName");

        String groupId=null;

        //查找群组id
        for (int i=0;i<DataManage.myGroup.getList().size();i++)
        {
            if (DataManage.myGroup.getList().get(i).getGroupName().equals(groupName))
                groupId=DataManage.myGroup.getList().get(i).getGroupNumber();
        }
        //将ID保存起来
        request.getSession().setAttribute("checkGroupId",groupId);
        //查找到所有文件ID
        List fileNumber =new ArrayList<String>();
        for (int i=0;i<DataManage.groupFile.getList().size();i++)
        {
            if (DataManage.groupFile.getList().get(i).getGroupId().equals(groupId))
            {
                fileNumber.add(DataManage.groupFile.getList().get(i).getGroupFileNumber());
            }

        }

        //在储存文件的表格中查找到文件
        List groupList =new ArrayList<FileList>();
        for (int i=0;i<DataManage.fileData.getList().size();i++)
        {
            for (int j=0;j<fileNumber.size();j++)
            {
                if (fileNumber.get(j).equals(DataManage.fileData.getList().get(i).getFileNo()))
                {
                    groupList.add(DataManage.fileData.getList().get(i));
                }
            }

        }
        String str= "{\"code\": 0,\"msg\": \"\",\"count\":"+groupList.size()+",\"limit\":10"+",\"data\":";
        str+=JSONArray.fromObject(groupList);
        str+="}";
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(str);



    }
}
