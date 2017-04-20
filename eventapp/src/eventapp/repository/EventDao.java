package eventapp.repository;


import java.util.List;
import eventapp.domain.Event;

public interface EventDao{
	
	public List<Event> getEventList();
	public void saveEvent(Event event);
	public List<Event> getEventByUser(int user_id);
	
}