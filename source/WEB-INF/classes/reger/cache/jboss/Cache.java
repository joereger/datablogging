package reger.cache.jboss;

import org.jboss.cache.aop.TreeCacheAop;
import org.jboss.cache.PropertyConfigurator;
import reger.core.WebAppRootDir;

/**
 * The Main JBossCache implementor
 */
public class Cache {

    private static TreeCacheAop treeCacheAop;

    private Cache(){

    }
    
    private static void setupCache(){
        try{
            treeCacheAop = new TreeCacheAop();
            PropertyConfigurator config = new PropertyConfigurator();
            config.configure(treeCacheAop, WebAppRootDir.getWebAppRootPath()+"WEB-INF/jbosscache-replSync-service.xml");
            //treeCacheAop.setClusterName("RegerCom-TreeCache-Cluster");
            treeCacheAop.start();
            reger.core.Debug.debug(3, "Cache.java", "JBossCache UserSessionCache created.");
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "Cache.java", "Boomps.");
        }
    }

    public static TreeCacheAop getTreeCache(){
        if (treeCacheAop == null){
            synchronized (Cache.class){
                setupCache();
            }
        }
        return treeCacheAop;
    }

}
