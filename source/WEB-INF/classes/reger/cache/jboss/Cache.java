package reger.cache.jboss;

import org.jboss.cache.aop.TreeCacheAop;
import org.jboss.cache.PropertyConfigurator;
import reger.core.WebAppRootDir;

/**
 * The Main JBossCache implementor
 *
 * Testing multicast on a network:
 * ==============================================
 * ON FIRST MACHINE:
 * 1) cd to /WEB-INF/lib/jgroups.jar
 * 2) java -cp jgroups.jar org.jgroups.tests.McastReceiverTest -mcast_addr 228.1.2.3 -port 41332
 * ON SECOND MACHINE:
 * 1) cd to /WEB-INF/lib/jgroups.jar
 * 2) java -cp jgroups.jar org.jgroups.tests.McastSenderTest -mcast_addr 228.1.2.3 -port 41332
 * NOW
 * Type in the second machine and you should see it echoed in the first box.  If not then you
 * don't have Multicast IP configured properly.
 *
 */
public class Cache {

//    private static TreeCacheAop treeCacheAop;
//
//    private Cache(){
//
//    }
//
//    private static void setupCache(){
//        try{
//            treeCacheAop = new TreeCacheAop();
//            PropertyConfigurator config = new PropertyConfigurator();
//            config.configure(treeCacheAop, WebAppRootDir.getWebAppRootPath()+"WEB-INF/jbosscache-replSync-service.xml");
//            //treeCacheAop.setClusterName("RegerCom-TreeCache-Cluster");
//            treeCacheAop.startService();
//            reger.core.Debug.debug(3, "Cache.java", "JBossCache UserSessionCache created.");
//        } catch (Exception e){
//            reger.core.Debug.errorsave(e, "Cache.java", "Boomps.");
//        }
//    }
//
//    public static TreeCacheAop getTreeCache(){
//        if (treeCacheAop == null){
//            synchronized (Cache.class){
//                setupCache();
//            }
//        }
//        return treeCacheAop;
//    }
   

}
