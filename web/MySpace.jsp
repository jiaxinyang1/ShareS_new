<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="page" class="Bean.UserBean"></jsp:useBean>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="../layui/layui.js"></script>
    <script src="LoginSystem.js"></script>
    <script src="MySpace.js"></script>
    <script src="jquery-3.3.1.js"></script>
    <script src="upload.js"></script>
    <!--script src="../layui/index.js"></script-->
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="loungh_2.css">
    <title>ShareSpace</title>
</head>
<body  class="layui-layout-body" onload="">
<script>
    layui.config({
        base: '/modules/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use('indexlayui'); //加载入口

</script>
<div class="layui-layout layui-layout-admin ">
    <%
        String username=(String)session.getAttribute("user");
    %>


    <div class="layui-header ">
        <!--div class="layui-logo layui-bg-blue">Space</div-->
        <ul class="layui-nav layui-layout-left ">
            <li class="layui-nav-item"><a href="ShareSpace1.jsp">ShareSpace</a> </li>
            <li class="layui-nav-item"><a href="/MySpace">MySpace</a> </li>
            <li class="layui-nav-item">
                <a href="/GroupSpace">GroupSpace</a>
            </li>
        </ul>
        <%
           // user.setUsername("test");
        %>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <button id="test_2"  data-method="upload" data-type="auto" class="layui-btn layui-btn-radius">
                    上传<i class="layui-icon">&#xe67c;</i>
                </button>
            </li>
            <li class="layui-nav-item">
                 <a href="javascript:;">
                     <img src="/picture/userimg.jpg" class="layui-nav-img">
                     <%=username%>
                   </a>
                 <dl class="layui-nav-child">
                   <dd><a href="">基本资料</a> </dd>
                   <dd><a href="">安全设置</a></dd>
                 </dl>
               </li>
               <li class="layui-nav-item"><a href="/LoginOut">退出</a></li>
        </ul>
    </div>
</div>


<div id="div0">
    <div class="layui-anim layui-anim-upbit">
        <div id="div1">
            <div id="upbtn">
                <button class="layui-btn">
                    <i class="layui-icon">&#xe619;</i>已上传
                </button>
            </div>
            <div>
                <button class="layui-btn">
                    <i class="layui-icon">&#xe61a;</i>已下载
                </button>
            </div>
            <div id="div2">
                <p id="p1">
                <p id="imgp"><img src="../picture/userimg.jpg" height="80px" width="80px" alt="User image"></p>
                <p class="fontp"><%=username%></p>
                <p class="fontp">积分:1000</p>
                <p class ="fontp">
                    <button class="layui-btn layui-btn-radius layui-btn-danger">
                        修改个人信息
                    </button>
                </p>
                </p>
            </div>
        </div>
    </div>
    <div class="layui-anim layui-anim-fadein">
        <div style="background: white" class="layui-main" >


         <div class="layui-btn-group demoTable">
        </div>
         <table lay-filter="test" id="user"  ></table>
         <script type="text/html" id="barDemo">
             <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
             <a class="layui-btn layui-btn-xs" lay-event="download">下载</a>
             <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
         </script>
         </div>
    </div>
</div>


</body>

</html>