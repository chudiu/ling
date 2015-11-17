package gem.second_hand.dao;

import gem.second_hand.entity.School;
import gem.second_hand.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolDao {
	//添加学校信息
	public void saveSchool(School school) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			// 2.SQL
			String sql = "insert into school(loca,name) values(?,?)";
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
	//获取学校信息
	public School getSchoolById(int id) {
		// try-catch-finally
		Connection conn = null;
		PreparedStatement prep = null;
		School s = null ;
		ResultSet rs = null;
		try {
			// 1
			conn = DBConnection.getDBConnection();
			// 2.
			String sql = "select *from school where id=?";
			// 3
			prep = conn.prepareStatement(sql);
			// 4
			prep.setInt(1, id);
			// 5.
			rs = prep.executeQuery();
			// 6.
			if (rs.next()) {
				s = new School();
				s.setId(rs.getInt("id"));
				s.setLoca(rs.getString("loca"));
				s.setName(rs.getString("name"));

			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (prep != null)
					prep.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return s;
	}

}
