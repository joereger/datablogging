package reger.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.event.SaveOrUpdateEventListener;
import org.hibernate.cfg.Configuration;

import java.io.File;


import reger.core.db.DbConfig;
import reger.hibernate.eventlisteners.RegerDefaultSaveOrUpdateEventListener;
import reger.hibernate.eventlisteners.RegerDefaultUpdateEventListener;
import reger.hibernate.eventlisteners.RegerDefaultSaveEventListener;
import reger.hibernate.interceptors.ValidationInterceptor;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static final ThreadLocal session = new ThreadLocal();

    static {
        try {
            //Create a configuration object
            Configuration conf = new Configuration();
            //Add config file
            String pathConfig = reger.core.WebAppRootDir.getWebAppRootPath() + "WEB-INF/classes/hibernate.cfg.xml";
            conf.configure(new File(pathConfig));
            //conf.addPackage("reger.dao.hibernate");
            //conf.addAnnotatedClass(Banner.class);
            //Set up database connection
            conf.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            conf.setProperty("hibernate.connection.username", DbConfig.getDbUsername());
            conf.setProperty("hibernate.connection.url", DbConfig.getDbConnectionUrl());
            conf.setProperty("hibernate.connection.password", DbConfig.getDbPassword());
            conf.setProperty("hibernate.connection.driver_class", DbConfig.getDbDriverName());

            //Misc
            //conf.setProperty("hibernate.current_session_context_class", "thread");
            conf.setProperty("hibernate.show_sql", "true");
            conf.setProperty("hibernate.generate_statistics", "false");

            //Save or update validation listener
//            SaveOrUpdateEventListener[] stack = { new RegerDefaultSaveOrUpdateEventListener() };
//            conf.getEventListeners().setSaveOrUpdateEventListeners(stack);
//            SaveOrUpdateEventListener[] stack2 = { new RegerDefaultUpdateEventListener() };
//            conf.getEventListeners().setUpdateEventListeners(stack2);
//            SaveOrUpdateEventListener[] stack3 = { new RegerDefaultSaveEventListener() };
//            conf.getEventListeners().setSaveEventListeners(stack3);

            //Interceptor(s)
//            conf.setInterceptor(new ValidationInterceptor());

            //Connection pool
            conf.setProperty("hibernate.c3p0.min_size", String.valueOf(DbConfig.getDbMinIdle()));
            conf.setProperty("hibernate.c3p0.max_size", String.valueOf(DbConfig.getDbMaxActive()));
            conf.setProperty("hibernate.c3p0.timeout", String.valueOf(DbConfig.getDbMaxWait()));
            conf.setProperty("hibernate.c3p0.max_statements", "50");

            //Second level cache
            conf.setProperty("hibernate.cache.use_second_level_cache", "true");
            conf.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.OSCacheProvider");
            conf.setProperty("hibernate.cache.use_structured_entries", "false");
            conf.setProperty("hibernate.cache.use_query_cache", "true");
            conf.setProperty("hibernate.cache.usage", "nonstrict-read-write");

            // Create the SessionFactory
            sessionFactory = conf.buildSessionFactory();

            System.out.println("Reger.com: HibernateUtil Session Initialized. Let's rock some data abstration!");
            System.out.println("Reger.com: HibernateUtil: username:"+DbConfig.getDbUsername());
        } catch (Throwable ex) {
            System.out.println("Reger.com: Initial Hibernate SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }



    public static Session getSession() throws HibernateException {
        Session s = (Session) HibernateUtil.session.get();
        if (s==null||!s.isOpen()) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = (Session)session.get();
        session.set(null);
        if (s!=null && s.isOpen()){
            s.close();
        }
    }

    public static Object load(Class clazz, int id){
        return getSession().get(clazz, id);
    }


    public static void refresh(Object obj){
        getSession().refresh(obj);
    }

    public static void save(Object obj) throws HibValEx {

        try{
            ValidateWorker.validate(obj);
        } catch (HibValEx hex){
            throw hex;
        }

        try{
            Session hsession = getSession();
            hsession.beginTransaction();
            hsession.saveOrUpdate(obj);
            hsession.getTransaction().commit();
            hsession.close();
        } catch (HibernateException hibex){
            reger.core.Debug.errorsave(hibex, "HibernateUtil.java", "Problem with HibernateUtil.save()");
            HibValEx hex = new HibValEx("Sorry, unable to complete database update: "+hibex.getMessage());
            throw hex;
        }
    }

    public static void delete(Object obj){
        Session hsession = getSession();
        hsession.beginTransaction();
        hsession.delete(obj);
        hsession.getTransaction().commit();
        hsession.close();
    }




}
