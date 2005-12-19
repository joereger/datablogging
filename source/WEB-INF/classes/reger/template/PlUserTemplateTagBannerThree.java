package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.SideColumn;
import reger.core.db.Db;

/**
 *
 */
public class PlUserTemplateTagBannerThree implements PlUserTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Banner.Three";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The third of three optional banners that you can include on your private label site.  Define these banner includes on your Settings tab.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.

     */
    public String getValue(StringBuffer mb, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {
        if (!userSession.getAccount().isPro() || (userSession.getAccount().isPro() && userSession.getPl().getShowbannertagsonpro()) ){
            return userSession.getPl().getBannerthree();
        } else {
            return "";
        }
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "Banner Three Here.";
    }

}
