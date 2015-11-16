package gem.second_hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gem.second_hand.entity.ReleDemands;
import gem.second_hand.util.DBConnection;

public class ReleDemandsDao {
private ReleDemands rd = new ReleDemands();


	public void saveReleDemands(ReleDemands reled) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "insert into rele_demands(user_id,demands_id)"
					+ "values(?,?)";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, reled.getUser_id());
			prep.setInt(2, reled.getDemands_id());
			
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
}
