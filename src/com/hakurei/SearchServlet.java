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
import java.util.Queue;


public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String search_content=request.getParameter("");
        List search_list =new ArrayList<FileList>();

       for (int i=0;i<DataManage.fileData.getList().size();i++)
       {
          // if(matchStringBySplit(DataManage.fileData.getList().get(i).getFileName(),search_content))
           {
               search_list.add(DataManage.fileData.getList().get(i));
           }
       }

        String str= "{\"code\": 0,\"msg\":\"\",\"count\":100,\"data\":";
        str+=JSONArray.fromObject(search_list);
        str+="}";
        System.out.println(str);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(str);


    }

    private Boolean matchStringBySplit( String parent,String child )
    {
        String[] array = parent.split(child);
        if (array.length-1>0)
            return true;
        return false;
    }
}
