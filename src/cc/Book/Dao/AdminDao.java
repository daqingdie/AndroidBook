package cc.Book.Dao;

import java.sql.SQLException;
import java.util.List;

import cc.Book.JavaBean.Admin;

public interface AdminDao {
	public List<Admin> queryAdminOfId(int id)throws SQLException;  //根据id查询管理员信息

}
