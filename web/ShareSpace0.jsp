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
  <script src="search0.js"></script>
  <link rel="stylesheet" href="../layui/css/layui.css">
  <link rel="stylesheet" type="text/css" href="loungh_1.css">
  <title>ShareSpace</title>
</head>
<body  class="layui-layout-body" onload="a()">
<script>
    layui.config({
        base: '/modules/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use('indexlayui'); //加载入口

</script>
<%
String login=(String) session.getAttribute("login");

%>
<div class="layui-layout layui-layout-admin ">

  <div class="layui-header  ">
    <!--div class="layui-logo layui-bg-blue">Space</div-->
    <ul class="layui-nav layui-layout-left ">
      <li class="layui-nav-item"><a href="ShareSpace0.jsp">ShareSpace</a> </li>
      <li class="layui-nav-item"><a href="/MySpace">MySpace</a> </li>
      <li class="layui-nav-item">
        <a href="/GroupSpace" >GroupSpace</a>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item"><a href="">上传</a></li>
      <li class="layui-nav-item">
        <div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">
        <button data-method="offset" data-type="auto" class="layui-btn layui-btn-primary">登录</button>
      </div>
      </li>

         <!--li class="layui-nav-item"><a href="">退出</a></li-->
    </ul>
  </div>

  <div id="div0">
    <div class="layui-anim layui-anim-fadein">
    <div id="top">
      <div class="layui-anim layui-anim-scale">
        <p>Share Space</p>
      </div>
      <div class="layui-anim layui-anim-upbit">
        <form class="layui-form" action="GoSearchPageServlet">
          <div id="div1">
            <div class="layui-form-item">
              <div class="layui-input-block">
                <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入文件名" class="layui-input">
                <p  style="visibility:hidden" id="login-infor">   <%=login%>   </p>
              </div>
            </div>
          </div>
          <div id="div2">
            <div class="layui-form-item">
              <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="search">搜索</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
    </div>
  </div>


</div>
</body>

</html>
