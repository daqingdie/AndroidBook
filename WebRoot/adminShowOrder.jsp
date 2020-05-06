<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
body {
	background-image: url(images/timg.jpg);
	background-repeat:norepeat;
	margin: 0px;}
	table,td{
font-family:"宋体";
font-size:25px;
}
table.altrowstable {
    font-family: verdana,arial,sans-serif;
    font-size:px;
    color:#333333;
    border-width: 1px;
    border-color: #a9c6c9;
    border-collapse: collapse;
}
table.altrowstable th {
    border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #a9c6c9;
}
table.altrowstable td {
    border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #a9c6c9;
}
.oddrowcolor{
    background-color:#d4e3e5;
}
.evenrowcolor{
    background-color:#c3dde0;
} 
form{
align=center;
}
a:link{
    color:red;
}
a:visited{
    color:#63B8FF;
}
a:hover{
    color:green;
}
a:active{
    color:black;
}

</style>
<script type="text/javascript">
function altRows(id){
    if(document.getElementsByTagName){  
        
        var table = document.getElementById(id);  
        var rows = table.getElementsByTagName("tr"); 
         
        for(i = 0; i < rows.length; i++){          
            if(i % 2 == 0){
                rows[i].className = "evenrowcolor";
            }else{
                rows[i].className = "oddrowcolor";
            }      
        }
    }
}

window.onload=function(){
    altRows('alternatecolor');};
</script>
  </head>
  
  <body>
  <a href="adminMain.jsp">返回管理员界面</a>
					<div align="center"><form action="Admin.do?action=searchOrder" method="post" >
						<input type="text" name="ordername" size="50" align="middle"/>
						<input type="submit" value="查询" align="top" style="width: 48px; height: 22px"/>
					</form></div>
<script>
function del(){
var i=window.confirm("您确认删除吗");
return i;
}
</script>				    
    <table class="altrowstable" id="alternatecolor" border="0" width="80%"align="center">
<tbody>
<tr><td>订单编号</td>
	<td>图书书名</td>
	<td>购买数量</td>
	<td>会员昵称</td>
	<td>配送地址</td>
	<td>配送电话</td>
	<td>下单时间</td>
	<td style="width:25%;">订单备注</td>
	<td>操作</td>
	</tr>

<c:forEach var="order" items="${adminSeeOrder}">
<tr>
   		<td>${order.orderId}</td>
   		<td>${order.bookName}</td>
   		<td>${order.orderNumber} </td>
   		<td>${order.orderName}</td>
   		<td>${order.orderAddress}</td>
   		<td>${order.orderPhone}</td>
   		<td>${order.orderTime}</td>
   		<td style="width:25%;">${order.orderMemo}</td>
   		<td><a href="Admin.do?action=selectOrder&id=${order.orderId }">修改</a> <a href="Order.do?action=del&id=${order.orderId }" onclick="return del()">删除</a></td>
   		
   	</tr>
</c:forEach>
</tbody>
</table> 
<br><br><br><br><br><br><br>
	<div class="in_bottom">
    <jsp:include page="foot.jsp"/>
    </div>
  </body>
</html>
