package gem.second_hand.dao;

import gem.second_hand.entity.User;
import gem.second_hand.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	//添加用户信息
	public void saveUser(User user) {
		// try-catch-finally
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "insert into user(name,password,nickname,school_id,sex,phone,email)"
					+ "values(?,?,?,?,?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setString(1, user.getName());
			prep.setString(2, user.getPassword());
			prep.setString(3, user.getNickname());
			prep.setInt(4, user.getSchool_id());
			prep.setInt(5, user.getSex());
			prep.setString(6, user.getPhone());
			prep.setString(7, user.getEmail());
			prep.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (prep != null)
					prep.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	//删除用户信息
	public void deleteUser(String[] ids) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "delete  from user where id=?";
			prep = conn.prepareStatement(sql);

			for (String id : ids) {
				prep.setInt(1, Integer.parseInt(id));
				prep.executeUpdate();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				prep.close();
				conn.close();
			} catch (Exception e2) {
				throw new RuntimeException(e2);
			}
		}
	}
	//更新用户信息
	public void updateUaser(User user) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "update user set name=?,password=?,nickname=?,school_id=?,sex=?,phone=?,email=? "
					+ " where id=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, user.getName());
			prep.setString(2, user.getPassword());
			prep.setString(3, user.getNickname());
			prep.setInt(4, user.getSchool_id());
			prep.setInt(5, user.getSex());
			prep.setString(6, user.getPhone());
			prep.setString(7, user.getEmail());
			prep.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (prep != null)
					prep.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	//获取用户信息
	public User getUserById(int id) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		User s = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "select * from user where id=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, id);
			rs = prep.executeQuery();
			
			if (rs.next()) {
				s = new User();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPassword(rs.getString("password"));
				s.setNickname(rs.getString("nickname"));
				s.setSchool_id(rs.getInt("school_id"));
				s.setSex(rs.getInt("sex"));
				s.setPhone(rs.getString("phone"));
				s.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				rs.close();
				prep.close();
				conn.close();
			} catch (Exception e2) {
				throw new RuntimeException(e2);
			}
		}
		return s;
	}

}
