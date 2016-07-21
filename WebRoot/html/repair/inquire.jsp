<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="domain.Repair"%>
<html>
<head>
<title>add</title>
<script type="text/javascript">
function Repair_addForm() {
return ture;
}
</script>
</head>
<meta charset="utf-8">
<body> <center>
<% Repair repair = (Repair)request.getAttribute("repair"); %>
<form action="RepairManager_update" method="post" name="Repair_add" onsubmit="Repair_addForm()">
  <table>
  <tr><td>维修编号:</td><td><input type="text" name="repairNo" value =<%=repair.getRepairNo() %> >
  <tr><td>维修人员:</td><td><input type="text" name="repairWork" value =<%=repair.getRepairWork() %> ></td></tr><br />
  <tr><td>维修状态:</td><td><input type="text" name="repairState" value =<%= repair.getRepairState()%> >
  <tr><td>检测记录:</td><td><input type="text" name="testRecord" value =<%=repair.getTestRecord()%>></td></tr><br />
 <tr><td> 维修记录:</td><td><input type="text" name="repairRecord" value =<%=repair.getTestRecord() %>></td></tr><br />
  <tr><td>维修检测时间:</td><td><input type="text" name="testTime" value =<%=repair.getTestTime() %>></td></tr><br />
  <tr><td>工作量:</td><td><input type="text" name="workAmount" value =<%= repair.getWorkAmount()%>></td></tr><br />
  <tr><td>维修所使用的器件:</td><td><input type="text" name="usePart" value =<%=repair.getUsePart() %> > 
</table>
<font color="red">(维修状态：0-未分配，1-分配未检测，2-检测完成维修未完成，3-维修完成) <br/>
  <br />
     </font>
     <input type="button" name="add" value="返回" onclick="javascript:location.href='html/repair/Repair_inquire.jsp'">
     &nbsp;
     <input type="submit" value="提交" >
  </center>
  </form>
</body>
</html>
