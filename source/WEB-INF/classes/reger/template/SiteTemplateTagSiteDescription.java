package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.pageFramework.PageProps;

/**
 *
 */
public class SiteTemplateTagSiteDescription implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Site.Description";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Puts your site description onto the page.";
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

        String homepagehtml="";


        if (userSession.getAccount().getHomepagehtml()!=null && !userSession.getAccount().getHomepagehtml().equals("")) {
            homepagehtml=userSession.getAccount().getHomepagehtml();
        }

        return homepagehtml;        

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "This is the Site Description.";
    }

}
