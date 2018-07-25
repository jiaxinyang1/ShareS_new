layui.use(['layer','upload','table'], function(){
    var $ = layui.jquery
        ,upload = layui.upload
        ,layer=layui.layer
        ,table=layui.table;

    var active={
        upload:function(othis){
            var type = othis.data('type')
                ,text = othis.text();
            layer.open({
                type: 1
                ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                ,id: 'layerDemo'+type //防止重复弹出
                ,content: '' +
                '<div class="layui-upload">\n' +
                '  <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button> \n' +
                '  <div class="layui-upload-list">\n' +
                '    <table  class="layui-table">\n' +
                '      <thead>\n' +
                '        <tr><th>文件名</th>\n' +
                '        <th>大小</th>\n' +
                '        <th>状态</th>\n' +
                '        <th>操作</th>\n' +
                '      </tr></thead>\n' +
                '      <tbody id="demoList"></tbody>\n' +
                '    </table>\n' +
                '  </div>\n' +
                '  <button type="button" class="layui-btn" id="testListAction">开始上传</button>\n' +
                '</div> ' +
                '<script>layui.use([\'layer\',\'upload\',\'table\'], function(){\n' +
                '    var $ = layui.jquery\n' +
                '        ,upload = layui.upload\n' +
                '        ,layer=layui.layer\n' +
                '        ,table=layui.table;' +
                'var demoListView = $(\'#demoList\')\n' +
                '    ,uploadListIns = upload.render({\n' +
                '    elem: \'#testList\'\n' +
                '    ,url: \'/upload\'\n' +
                '    ,accept: \'file\'\n' +
                '    ,multiple: true\n' +
                '    ,auto: false\n' +
                '    ,bindAction: \'#testListAction\'\n' +
                ',number:1'+
                '    ,choose: function(obj){\n' +
                '        var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列\n' +
                '        //读取本地文件\n' +
                '        obj.preview(function(index, file, result){\n' +
                '            var tr = $([\'<tr id="upload-\'+ index +\'">\'\n' +
                '                ,\'<td>\'+ file.name +\'</td>\'\n' +
                '                ,\'<td>\'+ (file.size/1014).toFixed(1) +\'kb</td>\'\n' +
                '                ,\'<td>等待上传</td>\'\n' +
                '                ,\'<td>\'\n' +
                '                ,\'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>\'\n' +
                '                ,\'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>\'\n' +
                '                ,\'</td>\'\n' +
                '                ,\'</tr>\'].join(\'\'));\n' +
                '\n' +
                '            //单个重传\n' +
                '            tr.find(\'.demo-reload\').on(\'click\', function(){\n' +
                '                obj.upload(index, file);\n' +
                '            });\n' +
                '\n' +
                '            //删除\n' +
                '            tr.find(\'.demo-delete\').on(\'click\', function(){\n' +
                '                delete files[index]; //删除对应的文件\n' +
                '                tr.remove();\n' +
                '                uploadListIns.config.elem.next()[0].value = \'\'; //清空 input file 值，以免删除后出现同名文件不可选\n' +
                '            });\n' +
                '\n' +
                '            demoListView.append(tr);\n' +
                '        });\n' +
                '    }\n' +
                '    ,done: function(res, index, upload){\n' +
                '  layer.msg(res.code);' +
                '  if(res.code == 0){ //上传成功\n' +
                '            var tr = demoListView.find(\'tr#upload-\'+ index)\n' +
                '                ,tds = tr.children();\n' +
                '            tds.eq(2).html(\'<span style="color: #5FB878;">上传成功</span>\');\n' +
                '            tds.eq(3).html(\'\'); //清空操作\n' +
                '            return delete this.files[index]; //删除文件队列已经上传成功的文件\n' +
                '        }\n' +
             //  '        this.error(index, upload);\n' +
                '    }\n' +
                '    ,error: function(index, upload){\n' +
                '        var tr = demoListView.find(\'tr#upload-\'+ index)\n' +
                '            ,tds = tr.children();\n' +
                '        tds.eq(2).html(\'<span style="color: #FF5722;">上传失败</span>\');\n' +
                '        tds.eq(3).find(\'.demo-reload\').removeClass(\'layui-hide\'); //显示重传\n' +
                '    }\n' +
                '});' +
                '})</script>'
                ,title:'上传文件'
                ,area:['400px','320px']
                ,btnAlign: 'c' //按钮居中
                ,shade: 0 //不显示遮罩
            });
        }
        , uploadtogroup:function(othis) {
        var type = othis.data('type')
            , text = othis.text();

            layer.open({
                type: 1
                ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                ,id: 'layerDemo'+type //防止重复弹出
                ,content: ' <table lay-filter="myspaceingroup" id="myspaceingroup" style="background: white"  ></table>' +
                '<script>' +
                    'layui.use([\'layer\',\'upload\',\'table\'], function(){\n' +
                '    var $ = layui.jquery\n' +
                '        ,upload = layui.upload\n' +
                '        ,layer=layui.layer\n' +
                '        ,table=layui.table;'+
                'table.render({' +
                ' elem:\'#myspaceingroup\'' +
                '  ,width:1100\n' +
                '  ,height: 600\n' +
                '            ,shade:1\n' +
                '            ,cols:[[ //标题栏\n' +
                '                 {type:\'checkbox\'}\n' +
                '                ,{field:\'fileNo\',title:\'文件编号\',width:100}\n' +
                '                ,{field: \'fileName\', title: \'文件名称\', width: 200, sort: true}\n' +
                '                ,{field: \'uploadTime\', title: \'日期\', width: 200}\n' +
                '                ,{field: \'fileSize\', title: \'大小\', minWidth: 100}\n' +
                '                ,{field: \'authority\', title: \'文件权限\', minWidth: 50}\n' +
                '            ]]' +
                ' ,url:\'/data\'\n' +
                '            ,skin: \'line\' //表格风格\n' +
                '            ,even: true' +
                '});' +
                '})'+
                '</script>'
                ,title:'上传文件到群组'
                ,area:['1000px','600px']
                ,btnAlign: 'c' //按钮居中
                ,shade: 0 //不显示遮罩
                ,btn:'上传到群组'
                ,yes:function () {

                    var checkStatus = table.checkStatus('myspaceingroup')
                        ,data = checkStatus.data;
                    layer.msg(JSON.stringify(data));
                    var post={data:JSON.stringify(data)};
                    $.post("/uploadtogroup",post,function f() {

                    });


            }
            });





    }
    }
    $('#test_2').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });

    $('#uploadtogroup').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
})

