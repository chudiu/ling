package gem.second_hand.entity;

public class School {
	//学校表 School
	private int id;
	private String  loca;
	private String name;

	public School() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getLoca() {
		return loca;
	}

	public void setLoca(String loca) {
		this.loca = loca;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", province=" + loca + ", school="
				+ name + "]";
	}
}
