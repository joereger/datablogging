package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

/**
 *
 */
public class SiteTemplateTagSideColumn implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Side.Column";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The Side Column holds the log name and log-specific links. The best way to learn about it is to play around with it.";
    }

    public boolean isRequired(){
        return true;
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

            return sc.toString() + "&nbsp;";
    }


    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "This is the Side Column.";
    }

}
