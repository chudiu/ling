package gem.second_hand.dao.test;

import org.junit.Test;

import gem.second_hand.dao.SecondHandDao;
import gem.second_hand.entity.Goods;

public class SecondHand_Test {
	SecondHandDao dao = new SecondHandDao();
	
	public static void main(String[] args) {
		

	}
	@Test
	public void saveGoods() {
		Goods goods = new Goods();
		goods.setTitle("我要卖");
		goods.setPrice(100);
		goods.setPhoto("E:\\MyFiles\\Myclass\\java-workspace\\"
				+ "web_server_workspace\\second_hand\\"
				+ "WebContent\\images.a.jpg");
		dao.saveGoods(goods);
	}
}
