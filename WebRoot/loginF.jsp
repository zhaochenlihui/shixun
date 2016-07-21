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
		function loginForm(f){
			if(f.workerNo==0){
				alert('职工编号为空！');
				return false;
			}
			else if(f.workerName==null || f.workerName==''){
				alert('用户名为空！');
				return false;
			}
			else if(f.password==null || f.password==''){
				alert('密码为空！');
				return false;
			}
			else if(f.workerType==null || f.workerType==''){
				alert('工作类型为空！');
				return false;
			}
			else return ture;
		}
	</script>
</head>
<body>
	<form action="WorkerManager_add" method="post" onsubmit="return loginForm(this)">
		<table>
			<tr><td>职工编号：</td><td><input type="text" name="workerNo"></td></tr>
			<tr><td>用户名：</td><td><input type="text" name="workerName"></td></tr>	
			<tr><td>密码：</td><td><input type="password" name="password"></td></tr>	
			<tr>
				<td>工作类型：</td>	
				<td>
					<select name="workerType">
						<option value="客服人员">客服人员</option>
						<option value="技术工程师">技术工程师</option>
						<option value="财务人员">财务人员</option>
						<option value="任务调度员">任务调度员</option>
						<option value="库管人员">库管人员</option>
						<option value="运营监督员">运营监督员</option>
					</select>
				</td>
			</tr>
			<tr><td>&nbsp;</td><td align="right"><input type="submit" name="" value="注册"></td></tr>
		</table>
	</form>
</body>
</html>