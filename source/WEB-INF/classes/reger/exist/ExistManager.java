package reger.exist;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

/**
 * Loads eXist embedded database and destroys it at the end
 */


public class ExistManager implements ServletContextListener {
 public void contextInitialized(ServletContextEvent cse) {
   System.out.println("Reger.com Application initialized");
   
   //call any other class here
 }
 public void contextDestroyed(ServletContextEvent cse) {
   System.out.println("Reger.com Application shut down");
   //do any clean up here
 }
}
