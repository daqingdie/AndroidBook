package cc.Book.service;

import java.util.List;

import cc.Book.JavaBean.Book;

public  interface BookService {
	public void addBook(Book book)throws Exception;                   
	public List<Book> searchOfId(int id)throws Exception;
	public List<Book> searchOfName(String name)throws Exception;
	public void changeBook(Book book,String oldname)throws Exception;
	public void delBook(int id)throws Exception;
	public String isRight(Book book);
	public boolean isExist(String name)throws Exception;
	
}
