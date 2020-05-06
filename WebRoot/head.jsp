<%@ page contentType="text/html;charset=gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title></title>
	<link href="css/styles.css" rel="stylesheet" type="text/css"/>
<script src="Scripts/swfobject_modified.js" type="text/javascript"></script>
<style>
body {
	background-image: url(images/timg.jpg);
	background-repeat:norepeat;
	margin: 0px;}
</style>

</head>
<body >
		<div class="head_right">
			<div class="head_right_nei">
				<div class="head_top">
					<div class="head_buy">
					    <div class="head_b1">
						<strong>
							<a href="Cart.do?action=see"style="text-decoration:none;">
								<img height="15" src="images/buy01.jpg" width="16">&nbsp;¹ºÎï³µ
							</a>
							
						</strong> |
						</div>
						<div class="head_u1">
						<a ><form action="User.do?action=out" method="post">
					<table>						
						<tr>					
							<td height="35">
							<% if(session.getAttribute("UserName")!=null)
							{
							%>
							»¶Ó­Äú<%=session.getAttribute("UserName") %>
							
							</td>
						  <td colspan="0" ><input type="submit" value="ÍË³ö" style="background:transparent" /></td>
						  <%   
							}else{%>

                        <td style="font-size: 12pt; 
              color: #ff3333; font-family:ËÎÌå">Ç×,Çë<a href="login.jsp" style="text-decoration:none;color: #ff3333;">µÇÂ¼</a></td>
                          <%
                           }
                           %> 
						</tr>																		
					</table>
					      
							 
					
				</form></a></div>
					</div>
				</div>
				<div class="head_middle" >
				<div class="head_m2" align="center"style="font-size: 18pt;">
					<a class="title01" href="index.jsp" style="text-decoration:none;">
						<span>&nbsp;&nbsp;Ê×Ò³&nbsp;&nbsp;</span>
					</a>					
						<a class="title01" href="login.jsp" style="text-decoration:none;">
							<span>&nbsp;&nbsp;µÇÂ¼&nbsp;&nbsp;</span>
						</a>
						<a class="title01" href="register.jsp"style="text-decoration:none;">
						<span>&nbsp;&nbsp;×¢²á&nbsp;&nbsp;</span>
					</a>
						<a class="title01" href="welcome.jsp"style="text-decoration:none;">
						<span>&nbsp;ÎÒµÄÕË»§&nbsp;&nbsp;</span>
					</a>														
					<!-- <a class="title01" href="#">
						<span>&nbsp;&nbsp;</span>
					</a> -->
					</div>
				</div>
				<div class="head_bottom" >
				    <div class="head_b2" align="center">
					<form action="Book.do?action=search" method="post">
						<input type="text" name="bookname" size="50" align="middle"/>
						<input type="image" name="submit" src="images/search02.jpg" align="top" style="width: 48px; height: 22px"/>
					</form>
				    </div>	
				</div>
			</div>
		</div>
	
<script type="text/javascript">
swfobject.registerObject("FlashID");
    </script>
    
</body>
</html>