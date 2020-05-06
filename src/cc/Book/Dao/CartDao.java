package cc.Book.Dao;

import java.sql.SQLException;
import java.util.List;

import cc.Book.JavaBean.Cart;


public interface CartDao {
	public void insertCart(Cart cart)throws SQLException;   				//新增购物车信息	
	public List<Cart> queryCartOfUserName(String name)throws SQLException;	//根据用户名查询购物车信息
	public List<Cart> queryCartOfId(int id)throws SQLException;				//根据id查询购物车信息
	public List<Cart> queryCartOfBookName(String name)throws SQLException;	//根据书名查询购物车信息	
	public void deleteCart(int id)throws SQLException;						//删除购物车信息
	public void updateCartNum(int id,int number)throws SQLException;		//更新购物车信息
	public void updateBookName(String oldName,String newName,double price)throws SQLException;//更新购物车内图书信息


}
