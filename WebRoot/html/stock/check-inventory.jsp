<%@ page language="java" import="java.util.List,java.lang.*,domain.SparePart,service.SparePartManagerService" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%--
List<SparePart> spList = (List<SparePart>) request.getAttribute("spList");
int i = spList.size();
--%>
<%
SparePartManagerService spms = new SparePartManagerService();
List<SparePart> spList = spms.findAllSparePart();
int i = spList.size();
%>	
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>check-inventory</title>
</head>
<body>
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
	
	<tr>
		
		<td  colspan=4><input type="button" value="stock-in" onclick="location.href='/aa/html/stock/stock-in.jsp'"></td>
		
		<td colspan=3><input type="button" value="stock-out" onclick="location.href='/aa/html/stock/stock-out.jsp'"></td>
	</tr>
	
</table>
</body>
</html>