<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="domain.Customer"%>
<!DOCTYPE html>
<html>

<head>
   
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/entering.css">
<script>
	function entering() {
		
		return true;
}
</script>
</head>

<body>
<% Customer customer = (Customer)request.getAttribute("customer"); %>
    <form class="entering_form" action="CustomerManager_update" method="post" name="entering" onsubmit="return entering()">
        <div id="enter_submit">
        <div class="enter_submit">
                <label>客户编号:</label>
                <input type="text" name="customerNo" value =<%=customer.getCustomerNo()%>>
            </div>
            <div class="enter_submit">
                <label>身份证编号：</label>
                <input type="text" name="IDCard" value =<%= customer.getIDCard()%>>
            </div>
            <div class="enter_submit">
                <label>客户送机时间：</label>
                <input type="text" name="deliverTime" value =<%=customer.getDeliverTime() %>>
            </div>
            <div class="enter_submit">
                <label>客户性质:</label>
                <select name="customerType" value =<%=customer.getCustomerType() %>>
                    <option value="家庭用户">家庭用户</option>
                    <option value="单位用户">单位用户</option>
                    <option value="代理商">代理商</option>
                    <option value="签约用户">签约用户</option>
                </select>
            </div>
            <div class="enter_submit">
                <label>单位名称:</label>
                <input type="text" name="company" value =<%= customer.getCompany()%>>
            </div>
            <div class="enter_submit">
                <label>座机:</label>
                <input type="text" name="homePhone" value =<%= customer.getHomePhone()%>>
            </div>
            <div class="enter_submit">
                <label>移动电话:</label>
                <input type="text" name="mobilePhone" value =<%= customer.getMobilePhone()%>>
            </div>
            <div class="enter_submit">
                <label>客户地址:</label>
                <input type="text" name="address" value =<%=customer.getAddress() %>>
            </div>
            <div class="enter_submit">
                <label>邮编:</label>
                <input type="text" name="postcode" value =<%=customer.getPostcode() %>>
            </div>
            <div class="enter_submit">
                <label>联系人:</label>
                <input type="text" name="linkmen" value =<%=customer.getLinkmen() %>>
            </div>
            <div class="enter_submit">
                <label>Email:</label>
                <input type="text" name="email" value =<%=customer.getEmail() %>>
            </div>
        <div class="enter_submit_button">
            <input type="submit" value="修改" onclick="alert('修改成功')">
        </div>
    </div>
    </form>
</body>

</html>
