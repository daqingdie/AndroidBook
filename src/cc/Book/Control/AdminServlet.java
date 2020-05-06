package cc.Book.Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.Book.JavaBean.*;
import cc.Book.service.AdminService;
import cc.Book.serviceImpl.AdminServiceImpl;

@WebServlet("/Admin.do")
public class AdminServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * 负责管理员的登陆和管理员对图书、用户、订单查询的操作
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AdminService adm=new AdminServiceImpl();           //创建管理员服务类对象
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String type=request.getParameter("action");       //获取页面传来的数据操作类型

		if(type.equals("check")){ //管理员登录验证
			if(request.getParameter("id").matches("[0-9]{1,}")){ //验证管理员ID是否为数字
				try{
					int id=Integer.valueOf(request.getParameter("id")); //获取Id
					String password=request.getParameter("password");  //获取密码
					if(adm.longin(id, password)){                      //检验数据库是否有匹配的数据
						String admin="管理员";                         
						HttpSession session=request.getSession();      
						session.setAttribute("admin",admin);           //把管理员登录凭证放进session（暂未使用）
						RequestDispatcher dispatcher= request.getRequestDispatcher("/adminMain.jsp");  //跳转到管理员主界面
						dispatcher.forward(request, response);
					}else{
						//弹窗报错且调回管理员登录页面
						response.setContentType("text/html;charset=utf-8");
						PrintWriter out=response.getWriter();
						out.print("<script language='javascript'>alert('ID或密码有误，请重新输入');window.location.href='adminLogin.jsp';</script>");
					}
					
				}catch(Exception e ){
					
				}
			}else{
				//弹窗报错且调回管理员登录页面
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('ID或密码有误，请重新输入');window.location.href='adminLogin.jsp';</script>");
			}
			
			
			
		}
		if(type.equals("seeOrder")){                         //管理员查看订单信息
			try{
				HttpSession session=request.getSession();
				List<Orders> orders=null;
				orders=adm.seeOrder();                       //查看全部订单信息
				session.setAttribute("adminSeeOrder", orders);     //把结果存放到session
				RequestDispatcher dispatcher= request.getRequestDispatcher("/adminShowOrder.jsp");  //跳转到订单管理页面
				dispatcher.forward(request, response); 			 
				
			}catch(Exception e){
				
			}
		}
		
		if(type.equals("seeUser")){                         //管理员查看用户信息
			try{
				HttpSession session=request.getSession();
				List<User> users=null;
				users=adm.seeUser();                      //查看全部用户信息
				session.setAttribute("adminSeeUser",users);   //把结果存放到session
				RequestDispatcher dispatcher= request.getRequestDispatcher("/adminShowUser.jsp");   //跳转到用户管理界面
				dispatcher.forward(request, response); 			
				
			}catch(Exception e){
				
			}
		}

		if(type.equals("seeBook")){                       //管理员查看图书信息
			try{
				HttpSession session=request.getSession();
				List<Book> Books=null;
				Books=adm.seeBook();                        //查看全部图书信息
				session.setAttribute("adminSeeBook",Books);  //把结果存放到session
				RequestDispatcher dispatcher= request.getRequestDispatcher("/adminShowBook.jsp");    //跳转到图书管理界面
				dispatcher.forward(request, response); 			
				
			}catch(Exception e){
				
			}
		}
		
		if(type.equals("searchBook")){                   //管理员查找图书
			try{
				String name=request.getParameter("bookname");   //获取管理员输入的图书书名
				List<Book> books=null;
				books=adm.searchBook(name);                     //根据书名查询图书信息
				HttpSession session=request.getSession();
				session.setAttribute("adminSeeBook",books);     //把结果存放到session
				RequestDispatcher dispatcher= request.getRequestDispatcher("/adminShowBook.jsp");  //跳转到图书管理界面
				dispatcher.forward(request, response); 
			}catch(Exception e){
				
			}
		} 
		if(type.equals("searchUser")){                        //管理员查找用户
			try{
				String name=request.getParameter("username");      //获取管理员输入的用户名
				HttpSession session=request.getSession();
				List<User> users=null;
				users=adm.searchUser(name);                       //根据用户名查询用户信息
				session.setAttribute("adminSeeUser",users);       //把结果存放到session
				RequestDispatcher dispatcher= request.getRequestDispatcher("/adminShowUser.jsp");   //跳转到用户管理界面
				dispatcher.forward(request, response); 			
				
			}catch(Exception e){
				
			}
			
		}
		
		if(type.equals("searchOrder")){                       // 管理员查找订单
			try{
				String name=request.getParameter("ordername");   //获取管理员输入的订单配送姓名
				HttpSession session=request.getSession();
				List<Orders> orders=null;
				orders=adm.searchOrders(name);                    //根据配送姓名查询订单信息
				session.setAttribute("adminSeeOrder",orders);     //把结果存放到session
				RequestDispatcher dispatcher= request.getRequestDispatcher("/adminShowOrder.jsp");    //挑战到订单管理界面
				dispatcher.forward(request, response); 			
				
			}catch(Exception e){
				
			}
			
		}
		
		if(type.equals("selectBook")){                       //管理员想要修改某本图书信息
			try{
				HttpSession session = request.getSession();
				int  id=Integer.valueOf(request.getParameter("id"));   //获取选中的图书的图书编号
				List<Book> books=null;
				books=adm.changeBook(id);                              //根据编号查询该图书信息
				Book book=new Book();
				book=books.get(0);                                     
				session.setAttribute("changeBook",book);               //把图书信息村存放到session
				session.setAttribute("oldname", book.getBookName());   //把图书旧书名存放到session
				RequestDispatcher dispatcher= request.getRequestDispatcher("/adminChangeBook.jsp");  //跳转到管理员修改图书信息页面
				dispatcher.forward(request, response); 	
			}catch(Exception e){
				
			}
			
		}
		
		if(type.equals("selectUser")){                       //管理员想要修改某用户信息
			try{
				HttpSession session = request.getSession();
				int  id=Integer.valueOf(request.getParameter("id"));  //获取选中的用户编号
				List<User> users=null;
				users=adm.changeUser(id);                             //根据编号查询用户
				User user=new User();
				user=users.get(0);
				session.setAttribute("Username",user.getUserName());   //把用户名存放到session
				session.setAttribute("Password",user.getUserPassword()); //把用户密码存放到session
				session.setAttribute("changeUser",user);                //把用户信息存放到session
				RequestDispatcher dispatcher= request.getRequestDispatcher("/adminChangeUser.jsp");  //跳转到管理员修改用户信息页面
				dispatcher.forward(request, response); 	
			}catch(Exception e){
				
			}
			
		}
		
		if(type.equals("selectOrder")){                         //管理员想要修改某订单信息
			try{
				HttpSession session = request.getSession();
				int  id=Integer.valueOf(request.getParameter("id"));  //获取选中的订单编号
				List<Orders> orders=null;
				orders=adm.changeOrder(id);                            //根据订单编号查询订单
				Orders order=new Orders();
				order=orders.get(0);
				session.setAttribute("Username", order.getOrderName());  //把配送姓名存放到session
				session.setAttribute("changeOrder",order);				//把订单信息存放到session
				//跳转到管理员修改订单信息页面
				RequestDispatcher dispatcher= request.getRequestDispatcher("/adminChangeOrder.jsp");  
				dispatcher.forward(request, response); 	
			}catch(Exception e){
				
			}
			
		}
		
		
	}
	
	
	

}
