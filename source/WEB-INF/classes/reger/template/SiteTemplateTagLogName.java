package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.Log;
import reger.cache.LogCache;

/**
 *
 */
public class SiteTemplateTagLogName implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Log.Name";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The name of the current log. Sample output: 'Running Log'. This will default to your site name if you're on the hompage or another generic page. Remember, the site name applies to the entire site, the log name applies only to a specific log.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     *
     * @param mb
     * @param sc
     * @param pageProps
     * @param userSession
     * @return
     */
    public String getValue(StringBuffer mb, StringBuffer sc, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {
        Log log = LogCache.get(pageProps.logProps.logid);
        if (log!=null){
            return log.getName();
        }
        return "";

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "My Log";
    }

}
