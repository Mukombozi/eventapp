package eventapp.domain;

import java.io.Serializable;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
public class Event {
	private int eventId;
	private String eventTitle;	
	private String eventDate;
	private String eventPlace;
	private String eventDesc;
	private String eventHrs;
	private String eventEH;
	private int eventHostId;
    private List<Event> eventList;
	//private Map<String, String> eventFeedBack;
	
	public Event(){		
	}
	
	public void setEventId(int eventId){
		this.eventId = eventId;
	}
	public void setEventEH(String end_hr){
		this.eventEH = end_hr;
	}
	public String getEventEH(){
		return eventEH;
	}
	public int getEventId(){
		return eventId;
	}
	public String getEventTitle(){
		return eventTitle;
	}
	public void setEventTitle(String eventTitle){
		this.eventTitle = eventTitle;
	}
	
	public String getEventDate(){
		return eventDate;
	}
	public void setEventDate(String eventDate){
		this.eventDate = eventDate;
	}
	public String getEventPlace(){
		return eventPlace;
	}
	public void setEventPlace(String eventPlace){
		this.eventPlace = eventPlace;
	}
	public String getEventDesc(){
		return eventDesc;
	}
	public void setEventDesc(String eventDesc){
		this.eventDesc = eventDesc;
	}
	
	public String getEventHrs(){
		return eventHrs;
	}
	public void setEventHrs(String eventHrs){
		this.eventHrs = eventHrs;
	}
	public int getEventHostId(){
		return eventHostId;
	}
	public void setEventHostId(int eventHostId){
		this.eventHostId = eventHostId;
	}
	
	public void setEventList(List<Event> list){
		this.eventList = list;
	}
	public List getEventList(){
		return eventList;
	}
	
	
}