package gem.second_hand.service;

import gem.second_hand.dao.DemandsDao;
import gem.second_hand.entity.Demands;

public class DemandsService {

	private DemandsDao dao=new DemandsDao();
	
	public void saveDemands(Demands d) {
		dao.saveDemands(d);
	}
	
	public Demands getDemandsById(int id) {
		return dao.getDemandsById(id);
	}
	
	public int getDemandsCounts() {
		return dao.getDemandsCounts();
	}
	
	public void updateDemands(Demands d) {
		dao.updateDemands(d);
	}
	
	public void deleteDemands(String[] ids) {
		dao.deleteDemands(ids);
	}
	
}
