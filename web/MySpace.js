layui.use(['layer','form','table'],function () {
        var $=layui.jquery,
            layer=layui.layer,
            form=layui.form,
            table=layui.table;
        table.render({
            elem:'#user'
            ,width:1100
            ,height: 600
            ,shade:1
            ,cols:[[ //标题栏
                {field:'fileNo',title:'文件编号',width:100}
                ,{field: 'fileName', title: '文件名称', width: 200, sort: true}
                ,{field: 'uploadTime', title: '日期', width: 200}
                ,{field: 'fileSize', title: '大小', minWidth: 100}
                ,{field: 'authority', title: '文件权限', minWidth: 50}
                ,{field:'operation',title:'操作',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}
            ]]
            ,url:'/data'
            ,skin: 'line' //表格风格
            ,even: true

        });



    table.on('tool(test)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.fileNo + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                location.href="/delete?fileNumber="+data.fileNo;

                layer.close(index);
            });
        } else if(obj.event === 'download'){

            location.href="/download?fileNumber="+data.fileNo;


            //layer.alert('编辑行：<br>'+ JSON.stringify(data))
        }
    });




});