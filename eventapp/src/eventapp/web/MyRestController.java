package eventapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;
import java.util.ArrayList;

import eventapp.domain.Event;
import eventapp.service.EventManager;


@RestController
public class MyRestController {
	
	@Autowired
	private EventManager eventManager;
	
	@RequestMapping(value="/eventlist", method=RequestMethod.GET)
	public List<Event> testRest(Model model){
		List<Event> events;
		/*
		List<Event> list = new ArrayList<Event>();
		Event event = new Event();
		event.setEventTitle("Gashibutisi");
		event.setEventPlace("Victoire");
		event.setEventDate("2017-03-20");
		list.add(event);
		event.setEventTitle("Biragoye");
		event.setEventPlace("Place de Marne");
		event.setEventDate("2017-03-20");
		model.addAttribute("list",list);
		list.add(event);
		*/
		events = eventManager.getEvents();
		return events;
	}
	
}