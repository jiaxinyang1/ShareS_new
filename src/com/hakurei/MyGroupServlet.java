package com.hakurei;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =(String)request.getSession().getAttribute("user");
        int myGroupCount=0;
        DataManage.myGroup.getList().clear();
        DataManage.myGroup.Find();
        List groups_buf =new ArrayList<MyGroup>();
        for (int i=0;i<DataManage.myGroup.getList().size();i++) {
            //统计群组个数
            if (DataManage.myGroup.getList().get(i).getGroupNumber() > myGroupCount) {
                myGroupCount = DataManage.myGroup.getList().get(i).getGroupNumber();
            }
            //查找出我加入的群组
            if (DataManage.myGroup.getList().get(i).getUser().equals(username)) {


                groups_buf.add(DataManage.myGroup.getList().get(i));
            }
        }

        request.getSession().setAttribute("myGroupCount",myGroupCount);
        System.out.println(myGroupCount);

        String str= "{\"code\": 0,\"msg\": \"\",\"count\": 1000,\"data\":";
        str+=JSONArray.fromObject(groups_buf);
        str+="}";
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(str);


    }
}
