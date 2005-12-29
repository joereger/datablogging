package reger.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.*;
import reger.core.db.DbConfig;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            //Create a configuration object
            Configuration conf = new Configuration();
            //Add mapping files
            String pathToMaps = reger.core.WebAppRootDir.getWebAppRootPath() + "hibernatemaps/";
            conf.addFile(pathToMaps + "Cat.hbm.xml");
            //Set up database connection
            conf.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLMyISAMDialect");
            conf.setProperty("hibernate.current_session_context_class", "thread");
            conf.setProperty("hibernate.connection.username", DbConfig.getDbUsername());
            conf.setProperty("hibernate.connection.url", DbConfig.getDbConnectionUrl());
            conf.setProperty("hibernate.connection.password", DbConfig.getDbPassword());
            conf.setProperty("hibernate.connection.driver_class", DbConfig.getDbDriverName());

            conf.setProperty("hibernate.c3p0.min_size", String.valueOf(DbConfig.getDbMinIdle()));
            conf.setProperty("hibernate.c3p0.max_size", String.valueOf(DbConfig.getDbMaxActive()));
            conf.setProperty("hibernate.c3p0.timeout", String.valueOf(DbConfig.getDbMaxWait()));
            conf.setProperty("hibernate.c3p0.max_statements", "50");

            // Create the SessionFactory
            sessionFactory = conf.buildSessionFactory();

            System.out.println("Reger.com: HibernateUtil Session Initialized. Let's rock some data abstration!");
            System.out.println("Reger.com: HibernateUtil: un:"+DbConfig.getDbUsername()+" pw:"+DbConfig.getDbPassword());
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Reger.com: Initial Hibernate SessionFactory creation failed." + ex);
            System.out.println("Reger.com: Initial Hibernate SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

//    public static final ThreadLocal session = new ThreadLocal();
//
//    public static Session currentSession() throws HibernateException {
//        Session s = (Session) session.get();
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
//        if (s != null){
//            s.close();
//        }
//    }













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
//            conf.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//            conf.setProperty("hibernate.connection.username", DbConfig.getDbUsername());
//            conf.setProperty("hibernate.connection.url", DbConfig.getDbConnectionUrl());
//            conf.setProperty("hibernate.connection.password", DbConfig.getDbPassword());
//            conf.setProperty("hibernate.connection.driver_class", DbConfig.getDbDriverName());
//            //Create the sessionFactory
//            sessionFactory = conf.buildSessionFactory();
//
//            System.out.println("Reger.com: HibernateUtil Session Initialized. Let's rock some data abstration!");
//        } catch (Throwable ex) {
//            // Make sure you log the exception, as it might be swallowed
//            log.error("Initial SessionFactory creation failed.", ex);
//            System.out.println("Reger.com: HibernateUtil error: " + ex.getMessage());
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
