<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="../layui/layui.js"></script>
    <!--script src="LoginSystem.js"></script-->
    <script src="GroupSpace.js"></script>
    <script src="jquery-3.3.1.js"></script>
    <script src="upload.js"></script>
    <!--script src="../layui/index.js"></script-->
    <script src="navigation.js"></script>
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
        String username=(String)session.getAttribute("nickname");
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
                    <div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">
                        <button data-method="offset" data-type="auto" class="layui-btn layui-btn-radius layui-btn-danger">创建群组</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="mid">
        <div class="layui-anim layui-anim-up">
            <div class="table">
                <table id="table1" lay-filter="test1"></table>
                <script type="text/html" id="barDemo">
                    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                    <a class="layui-btn layui-btn-xs" lay-event="download">下载</a>
                    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                </script>
                <button id="uploadtogroup" data-method="uploadtogroup" data-type="auto" class="layui-btn layui-btn-radius" style="display: none ">
                    上传<i class="layui-icon">&#xe67c;</i>
                </button>
            </div>
        </div>
    </div>
    <div id="right">
        <div class="layui-anim layui-anim-up">
            <div class="table">
                <table id="table2" lay-filter="test2"></table>


            </div>
        </div>
    </div>
</div>
</body>

</html>