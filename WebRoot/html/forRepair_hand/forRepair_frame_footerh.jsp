<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="domain.CustomerSure"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script>
	function print() {
	alert("打印信息~~");
	}
	</script>
</head>
<body>
<form action="../../ForRepairManager_hand" method=" post" name="forRepair_frame_footer" onsubmit="return print()">
   <% CustomerSure customersure = (CustomerSure)request.getAttribute("customersure"); %>
	<table border="1px" bordercolor="#f0fe26" cellspacing="0px" style="border-collapse:collapse" align="center" width=780>
		<tr><th colspan="4">华中科技有限公司取机凭证</th></tr>
		<tr align="center">
			<th>接修日期</th>
			<td><input type="text" name="reserveTime" value =<%=customersure.getReserveTime() %>></td>
			<th>维修编号</th>
			<td><input type="text" name="repairNo" value =<%=customersure.getRepairNo() %>></td>
		</tr>
		<tr align="center">
			<th>产品类型</th>
			<td><input type="text" name="productType" value =<%=customersure.getProductType() %>></td>
			<th>机器品牌</th>
			<td><input type="text" name="machineBrand" value =<%=customersure.getMachineBrand() %>></td>
		</tr>
		<tr align="center">
			<th>机器型号</th>
			<td><input type="text" name="machineVersion" value =<%=customersure.getMachineVersion() %>></td>
			<th>系列号</th>
			<td><input type="text" name="seriesNumber" value =<%=customersure.getSeriesNumber() %>></td>
		</tr>
		<tr align="center">
			<th>单位名称</th>
			<td><input type="text" name="company" value =<%=customersure.getCompany() %>></td>
			<th>联系人</th>
			<td><input type="text" name="linkmen" value =<%=customersure.getLinkmen() %>></td>
		</tr>
		<tr><th colspan="4">机器故障现象</th></tr>
		
		<tr><td colspan="4" align="center"><input type="text" name="failureAppear" value =<%=customersure.getFailureAppear() %>></td></tr>
		<tr>
			<th colspan="2">缺少零件</th>
			<th colspan="2">随机附件</th>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="text" name="lockPart" value =<%=customersure.getLockPart() %>></td>
			<td colspan="2" align="center"><input type="text" name="attachment" value =<%=customersure.getAttachment()%>></td>
		</tr>
	</table>
	<table align="center" width=780>
		<tr>
			<th align="left">接机签字：</th>
			<td><input type="text"></td>
			<th align="left">机主签字：</th>
			<td><input type="text"></td>
			<th align="left">打印时间：</th>
			<td><input type="text"></td>
		</tr>
		<br/>
		<tr><th align="left">说明：</th></tr>
		<td>&nbsp;</td>
	</table>
	<table align="center" width=780>
		<tr>
			<th align="right"><a href="html/forRepair_hand/forRepair_frame_headerh.jsp"><input type="button" name="print" value="提交"></a></th>
		</tr>
	</table>
	</form>
</body>
</html>
