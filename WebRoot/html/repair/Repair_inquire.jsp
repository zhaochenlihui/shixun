<%@ page language="java" import="java.util.*,service.RepairManagerService,domain.Repair" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
RepairManagerService service = new RepairManagerService(); 
List<Repair> cusList = service.findAllRepair();
int i=cusList.size();
int repairNo;
 %>
<html>
    <head>
      <meta charset="utf-8">
      <script type="text/javascript">
        function inquire_no() {
         
          return true;
      }
    </script>
    </head>
    
    <body>
      <form action="../../RepairManager_inquire" method="post" name="inquire_no" onsubmit="return inquire_no()">
        请输入编号：<input type="text" name="repairNo">
        <input type="submit" name="update" value="修改">
        <a href="../../RepairManager_delete"><input type="submit" name="inquire" value="查找"></a>
        <a href="Repair_add.jsp"> <input type="button" name="add" value="添加" ></a>
     </form>
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
          <form action="../../RepairManager_delete">
          <%
          
            for(;i>0;i--){
          %>
          
          <tr>
            <td><input type="text" name="repairNo" style="display:none"><%=cusList.get(i-1).getRepairNo() %></td>
            <td><%=cusList.get(i-1).getRepairState() %></td>
            <td><%=cusList.get(i-1).getRepairWork() %></td>
            <td><%=cusList.get(i-1).getTestRecord() %></td>
            <td><%=cusList.get(i-1).getWorkAmount() %></td>
            <td><%=cusList.get(i-1).getRepairRecord() %></td>
            <td><%=cusList.get(i-1).getTestTime() %></td>
            <td><%=cusList.get(i-1).getUsePart() %></td> 
            <td><input type="submit" value="删除"></td>
             
          </tr> 
          <% 
          }
          %>
          </form>
        </table>

     
      
      <font color="red">(维修状态：0-未分配，1-分配未检测，2-检测完成维修未完成，3-维修完成) 
      <br/>
      </font>
    </body>
</html>
