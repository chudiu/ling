package gem.second_hand.dao;

import gem.second_hand.entity.ReleGoods;
import gem.second_hand.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReleGoodsDao {
	
	public void saveReleGoods(ReleGoods releg) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "insert into rele_goods(user_id,goods_id,reletime)"
					+ "values(?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, releg.getUser_id());
			prep.setInt(2, releg.getGoods_id());
			prep.setTimestamp(3, releg.getReletime());
			
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
	public void deleteReleGoods(String[] ids) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "delete  from rele_goods where id=?";
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
	public ReleGoods getReleGoodsById(int id) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		ReleGoods releg = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "select * from rele_goods where id=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, id);
			rs = prep.executeQuery();
			
			if (rs.next()) {
				releg  = new ReleGoods();
				releg.setId(rs.getInt("id"));
				releg.setGoods_id(rs.getInt("goods_id"));
				releg.setUser_id(rs.getInt("user_id"));
				releg.setReletime(rs.getTimestamp("reletime"));
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
		return releg;
	}
}
