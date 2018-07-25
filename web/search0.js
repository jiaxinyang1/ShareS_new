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




});