package gem.second_hand.entity;

public class Favourite {
	//收藏表 Favourite
	private int id;
	private int goods_id;
	private int user_id;

	public Favourite(){

	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Favourite [goods_id=" + goods_id + ", user_id=" + user_id + "]";
	}
}
