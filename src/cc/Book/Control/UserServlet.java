package cc.Book.Control;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.Book.DaoImpl.UserDaoImpl;

import cc.Book.JavaBean.User;

import cc.Book.service.UserService;

import cc.Book.serviceImpl.UserServiceImpl;
@WebServlet("/User.do")
public class UserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService us=new UserServiceImpl();             //创建用户服务类对象
		request.setCharacterEncoding("UTF-8");					
		response.setContentType("text/html;charset=UTF-8");
		String type=request.getParameter("action");		//获取页面传递的操作类型
		
		if(type.equals("check")){             //用户登录系统
			try{
			    String name=request.getParameter("username");      //获取用户名
			    String password=request.getParameter("password");	//获取密码
			    if(us.login(name, password)){						//数据库是否有匹配的数据
			    HttpSession session=request.getSession();
				session.setAttribute("UserName",name);				//存放登录凭证
				//跳转回首页
				RequestDispatcher dispatcher= request.getRequestDispatcher("/index.jsp");  
				dispatcher.forward(request, response);
			    }else{
			    	//弹窗报错并跳转回登录页面
			    	response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.print("<script language='javascript'>alert('账号密码有误，请重新输入');window.location.href='login.jsp';</script>");
			    }

				}
			catch(Exception e)                          
			{
			}
		}
		
		if(type.equals("add")){         //注册为用户
			try{
				//获取数据并封装
				User user=new User();
				String name=request.getParameter("name");
				String password=request.getParameter("password");
				String sex=request.getParameter("sex");
				String phone=request.getParameter("phone");
				String address=request.getParameter("address");
				user.setUserName(name);
				user.setUserPassword(password);
				user.setUserSex(sex);
				user.setUserAddress(address);
				user.setUserPhone(phone);
				if(us.isRight(user).equals("正确")){ //检验数据是否合法
					if(!us.isExist(name)){          //检验用户名是否存在
						us.addUser(user);           //新增用户
						//弹窗提示成功并跳转到登录页面
						response.setContentType("text/html;charset=utf-8");
						PrintWriter out=response.getWriter();
						out.print("<script language='javascript'>alert('注册成功，点击确定返回登录页面');window.location.href='login.jsp';</script>");
					}else{
						//弹窗报错并跳转回注册页面
						response.setContentType("text/html;charset=utf-8");
						PrintWriter out=response.getWriter();
						out.print("<script language='javascript'>alert('该用户名已存在，请重新输入');window.location.href='register.jsp';</script>");
					}
					
				}else{
					//弹窗报错并跳转回注册页面
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.print("<script language='javascript'>alert('"+us.isRight(user)+"');window.location.href='register.jsp';</script>");
				}
				
				
				
			}catch(Exception e){
				
			}
		}
		
		if(type.equals("out")){      //用户登出系统
			try{ 
				HttpSession session = request.getSession();
	            session.removeAttribute("UserName");   //清除登录凭证
	            response.sendRedirect("index.jsp");		//跳转回首页
				
			}catch(Exception e){
				
			}
		}
		
		if(type.equals("see")){      //用户查看个人信息
			try{ 
				HttpSession session = request.getSession();
				String name=String.valueOf(session.getAttribute("UserName")); //获取当前用户信息
				//查询，封装，跳转
				List<User> see=null;
				see=us.see(name);
				User user=see.get(0);
				session.setAttribute("user", user);
				RequestDispatcher dispatcher= request.getRequestDispatcher("/showUser.jsp");  
				dispatcher.forward(request, response); 	
				
			}catch(Exception e){
				
			}
		}
		if(type.equals("change")){  //用户想要修改个人信息
			try{
				//获取，查询，封装，跳转
				HttpSession session = request.getSession();
				String name=String.valueOf(session.getAttribute("UserName"));
				List<User> change=null;
				change=us.see(name);
				User user=change.get(0);
				session.setAttribute("changeUser",user);
				RequestDispatcher dispatcher= request.getRequestDispatcher("/changeUser.jsp");  
				dispatcher.forward(request, response); 	
		}catch(Exception e){
		}
	}
		
		if(type.equals("update")){   //用户修改个人信息
			try{
				//获取，检验，获取，封装，检验，更新，跳转
				String pad_1=request.getParameter("password_1");
				String pad_2=request.getParameter("password_2");
				if(pad_1.equals(pad_2)){
					HttpSession session = request.getSession();
					String name=String.valueOf(session.getAttribute("UserName"));
					String sex=request.getParameter("usersex");
					String addr=request.getParameter("useraddress");
					String pho=request.getParameter("userphone");
					User user=new User();
					user.setUserName(name);
					user.setUserPassword(pad_1);
					user.setUserSex(sex);
					user.setUserPhone(pho);
					user.setUserAddress(addr);
					if(us.isRight(user).equals("正确")){
						us.changeUser(user);
						response.setContentType("text/html;charset=utf-8");
						PrintWriter out=response.getWriter();
						out.print("<script language='javascript'>alert('修改成功，点击确认查看我的信息');window.location.href='User.do?action=see';</script>");
					}else{
						response.setContentType("text/html;charset=utf-8");
						PrintWriter out=response.getWriter();
						out.print("<script language='javascript'>alert('"+us.isRight(user)+"');window.location.href='User.do?action=change';</script>");
					}
					
					
				}else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.print("<script language='javascript'>alert('两次密码输入不同，请重新输入');window.location.href='User.do?action=change';</script>");
				}
				
			}catch(Exception e){
				
			}
		}
		
		if(type.equals("updateUser")){     //管理员修改用户信息
			try{
				//获取，封装，检验，更新，跳转
				HttpSession session = request.getSession();
				int id=Integer.valueOf(request.getParameter("id"));
				String name=String.valueOf(session.getAttribute("Username"));
				String psd=String .valueOf(session.getAttribute("Password"));
				String sex=request.getParameter("usersex");
				String addr=request.getParameter("useraddress");
				String pho=request.getParameter("userphone");
				User user=new User();
				user.setUserId(id);
				user.setUserName(name);
				user.setUserPassword(psd);
				user.setUserSex(sex);
				user.setUserPhone(pho);
				user.setUserAddress(addr);
				if(us.isRight(user).equals("正确")){
						us.changeUserOfId(user);
						response.setContentType("text/html;charset=utf-8");
						PrintWriter out=response.getWriter();
						out.print("<script language='javascript'>alert('修改成功');window.location.href='Admin.do?action=seeUser';</script>");
					
				}else {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.print("<script language='javascript'>alert('"+us.isRight(user)+"');window.location.href='Admin.do?action=selectUser&id="+id+"';</script>");
				}
				
				
			}catch(Exception e){
				
			}
		}
		
		if(type.equals("del")){                //管理员删除用户
			try{
				//获取，删除，跳转
				int id=Integer.valueOf(request.getParameter("id"));
				us.delUser(id);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('删除成功');window.location.href='Admin.do?action=seeUser';</script>");
			}catch(Exception e){
				
			}
		}
		
}
	
		
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doPost(request,response);
		}

}
