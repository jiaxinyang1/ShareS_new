layui.use(['layer','form','table'],function () {
        var $=layui.jquery,
            layer=layui.layer,
            form=layui.form,
            table=layui.table;
        table.render({
            elem:'#user'
            ,width:1000
            ,cols:[[ //标题栏
                {type: 'checkbox'}
                ,{field:'fileNo',title:'文件编号',width:100}
                ,{field: 'fileName', title: '文件名称', width: 200, sort: true}
                ,{field: 'uploadTime', title: '日期', width: 200}
                ,{field: 'fileSize', title: '大小', minWidth: 100}
                ,{field: 'authority', title: '文件权限', minWidth: 100}
                ,{field:'operation',title:'操作',fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}
            ]]
            ,url:'/data'
            ,skin: 'line' //表格风格
            ,even: true
        });


});