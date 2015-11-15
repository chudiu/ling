package gem.second_hand.dao;

import gem.second_hand.entity.Goods;
import gem.second_hand.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsDao {
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

	// 获得商品的数量
	public int getCounts() {
		// 1.
		Connection conn = null;
		PreparedStatement prep = null;
		// Student s = null;
		ResultSet rs = null;
		int counts = 0;
		try {
			conn = DBConnection.getDBConnection();
			// 2.鍒嗛〉鏌ヨ鐨凷QL璇彞
			String sql = "select count(*) c from goods ";
			// 3.
			prep = conn.prepareStatement(sql);

			// 5.
			rs = prep.executeQuery();
			// 6.澶勭悊鏌ヨ缁撴灉锛�**锛�
			while (rs.next()) {
				counts = rs.getInt("c");
			}
		} /*
		 * catch ( ) { // 澶勭悊寮傚父锛氳浆鎹负浣犵殑搴旂敤绋嬪簭鐨勫紓甯革紝鍐嶆姏鍑�
		 * //缂栬瘧鏈熷紓甯革紝杩愯寮傚父==銆�銆乼hrow new RuntimeException(e);
		 * //2銆佸紓甯镐俊鎭啓鍒版棩蹇楁枃浠�涓� e.printStackTrace(); }
		 */catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				// 7.鍙兘鏈夌┖鎸囬拡寮傚父
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

	// 更新商品数据
	public void update(Goods g) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getDBConnection();
			// 2. 商品对象==》记录
			String sql = "update goods set title=?,price=?,photo=?,type_id=?,voice=?,"
					+ "descr=?,user_id=?,viewcount=?,loca=?,school_id=? where id=? ";
			// 3.
			prep = conn.prepareStatement(sql);
			// 4.设置值
			prep.setString(1, g.getTitle());
			prep.setFloat(2, g.getPrice());
			prep.setString(3, g.getPhoto());
			prep.setInt(4, g.getType_id());// 商品类型需要修改吗
			prep.setString(5, g.getVoice());
			prep.setString(6, g.getDescr());
			prep.setInt(7, g.getUser_id());// 好像也不需要改
			prep.setInt(8, g.getViewCount());
			prep.setString(9, g.getLoca());
			prep.setInt(10, g.getSchool_id());// 发布的学校不会变吧

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
}
