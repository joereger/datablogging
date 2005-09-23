package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

/**
 *
 */
public class SiteTemplateTagOnThisDay implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "On.This.Day";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A summary of those entries occurring on this day exactly one, two, three, etc years ago.";
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
        //On This Day
        if (userSession.getAccount().isPro()) {
            out.append(reger.OnThisDay.getHtml(userSession.getAccount().getAccountid(), userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid(), false), true, userSession.getAccount().getTimezoneid(), -1));
        }
        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "On this day.";
    }

}
