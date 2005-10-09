package reger.cache.jcs;

import org.apache.jcs.JCS;
import org.apache.jcs.engine.behavior.ICompositeCacheAttributes;
import org.apache.jcs.engine.CompositeCacheAttributes;
import reger.UserSession;

import java.util.Set;
import java.util.HashSet;

public class UserSessionCache {

    private static UserSessionCache instance;
    private static int checkedOut = 0;
    private static JCS userSessionCache;

    private UserSessionCache(){
        try{
            //Cache properties
            CompositeCacheAttributes attr = new CompositeCacheAttributes();
            attr.setCacheName("userSessionCache");
            attr.setMaxMemoryIdleTimeSeconds(1800);
            attr.setMaxObjects(10000);
            attr.setMaxSpoolPerRun(1000);
            attr.setMemoryCacheName("userSessionCache");
            attr.setShrinkerIntervalSeconds(60);
            attr.setUseDisk(false);
            attr.setUseLateral(false);
            attr.setUseMemoryShrinker(true);
            attr.setUseRemote(false);
            //Create the cache
            userSessionCache = JCS.getInstance("userSessionCache", attr);
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
            userSessionCache.clear();
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }

    }

    public void removeUserSession(String userSessionid){
        try{
            userSessionCache.remove("UserSession"+userSessionid, "us");
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }

    }

    public void removeUserSessionByCacheKey(String key){
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


    public UserSession getUserSession(String userSessionId){
        UserSession userSession = null;

        userSession = (UserSession) userSessionCache.getFromGroup("UserSession" + userSessionId, "us");

        if (userSession == null){
            reger.core.Debug.debug(4, "UserSessionCache.java", "Session not found in cache.");
        } else {
            reger.core.Debug.debug(4, "UserSessionCache.java", "Found session in cache.");
        }

        return  userSession;
    }

    public UserSession getUserSessionUsingActualKeyOfCache(String key){
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
    public void putUserSession(String userSessionId, UserSession userSession){
        try{
            userSessionCache.putInGroup("UserSession" + userSessionId, "us", userSession);
        }catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSessionCache.java", "Possible cause: Make sure all objects and sub-objects of UserSession are serializable.");
        }
    }

    public static String getCacheStatsAsHtml(){
        StringBuffer mb = new StringBuffer();
        if (userSessionCache!=null){
            mb.append(userSessionCache.getStats());


        }
        return mb.toString();
    }

    public static Set getKeys(){
        if (userSessionCache!=null){
            return userSessionCache.getGroupKeys("us");
        }
        return new HashSet();
    }


}
