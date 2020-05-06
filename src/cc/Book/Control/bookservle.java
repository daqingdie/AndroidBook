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

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import cc.Book.JavaBean.Book;
import cc.Book.service.BookService;
import cc.Book.serviceImpl.BookServiceImpl;

@WebServlet("/Book.do")
public class bookservle extends HttpServlet {
	/**
	 * 对图书的增删查改等操作进行信息的封装和跳转
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService sa=new BookServiceImpl();   //创建图书服务类对象
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String type=request.getParameter("action"); //获取页面传递的操作类型
		
		if(type.equals("add")){          //管理员新增图书
			//检验管理员输入的图书库存和图书单价数据是否合法（不合法会导入下面获取失败）
			if(request.getParameter("bookNumber").matches("[0-9]{1,}")&&request.getParameter("bookPrice").matches("^[-\\+]?[.\\d]*$")){
				try{
					Book book=new Book();
					//获取图书数据并封装
				    String name=request.getParameter("bookName");
				    String concern=request.getParameter("bookConcern");
				    int Number=Integer.valueOf(request.getParameter("bookNumber"));
				    float price=Float.valueOf(request.getParameter("bookPrice"));
				    String Author=request.getParameter("bookAuthor");
				    String msg=request.getParameter("bookSummary");
				    book.setBookName(name);
				    book.setBookConcern(concern);
				    book.setBookNum(Number);
				    book.setBookPrice(price);
				    book.setBookAuthor(Author);
				    book.setBookSummary(msg);
				    if(sa.isRight(book).equals("正确")){     //检验数据是否合法
				    	if(!sa.isExist(name)){
				    		sa.addBook(book);  //新增图书信息
							response.setContentType("text/html;charset=utf-8");
							PrintWriter out=response.getWriter();
							//跳转到图书管理页面
							out.print("<script language='javascript'>alert('添加成功');window.location.href='Admin.do?action=seeBook';</script>");
				    	}else{
				    		//弹窗报错且跳转回添加图书页面
				    		response.setContentType("text/html;charset=utf-8");
							PrintWriter out=response.getWriter();
							out.print("<script language='javascript'>alert('该图书名已存在，请重新修改');window.location.href='addBook.jsp';</script>");
				    	}
				    	
				    }else{
				    	//弹窗报错且跳转回添加图书页面
				    	response.setContentType("text/html;charset=utf-8");
						PrintWriter out=response.getWriter();
						out.print("<script language='javascript'>alert('"+sa.isRight(book)+"');window.location.href='addBook.jsp';</script>");
				    }
					
					}catch(Exception e)                          
					{
					}
			}else{
				//弹窗报错且跳转回添加图书页面
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('库存只能为整数且单价只能为数字');window.location.href='addBook.jsp';</script>");
			}
			


			
		}
		
		if(type.equals("search")){     //用户查询图书
			try{
				String name=request.getParameter("bookname");  //获取用户输入的图书书名
				List<Book> books=null;
				books=sa.searchOfName(name);              //根据书名查询图书
				HttpSession session=request.getSession();
				session.setAttribute("books",books);     //把结果存放到session
				//跳转到显示页面
				RequestDispatcher dispatcher= request.getRequestDispatcher("/searchBookShow.jsp");  
				dispatcher.forward(request, response); 		
				
			}catch(Exception e){
				
			}
		}
		
		if(type.equals("updateBook")){       //管理员修改图书信息
			//检验修改后的图书库存和单价是否合法
			if(request.getParameter("booknumber").matches("[0-9]{1,}")&&request.getParameter("bookprice").matches("^[-\\+]?[.\\d]*$")){
				try{
					//获取数据和封装
					HttpSession session=request.getSession();
					String oldname=String.valueOf(session.getAttribute("oldname")); //从session获取旧书名来对比
					int id=Integer.valueOf(request.getParameter("id"));
					String name=request.getParameter("bookname");
					String author=request.getParameter("bookauthor");
					String concern=request.getParameter("bookconcern");
					int number=Integer.valueOf(request.getParameter("booknumber"));
					double price=Double.valueOf(request.getParameter("bookprice"));	
					String summary=request.getParameter("booksummary");
					Book book=new Book();
					book.setBookId(id);
					book.setBookName(name);
					book.setBookAuthor(author);
					book.setBookConcern(concern);
					book.setBookNum(number);
					book.setBookPrice(price);
					book.setBookSummary(summary);
					if(sa.isRight(book).equals("正确")){      //检验数据是否合法
						if(name.equals(oldname)){   //检查用户是否修改了书名
							sa.changeBook(book,oldname);      //用户未修改书名直接更新图书信息
							//弹窗并跳转到图书管理页面
							response.setContentType("text/html;charset=utf-8");
							PrintWriter out=response.getWriter();
							out.print("<script language='javascript'>alert('修改成功');window.location.href='Admin.do?action=seeBook';</script>");
						}else{  //用户修改了书名，
							if(!sa.isExist(name)){   //查询修改后的书名是否存在
								sa.changeBook(book,oldname);  //不存在新书名，更新图书信息
								//弹窗并跳转到图书管理页面
								response.setContentType("text/html;charset=utf-8");
								PrintWriter out=response.getWriter();
								out.print("<script language='javascript'>alert('修改成功');window.location.href='Admin.do?action=seeBook';</script>");
							}else{
								//弹窗报错并跳转回图书修改页面
								response.setContentType("text/html;charset=utf-8");
								PrintWriter out=response.getWriter();
								out.print("<script language='javascript'>alert('该图书名已存在，请重新修改');window.location.href='adminChangeBook.jsp';</script>");
							}
						}
						
						
					}else {
						//弹窗报错并跳转回图书修改页面
						response.setContentType("text/html;charset=utf-8");
						PrintWriter out=response.getWriter();
						out.print("<script language='javascript'>alert('"+sa.isRight(book)+"');window.location.href='adminChangeBook.jsp';</script>");
					}
					
					
				}catch(Exception e){
					
				}
			}else{
				//弹窗报错并跳转回图书修改页面
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('库存只能为整数且单价只能为数字');window.location.href='adminChangeBook.jsp';</script>");
			}
			
			
		}
		
		if(type.equals("del")){   //管理员删除图书
			try{
				int id=Integer.valueOf(request.getParameter("id"));  //获取选择的图书编号
				sa.delBook(id);                                      //删除该图书
				//弹窗并跳转回图书管理页面
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('删除成功');window.location.href='Admin.do?action=seeBook';</script>");
			}catch(Exception e){
				
			}
		}
	}
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doPost(request,response);
		}

}
