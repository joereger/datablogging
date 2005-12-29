package reger.hibernate;

import javax.servlet.ServletContextEvent;

/**
 * Manages startup and shutdown of Hibernate object
 */
public class HibernateListener {

    public void contextInitialized(ServletContextEvent event) {
        HibernateUtil.getSessionFactory(); // Just call the static initializer of that class
    }

    public void contextDestroyed(ServletContextEvent event) {
        HibernateUtil.getSessionFactory().close(); // Free all resources
    }

}
