package eventapp.domain;


public class Host extends User{
	
	private long hostId;
	private String email;
	private String phoneNumber;
	private String login;
	private String passWord;
	
	
	public void setHostId(long hostId){
		this.hostId = hostId;
	}
	
	public long getHostId(){
		return hostId;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public void setLogin(String login){
		this.login = login;
	}
	public String getLogin(){
		return login;
	}
	public void setPassword(String passWord){
		this.passWord = passWord;
	}
	public String getPassword(){
		return passWord;
	}
}