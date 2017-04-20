package eventapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import eventapp.domain.User;

@Component
@Controller
@RequestMapping("/home")
public class LoginController{
	
	protected final Log logger = LogFactory.getLog(getClass());
	User user;
	
	@RequestMapping(value="/connect1", method=RequestMethod.POST)
	public String connect1(@ModelAttribute User user){		
		
		logger.info("Having "+user.getUserName()+" and "+user.getPassword());
		return "home";
	}
	
	@RequestMapping("/connect2")
	public String connect2(){		
		
		//logger.info("Having "+user.getUserName()+" and "+user.getPassword());
		return "home";
	}
	
}