package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

/**
 *
 */
public class SiteTemplateTagMostRead7Days implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Titles.Most.Read.Entries.7.Days";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The titles of the most read entries over the last 7 days.";
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
        HpTemplateTagMostRead7Days mr = new HpTemplateTagMostRead7Days();
        return mr.getHtml(userSession, request, pageProps);
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "List of Most Read Entries in Last 7 Days Here";
    }

}
