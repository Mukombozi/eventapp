package eventapp.web;

/*
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
*/
//import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import eventapp.service.UserManager;
import eventapp.domain.User;

@Component
@Controller
@RequestMapping("/create_user")
public class NewUserController /* extends SimpleFormController */ {
	
	UserManager userManager;
	
	//@Override
	//protected ModelAndView onSubmit(Object command) throws ServletException {
	
	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public String newUser(@ModelAttribute User command){	
		User user = new User();
		user.setUserName((command).getUserName());
		user.setLastName((command).getLastName());
		user.setName((command).getName());
		user.setPassword((command).getPassword());
		user.setEmail((command).getEmail());
		user.setTel((command).getTel());
		userManager.saveUser(user);
		
		return "home"; 
		//new ModelAndView(new RedirectView(getSuccessView()));
	}
	
	/*
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws ServletException{
		User user = new User();
		return user;
	}
	*/
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}
	
	public UserManager getUserManager(){
		return userManager;
	}
}