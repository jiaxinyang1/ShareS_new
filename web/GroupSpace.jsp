<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="../layui/layui.js"></script>
    <script src="LoginSystem.js"></script>
    <script src="GroupSpace.js"></script>
    <!--script src="../layui/index.js"></script-->
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="loungh_3.css">
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
        // String strURL = request.getParameter("first");
        String password = (String)session.getAttribute("password");
        // String strSession = (String)request.getSession().getAttribute("strSession");
        String username=(String)session.getAttribute("username");
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
            <li class="layui-nav-item"><a href="">上传</a></li>
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


<div class="div0">
    <div class="layui-anim layui-anim-fadein">
        <div id="left">
            <div id="upbtn">
                <button class="layui-btn">
                    <i class="layui-icon">&#xe613;</i>
                    所有群组
                </button>
            </div>
            <div id="leftbottom">
                <div class="leftdiv">
                    <img src="../picture/userimg.jpg" height="80px" width="80px" alt="use image">
                </div>
                <div class="leftdiv">
                    <button class="layui-btn layui-btn-radius layui-btn-danger">创建群组</button>
                </div>
            </div>
        </div>
    </div>
    <div id="mid">
        <div class="layui-anim layui-anim-up">
            <div class="table">
                <table id="table1" lay-filter="test"></table>

            </div>
        </div>
    </div>
    <div id="right">
        <div class="layui-anim layui-anim-up">
            <div class="table">
                <table id="table2" lay-filter="test"></table>


            </div>
        </div>
    </div>
</div>
</body>

</html>