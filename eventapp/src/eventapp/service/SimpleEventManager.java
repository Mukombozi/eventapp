package eventapp.service;

import java.util.List;
import java.util.ArrayList;
import eventapp.domain.Event;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import eventapp.repository.EventDao;
import java.time.format.DateTimeParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Thread;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SimpleEventManager implements EventManager{	
	protected final Log logger = LogFactory.getLog(getClass());	
	
	EventDao eventDao;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	
	public List<Event> upComingEvent(){
		List<Event> list = new ArrayList<Event>();
		List<Event> eventList_1 = getEvents();
		LocalDate refDate = LocalDate.now();
		refDate = refDate.minusWeeks(1);
		for(Event e : eventList_1){
			String d = e.getEventDate();
			try{
				logger.info("event date should come from database "+d);
				LocalDate date1 = LocalDate.parse(d,dtf);
			if(date1.isAfter(refDate)) list.add(e);	
			}
			catch(DateTimeParseException ex){
				logger.info("can not parse the date"+d);
			}
			
		}		
		return list;
	}
	
	
	public List<Event> getEvents(){
		return eventDao.getEventList();
	}
	public void saveEvent(Event event){						
		eventDao.saveEvent(event);
		(new LoadEventJSon()).start();
	}
	
	public List<Event> getEventByUser(int user_id){
		return eventDao.getEventByUser(user_id);
	}
	
	@Autowired
	public void setEventDao(EventDao eventDao){
		this.eventDao = eventDao;
	}
	
	class LoadEventJSon extends Thread {
				
		List<Event> list;		
		ObjectMapper objectMapper;
		
		public void run(){			
			objectMapper = new ObjectMapper();		    
			try{			
				list = getEvents();
				Event event;
								
				FileOutputStream fout = 
				new FileOutputStream("C:\\Program Files\\Apache Software Foundation\\apache-tomcat-7.0.70\\webapps\\eventapp\\resources\\js\\jspall_events.json");
				PrintWriter writer = new PrintWriter(fout);
				writer.println("{");
				writer.println(" \"events\":");
				writer.println("[");
				for(Event e: list){
					event = new Event();
					event.setEventId(e.getEventId());
					event.setEventTitle(e.getEventTitle());
					event.setEventPlace(e.getEventPlace());
					event.setEventDate(e.getEventDate());
					event.setEventHrs(e.getEventHrs());
					event.setEventEH(e.getEventEH());
					event.setEventDesc(e.getEventDesc());					
					String value = objectMapper.writeValueAsString(event);
					writer.println(value+",");
					writer.flush();
				} 					
				writer.println("]");
				writer.println("}");
				writer.flush();				
			}catch(IOException ex){logger.info(ex);}	
			
		}
	}
	
	}