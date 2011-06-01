package reger.cache.providers.jboss;

import reger.cache.providers.CacheProvider;
import reger.core.WebAppRootDir;
import org.jboss.cache.aop.TreeCacheAop;
import org.jboss.cache.PropertyConfigurator;
import org.jboss.cache.CacheException;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Implementation of the jbosscache
 */
public class JbossTreeCacheAOPProvider implements CacheProvider {

    private static TreeCacheAop treeCacheAop;

    public JbossTreeCacheAOPProvider(){

    }

    public String getProviderName(){
        return "JbossTreeCacheAOPProvider";
    }

    private static void setupCache(){
//        try{
//            treeCacheAop = new TreeCacheAop();
//            PropertyConfigurator config = new PropertyConfigurator();
//            //config.configure(treeCacheAop, WebAppRootDir.getWebAppRootPath()+"WEB-INF"+java.io.File.separator+"jbosscache-replSync-service.xml");
//            config.configure(treeCacheAop, WebAppRootDir.getWebAppRootPath()+"WEB-INF"+java.io.File.separator+"jbosscache-replSync-service.xml");
//            //treeCacheAop.setClusterName("RegerCom-TreeCache-Cluster");
//            treeCacheAop.startService();
//            reger.core.Debug.debug(5, "Cache.java", "JBossCache UserSessionCache created.");
//        } catch (Exception e){
//            reger.core.Debug.errorsave(e, "Cache.java", "Boomps.");
//        }
    }

    public static TreeCacheAop getTreeCache(){
        if (treeCacheAop == null){
            synchronized (JbossTreeCacheAOPProvider.class){
                setupCache();
            }
        }
        return treeCacheAop;
    }

    public Object get(String key, String group) {
//        try{
//            return JbossTreeCacheAOPProvider.getTreeCache().getObject("/"+group+"/"+key);
//        } catch (CacheException ex){
//            reger.core.Debug.debug(4, "JbossTreeCacheAOPProvider.java", "Object not found in cache. key="+key);
//            return null;
//        }
        return new String();
    }

    public void put(String key, String group, Object obj) {
//        try{
//            JbossTreeCacheAOPProvider.getTreeCache().putObject("/"+group+"/"+key, obj);
//        }catch (Exception e){
//            reger.core.Debug.errorsave(e, "JbossTreeCacheAOPProvider.java");
//        }
    }

    public void flush() {
//        try{
//            JbossTreeCacheAOPProvider.getTreeCache().removeObject("/");
//        }catch (Exception e){
//            reger.core.Debug.errorsave(e, "JbossTreeCacheAOPProvider.java");
//        }
    }

    public void flush(String group) {
//        try{
//            JbossTreeCacheAOPProvider.getTreeCache().removeObject("/"+group);
//        }catch (Exception e){
//            reger.core.Debug.errorsave(e, "JbossTreeCacheAOPProvider.java");
//        }
    }

    public void flush(String key, String group) {
//        try{
//            JbossTreeCacheAOPProvider.getTreeCache().removeObject("/"+group+"/"+key);
//        }catch (Exception e){
//            reger.core.Debug.errorsave(e, "JbossTreeCacheAOPProvider.java");
//        }
    }

    public String[] getKeys(){
//        if (JbossTreeCacheAOPProvider.getTreeCache()!=null){
//            try{
//                HashSet hm = (HashSet)JbossTreeCacheAOPProvider.getTreeCache().getKeys("/");
//                String[] out = new String[hm.size()];
//                int i = 0;
//                for (Iterator iterator = hm.iterator(); iterator.hasNext();) {
//                    String s = (String) iterator.next();
//                    out[i] = s;
//                    i=i+1;
//                }
//                return out;
//            } catch (CacheException ex){
//                return new String[0];
//            }
//        }
        return new String[0];
    }

    public String[] getKeys(String group){
//        if (JbossTreeCacheAOPProvider.getTreeCache()!=null){
//            try{
//                HashSet hm = (HashSet)JbossTreeCacheAOPProvider.getTreeCache().getKeys("/"+group);
//                String[] out = new String[hm.size()];
//                int i = 0;
//                for (Iterator iterator = hm.iterator(); iterator.hasNext();) {
//                    String s = (String) iterator.next();
//                    out[i] = s;
//                    i=i+1;
//                }
//                return out;
//            } catch (CacheException ex){
//                return new String[0];
//            }
//        }
        return new String[0];
    }

    public String getCacheStatsAsHtml() {
        StringBuffer mb = new StringBuffer();
        mb.append("JbossCacheAOPProvider<br>");
        mb.append(reger.cache.providers.jboss.CacheDumper.getHtml("/", 1));
        return mb.toString();
    }
}
