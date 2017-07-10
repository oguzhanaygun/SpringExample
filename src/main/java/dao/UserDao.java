package dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.User;

@Repository
public class UserDao extends AbstractDao<String, User>{
	
	public User findByName(String name) {
        return getByKey(name);
    }
 
    
    public void saveUser(User user) {
        persist(user);
    }
    

}
