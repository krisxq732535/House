﻿<%@ page pageEncoding="utf-8" language="java" contentType="text/html;utf-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="${pageContext.request.contextPath}/css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.3.js"></script>
<script>
      $(function () {
          $.post("/page/proTypeController/getType.do",null,function (data) {
              for(var i=0;i<data.length;i++){
                  var chid=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                  $("#typeId").append(chid);
              }
              $("#typeId").val(${extHouse.typeId});
          },"json");
              $.post("/page/districtController/getDistrict.do",null,function (data) {
                  for(var i=0;i<data.length;i++){
                      var chid=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                      $("#districtId").append(chid);
                  }
                  $("#districtId").val(${extHouse.districtId});
                  changeStreet();
              },"json");
          $("#districtId").change(function () {
              changeStreet()
          });

         function changeStreet(){
             $("#streetId>option:gt(0)").remove();
             $.post("/page/proStreetController/getStreet.do",{"id":$("#districtId").val()},function (data) {
                 for(var i=0;i<data.length;i++){
                     var chid=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                     $("#streetId").append(chid);
                 }
                 $("#streetId").val(${extHouse.streetId});
             },"json")
         }
      });

</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="${pageContext.request.contextPath}/images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post name=add.action
action="${pageContext.request.contextPath}/page/HouseController/updateHouseById.do" enctype="multipart/form-data">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><input type="hidden" value="${extHouse.id}" name="id"> <INPUT id=add_action_title class=text type=text name=title value="${extHouse.title}"> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=typeId id="typeId"><OPTION selected
        >请选择</OPTION></SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=floorage class=text type=text
name=floorage value="${extHouse.floorage}"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price value="${extHouse.price}"> </TD></TR>
  <TR>
    <TD class=field>发布日期：</TD>
    <TD><INPUT class=text type=date name=pubdate value="<f:formatDate value="${extHouse.pubdate}" pattern="yyyy-MM-dd"></f:formatDate>"></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=districtId id=districtId><OPTION selected
        >请选择</OPTION></SELECT> 街：<SELECT class=text id="streetId"
        name=streetId><OPTION selected>请选择</OPTION></SELECT> </TD></TR><!--
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->

  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=contact class=text type=text name=contact value="${extHouse.contact}"> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description>${extHouse.description}</TEXTAREA></TD></TR>
  <TR>
      <TD class=field>图片：</TD>
      <TD><img src="http://localhost:81/${extHouse.path}" width="100" height="80"><INPUT type="file" id="pfile" name="pfile" multiple="multiple"></TD></TR>
  </TBODY></TABLE>
<DIV class=buttons><INPUT value=立即发布 type=submit>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
