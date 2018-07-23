<%--
  Created by IntelliJ IDEA.
  User: sy3
  Date: 2018/7/20
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>ShareSpace</title>
    <link rel='stylesheet'href='loungh.css' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <script src="./layui/layui.all.js"></script>
    <script>
        ;!function(){
            var layer = layui.layer
                ,form = layui.form;

            layer.msg('Welcom');
        }();
    </script>
</head>
<body>
<h1>ShareSpace</h1>
<div class="layui-anim layui-anim-fadein">
    <p><img src="./picture/top.jpg" width="1480px" alt="just a picture"></p>
    <div id="div0">
        <div id="div1">
            <a href="ShareSpace0.jsp"><img src="./picture/left.jpg" height="233px" width="400px" alt="Picture share"></a>
        </div>
        <div class="div2">
            <a href="ShareSpace0.jsp"><img src="./picture/mid.jpg" height="233px" width="400px" alt="Files share"></a>
        </div>
        <div class="div2">
            <a href="ShareSpace0.jsp"><img src="./picture/right.jpg" height="233px" width="400px" alt="Others"></a>
        </div>
    </div>
</div>
<div id="div3">
    <div class="layui-anim layui-anim-upbit">
        <div id ="div4">
            <p style="color: white;font-size: 50px">ShareSpace</p>
        </div>
        <div id="div5">
            <p style="color:white;font-size: 25px">在线共享平台，群组分享模式，跨平台操作</p>
        </div>
    </div>
    <div id="div6">
        <div class="layui-anim layui-anim-up">
            <a href="ShareSpace0.jsp"><img src="./picture/fm.jpg" height="75px" width="1100px"></a>
        </div>
    </div>
</div>

</body>
</html>
