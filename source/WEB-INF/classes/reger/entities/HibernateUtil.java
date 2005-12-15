package reger.entities;

//import org.hibernate.*;
//import org.hibernate.cfg.*;
//import org.apache.commons.logging.LogFactory;
//import org.apache.commons.logging.Log;
//import reger.core.db.DbConfig;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.ServletException;
//import java.io.IOException;

public class HibernateUtil {

//    private static Log log = LogFactory.getLog(HibernateUtil.class);
//
//    private static final SessionFactory sessionFactory;
//
//    static {
//        try {
//            //Create a configuration object
//            Configuration conf = new Configuration();
//            //Add mapping files
//            String pathToMaps = reger.core.WebAppRootDir.getWebAppRootPath() + "hibernatemaps/";
//            conf.addFile(pathToMaps + "Cat.hbm.xml");
//            //Set up database connection
//            conf.setProperty("dialect", "net.sf.hibernate.dialect.MySQLDialect");
//            conf.setProperty("connection.username", DbConfig.getDbUsername());
//            conf.setProperty("connection.url", DbConfig.getDbConnectionUrl());
//            conf.setProperty("connection.password", DbConfig.getDbPassword());
//            conf.setProperty("connection.driver_class", DbConfig.getDbDriverName());
//            //Create the sessionFactory
//            sessionFactory = conf.buildSessionFactory();
//
//            reger.core.Debug.logtodb("HibernateUtil.java","HibernateUtil Session Initialized. Let's rock some data abstration!");
//        } catch (Throwable ex) {
//            // Make sure you log the exception, as it might be swallowed
//            log.error("Initial SessionFactory creation failed.", ex);
//            reger.core.Debug.errorsave(ex, "HibernateUtil.java");
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static final ThreadLocal session = new ThreadLocal();
//
//    public static Session currentSession() throws HibernateException {
//        Session s = (Session) session.get();
//        // Open a new Session, if this Thread has none yet
//        if (s == null) {
//            s = sessionFactory.openSession();
//            session.set(s);
//        }
//        return s;
//    }
//
//    public static void closeSession() throws HibernateException {
//        Session s = (Session) session.get();
//        session.set(null);
//        if (s != null)
//            s.close();
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //Must be here so that Tomcat considers this to be a servlet and will load it at Tomcat startup
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //Must be here so that Tomcat considers this to be a servlet and will load it at Tomcat startup
//    }

}
