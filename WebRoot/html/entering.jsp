<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head>
    <title>entering</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/entering.css">
<script>
	function entering() {
		
		return true;
}
</script>
</head>

<body>
    <form class="entering_form" action="../CustomerManager" method="post" name="entering" onsubmit="return entering()">
        <div id="enter_submit">
        <div class="enter_submit">
                <label>客户编号:</label>
                <input type="text" name="customerNo" />
            </div>
            <div class="enter_submit">
                <label>身份证编号：</label>
                <input type="text" name="IDCard" />
            </div>
            <div class="enter_submit">
                <label>客户送机时间：</label>
                <input type="text" name="deliverTime" />
            </div>
            <div class="enter_submit">
                <label>客户性质:</label>
                <select name="customerType">
                    <option value="家庭用户">家庭用户</option>
                    <option value="单位用户">单位用户</option>
                    <option value="代理商">代理商</option>
                    <option value="签约用户">签约用户</option>
                </select>
            </div>
            <div class="enter_submit">
                <label>单位名称:</label>
                <input type="text" name="company" />
            </div>
            <div class="enter_submit">
                <label>座机:</label>
                <input type="text" name="homePhone" />
            </div>
            <div class="enter_submit">
                <label>移动电话:</label>
                <input type="text" name="mobilePhone" />
            </div>
            <div class="enter_submit">
                <label>客户地址:</label>
                <input type="text" name="address" />
            </div>
            <div class="enter_submit">
                <label>邮编:</label>
                <input type="text" name="postcode" />
            </div>
            <div class="enter_submit">
                <label>联系人:</label>
                <input type="text" name="linkmen" />
            </div>
            <div class="enter_submit">
                <label>Email:</label>
                <input type="text" name="email" />
            </div>
        <div class="enter_submit_button">
            <input type="submit" value="提交 " onclick="alert('添加成功')">
        </div>
    </div>
    </form>
</body>

</html>
