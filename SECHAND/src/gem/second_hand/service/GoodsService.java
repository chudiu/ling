package gem.second_hand.service;

import gem.second_hand.dao.GoodsDao;
import gem.second_hand.entity.Goods;

public class GoodsService {

	private GoodsDao dao=new GoodsDao();
	
	public void saveGoods(Goods goods) {
		dao.saveGoods(goods);
	}
	
	public Goods getGoodsById(int id) {
		return dao.getGoodsById(id);
	}
	
	public int getGoodsCounts() {
		return dao.getGoodsCounts();
	}
	
	public void updateGoods(Goods g) {
		dao.updateGoods(g);
	}
	
	public void deleteGoods(String[] ids) {
		dao.deleteGoods(ids);
		
	}
	
}
