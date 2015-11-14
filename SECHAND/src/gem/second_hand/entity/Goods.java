package gem.second_hand.entity;

public class Goods {//对象怎么区分？？？
	//商品表 Goods
	private int id;
	private String title;
	private float price;
	private String  photo;//只存放路径
	private String voice; //只存放路径
	private int type_id ;//int
	private String descr;
	private int user_id ;
	private int viewcont ;
	private String loca;
	private int school_id;

	public Goods() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getViewCount() {
		return viewcont;
	}

	public void setViewCount(int views) {
		this.viewcont = views;
	}

	public String getLoca() {
		return loca;
	}

	public void setLoca(String loco) {
		this.loca = loco;
	}

	public int getSchool_id() {
		return school_id;
	}

	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}
	
	

	@Override
	public String toString() {
		return "Goods [id=" + id + ", title=" + title + ", price=" + price
				+ ", photo=" + photo + ", voice=" + voice + ", type_id="
				+ type_id + ", descr=" + descr + ", user_id=" + user_id
				+ ", views=" + viewcont + ", loco=" + loca + ", school_id="
				+ school_id + "]";
	}
	 
}
