package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.Entry;
import reger.core.Debug;

/**
 *
 */
public class SiteTemplateTagEntryTitle implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Entry.Title";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "If a single entry is being displayed, this shows the entry title. Otherwise it displays nothing. This is frequently used in the Title tag of a page to make the entry title available for search engines.";
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
        Debug.debug(5, "", "SiteTemplateTagEntryTitle.java -<br>pageProps.entry.eventid="+pageProps.entry.eventid+"<br>request.getParameter(\"eventid\")="+request.getParameter("eventid"));
        if (pageProps.entry.eventid>0){
            if (pageProps.entry.title.equals("")){
                Debug.debug(5, "", "SiteTemplateTagEntryTitle.java - returning page title from pageProps.entry.title.");
                return reger.core.Util.cleanForHtml(Entry.entryTitleFromEventid(pageProps.entry.eventid));
            } else {
                Debug.debug(5, "", "SiteTemplateTagEntryTitle.java - returning \""+pageProps.entry.title+"\" from pageProps.entry.title.");
                return pageProps.entry.title;
            }
        }
        Debug.debug(5, "", "SiteTemplateTagEntryTitle.java - returning blank page title.");
        return "";
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "This is a log entry.";
    }

}
