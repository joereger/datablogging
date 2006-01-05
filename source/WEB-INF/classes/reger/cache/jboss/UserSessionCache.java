package reger.cache.jboss;

import reger.UserSession;
import reger.core.WebAppRootDir;

import java.util.Set;
import java.util.HashSet;

import org.jboss.cache.TreeCache;
import org.jboss.cache.PropertyConfigurator;
import org.jboss.cache.CacheException;
import org.jboss.cache.aop.TreeCacheAop;

public class UserSessionCache {

//    private static UserSessionCache instance;
//    private static int checkedOut = 0;
//    private static int created = 0;
//    private static TreeCacheAop userSessionCache;
    private static String fqn = "/usersession";

    private UserSessionCache(){
//        try{
//            created++;
//            userSessionCache = new TreeCacheAop();
//            PropertyConfigurator config = new PropertyConfigurator();
//            config.configure(userSessionCache, WebAppRootDir.getWebAppRootPath()+"WEB-INF/jbosscache-replSync-service.xml");
//            //userSessionCache.setClusterName("RegerCom-TreeCache-Cluster");
//            userSessionCache.start();
//            reger.core.Debug.debug(3, "UserSessionCache.java", "JBossCache UserSessionCache created.");
//        } catch (Exception e){
//            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
//        }
    }


//    public static UserSessionCache getInstance(){
//        synchronized (UserSessionCache.class){
//            if (instance == null){
//                instance = new UserSessionCache();
//            }
//        }
//
//        synchronized (instance){
//            instance.checkedOut++;
//        }
//
//        return instance;
//    }


    public static void flushUserSessions(){
        try{
            Cache.getTreeCache().remove(fqn);
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }

    }

    public static void removeUserSession(String userSessionid){
        try{
            Cache.getTreeCache().remove(fqn, "UserSession"+userSessionid);
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }

    }

    public static void removeUserSessionByCacheKey(String key){
        reger.core.Debug.debug(4, "UserSessionCache.java", "removeUserSessionByCacheKey("+key+")");
        try{
            if(Cache.getTreeCache().get(fqn, key)!=null){
                reger.core.Debug.debug(4, "UserSessionCache.java", "userSessionCache.get("+key+")!=null");
            } else {
                reger.core.Debug.debug(4, "UserSessionCache.java", "userSessionCache.get("+key+")==null");
            }
        } catch (CacheException ex){
            reger.core.Debug.debug(4, "UserSessionCache.java", "userSessionCache.get("+key+")==null");
        }
        try{
            Cache.getTreeCache().remove(key, "us");
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }

    }


    public static UserSession getUserSession(String userSessionId){
        UserSession userSession = null;
        try{
            userSession = (UserSession) Cache.getTreeCache().get(fqn, "UserSession" + userSessionId);
            reger.core.Debug.debug(4, "UserSessionCache.java", "Found session in cache.");
            return userSession;
        } catch (CacheException ex){
            reger.core.Debug.debug(4, "UserSessionCache.java", "Session not found in cache.");
            return null;
        }
    }

    public static UserSession getUserSessionUsingActualKeyOfCache(String key){
        UserSession userSession = null;
        try{
            userSession = (UserSession) Cache.getTreeCache().get(fqn, key);
            reger.core.Debug.debug(4, "UserSessionCache.java", "Found session in cache.");
            return userSession;
        } catch (CacheException ex){
            reger.core.Debug.debug(4, "UserSessionCache.java", "Session not found in cache.");
            return null;
        }
    }



    public static void putUserSession(String userSessionId, UserSession userSession){
        try{
            Cache.getTreeCache().put(fqn, "UserSession" + userSessionId, userSession);
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }
    }

    public static String getCacheStatsAsHtml(){
        StringBuffer mb = new StringBuffer();
        if (Cache.getTreeCache()!=null){
            try{
                HashSet hsh = (HashSet)Cache.getTreeCache().getKeys(fqn);
                mb.append(hsh.size() + " keys in UserSessionCache.");
            } catch (CacheException ex){
                return "";
            }
        }
        return mb.toString();
    }

    public static Set getKeys(){
        if (Cache.getTreeCache()!=null){
            try{
                return Cache.getTreeCache().getKeys(fqn);
            } catch (CacheException ex){
                return new HashSet();
            }
        }
        return new HashSet();
    }


}
