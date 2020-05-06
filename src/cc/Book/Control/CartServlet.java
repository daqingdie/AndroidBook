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

import cc.Book.JavaBean.Cart;
import cc.Book.service.CartService;
import cc.Book.serviceImpl.CartServiceImpl;


@WebServlet("/Cart.do")
public class CartServlet extends HttpServlet {
/**
 * 用户对购物车的增删查看操作的信息获取、封装和跳转
 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String type=request.getParameter("action");   //获取页面传递的操作类型
		CartService cas=new CartServiceImpl();        //创建购物车服务类的对象
		
		if(type.equals("add")){      //用户添加图书到购物车
			HttpSession session=request.getSession();
			if(session.getAttribute("UserName")!=null){   //验证用户是否登录 
				try{
			
					int id=Integer.valueOf(request.getParameter("id"));  //获取选择的图书编号
					
						String name=String.valueOf(session.getAttribute("UserName")); //获取当前的用户名
						if(cas.isExist(id, name)){   //检验购物车是否存在该图书
							//已存在弹窗报错
							response.setContentType("text/html;charset=utf-8");
							PrintWriter out=response.getWriter();
							out.print("<script language='javascript'>alert('购物车已存在该图书，请勿重复添加');window.location.href='index.jsp';</script>");
						}else{
							//图书未存在，新增购物车信息
							cas.addCart(id, name);
							//弹窗提示成功
							response.setContentType("text/html;charset=utf-8");
							PrintWriter out=response.getWriter();
							out.print("<script language='javascript'>alert('添加成功');window.location.href='index.jsp';</script>");
						}
		
				}catch(Exception e){
					
				}
			}else{
				//弹窗提示登录并跳转到登录页面
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('您还未登录，请先登录');window.location.href='login.jsp';</script>");
			}
			
		}
		
		if(type.equals("see")){        //用户查看购物车
			HttpSession session=request.getSession();
			if(session.getAttribute("UserName")!=null){   //检验用户是否登录
				try{
					String name=String.valueOf(session.getAttribute("UserName")); //获取当前用户名
					List<Cart> see=null;
					see=cas.seeCart(name);              //查询该用户的购物车信息
					session.setAttribute("seeCart",see);  //把结果存放到session
					//跳转到购物车显示页面
					RequestDispatcher dispatcher= request.getRequestDispatcher("/showCart.jsp");  
					dispatcher.forward(request, response); 					
				}catch(Exception e){
					
				}
			}else{
				//弹窗报错并跳转回登录页面
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('您还未登录，请先登录');window.location.href='login.jsp';</script>");
			}
			
		}
		
		if(type.equals("del")){             //用户删除购物车
			try{
				int id=Integer.valueOf(request.getParameter("id"));  //获取用户选择的购物车编号
				cas.delCart(id);            //删除该购物车
				/*RequestDispatcher dispatcher= request.getRequestDispatcher("/delCartShow.jsp");  
				dispatcher.forward(request, response); 	*/
				//弹窗提示成功并跳转回购物车显示页面
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('删除成功，点击确定返回购物车');window.location.href='Cart.do?action=see';</script>");
			}catch(Exception e){
				
			}
			
		}
		
		if(type.equals("change")){           //用户想要修改购物车里图书数量
			try{
				int id=Integer.valueOf(request.getParameter("id"));  //获取用户选择的购物车编号
				List<Cart> ch=null;
				//查询购物车信息并封装
				ch=cas.queryCart(id);                               
				Cart changeCart=new Cart();
				changeCart=ch.get(0); 
				HttpSession session=request.getSession();
				session.setAttribute("changeCart", changeCart);  //把结果存放到session
				//跳转到修改购物车信息页面
				RequestDispatcher dispatcher= request.getRequestDispatcher("/changeCart.jsp");  
				dispatcher.forward(request, response); 	
				
			}catch(Exception e ){
				
			}
		}
		
		if(type.equals("update")){            //用户修改购物车里图书的数量
			int id=Integer.valueOf(request.getParameter("id"));     //获取用户选择的购物车编号
			//检验用户修改的数量数据是否合法
			if(request.getParameter("num").matches("[0-9]{1,}")&&Integer.valueOf(request.getParameter("num"))>0){
				try{
					
					int num=Integer.valueOf(request.getParameter("num")); //获取用户输入的数量
					if(cas.changeCart(id, num)){  						//尝试修改数量
						//弹窗提示成功并跳转回购物车页面
						response.setContentType("text/html;charset=utf-8");
						PrintWriter out=response.getWriter();
						out.print("<script language='javascript'>alert('修改成功，点击确定返回购物车');window.location.href='Cart.do?action=see';</script>");
					}
					//弹窗报错并跳转回修改购物车页面
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.print("<script language='javascript'>alert('该库存不足，请重新输入');window.location.href='Cart.do?action=change&id="+id+"';</script>");
				}catch(Exception e){
					
				}
			}else{
				//弹窗报错并跳转回修改购物车页面
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('库存只能为正整数，请重新输入');window.location.href='Cart.do?action=change&id="+id+"';</script>");
			}
			
		}

	}
	
		
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doPost(request,response);
		}

}
