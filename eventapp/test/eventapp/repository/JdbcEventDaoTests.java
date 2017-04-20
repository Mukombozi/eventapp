package eventapp.test.repository;

import java.util.List;
import eventapp.repository.EventDao;
import eventapp.domain.Event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class JdbcEventDaoTests extends AbstractTransactionalDataSourceSpringContextTests{
	private EventDao eventDao;
	protected final Log logger = LogFactory.getLog(getClass());
	public void setEventDao(EventDao eventDao){
		this.eventDao = eventDao;
	}
	
	@Override
	protected String[] getConfigLocations(){
		return new String[]{"classpath:test-context.xml"};
	}
	@Override
	protected void onSetUpInTransaction() throws Exception{
	    super.deleteFromTables(new String[]{"EVENTS","EV_USERS"});
		super.executeSqlScript("file:db/load_data.sql",true);
	}
	
	public void testGetEventList(){
		List<Event> events = eventDao.getEventList();
		assertEquals("number of events ?",1,events.size());
	}
	public void testSaveEvent(){
		List<Event> events = eventDao.getEventList();
		logger.info("Change event title");
		for(Event ev : events){
			ev.setEventDate("2017-01-01");
			eventDao.saveEvent(ev);			
		}
		logger.info("The changed event title");
		List<Event> updates = eventDao.getEventList();
		for(Event upEv : updates ){
			logger.info("Avant toutes les OP");
			assertEquals("wrong event place ?","2017-01-01",upEv.getEventDate());
			logger.info("Apres toutes les OP");
		}
		logger.info("Apres toutes les OP");
	}
}