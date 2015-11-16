package gem.second_hand.service;

import gem.second_hand.dao.GoodsTypeDao;
import gem.second_hand.entity.GoodsType;

public class GoodsTypeService {

	private GoodsTypeDao dao=new GoodsTypeDao();
	
	public GoodsType getGoodsTyoeById(int id) {
		return dao.getGoodsTyoeById(id);
	}
	
	public void saveGoodsType(GoodsType gtype) {
		dao.saveGoodsType(gtype);
	}
	
	
	
}
