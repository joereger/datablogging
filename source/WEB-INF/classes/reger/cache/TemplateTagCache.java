package reger.cache;

import reger.Account;
import reger.template.TemplateTag;
import reger.cache.providers.CacheFactory;

/**
 * Caches Template tags
 */
public class TemplateTagCache {

    private static String GROUP = "templatetag";

    public static TemplateTag get(String syntax, String subgroup, TemplateTag[] possibletags){
        reger.core.Debug.debug(5, "TemplateTagCache.java", "In get("+syntax.replaceAll("<", "&lt;")+")");
        if (syntax!=null && !syntax.equals("")){
            reger.core.Debug.debug(5, "TemplateTagCache.java", "syntax is not null");
            String key = GROUP+"-"+subgroup+"-"+syntax;
            reger.core.Debug.debug(5, "TemplateTagCache.java", "key="+key.replaceAll("<", "&lt;"));
            Object obj = CacheFactory.getCacheProvider().get(key, TemplateTagCache.GROUP);
            reger.core.Debug.debug(5, "TemplateTagCache.java", "after the cache call");
            if (obj!=null && (obj instanceof TemplateTag)){
                reger.core.Debug.debug(5, "TemplateTagCache.java", "Returning from cache.");
                return (TemplateTag)obj;
            } else {
                //Look for tag that fits this syntax
                if (possibletags!=null){
                    for (int i = 0; i < possibletags.length; i++) {
                        if (possibletags[i]!=null){
                            if (possibletags[i].acceptsParticularSyntax(syntax)){
                                CacheFactory.getCacheProvider().put(key, TemplateTagCache.GROUP, possibletags[i]);
                                reger.core.Debug.debug(5, "TemplateTagCache.java", "Returning after adding to cache.");
                                return possibletags[i];
                            }
                        }
                    }
                }
            }
        }
        reger.core.Debug.debug(5, "TemplateTagCache.java", "Returning null.");
        return null;
    }

    public static void put(String syntax, String subgroup, TemplateTag tag){
        if (syntax!=null && !syntax.equals("") && tag!=null){
            String key = GROUP+"-"+subgroup+"-"+syntax;
            CacheFactory.getCacheProvider().put(key, TemplateTagCache.GROUP, tag);
        }
    }

    public static void flush(){
        CacheFactory.getCacheProvider().flush(TemplateTagCache.GROUP);
    }

 


}
