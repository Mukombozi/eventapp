 package eventapp.service;
 
 import java.util.List;
 import eventapp.domain.Event;
 
 public interface EventManager {	
	public List<Event> getEvents();
    public void saveEvent(Event event);
    public List<Event> getEventByUser(int user_id);	
	//public void putEventJSONFormat(List<Event> list);
	//public List<Event> upComingEvent();	
 }