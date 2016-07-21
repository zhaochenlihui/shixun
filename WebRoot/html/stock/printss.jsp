<%@ page language="java" import="java.util.List,java.lang.*,domain.SparePart,service.SparePartManagerService" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>printss</title>
	</head>
	<body>
		<%System.out.println("kaishidayin!!!");
		List<SparePart> spList = (List<SparePart>)request.getAttribute("spList"); %>
		<table border="1" style="font-size:150%;text-align:center">
	<tr>
		<th>备件名称</th>
		<th>型号</th>
		<th>单价</th>
		<th>数量</th>
		<th>入库时间</th>
		<th>警戒数量</th>
		<th>库存状态</th>
	</tr>
		
	<%
	int i=spList.size();
		for(;i>0;i--){
	%>
			<tr>
				<td> <%=spList.get(i-1).getPartName()  %> </td>
				<td> <%=spList.get(i-1).getVesion() %> </td>
				<td> <%=spList.get(i-1).getPrice() %> </td>
				<td> <%=spList.get(i-1).getAmount() %> </td>
				<td> <%=spList.get(i-1).getInTime() %> </td>
				<td> <%=spList.get(i-1).getAlertAmount() %> </td>
				<td> <%=spList.get(i-1).getStockState() %> </td>
			</tr>
	<%	
		}
	%>
	</table>
	<a href="html/repair/Repair_add.jsp"><input type="button" value="返回" ></a>
	</body>
</html>