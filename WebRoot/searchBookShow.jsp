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
    
    <title>图书查询</title>
    
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
aa{
font-family:"黑体";
font-size:30px;
} 
</style>
  </head>
  
  <body >
  <div>
  <div><jsp:include page="head.jsp"/></div>
	<table style="text-align: left; width:100%;" border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr><td align="center" width="100">书名</td>   
            <td align="center">作者</td>  
            <td align="center" >出版社</td> 
            <td align="center" >图书简介</td>
            <td align="center" >库存</td>
            <td align="center" >价格</td> 
            <td align="center" >操作</td>      
	</tr>

<c:forEach var="book" items="${books}">
<tr>
   		<td align="center" width="100">${book.bookName }</td>   
            <td align="center">${book.bookAuthor }</td>  
            <td align="center" >${book.bookConcern}</td> 
            <td align="center" >${book.bookSummary}</td>
            <td align="center" >${book.bookNum }</td>
            <td align="center" >${book.bookPrice}</td> 
            <td align="center" ><a href="Cart.do?action=add&id=${book.bookId }" >加入购物车</a></td>      
   	</tr>
</c:forEach>
</tbody>
</table> 
	<div class="in_bottom">
    <jsp:include page="foot.jsp"/>
    </div>
    </div>
</body>
</html>