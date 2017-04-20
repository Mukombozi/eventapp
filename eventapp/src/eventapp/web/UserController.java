package eventapp.web;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.annotation.Validated;

import org.springframework.validation.DataBinder;
import org.springframework.validation.BindingResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import eventapp.domain.Event;
import eventapp.service.EventManager;
import eventapp.domain.User;
import eventapp.service.UserManager;
import eventapp.service.FormValidator;
//import eventapp.service.EventFormValidator;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@SessionAttributes({"visa","user","username"})
public class UserController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private EventManager eventManager;
	
	@Autowired
	private UserManager userManager;	
	
	//@Autowired
	//private UserFormValidator userFormValidator;
	
	//@Autowired
	//private FormValidator formValidator;
	
	private DataBinder binder;
	
	@InitBinder({"event","user"})
	protected void initBinder(WebDataBinder binder){
	      binder.setValidator(new FormValidator());		 
	}
	
	boolean visa=false;
	String username;
	int userId;
	
    /*
	@ModelAttribute
	public boolean setVisa(){		
		boolean visa = false;
		return visa;		
	}
	*/
	
	@ModelAttribute
	public User setUser(){
		User user = new User();
		return user;
	}
	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String homeView(Model myModel){     	
		SimpleDateFormat datefmt = new SimpleDateFormat("dd/MM/yyy");
		Calendar cal = Calendar.getInstance();
		String now = (datefmt.format(cal.getTime())).toString();
		
        myModel.addAttribute("now",now);
		logger.info("Returning home view with " + now);
		
		List<Event> events = eventManager.getEvents();	
		myModel.addAttribute("size",events.size());		
		myModel.addAttribute("events",eventManager.getEvents());
		
		return "home";  		
	}
	
	@RequestMapping(path="/profil", method=RequestMethod.GET)
	public String userProfil(Model myModel){
		
		
		//List<User> profile = userManager.getUsers();		
		if(!visa){						      	
			return "profil";
		}
		
		if(visa){
		logger.info("the user "+username+" created event !!!!!!!!!!!!!!!!");
		logger.info("The user id "+userId);
		List<Event> user_events =  eventManager.getEventByUser(userId);		
		User auth_user = userManager.getUserById(userId);
		logger.info("User email "+auth_user.getEmail()+" User Tel "+auth_user.getTel());
		myModel.addAttribute("name",auth_user.getUserName());
		myModel.addAttribute("lastname",auth_user.getLastName());
		username = auth_user.getUserName();
		myModel.addAttribute("email",auth_user.getEmail());
		myModel.addAttribute("telephone",auth_user.getTel());			
		
		myModel.addAttribute("userEv", user_events);
		
		for(Event ev : user_events) logger.info("event title "+ev.getEventTitle()+" place "+ev.getEventPlace());
		
		return "profil";	
		}
		return "home";
	}
	
	@RequestMapping(path="/adduser", method=RequestMethod.GET)
	public ModelAndView newUserForm(){		
		return new ModelAndView("adduser","user",new User());
	}
	/*
	public ActionForward execute(){
		
	}
	*/
	@PostMapping("/adduser")
	public String newUser(@ModelAttribute("user") @Validated User user, BindingResult bindingResult){
		User u = new User();
		//binder = new DataBinder(u);
		//binder.setValidator(new UserFormValidator());
		//binder.bind(user);
		//binder.vaidate();
		if(bindingResult.hasErrors()) return "adduser";
		
		u.setName(user.getName());
		u.setLastName(user.getLastName());
		u.setUserName(user.getUserName());
		u.setPassword(user.getPassword());
		u.setEmail(user.getEmail());
		u.setTel(user.getTel());		
		userManager.saveUser(u);
								
		return "result";
	}
	
	@PostMapping("/home")
	public String connect(@ModelAttribute("user") User user, Model model, HttpSession session){
		List<User> list = userManager.getUsers();
		User user_session = (User)session.getAttribute("user");		
		for(User u : list){ 
			if(((u.getUserName()).equals(user.getUserName()))&&
			((u.getPassword()).equals(user.getPassword()))){						
			user.setUserName(user.getUserName());
			visa=true;
			model.addAttribute("visa", visa);
			model.addAttribute("username", user.getUserName());			
			user_session.setUserName(u.getUserName());
			user_session.setPassword(u.getPassword());
			session.setAttribute("user",user_session);
			User usert = (User)session.getAttribute("user");
			logger.info("Displaying in connect user "+usert.getUserName());
			userId = userManager.getUserId(usert.getUserName());
			logger.info("Displaying in connect userId "+userId);
			logger.info("Displaying in connect test "+visa);
			return homeView(model);
			}
		}
		if(!visa){
			model.addAttribute("visa", new Boolean(false));
			return homeView(model);
		}
		logger.info(user.getUserName()+"<<<<>>>>"+user.getPassword());
		return "home";
	}
	 
	
	@RequestMapping(path="/event",method=RequestMethod.GET)
	public ModelAndView eventForm(Model model){
		model.addAttribute("event", new Event());
		
		logger.info("Executing the EventController");
		return new ModelAndView("event","event", new Event()); 				
	 }	
	
	@PostMapping("/event")
	public String newEvent(@ModelAttribute("event")  @Validated Event event, BindingResult bindingResult){
						
		if(visa){
			Event ev = new Event();
			if(bindingResult.hasErrors()) return "event";
			
			ev.setEventTitle(event.getEventTitle());
			ev.setEventPlace(event.getEventPlace());
			ev.setEventDate(event.getEventDate());
			ev.setEventHrs(event.getEventHrs());
			ev.setEventEH(event.getEventEH());
			ev.setEventHostId(userId);
			ev.setEventDesc(event.getEventDesc());
			
			eventManager.saveEvent(ev);

		}
							
	    return "result"; 				
	}
	
	
	@RequestMapping(value="/myTest",method=RequestMethod.GET)		
	@ResponseStatus(HttpStatus.OK)
	public  @ResponseBody List<Event> getAllEvent(){		
		logger.info("Is it executed !!!!!!!!");
		List<Event> events  = eventManager.getEvents();
		return events;
	}
	
	@RequestMapping("/end")
	public String disconnect(SessionStatus status){
		status.setComplete();
		return "last";
	}
	
	
	
	
	
}