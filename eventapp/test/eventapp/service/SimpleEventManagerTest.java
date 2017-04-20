package eventapp.test.service;

import junit.framework.TestCase;
import eventapp.service.SimpleEventManager;
import eventapp.domain.Event;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import eventapp.test.repository.DataTransitInMemory;
import eventapp.repository.EventDao;

public class SimpleEventManagerTest extends TestCase{
	private int eventList_size;
	private List<Event> eventList;	
	private SimpleEventManager eventManager;
	EventDao eventDao;
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	protected final Log logger = LogFactory.getLog(getClass());
	
	protected void setUp() throws Exception{
		
		eventManager = new SimpleEventManager();	
		eventList = new ArrayList<Event>();
		Event event1 = new Event();
		event1.setEventTitle("Dépistage");
		event1.setEventDate("12/01/2017");
		event1.setEventPlace("Cappucin");
		Event event2 = new Event();
		event2.setEventTitle("Reunion");
		event2.setEventDate("15/01/2017");
		event2.setEventPlace("Palludate");				
		eventList.add(event1);
		eventList.add(event2);		
		eventList_size = 2;
		eventDao = new DataTransitInMemory(eventList);
		eventManager.setEventDao(eventDao);
	}
	
	public void testgetEventListWithNoEvent(){		
		eventManager.setEventDao(new DataTransitInMemory(null));
		assertNull(eventManager.getEvents());
	}
	
	public void testgetAndSetListEventwithEvent(){		
		eventManager.setEventDao(eventDao);
		String firstEvent = "Dépistage";
		String lastEvent  = "Reunion";
		List<Event> list  = eventManager.getEvents();
		assertEquals(eventList_size,(list).size());
		assertEquals (firstEvent, (list.get(0)).getEventTitle());
		assertEquals (lastEvent, (list.get(1)).getEventTitle());		
	}
	
	public void testUpComingEvent(){
    LocalDate refDate = LocalDate.now();
	refDate = refDate.minusWeeks(1);
	List<Event> list = new ArrayList<Event>();
	String event;
	for(Event e : eventList){
		String event_str = e.getEventDate();
		LocalDate eventdate = LocalDate.parse(event_str, dtf);
		if(eventdate.isAfter(refDate)) list.add(e);
	}
	assertTrue("taille de la liste des événements à venir! "+list.size(),list.size()>0);
	}
	
}