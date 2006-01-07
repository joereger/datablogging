package reger.cache.jboss;

import reger.core.db.Db;

import java.util.Map;
import java.util.Iterator;

import org.jboss.cache.Fqn;

/**
 * Dumps a class to html
 */
public class CacheDumper {

//    public static String getHtml(String fqn){
//        try{
//            Map objs = reger.cache.jboss.Cache.getTreeCache().findObjects(fqn);
//            return dumpMap(objs, 0).toString();
//        } catch (Exception ex){
//            reger.core.Debug.errorsave(ex, "CacheDumper.java");
//            return "Error retrieving cache: " + ex.getMessage();
//        }
//    }
//
//
//    private static StringBuffer dumpMap(Map map, int nestinglevel){
//        StringBuffer out = new StringBuffer();
//        nestinglevel++;
//        Iterator it = map.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pairs = (Map.Entry)it.next();
//            Fqn fqn = (Fqn)pairs.getKey();
//            Object value = pairs.getValue();
//            reger.core.Debug.debug(3, "CacheDumper.java", "fqn="+fqn.toString()+"<br>value="+value.toString());
//
//            out.append("<br>");
//            for(int i=0; i<=nestinglevel; i++){
//                out.append("&nbsp;&nbsp;&nbsp;&nbsp;");
//            }
//            out.append(fqn.toString());
//            //out.append("["+value.toString()+"]");
//
//            try{
//                Map objs = reger.cache.jboss.Cache.getTreeCache().findObjects(fqn);
//                out.append(dumpMap(objs, nestinglevel));
//            } catch (org.jboss.cache.CacheException cex){
//                reger.core.Debug.debug(3, "CacheDumper.java", cex.getMessage());
//            }
//        }
//        return out;
//    }






}
