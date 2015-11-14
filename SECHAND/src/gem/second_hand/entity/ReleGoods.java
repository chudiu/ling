package gem.second_hand.entity;

import java.sql.Date;

public class ReleGoods {
	//商品发布表 ReleGoods
	private int id;
	private int user_id;
	private int goods_id;
	private Date reletime;//哪个包

	public ReleGoods() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public Date getReletime() {
		return reletime;
	}

	public void setReletime(Date reletime) {
		this.reletime = reletime;
	}

	@Override
	public String toString() {
		return "ReleGoods [user_id=" + user_id + ", goods_id=" + goods_id
				+ ", reletime=" + reletime + "]";
	}
}
