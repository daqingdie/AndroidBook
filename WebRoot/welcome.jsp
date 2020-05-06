<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户界面</title>
    
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
} a:link{
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
}</style>
  </head>
  
  <body >
 <%@ page import="javax.servlet.http.HttpServletRequest" %>
 <%@ page import="java.io.PrintWriter" %>
 <%
 if(session.getAttribute("UserName")==null){
        response.setContentType("text/html;charset=utf-8");
		PrintWriter ou=response.getWriter();
		ou.print("<script language='javascript'>alert('您还未登录，请先登录');window.location.href='login.jsp';</script>");
		}
  %>
  <div>
  <div><jsp:include page="head.jsp"/></div>
  <div>
	<table align="center" style="font-size: 30pt;  font-family:宋体">
		<tr>
			<td>
				<table>
					<tr>
						<td><a href="User.do?action=see">查看我的信息&nbsp;&nbsp;</a>
						</td>
					
						<td><a href="User.do?action=change">&nbsp;&nbsp;修改资料&nbsp;&nbsp;</a>
						</td>						
						<td><a href="Order.do?action=see">&nbsp;&nbsp;我的订单&nbsp;&nbsp;</a>
						</td>
						
					</tr>
					
				</table></td>

		</tr>
	</table>
	</div>  
	<div class="in_bottom">
    <jsp:include page="foot.jsp"/>
    </div>
    </div>
</body>
</html>