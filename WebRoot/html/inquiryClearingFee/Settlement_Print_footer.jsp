<%@ page language="java" import="java.util.*,domain.ClearFee" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script type="text/javascript">
		function Settlement_Print() {
		return ture;
		}
	</script>
</head>
<body>
<%ClearFee su=(ClearFee)request.getAttribute("clearfee"); %>
<form action="../../FeeManager_query" method="post" name="SettlementForm" onsubmit="return Settlement_Print()">
	<table border="1px" bordercolor="#f0fe26" cellspacing="0px" style="border-collapse:collapse" width=780 height=300>
		<tr><th colspan="6">华中科技有限公司结算清单</th></tr>
		<tr align="center">
			<th>维修单号</th>
			<td align="center"><%=su.getRepairNo()%></td>
			<th colspan="2">机器品牌</th>
			<td colspan="2" align="center"><%=su.getMachineBrand() %></td>
		</tr>
		<tr align="center">
			<th>接修日期</th>
			<td align="center"><%=su.getReserveTime() %></td>
			<th colspan="2">修复日期</th>
			<td colspan="2" align="center"><%=su.getRepairedTime() %></td>
		</tr>
		<tr align="center">
			<th>产品类型</th>
			<td align="center"><%=su.getProductType() %></td>
			<th colspan="2">系列号</th>
			<td colspan="2" align="center"><%=su.getSeriesNumber() %></td>
		</tr>
		<tr align="center">
			<th>单位名称</th>
			<td align="center"><%=su.getCompany() %></td>
			<th colspan="2">联系人</th>
			<td colspan="2" align="center"><%=su.getLinkmen() %></td>
		</tr>
		<tr align="center" >
			<th>合计金额</th>
			<td align="center"><%=su.getMoneySum() %></td>
			<th>维修费</th>
			<td align="center"><%=su.getRepairCost() %></td>
			<th>材料费</th>
			<td align="center"><%=su.getMaterialCost() %></td>
		</tr>
		<tr><th colspan="6">机器故障现象</th></tr>
		<tr><td colspan="6" align="center"><%=su.getFailureType() %></td></tr>
		<tr>
			<th colspan="3">保修承诺</th>
			<th colspan="3">注意事项</th>
		</tr>
		<tr>
			<td colspan="3" align="center"> <%=su.getWarranty() %></td>
			<td colspan="3" align="center"><%=su.getAttention() %></td>
		</tr>
		<tr align="center">
			<th>部件名称</th>
			<th>型号</th>
			<th colspan="2">数量</th>
			<th colspan="2">单价</th>
		</tr>
		<tr align="center">
			<td align="center"><%=su.getPartName() %></td>
			<td align="center"><%=su.getVersion() %></td>
			<td colspan="2" align="center"><%=su.getAmount() %></td>
			<td colspan="2" align="center"><%=su.getPrice() %></td>
		</tr>
		<tr align="right"><td colspan="5">&nbsp;</td><td><a href="html/inquiryClearingFee/Settlement_frame_header.jsp"><input type="button" value="返回"></a></td></tr>
	</table>
	</form>
</body>
</html>
