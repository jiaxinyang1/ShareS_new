<%--
  Created by IntelliJ IDEA.
  User: sy3
  Date: 2018/7/18
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="../layui/layui.js"></script>
    <script src="LoginSystem.js"></script>
    <!--script src="../layui/index.js"></script-->
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="loungh_1.css">
    <title>ShareSpace</title>
</head>
<body  class="layui-layout-body" onload="">
<script>
    layui.config({
        base: '/modules/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use('indexlayui'); //加载入口

</script>
<%
    String password = (String) session.getAttribute("password");
    String username=(String)session.getAttribute("user");
%>
<div class="layui-layout layui-layout-admin ">
    <div class="layui-header  ">
        <!--div class="layui-logo layui-bg-blue">Space</div-->
        <ul class="layui-nav layui-layout-left ">
            <li class="layui-nav-item"><a href="ShareSpace1.jsp">ShareSpace</a> </li>
            <li class="layui-nav-item"><a href="/MySpace">MySpace</a> </li>
            <li class="layui-nav-item">
                <a href="/GroupSpace" >GroupSpace</a>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="">上传</a></li>
            <li class="layui-nav-item">
                <a href="/login">
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

    <div id="div0">
        <div class="layui-anim layui-anim-scale">
            <p>Share Space</p>
        </div>
        <div class="layui-anim layui-anim-up">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <div id="div1">
                        <input type="text" name="title" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                    <div id="div2">
                        <input type="image" src="search.jpg" name="image" height="38px">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
