package reger.template;

import reger.Account;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

import java.util.Properties;

/**
 * Caches Account objects using OSCache
 */
public class SiteTemplateCacheTags {

    private static GeneralCacheAdministrator admin;

    private static TemplateTag[] tags;

    public static TemplateTag get(String syntax){
        //reger.core.Util.debug(4, "SiteTemplateTagCache.get("+syntax+") called.");
        if (admin==null){
            Properties props = new Properties();
            props.setProperty("cache.capacity", "50");
            admin = new GeneralCacheAdministrator();
        }

        try {
            //reger.core.Util.debug(3, "SiteTemplateTagCache.get("+syntax+") trying to return from cache.");
            return (TemplateTag) admin.getFromCache(syntax);
        } catch (NeedsRefreshException nre) {
            try {
                //reger.core.Util.debug(3, "SiteTemplateTagCache.get("+syntax+") refreshing object from database.");

                if (tags==null){
                    loadTags();
                }

                //Find a tag that fulfills the incoming syntax
                if (tags!=null){
                    for (int i = 0; i < tags.length; i++) {
                        if (tags[i]!=null){
                            if (tags[i].acceptsParticularSyntax(syntax)){
                                admin.putInCache(syntax, tags[i]);
                                return tags[i];
                            }
                        }
                    }
                }
                admin.cancelUpdate(syntax);
                return null;
            } catch (Exception ex) {
                admin.cancelUpdate(syntax);
                reger.core.Util.errorsave(ex);
                return null;
            }
        }
    }

    public static void loadTags(){
        //reger.core.Util.debug(3, "SiteTemplateTagCache.loadTags() refreshing tag list.");
        tags = new TemplateTag[0];
        synchronized(tags){
            SiteTemplateProcessor processor = new SiteTemplateProcessor();
            tags = processor.getTagsThisProcessorCanHandle();
        }
    }




}
