package cc.Book.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cc.Book.Dao.AdminDao;
import cc.Book.JavaBean.Admin;
import cc.Book.utils.DBCPUtils;

public class AdminDaoImpl implements AdminDao{

	@Override
/**
 *  根据id查询管理员信息
 */
	public List<Admin> queryAdminOfId(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Admin> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM admin WHERE adminId=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			messages=new ArrayList<Admin>();
			while (rs.next()) {
				Admin admin=new Admin();
				admin.setAdminId(rs.getInt(1));
				admin.setAdminPassword(rs.getString(2));
				messages.add(admin);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, rs);
		}
		return messages;
	}

}
