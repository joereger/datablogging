package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.Entry;
import reger.core.Debug;

/**
 *
 */
public class SiteTemplateTagRssXmlLink implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Rss.Link";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "An icon linking to RSS/XML feeds.";
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
     */
    public String getValue(StringBuffer mb, StringBuffer sc, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {
        StringBuffer out = new StringBuffer();
        //XML Link
        out.append("<!-- XML Start --><a href='rssfeeds.log'><img src='images/xml-newsfeed.png' alt='View this site in XML' border=0></a><!-- XML End -->");
        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "RSS/XML";
    }

}
