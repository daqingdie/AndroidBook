package cc.Book.Dao;


import java.sql.SQLException;
import java.util.List;

import cc.Book.JavaBean.Book;


public interface BookDao {
	public void insertBook(Book book)throws SQLException;  //新增图书		
	public List<Book> queryBookOfId(int id)throws SQLException;		//根据id查询图书		
	public List<Book> queryBookOfName(String name)throws SQLException;	//根据书名查询图书	
	public List<Book> queryBook()throws SQLException;				//查询所有图书
	public void updateBook(Book book)throws SQLException;	//更新图书信息	
	public void deleteBook(int id)throws SQLException;//删除图书
	public void updateBookNum(long id,int number);//更新图书库存
}
