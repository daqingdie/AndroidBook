package cc.Book.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import cc.Book.JavaBean.*;

public class DBCPUtils {
	
	private static DataSource dataSource;

	//加载配置文件，创建数据库连接池
	static {
		try {
			InputStream is = DBCPUtils.class.getResourceAsStream("/dbcp.properties");
			Properties p = new Properties();
			p.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//返回连接对象
	public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("数据连接获取失败！");
        }
    }
	
	//返回连接池对象
	public static DataSource getDataSource() {
        return dataSource;
    }
	
	//释放连接，被连接池收回
	public static void releaseConnection(Connection connection, PreparedStatement pstmt, ResultSet rs){
        try {
            if(rs != null ) {
                rs.close();
            }
            if(pstmt != null ) {
                pstmt.close();
            }
            if(connection != null ) {
                connection.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	/*public static void main(String[] args) {
		Connection conn = null;
        PreparedStatement stmt = null;
        String insertSql="insert into user (userName,userPassword,userAddress,userPhone,userSex) values(?,?,?,?,?)";
        String deleteSql ="delete from user where name=?";
        String updateSql = "";
         // getConn()方法是静态的，直接用类调用建立连接。
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(insertSql);
            stmt.setString(1, "你好");
            stmt.setString(2, "你好");
            stmt.setString(3, "你好");
            stmt.setString(4, "你好");
            stmt.setString(5, "你好");
            stmt.executeUpdate();
            System.out.println("ok");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
             //关闭连接，由于插入操作不涉及ResultSet类，故其对象rs无需关闭，用null代替。
        }
	}
	
	public void see()throws SQLException{
		Connection conn = null;
        PreparedStatement stmt = null;
        String insertSql="insert into user (userName,userPassword,userAddress,userPhone,userSex) values(?,?,?,?,?)";
        String deleteSql ="delete from user where name=?";
        String updateSql = "";
         // getConn()方法是静态的，直接用类调用建立连接。
        try {
            conn = DBCPUtils.getConnection();
            stmt = conn.prepareStatement(insertSql);
            stmt.setString(1, "你好");
            stmt.setString(2, "你好");
            stmt.setString(3, "你好");
            stmt.setString(4, "你好");
            stmt.setString(5, "你好");
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.releaseConnection(conn, stmt, null); 
             //关闭连接，由于插入操作不涉及ResultSet类，故其对象rs无需关闭，用null代替。
        }
        
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<User> users=null;
		try{
		conn = DBCPUtils.getConnection();
			stmt = conn.prepareStatement("select * from User");
			rs = stmt.executeQuery();
			users=new ArrayList<User>();
			while (rs.next()) {
				User user=new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserName(rs.getString(3));
				user.setUserAddress(rs.getString(4));
				user.setUserSex(rs.getString(5));
				user.setUserPhone(rs.getString(6));
				System.out.println(user.getUserId()+user.getUserName()+
				user.getUserName()+
				user.getUserAddress()+
				user.getUserSex()+
				user.getUserPhone());
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(conn, stmt, rs);
		}
		return 
	}*/

}
