package eventapp.test.domain;

import junit.framework.TestCase;
import eventapp.domain.Event;


public class EventTest extends TestCase{
	
	private Event event;	
	
	protected void setUp() throws Exception{
		event = new Event();
	}
	
	public void testgetAndSetEventTitle(){
		String testTitle ="aName";
		assertNull(event.getEventTitle());
		event.setEventTitle(testTitle);
		assertEquals(testTitle,event.getEventTitle());		
	}
	public void testgetAndSetEventDate(){
		String testDate ="aDate";
		assertNull(event.getEventDate());
		event.setEventDate(testDate);
		assertEquals(testDate, event.getEventDate());
	}
	public void testgetAndSetEventPlace(){
		String testPlace ="aPlace";
		assertNull(event.getEventPlace());
		event.setEventPlace(testPlace);
		assertEquals(testPlace, event.getEventPlace());
	}
	public void testgetAndSetEventDescription(){
		String description = "adescription";
		assertNull(event.getEventDesc());
		event.setEventDesc(description);
		assertEquals(description, event.getEventDesc());
	}
	
}