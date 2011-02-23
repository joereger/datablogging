package reger.scheduledtasks;

import reger.core.scheduler.SmtpListener;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import java.awt.*;


/**
 * App startup and shutdown tasks
 */

public class AppStartupAndShutdown implements ServletContextListener {
 public void contextInitialized(ServletContextEvent cse) {
    System.out.println("REGER: Application initialized");

    System.setProperty("java.awt.headless", "true");
    boolean headless = GraphicsEnvironment.isHeadless();
    System.out.println("Headless: " + headless);

 }
 public void contextDestroyed(ServletContextEvent cse) {
   SmtpListener.keepMeRunning = false;
   StartSmtpListener.shutdownListener();
   System.out.println("REGER: Application shut down");
 }
}