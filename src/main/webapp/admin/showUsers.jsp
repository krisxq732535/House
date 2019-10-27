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
    <script language="JavaScript" src="js/showUsers.js"></script>
</head>
<body>
    <%--数据表格显示--%>
    <table id="dg">

    </table>
    <div id="tb">
            用户名：<input type="text" name="name" id="name">
            电话号码：<input type="text" name="telephone" id="telephone">
            <a id="btn" href="javascript:searchs()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
    </div>
</body>
</html>
