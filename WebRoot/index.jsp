<%@ page language="java" pageEncoding="UTF-8"
	     contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>网上二手书交易平台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
<style>

</style>
	
  </head> 
  <body>
  <div>
  	<jsp:include page="head.jsp"/>
  	<jsp:include page="main.jsp"/>
  	<div class="in_bottom"><br><br><br><br><br><br><br>
    <jsp:include page="foot.jsp"/>
    </div>
    </div>
  </body>
</html>
