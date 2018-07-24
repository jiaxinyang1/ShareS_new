package com.hakurei;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class Download extends HttpServlet {



    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    //设置下载文件所在目录
    String basePath = "D:/upload";

    String url;
    String file_name;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        String fileNumber =(String) request.getParameter("fileNumber");
        System.out.println(fileNumber);

        for (int i=0;i<DataManage.fileData.getList().size();i++)
        {
            if (fileNumber.equals(DataManage.fileData.getList().get(i).getFileNo()))
            {
                url=DataManage.fileData.getList().get(i).getFileURL();
                file_name=DataManage.fileData.getList().get(i).getFileName();
            }
        }
        //将收到请求设置为UTF-8格式
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //以流的形式读入文件
        InputStream in = new FileInputStream(new File(url,file_name));

        //下载转码
        String userAgent = request.getHeader("user-agent").toLowerCase();
        if(userAgent.contains("mise")||userAgent.contains("edge")||userAgent.contains("trident")){
            //win10 ie edge浏览器和其他系统浏览器
            file_name =  URLEncoder.encode(file_name,"UTF-8");
        }else
        {
            file_name=new String(file_name.getBytes("UTF-8"),"iso-8859-1");
        }

        //使用浏览器进行下载
        response.addHeader("Content-type", "appllication/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=" + file_name);
        //定义流输出
        OutputStream out = response.getOutputStream();

        //定义临时缓冲区
        byte[] buffer = new byte[1024];
        int len = -1;

        //将流中的数据读出
        while ((len = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, len);
        }

        //关闭流
        out.close();
        in.close();
    }
    /**
     *
     */

}