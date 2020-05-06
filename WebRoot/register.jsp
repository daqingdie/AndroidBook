	<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
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
<script language="JavaScript">
function ValidateLoginForm(form)
{
   

   if (form.name.value == "")
   {
      alert("请输入用户名");
      return false
   }
      if (form.password.value == "")
   {
      alert("请输入密码");
      return false
   }
   else if((form.password.value.length<3)||(form.password.value.length>8)){
	alert("密码必须是3-8位字母或数字");
	return false;
}
      if (form.re_password.value == "")
   {
      alert("请输入密码确认");
      return false
   }
   else if(form.password.value!=form.re_password.value){
	
	alert("两次密码不同!");
	return false;
}

   if (form.phone.value == "")
   {
      alert("请输入手机号码");
      return false
   }
   if (form.sex.value == "")
   {
      alert("请输入性别");
      return false
   }
      if (form.address.value == "")
   {
      alert("请输入地址");
      return false
   }
   return true
}
 </script>
</head>

<body>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
 <%@ page import="java.io.PrintWriter" %>
 <%
 if(session.getAttribute("UserName")!=null){
        response.setContentType("text/html;charset=utf-8");
		PrintWriter ou=response.getWriter();
		ou.print("<script language='javascript'>alert('您已登录，无需注册用户');window.location.href='index.jsp';</script>");
		}
  %> 
<!-- bgcolor="#F4F5FF" leftmargin="0" topmargin="0" -->
<div>
	<jsp:include page="head.jsp"/>
</div>
<form name="login" action="<%=path%>/User.do?action=add" method="post" onsubmit="return ValidateLoginForm(this)">
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
										<b>会员注册</b>
									</td>
								</tr>
								<tr align="center" bgcolor="#FFFFFF">
									<td>
										<div align="right">
											会员名称：
										</div>
									</td>
									<td>
									<div align="center">
										<input type="text" name="name">
										</div>
									</td>
								</tr>
								<tr align="center" bgcolor="#FFFFFF">
									<td width="36%">
										<div align="right">
											密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：
										</div>
									</td>
									<td width="64%">
									<div align="center">
										<input name="password" type="password">
										</div>
									</td>
								</tr>
								<tr align="center" bgcolor="#FFFFFF">
									<td>
										<div align="right">
											确认密码：
										</div>
									</td>
									<td>
									<div align="center">
										<input name="re_password" type="password" value="">
										</div>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="25">
										<div align="right">
											手机号码：
										</div>
									</td>
									<td height="25">
										<div align="center">
											<input type="text" name="phone">
										</div>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="25">
										<div align="right">
											性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
										</div>
									</td>
									<td height="25">
										<div align="center">
											<select name="sex">
											<option value="保密">保密</option>
											<option value="男"> 男</option> 
 										   <option value="女">女</option> 
    										</select>
										</div>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="25">
										<div align="right">
											详细地址：
										</div>
									</td>
									<td height="25">
										<div align="center">
											<input type="text" name="address">
										</div>
									</td>
								</tr>
								<tr align="center" bgcolor="#FFFFFF">
									<td colspan="2">
										<input type="submit" value="提交注册" width="50" height="22" border="0">
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
