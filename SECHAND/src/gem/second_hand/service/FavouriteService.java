package gem.second_hand.service;

import gem.second_hand.dao.FavouriteDao;
import gem.second_hand.entity.Favourite;

public class FavouriteService {

	private FavouriteDao dao=new FavouriteDao();
	
	public void deleteFavourite(String[] ids) {
		dao.deleteFavourite(ids);
	}
	
	public Favourite getFavouriteById(int id) {
		return dao.getFavouriteById(id);

	}
	
	public void saveFavourite(Favourite f) {
		dao.saveFavourite(f);
	}
	
	
}
