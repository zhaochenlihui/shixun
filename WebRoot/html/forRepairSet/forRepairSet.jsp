<%@ page language="java" import="java.util.*,domain.ForRepair,service.ForRepairManagerService" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
ForRepairManagerService service = new ForRepairManagerService();
List<ForRepair> cusList = service.findAllForRepair();
int i=cusList.size();
 %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script>
	function delete_record() {
	alert("已删除该记录");
	}
	
	</script>
</head>
<body>
	<table width=700>
	<form action="../../ForRepairManager" method=" post" name="forRepairSet" >
		<tr>
			<td>
			维修编号：<input type="text" name="repairNo">
	       <input type="submit" name="update" value="修改"></a>
	       <input type="submit" name="inquire" value="查看"></a>
	        <a href="forRepairSet_add.jsp"><input type="button" name="add" value="添加"></a>
			</td>
		</tr>
	</table>
	
	<table border="1px" bordercolor="#f0fe26" cellspacing="0px" style="border-collapse:collapse" width=700>
		<tr align="center">
			<th>维修编号</th>
			<th>客户编号</th>
			<th>产品类型</th>
			<th>机器品牌</th>
			<th>报修时间</th>
			<th>预估价格</th>
			<th>报修状态</th>
			<th></th>
		</tr>
		<%
			for(;i>0;i--){
		 %>
		<tr align="center">
			<td><%=cusList.get(i-1).getRepairNo() %></td>
			<td><%=cusList.get(i-1).getCustomerNo() %></td>
			<td><%=cusList.get(i-1).getProductType() %></td>
			<td><%=cusList.get(i-1).getMachineBrand() %></td>
			<td><%=cusList.get(i-1).getDeliverTime() %></td>
			<td><%=cusList.get(i-1).getPreviewCost() %></td>
			<td><%=cusList.get(i-1).getDeliverState() %></td>
			<td><input type="button" value="删除"></td>
		</tr>
		<%
		}
		 %>
		</form>
	</table>
	<br/>

	
</body>
</html>