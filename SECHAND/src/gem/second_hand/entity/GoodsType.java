package gem.second_hand.entity;

public class GoodsType {
	//商品类型表 GoodsType
	private int id;
	private String name;
	private String torder;
	public GoodsType () {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTorder() {
		return torder;
	}
	public void setTorder(String torder) {
		this.torder = torder;
	}
	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", name=" + name + ", torder=" + torder
				+ "]";
	}
	
}
