package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

/**
 *
 */
public class SiteTemplateTagSmallCalendar implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Small.Calendar";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A small calendar showing which dates entries appear on.";
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
        //Hp calendar
        if (userSession.getAccount().getHomepagecalendar()==1) {
            String viewmonth = "";
            if (request.getParameter("viewmonth")!=null && !request.getParameter("viewmonth").equals("")){
                viewmonth = request.getParameter("viewmonth");
            } else if (request.getParameter("viewdate")!=null && !request.getParameter("viewdate").equals("")){
                viewmonth = request.getParameter("viewdate");
            }
            out.append(reger.CalendarHtml.smallcalendar(reger.Vars.CALENDARTYPEEMPTYEVENTFINDER, viewmonth, pageProps.logProps.logid, "index.log", userSession));
        }
        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "Calendar here.";
    }

}
