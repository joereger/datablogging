package reger;

import reger.core.db.Db;
import reger.core.Debug;

/**
 * A class containing methods to build and maintain side column displays.
 */
public class SideColumn {

    /**
     * Starts a side column unit
     */
    public static StringBuffer sideColTableStart(String tablename){
        StringBuffer sc = new StringBuffer();

        sc.append("<!-- "+tablename+" Start -->");
        sc.append("<table class=sidecolunit cellpadding=0 cellspacing=0 width=100% border=0>");

        return sc;
    }

    /**
     * Header row
     */
    public static StringBuffer sideColHeaderRow(String header){
        StringBuffer sc = new StringBuffer();

        sc.append("<tr>");
        sc.append("<td class=sidecolheader align=left>");
        sc.append(header);
        sc.append("</td>");
        sc.append("</tr>");

        return sc;
    }

    /**
     * Content row
     */
    public static StringBuffer sideColContentRow(String content){
        StringBuffer sc = new StringBuffer();

        sc.append("<tr>");
        sc.append("<td class=sidecolcontent  align=left valign=top width=9>");
        sc.append(content);
        sc.append("</td>");
        sc.append("</tr>");

        return sc;
    }

    /**
     * Ends a side column unit
     */
    public static StringBuffer sideColTableEnd(String tablename){
        StringBuffer sc = new StringBuffer();

        sc.append("</table>");
        sc.append("<!-- "+tablename+" end -->");

        return sc;
    }

    /**
     * Call this to put a side column Log Html unit on the screen
     */
    public static StringBuffer logHtml(int logid, int accountid){
        StringBuffer lh = new StringBuffer();

//        lh.append(sideColTableStart("Log Html"));
//
//        //lh.append(reger.SideColumn.sideColHeaderRow(""));
//
//        //-----------------------------------
//        //-----------------------------------
//        String[][] rstLogHtml= Db.RunSQL("SELECT message FROM megalog WHERE logid='" + logid + "' AND accountid='"+accountid+"'");
//        //-----------------------------------
//        //-----------------------------------
//        if (rstLogHtml!=null && rstLogHtml.length>0){
//            lh.append(reger.SideColumn.sideColContentRow(rstLogHtml[0][0]));
//        } else {
//            return new StringBuffer();
//        }
//
//        lh.append(sideColTableEnd("Log Html"));

        return lh;
    }


    /**
     * Call this to put a side column Favorites unit on the screen
     */
    public static StringBuffer favorites(int logid, String logname){
        StringBuffer fv = new StringBuffer();

        fv.append(sideColTableStart("Favorites"));

        fv.append(reger.SideColumn.sideColHeaderRow("Favorite " + reger.core.Util.cleanForHtml(logname) + " Entries"));

        //-----------------------------------
        //-----------------------------------
        String[][] rstFavorite= Db.RunSQL("SELECT eventid, title FROM event WHERE logid='" + logid + "' AND "+reger.Entry.sqlOfLiveEntry+" AND favorite='1'");
        //-----------------------------------
        //-----------------------------------
        if (rstFavorite!=null && rstFavorite.length>0){
            for(int i=0; i<rstFavorite.length; i++){
                fv.append(reger.SideColumn.sideColContentRow("<img src='images/clear.gif' width='9' height='3' alt='' border='0'><br><img src='images/bullet-arrow.gif' width='9' height='9' alt='' border='0'><a href='entry-logid"+logid+"-eventid"+rstFavorite[i][0]+".log'>" + reger.core.Util.cleanForHtml(rstFavorite[i][1]) + "</a>"));
            }
        } else {
            fv.append(reger.SideColumn.sideColContentRow("None."));
        }

        fv.append(sideColTableEnd("Favorites"));

        return fv;
    }

    /**
     * Override so that this can be called more simply
     * @param logid
     * @return
     */
    public static StringBuffer chartsngraphs(int logid, reger.UserSession userSession){
        //Get eventtypeid
        //-----------------------------------
        //-----------------------------------
        String[][] rstEvtid= Db.RunSQL("SELECT eventtypeid FROM megalog WHERE logid='"+logid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEvtid!=null && rstEvtid.length>0){
            return chartsngraphs(logid, Integer.parseInt(rstEvtid[0][0]), userSession);
        }
        return chartsngraphs(logid, 0, userSession);
    }


    public static StringBuffer chartsngraphs(int logid, int eventtypeid, reger.UserSession userSession){
        StringBuffer sc = new StringBuffer();

        sc.append(sideColTableStart("Charts and Graphs"));

        sc.append(reger.SideColumn.sideColHeaderRow("<a href='graphs.log'>Graphs"));

        StringBuffer tmp=new StringBuffer();

        //Go get any charts related to this log.
        String sql = "SELECT DISTINCT megachart.megachartid, chartname, megalog.logid, megachart.accountid FROM megachart, megachartyaxis, megalog" +
        " WHERE "+
        " megachart.megachartid=megachartyaxis.megachartid AND megalog.logid='"+logid+"'"+
        " AND "+
        userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid()) +
        " AND "+
        " (megalog.logid=megachart.xlogid OR megalog.logid=megachartyaxis.ylogid OR megalog.eventtypeid=megachart.xeventtypeid OR megalog.eventtypeid=megachartyaxis.yeventtypeid ) "+
        " AND "+
        " (megachart.accountid='"+userSession.getAccount().getAccountid()+"' OR megachart.accountid='0')"+
        " ORDER BY megachart.accountid DESC, megalog.logid ASC, megachart.megachartid DESC";
        Debug.debug(5, "", sql);

        //-----------------------------------
        //-----------------------------------
        String[][] rstGraph= Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstGraph!=null && rstGraph.length>0){
            for(int i=0; i<rstGraph.length; i++){
                //tmp.append("<font face=arial size=-1 class=smallfont>");
                tmp.append("<a href='graphs-detail.log?megachartid="+rstGraph[i][0]+"'>");
                tmp.append(rstGraph[i][1]);
                tmp.append("</a>");
                //tmp.append("</font>");
                //Add to main output
                sc.append(sideColContentRow(tmp.toString()));
                //Clear tmp
                tmp.delete(0,tmp.length());
            }
        } else {
            sc.append(sideColContentRow("<font face=arial class=smallfont size=-2>None.</font>"));
        }

        sc.append(sideColTableEnd("Charts and Graphs"));

        return sc;
    }


    /**
     * Call this to put a side column Messages unit on the screen
     */
    public static StringBuffer messages(int logid, String logname){
        StringBuffer fv = new StringBuffer();

        fv.append(sideColTableStart("Messages"));

        fv.append(reger.SideColumn.sideColHeaderRow(reger.core.Util.cleanForHtml(logname) + " Messages"));

        //-----------------------------------
        //-----------------------------------
        String[][] rstMessages= Db.RunSQL("SELECT count(*) FROM message, event WHERE event.logid='" + logid + "' AND message.isapproved='1' AND message.eventid=event.eventid");
        //-----------------------------------
        //-----------------------------------
        if (rstMessages!=null && rstMessages.length>0 && !rstMessages[0][0].equals("0")){
            fv.append(reger.SideColumn.sideColContentRow("<a href='messages.log?logid="+logid+"'>"+rstMessages[0][0] + " Messages Available</a>"));
        } else {
            fv.append(reger.SideColumn.sideColContentRow("None."));
        }

        fv.append(sideColTableEnd("Messages"));

        return fv;
    }

}
