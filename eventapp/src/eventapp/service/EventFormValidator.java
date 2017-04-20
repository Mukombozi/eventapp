package eventapp.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import eventapp.domain.Event;

@Component
public class EventFormValidator implements Validator{
	         
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	public boolean supports(Class clazz){
		return Event.class.equals(clazz);
	}
	
	public void validate(Object obj, Errors errors){
		
		ValidationUtils.rejectIfEmpty(errors,"eventTitle","empty.name");
		ValidationUtils.rejectIfEmpty(errors,"eventPlace","empty.lastname");
		ValidationUtils.rejectIfEmpty(errors,"eventDate","empty.username");
		ValidationUtils.rejectIfEmpty(errors,"eventHrs","empty.password");
		ValidationUtils.rejectIfEmpty(errors,"eventEH","empty.confpassword");
		
		Event ev = (Event) obj;
		
		
		//LocalDate ev_date = LocalDate.parse(ev.getEventDate(),dtf);
		// logger.info("Validating with " + ev + ": " + ev.getEventPlace()+" "+ev.getEventTitle()+" "+ev.getEventDate());
		//if(ev_date.isBefore(today)){
		//	logger.info("Can't Validate with " + ev + ": " + ev.getEventPlace());
		//	errors.rejectValue("eventDate","date.passe");
		
	    //}
		
	}
	
}