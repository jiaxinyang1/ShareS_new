layui.use(['layer','upload','table','form'], function() {
    var $ = layui.jquery
        , upload = layui.upload
        , layer = layui.layer
        , table = layui.table
        ,form=layui.form;
    form.on('submit(passchange)', function(data){
        /*   layer.alert(JSON.stringify(data.field), {
               title: '最终的提交信息'
           })
           */
        if(data.field.pass1!=data.field.pass11) {
            layer.msg("密码不一致");
            return false;
        }
        else return true;
    });//注册表单验证
    $('#test3').on('click', function () {
        layer.open({
            type: 1,
            title: '密码修改',
            area: ['600px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: '<form class="layui-form" action="changePass" method="get"> ' +
            ' <div class="layui-form-item">\n' +
            '    <label class="layui-form-label">原密码</label>\n' +
            '    <div class="layui-input-block">\n' +
            '      <input type="password" name="pass0" lay-verify="" placeholder="请输入原密码" autocomplete="off" class="layui-input">\n' +
            '    </div>\n' +
            '  </div>'+
            ' <div class="layui-form-item layui-form-text">\n' +
            '    <label class="layui-form-label">新密码</label>\n' +
            '    <div class="layui-input-block">\n' +
            '      <input type="password"  placeholder="新密码" class="layui-input" autocomplete="off" name="pass1"></input>\n' +
            '    </div>\n' +
            '  </div>'+
            ' <div class="layui-form-item layui-form-text">\n' +
            '    <label class="layui-form-label">确认新密码</label>\n' +
            '    <div class="layui-input-block">\n' +
            '      <input type="password" placeholder="确认新密码" class="layui-input" autocomplete="off" name="pass11"></input>\n' +
            '    </div>\n' +
            '  </div>'+
            ' <div class="layui-form-item">\n' +
            '    <div class="layui-input-block">\n' +
            '      <button class="layui-btn layui-btn" lay-submit="" lay-filter="passchange">确认</button>\n' +
            '    </div>\n' +
            '  </div>'+
            '</form> '
        });
    });

    $('#test1').on('click', function () {
        layer.open({
            type: 1,
            title: '基本信息修改',
            area: ['600px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: '<div style="text-align:center;font-size:20px;padding:50px 0 20px 0">请输入新昵称</div>' +
            '<form class="layui-form" action="/changeNickName" method="get"> ' +
            ' <div class="layui-form-item">\n' +
            '    <label class="layui-form-label">昵称</label>\n' +
            '    <div class="layui-input-block">\n' +
            '      <input type="text" name="newusername" lay-verify="" placeholder="请输入新昵称" autocomplete="off" class="layui-input">\n' +
            '    </div>\n' +
            '  </div>'+
            ' <div class="layui-form-item">\n' +
            '    <div class="layui-input-block">\n' +
            '<button class="layui-btn"  lay-submit="" lay-filter="namechange">确定</button>'+
            '    </div>\n' +
            '  </div>'+
            '</form> '

        });
    });
});