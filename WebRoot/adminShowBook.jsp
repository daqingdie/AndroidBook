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
    
    <title>管理图书</title>
    
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
  
  <body>
  <a href="adminMain.jsp">返回管理员界面</a>
  <div align="center">
					<form action="Admin.do?action=searchBook" method="post">
						<input type="text" name="bookname" size="50" align="middle"/>
						<input type="submit" value="查询" align="top" style="width: 48px; height: 22px"/>
					</form></div>
					<div align="center"><a href="addBook.jsp">新增图书</a></div>
<script>
function del(){
var i=window.confirm("您确认删除吗");
return i;
}
</script>				    
    <table class="altrowstable" id="alternatecolor" border="0" width="70%"align="center">
<tbody>
<tr><td align="center">图书编号</td>
	<td align="center">图书书名</td>
	<td align="center">图书作者</td>
	<td align="center">图书出版社</td>
	<td align="center">图书库存</td>
	<td align="center">图书单价</td>
	<td style="width:30%;" align="center">图书简介</td>
	<td align="center">操作</td>
	</tr>

<c:forEach var="book" items="${adminSeeBook}">
<tr>
   		<td align="center">${book.bookId}</td>
   		<td align="center">${book.bookName}</td>
   		<td align="center">${book.bookAuthor}</td>
   		<td align="center">${book.bookConcern}</td>
   		<td align="center">${book.bookNum}</td>
   		<td align="center">${book.bookPrice}</td>
   		<td style="width:35%;" >${book.bookSummary }</td>
   		<td align="center"><a href="Admin.do?action=selectBook&id=${book.bookId }">修改</a> <a href="Book.do?action=del&id=${book.bookId }" onclick="return del()">删除</a></td>
   		
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
