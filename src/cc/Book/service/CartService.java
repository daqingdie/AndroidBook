package cc.Book.service;

import java.util.List;

import cc.Book.JavaBean.Cart;



public interface CartService {
	public void addCart(int id,String name)throws Exception;
	public List<Cart> seeCart(String name)throws Exception;
	public void delCart(int id)throws Exception;
	public List<Cart> queryCart(int id)throws Exception;
	public boolean changeCart(int id,int num);
	public boolean isExist(int id,String name);


}
