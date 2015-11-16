package gem.second_hand.dao;

import gem.second_hand.entity.Demands;
import gem.second_hand.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemandsDao {
	// 添加需求数据
	public void saveDemands(Demands d) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			// 2.SQL
			String sql = "insert into demands(title,price,type_id,descr,user_id,loca"
					+ ",school_id) values(?,?,?,?,?,?,?)";
			// 3.PreparedStatement
			prep = conn.prepareStatement(sql);
			// 4.setXxx(1,
			prep.setString(1, d.getTitle());
			prep.setFloat(2, d.getPrice());
			prep.setInt(3, d.getType_id());
			prep.setString(4, d.getDescr());
			prep.setInt(5, d.getUser_id());
			prep.setString(6, d.getLoca());
			prep.setInt(7, d.getSchool_id());

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

	// 获得需求
	public Demands getDemandsById(int id) {
		// try-catch-finally
		Connection conn = null;
		PreparedStatement prep = null;
		Demands d = null;
		ResultSet rs = null;
		try {
			// 1
			conn = DBConnection.getDBConnection();
			// 2.
			String sql = "select *from demands where id=?";
			// 3
			prep = conn.prepareStatement(sql);
			// 4
			prep.setInt(1, id);
			// 5.
			rs = prep.executeQuery();
			// 6.
			if (rs.next()) {
				d = new Demands();
				d.setId(rs.getInt("id"));
				d.setTitle(rs.getString("title"));
				d.setPrice(rs.getFloat("price"));
				d.setType_id(rs.getInt("type_id"));
				d.setDescr(rs.getString("descr"));
				d.setUser_id(rs.getInt("user_id"));
				d.setLoca(rs.getString("loca"));
				d.setSchool_id(rs.getInt("school_id"));

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

		return d;
	}

	// 获得需求的数量
	public int getDemandsCounts() {
		// 1.
		Connection conn = null;
		PreparedStatement prep = null;
		// Student s = null;
		ResultSet rs = null;
		int counts = 0;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "select count(*) c from demands ";
			// 3.
			prep = conn.prepareStatement(sql);
			// 5.
			rs = prep.executeQuery();
			while (rs.next()) {
				counts = rs.getInt("c");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return counts;
	}

	// 更新需求数据
	public void updateDemands(Demands d) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			// 2. 需求对象==》记录
			String sql = "update demands set title=?,price=?,type_id=?,"
					+ "descr=?,user_id=?,loca=?,school_id=? where id=? ";
			// 3.
			prep = conn.prepareStatement(sql);
			// 4.设置值
			prep.setString(1, d.getTitle());
			prep.setFloat(2, d.getPrice());
			prep.setInt(3, d.getType_id());// 商品类型需要修改吗
			prep.setString(4, d.getDescr());
			prep.setInt(5, d.getUser_id());// 好像也不需要改
			prep.setString(6, d.getLoca());
			prep.setInt(7, d.getSchool_id());// 发布的学校不会变吧

			prep.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				// 7.关闭资源
				if (prep != null)
					prep.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	// 删除需求数据
	public void deleteDemands(String[] ids) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "delete  from demands where id=?";
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

}
