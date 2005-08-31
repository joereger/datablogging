package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.core.db.Db;
import reger.core.Util;
import reger.pageFramework.PageProps;

import java.util.Calendar;

/**
 *
 */
public class HpTemplateTagOnThisDay implements HpTemplateTag{

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
        return "A list of entries that happened exactly one, two, three, etc years ago.";
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

        if (userSession.getAccount().isPro()) {

            //Put the header on
//            mb.append("<font face=arial size=-1 class=mediumfont color=#cccccc>");
//            mb.append("On This Day in History");
//            mb.append("</font>");
//            mb.append("<br>");

            //Get the list

            mb.append(reger.OnThisDay.getHtml(userSession.getAccount().getAccountid(), userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid()), false, userSession.getAccount().getTimezoneid(), pageProps.logProps.logid));

        }

        return mb.toString();

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        StringBuffer mb = new StringBuffer();

        mb.append("<font face=arial size=-1 class=mediumfont color=#cccccc>On This Day in History</font><br><font face=arial class=mediumfont size=-1>3 Years Ago:</font><br><font face=arial class=smallfont size=-1><a href='#'><img src=images/bullet-arrow.gif border=0>Morning Ride</a></font><br><font face=arial class=smallfont size=-1><a href='#'><img src=images/bullet-arrow.gif border=0>Mmmmm, Ostrich.</a></font><br><font face=arial class=mediumfont size=-1>4 Years Ago:</font><br><font face=arial class=smallfont size=-1><a href='#'><img src=images/bullet-arrow.gif border=0>Stationary Bike 30 Min</a></font>");

        return mb.toString();
    }

}
