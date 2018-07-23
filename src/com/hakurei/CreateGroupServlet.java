package com.hakurei;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateGroupServlet extends HttpServlet {

    @Override
    public void init()
    {

        DataManage.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MyGroup myGroup_buff = new MyGroup();
        int number=Integer.valueOf(request.getSession().getAttribute("myGroupCount").toString())+1;
        myGroup_buff.setUser((String) request.getSession().getAttribute("user"));
        myGroup_buff.setGroupName(request.getParameter("groupname"));
        myGroup_buff.setGroupNumber(number);
        //更新一下数量值
        request.getSession().setAttribute("myGroupCount",Integer.toString(number));

        System.out.println(request.getParameter("groupname"));
        DataManage.myGroup.Insert(myGroup_buff);
        DataManage.myGroup.getList().clear();
        DataManage.myGroup.Find();
        request.getRequestDispatcher("GroupSpace.jsp").forward(request,response);

    }
}
