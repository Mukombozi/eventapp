package eventapp.domain;


public class Visitor extends User{
		
	String	phoneNumber;
    String	email;
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public String getEmail(){
		return email;
	}
	
}