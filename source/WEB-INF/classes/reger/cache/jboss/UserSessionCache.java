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

//    private static String fqn = "/usersession";
//
//    private UserSessionCache(){
//
//    }
//
//
//
//
//
//    public static void flushUserSessions(){
//        try{
//            Cache.getTreeCache().removeObject(fqn);
//        }catch (Exception e){
//            reger.core.Debug.errorsave(e, "UserSessionCache.java");
//        }
//
//    }
//
//    public static void removeUserSession(String userSessionid){
//        try{
//            Cache.getTreeCache().removeObject(fqn+"/UserSession"+userSessionid);
//        }catch (Exception e){
//            reger.core.Debug.errorsave(e, "UserSessionCache.java");
//        }
//
//    }
//
//    public static void removeUserSessionByCacheKey(String key){
//        reger.core.Debug.debug(4, "UserSessionCache.java", "removeUserSessionByCacheKey("+key+")");
//        try{
//            if(Cache.getTreeCache().getObject(fqn+key)!=null){
//                reger.core.Debug.debug(4, "UserSessionCache.java", "userSessionCache.get("+key+")!=null");
//            } else {
//                reger.core.Debug.debug(4, "UserSessionCache.java", "userSessionCache.get("+key+")==null");
//            }
//        } catch (CacheException ex){
//            reger.core.Debug.debug(4, "UserSessionCache.java", "userSessionCache.get("+key+")==null");
//        }
//        try{
//            Cache.getTreeCache().removeObject(fqn+key);
//        }catch (Exception e){
//            reger.core.Debug.errorsave(e, "UserSessionCache.java");
//        }
//
//    }
//
//
//    public static UserSession getUserSession(String userSessionId){
//        UserSession userSession = null;
//        try{
//            userSession = (UserSession) Cache.getTreeCache().getObject(fqn+"/UserSession" + userSessionId);
//            reger.core.Debug.debug(4, "UserSessionCache.java", "Found session in cache.");
//            return userSession;
//        } catch (CacheException ex){
//            reger.core.Debug.debug(4, "UserSessionCache.java", "Session not found in cache.");
//            return null;
//        }
//    }
//
//    public static UserSession getUserSessionUsingActualKeyOfCache(String key){
//        UserSession userSession = null;
//        try{
//            userSession = (UserSession) Cache.getTreeCache().getObject(fqn+key);
//            reger.core.Debug.debug(4, "UserSessionCache.java", "Found session in cache.");
//            return userSession;
//        } catch (CacheException ex){
//            reger.core.Debug.debug(4, "UserSessionCache.java", "Session not found in cache.");
//            return null;
//        }
//    }
//
//
//
//    public static void putUserSession(String userSessionId, UserSession userSession){
//        try{
//            Cache.getTreeCache().putObject(fqn+"/UserSession" + userSessionId, userSession);
//        }catch (Exception e){
//            reger.core.Debug.errorsave(e, "UserSessionCache.java");
//        }
//    }
//
//    public static String getCacheStatsAsHtml(){
//        StringBuffer mb = new StringBuffer();
//        if (Cache.getTreeCache()!=null){
//            try{
//                HashSet hsh = (HashSet)Cache.getTreeCache().getKeys(fqn);
//                mb.append(hsh.size() + " keys in UserSessionCache.");
//            } catch (CacheException ex){
//                return "";
//            }
//        }
//        return mb.toString();
//    }
//
//    public static Set getKeys(){
//        if (Cache.getTreeCache()!=null){
//            try{
//                return Cache.getTreeCache().getKeys(fqn);
//            } catch (CacheException ex){
//                return new HashSet();
//            }
//        }
//        return new HashSet();
//    }


}
