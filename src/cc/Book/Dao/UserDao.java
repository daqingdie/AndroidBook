package cc.Book.Dao;

import java.sql.SQLException;
import java.util.List;

import cc.Book.JavaBean.User;


public interface UserDao {
	public List<User> queryUserOfName(String name)throws SQLException;			//根据用户名查询用户信息	
	public void insertUser(User user)throws SQLException;						//新增用户信息
	public void updateUser(User user)throws SQLException;						//更新用户信息	
	public void updateUserOfId(User user)throws SQLException;                   //管理员更新用户信息
	public List<User> queryUser()throws SQLException;							//查看所有用户信息
	public List<User> queryUserOfId(int id)throws SQLException;					//根据id查询用户信息	
	public void deleteUser(int id)throws SQLException;							//删除用户信息

}
