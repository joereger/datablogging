package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

/**
 *
 */
public class SiteTemplateTagMostRecentList implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Titles.Most.Recent.Entries";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The titles of the 15 most recent log entries.";
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
        HpTemplateTagMostRecentList mr = new HpTemplateTagMostRecentList();
        return mr.getHtml(userSession, request, pageProps);
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "List of Most Recent Entries Here";
    }

}
