package eventapp.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import eventapp.domain.Event;

@Repository
public class JdbcEventDao implements EventDao{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	private JdbcTemplate jdbcTemplate;	
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
		
	public List<Event> getEventList() {
       logger.info("Getting events list!!!");       
	   List<Event> events= jdbcTemplate.query(
                "select EVENT_ID, EVENT_TITLE, EVENT_DATE, EVENT_HRS,EVENT_EH"+
				", EVENT_PLACE, EVENT_DESC, EVENT_HOSTID from EVENTS", 
                new EventMapper());
        logger.info("End of getting all events list!!!"); 
		
		return events;
    }
	
	public List<Event> getEventByUser(int user_id){
		logger.info("getting all "+user_id+" events");
		
		List<Event> events = jdbcTemplate.query("select EVENT_ID, EVENT_TITLE,EVENT_DATE,EVENT_HRS,"+
		"EVENT_EH, EVENT_PLACE,EVENT_DESC, EVENT_HOSTID from EVENTS where EVENT_HOSTID = "+user_id, 
		new EventMapper());
		
		logger.info("End of getting all "+user_id+" events");
		return events;
	}
		
	public void saveEvent(Event event) {
        
		logger.info("Saving event: " + event.getEventTitle());        	
        jdbcTemplate.
		update("insert into EVENTS(EVENT_TITLE,EVENT_DATE, EVENT_HRS, EVENT_EH,EVENT_PLACE,EVENT_DESC, EVENT_HOSTID) values(?,?,?,?,?,?,?)",
		event.getEventTitle(),
		event.getEventDate(),
		event.getEventHrs(),
		event.getEventEH(),
		event.getEventPlace(),
		event.getEventDesc(),
		event.getEventHostId());		
		logger.info(event.getEventTitle()+ " Event saved!!");		   
					
    }	
	
	private static class EventMapper implements RowMapper<Event> {

        public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
            Event ev = new Event();
			ev.setEventId(new Integer(rs.getInt("EVENT_ID")));
            ev.setEventTitle(rs.getString("EVENT_TITLE"));
            ev.setEventDate(rs.getString("EVENT_DATE"));
			ev.setEventHrs(rs.getString("EVENT_HRS"));
			ev.setEventEH(rs.getString("EVENT_EH"));
			ev.setEventPlace(rs.getString("EVENT_PLACE"));
			ev.setEventDesc(rs.getString("EVENT_DESC"));
			ev.setEventHostId(new Integer(rs.getInt("EVENT_HOSTID")));            		
            return ev;
        }

    }
    
}