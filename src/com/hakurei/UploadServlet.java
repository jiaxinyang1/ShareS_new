package com.hakurei;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //配置存储文件名
    private static final String UPLOAD_DIRECTORY = "upload";

    //上传配置
    private static final int MEMORY_THRESHOLD = 1024* 1024*3;  //3MB
    private static final int MAX_FILE_SIZE = 1024* 1024*40;   //40MB
    private static final int MAX_REQUEST_SIZE = 1024* 1024*50; //50MB

    public UploadServlet() {
        // TODO Auto-generated constructor stub
        super();
    }

    @Override
    public void  init()
    {
        DataManage.init();
    }
    /**
     *上传数据及保存文件
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //检测是否为多媒体上传
        if(!ServletFileUpload.isMultipartContent(request)) {
            //如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error:表单必须包含enctype=multipart/form-data");
            writer.flush();
            return;
        }

        //配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();

        //设置内存临界值-超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);

        //设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);

        //设置最大文件上传值ֵ
        upload.setFileSizeMax(MAX_FILE_SIZE);

        //设置最大请求值（包含文件和表单数据）ֵ
        upload.setSizeMax(MAX_REQUEST_SIZE);

        //中文处理
        upload.setHeaderEncoding("UTF-8");
        String username=(String)request.getSession().getAttribute("user");
        System.out.print(username);

        //构造临时路径来存储上传的文件
        //这个路径相对于当前应用的目录
        //String uploadpath = request.getServletContext().getRealPath("./")+File.separator+UPLOAD_DIRECTORY;
        String uploadpath = "D:"+File.separator+UPLOAD_DIRECTORY+File.separator+username;

        //如果目录不存在则创建
        File uploadDir = new File(uploadpath);
        if(!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            //解析请求内容，提取文件数据
            //@SuppressWarnings("unchecked")
            List<FileItem> formItem = upload.parseRequest(request);

            if(formItem !=null&&formItem.size()>0) {
                //迭代表单数据
                for(FileItem item :formItem) {
                    //处理不在表单中的字段
                    if(!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadpath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        //在控制台输出文件上传的路径
                        System.out.println(fileName);
                        //保存文件到硬盘
                        item.write(storeFile);
                        FileList newFile =new FileList();
                        newFile.setFileName(fileName);
                        newFile.setFileSize("1");
                        newFile.setUploadTime(getNowDateShort());
                        newFile.setFileNo(String.valueOf(DataManage.fileData.getList().size()+1));
                        newFile.setFileURL("D:/upload/"+username+"/"+fileName);
                        newFile.setUploader(username);
                        newFile.setAuthority(1);
                        DataManage.fileData.Insert(newFile);
                        request.setAttribute("message", "文件上传成功");
                        DataManage.fileData.getList().clear();
                        DataManage.fileData.Find();
                        request.getRequestDispatcher("MySpace.jsp").forward(request, response);
                    }
                }
            }
        }catch(Exception ex) {
           // request.setAttribute("message", "错误信息"+ex.getMessage());
            System.out.println(ex.getMessage());
        }

    }
    public String getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);

        return dateString;
    }
}