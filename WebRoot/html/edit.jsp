<%@ page language="java" import="java.util.*,domain.Customer,service.CustomerManagerService" contentType="text/html;" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
CustomerManagerService service = new CustomerManagerService(); 
List<Customer> cusList = service.findAllCustomer();
int i=cusList.size();
 %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script type="text/javascript">

	</script>
</head>

<body>
	<form name="inpu" action="../CustomerManager_query" method="post" onsubmit="return editForm(this)">
		客户编号：<input type="text" name="customerNo">
		<input type="submit" name="update" value="修改">
		<table border="1px" bordercolor="#f0fe26" cellspacing="0px" width="300">
        	<tr>
            	<th>客户编号</th>
            	<th>身份证编号</th>
            	<th>客户送机时间</th>
            	<th>客户性质</th>
            	<th>单位名称</th>
            	<th>座机</th>
            	<th>移动电话</th>
            	<th>客户地址</th>
            	<th>邮编</th>
            	<th>联系人</th>
            	<th>Email</th>
            	<th>&nbsp;</th>
        	</tr>
        	<tr>
            	<%
        	for(;i>0;i--){
        	 %>
        	<tr>
            	<td><%=cusList.get(i-1).getCustomerNo() %></td>
            	<td><%=cusList.get(i-1).getIDCard() %></td>
            	<td><%=cusList.get(i-1).getDeliverTime() %></td>
            	<td><%=cusList.get(i-1).getCustomerType() %></td>
            	<td><%=cusList.get(i-1).getCompany() %></td>
            	<td><%=cusList.get(i-1).getHomePhone() %></td>
            	<td><%=cusList.get(i-1).getMobilePhone() %></td>
            	<td><%=cusList.get(i-1).getAddress() %></td>
            	<td><%=cusList.get(i-1).getPostcode() %></td>
            	<td><%=cusList.get(i-1).getLinkmen() %></td>
            	<td><%=cusList.get(i-1).getEmail() %></td>
            	<td><input type="submit" name="delete" value="删除" ></td>
            	
        	</tr>
        	<%
        	}
        	 %>
    	</table>

	</form>
</body>
</html>