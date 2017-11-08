package be.vdab.listeners;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class MandjeListener
 *
 */
@WebListener
public class MandjeListener implements ServletContextListener, HttpSessionAttributeListener {

  
	private static final String MANDJE = "mandje";
	private static final String AANTAL_MANDJES = "aantalMandjes";
	
 
    public void contextInitialized(ServletContextEvent event)  { 
	       event.getServletContext().setAttribute(AANTAL_MANDJES, new AtomicInteger());
	    }
	
	
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    }


    public void attributeAdded(HttpSessionBindingEvent event)  { 
        if(MANDJE.equals(event.getName())) {
        	
        	((AtomicInteger)
        			event.getSession().getServletContext().getAttribute(AANTAL_MANDJES))
        	.incrementAndGet();
        	
        }
    }

	
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         if(MANDJE.equals(event.getName())) {
        	 
        	 ((AtomicInteger) event.getSession().getServletContext()
        			 .getAttribute(AANTAL_MANDJES)).decrementAndGet();
        	 
         }
    }

	
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

	
  
	
}
