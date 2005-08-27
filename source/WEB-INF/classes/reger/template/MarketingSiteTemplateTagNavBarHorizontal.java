package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.pageFramework.PageProps;

import java.util.Calendar;

/**
 *
 */
public class MarketingSiteTemplateTagNavBarHorizontal implements MarketingSiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "NavBar.Horizontal";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Navbar for the marketing section that gives users access to the various sections, tours and signup pages.";
    }

    public boolean isRequired(){
        return true;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     * @return
     */
    public String getHtml(StringBuffer mb, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request){

        return reger.navbarMarketing.htmlOut(pageProps.marketingSiteSection, userSession.getPl(), pageProps).toString();

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "No preview available.";
    }

}
