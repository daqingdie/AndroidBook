package cc.Book.service;

import java.util.List;

import cc.Book.JavaBean.Orders;

public interface OrdersService {
	public void addOrder(Orders order,int cartId)throws Exception;
	public Orders select(int id,String name)throws Exception;
	public List<Orders> seeOrder(String name)throws Exception;
	public void delOrder(int id)throws Exception;
	public void changeOrder(Orders order)throws Exception;
	public String idRight(Orders order)throws Exception;

}
