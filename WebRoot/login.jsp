<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会员登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
body {
	background-image: url(images/timg.jpg);
	background-repeat:norepeat;
	margin: 0px;}
.log_top{
    float:;
}
table,td{
font-family:"宋体";
font-size:12px;
}
.inputtext{
border-left:1px solid balck;
border-right:1px solid balck;
border-top:1px solid balck;
border-bottom:1px solid balck;
}
.loginbg {
font-size: 12px;
width: 59px;
height: 26px;
background-image: url(images/login_bg.gif);
border: none;
padding-top: 3px;
color:white;
</style>
<script language="JavaScript">
function show()
{
   
   if (login.usernme.value == "")
   {
      alert("请输入用户名");
      return false
   }
      if (login.password.value == "")
   {
      alert("请输入密码");
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
		ou.print("<script language='javascript'>alert('您已登录，无需再次登录');window.location.href='index.jsp';</script>");
		}
  %>
  <div class=log_top><jsp:include page="head.jsp"/></div>
  
    <form action="<%=path%>/User.do?action=check" name="login" method="post" >
<table width="100%" height="98" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<!-- <table width="50%" align="center" height="34" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="images/log00.gif" width="291" height="34"></td>
  </tr>
</table> -->
<table width="100%" height="30" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="50%" height="261" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="457" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="3"><img src="images/log01.gif" width="457" 
        height="40" border="0" usemap="#Map"></td>
      </tr>
      <tr>
        <td width="142" rowspan="3"><img src="images/log02.gif" width="142" height="221"></td>
        <td width="240" valign="top"><img src="images/log03.gif" width="240" height="42"></td>
        <td width="75" rowspan="3"><img src="images/log04.gif" width="75" height="221"></td>
      </tr>
      <tr>
        <td height="107" valign="top" background="images/log05.gif">
		<table width="75%"  align="center" height="100%" border="0" 
		cellpadding="0" cellspacing="0">                  
         <td width="24%" height="30">用户名:</td>
          <td width="76%" height="30"><input type="text" name="username" 
          
          size="15" class="inputtext"></td>
           </tr>
           <tr>
          <td height="25">密&nbsp;&nbsp;码:</td>
         <td height="25"><input type="password" name="password" 
         size="15" class="inputtext"></td>                 
                  </tr>
                  <tr>
                    <td height="25" colspan="2"><p align="center">
                    <input type="submit" value="登 录" class="loginbg">
                    <!-- <input type="hidden" name="action"value="userlogin">&nbsp;&nbsp; -->
                    <input type="reset" value="取 消" class="loginbg" onclick="show()"></td>
                   </tr>
                </table></td>
      </tr>
      <tr>
        <td valign="bottom"><img src="images/log06.gif" width="240" height="72"></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
<div class="in_bottom">
    <jsp:include page="foot.jsp"/>
    </div>
  </body>
</html>
