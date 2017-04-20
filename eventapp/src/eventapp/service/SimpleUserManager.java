package eventapp.service;

import java.util.List;
import java.util.ArrayList;
import eventapp.domain.Event;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import eventapp.domain.User;
import eventapp.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SimpleUserManager implements UserManager{
	List<User> list;
	UserDao userDao;
	
	public User createUser(){
		User user = new User();
		return user;
	}
	public List<User> getUsers(){
		list = userDao.getUserList();
		return list;
	}
	public void saveUser(User user){
		userDao.saveUser(user);
	}
	
	public int getUserId(String username){
		return userDao.getUserId(username);
	}
	public User getUserById(int userId){
		return userDao.getUserById(userId);
	}
	@Autowired
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
}