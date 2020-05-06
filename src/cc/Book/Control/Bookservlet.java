package cc.Book.Control;


import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cc.Book.JavaBean.Book;
import cc.Book.service.BookService;
import cc.Book.serviceImpl.BookServiceImpl;


/**
 * 测试基类反射机制跳转
 * 测试未通过，未使用
 * @author 大清爹
 *
 */
public class Bookservlet extends BaseCartServlet {
	private BookService boo=new BookServiceImpl();
	
	
	public String addd(HttpServletRequest request, HttpServletResponse response){
		try{
			Book book=new Book();
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
			boo.addBook(book);
			return "index.jsp";
			
		}catch(Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
		return null;
		
	}
	
	

}
