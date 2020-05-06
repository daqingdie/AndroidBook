package cc.Book.DaoImpl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cc.Book.Dao.BookDao;
import cc.Book.JavaBean.Book;
import cc.Book.utils.DBCPUtils;

public class BookDaoImpl implements BookDao{
	
	public void insertBook(Book book)
	{
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="INSERT INTO book(bookName,bookConcern,bookNumber,bookPrice,bookAuthor,bookSummary) VALUES(?,?,?,?,?,?)";
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getBookName());
            stmt.setString(2, book.getBookConcern());
            stmt.setInt(3, book.getBookNum());
            stmt.setDouble(4, book.getBookPrice());
            stmt.setString(5, book.getBookAuthor());
            stmt.setString(6, book.getBookSummary());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
            
        }
		
	}

	@Override
	public List<Book> queryBookOfId(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Book> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM book WHERE bookId=?");
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			messages=new ArrayList<Book>();
			while (result.next()) {
				Book book=new Book();
				book.setBookId(result.getInt(1));
				book.setBookName(result.getString(2));
				book.setBookConcern(result.getString(3));
				book.setBookNum(result.getInt(4));
				book.setBookPrice(result.getDouble(5));
				book.setBookAuthor(result.getString(6));
				book.setBookSummary(result.getString(7));
				messages.add(book);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
	
	}

	@Override
	public List<Book> queryBookOfName(String name) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Book> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM book WHERE bookName=?");
			stmt.setString(1, name);
			result = stmt.executeQuery();
			messages=new ArrayList<Book>();
			while (result.next()) {
				Book book=new Book();
				book.setBookId(result.getInt(1));
				book.setBookName(result.getString(2));
				book.setBookConcern(result.getString(3));
				book.setBookNum(result.getInt(4));
				book.setBookPrice(result.getDouble(5));
				book.setBookAuthor(result.getString(6));
				book.setBookSummary(result.getString(7));
				messages.add(book);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
		
	}

	@Override
	public List<Book> queryBook() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Book> messages=null;
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM book");
			result = stmt.executeQuery();
			messages=new ArrayList<Book>();
			while (result.next()) {
				Book book=new Book();
				book.setBookId(result.getInt(1));
				book.setBookName(result.getString(2));
				book.setBookConcern(result.getString(3));
				book.setBookNum(result.getInt(4));
				book.setBookPrice(result.getDouble(5));
				book.setBookAuthor(result.getString(6));
				book.setBookSummary(result.getString(7));
				messages.add(book);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, result);
		}
		return messages;
		
	}

	@Override
	public void updateBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="UPDATE book SET bookName=?,bookConcern=?,bookNumber=?,bookPrice=?,bookAuthor=?,bookSummary=? WHERE bookId=?";
         // getConn()方法是静态的，直接用类调用建立连接。
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getBookName());
            stmt.setString(2, book.getBookConcern());
            stmt.setInt(3, book.getBookNum());
            stmt.setDouble(4, book.getBookPrice());
            stmt.setString(5, book.getBookAuthor());
            stmt.setString(6, book.getBookSummary());
            stmt.setLong(7, book.getBookId());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
             //关闭连接，由于插入操作不涉及ResultSet类，故其对象rs无需关闭，用null代替。
        }
		
	}

	@Override
	public void deleteBook(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="DELETE FROM book WHERE bookId=?";

        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 

        }
	
	}

	@Override
	public void updateBookNum(long id, int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        String sql="UPDATE book SET bookNumber=? WHERE bookId=?";

        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,number);
            stmt.setLong(2,id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
            
        }
	}
	
	
}
