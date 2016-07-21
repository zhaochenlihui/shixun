<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="domain.Machine"%>
<%@page import="domain.ForRepair"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script>
		function details_form() {
		return true;
		}
	</script>
</head>
<body>
<% Machine machine = (Machine)request.getAttribute("machine"); %>
<% ForRepair forrepair = (ForRepair)request.getAttribute("forrepair"); %>
<form action="ForRepairManager_update" method="post" name="details_form" onsubmit="return details_form()">
	<table border="1px" bordercolor="#f0fe26" cellspacing="0px" style="border-collapse:collapse" align="center" width="780">
		<tr align="center">
			<th width="130">维修编号</th>
			<td width="130"><input type="text" name="repairNo" value =<%=machine.getRepairNo() %>></td>
			<th width="130">客户编号</th>
			<td width="130"><input type="text" name="customerNo" value =<%=forrepair.getCustomerNo()%>></td>
			<th width="130">报修状态</th>
			<td width="130" align="right">
				<select name="deliverState" value =<%=forrepair.getDeliverState()%> >
					<option value="0">未打印</option>
                    <option value="1">打印</option>
                    <option value="2">提交</option>
				</select>
			</td>
		</tr>
		<tr align="center">
			<th width="130">报修时间</th>
			<td width="130"><input type="text" name="deliverTime"value =<%=forrepair.getDeliverTime() %>></td>
			<th width="130">预估价格</th>
			<td width="130"><input type="text" name="previewCost" value =<%=forrepair.getPreviewCost() %>></td>
			<th width="130">产品类型</th>
			<td width="130" align="right">
				<select name="productType" value =<%=forrepair.getProductType() %>>
					<option value="1">台式机</option>
                    <option value="2">笔记本</option>
                    <option value="3">投影仪</option>
                    <option value="4">打印机</option>
                    <option value="5">其他</option>
				</select>
			</td>
		</tr>
	</table>

	<table border="1px" bordercolor="#f0fe26" cellspacing="0px" style="border-collapse:collapse" align="center" width="780">
		<tr align="center">
			<th width="130">机器品牌</th>
			<td width="130"><input type="text" name="machineBrand" value =<%=machine.getMachineBrand()%>></td>
			<th width="130">机器型号</th>
			<td width="130"><input type="text" name="machineVesion" value =<%=machine.getMachineVesion() %>></td>
			<th width="130">故障类型</th>
			<td width="130" align="right">
				<select name="failureType" value =<%=machine.getFailureType() %>>
					<option value="1">固定性故障</option>
                    <option value="2">间隙性故障</option>
				</select>
			</td>
		</tr>
		<tr align="center">
			<th width="130">系列号</th>
			<td width="130"><input type="text" name="seriesNumber" value =<%=machine.getSeriesNumber() %>></td>
			<th width="130">开机口令</th>
			<td width="130"><input type="text" name="onPassword" value =<%=machine.getOnPassword() %>></td>
			<th width="130">缺少零件</th>
			<td width="130"><input type="text" name="lackPart" value =<%=machine.getLackPart() %>></td>
		</tr>
		<tr align="center">
			<th width="130">重要资料</th>
			<td width="130"><input type="text" name="importantM" value =<%=machine.getImportantM() %>></td>
			<th width="130">HDD</th>
			<td width="130"><input type="text" name="HDD" value =<%=machine.getHDD() %>></td>
			<th width="130">内存</th>
			<td width="130"><input type="text" name="memory" value =<%=machine.getMemory() %>></td>
		</tr>
		<tr align="center">
			<th width="130">外置PC卡</th>
			<td width="130"><input type="text" name="pcCard" value =<%=machine.getPcCard() %>></td>
			<th width="130">AC适配器</th>
			<td width="130"><input type="text" name="AC" value =<%=machine.getAC() %>></td>
			<th width="130">电池</th>
			<td width="130"><input type="text" name="battery" value =<%=machine.getBattery() %>></td>
		</tr>
		<tr align="center">
			<th width="130">外接光驱</th>
			<td width="260" colspan="2"><input type="text" name="CDDriver" value =<%=machine.getCDDriver() %>></td>
			<th width="130">外接软驱</th>
			<td width="260" colspan="2"><input type="text" name="softDriver" value =<%=machine.getSoftDriver() %>></td>
		</tr>
		<tr align="center">
			<th width="130">机器检查外观</th>
			<td colspan="5"><input type="text" name="outlook" value =<%=machine.getOutlook() %>></td>
		</tr>
		<tr align="center">
			<th width="130">机器故障现象</th>
			<td colspan="5"><input type="text" name="failureAppear" value =<%=machine.getFailureAppear() %>></td>
		</tr>
		<tr align="center">
			<th width="130">其他</th>
			<td colspan="5"><input type="text" name="others" value =<%=machine.getOthers() %>></td>
		</tr>
	</table>

	<table align="center" width="780">
		<tr align="right">
			<td>
				<a href="html/forRepairSet/forRepairSet.jsp"><input type="button" name="return" value="返回"></a>
				<input type="submit" name="submit" value="提交">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>