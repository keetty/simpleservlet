package folder.database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.web.context.ContextLoader;

public class Listener implements ServletContextListener {
	ContextLoader contextLoader;
	
	protected ContextLoader createContextLoader () {
	return new ContextLoader (); 
	} 

@Override
	public void contextInitialized(ServletContextEvent event) {
		this.contextLoader = createContextLoader ();
		this.contextLoader.initWebApplicationContext (event.getServletContext ()); 
	}
@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

}