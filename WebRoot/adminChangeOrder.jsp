<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改订单信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>body {
	background-image: url(images/timg.jpg);
	background-repeat:norepeat;
	margin: 0px;}</style>

</head>

<body>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
 <%@ page import="java.io.PrintWriter" %>
<!-- bgcolor="#F4F5FF" leftmargin="0" topmargin="0" -->
<a href="Admin.do?action=seeOrder">返回查看订单</a><br><br>
<form method="post" action="<%=path%>/Order.do?action=updateOrder&id=${changeOrder.orderId}">
	<table  align="center" width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="12%" height="307" valign="top">
		</td>
		<td width="88%" valign="top">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top">&nbsp;
					
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="19%">&nbsp;
							
						</td>
						<td width="81%" background="image/index_right_bg.gif">
							<form name="form1" method="post" action="register_confirm.jsp">
								<table width="38%" border="0" cellpadding="4" cellspacing="1" bgcolor="#999999">
								<tr align="center" bgcolor="#f6f6f6">
									<td colspan="2">
										<b>修改订单信息</b>
									</td>
								</tr>
								<tr align="center" bgcolor="#FFFFFF">
									<td>
										<div align="right">
											 订单编号：
										</div>
									</td>
									<td>
									<div align="center">
										<input type="text" name="orderid" value="${changeOrder.orderId}" disabled>
										</div>
									</td>
								</tr>
								<tr align="center" bgcolor="#FFFFFF">
									<td width="36%">
										<div align="right">
											图书书名：
										</div>
									</td>
									<td width="64%">
									<div align="center">
										<input type="text" name="bookname" value=${changeOrder.bookName }>
										</div>
									</td>
								</tr>
								<tr align="center" bgcolor="#FFFFFF">
									<td>
										<div align="right">
											购买数量：
										</div>
									</td>
									<td>
									<div align="center">
										<input type="text" name="ordernumber" value=${changeOrder.orderNumber }>
										</div>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="25">
										<div align="right">
											配送姓名：
										</div>
									</td>
									<td height="25">
										<div align="center">
											<input type="text" name="ordername" value="${changeOrder.orderName}" disabled>
										</div>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="25">
										<div align="right">
											 配送地址：
										</div>
									</td>
									<td height="25">
										<div align="center">
											<input type="text" name="orderaddress" value="${changeOrder.orderAddress}" >
										</div>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="25">
										<div align="right">
											  配送电话：
										</div>
									</td>
									<td height="25">
										<div align="center">
											<input type="text" name="orderphone" value="${changeOrder.orderPhone}">
										</div>
									</td>
								</tr>
<tr bgcolor="#FFFFFF">
									<td height="25">
										<div align="right">
											 下单时间：
										</div>
									</td>
									<td height="25">
										<div align="center">
											<input type="text" name="ordertime" value="${changeOrder.orderTime}" disabled>
										</div>
									</td>
								</tr>
<tr bgcolor="#FFFFFF">
									<td height="25">
										<div align="right">
											  订单备注：
										</div>
									</td>
									<td height="25">
										<div align="center">
											<input type="text" name="ordermemo" value="${changeOrder.orderMemo}">
										</div>
									</td>
								</tr>
								<tr align="center" bgcolor="#FFFFFF">
									<td colspan="2">
										<input type="submit" value="确定修改" width="50" height="22" border="0">
									</td>
								</tr>
								</table>
								<span class="top">
							</form>
						</td>
					</tr>
			
			<tr>
				<td>
					<span class="top">
				</td>
			</tr>
	
</form>
<div class="in_bottom">
	<jsp:include page="foot.jsp"/>
</div>
</body>
</html>
