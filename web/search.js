layui.use(['layer','form','table'],function () {
    var $ = layui.jquery
        ,upload = layui.upload
        ,layer=layui.layer
        ,table=layui.table;


    table.render({
        elem: '#table2'
        ,width: 870
        ,url: '/search'
        ,page: true
        ,cols: [[
            {field:'fileNo',title:'文件编号',width:100}
            ,{field: 'fileName', title: '文件名称', width: 200, sort: true}
            ,{field: 'uploadTime', title: '日期', width: 200}
        ]]
    });


    form.on('submit(search)', function(data){
        /*   layer.alert(JSON.stringify(data.field), {
               title: '最终的提交信息'
           })
           */





        return true;
    });





});