package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

/**
 *
 */
public class SiteTemplateTagNavbarVertical implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Navbar.Vertical";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Defines a Navigation Bar that allows you and your visitors to move around your site.";
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
        //return reger.navBars.generateNavbar(1, userSession.getAccountuser(), userSession.getAccount().getAccountid(), pageProps.logProps.logid, userSession.getAccount().getShowhometab(), userSession.getAccount().getHometabtext(), userSession.getAccount().getShowlogintab(), request.getRequestURI()).toString();
        reger.nestednav.NestedNavDisplayVertical vert = new reger.nestednav.NestedNavDisplayVertical();
        return vert.outputNavBarHtml(userSession.getAccount().getNestedNavCollection(), userSession, request);
    }



    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return reger.navBars.preview(1, null, -1, -1, true, "", true, "/index.log").toString();
    }

}
