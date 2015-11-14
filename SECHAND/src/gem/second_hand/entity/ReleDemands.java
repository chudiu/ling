package gem.second_hand.entity;

import java.sql.Date;

public class ReleDemands {
	//需求发布表 ReleDemands
	private int id;
	private int user_id;
	private int demands_id;
	private Date reletime;//哪个包

	public ReleDemands (){

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

	public int getDemands_id() {
		return demands_id;
	}

	public void setDemands_id(int demands_id) {
		this.demands_id = demands_id;
	}

	public Date getReletime() {
		return reletime;
	}

	public void setReletime(Date reletime) {
		this.reletime = reletime;
	}

	@Override
	public String toString() {
		return "ReleDemands [user_id=" + user_id + ", demands_id=" + demands_id
				+ ", reletime=" + reletime + "]";
	}
}
