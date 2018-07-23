layui.use(['layer','form'],function () {
      var $=layui.jquery,
          layer=layui.layer,
          form=layui.form;



    form.on('submit(demo1)', function(data){
     /*   layer.alert(JSON.stringify(data.field), {
            title: '最终的提交信息'
        })
        */


        return true;
    });//登录表单验证

    form.on('submit(demo2)', function(data){
        /*   layer.alert(JSON.stringify(data.field), {
               title: '最终的提交信息'
           })
           */

        return true;
    });//注册表单验证
    var active={
        offset:function(othis){
        var type = othis.data('type')
            ,text = othis.text();
layer.open({
    type: 1
    ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
    ,id: 'layerDemo'+type //防止重复弹出
    ,content: '<form class="layui-form" action="/login" method="get"> ' +
        ' <div class="layui-form-item">\n' +
    '    <label class="layui-form-label">帐号</label>\n' +
    '    <div class="layui-input-inline">\n' +
    '      <input type="text" name="username" lay-verify="email" placeholder="请输入帐号" autocomplete="off" class="layui-input">\n' +
    '    </div>\n' +
    '  </div>'+
    ' <div class="layui-form-item">\n' +
    '    <label class="layui-form-label">密码</label>\n' +
    '    <div class="layui-input-inline">\n' +
    '      <input type="password" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">\n' +
    '    </div>\n' +
    '  </div>'+
        '<div class="layui-form-item">\n' +
    '            <label class="layui-form-label">验证码：</label>\n' +
    '\n' +
    '            <div class="layui-input-inline">\n' +
    '                <input type="number" name="code" class="layui-input" lay-verify="code" placeholder="验证码" maxlength="4"/><img src="img/v.png" onclick="getImage()" title="单击刷新验证码" id="img_rand_code" alt="">\n' +
    '            </div>\n' +
    '        </div>'+
    ' <div class="layui-form-item">\n' +
    '    <div class="layui-input-block">\n' +
    '      <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="demo1">登录</button>\n' +
    '    </div>\n' +
    '  </div>'+
    '</form> '
    ,title:'登录'
    ,area:['400px','320px']
    ,btn: '没有账号?点此注册'
    ,btnAlign: 'c' //按钮居中
    ,shade: 0 //不显示遮罩
    ,yes:function(){
         layer.open({
             type: 1
             ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
             ,id: 'layerDemoRe'+type //防止重复弹出
             ,content: '<form class="layui-form" action="/nmsl" method="get"> ' +
             ' <div class="layui-form-item">\n' +
             '    <label class="layui-form-label">Email</label>\n' +
             '    <div class="layui-input-inline">\n' +
             '      <input type="text" name="email" lay-verify="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">\n' +
             '    </div>\n' +
             '  </div>'+
             ' <div class="layui-form-item">\n' +
             '    <label class="layui-form-label">用户名</label>\n' +
             '    <div class="layui-input-inline">\n' +
             '      <input type="text" name="username" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">\n' +
             '    </div>\n' +
             '  </div>'+
             ' <div class="layui-form-item">\n' +
             '    <label class="layui-form-label">密码</label>\n' +
             '    <div class="layui-input-inline">\n' +
             '      <input type="password" name="password" lay-verify="required" placeholder="请输入密码,16位" autocomplete="off" class="layui-input">\n' +
             '    </div>\n' +
             '  </div>'+
             ' <div class="layui-form-item">\n' +
             '    <label class="layui-form-label">确认密码</label>\n' +
             '    <div class="layui-input-inline">\n' +
             '      <input type="password" name="password2" lay-verify="required" placeholder="再次输入密码" autocomplete="off" class="layui-input">\n' +
             '    </div>\n' +
             '  </div>'+
             ' <div class="layui-form-item">\n' +
             '    <label class="layui-form-label">手机号</label>\n' +
             '    <div class="layui-input-inline">\n' +
             '      <input type="tel" name="phone" lay-verify="required|phone" placeholder="请输入手机号" autocomplete="off" class="layui-input">\n' +
             '    </div>\n' +
             '  </div>'+
             '<div class="layui-form-item">\n' +
             '            <label class="layui-form-label">验证码：</label>\n' +
             '\n' +
             '            <div class="layui-input-inline">\n' +
             '                <input type="number" name="code" class="layui-input" lay-verify="code" placeholder="验证码" maxlength="4"/><img src="img/v.png" onclick="getImage()" title="单击刷新验证码" id="img_rand_code" alt="">\n' +
             '            </div>\n' +
             '        </div>'+
             ' <div class="layui-form-item">\n' +
             '    <div class="layui-input-block">\n' +
             '      <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="demo2">立即提交</button>\n' +
             '      <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
             '    </div>\n' +
             '  </div>'+
             '</form> '
             ,title:'注册'
             ,area:['400px','460px']
             // ,btn:['注册','重置']
             //  ,btnAlign: 'c' //按钮居中
             ,shade: 0 //不显示遮罩

         })
     }

});
    }

    }
    $('#layerDemo .layui-btn').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
});


function a() {
    var inf=document.getElementById("login-infor").innerHTML;

    if(inf){
        console.log(inf);
       // console.log("aaa");
       layer.msg(inf);
    }
    else
        layer.msg("请登录");
}