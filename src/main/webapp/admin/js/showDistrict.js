$(function () {
    $('#dg').datagrid({
        url:'district/selectDistrictByPage.do',
        toolbar:'#tb',//绑定工具栏
        pagination:true,
        pageSize:3,
        pageList:[3,6,9],
        columns:[[
            {field:'opt',checkbox:'true',width:100},
            {field:'id',title:'区域编号',width:100},
            {field:'name',title:'区域名称',width:100},
            {field:'d',title:'操作',width:100,
                formatter: function(value,row,index){
                    return "<a href='javascript:del()'>删除</a> | <a href=''>修改</a>"
                }
            }
        ]]
    });
});

//工具栏点击添加按钮触发函数
function add() {
    //添加对话框标题
    $("#AddDialog").dialog("setTitle","添加区域");
    //打开窗口
    $("#AddDialog").dialog("open");
}

//关闭对话框(传入id，一个方法可以关闭所有窗口)
function CloseDialog(id) {
    //关闭对话框
    $("#"+id).dialog("close");
}

//保存信息（使用easyui的表单提交）
function addSaveDialog() {
    //采用easyui的表单来提交（这里有两种方式：一种是ajax方式一种是easyui方式；前者在需要传入的参数比较多的时候不适用，后者只是对ajax的封装）
    //但是两者都是异步请求
    $("#addForm").form('submit',{
        url:"district/insertDistrict.do",
        success:function(data){
            data=$.parseJSON(data);
            if(data.result==1){
                $("#dg").datagrid("reload");//刷新
                //关闭对话框
                $("#AddDialog").dialog("close");
                $.messager.alert("Warning","添加成功");
            }else {
                $.messager.alert("Warning","添加失败");
            }
        }
    });
    /* //使用ajax提交
     $.post('district/insertDistrict.do',{"name":$("#name").val()},
     function (data) {
         if(data.result==1){
             //刷新数据
             $("#dg").datagrid("reload");
             //关闭窗口
             $("#AddDialog").dialog("close");
             alert("添加成功");
         }else {
             alert("添加失败");
         }
          },"json"
     )*/
}

//打开修改框(更新前对的查询)
function update() {
    var $opts=$("#dg").datagrid("getSelections");
    if($opts.length==1){
        $("#updateDialog").dialog("setTitle","修改");
        $("#updateDialog").dialog("open");
        //将勾选的数据添加到数据表格中
        //先到数据库查询，将查询结果回显到页面
        //方式一——$("#updateForm").form('load',$opts[0]);直接利用表格不去数据库
        /*这里也可以用ajax进行异步*/
        $("#id").val($opts[0].id);
        //方式二：去数据库查；对于什么时候用方式一还是方式二在于如果数据比较多，并且在前端页面数据中的字段没有全部显示时可以用方式二其他情况可以用方式一
        $("#updateForm").form('submit',{
                url: 'district/upselectDistrict.do',
                success: function (data) {
                    data=$.parseJSON(data);
                    // $("#upname").val(data);
                    //获取对象的数据加载到表单中显示
                    $("#updateForm").form('load',data);
                }
            }
        )
    }else if($opts.length==0) {
        $.messager.alert('Warning','请选择一条信息进行修改');
    }else {
        $.messager.alert('Warning','不能选择多条信息');
    }
}

//修改信息
function upSaveDialog() {
    //采用easyui的表单来提交（这里有两种方式：一种是ajax方式一种是easyui方式；前者在需要传入的参数比较多的时候不适用，后者只是对ajax的封装）
    //但是两者都是异步请求
    $("#updateForm").form('submit',{
        url:"district/updateDistrict.do",
        success:function(data){
            data=$.parseJSON(data);
            if(data.result==1){
                $("#dg").datagrid("reload");//刷新
                //关闭对话框
                $.messager.alert('error','修改成功');
                $("#updateDialog").dialog("close");
            }else {
                $.messager.alert('error','修改失败');
                $("#updateDialog").dialog("close");
            }
        }
    });
}

//根据id单个删除区域信息
function del() {
    //如果通过参数来传入id也可以通过fomatter中的row来获取
    $.messager.confirm('删除操作', '确定需要删除吗？', function(r){
        if (r){
            //使用ajax的post请求而不是用easyui的form表单提交是因为此处不是表单提交
            //先利用easyui的datagrid中的getSelections方法获取选中的记录
            var $opts=$("#dg").datagrid("getSelections");
            $.post('district/deleteDistrict.do',{"id":$opts[0].id},
                function (data) {
                    if(data.result==1){
                        $("#dg").datagrid("reload");
                        $.messager.alert('Warning','删除成功');
                    }else {
                        $.messager.alert('Warning','删除失败');
                    }
                },"json");
        }
    });
}
/*区域的批量删除*/
function dels() {
    var $opts=$("#dg").datagrid("getSelections");
    if($opts.length>=1){
        $.messager.confirm('删除操作', '确定需要删除吗？', function(r){
            if (r){
                //使用ajax的post请求而不是用easyui的form表单提交是因为此处不是表单提交
                //先利用easyui的datagrid中的getSelections方法获取选中的记录
                var ids="";
                for (var i = 0; i <$opts.length ; i++) {
                    ids=ids+$opts[i].id+","
                }
                ids.substring(0,ids.length-1);
                $.post('district/deleteMoreDistrict.do',{"id":ids},
                    function (data) {
                        if(data.result>=1){
                            $.messager.alert("Warning","删除成功");
                            $("#dg").datagrid("reload");
                        }else {
                            $.messager.alert("Warning","删除失败");
                        }
                    },"json");
            }
        });
    }else {
        $.messager.alert("Warning","至少选择一个进行删除");
    }
}
