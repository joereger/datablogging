package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.pageFramework.PageProps;

import java.util.Calendar;

/**
 *
 */
public class HpTemplateTagListOfEntries implements HpTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Entry.List";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A traditional weblog list of entries in reverse-chronological order.";
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

        mb.append(reger.htmlListEvents.getList(userSession, pageProps.logProps.logid, reger.core.Util.getCurrentPage(request.getParameter("currentpage")),request.getParameter("viewdate"), request.getParameter("viewmonth"), "index.log", -1, true, request));

        return mb.toString();

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "List of Entries Here";
    }

}
