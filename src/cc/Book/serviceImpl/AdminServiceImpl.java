package cc.Book.serviceImpl;

import java.util.List;

import cc.Book.Dao.*;
import cc.Book.DaoImpl.*;
import cc.Book.JavaBean.*;
import cc.Book.service.AdminService;

public class AdminServiceImpl implements AdminService{
	//创建DaoImpl对象
	AdminDao ad=new AdminDaoImpl();
	BookDao bo=new BookDaoImpl();
	UserDao us=new UserDaoImpl();
	OrdersDao or=new OrdersDaoImpl();

	@Override
	public boolean longin(int id, String password) throws Exception { //管理员登录
		// TODO Auto-generated method stub
		try{
			List<Admin> admins=null;
			admins=ad.queryAdminOfId(id);   //根据id查询到密码
			Admin admin=new Admin();
			admin=admins.get(0);
			if(password.equals(admin.getAdminPassword())){  //检验用户输入的密码和数据库的密码是否一致
				return true;   //返回正确
			}else{ 
				return false;  //返回错误
			}
			
			
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public List<User> seeUser() throws Exception {  //查看所有用户信息
		// TODO Auto-generated method stub
		try{
			//查询，封装，返回;
			List<User> users=null;
			users=us.queryUser();
			return users;
		}catch(Exception e){
			return null;
		}
		
	}

	@Override
	public List<Book> seeBook() throws Exception {  //查看所有图书信息
		// TODO Auto-generated method stub
		try{
			//查询，封装，返回;
			List<Book> books=null;
			books=bo.queryBook();
			return books;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Orders> seeOrder() throws Exception {  //查看所有订单信息
		// TODO Auto-generated method stub
		try{
			//返回
			return or.queryOrder();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<User> searchUser(String name) throws Exception {  //查询用户信息
		// TODO Auto-generated method stub
		try{
			//查询，封装，返回;
			List<User> users=null;
			users=us.queryUserOfName(name);
			return users;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Book> searchBook(String name) throws Exception {  //查询图书信息
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
	public List<Orders> searchOrders(String name) throws Exception {  //查询订单信息
		// TODO Auto-generated method stub
		try{
			//返回
			return or.queryOrderOfName(name);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<User> changeUser(int id) throws Exception {     //选择一个用户更改信息
		// TODO Auto-generated method stub
		try{
			//返回
			return us.queryUserOfId(id);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Book> changeBook(int id) throws Exception {     //选择一本书更改信息
		// TODO Auto-generated method stub
		try{
			//返回
			return bo.queryBookOfId(id);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Orders> changeOrder(int id) throws Exception {  //选择一个订单修改
		// TODO Auto-generated method stub
		try{
			//返回
			return or.queryOrderOfId(id);
		}catch(Exception e){
			return null;
		}
	}

}
