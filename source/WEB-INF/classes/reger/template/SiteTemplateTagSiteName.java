package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.pageFramework.PageProps;

/**
 *
 */
public class SiteTemplateTagSiteName implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Site.Name";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Puts the name of your site on the page. Most people use this at the top of their page and in the &lt;Title>&lt;/Title> tag.";
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
        String homepagetitle="My Site";

        if (userSession.getAccount().getHomepagetitle()!=null && !userSession.getAccount().getHomepagetitle().equals("")) {
            homepagetitle=userSession.getAccount().getHomepagetitle();
        }

        return homepagetitle;        

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "Site Name";
    }

}
