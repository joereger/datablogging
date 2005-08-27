package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

import java.util.Calendar;

/**
 *
 */
public class MarketingHpTemplateTagVersionNumber implements MarketingHpTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "VersionNumber";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Displays the version number of the software currently running.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     * @return
     */
    public String getHtml(UserSession userSession, javax.servlet.http.HttpServletRequest request, PageProps pageProps){

        StringBuffer mb = new StringBuffer();

        mb.append("Version " + reger.versioninfo.VersionInfo.getCURRENTVERSIONNAME());

        return mb.toString();

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "Version " + reger.versioninfo.VersionInfo.getCURRENTVERSIONNAME();
    }

}
