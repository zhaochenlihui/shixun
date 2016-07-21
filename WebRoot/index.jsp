<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/DL.css" />
<script type="text/javascript">
function validateForm(form){
	with(form){
		if(form.workerName.value == '' || form.workerName.value==null ){
            alert('用户名为空！');
            return false;
    }
    else if( form.password.value == '' || form.password.value==null ){
            alert('密码为空！')
            return false;
    }  
    else return true;
  }  
	}
	
</script>
</head>
<body>
<nav>华中科技大学设备维修系统</nav>
<div id="login">	
<form name="input" action="workerManager" method="post"  onsubmit="return validateForm(this)">
<div id="name">
账号:
<input type="text" name="workerName" />
</div>
</br>
<div id="password">
密码:
<input type="password" name="password" />
</br>
</div>
<div id="submit">
<input type="submit" value="登录" style="height:25px; width:50px;"><!--有错误-->
<a href="loginF.jsp"><input type="button" value="注册" style="height:25px; width:50px;"></a>
</div>
</form>								
</div>
</body>
</html>
