package gem.second_hand.service;

import gem.second_hand.dao.SchoolDao;
import gem.second_hand.entity.School;

public class SchoolService {
	private SchoolDao dao=new SchoolDao();
   
	public void saveSchool(School school) {
		dao.saveSchool(school);
	}	
	
	public School getSchoolById(int id) {
		return dao.getSchoolById(id);	
	}
	
	
}
