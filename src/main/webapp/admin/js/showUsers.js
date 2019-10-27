$(function () {
    $('#dg').datagrid({
        url:'users/searchUserLike.do',
        toolbar:'#tb',//绑定工具栏
        pagination:true,
        pageSize:3,
        pageList:[3,6,9],
        columns:[[
            {field:'opt',checkbox:'true',width:100},
            {field:'id',title:'用户编号',width:100},
            {field:'name',title:'用户名称',width:100},
            {field:'telephone',title:'用户电话',width:100},
            {field:'isAdmin',title:'是否是管理员',width:100},

        ]]
    });
});


function searchs() {
    var $name=$("#name").val();
    var $telephone=$("#telephone").val();
    $("#dg").datagrid("load",{"name":$name,"telephone":$telephone})
    //注意：只有datagrid提交才会提供page和rows
    /*$.post("users/searchUserLike.do",{"name":$name,"telephone":$telephone},
        function (data) {
            $("#searchForm").form("reload",data);
        },
        "json")*/
}





