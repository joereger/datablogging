package reger.template;

import reger.UserSession;
import reger.nestednav.NestedNavDisplayLogsAndPages;
import reger.pageFramework.PageProps;

/**
 *
 */
public class SiteTemplateTagNavLogsAndPages implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Nav.Logs.And.Pages";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A navbar dropdown button listing logs and pages on the site.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getValue(StringBuffer mb, StringBuffer sc, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {
        StringBuffer out = new StringBuffer();


        NestedNavDisplayLogsAndPages navMgrDisplay = new NestedNavDisplayLogsAndPages();
        out.append(navMgrDisplay.outputNavBarHtml(userSession.getAccount().getNestedNavCollection(), userSession, request));



        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return ".";
    }

}
