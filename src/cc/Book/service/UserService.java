package cc.Book.service;

import java.util.List;

import cc.Book.JavaBean.User;


public  interface UserService {
	public boolean login(String name,String password)throws Exception;
	public void addUser(User user)throws Exception;
	public List<User> see(String name)throws Exception;
	public void changeUser(User user)throws Exception;
	public void changeUserOfId(User user)throws Exception;
	public void delUser(int id)throws Exception;
	public String isRight(User user);
	public boolean isExist(String name);

}