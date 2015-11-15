package gem.second_hand.dao;

import gem.second_hand.entity.Goods;
import gem.second_hand.entity.User;

public class SecondHandDao {
private UserDao udao = new UserDao(); 
private GoodsDao gdao = new GoodsDao();

	public SecondHandDao() {}
	public void deleteUser(String[] ids) {
		udao.deleteUser(ids);
	}
	public void saveUser(User user) {
		udao.saveUser(user);
	}
	public User getUserById(int id) {
		return udao.getUserById(id);
	}
	public void updateUaser(User user) {
		udao.updateUaser(user);
	}
	
	
	public Goods getGoodsById(int id) {
		return gdao.getGoodsById(id);				
	}
	public void saveGoods(Goods goods) {
		gdao.saveGoods(goods);
	}
	public void update(Goods g) {
		gdao.update(g);
	}
	
	
}

