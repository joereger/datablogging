package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.Entry;
import reger.core.Debug;

/**
 *
 */
public class SiteTemplateTagWapLink implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Wap.Link";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A link to the wireless access protocol (WAP) version of your site.  Readers can access your site via cell phone.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     *
     */
    public String getValue(StringBuffer mb, StringBuffer sc, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {
        StringBuffer out = new StringBuffer();
        //WAP Link
        out.append("<br>");
        out.append("<!-- WAP Start --><a href='/mobile/home.log'><img src='images/wap-access.png' alt='View this site using a WAP device.' border=0></a><!-- WAP End --><br>");
        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "WAP";
    }

}
