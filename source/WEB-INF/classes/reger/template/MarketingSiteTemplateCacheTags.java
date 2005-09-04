package reger.template;

import reger.core.Debug;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

import java.util.Properties;

/**
 * Caches Account objects using OSCache
 */
public class MarketingSiteTemplateCacheTags {

    private static GeneralCacheAdministrator admin;

    private static TemplateTag[] tags;

    public static TemplateTag get(String syntax){
        Debug.debug(5, "", "MarketingSiteTemplateTagCache.get("+syntax+") called.");
        if (admin==null){
            Properties props = new Properties();
            props.setProperty("cache.algorithm", "com.opensymphony.oscache.base.algorithm.LRUCache");
            props.setProperty("cache.capacity", "50");
            admin = new GeneralCacheAdministrator();
        }

        try {
            Debug.debug(5, "", "MarketingSiteTemplateTagCache.get("+syntax+") trying to return from cache.");
            return (TemplateTag) admin.getFromCache(syntax);
        } catch (NeedsRefreshException nre) {
            try {
                Debug.debug(5, "", "MarketingSiteTemplateTagCache.get("+syntax+") refreshing object from database.");

                if (tags==null){
                    loadTags();
                }

                //Find a tag that fulfills the incoming syntax
                if (tags!=null){
                    for (int i = 0; i < tags.length; i++) {
                        if (tags[i]!=null){
                            if (tags[i].acceptsParticularSyntax(syntax)){
                                Debug.debug(5, "", "MarketingSiteTemplateTagCache.get("+syntax+") putting tag into cache, returning tag.");
                                admin.putInCache(syntax, tags[i]);
                                return tags[i];
                            }
                        }
                    }
                }
                Debug.debug(5, "", "MarketingSiteTemplateTagCache.get("+syntax+") returning null.");
                admin.cancelUpdate(syntax);
                return null;
            } catch (Exception ex) {
                admin.cancelUpdate(syntax);
                Debug.errorsave(ex, "");
                return null;
            }
        }
    }

    public static void loadTags(){
        Debug.debug(5, "", "MarketingSiteTemplateTagCache.loadTags() refreshing tag list.");
        tags = new TemplateTag[0];
        synchronized(tags){
            MarketingSiteTemplateProcessor processor = new MarketingSiteTemplateProcessor();
            tags = processor.getTagsThisProcessorCanHandle();
        }
    }




}
