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
		function forRepairHand() {
	document.getElementById("formid").submit();
	}
	</script>
</head>
<body>
<form action="../../ForRepairManager_hand" method="post" name="forRepair_frame_headerh" id="formid" onsubmit="return repairNo()">
	<table align="center" width="780">
		<tr>
			<td>
				维修编号：<input type="text" name="repairNo">
				<a href="forRepair_frame_footerh.jsp" target="mainframe"><input type="submit" name="find" onclick="forRepairHand()" value="查找"></a>
			</td>
		</tr>	
	</table>
	</form>
</body>
</html>