<%@ page language="java" import="java.util.*,domain.Repair,service.RepairManagerService" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
RepairManagerService service = new RepairManagerService();
List<Repair> cusList = service.findAllRepair();
int i=cusList.size();
%>
<html>
    <head>
      <meta charset="utf-8">
      <script type="text/javascript">
        function repairForm(form){
          return true;
        }
      </script>
    </head>
    
    <body>
      <form action="" method="post" onsubmit="return repairForm(this)">
        <table border="1px" bordercolor="#f0fe26" cellspacing="0px" width="800">
          <tr>
            <th>维修编号</th>
            <th>维修状态</th>
            <th>维修人员</th>
            <th>检测记录</th>
            <th>工作量</th>
            <th>维修记录</th>
            <th>维修检测时间(h)</th>
            <th>维修使用的器件</th>
          </tr>
          <%
            for(;i>0;i--){
          %>
          <tr>
            <td><%=cusList.get(i-1).getRepairNo() %></td>
            <td><%=cusList.get(i-1).getRepairState() %></td>
            <td><%=cusList.get(i-1).getRepairWork() %></td>
            <td><%=cusList.get(i-1).getTestRecord() %></td>
            <td><%=cusList.get(i-1).getWorkAmount() %></td>
            <td><%=cusList.get(i-1).getRepairRecord() %></td>
            <td><%=cusList.get(i-1).getTestTime() %></td>
            <td><%=cusList.get(i-1).getUsePart() %></td>
            <td><input type="button" name="give" value="分配" onclick="javascript:location.href='Repair_person.jsp'" ></td>   
          </tr> 
          <% 
          }
          %>
        </table>
      </form>
    </body>
    
    <font color="red">(维修状态：0-未分配，1-分配未检测，2-检测完成维修未完成，3-维修完成) <br/>
    </font>
</html>
