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
    <script src="jquery-3.3.1.js"></script>
    <script src="upload.js"></script>
    <script src="navigation.js"></script>
    <script src="search.js"></script>
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
    String username=(String)session.getAttribute("nickname");
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
            <li class="layui-nav-item">
                <button id="test_2" data-method="upload" data-type="auto" class="layui-btn layui-btn-radius">
                    上传<i class="layui-icon">&#xe67c;</i>
                </button>

            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="/picture/userimg.jpg" class="layui-nav-img">
                    <%=username%>
                </a>
                <dl class="layui-nav-child">
                    <dd><button id="test1" class="layui-btn" style="padding:0 55px 0 55px;margin:5px 0 10px 0">昵称修改</button>
                    </dd>
                    <dd><button id="test3" class="layui-btn" style="padding:0 55px 0 55px">密码修改</button>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="/LoginOut">退出</a></li>
        </ul>
    </div>

    <div id="div0">
        <div class="layui-anim layui-anim-fadein">
            <div style="background: transparent" class="layui-main" >

                <table lay-filter="search_table" id="table2" style="background: white"></table>
                <script type="text/html" id="barDemo">
                    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                    <a class="layui-btn layui-btn-xs" lay-event="download">下载</a>

                </script>


            </div>
    </div>
    </div>
</div>
</body>

</html>
