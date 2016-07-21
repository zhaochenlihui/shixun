<%@ page language="java" import="java.util.List,java.lang.*,domain.SparePart,service.SparePartManagerService" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta Content-Type:text/html; charset="utf-8" >
	<title>stock-out</title>
	<script type="text/javascript">
	function validate_required(form)
	{
	with (form)
	  {
	  if (form.spareParts_Name.value==null||form.spareParts_Name.value=="")
	    {alert("备件名不能为空");return false}
	  else if(form.spareParts_ModelNo.value==null||form.spareParts_ModelNo.value==""){
		  alert("备件型号不能为空");return false
	  }else if(form.spareParts_FixNo.value==null||form.spareParts_FixNo.value==""){
		  alert("维修编号不能为空");return false
	  }
	  else {
		 	//document.myform.submit();
	  		return true
	  }
	  
	  }
	}
	</script>
</head>
<body>
<!-- <form style="font-size:150%;text-align:center" method="get"> -->
	<!-- <fieldset>	 -->
<!-- <legend>±¸¼þ³ö¿â</legend> -->

<form action="/aa/SparePartOutManager" method="post" name="myform" onsubmit="return validate_required(this)">
<%
session.setAttribute("service", "Stock-out"); 
%>
<table border="1" style="font-size:150%;text-align:center">
<tr>
	<th>设备名：</th>
	<th><input type="text"  name="spareParts_Name" ></th>
</tr>
<tr>
	<th>型号：</th>
	<th><input type="text"  name="spareParts_ModelNo"></th>
</tr>
<tr>
	<th>维修状态：</th>
	<th><input type="text"  name="spareParts_FixNo"></th>
</tr>
<tr>
	<th>单价：</th>
	<th><input type="text"  name="spareParts_UnitPrice"></th>
</tr>
<tr>
	<th>数量：</th>
	<th><input type="text"  name="spareParts_Quantity"></th>
</tr>
<tr>	
	<th>出库时间：</th>
	<th><input type="text" name="spareParts_StockoutTime"></th>
</tr>
<tr>
	<td><input type="submit" style="width:100%" value="stock-out" 
		name="spareParts_In" ></td>
	<td><input type="reset" style="width:100%" value="reset" name="spareParts_Reset"></td>
</tr>
</table>	
</form>
	<!-- </fieldset> -->
<!-- </form> -->
</body>
</html>