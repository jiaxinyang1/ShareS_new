<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="../layui/layui.js"></script>
    <!--script src="LoginSystem.js"></script-->
    <script src="GroupSpace.js"></script>
    <script SRC="jquery-3.3.1.js"></script>
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
                <button id="test2" class="layui-btn layui-btn-radius">
                    上传<i class="layui-icon">&#xe67c;</i>
                </button>
                <script type="text/javascript">
                    $('#test2').on('click', function(){
                        layer.open({
                            type: 1,
                            title: '上传',
                            area: ['600px', '360px'],
                            shadeClose: true, //点击遮罩关闭
                            content: '<div style="text-align:center;font-size:20px;padding-top:20px;width:100%">请选择</div>  '+
                            '<div style="width:100%">'+
                            '<form class="layui-form layui-form-pane" action="">'+
                            '<input class="search" type="text" style="float:left;padding-top:10px;padding-bottom:7px;margin-left:75px;width: 400px;margin-top:20px;margin-bottom:20px" required lay-verify="required" placeholder="请选择文件" autocomplete="off" class="layui-input"></form> '+
                            '<button style="padding-left:20px;padding-right:20px;margin-top:20px;float:left" class="layui-btn">浏览</button></div>'+
                            '<div style="  margin: auto;text-align: center;clear: both;"><div style="font-size:20px;text-align:center">权限</div> '+
                            '<div style="text-align:center"><select name="interest" lay-filter="aihao" style="padding:10px 0 10px 0;margin:20px 0 20px 0"><option value="">请选择</option><option value="0">公开</option><option value="1" selected="">私密</option><option value="2">组内</option></select></div></div> '+
                            '<div style="text-align:center"><button class="layui-btn">确定</button><button class="layui-btn">取消</button></div>'
                        });
                    });
                </script>
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
                        <button data-method="offset" data-type="auto" class="layui-btn layui-btn-radius layui-btn-danger">创建群组?</button>
                    </div>
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