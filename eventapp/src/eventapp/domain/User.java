package eventapp.domain;



public class User {
	
	private int userId;
	
	private String userName;
	
	private String lastName;
	
	private String name;
	
	private String password;
	
	private String confPassword;
	
	private String email;
	
	private String tel;
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return userId;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getUserName(){
		return userName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setConfPassword(String confPassword){
		this.confPassword = confPassword;
	}
	public String getConfPassword(){
		return confPassword;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setTel(String tel){
		this.tel = tel;
	}
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	public String getEmail(){
		return email;
	}
	public String getTel(){
		return tel;
	}
		
}