package gem.second_hand.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
	

public class DBConnection {
	//获得数据库联接对象
	public static  Connection getDBConnection() throws ClassNotFoundException, SQLException {
		//注册
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3307/second_hand";
		String user="root";
		String password="SQL3026285";
		
		return DriverManager.getConnection(url, user, password);
		
		
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		Connection conn =  getDBConnection();
		System.out.println(conn);
		//Connection c1 = C3p0.getConnection();
		//System.out.println(c1);
	}
	
}
