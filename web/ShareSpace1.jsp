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
                            '<form class="layui-form layui-form-pane" action="/upload">'+
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
