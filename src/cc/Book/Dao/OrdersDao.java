package cc.Book.Dao;

import java.sql.SQLException;
import java.util.List;

import cc.Book.JavaBean.Orders;

public interface OrdersDao {
	public void insertOrder(Orders order)throws SQLException;   			//新增订单	
	public List<Orders> queryOrder()throws SQLException;					//查看所有订单信息	
	public List<Orders> queryOrderOfName(String name)throws SQLException;	//根据配送姓名查询订单信息	
	public List<Orders> queryOrderOfId(int id)throws SQLException;			//根据id查询订单信息	
	public void deleteOrder(int id)throws SQLException;						//删除订单信息
	public void updateOrder(Orders order)throws SQLException;				//更新订单信息
}
