package cc.Book.serviceImpl;

import java.util.List;

import cc.Book.Dao.CartDao;
import cc.Book.Dao.OrdersDao;
import cc.Book.Dao.UserDao;
import cc.Book.DaoImpl.CartDaoImpl;
import cc.Book.DaoImpl.OrdersDaoImpl;
import cc.Book.DaoImpl.UserDaoImpl;
import cc.Book.JavaBean.Cart;
import cc.Book.JavaBean.Orders;
import cc.Book.JavaBean.User;
import cc.Book.service.OrdersService;

public class OrdersServiceImpl implements OrdersService{
	//创建DaoImpl对象
	UserDao use=new UserDaoImpl();
	CartDao car=new CartDaoImpl();
	OrdersDao or=new OrdersDaoImpl();

	@Override
	public void addOrder(Orders order,int cartId) throws Exception {  //新增订单
		// TODO Auto-generated method stub
		try{
			car.deleteCart(cartId);   //删除对应的购物车
			or.insertOrder(order);		//新增订单信息
			
		}catch(Exception e){
			
		}
		
	}

	@Override
	public Orders select(int id, String name) throws Exception {   //用户选择某购物车结算
		// TODO Auto-generated method stub
		try{
			List<User> users=null;
			List<Cart> carts=null; 
			users=use.queryUserOfName(name);				//查询当前用户信息
			carts=car.queryCartOfId(id);					//查询选中的购物车细信息
			User user=new User();
			Cart cart=new Cart();
			user=users.get(0);
			cart=carts.get(0);
			//封装未完成的订单信息
			Orders order=new Orders();
			order.setOrderName(user.getUserName());
			order.setOrderAddress(user.getUserAddress());
			order.setOrderPhone(user.getUserPhone());
			order.setOrderNumber(cart.getNumber());
			order.setBookName(cart.getBookName());
			order.setOrderMemo("");
			return order;		//返回
			
		}catch(Exception e){
			return null;
		}
		
	}

	@Override
	public List<Orders> seeOrder(String name) throws Exception {    //用户查看订单
		// TODO Auto-generated method stub
		try{
			//查询，封装，返回
			List<Orders> orders=null;
			orders=or.queryOrderOfName(name);
			return orders;
			
			
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public void delOrder(int id) throws Exception {           //删除订单
		// TODO Auto-generated method stub
		try{
			//删除
			or.deleteOrder(id);
			
		}catch(Exception e){
			
		}
	}

	@Override
	public void changeOrder(Orders order) throws Exception {       //管理员更新订单信息
		// TODO Auto-generated method stub
		try{
			//更新
			or.updateOrder(order);
			
		}catch(Exception e){
			
		}
	}

	@Override
	public String idRight(Orders order) throws Exception {    //检验数据是否合法
		// TODO Auto-generated method stub
		//System.out.println(order.getOrderPhone());
		String mess="正确";
		if(order.getBookName().equals(""))
			mess="图书名不能为空";
		else if(order.getBookName().length()>20)
			mess="图书名过长";
		else if(order.getOrderNumber()>1000)
			mess="数量不得大于1000";
		else if(order.getOrderNumber()<=0)
			mess="数量不得小于1";
		else if(order.getOrderName().equals(""))
			mess="配送姓名不能为空";
		else if(order.getOrderName().length()>20)
			mess="配送姓名过长";
		else if(order.getOrderAddress().equals(""))
			mess="配送地址不能为空";
		else if(order.getOrderAddress().length()>40)
			mess="配送地址过长";
		else if(order.getOrderPhone().equals(""))
			mess="配送电话不能为空";
		else if(!order.getOrderPhone().matches("[0-9]{1,}"))
			mess="配送电话只能为数字";
		else if(order.getOrderPhone().length()!=11)
			mess="配送电话只能为11位手机号码";
			
		return mess;
	}

}
