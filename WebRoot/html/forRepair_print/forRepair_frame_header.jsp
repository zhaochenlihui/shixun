<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script type="text/javascript">
	function forRepairPrint() {
	document.getElementById("formid").submit();
	}
	</script>
</head>
<body>
	<table align="center" width="780">
		<tr>
			<td>
			<form action="../../ForRepairManager_print" method="post" id="formid">
				维修编号：<input type="text" name="repairNo">
		<a href="forRepair_frame_footer.jsp"><input type="submit" onclick="forRepairPrint()" name="find" value="查找"></a>
			</form>
			</td>
			
		</tr>	
	</table>
</body>
</html>