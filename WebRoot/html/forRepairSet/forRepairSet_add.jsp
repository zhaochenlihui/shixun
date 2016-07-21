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
		function forRepairSet_addForm() {
			return ture;
		}
	</script>
</head>
<body>
<form action="../../MachineManager" method="post" name="forRepairSet_add" onsubmit="return forRepairSet_addForm()">
	<table>
		<tr>
			<td>维修编号：</td><td><input type="text" name="repairNo"></td>
			<td>&nbsp;</td>
			<td>机器外观检查：</td><td><input type="text" name="outlook"></td>
		</tr>
		<tr>
			<td>客户编号：</td><td><input type="text" name="customerNo"></td>
			<td>&nbsp;</td>
			<td>开机口令：</td><td><input type="text" name="onPassword"></td>
		</tr>
		<tr>
			<td>产品类型:</td>
			<td>
				<select name="productType">
					<option value="台式机">台式机</option>
					<option value="笔记本">笔记本</option>
					<option value="投影仪">投影仪</option>
					<option value="打印机">打印机</option>
					<option value="其他">其他</option>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>重要资料：</td><td><input type="text" name="importantM"></td>
		</tr>
		<tr>
			<td>报修时间：</td><td><input type="text" name="deliverTime"></td>
			<td>&nbsp;</td>
			<td>HDD：</td><td><input type="text" name="HDD"></td>
		</tr>
		<tr>
			<td>预估价格：</td><td><input type="text" name="previewCost"></td>
			<td>&nbsp;</td>
			<td>内存：</td><td><input type="text" name="memory"></td>
		</tr>
		<tr>
			<td>报修状态：</td>
			<td>
				<select name="deliverState">
					<option value="未打印">未打印</option>
					<option value="打印">打印</option>
					<option value="提交">提交</option>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>外置PC卡：</td><td><input type="text" name="pcCard"></td>
		</tr>
		<tr>
			<td>机器品牌：</td><td><input type="text" name="machineBrand"></td>
			<td>&nbsp;</td>
			<td>AC适配器：</td><td><input type="text" name="AC"></td>
		</tr>
		<tr>
			<td>机器型号：</td><td><input type="text" name="machineVesion"></td>
			<td>&nbsp;</td>
			<td>电池：</td><td><input type="text" name="battery"></td>
		</tr>
		<tr>
			<td>系列号：</td><td><input type="text" name="seriesNumber"></td>
			<td>&nbsp;</td>
        	<td>外接光驱：</td><td><input type="text" name="CDDriver"></td>
		</tr>
		<tr>
			<td>缺少零件：</td><td><input type="text" name="lackPart"></td>
			<td>&nbsp;</td>
			<td>其他：</td><td><input type="text" name="others"></td>
		</tr>
		<tr><td>机器故障现象：</td><td><input type="text" name="failureAppear"></td></tr>
		<tr>
			<td>故障类型：</td>
			<td>
				<select name="failureType">
					<option value="固定性故障">固定性故障</option>
					<option value="间隙性故障">间隙性故障</option>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td align="right"><input type="submit" name="handIn" value="提交"></td>
		</tr>
		
	</table>
	</form>
</body>
</html>