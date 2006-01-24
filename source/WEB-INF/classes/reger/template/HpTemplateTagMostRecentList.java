package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

import java.util.Calendar;

/**
 *
 */
public class HpTemplateTagMostRecentList implements HpTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Titles.Most.Recent.Entries";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The titles of the 15 most recent log entries.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getHtml(reger.UserSession userSession, javax.servlet.http.HttpServletRequest request, PageProps pageProps){

        StringBuffer mb = new StringBuffer();

        //Get the list
        mb.append("<table cellpadding=0 cellspacing=1 border=0>");

        //Limit to logid, if required
        String logidSql = "";
        if (pageProps.logProps.logid>0){
            logidSql = " AND event.logid='"+pageProps.logProps.logid+"'";
        }

        //Decide whether or not to show entries that are hidden from the homepage
        boolean includelogshiddenfromhomepage = false;
        if (pageProps.logProps.logid>0){
            includelogshiddenfromhomepage = true;
        }

        String sql = "SELECT eventid, title, event.logid FROM event WHERE event.accountid='"+ userSession.getAccount().getAccountid() +"' AND "+reger.Entry.sqlOfLiveEntry+" AND "+userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid(), includelogshiddenfromhomepage)+" "+logidSql+" ORDER BY date DESC LIMIT 0,15";
        reger.core.Debug.debug(5, "HpTemplateTagMostRecentList.java", sql);
        reger.core.Debug.debug(5, "HpTemplateTagMostRecentList.java", "userSession.getAccountUser()="+userSession.getAccountuser().getAccountuserid() + "<br>isloggedin:" + userSession.getAccountuser().getIsLoggedIn() + "<br>email:"+userSession.getAccountuser().getEmail());
        //-----------------------------------
        //-----------------------------------
        String[][] rstLastentries= reger.core.db.Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstLastentries!=null && rstLastentries.length>0){
            for(int i=0; i<rstLastentries.length; i++){
                mb.append("<tr><td bgcolor=#ffffff valign=top>");
                mb.append("<font face=arial size=-2 class=smallfont>");
                mb.append("<strong>");
                mb.append(i + 1);
                mb.append("</strong>");
                mb.append("</font>");
                mb.append("</td>");

                String entryurl=reger.Entry.entryFileNameStatic(Integer.parseInt(rstLastentries[i][2]), Integer.parseInt(rstLastentries[i][0]), rstLastentries[i][1]);
                mb.append("<td bgcolor=#ffffff valign=top>");
                mb.append("<a href='"+entryurl+"'><font face=arial size=-2>" + reger.core.Util.cleanForHtml(rstLastentries[i][1]) + "</font></a>");
                mb.append("</td>");
                mb.append("</tr>");
            }
        }
        mb.append("</table>");

        return mb.toString();

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        StringBuffer mb = new StringBuffer();

        //Put the header on
        mb.append("<font face=arial size=-1 class=mediumfont color=#cccccc>");
        mb.append("15 Most Recent Entries");
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
