package reger.cache.providers.oscache;

import reger.cache.providers.CacheProvider;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.plugins.clustersupport.JavaGroupsBroadcastingListener;
import com.opensymphony.oscache.base.NeedsRefreshException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * OsCache cache implementation
 */
public class OsCacheClusteredProvider implements CacheProvider {

    private static GeneralCacheAdministrator admin;
    private static ArrayList<KeyGroupRelationship> groupKeyRelationships = new ArrayList<KeyGroupRelationship>();

    public OsCacheClusteredProvider(){

    }

    private static void setupCache(){
        OsCacheClusteredProvider.groupKeyRelationships = new ArrayList<KeyGroupRelationship>();
        OsCacheClusteredProvider.admin = new GeneralCacheAdministrator();
        JavaGroupsBroadcastingListener listener = new JavaGroupsBroadcastingListener();
        OsCacheClusteredProvider.admin.getCache().addCacheEventListener(listener, listener.getClass());
    }

    public String getProviderName(){
        return "OsCacheClusteredProvider";
    }

    public Object get(String key, String group) {
        if (OsCacheClusteredProvider.admin ==null){
            setupCache();
        }
        try {
            return OsCacheClusteredProvider.admin.getFromCache("/"+group+"/"+key);
        } catch (NeedsRefreshException nre) {
            admin.cancelUpdate("/"+group+"/"+key);
            return null;
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "OsCacheProvider.java");
        }
        return null;
    }

    public void put(String key, String group, Object obj) {
        if (OsCacheClusteredProvider.admin ==null){
            setupCache();
        }
        try{
            OsCacheClusteredProvider.groupKeyRelationships.add(new KeyGroupRelationship("/"+group+"/"+key, group));
            OsCacheClusteredProvider.admin.putInCache("/"+group+"/"+key, obj, new String[]{group});
        } catch (Exception ex){
            admin.cancelUpdate("/"+group+"/"+key);
            reger.core.Debug.errorsave(ex, "OsCacheProvider.java");
        }
    }

    public void flush() {
        if (OsCacheClusteredProvider.admin !=null){
            try{
                OsCacheClusteredProvider.admin.flushAll();
            } catch (Exception e){
                reger.core.Debug.errorsave(e, "OsCacheProvider.java");
            }
        }
    }

    public void flush(String group) {
        if (OsCacheClusteredProvider.admin !=null){
            try{
                OsCacheClusteredProvider.groupKeyRelationships = new ArrayList<KeyGroupRelationship>();
                OsCacheClusteredProvider.admin.flushGroup(group);
            } catch (Exception e){
                reger.core.Debug.errorsave(e, "OsCacheProvider.java");
            }
        }
    }

    public void flush(String key, String group) {
        if (OsCacheClusteredProvider.admin !=null){
            try{
                removeKeyFromKeyGroupMap("/"+group+"/"+key);
                OsCacheClusteredProvider.admin.flushEntry("/"+group+"/"+key);
            } catch (Exception e){
                reger.core.Debug.errorsave(e, "OsCacheProvider.java");
            }
        }
    }

    public String[] getKeys() {
        if (OsCacheClusteredProvider.admin !=null){
            ArrayList<String> outList = new ArrayList<String>();
            for (Iterator it = OsCacheClusteredProvider.groupKeyRelationships.iterator(); it.hasNext(); ) {
                KeyGroupRelationship kgr = (KeyGroupRelationship)it.next();
                outList.add(kgr.key);
            }
            String[] out = new String[outList.size()];
            int i = 0;
            for (Iterator it = outList.iterator(); it.hasNext(); ) {
                String key = (String)it.next();
                out[i]=key;
                i=i+1;
            }
            return out;
        }
        return new String[0];
    }

    public String[] getKeys(String group) {
        if (OsCacheClusteredProvider.admin !=null){
            ArrayList<String> outList = new ArrayList<String>();
            for (Iterator it = OsCacheClusteredProvider.groupKeyRelationships.iterator(); it.hasNext(); ) {
                KeyGroupRelationship kgr = (KeyGroupRelationship)it.next();
                if (kgr.group.equals(group)){
                    outList.add(kgr.key);
                }
            }
            String[] out = new String[outList.size()];
            int i = 0;
            for (Iterator it = outList.iterator(); it.hasNext(); ) {
                String key = (String)it.next();
                out[i]=key;
                i=i+1;
            }
            return out;
        }
        return new String[0];
    }

    public String getCacheStatsAsHtml() {
        StringBuffer mb = new StringBuffer();
        mb.append("OsCacheClusteredProvider<br>");
        String[] keys = getKeys();
        mb.append(keys.length + " keys in cache<br>");
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            mb.append("<br>"+key);
        }
        return mb.toString();
    }

    private void removeKeyFromKeyGroupMap(String key){
        ArrayList<String> outList = new ArrayList<String>();
        for (Iterator it = OsCacheClusteredProvider.groupKeyRelationships.iterator(); it.hasNext(); ) {
            KeyGroupRelationship kgr = (KeyGroupRelationship)it.next();
            if (kgr.key.equals(key)){
                it.remove();
            }
        }
    }


}
