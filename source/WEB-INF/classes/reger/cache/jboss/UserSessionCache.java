package reger.cache.jboss;

import reger.UserSession;
import reger.core.WebAppRootDir;

import java.util.Set;
import java.util.HashSet;

import org.jboss.cache.TreeCache;
import org.jboss.cache.PropertyConfigurator;
import org.jboss.cache.CacheException;

public class UserSessionCache {

    private static UserSessionCache instance;
    private static int checkedOut = 0;
    private static int created = 0;
    private static TreeCache userSessionCache;
    private static String fqn = "/usersession";

    private UserSessionCache(){
        try{
            created++;
            userSessionCache = new TreeCache();
            PropertyConfigurator config = new PropertyConfigurator();
            config.configure(userSessionCache, WebAppRootDir.getWebAppRootPath()+"WEB-INF/jbosscache-replSync-service.xml");
            userSessionCache.startService();
            reger.core.Debug.debug(3, "UserSessionCache.java", "JBossCache UserSessionCache created.");
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }
    }

    /**
     * Singleton access point to the manager.
     */
    public static UserSessionCache getInstance(){
        synchronized (UserSessionCache.class){
            if (instance == null){
                instance = new UserSessionCache();
            }
        }

        synchronized (instance){
            instance.checkedOut++;
        }

        return instance;
    }


    public void flushUserSessions(){
        try{
            userSessionCache.remove(fqn);
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }

    }

    public void removeUserSession(String userSessionid){
        try{
            userSessionCache.remove(fqn, "UserSession"+userSessionid);
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }

    }

    public void removeUserSessionByCacheKey(String key){
        reger.core.Debug.debug(4, "UserSessionCache.java", "removeUserSessionByCacheKey("+key+")");
        try{
            if(userSessionCache.get(fqn, key)!=null){
                reger.core.Debug.debug(4, "UserSessionCache.java", "userSessionCache.get("+key+")!=null");
            } else {
                reger.core.Debug.debug(4, "UserSessionCache.java", "userSessionCache.get("+key+")==null");
            }
        } catch (CacheException ex){
            reger.core.Debug.debug(4, "UserSessionCache.java", "userSessionCache.get("+key+")==null");
        }
        try{
            userSessionCache.remove(key, "us");
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }

    }


    public UserSession getUserSession(String userSessionId){
        UserSession userSession = null;
        try{
            userSession = (UserSession) userSessionCache.get(fqn, "UserSession" + userSessionId);
            reger.core.Debug.debug(4, "UserSessionCache.java", "Found session in cache.");
            return userSession;
        } catch (CacheException ex){
            reger.core.Debug.debug(4, "UserSessionCache.java", "Session not found in cache.");
            return null;
        }
    }

    public UserSession getUserSessionUsingActualKeyOfCache(String key){
        UserSession userSession = null;
        try{
            userSession = (UserSession) userSessionCache.get(fqn, key);
            reger.core.Debug.debug(4, "UserSessionCache.java", "Found session in cache.");
            return userSession;
        } catch (CacheException ex){
            reger.core.Debug.debug(4, "UserSessionCache.java", "Session not found in cache.");
            return null;
        }
    }


    /**
     * Stores UserSession in database.  Clears old items and caches
     * new.
     */
    public void putUserSession(String userSessionId, UserSession userSession){
        try{
            userSessionCache.put(fqn, "UserSession" + userSessionId, userSession);
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }
    }

    public static String getCacheStatsAsHtml(){
        StringBuffer mb = new StringBuffer();
        if (userSessionCache!=null){
            try{
                HashSet hsh = (HashSet)userSessionCache.getKeys(fqn);
                mb.append(hsh.size() + " keys in UserSessionCache.");
            } catch (CacheException ex){
                return "";
            }
        }
        mb.append("<br>");
        mb.append("UserSessionCache singleton created " + created + " time(s).");
        mb.append("UserSessionCache checked out " + checkedOut + " time(s).");
        return mb.toString();
    }

    public static Set getKeys(){
        if (userSessionCache!=null){
            try{
                return userSessionCache.getKeys(fqn);
            } catch (CacheException ex){
                return new HashSet();
            }
        }
        return new HashSet();
    }


}
