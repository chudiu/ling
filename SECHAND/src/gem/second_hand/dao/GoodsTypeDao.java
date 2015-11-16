package gem.second_hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gem.second_hand.entity.GoodsType;
import gem.second_hand.util.DBConnection;

public class GoodsTypeDao {
	//获取商品类型数据
	public GoodsType getGoodsTyoeById(int id) {
		// try-catch-finally
		Connection conn = null;
		PreparedStatement prep = null;
		GoodsType gtype = null;
		ResultSet rs = null;
		try {
			// 1
			conn = DBConnection.getDBConnection();
			// 2.
			String sql = "select *from goodsType where id=?";
			// 3
			prep = conn.prepareStatement(sql);
			// 4
			prep.setInt(1, id);
			// 5.
			rs = prep.executeQuery();
			// 6.
			if (rs.next()) {
				gtype = new GoodsType();
				gtype.setId(rs.getInt("id"));
				gtype.setName(rs.getString("name"));
				gtype.setTorder(rs.getString("torder"));

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

		return gtype;
	}
	//添加商品类型数据
	public void saveGoodsType(GoodsType gtype) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			// 2.SQL
			String sql = "insert into goods_type(name,torder) "
					+ "values(?,?)";
			// 3.PreparedStatement
			prep = conn.prepareStatement(sql);
			prep.setString(1, gtype.getName());
			prep.setString(2, gtype.getTorder());
			
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
