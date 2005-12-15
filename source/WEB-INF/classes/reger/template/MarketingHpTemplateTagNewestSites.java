package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

import java.util.Calendar;

/**
 *
 */
public class MarketingHpTemplateTagNewestSites implements MarketingHpTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Newest.Sites";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Newest sites added to the private label.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getHtml(UserSession userSession, javax.servlet.http.HttpServletRequest request, PageProps pageProps){
        MarketingSiteTemplateTagNewestSites tag = new MarketingSiteTemplateTagNewestSites();
        return tag.getHtml(new StringBuffer(), pageProps, userSession, request);
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "No Preview Available.";
    }

}
