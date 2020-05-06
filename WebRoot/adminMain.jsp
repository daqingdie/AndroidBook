<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                "http://www.w3.org/TR/html4/losse.dtd">
<html>
<head>
<meta http-equiv="Content=Type" content="text/html;charset=UTF-8">
<title>管理员界面</title>
<style type="text/css">
body {
	background-image: url(images/timg.jpg);
	background-repeat:norepeat;
	margin: 0px;}
	table,td{
font-family:"宋体";
font-size:20px;
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
</head>
<body>
<a href="index.jsp">返回首页</a><div align="center">
<h1><a href="Admin.do?action=seeUser">用户管理</a><br><br><br>
<a href="Admin.do?action=seeBook">图书管理</a><br><br><br>
<a href="Admin.do?action=seeOrder">订单管理</a><br><br><br>

</h1></div>
<br><br><br><br><br><br><br>
	<div class="in_bottom">
    <jsp:include page="foot.jsp"/>
    </div>
</body>
</html>
