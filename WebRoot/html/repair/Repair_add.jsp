<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<script type="text/javascript">
  <meta charset="utf-8">
  function Repair_addForm() {

    return ture;
  }
</script>
</head>

<body>
<form action="../../RepairManager_add" method="post" name="Repair_add" onsubmit="Repair_addForm()">
  <table>
  <tr>
    <td>维修编号:</td>
    <td>
      <input type="text" name="repairNo"  />
      <font color="red">*必填项</font>
    </td>
  </tr>
  <tr>
    <td>维修人员:</td>
    <td><input type="text" name="repairWork" /></td>
  </tr>
  <tr>
    <td>维修状态:</td>
    <td>
      <input type="text" name="repairState" />
      <font color="red">*必填项</font>
    </td>
  </tr>
  <tr>
    <td>检测记录:</td>
    <td><input type="text" name="testRecord" /></td>
  </tr>
  <tr>
    <td> 维修记录:</td>
    <td><input type="text" name="repairRecord" /></td>
  </tr>
  <tr>
    <td>维修检测时间:</td>
    <td><input type="text" name="testTime" /></td>
  </tr>
  <tr>
    <td>工作量:</td>
    <td><input type="text" name="workAmount" /></td>
  </tr>
  <tr>
    <td>维修所使用的器件:</td>
    <td>
      <input type="text" name="usePart" /> 
      <input type="button" value="查询库存" onclick="javascript:location.href='../stock/check-sparepart.jsp'">
    </td>
  </tr>
  </table>
  <font color="red">(维修状态：0-未分配，1-分配未检测，2-检测完成维修未完成，3-维修完成) </font>
  <input type="submit" name="add" value="添加" onclick="alert('ok')" />
</form>
</body>
</html>
