package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.core.db.Db;
import reger.core.Util;
import reger.pageFramework.PageProps;
import reger.core.db.Db;

import java.util.Calendar;

/**
 *
 */
public class HpTemplateTagFavoriteEntries implements HpTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Titles.Favorite.Entries";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The titles of entries marked as favorite entries.";
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
//        mb.append("Favorite Entries");
//        mb.append("</font>");
//        mb.append("<br>");

        //Get the list
        mb.append("<table cellpadding=0 cellspacing=1 border=0>");

        //Limit to logid, if required
        String logidSql = "";
        if (pageProps.logProps.logid>0){
            logidSql = " AND megalog.logid='"+pageProps.logProps.logid+"'";
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstLastentries= Db.RunSQL("SELECT eventid, title, event.logid FROM event WHERE event.accountid='"+ userSession.getAccount().getAccountid() +"' AND "+reger.Entry.sqlOfLiveEntry+" AND event.favorite='1' AND "+userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid())+" "+logidSql+" ORDER BY date DESC");
        //-----------------------------------
        //-----------------------------------
        if (rstLastentries!=null && rstLastentries.length>0){
            for(int i=0; i<rstLastentries.length; i++){
                mb.append("<tr><td bgcolor=#ffffff valign=top>");
                mb.append("<font face=arial size=-2 class=smallfont>");
                mb.append("<strong>");
                mb.append(i+1);
                mb.append("</strong>");
                mb.append("</font>");
                mb.append("</td>");
                String entryurl=reger.Entry.entryFileNameStatic(Integer.parseInt(rstLastentries[i][2]), Integer.parseInt(rstLastentries[i][0]), rstLastentries[i][1]);
                mb.append("<td bgcolor=#ffffff valign=top>");
                mb.append("<a href='"+entryurl+"'><font face=arial size=-2>" + Util.cleanForHtml(rstLastentries[i][1]) + "</font></a>");
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
        mb.append("Favorite Entries");
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
