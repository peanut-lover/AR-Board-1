package arboard.common.listener;

import java.util.HashMap; 

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class ARBoardServletContextListener implements ServletContextListener {

	// ServletContext has Attribute ( name is ACTIVEUSERS_ATTRIBUTE_NAME )
	// ACTIVEUSERS attribute is HashMap<String,HttpSession> about active users
	public static final String ACTIVEUSERS_ATTRIBUTE_NAME = "activeUsers";
	

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext context = event.getServletContext();
		if(context.getAttribute(ACTIVEUSERS_ATTRIBUTE_NAME) == null){
			System.out.println("Context Initialization");
			context.setAttribute(ACTIVEUSERS_ATTRIBUTE_NAME, new HashMap<String, HttpSession>()); 
		}
		
		String certificatePath = context.getRealPath("/apns.pem");
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
