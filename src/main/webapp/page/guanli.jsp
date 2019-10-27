    ﻿<%@ page pageEncoding="utf-8" language="java" contentType="text/html;utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%
   //判断有没有session
  Object o=session.getAttribute("users");
  if(o==null){
      //1.没有登入  2.登入过，但时间超过有效期
     out.print("<script>alert('你还没有登入，或者过期，可以滚去登入，不许进');location.href='login.jsp';</script>");
  }
%>--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="${pageContext.request.contextPath}/css/style.css">
<script src="${pageContext.request.contextPath}/scripts/jquery-1.8.3.js"></script>
  <script>
    /*$(function () {
        $("#delHouse").click(function () {
            $.post("HouseController/delHouse.do",{"id":$("#hid").val()},function (data) {
                if(data>0){
                    alert("删除成功");
                }else {
                    alert("删除失败");
                }
            })
        })
    })*/
    
    function delHouse(obj,id) {
        $.post("${pageContext.request.contextPath}/page/HouseController/delHouse.do",{"id":id},function (data) {
            if(data.temp>0){
                $(obj).parent().parent().parent().remove();
            }else {
                alert("删除失败22");
            }
        },"json")
    }
  </script>
<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="${pageContext.request.contextPath}/images/logo.gif"></DIV>
<DIV class=search>欢迎${sessionScope.users.name}.<LABEL class="ui-green searchs"><a href="${pageContext.request.contextPath}/page/fabu.jsp" title="">发布房屋信息</a></LABEL>
<LABEL class=ui-green><INPUT onclick='document.location="index.jsp"' value="退       出" type=button name=search></LABEL> 
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${extHouseList}" var="e">
  <TR>
    <TD class=house-thumb><SPAN><A href="details.htm" target="_blank"><img src="http://127.0.0.1:81/${e.path}" width="100" height="75" alt=""></A></SPAN></TD>
    <TD>
      <DL>
        <DT><A href="details.htm" target="_blank">${e.title}</A></DT>
        <DD>${e.dName}${e.sName},${e.tName}平米,类型：${e.floorage}<BR>联系方式：${e.contact} </DD></DL></TD>

      <td>${e.price}元/月</td>
      <td>
          <c:if test="${e.ispass==1}">审核已通过</c:if>
          <c:if test="${e.ispass==0}">正在审核中...</c:if>
      </td>
    <TD class=house-type><LABEL class=ui-green><INPUT onclick="location.href='/page/HouseController/getHouseById.do?id=${e.id}'" value="修    改" type=button name=search></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT value="删    除" onclick="delHouse(this,${e.id})" id="delHouse" type=button name=search><input type="hidden" id="hid" value="${e.id}"></LABEL></TD></TR>
  </c:forEach>
<%--  <TR class=odd>
    <TD class=house-thumb><SPAN><A href="details.htm" target="_blank"><img src="${pageContext.request.contextPath}/images/thumb_house.gif" width="100" height="75" alt=""></A></SPAN></TD>
    <TD>
      <DL>
        <DT><A href="details.htm" target="_blank">jjjj</A></DT>
        <DD>海淀区中关村大街,123平米<BR>联系方式：ff </DD></DL></TD>
    <TD class=house-type><LABEL class=ui-green><INPUT onclick=update(47) value="修    改" type=button name=search></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT value="删    除" type=button name=search></LABEL></TD></TR>

  <TR>
    <TD class=house-thumb><SPAN><A href="details.htm" target="_blank"><img src="${pageContext.request.contextPath}/images/thumb_house.gif" width="100" height="75" alt=""></A></SPAN></TD>
    <TD>
      <DL>
        <DT><A href="details.htm" target="_blank">大房子</A></DT>
        <DD>海淀区中关村大街,100平米<BR>联系方式：123456789 </DD></DL></TD>
    <TD class=house-type><LABEL class=ui-green><INPUT onclick=update(6) value="修    改" type=button name=search></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT value="删    除" type=button name=search></LABEL></TD></TR>
  --%>
  </TBODY></TABLE></DIV>
<DIV class=pager>
<UL>
  <LI class=current><A id=widget_338868862 
  href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=1" 
  parseContent="true" showError="true" targets="houseArea" 
  ajaxAfterValidation="false" validate="false" 
dojoType="struts:BindAnchor">1</A>
   </LI>
  <LI class=current><A id=widget_1160989910 
  href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=2" 
  parseContent="true" showError="true" targets="houseArea" 
  ajaxAfterValidation="false" validate="false" 
dojoType="struts:BindAnchor">2</A>
   </LI></UL><SPAN class=total>1/2页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
