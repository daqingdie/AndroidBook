package cc.Book.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cc.Book.Dao.UserDao;
import cc.Book.JavaBean.Orders;
import cc.Book.JavaBean.User;
import cc.Book.utils.DBCPUtils;

public class UserDaoImpl implements UserDao{
	

	@Override
	public List<User> queryUserOfName(String name) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<User> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM user WHERE userName=?");
			stmt.setString(1, name);
			result = stmt.executeQuery();
			messages=new ArrayList<User>();
			while (result.next()) {
				User user=new User();
				user.setUserId(result.getInt(1));
				user.setUserPassword(result.getString(2));
				user.setUserName(result.getString(3));
				user.setUserAddress(result.getString(4));
				user.setUserSex(result.getString(5));
				user.setUserPhone(result.getString(6));
				//System.out.println(user.getUserAddress());
				messages.add(user);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
		
		
	}

	@Override
	public void insertUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="INSERT INTO user(userName,userPassword,userSex,userAddress,userPhone) VALUES(?,?,?,?,?)";
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,user.getUserName());
            stmt.setString(2,user.getUserPassword());
            stmt.setString(3,user.getUserSex());
            stmt.setString(4,user.getUserAddress());
            stmt.setString(5,user.getUserPhone());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
        }
	
		
	}
	
	@Override
	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="UPDATE user SET userPassword=?,userSex=?,userPhone=?,userAddress=? WHERE userName=?";
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,user.getUserPassword());
            stmt.setString(2,user.getUserSex());
            stmt.setString(3,user.getUserPhone());
            stmt.setString(4,user.getUserAddress());
            stmt.setString(5,user.getUserName());            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
        }
		
	}

	@Override
	public List<User> queryUser() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<User> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM user ");
			result = stmt.executeQuery();
			messages=new ArrayList<User>();
			while (result.next()) {
				User user=new User();
				user.setUserId(result.getInt(1));
				user.setUserPassword(result.getString(2));
				user.setUserName(result.getString(3));
				user.setUserAddress(result.getString(4));
				user.setUserSex(result.getString(5));
				user.setUserPhone(result.getString(6));
				//System.out.println(user.getUserAddress());
				messages.add(user);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
		
	}

	@Override
	public List<User> queryUserOfId(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<User> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM user WHERE userId=?");
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			messages=new ArrayList<User>();
			while (result.next()) {
				User user=new User();
				user.setUserId(result.getInt(1));
				user.setUserPassword(result.getString(2));
				user.setUserName(result.getString(3));
				user.setUserAddress(result.getString(4));
				user.setUserSex(result.getString(5));
				user.setUserPhone(result.getString(6));
				//System.out.println(user.getUserAddress());
				messages.add(user);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
	
		
	}

	@Override
	public void updateUserOfId(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="UPDATE user SET userPassword=?,userSex=?,userPhone=?,userAddress=?,userName=? WHERE userId=?";
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,user.getUserPassword());
            stmt.setString(2,user.getUserSex());
            stmt.setString(3,user.getUserPhone());
            stmt.setString(4,user.getUserAddress());
            stmt.setString(5,user.getUserName());      
            stmt.setLong(6,user.getUserId());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
        }
		
	}

	@Override
	public void deleteUser(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="DELETE FROM user WHERE userId=?";
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);  
            stmt.setLong(1,id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
        }
	
	}
}
