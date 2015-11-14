package gem.second_hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gem.second_hand.entity.Goods;
import gem.second_hand.entity.User;
import gem.second_hand.util.DBConnection;

public class SecondHandDao {

	public SecondHandDao() {

	}

	// 保存商品
	public void saveGoods(Goods goods) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			// 2.SQL
			String sql = "insert into goods(title,price,photo,voice,type_id,descr,user_id,viewcount"
					+ ",loca,school_id) values(?,?,?,?,?,?,?,?,?,?)";
			// 3.PreparedStatement
			prep = conn.prepareStatement(sql);
			// 4.setXxx(1,鍊�
			prep.setString(1, goods.getTitle());
			prep.setFloat(2, goods.getPrice());
			prep.setString(3, goods.getPhoto());
			prep.setString(4, goods.getVoice());
			prep.setInt(5, goods.getType_id());
			prep.setString(6, goods.getDescr());
			prep.setInt(7, goods.getUser_id());
			prep.setInt(8, goods.getViewCount());
			prep.setString(9, goods.getLoca());
			prep.setInt(10, goods.getSchool_id());
			// 5.鎵ц
			prep.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6.鍏抽棴,finally
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

	// 获得商品
	public Goods getGoodsById(int id) {
		// try-catch-finally
		Connection conn = null;
		PreparedStatement prep = null;
		Goods g = null;
		ResultSet rs = null;
		try {
			// 1
			conn = DBConnection.getDBConnection();
			// 2.
			String sql = "select *from goods where id=?";
			// 3
			prep = conn.prepareStatement(sql);
			// 4
			prep.setInt(1, id);
			// 5.
			rs = prep.executeQuery();
			// 6.
			if (rs.next()) {
				g = new Goods();
				g.setId(rs.getInt("id"));
				g.setTitle(rs.getString("title"));
				g.setPrice(rs.getFloat("price"));
				g.setPhoto(rs.getString("photo"));
				g.setVoice(rs.getString("voice"));
				g.setType_id(rs.getInt("type_id"));
				g.setDescr(rs.getString("descr"));
				g.setUser_id(rs.getInt("user_id"));
				g.setViewCount(rs.getInt("viewcount"));
				g.setLoca(rs.getString("loca"));
				g.setSchool_id(rs.getInt("school_id"));

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

		return g;
	}

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
			s = new User();
			if (rs.next()) {
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

