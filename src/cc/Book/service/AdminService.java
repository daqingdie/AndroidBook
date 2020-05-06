package cc.Book.service;

import java.util.List;

import cc.Book.JavaBean.*;

public interface AdminService {
	public boolean longin(int id,String password)throws Exception;    
	public List<User> seeUser()throws Exception;	
	public List<Book> seeBook()throws Exception;		
	public List<Orders> seeOrder()throws Exception;					
	public List<User> searchUser(String name)throws Exception;		
	public List<Book> searchBook(String name)throws Exception;			
	public List<Orders> searchOrders(String name)throws Exception;		
	public List<User> changeUser(int id)throws Exception;				
	public List<Book> changeBook(int id)throws Exception;				
	public List<Orders> changeOrder(int id)throws Exception;			
}
