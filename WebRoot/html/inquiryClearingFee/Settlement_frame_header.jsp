<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script>
	function Settlement_form(form) {
		with(form){
			if(form.repairNo.value==null || form.repairNo.value==''){
				alert('维修编号为空！');
				return false;
			}
		}
		return true;
	}
	</script>
</head>
<body>
<form action="../../FeeManager_query" method="post" name="SettlementForm" onsubmit="return Settlement_form(this)">
	<table align="center" width="780">
		<tr>
			<td>
				维修编号：<input type="text" name="repairNo">
			<a href="Settlement_Print_footer.jsp">	<input type="submit" name="find" value="查找"></a>
			</td>
		</tr>	
	</table>
	</form>
</body>
</html>