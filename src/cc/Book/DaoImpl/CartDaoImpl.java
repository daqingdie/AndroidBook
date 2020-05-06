package cc.Book.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cc.Book.Dao.CartDao;
import cc.Book.JavaBean.Cart;
import cc.Book.utils.DBCPUtils;

public class CartDaoImpl implements CartDao{


	@Override
	public void insertCart(Cart cart) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="INSERT INTO cart(bookName,number,bookPrice,sum,userName) VALUES(?,?,?,?,?)";
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,cart.getBookName());
            stmt.setInt(2, cart.getNumber());
            stmt.setDouble(3, cart.getBookPrice());
            stmt.setDouble(4,cart.getSum());
            stmt.setString(5,cart.getUserName());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
        }
		
	}

	@Override
	public List<Cart> queryCartOfUserName(String name) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Cart> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM cart WHERE userName=?");
			stmt.setString(1,name);
			result = stmt.executeQuery();
			messages=new ArrayList<Cart>();
			while (result.next()) {
				Cart cart=new Cart();
				cart.setCartId(result.getInt(1));
				cart.setBookName(result.getString(2));
				cart.setNumber(result.getInt(3));
				cart.setBookPrice(result.getDouble(4));
				cart.setSum(result.getDouble(5));
				cart.setUserName(result.getString(6));
				messages.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
		
	}

	@Override
	public void deleteCart(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="DELETE FROM cart WHERE cartId=?";
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
        }
		
		
	}

	@Override
	public List<Cart> queryCartOfId(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Cart> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM cart WHERE cartId=?");
			stmt.setInt(1,id);
			result = stmt.executeQuery();
			messages=new ArrayList<Cart>();
			while (result.next()) {
				Cart cart=new Cart();
				cart.setCartId(result.getInt(1));
				cart.setBookName(result.getString(2));
				cart.setNumber(result.getInt(3));
				cart.setBookPrice(result.getDouble(4));
				cart.setSum(result.getDouble(5));
				cart.setUserName(result.getString(6));
				messages.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
	
	}

	@Override
	public void updateCartNum(int id, int number) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="UPDATE cart SET number=? WHERE cartId=?";
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, number);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
        }
		
	}

	@Override
	public List<Cart> queryCartOfBookName(String name) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Cart> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM cart WHERE bookName=?");
			stmt.setString(1,name);
			result = stmt.executeQuery();
			messages=new ArrayList<Cart>();
			while (result.next()) {
				Cart cart=new Cart();
				cart.setCartId(result.getInt(1));
				cart.setBookName(result.getString(2));
				cart.setNumber(result.getInt(3));
				cart.setBookPrice(result.getDouble(4));
				cart.setSum(result.getDouble(5));
				cart.setUserName(result.getString(6));
				messages.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
		
	}

	@Override
	public void updateBookName(String oldName, String newName, double price)
			throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="UPDATE cart SET bookName=?,bookPrice=? WHERE bookName=?";
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newName);
            stmt.setDouble(2, price);
            stmt.setString(3, oldName);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
        }
		
	}

}
