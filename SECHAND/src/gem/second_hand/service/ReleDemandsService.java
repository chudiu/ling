package gem.second_hand.service;

import gem.second_hand.dao.ReleDemandsDao;
import gem.second_hand.entity.ReleDemands;

public class ReleDemandsService {

	private ReleDemandsDao dao=new ReleDemandsDao();
	
	public void saveReleDemands(ReleDemands reled) {
		dao.saveReleDemands(reled);
	}
	
	public void deleteReleDemands(String[] ids) {
		dao.deleteReleDemands(ids);
	}
	
	public ReleDemands getReleDemandsById(int id) {
		return dao.getReleDemandsById(id);
	}
	
}
