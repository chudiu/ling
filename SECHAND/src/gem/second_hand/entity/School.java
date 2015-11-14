package gem.second_hand.entity;

public class School {
	//学校表 School
	private int id;
	private String  province;
	private String school;

	public School() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", province=" + province + ", school="
				+ school + "]";
	}
}
