package eventapp.test.web;

import org.springframework.web.servlet.ModelAndView;
import junit.framework.TestCase;
import eventapp.service.SimpleEventManager;
import java.util.Map;
import java.util.ArrayList;
import eventapp.domain.Event;
import eventapp.web.HomeController;
import eventapp.test.repository.DataTransitInMemory;


public class HomeControllerTest extends TestCase {
	
	public void testHandleRequestView() throws Exception{
	HomeController controller = new HomeController();
	SimpleEventManager simpleEventManager = new SimpleEventManager();
	simpleEventManager.setEventDao(new DataTransitInMemory(new ArrayList<Event>()));	
	controller.setEventManager(simpleEventManager);
    ModelAndView modelAndView = controller.handleRequest(null, null);		
    assertEquals("home", modelAndView.getViewName());
	assertNotNull(modelAndView.getModel());
	Map modelMap = (Map)modelAndView.getModel().get("model");	
	String nowValue = (String) modelMap.get("now");
	assertNotNull(nowValue);
	}
}