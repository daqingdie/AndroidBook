package cc.Book.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cc.Book.Dao.OrdersDao;
import cc.Book.JavaBean.Orders;
import cc.Book.utils.DBCPUtils;

public class OrdersDaoImpl implements OrdersDao{


	@Override
	public void insertOrder(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="INSERT INTO orders(orderName,orderAddress,orderPhone,orderNumber,orderTime,bookName,orderMemo) VALUES(?,?,?,?,?,?,?)";
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,order.getOrderName());
            stmt.setString(2,order.getOrderAddress());
            stmt.setString(3,order.getOrderPhone());
            stmt.setInt(4,order.getOrderNumber());
            stmt.setString(5,order.getOrderTime());
            stmt.setString(6,order.getBookName());
            stmt.setString(7,order.getOrderMemo());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
        }
		
		
	}

	@Override
	public List<Orders> queryOrder() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Orders> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM orders");
			result = stmt.executeQuery();
			messages=new ArrayList<Orders>();
			while (result.next()) {
				Orders order=new Orders();
				order.setOrderId(result.getInt(1));
				order.setOrderName(result.getString(2));
				order.setOrderAddress(result.getString(3));
				order.setOrderPhone(result.getString(4));
				order.setOrderNumber(result.getInt(5));
				order.setOrderTime(result.getString(6));
				order.setBookName(result.getString(7));
				order.setOrderMemo(result.getString(8));
				messages.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
		
		
	}

	@Override
	public List<Orders> queryOrderOfName(String name) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Orders> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM orders WHERE orderName=?");
			stmt.setString(1, name);
			result = stmt.executeQuery();
			messages=new ArrayList<Orders>();
			while (result.next()) {
				Orders order=new Orders();
				order.setOrderId(result.getInt(1));
				order.setOrderName(result.getString(2));
				order.setOrderAddress(result.getString(3));
				order.setOrderPhone(result.getString(4));
				order.setOrderNumber(result.getInt(5));
				order.setOrderTime(result.getString(6));
				order.setBookName(result.getString(7));
				order.setOrderMemo(result.getString(8));
				messages.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
		
		
	}

	@Override
	public void deleteOrder(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="DELETE FROM orders WHERE orderId=?";
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
	public List<Orders> queryOrderOfId(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Orders> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM orders WHERE orderId=?");
			stmt.setInt(1,id);
			result = stmt.executeQuery();
			messages=new ArrayList<Orders>();
			while (result.next()) {
				Orders order=new Orders();
				order.setOrderId(result.getInt(1));
				order.setOrderName(result.getString(2));
				order.setOrderAddress(result.getString(3));
				order.setOrderPhone(result.getString(4));
				order.setOrderNumber(result.getInt(5));
				order.setOrderTime(result.getString(6));
				order.setBookName(result.getString(7));
				order.setOrderMemo(result.getString(8));
				messages.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
		
		
	}

	@Override
	public void updateOrder(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="UPDATE orders SET orderName=?,orderAddress=?,orderPhone=?,orderNumber=?,bookName=?,orderMemo=? WHERE orderId=?";
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,order.getOrderName());
            stmt.setString(2,order.getOrderAddress());
            stmt.setString(3,order.getOrderPhone());
            stmt.setInt(4,order.getOrderNumber());
            stmt.setString(5,order.getBookName());
            stmt.setString(6,order.getOrderMemo());
            stmt.setInt(7,order.getOrderId());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
        }
		
	}

}
