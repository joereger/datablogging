package reger.cache.jcs;

import org.apache.jcs.JCS;
import org.apache.jcs.engine.CompositeCacheAttributes;
import reger.UserSession;

import java.util.Set;
import java.util.HashSet;

public class UserSessionCacheBackup {

    private static JCS userSessionCache;

    private static void setupCache(){
        try{
            //Cache properties
            CompositeCacheAttributes attr = new CompositeCacheAttributes();
            attr.setCacheName("UserSessionCache");
            attr.setMaxMemoryIdleTimeSeconds(1800);
            attr.setMaxObjects(10000);
            attr.setMaxSpoolPerRun(1000);
            attr.setMemoryCacheName("UserSessionCache");
            attr.setShrinkerIntervalSeconds(60);
            attr.setUseDisk(false);
            attr.setUseLateral(false);
            attr.setUseMemoryShrinker(true);
            attr.setUseRemote(false);
            //Create the cache
            userSessionCache = JCS.getInstance("UserSessionCache", attr);
            reger.core.Debug.debug(3, "UserSessionCache.java", "JCS UserSessionCache Set Up.");
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }
    }

    private static void verifyCacheSetup(){
        if (userSessionCache == null){
            synchronized (UserSessionCacheBackup.class){
                setupCache();
            }
        }
    }

    public static void flushUserSessions(){
        verifyCacheSetup();
        try{
            userSessionCache.clear();
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }

    }

    public static  void removeUserSession(String userSessionid){
        verifyCacheSetup();
        try{
            userSessionCache.remove("UserSession"+userSessionid, "us");
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }

    }

    public static void removeUserSessionByCacheKey(String key){
        verifyCacheSetup();
        reger.core.Debug.debug(4, "UserSessionCache.java", "removeUserSessionByCacheKey("+key+")");
        if(userSessionCache.get(key)!=null){
            reger.core.Debug.debug(4, "UserSessionCache.java", "userSessionCache.get("+key+")!=null");
        } else {
            reger.core.Debug.debug(4, "UserSessionCache.java", "userSessionCache.get("+key+")==null");
        }
        try{
            userSessionCache.remove(key, "us");
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }

    }


    public static UserSession getUserSession(String userSessionId){
        verifyCacheSetup();
        UserSession userSession = null;

        userSession = (UserSession) userSessionCache.getFromGroup("UserSession" + userSessionId, "us");

        if (userSession == null){
            reger.core.Debug.debug(4, "UserSessionCache.java", "Session not found in cache.");
        } else {
            reger.core.Debug.debug(4, "UserSessionCache.java", "Found session in cache.");
        }

        return  userSession;
    }

    public static UserSession getUserSessionUsingActualKeyOfCache(String key){
        verifyCacheSetup();
        UserSession userSession = null;

        userSession = (UserSession) userSessionCache.getFromGroup(key, "us");

        if (userSession == null){
            reger.core.Debug.debug(4, "UserSessionCache.java", "Session not found in cache.");
        } else {
            reger.core.Debug.debug(4, "UserSessionCache.java", "Found session in cache.");
        }

        return  userSession;
    }


    /**
     * Stores UserSession in database.  Clears old items and caches
     * new.
     */
    public static void putUserSession(String userSessionId, UserSession userSession){
        verifyCacheSetup();
        try{
            userSessionCache.putInGroup("UserSession" + userSessionId, "us", userSession);
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }
    }

    public static String getCacheStatsAsHtml(){
        verifyCacheSetup();
        StringBuffer mb = new StringBuffer();
        if (userSessionCache!=null){
            mb.append(userSessionCache.getStats());
        }
        return mb.toString();
    }

    public static Set getKeys(){
        verifyCacheSetup();
        if (userSessionCache!=null){
            return userSessionCache.getGroupKeys("us");
        }
        return new HashSet();
    }


}
