package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.SideColumn;
import reger.core.db.Db;

/**
 *
 */
public class PlUserTemplateTagUserSite implements PlUserTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "User.Site";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The body of the user's site.";
    }

    public boolean isRequired(){
        return true;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.

     */
    public String getValue(StringBuffer mb, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {
        return mb.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "User Site Goes Here.";
    }

}
