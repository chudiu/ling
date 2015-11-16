package gem.second_hand.dao;

import gem.second_hand.entity.Favourite;
import gem.second_hand.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FavouriteDao {
	
	//删除收藏
	public void deleteFavourite(String[] ids) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "delete  from favourite where id=?";
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
	//获得收藏数据
	public Favourite getFavouriteById(int id) {
		// try-catch-finally
		Connection conn = null;
		PreparedStatement prep = null;
		Favourite f = null;
		ResultSet rs = null;
		try {
			// 1
			conn = DBConnection.getDBConnection();
			// 2.
			String sql = "select *from favourite where id=?";
			// 3
			prep = conn.prepareStatement(sql);
			// 4
			prep.setInt(1, id);
			// 5.
			rs = prep.executeQuery();
			// 6.
			if (rs.next()) {
				f = new Favourite();
				f.setId(rs.getInt("id"));
				f.setGoods_id(rs.getInt("goods_id"));
				f.setUser_id(rs.getInt("user_id"));

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

		return f;
	}
	//添加收藏数据
	public void saveFavourite(Favourite f) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			// 2.SQL
			String sql = "insert into favourite(goods_id,user_id) "
					+ "values(?,?)";
			// 3.PreparedStatement
			prep = conn.prepareStatement(sql);
			prep.setInt(1, f.getGoods_id());
			prep.setInt(2, f.getUser_id());
			
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

}
