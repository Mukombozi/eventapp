package eventapp.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import eventapp.domain.User;
import eventapp.domain.Event;
@Component
public class FormValidator implements Validator{
	         
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public boolean supports(Class clazz){
		return (User.class.equals(clazz) || Event.class.equals(clazz));
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		
		if(obj instanceof User){
		ValidationUtils.rejectIfEmpty(errors,"name","empty.name");
		ValidationUtils.rejectIfEmpty(errors,"lastName","empty.lastname");
		ValidationUtils.rejectIfEmpty(errors,"userName","empty.username");
		ValidationUtils.rejectIfEmpty(errors,"password","empty.password");
		ValidationUtils.rejectIfEmpty(errors,"confPassword","empty.confpassword");
		ValidationUtils.rejectIfEmpty(errors,"email","empty.email");
		ValidationUtils.rejectIfEmpty(errors,"tel","empty.tel");
		}
		if(obj instanceof Event){
		ValidationUtils.rejectIfEmpty(errors,"eventTitle","empty.event_title");
		ValidationUtils.rejectIfEmpty(errors,"eventPlace","empty.event_place");
		ValidationUtils.rejectIfEmpty(errors,"eventDate","empty.event_date");
		ValidationUtils.rejectIfEmpty(errors,"eventHrs","empty.event_hrs");
		ValidationUtils.rejectIfEmpty(errors,"eventEH","empty.event_eh");
		}
		
		//User user = (User) obj;
		
		
		//LocalDate ev_date = LocalDate.parse(ev.getEventDate(),dtf);
		// logger.info("Validating with " + ev + ": " + ev.getEventPlace()+" "+ev.getEventTitle()+" "+ev.getEventDate());
		//if(ev_date.isBefore(today)){
		//	logger.info("Can't Validate with " + ev + ": " + ev.getEventPlace());
		//	errors.rejectValue("eventDate","date.passe");
		
	    //}
		
	}
	
}