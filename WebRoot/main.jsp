<%@ page language="java" pageEncoding="UTF-8"
contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*" %>

<jsp:directive.page import="cc.Book.test.DbManager"/>
<jsp:directive.page import="cc.Book.test.Pagination"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>网上二手书交易平台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- <style type="text/css">body, td, th, input {font-size:12px; text-align:center; }</style> -->
<style>
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

table.altrowstable {
    font-family: verdana,arial,sans-serif;
    font-size:11px;
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
  <body>
  <%
	final int pageSize = 20;	// 一页显示 20 条记录

	int pageNum = 1; 			// 当前页数
	int pageCount = 1;			// 总页数

	int recordCount = 0;		// 总记录数
	
	try{
		// 从地址栏参数取当前页数
		pageNum = Integer.parseInt(request.getParameter("pageNum"));
	}catch(Exception e){}
	
	String sql = null;	
	Connection conn = null;
	PreparedStatement preStmt = null;
	ResultSet rs = null;

	try{
		sql = "SELECT count(*) FROM book ";		
		recordCount = DbManager.getCount(sql);				
		pageCount = (recordCount + pageSize - 1) / pageSize;// 计算总页数		
		int startRecord = (pageNum - 1) * pageSize;// 本页从 startRecord 行开始				
		sql = "SELECT * FROM book  LIMIT ?, ? ";// MySQL 使用limit实现分页		
		conn = DbManager.getConnection();
		preStmt = conn.prepareStatement(sql);
		DbManager.setParams(preStmt, startRecord, pageSize);
		rs = preStmt.executeQuery();
%>
<!--  <h2>首页</h2>   -->
 <!--    <hr>  -->  
    <table class="altrowstable" id="alternatecolor" border="0" width="95%"align="center">  
        <tr bgcolor="#dddddd">  
            <td  align="center" >书名</td>   
            <td align="center">作者</td>  
            <td align="center" >出版社</td> 
            <td align="center"  width="30%">图书简介</td>
            <td align="center" >库存</td>
            <td align="center" >价格</td> 
            <td align="center" >操作</td>      
        </tr>  
        <%  
            String name,con,aut,sum,id;
            int num;double pri; 
            //将查询结果集中的记录输出到页面上  
            while (rs.next()){  
                //从当前记录中读取各字段的值 
                id=rs.getString("bookId").trim();
                name = rs.getString("bookName").trim();  
                con= rs.getString("bookConcern").trim();  
                aut = rs.getString("bookAuthor").trim();  
                sum= rs.getString("bookSummary").trim();  
                num =Integer.valueOf(rs.getString("bookNumber").trim());
                pri = Double.valueOf(rs.getString("bookPrice").trim());  
                if(num>0){  
                out.println("<tr>");  
                out.println("<td align='center'>"+name+"</td>");  
                out.println("<td align='center'>");  
                out.println( con +"</td>");  
                out.println("<td align='center'>"+ aut +"</td>");  
                out.println("<td align='center'>"+ sum +"</td>");  
                out.println("<td align='center'>"+ num +"</td>"); 
                out.println("<td align='center'>"+ pri +"</td>");   
                out.println("</td>");  
                out.println("<td align='center'><a  href='Cart.do?action=add&id="+id+"'>加入购物车</a></td>");  
                out.println("</tr>");  }
            }  
        %>         
    </table>  
    <table align="center"><tr><td> <%= Pagination.getPagination(pageNum, pageCount, recordCount, request.getRequestURI()) %> </td></tr></table>
  <br/><br/><br/>
  
  </body>
  <%
	}catch(SQLException e){
		out.println("执行SQL：" + sql + "时发生异常：" + e.getMessage());
		e.printStackTrace();
	}finally{
		if(rs != null)	rs.close();
		if(preStmt != null)	preStmt.close();
		if(conn != null)	conn.close();
	}
%>
</html>
