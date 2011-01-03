package reger.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.File;

import reger.systemprops.InstanceProperties;

public class HibernateUtilAnnotations {

    private static SessionFactory sessionFactory;
    private static final ThreadLocal session = new ThreadLocal();

    static {
        try {
            //Create a configuration object
            AnnotationConfiguration conf = new AnnotationConfiguration();
            //Add config file
            String pathConfig = reger.core.WebAppRootDir.getWebAppRootPath() + "WEB-INF/classes/hibernate.cfg.xml";
            conf.configure(new File(pathConfig));
            //conf.addPackage("reger.dao.hibernate");
            //conf.addAnnotatedClass(Banner.class);
            //Set up database connection
            conf.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            conf.setProperty("hibernate.connection.username", InstanceProperties.getDbUsername());
            conf.setProperty("hibernate.connection.url", InstanceProperties.getDbConnectionUrl());
            conf.setProperty("hibernate.connection.password", InstanceProperties.getDbPassword());
            conf.setProperty("hibernate.connection.driver_class", InstanceProperties.getDbDriverName());

            //Misc
            //conf.setProperty("hibernate.current_session_context_class", "thread");
            conf.setProperty("hibernate.show_sql", "true");
            conf.setProperty("hibernate.generate_statistics", "false");

            //Connection pool
            conf.setProperty("hibernate.c3p0.min_size", String.valueOf(InstanceProperties.getDbMinIdle()));
            conf.setProperty("hibernate.c3p0.max_size", String.valueOf(InstanceProperties.getDbMaxActive()));
            conf.setProperty("hibernate.c3p0.timeout", String.valueOf(InstanceProperties.getDbMaxWait()));
            conf.setProperty("hibernate.c3p0.max_statements", "50");

            //Second level cache
            conf.setProperty("hibernate.cache.use_second_level_cache", "true");
            conf.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.OSCacheProvider");
            conf.setProperty("hibernate.cache.use_structured_entries", "false");
            conf.setProperty("hibernate.cache.use_query_cache", "false");

            // Create the SessionFactory
            HibernateUtilAnnotations.sessionFactory = conf.buildSessionFactory();

            System.out.println("Reger.com: HibernateUtil Session Initialized. Let's rock some data abstration!");
            System.out.println("Reger.com: HibernateUtil: username:"+ InstanceProperties.getDbUsername());
        } catch (Throwable ex) {
            System.out.println("Reger.com: Initial Hibernate SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }



    public static Session getSession() throws HibernateException {
        Session s = (Session) HibernateUtilAnnotations.session.get();
        if (s==null||!s.isOpen()) {
            s = HibernateUtilAnnotations.sessionFactory.openSession();
            HibernateUtilAnnotations.session.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = (Session) HibernateUtilAnnotations.session.get();
        HibernateUtilAnnotations.session.set(null);
        if (s!=null && s.isOpen()){
            s.close();
        }
    }

    public static Object load(Class clazz, int id){
        return HibernateUtilAnnotations.getSession().get(clazz, id);
    }

    public static void save(Object obj){
        Session hsession = HibernateUtilAnnotations.getSession();
        hsession.beginTransaction();
        hsession.saveOrUpdate(obj);
        hsession.getTransaction().commit();
        hsession.close();
    }

    public static void delete(Object obj){
        Session hsession = HibernateUtilAnnotations.getSession();
        hsession.beginTransaction();
        hsession.delete(obj);
        hsession.getTransaction().commit();
        hsession.close();

    }




}
