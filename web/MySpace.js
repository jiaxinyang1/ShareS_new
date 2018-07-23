layui.use(['layer','form','table'],function () {
        var $=layui.jquery,
            layer=layui.layer,
            form=layui.form,
            table=layui.table;
        table.render({
            elem:'#user'
            ,width:800
            ,cols:[[ //标题栏
                {type: 'checkbox'}
                ,{field: 'name', title: '文件名称', width: 100, sort: true}
                ,{field: 'date', title: '日期', width: 80}
                ,{field: 'des', title: '描述', width: 80}
                ,{field: 'level', title: '文件权限', width:100}
                ,{field:'operation',title:'操作',fixed: 'right', width:120, align:'center', toolbar: '#barDemo'}
            ]]
            ,url:'/data'
            ,skin: 'line' //表格风格
            ,even: true
        });


});