package gem.second_hand.dao;

import gem.second_hand.entity.Goods;
import gem.second_hand.entity.School;
import gem.second_hand.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SchoolDao {
	public void saveSchool(School school) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			// 2.SQL
			String sql = "insert into school(loca,name) values(?,?,?,?,?,?,?,?,?,?)";
			// 3.PreparedStatement
			prep = conn.prepareStatement(sql);
			prep.setString(1, school.getLoca());
			prep.setString(2, school.getName());
			
			prep.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (prep != null)
					prep.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
