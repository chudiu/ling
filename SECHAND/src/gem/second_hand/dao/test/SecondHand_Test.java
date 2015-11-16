package gem.second_hand.dao.test;

import org.junit.Test;

import gem.second_hand.dao.DemandsDao;
import gem.second_hand.dao.FavouriteDao;
import gem.second_hand.dao.GoodsDao;
import gem.second_hand.dao.GoodsTypeDao;
import gem.second_hand.dao.ReleDemandsDao;
import gem.second_hand.dao.ReleGoodsDao;
import gem.second_hand.dao.SchoolDao;
import gem.second_hand.dao.SecondHandDao;
import gem.second_hand.dao.UserDao;
import gem.second_hand.entity.Goods;
import gem.second_hand.entity.GoodsType;
import gem.second_hand.entity.School;
import gem.second_hand.entity.User;

public class SecondHand_Test {

	private SecondHandDao dao = new SecondHandDao();

	public static void main(String[] args) {

	}

	// 用户
	@Test
	public void deleteUser() {
		String[] ids = { "2" };
		dao.deleteUser(ids);
	}

	@Test
	public void saveUser() {
		User user = new User();
		user.setName("li4");
		user.setNickname("jj");
		user.setPassword("345");
		user.setPhone("13838445438");
		user.setSchool_id(1);
		user.setSex(1);
		dao.saveUser(user);
	}

	@Test
	public void getUserById() {
		int id = 1;
		User u = dao.getUserById(id);
		System.out.println(u);
	}

	@Test
	public void updateUaser() {
		User user = new User();
		user.setName("wang5");
		user.setNickname("zz");
		user.setPassword("123");
		user.setPhone("13838388888");
		user.setSchool_id(1);
		user.setSex(0);
		user.setId(2);
		dao.updateUaser(user);
	}

	// 商品
	@Test
	public void saveGoods() {
		Goods goods = new Goods();
		goods.setTitle("我要卖奥迪");
		goods.setPrice(10034);
		goods.setPhoto("E:\\MyFiles\\Myclass\\java-workspace\\"
				+ "web_server_workspace\\second_hand\\"
				+ "WebContent\\images.b.jpg");
		goods.setUser_id(1);
		goods.setType_id(2);
		goods.setSchool_id(2);
		dao.saveGoods(goods);
	}

	@Test
	public void getGoodsById() {
		int id = 4;
		Goods g = dao.getGoodsById(id);
		System.out.println(g);
	}

	@Test
	public void update() {
		Goods goods = new Goods();
		goods.setTitle("我要卖美女");
		goods.setPrice(99999);
		goods.setPhoto("E:\\MyFiles\\Myclass\\java-workspace\\"
				+ "web_server_workspace\\second_hand\\"
				+ "WebContent\\images.c.jpg");
		goods.setUser_id(1);
		goods.setType_id(2);
		goods.setSchool_id(1);
		goods.setId(3);
		dao.updateGoods(goods);
	}

	@Test
	public void getGoodsCounts() {

		System.out.println(dao.getGoodsCounts());
	}

	@Test
	public void deleteGoods() {
		String[] ids = { "4" };
		dao.deleteGoods(ids);
	}

	// 商品类型
	@Test
	public void getGoodsTyoeById() {
		int id = 2;
		GoodsType gt = dao.getGoodsTyoeById(id);
		System.out.println(gt);
	}

	@Test
	public void saveGoodsType() {
		GoodsType gtype = new GoodsType();
		gtype.setName("单车");
		gtype.setTorder("发布时间");
		dao.saveGoodsType(gtype);
	}

	// 学校
	@Test
	public void saveSchool() {
		School school = new School();
		school.setLoca("广西南宁西乡塘");
		school.setName("广西民大相思湖学院");
		dao.saveSchool(school);
	}

	@Test
	public void getSchoolById() {
		int id = 2;
		School s = dao.getSchoolById(id);
		System.out.println(s);
	}
}
