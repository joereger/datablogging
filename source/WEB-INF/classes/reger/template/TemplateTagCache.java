package reger.template;

import reger.Account;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

import java.util.Properties;

/**
 * Caches Account objects using OSCache
 */
public class TemplateTagCache {

//    private static GeneralCacheAdministrator admin;
//
//    private static TemplateTag[] tags;
//
//    public static TemplateTag get(String syntax){
//        //reger.core.Util.debug(4, "TemplateTagCache.get("+syntax+") called.");
//        if (admin==null){
//            Properties props = new Properties();
//            props.setProperty("cache.capacity", "100");
//            admin = new GeneralCacheAdministrator();
//        }
//
//        try {
//            reger.core.Util.debug(3, "TemplateTagCache.get("+syntax+") trying to return from cache.");
//            return (TemplateTag) admin.getFromCache(syntax);
//        } catch (NeedsRefreshException nre) {
//            try {
//                reger.core.Util.debug(3, "TemplateTagCache.get("+syntax+") refreshing object from database.");
//
//                if (tags==null){
//                    loadTags();
//                }
//
//                //Find a tag that fulfills the incoming syntax
//                if (tags!=null){
//                    for (int i = 0; i < tags.length; i++) {
//                        if (tags[i]!=null){
//                            if (tags[i].acceptsParticularSyntax(syntax)){
//                                admin.putInCache(syntax, tags[i]);
//                                return tags[i];
//                            }
//                        }
//                    }
//                }
//                return null;
//            } catch (Exception ex) {
//                admin.cancelUpdate(syntax);
//                reger.core.Util.errorsave(ex);
//                return null;
//            }
//        }
//    }
//
//    public static void loadTags(){
//        reger.core.Util.debug(3, "TemplateTagCache.loadTags() refreshing tag list.");
//        tags = new TemplateTag[0];
//        //synchronized(tags){
//            tags = new TemplateTag[0];
//
//            //Add Tags
//            EntryListTemplateProcessor eltp = new EntryListTemplateProcessor();
//            TemplateTag[] entryListTemplateTags = eltp.getTagsThisProcessorCanHandle();
//            for (int i = 0; i < entryListTemplateTags.length; i++) {
//                TemplateTag tag = entryListTemplateTags[i];
//                tags = reger.AddToArray.addToTemplateTagArray(tags, tag);
//            }
//
//            //Add Tags
//            HpTemplateProcessor hptp = new HpTemplateProcessor();
//            TemplateTag[] hpTt = hptp.getTagsThisProcessorCanHandle();
//            for (int i = 0; i < hpTt.length; i++) {
//                TemplateTag tag = hpTt[i];
//                tags = reger.AddToArray.addToTemplateTagArray(tags, tag);
//            }
//
//            //Add Tags
//            MarketingHpTemplateProcessor mtpt = new MarketingHpTemplateProcessor();
//            TemplateTag[] marketingTags = mtpt.getTagsThisProcessorCanHandle();
//            for (int i = 0; i < marketingTags.length; i++) {
//                TemplateTag tag = marketingTags[i];
//                tags = reger.AddToArray.addToTemplateTagArray(tags, tag);
//            }
//
//            //Add Tags
//            MarketingSiteTemplateProcessor mstt = new MarketingSiteTemplateProcessor();
//            TemplateTag[] marketingSiteTags = mstt.getTagsThisProcessorCanHandle();
//            for (int i = 0; i < marketingSiteTags.length; i++) {
//                TemplateTag tag = marketingSiteTags[i];
//                tags = reger.AddToArray.addToTemplateTagArray(tags, tag);
//            }
//
//            //Add Tags
//            SiteTemplateProcessor stp = new SiteTemplateProcessor();
//            TemplateTag[] siteTags = stp.getTagsThisProcessorCanHandle();
//            for (int i = 0; i < siteTags.length; i++) {
//                TemplateTag tag = siteTags[i];
//                tags = reger.AddToArray.addToTemplateTagArray(tags, tag);
//            }
//
//        //}
//    }
//



}
