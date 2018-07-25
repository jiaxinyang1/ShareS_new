layui.use(['layer','form','table'],function () {
    var $=layui.jquery,
        layer=layui.layer,
        form=layui.form,
        table=layui.table;
        table.render({
            elem:'#table2'
            ,width:400
            ,height: 450
            ,cols:[[ //标题栏
                {field: 'groupName', title: '我加入的群组', width: 400, event:'opengroupspace',style:'cursor: pointer;'}
            ]]
            ,url: '/myGroup'
            ,skin: 'line' //表格风格
            ,even: true
        });
    form.on('submit(demo1)', function(data){
        /*   layer.alert(JSON.stringify(data.field), {
               title: '最终的提交信息'
           })
           */
        return true;
    });//登录表单验证
    var active={
        offset:function(othis){
            var type = othis.data('type')
                ,text = othis.text();
            layer.open({
                type: 1
                ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                ,id: 'layerDemo'+type //防止重复弹出
                ,content: '<form class="layui-form" action="/createGroup" method="get"> ' +
                ' <div class="layui-form-item">\n' +
                '    <label class="layui-form-label">群组名称</label>\n' +
                '    <div class="layui-input-inline">\n' +
                '      <input type="text" name="groupname" lay-verify="" placeholder="请输入群组名称" autocomplete="off" class="layui-input">\n' +
                '    </div>\n' +
                '  </div>'+
                ' <div class="layui-form-item layui-form-text">\n' +
                '    <label class="layui-form-label">群组简介</label>\n' +
                '    <div class="layui-input-block">\n' +
                '      <textarea placeholder="请输入群组简介" class="layui-textarea" name="desc"></textarea>\n' +
                '    </div>\n' +
                '  </div>'+
                ' <div class="layui-form-item">\n' +
                '    <div class="layui-input-block">\n' +
                '      <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="demo1">创建</button>\n' +
                '    </div>\n' +
                '  </div>'+
                '</form> '
                ,title:'创建群组'
                ,area:['400px','320px']
                ,btnAlign: 'c' //按钮居中
                ,shade: 0 //不显示遮罩
            });
        }

    }
    $('#layerDemo .layui-btn').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
    table.on('tool(test1)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.fileNo + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                location.href="/deleteGroupFile?fileNumber="+data.fileNo;

                layer.close(index);

            });
        } else if(obj.event === 'download'){

            location.href="/download?fileNumber="+data.fileNo;


            //layer.alert('编辑行：<br>'+ JSON.stringify(data))
        }
    });

    table.on('tool(test2)', function(obj){
        var data = obj.data;




        if(obj.event === 'opengroupspace') {

            table.render({
                elem:'#table1'
                ,width:600
                ,height: 450
                ,cols:[[ //标题栏
                    {field:'fileNo',title:'文件编号',width:100}
                    ,{field: 'fileName', title: '文件名称', width: 100, sort: true}
                    ,{field: 'uploadTime', title: '日期', width: 100}
                    ,{field: 'fileSize', title: '大小', minWidth: 30}
                    ,{field: 'authority', title: '文件权限', minWidth: 30}
                    ,{field:'operation',title:'操作',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}
                ]]
                ,url: '/groupfile?groupName='+data.groupName
                ,skin: 'line' //表格风格
                ,even: true
            });

          // document.getElementById(uploadtogroup).style.display="inline";

            $('#uploadtogroup').css('display','block');




        }
    })


});