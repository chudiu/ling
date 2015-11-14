package gem.second_hand.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0 {

	
	public static Connection getConnection(){
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {//设置基本参数
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost/student_db");
			ds.setUser("root");
			ds.setPassword("SQL3026285");
			//设置连接池参数
			ds.setMaxPoolSize(50);//设置连接池最大数量 50
			ds.setMinPoolSize(5);//最小数量 5
			ds.setInitialPoolSize(10);//初始数量 10
			ds.setAcquireIncrement(5);//如果连接池已经用完了，每次增加多少个连接池
			ds.setMaxStatements(180);//连接池缓存最大语句数量
			ds.setMaxIdleTime(60);//如果连接池多久没有活动，自动关闭这个 连接池，时间单位为秒
			
			return ds.getConnection();
		}catch (PropertyVetoException | SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[] args) {
		Connection c1 = getConnection();
		//Connection c2 = getConnection();
		//Connection c3 = getConnection();
		//Connection c4 = getConnection();
		System.out.println(c1);
		//System.out.println(c2);
		//System.out.println(c3);
		//System.out.println(c4);

	}

}
