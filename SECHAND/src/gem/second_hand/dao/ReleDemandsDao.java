package gem.second_hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gem.second_hand.entity.ReleDemands;
import gem.second_hand.util.DBConnection;

public class ReleDemandsDao {

	public void saveReleDemands(ReleDemands reled) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "insert into rele_demands(user_id,demands_id,reletime)"
					+ "values(?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, reled.getUser_id());
			prep.setInt(2, reled.getDemands_id());
			prep.setDate(3, reled.getReletime());
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
	public void deleteReleDemands(String[] ids) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "delete  from rele_demands where id=?";
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
	public ReleDemands getReleDemandsById(int id) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		ReleDemands reled = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "select * from rele_demands where id=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, id);
			rs = prep.executeQuery();
			
			if (rs.next()) {
				reled  = new ReleDemands();
				reled.setId(rs.getInt("id"));
				reled.setDemands_id(rs.getInt("demands_id"));
				reled.setUser_id(rs.getInt("user_id"));
				reled.setReletime(rs.getDate("reletime"));
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
		return reled;
	}
}
