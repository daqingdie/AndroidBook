<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的信息</title>
    
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
  
  <body >
  <div></div>
  <div><jsp:include page="head.jsp"/></div>
	<table border="0" width="70%"align="center" >
	
	<tbody>
					<tr>
						<td><a href="User.do?action=see">查看我的信息&nbsp;&nbsp;</a>
						</td>
					
						<td><a href="User.do?action=change">&nbsp;&nbsp;修改资料&nbsp;&nbsp;</a>
						</td>						
						<td><a href="Order.do?action=see">&nbsp;&nbsp;我的订单&nbsp;&nbsp;</a></td></tr>
	</tbody></table><br><br><br>
	<table class="altrowstable" id="alternatecolor" border="0" width="70%"align="center"><tbody>
<tr><td>编号</td><td>${user.userId}</td></tr>
<tr>	<td>昵称</td><td>${user.userName}</td></tr>
<tr>	<td>性别</td><td>${user.userSex}</td></tr>
<tr><td>手机号码</td><td>${user.userPhone }</td></tr>
<tr><td>配送地址</td><td>${user.userAddress }</td></tr>

</tbody>
</table>  
	<div class="in_bottom">
    <jsp:include page="foot.jsp"/>
    </div>
</body>
</html>