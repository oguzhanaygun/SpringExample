package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import model.User;

@Service
@Transactional
public class UserService  {
	
	@Autowired
	UserDao dao;
	public void Save(User user){
		 dao.saveUser(user);
	}
	public User getUser(String email){
		return dao.getByKey(email);
	}


}
