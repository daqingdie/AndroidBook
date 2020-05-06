package cc.Book.serviceImpl;


import java.util.List;



import cc.Book.Dao.*;
import cc.Book.DaoImpl.*;
import cc.Book.JavaBean.*;
import cc.Book.service.BookService;

public class BookServiceImpl implements BookService {
	//创建DaoImpl对象
	BookDao bo=new BookDaoImpl();
	CartDao ca=new CartDaoImpl();
	
	public void addBook (Book book)throws Exception{   //新增图书
		try{
			//新增图书
			bo.insertBook(book);
			
		}catch(Exception e){
			
		}
				
	}
	
	@Override
	public List<Book> searchOfId(int id) throws Exception {  //根据编号查询图书（未用到）
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Book> searchOfName(String name) throws Exception {  //根据书名查询图书
		// TODO Auto-generated method stub
		try{
			//查询，封装，返回;
			List<Book> books=null;
			books=bo.queryBookOfName(name);
			return books;
			
		}catch(Exception e){
			return null;
		}
		
	}

	@Override
	public void changeBook(Book book,String oldname) throws Exception {     //管理员修改图书
		// TODO Auto-generated method stub
		try{
			ca.updateBookName(oldname,book.getBookName(),book.getBookPrice());  //更新含有此书的购物车的书名和价格
			bo.updateBook(book);//更新图书信息
		}catch(Exception e){
			
		}
	}

	@Override
	public void delBook(int id) throws Exception {    //删除图书
		// TODO Auto-generated method stub
		try{
			//删除图书
			bo.deleteBook(id);
			
		}catch(Exception e){
			
		}
	}

	@Override
	public String isRight(Book book) {  //检验数据是否合法
		// TODO Auto-generated method stub
		String mess="正确";
		if(book.getBookName().equals(""))
			mess="图书书名不能为空";
		else if(book.getBookName().length()>20)
			mess="图书书名过长";
		else if(book.getBookAuthor().equals(""))
			mess="图书作者不能为空";
		else if(book.getBookAuthor().length()>20)
			mess="图书作者过长";
		else if(book.getBookConcern().equals(""))
			mess="图书出版社不能为空";
		else if(book.getBookConcern().length()>20)
			mess="图书出版社过长";
		else if(book.getBookNum()<=0)
			mess="图书库存不能少于0";
		else if(book.getBookNum()>1000)
			mess="图书库存不能大于1000";
		else if(book.getBookPrice()<=0)
			mess="图书单价不能小于0";
		return mess;
	}

	@Override
	public boolean isExist(String name) throws Exception {  //检验图书名是否存在
		// TODO Auto-generated method stub
		try{
			List<Book> books=bo.queryBookOfName(name);
			if(!books.get(0).getBookName().equals("")){
				return true;
			}else return false;
		}catch(Exception e){
			return false;
		}
	}

}
