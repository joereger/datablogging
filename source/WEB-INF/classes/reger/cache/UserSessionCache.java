package reger.cache;

import reger.cache.providers.CacheFactory;
import reger.UserSession;


public class UserSessionCache {



    private static String GROUP = "usersession";

    public static UserSession get(String key){
        Object obj = CacheFactory.getCacheProvider().get(key, GROUP);
        if (obj!=null && (obj instanceof UserSession)){
            return (UserSession)obj;
        } else {
            return null;
        }
    }

    public static void put(String key, UserSession userSession){
        CacheFactory.getCacheProvider().put(key, GROUP, userSession);
    }

    public static void flush(){
        CacheFactory.getCacheProvider().flush(GROUP);
    }

    public static void flush(String key){
        CacheFactory.getCacheProvider().flush(key, GROUP);
    }






}
