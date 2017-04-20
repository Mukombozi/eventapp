package eventapp.test.repository;

import java.util.List;
import eventapp.domain.Event;
import eventapp.repository.EventDao;

public class DataTransitInMemory implements EventDao{
	
	List<Event> eventList;
	public DataTransitInMemory(List<Event> eventList){
		this.eventList = eventList;
	}
	
	public List<Event> getEventList(){
		return eventList;
	}
	public void saveEvent(Event event){
		
	}
}



