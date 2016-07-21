<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<script type="text/javascript">
	function entering() {
return true;
}
</script>
</head>

<body>
<form action="../../FeeManager" method="post"  name="entering" onsubmit="return entering()">
<table>
<tr><td>维修编号</td><td><input   type="text" name="repairNo"/></td></tr>
<tr><td>维修费用</td><td><input   type="text" name="repairCost"/></td>

</tr>
<tr><td>材料费用</td><td><input   type="text" name="materialCost"/></td>

</tr>
<tr><td>保修承诺</td><td><input   type="text" name="warranty"/></td></tr>
<tr><td>注意事项</td><td><input   type="text" name="attention"/></td></tr>
<tr><td>结算日期</td><td><input   type="text" name="clearTime"/></td></tr>

<tr><td><input type="submit" value="提交" >

</td></tr>
</table>
</form>
</body>
</html>