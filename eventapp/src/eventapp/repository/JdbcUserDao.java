package eventapp.repository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import eventapp.domain.User;
import eventapp.repository.UserDao;

@Repository
public class  JdbcUserDao implements UserDao {
	
	private JdbcTemplate jdbcTemplate;	
	
	@Autowired	
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	protected final Log logger = LogFactory.getLog(getClass());
	public List<User> getUserList() {
    				
		logger.info("getting all registered users!");
        
		List<User> users = jdbcTemplate.query(
                "select NAME, LAST_NAME, USER_NAME"+
				", PASSWORD, EMAIL, TEL from EV_USERS", 
                new UserMapper());
		for(User u : users) logger.info(u.getName()+"  ->> "+u.getLastName());		
        return users;
    }
	
	public void saveUser(User user) {
    
		logger.info("Saving user: " + user.getLastName());        	
        jdbcTemplate.
		update("insert into EV_USERS(NAME, LAST_NAME, "+
		"USER_NAME, PASSWORD, EMAIL, TEL) values(?,?,?,?,?,?)",
		user.getName(),user.getLastName(),user.getUserName(),user.getPassword(), user.getEmail(),user.getTel());
		
		logger.info(user.getUserName()+ " saved!!");		   
					
    }
	
	public int getUserId(String username){
		
		int userId = jdbcTemplate.queryForObject("select USER_ID from EV_USERS where USER_NAME = ?",Integer.class,username);
		logger.info("return userId "+userId);
		return userId;
	}
	
	public User getUserById(int userId){
		logger.info("find user by id >>>>>>>>>>>"+userId);
		User user = jdbcTemplate.queryForObject("select NAME, LAST_NAME, USER_NAME,"+		
		"PASSWORD, EMAIL, TEL from EV_USERS where USER_ID = ?",new Object[]{userId},
		new UserMapper());
		logger.info("user info "+user.getName()+" "+user.getLastName()+" "+user.getEmail());
		return user;
	}
	private static class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            //user.setUserId(new Integer(rs.getInt("USER_ID")));
            user.setName(rs.getString("NAME"));
			user.setLastName(rs.getString("LAST_NAME"));
			user.setUserName(rs.getString("USER_NAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setEmail(rs.getString("EMAIL"));
			user.setTel(rs.getString("TEL"));
			            		
            return user;
        }

    }
    	
}