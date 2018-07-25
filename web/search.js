layui.use(['layer','form','table'],function () {
    var $ = layui.jquery
        ,upload = layui.upload
        ,layer=layui.layer
        ,table=layui.table
        ,form=layui.form;
    form.on('submit(search)', function(data){
        /*   layer.alert(JSON.stringify(data.field), {
               title: '最终的提交信息'
           })
           */






        return true;
    });
    table.render({
        elem: '#table2'
        ,width: 1850
        ,height:600
        ,url: '/search'
       // ,page: true
        ,cols: [[
            {field:'fileNo',title:'文件编号',minwidth:100}
            ,{field: 'fileName', title: '文件名称', minwidth: 150, sort: true}
            ,{field: 'uploadTime', title: '日期', minwidth:150}
            ,{field:'operation',title:'操作',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}
        ]]
    });


    table.on('tool(search_table)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.fileNo + ' 的查看操作');
        }
         else if(obj.event === 'download'){

            location.href="/download?fileNumber="+data.fileNo;


            //layer.alert('编辑行：<br>'+ JSON.stringify(data))
        }
    });



});