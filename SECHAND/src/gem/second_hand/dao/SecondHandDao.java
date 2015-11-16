package gem.second_hand.dao;

import gem.second_hand.entity.Demands;
import gem.second_hand.entity.Favourite;
import gem.second_hand.entity.Goods;
import gem.second_hand.entity.GoodsType;
import gem.second_hand.entity.School;
import gem.second_hand.entity.User;

public class SecondHandDao {
private UserDao udao = new UserDao(); 
private GoodsDao gdao = new GoodsDao();
private DemandsDao ddao = new DemandsDao();
private FavouriteDao fdao = new FavouriteDao();
private GoodsTypeDao gtdao = new GoodsTypeDao();
private SchoolDao sdao = new SchoolDao();

	public SecondHandDao() {}
	//用户
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
	
	//商品
	public Goods getGoodsById(int id) {
		return gdao.getGoodsById(id);				
	}
	public void saveGoods(Goods goods) {
		gdao.saveGoods(goods);
	}
	public void update(Goods g) {
		gdao.updateGoods(g);
	}
	public int getGoodsCounts() {
		return gdao.getGoodsCounts();
	}
	public void deleteGoods(String[] ids) {
		gdao.deleteGoods(ids);
	}
	
	//需求
	public void saveDemands(Demands d) {
		ddao.saveDemands(d);
	}	
	public Demands getDemandsById(int id) {
		return ddao.getDemandsById(id);
	}
	public int getDemandsCounts() {
		return ddao.getDemandsCounts();
	}
	public void updateDemds(Demands d) {
		ddao.updateDemands(d);
	}
	public void deleteDemands(String[] ids){
		ddao.deleteDemands(ids);
	}
	
	//收藏
	public void deleteFavourite(String[] ids) {
		fdao.deleteFavourite(ids);
	}
	public Favourite getFavouriteById(int id) {
		return fdao.getFavouriteById(id);
	}
	public void saveFavourite(Favourite f) {
		fdao.saveFavourite(f);
	}
	
	
	//商品类型
	public GoodsType getGoodsTyoeById(int id) {
		return gtdao.getGoodsTyoeById(id);
	}
	public void saveGoodsType(GoodsType gtype) {
		gtdao.saveGoodsType(gtype);
	}
	
	//学校
	public void saveSchool(School school) {
		sdao.saveSchool(school);
	}
	public School getSchoolById(int id) {
		return sdao.getSchoolById(id);
	}
	
	//
}

