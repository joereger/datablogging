package reger.scheduledtasks;

import reger.core.scheduler.SmtpListener;
import reger.hibernate.HibernateUtil;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;


/**
 * App startup and shutdown tasks
 */

public class AppStartupAndShutdown implements ServletContextListener {
 public void contextInitialized(ServletContextEvent cse) {
   System.out.println("REGER: Application initialized");
 }
 public void contextDestroyed(ServletContextEvent cse) {
   SmtpListener.keepMeRunning = false;
   StartSmtpListener.shutdownListener();
   System.out.println("REGER: Application shut down");
 }
}