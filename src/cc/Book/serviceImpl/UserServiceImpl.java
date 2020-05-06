package cc.Book.serviceImpl;

import java.util.List;

import cc.Book.Dao.UserDao;
import cc.Book.DaoImpl.UserDaoImpl;
import cc.Book.JavaBean.User;
import cc.Book.service.UserService;

public class UserServiceImpl implements UserService {
	//创建DaoImpl对象
	UserDao u=new UserDaoImpl();


	@Override
	public void addUser(User user) throws Exception {    //注册用户
		// TODO Auto-generated method stub
		try{
			//新增
			u.insertUser(user);
			
			
		}catch(Exception e){
			
		}
		
	}

	@Override
	public boolean login(String name, String password) throws Exception {  //用户登录系统
		// TODO Auto-generated method stub
		try{
			
			List<User> all=null;
			all=u.queryUserOfName(name);   //查询用户信息
			User a= all.get(0);
			if(password.equals(a.getUserPassword()))  //密码是否匹配
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
			
		}
	}

	@Override
	public List<User> see(String name) throws Exception {       //用户查看个人信息
		try{
			//查询，封装，返回
			List<User> all=null;
			all=u.queryUserOfName(name);
			return all;
			
		}catch(Exception e){
			return null;
			
		}
		// TODO Auto-generated method stub
	}

	@Override
	public void changeUser(User user) throws Exception {      //用户更新个人信息
		// TODO Auto-generated method stub
		try{
			//更新
			u.updateUser(user);
			
		}catch(Exception e){
			
		}
		
	}

	@Override
	public void changeUserOfId(User user) throws Exception {    //管理员更新用户信息
		// TODO Auto-generated method stub
		try{
			//更新
			u.updateUserOfId(user);
			
		}catch(Exception e){
			
		}
	}

	@Override
	public void delUser(int id) throws Exception {                //删除用户
		// TODO Auto-generated method stub
		try{
			//删除
			u.deleteUser(id);
		}catch(Exception e){
			
		}
	}

	@Override
	public String isRight(User user) {              //检验数据合法性
		// TODO Auto-generated method stub
		String mess= "正确"; 
		 if(user.getUserPhone().equals(""))
			mess="手机号码不能为空";
		else if((user.getUserPhone().length())!=11)
			mess="手机号码只能为11位，请重新输入！";
		else if(user.getUserName().equals(""))
			mess="用户名不能为空";
		else if(user.getUserName().length()>10)
			mess="用户名过长，请重新输入";
		else if(user.getUserAddress().equals(""))
			mess="地址不能为空";
		else if(user.getUserAddress().length()>38)
			mess="地址过长，请重新输入";
		else if(!user.getUserPhone().matches("[0-9]{1,}"))
			mess="手机号码必须为数字，请重新输入";
		else if(user.getUserPassword().equals(""))
			mess="密码不能为空";
		else if(user.getUserPassword().length()>8)
			mess="密码不能大于8位";
		else if(user.getUserPassword().length()<3)
			mess="密码不能小于3位";
		else if(user.getUserPassword().matches(".*[^a-zA-Z0-9]+.*"))
			mess="密码不能带有特殊符号（如空格）";
		
		return mess;
	}

	@Override
	public boolean isExist(String name) {      //检验是否存在该用户
		// TODO Auto-generated method stub
		try{
			List<User> users=u.queryUserOfName(name);
			//System.out.println("shishi");
			//System.out.print(users.get(0).getUserName());
			if(!users.get(0).getUserName().equals("")){
				return true;
			}else return false;
		}catch(Exception e){
			return false;
		}
		
	}
	

}
