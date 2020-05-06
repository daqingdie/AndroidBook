package cc.Book.Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.Book.JavaBean.Orders;
import cc.Book.service.OrdersService;
import cc.Book.serviceImpl.OrdersServiceImpl;
@WebServlet("/Order.do")
public class OrdersServlet extends HttpServlet {

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
	 * 用户对订单的新增，查看操作的信息获取，封装和跳转
	 * 管理员对订单的修改删除的信息获取，封装和跳转
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String type=request.getParameter("action");   //获取页面传递的操作类型	
		OrdersService ord=new OrdersServiceImpl();    //创建订单服务类的对象
		
		
		if(type.equals("select")){                    //用户选中一个购物车结算
			try{
				HttpSession session=request.getSession();
				String name=String.valueOf(session.getAttribute("UserName"));  //获取当前用户名
				int id=Integer.valueOf(request.getParameter("cartId"));       //获取用户选中的购物车编号
				Orders order=new Orders();
				order=ord.select(id, name);                                  //查询选中的购物车信息
				session.setAttribute("addOrder",order);                     //把结果存放到session
				//跳转到结算界面
				RequestDispatcher dispatcher= request.getRequestDispatcher("/addOrder.jsp?id="+id);  
				dispatcher.forward(request, response); 	
				
				
				
			}catch(Exception e){
				
			}
		}
		
		if(type.equals("add")){                     //用户新增订单
			try{
				HttpSession session=request.getSession();
				String name=String.valueOf(session.getAttribute("UserName"));  //获取当前的用户名
				int id=Integer.valueOf(request.getParameter("id"));           //获取选中的购物车信息
				Orders order=new Orders();
				order=ord.select(id, name);                                   //查询的购物车信息
				
				String memo=request.getParameter("Memo");                     //获取用户填写的备注
				//获取当前时间
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
				String time=df.format(new Date());
				//封装数据
				order.setOrderMemo(memo);
				order.setOrderTime(time);
				ord.addOrder(order,id);                                     //新增订单信息
				/*RequestDispatcher dispatcher= request.getRequestDispatcher("/addOrderShow.jsp");  
				dispatcher.forward(request, response); */
				//弹窗提示成功并跳转到订单显示页面
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('添加订单成功,点击确定返回查看');window.location.href='Order.do?action=see';</script>");
			}catch(Exception e){
				
			}
			
		}

	
	
	if(type.equals("see")){                                   //用户查看订单信息
		try{
			HttpSession session=request.getSession();
			String name=String.valueOf(session.getAttribute("UserName"));  //获取当前用户名
			List<Orders> orders=null;
			orders=ord.seeOrder(name);                                     //根据用户名查询订单信息
			session.setAttribute("seeOrder", orders);                      //把结果封装到session
			//跳转到订单显示页面
			RequestDispatcher dispatcher= request.getRequestDispatcher("/showOrder.jsp");  
			dispatcher.forward(request, response); 				
			
		}catch(Exception e){
			
		}

	}
	
	if(type.equals("del")){                                   //管理员删除订单信息
		try{
			int id=Integer.valueOf(request.getParameter("id"));       //获取选中的订单编号
			ord.delOrder(id);                                   		//删除订单信息
			//弹窗提示成功并跳转到订单管理页面
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('删除成功');window.location.href='Admin.do?action=seeOrder';</script>");
			
		}catch(Exception e){
			
		}
	}
	
	if(type.equals("updateOrder")){                          //管理员修改订单信息
		int id=Integer.valueOf(request.getParameter("id"));		//获取选中的订单编号
		//检验管理员输入的订单购买数量数据是否合法
		if(request.getParameter("ordernumber").matches("[0-9]{1,}")&&Integer.valueOf(request.getParameter("ordernumber"))>0){
			try{
				//获取数据和封装信息
				HttpSession session=request.getSession();
				String bookName=request.getParameter("bookname");
				int number=Integer.valueOf(request.getParameter("ordernumber"));
				String name=String.valueOf(session.getAttribute("Username"));
				String address=request.getParameter("orderaddress");
				String phone=request.getParameter("orderphone");
				String memo=request.getParameter("ordermemo");
				Orders order=new Orders();
				order.setOrderId(id);
				order.setBookName(bookName);
				order.setOrderAddress(address);
				order.setOrderMemo(memo);
				order.setOrderName(name);
				order.setOrderNumber(number);
				order.setOrderPhone(phone);
				if(ord.idRight(order).equals("正确")){  			//检验数据是否合法
					ord.changeOrder(order);						//更新订单信息
					//弹窗提示成功并跳转回订单管理页面
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.print("<script language='javascript'>alert('修改成功');window.location.href='Admin.do?action=seeOrder';</script>");
				}else{
					//弹窗报错并跳转回订单修改页面
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.print("<script language='javascript'>alert('"+ord.idRight(order)+"');window.location.href='adminChangeOrder.jsp';</script>");
				}
				
				
				
			}catch(Exception e){
				
			}
		}else{
			//弹窗报错并跳转回订单修改页面
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('购买数量只能为正整数');window.location.href='adminChangeOrder.jsp';</script>");
		}
		
		}
}
		
	
}
