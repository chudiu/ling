package gem.second_hand.entity;

public class Demands {//对象之间怎么区分
	//需求表 Demands
	private int id;
	private int user_id ;
	private String title;
	private int type_id;
	private String descr ;
	private float price ;
	private String loca ;
	private int school_id;
	

	public Demands() {

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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getType_id() {
		return type_id;
	}


	public void setType_id(int type_id) {
		this.type_id = type_id;
	}


	public String getDescr() {
		return descr;
	}


	public void setDescr(String descr) {
		this.descr = descr;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getLoca() {
		return loca;
	}


	public void setLoca(String loca) {
		this.loca = loca;
	}


	public int getSchool_id() {
		return school_id;
	}


	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}




	@Override
	public String toString() {
		return "Demands [id=" + id + ", user_id=" + user_id + ", title="
				+ title + ", type_id=" + type_id + ", descr=" + descr
				+ ", price=" + price + ", loca=" + loca + ", school_id="
				+ school_id + "]";
	}
	
}
