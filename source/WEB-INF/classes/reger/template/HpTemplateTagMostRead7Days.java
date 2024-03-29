package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.pageFramework.PageProps;

import java.util.Calendar;

/**
 *
 */
public class HpTemplateTagMostRead7Days implements HpTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Titles.Most.Read.Entries.7.Days";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The titles of the most read entries over the last 7 days.";
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

        //Put the header on
//        mb.append("<font face=arial size=-1 class=mediumfont color=#cccccc>");
//        mb.append("Most Read Entries Last 7 Days");
//        mb.append("</font>");
//        mb.append("<br>");

        //Get the list
        mb.append(reger.trafficHtmlOut.entryTrafficList(7, 15, userSession, false, pageProps.logProps.logid));

        return mb.toString();

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        StringBuffer mb = new StringBuffer();

        //Put the header on
        mb.append("<font face=arial size=-1 class=mediumfont color=#cccccc>");
        mb.append("Most Read Entries Last 7 Days");
        mb.append("</font>");
        mb.append("<br>");

        //Get the list
        mb.append("<table cellpadding=0 cellspacing=1 border=0>");


        for(int i=1; i<=15; i++){
            mb.append("<tr><td bgcolor=#ffffff valign=top>");
            mb.append("<font face=arial size=-2 class=smallfont>");
            mb.append("<strong>");
            mb.append(i);
            mb.append("</strong>");
            mb.append("</font>");
            mb.append("</td>");

            mb.append("<td bgcolor=#ffffff valign=top>");
            mb.append("<a href='#'><font face=arial size=-2>Title of Entry #"+i+"</font></a>");
            mb.append("</td>");
            mb.append("</tr>");
        }



        mb.append("</table>");

        return mb.toString();
    }

}
