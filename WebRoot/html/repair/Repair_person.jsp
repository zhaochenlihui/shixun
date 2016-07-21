<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head></head>
<meta charset="utf-8">

<table border="1" cellspacing="0px"  style="border-collapse:collapse"  width="500">
  <tr><td align="center">编号</td><td align="center">工程师</td><td align="center">状态</td><td align="center">分配</td></tr>
<tr><td align="center">01</td><td align="center">张三</td><td align="center">空闲</td><td align="center"><input type="button" value="分配" name="distribute" onclick="javascript:location.href='Repair_show.jsp'"></td></tr>
<tr><td align="center">02</td><td align="center">李四</td><td align="center">空闲</td><td align="center"><input type="button" value="分配" name="distribute" onclick="javascript:location.href='Repair_show.jsp'"></td></tr>

</table>

</html>
