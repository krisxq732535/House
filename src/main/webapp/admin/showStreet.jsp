<%--
  Created by IntelliJ IDEA.
  User: kris
  Date: 2019/10/13
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="Css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/showStreet.js"></script>


</head>
<body>
    <%--数据表格显示--%>
    <table id="dg"></table>

    <%--显示工具栏--%>
    <div id="tb">
        <a href="javascript:add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>

        <a href="javascript:update()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a>

        <a href="javascript:dels()" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">删除</a>
    </div>

    <%--制作点击工具栏后弹出的添加对话框--%>
    <div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
         style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
        <form action="" id="addForm" method="post">
            <select id="" name="">
                <option>

                </option>
            </select>
            街道名称:<input type="text" name="name" id="name"><br/>
        </form>
    </div>


    <%--添加对话框按钮--%>
    <div id="AddDialogButtons">
        <a href="javascript:addSaveDialog()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
        <a href="javascript:CloseDialog('AddDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>


    <%--制作点击工具栏后弹出的修改对话框--%>
    <div id="updateDialog" class="easyui-dialog" buttons="#updateDialogButtons"
         style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
        <form action="" id="updateForm" method="post">
            <input type="text" readonly id="id" name="id"> <br>
            街道名称:<input type="text" name="name" id="upname"><br/>
        </form>
    </div>

    <%--修改对话框按钮--%>
    <div id="updateDialogButtons">
        <a href="javascript:upSaveDialog()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
        <a href="javascript:CloseDialog('updateDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
</body>
</html>
