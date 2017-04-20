package eventapp.repository;

import java.util.List;
import eventapp.domain.User;


public interface UserDao{
	public List<User> getUserList();
	public void saveUser(User user);
	public int getUserId(String username);
	public User getUserById(int userId);
}