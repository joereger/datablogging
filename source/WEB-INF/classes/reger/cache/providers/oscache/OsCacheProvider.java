package reger.cache.providers.oscache;

import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.plugins.clustersupport.JavaGroupsBroadcastingListener;
import reger.cache.providers.CacheProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;


/**
 * OsCache cache implementation
 */
public class OsCacheProvider implements CacheProvider {

    private static GeneralCacheAdministrator admin;
    private static ArrayList<KeyGroupRelationship> groupKeyRelationships = new ArrayList<KeyGroupRelationship>();

    public OsCacheProvider(){

    }

    private static void setupCache(){
        //Initialize the groupKeyRelationships
        groupKeyRelationships = new ArrayList<KeyGroupRelationship>();
        //Load props file
        File internalFile = new File(reger.core.WebAppRootDir.getWebAppRootPath() + "/WEB-INF/classes/oscache.properties");
        if (internalFile!=null && internalFile.exists() && internalFile.canRead() && internalFile.isFile()){
            Properties properties = new Properties();
            try{
                properties.load(new FileInputStream(internalFile));
                admin = new GeneralCacheAdministrator(properties);
            } catch (Exception e){
                reger.core.Debug.errorsave(e, "OsCacheProvider.java");
                admin = new GeneralCacheAdministrator();
            }
        } else {
            reger.core.Debug.debug(5, "OsCacheProvider.java", "Couldn't find oscache proerties file:<br>"+internalFile.getAbsolutePath());
            admin = new GeneralCacheAdministrator();
        }
        //Manually set some properties
        //admin.setCacheCapacity(4999);
    }

    public String getProviderName(){
        return "OsCacheProvider";
    }

    public Object get(String key, String group) {
        if (admin==null){
            setupCache();
        }
        try {
            return admin.getFromCache("/"+group+"/"+key);
        } catch (NeedsRefreshException nre) {
            admin.cancelUpdate("/"+group+"/"+key);
            return null;
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "OsCacheProvider.java");
        }
        return null;
    }

    public void put(String key, String group, Object obj) {
        if (admin==null){
            setupCache();
        }
        try{
            groupKeyRelationships.add(new KeyGroupRelationship("/"+group+"/"+key, group));
            admin.putInCache("/"+group+"/"+key, obj, new String[]{group});
        } catch (Exception ex){
            admin.cancelUpdate("/"+group+"/"+key);
            reger.core.Debug.errorsave(ex, "OsCacheProvider.java");
        }
    }

    public void flush() {
        if (admin!=null){
            try{
                admin.flushAll();
            } catch (Exception e){
                reger.core.Debug.errorsave(e, "OsCacheProvider.java");
            }
        }
    }

    public void flush(String group) {
        if (admin!=null){
            try{
                groupKeyRelationships = new ArrayList<KeyGroupRelationship>();
                admin.flushGroup(group);
            } catch (Exception e){
                reger.core.Debug.errorsave(e, "OsCacheProvider.java");
            }
        }
    }

    public void flush(String key, String group) {
        if (admin!=null){
            try{
                removeKeyFromKeyGroupMap("/"+group+"/"+key);
                admin.flushEntry("/"+group+"/"+key);
            } catch (Exception e){
                reger.core.Debug.errorsave(e, "OsCacheProvider.java");
            }
        }
    }

    public String[] getKeys() {
        if (admin!=null){
            ArrayList<String> outList = new ArrayList<String>();
            for (Iterator it = groupKeyRelationships.iterator(); it.hasNext(); ) {
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
        if (admin!=null){
            ArrayList<String> outList = new ArrayList<String>();
            for (Iterator it = groupKeyRelationships.iterator(); it.hasNext(); ) {
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
        mb.append("OsCacheProvider<br>");
        if (admin!=null){
            mb.append("cache.capacity: "+admin.getProperty("cache.capacity")+"<br>");
            String[] keys = getKeys();
            mb.append(keys.length + " keys in cache<br>");
            for (int i = 0; i < keys.length; i++) {
                String key = keys[i];
                mb.append("<br>"+key);
            }
        } else {
            mb.append("Cache is null.");
        }
        return mb.toString();
    }

    private void removeKeyFromKeyGroupMap(String key){
        ArrayList<String> outList = new ArrayList<String>();
        for (Iterator it = groupKeyRelationships.iterator(); it.hasNext(); ) {
            KeyGroupRelationship kgr = (KeyGroupRelationship)it.next();
            if (kgr.key.equals(key)){
                it.remove();
            }
        }
    }


}
