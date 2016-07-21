<%@ page language="java"  contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%--@ import="java.util.List,java.lang.*,com.soft.domain.SparePart,com.soft.service.SparePartManagerService"--%>
<!DOCTYPE html>
<html>
<head>
	<meta Content-Type:text/html; charset="utf-8" >
	<title>check-sparepart</title>
	<script type="text/javascript">
	function validate_required(form)
	{
	with (form){
	  if (form.spareParts_Name.value==null||form.spareParts_Name.value=="")
	    {alert("备件名不能为空");return false}
	  else {
		 	//document.myform.submit();
	  		return true
	  }
	  }
	}
	</script>
</head>
<body>
<%session.setAttribute("service", "find");%>
<form action="/aa/CheckSparePartsManager" method="post" name="myform" 
	onsubmit="return validate_required(this)">
	备件名称：<input type="text" name="spareParts_Name">
	<input type="submit" style="width:8%" value="Submit" name="spareParts_In" >
	<br/>
</form>		
</body>
</html>