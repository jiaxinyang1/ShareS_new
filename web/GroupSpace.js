layui.use(['layer','form','table'],function () {
    var $=layui.jquery,
        layer=layui.layer,
        form=layui.form,
        table=layui.table;
        table.render({
            elem:'#table1'
            ,width:209
            ,height:450
            ,cols:[[ //标题栏
                {type: 'checkbox'}
                ,{field: 'mygroup', title: '我创建的群组', width: 209}
            ]]
            ,url: ''
            ,skin: 'line' //表格风格
            ,even: true
        });

        table.render({
            elem:'#table2'
            ,width:209
            ,height: 450
            ,cols:[[ //标题栏
                {type: 'checkbox'}
                ,{field: 'group', title: '我加入的群组', width: 209}
            ]]
            ,url: ''
            ,skin: 'line' //表格风格
            ,even: true
        });





});