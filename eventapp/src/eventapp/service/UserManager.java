package eventapp.service;

import java.util.List;
import eventapp.domain.User;

public interface UserManager{
	//public User createUser();
	public List<User> getUsers();
	//public List<User> getProfile();
	public void saveUser(User user);
	public int getUserId(String username);
	public User getUserById(int userId);
}
