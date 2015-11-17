package gem.second_hand.service;

import gem.second_hand.dao.UserDao;
import gem.second_hand.entity.User;




public class UserService {
private UserDao dao=new UserDao();
public void save(User u){
	dao.saveUser(u);
	
	
}
}
