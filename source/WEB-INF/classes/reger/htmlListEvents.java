package reger;

import reger.template.Template;
import reger.core.TimeUtils;
import reger.core.Debug;
import reger.cache.LogCache;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class htmlListEvents {

    public static StringBuffer getList(reger.UserSession userSession, int logid, int currentpage, String viewdate, String viewmonth, String thispagename, int locationid, boolean displaypagingnumbers, HttpServletRequest request) {

        //Create the output stringbuffer
        StringBuffer list = new StringBuffer();

        //Number of entries to display
        int numberofentriestodisplay = userSession.getAccount().getDisplaynumberofentries();
        if (request.getParameter("numberofentriestodisplay") != null && reger.core.Util.isinteger(request.getParameter("numberofentriestodisplay"))) {
            numberofentriestodisplay = Integer.parseInt(request.getParameter("numberofentriestodisplay"));
        }

        //Override display
        if (request.getParameter("displaypagingnumbers") != null && request.getParameter("displaypagingnumbers").equals("false")) {
            displaypagingnumbers = false;
        }

        //Deal with paging
        int limitMin = (currentpage * numberofentriestodisplay) - numberofentriestodisplay;
        int limitMax = numberofentriestodisplay;

        //Logid SQL clause
        String logidSql = "";
        if (logid > 0) {
            logidSql = " AND event.logid='" + logid + "' ";
        }

        //Locationid SQL clause
        String locationidSql = "";
        if (locationid > 0) {
            locationidSql = " AND locationid='" + locationid + "' ";
        }

        //Show on homepage sql
        boolean includelogshiddenfromhomepage = true;
        if ((logid <= 0) && (request.getParameter("tagid") == null) && (request.getParameter("tag") == null)) {
            includelogshiddenfromhomepage = false;
        }

        //@!todo Setting a viewdate in the url line doesn't work.  It returns no results.  Possibly a timezone issue.
        //Viewdate SQL - 2003-12-23
        String viewdatesql = "";
        String tmp = "";
        String viewdateusermessage = "";
        if ((viewdate != null && !viewdate.equals("")) || (viewmonth != null && !viewmonth.equals(""))) {
            //Start date
            if (viewmonth != null && !viewmonth.equals("") && viewmonth.length() >= 7) {
                tmp = viewmonth.substring(0, 7) + "-01";
            } else {
                tmp = viewdate;
            }
            Calendar viewstart = TimeUtils.dbstringtocalendar(tmp + " 00:00:00");
            viewdateusermessage = reger.core.TimeUtils.dateformatdate(viewstart);
            ;
            viewstart = TimeUtils.usertogmttime(viewstart, userSession.getAccount().getTimezoneid());
            String viewstartStr = TimeUtils.dateformatfordb(viewstart);

            //End date
            if (viewmonth != null && !viewmonth.equals("")) {
                tmp = viewmonth.substring(0, 7) + "-01 00:00:00";
                Calendar tmpCal = reger.core.TimeUtils.xMonthsAgoEnd(reger.core.TimeUtils.dbstringtocalendar(tmp), 0);
                tmp = reger.core.TimeUtils.dateformatdate(tmpCal);
            } else {
                tmp = viewdate;
            }
            Calendar viewend = TimeUtils.dbstringtocalendar(tmp + " 23:59:59");
            viewdateusermessage = viewdateusermessage + " - " + reger.core.TimeUtils.dateformatdate(viewend) + "<br>";
            viewend = TimeUtils.usertogmttime(viewend, userSession.getAccount().getTimezoneid());
            String viewendStr = TimeUtils.dateformatfordb(viewend);

            //Create the sql
            viewdatesql = " AND event.date>'" + viewstartStr + "' AND event.date<'" + viewendStr + "'";

            //reger.core.Util.logtodb("viewdatesql: " + viewdatesql);
        }

        //Field list.  Do this to keep the resulting array the same for all queries
        String fieldSql = "";
        //fieldSql = "title, comments, date, eventid, event.logid, (SELECT count(*) FROM message m WHERE m.eventid=event.eventid and m.isapproved='1'), (SELECT count(*) FROM image i WHERE i.eventid=event.eventid), event.accountuserid";
        fieldSql = "event.eventid";

        String from = "event event";
        String tagSql = "";
        String tagId = request.getParameter("tagid");
//        String tag = request.getParameter("tag");
        if ((tagId != null) && (tagId.trim().length() > 0)) {
            from += ", tag tag, eventtaglink eventtaglink";
            tagSql += " AND tag.tagid='" + tagId + "' AND eventtaglink.tagid=tag.tagid and event.eventid=eventtaglink.eventid ";
        }
//        if ((tag != null) && (tag.trim().length() > 0)) {
//            System.out.println("TAG IS **** " + tag);
//        }

        //This section builds one of two sets of SQL queries.
        //In each set is a main that returns a limited number of records.
        //And a count that only returns the count of all records fulfilling criteria.
        String sql = "";
        String sqlCount = "";

        //It's the homepage or a log homepage
        //sql = "SELECT "+ fieldSql +" FROM event event, megalog WHERE "+reger.Entry.sqlOfLiveEntry+" AND event.logid=megalog.logid AND megalog.accountid='" + userSession.getAccount().getAccountid() + "' AND " + userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid()) + "" + logidSql + viewdatesql + locationidSql + showonhomepageSql +"ORDER BY event.date DESC" + " LIMIT "+ limitMin +","+ limitMax;
        //sqlCount = "SELECT count(*) FROM event event, megalog WHERE "+reger.Entry.sqlOfLiveEntry+" AND event.logid=megalog.logid AND megalog.accountid='" + userSession.getAccount().getAccountid() + "' AND " + userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid()) + "" + logidSql + viewdatesql + locationidSql + showonhomepageSql;

        sql = "SELECT " + fieldSql + " FROM " + from + " WHERE " + reger.Entry.sqlOfLiveEntry + " AND " + userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid(), includelogshiddenfromhomepage) + "" + logidSql + viewdatesql + tagSql + locationidSql + "ORDER BY event.date DESC" + " LIMIT " + limitMin + "," + limitMax;
        sqlCount = "SELECT count(*) FROM " + from + " WHERE " + reger.Entry.sqlOfLiveEntry + " AND " + userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid(), includelogshiddenfromhomepage) + "" + logidSql + viewdatesql + locationidSql + tagSql;
        //For debugging, output the sql to the screen
        //list.append("<br>" + sql);
        Debug.debug(5, "", "htmlListEvents.java - <br>sql:<br>" + sql + "<br><br>sqlCount:<br>" + sqlCount);
        //Count total records
        //-----------------------------------
        //-----------------------------------
        String[][] rsEventCount = reger.core.db.Db.RunSQL(sqlCount);
        //-----------------------------------
        //-----------------------------------
        int counttotal = 0;
        if (rsEventCount != null) {
            counttotal = Integer.parseInt(rsEventCount[0][0]);
        }

        //reger.core.Util.logtodb("sql htmlListEvents.java: "+sql);
        //Return the actual records needed
        //-----------------------------------
        //-----------------------------------
        String[][] rsEvent = reger.core.db.Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------

        //SHow the date message
        if (!viewdateusermessage.equals("")) {
            list.append("<font class=bigfont face=arial size=+1>" + viewdateusermessage + "</font>");
        }

        //Create the paging links
        StringBuffer pagingLinks = new StringBuffer();
        if (userSession != null && userSession.getAccount() != null && userSession.getAccount().getAccountid() > 0 && reger.core.Util.isinteger(String.valueOf(numberofentriestodisplay)) && request != null) {
            pagingLinks.append(reger.pagingLinkPrint.getHtml(counttotal, currentpage, numberofentriestodisplay, request));
        }

        //Append the paginglinks to the top of the page
        //if (displaypagingnumbers) {
            //list.append(pagingLinks);
        //}


        String author = "";

        if (rsEvent != null && rsEvent.length > 0) {
            for (int i = 0; i < rsEvent.length; i++) {

                //Go get the entry from the cache
                Entry entry = reger.cache.EntryCache.get(Integer.parseInt(rsEvent[i][0]));

                //The link
                //String entryurl="entry.log?logid=" + rsEvent[i][5] + "&eventid=" + rsEvent[i][4];
                //String entryurl="entry-logid" + rsEvent[i][5] + "-eventid" + rsEvent[i][4] + ".log";
                String entryurl = reger.Entry.entryFileNameStatic(entry.logid, entry.eventid, entry.title);
                String entryurladmin = "entry.log?logid=" + entry.logid + "&eventid=" + entry.eventid + "&action=edit";
                //Calculate the port num
//                String portStr = "";
//                String forceportStr = AllSystemProperties.getProp("FORCEPORT");
//                if (Util.isinteger(forceportStr)){
//                    if (!forceportStr.equals("80") && !forceportStr.equals("443")){
//                        portStr = ":"+forceportStr;
//                    }
//                } else {
//                    if (request.getLocalPort()!=80 && request.getLocalPort()!=443) {
//                        portStr = ":"+request.getLocalPort();
//                    }
//                }
                //Now create the entry urls
                //entryurl = "" + userSession.getAccount().getSiteRootUrl(userSession) + portStr + "/" + entryurl;
                //entryurladmin = "" + userSession.getAccount().getSiteRootUrl(userSession) + portStr + "/myhome/" + entryurladmin;
                entryurl = userSession.getUrlWithPortSmartlyAttached(userSession.getAccount().getSiteRootUrl(userSession) + "/" + entryurl);
                entryurladmin = userSession.getUrlWithPortSmartlyAttached(userSession.getAccount().getSiteRootUrl(userSession) + "/myhome/" + entryurladmin);


                //Replace any image tags with html for images
                String entrybody = MegaHtmlFormTopImageTags.replaceImageTagsWithHtml(entry, "");
                entrybody = entrybody.replaceAll( reger.Vars.CARRIAGERETURN + reger.Vars.LINEBREAK, "<br>");
                //How many chars to display?
                int displaycharsinsummary = userSession.getAccount().getDisplaycharsinsummary();
                if ((displaycharsinsummary <= 0) || (displaycharsinsummary >= entrybody.length())) {
                    displaycharsinsummary = entrybody.length();
                }
                entrybody = entrybody.substring(0, displaycharsinsummary);
                //Add the More Link if needed
                if (entry.comments.length() > displaycharsinsummary) {
                    entrybody = entrybody + " ...<a href=" + entryurl + ">More</a>";
                }

                //Author
//				author = rsEvent[i][8];
//				if (!rsEvent[i][9].equals("")){
//                    author = rsEvent[i][9];
//                }

                //Call the tRexEntry Engine
                String templateText = reger.template.AllTemplatesInSystem.getTemplateByTemplateid(userSession.getAccount().getEntlisttemplateid(), Template.TEMPLATETYPEENTRYLIST).getTemplate();

                //Try to override with specific template for log
                if (logid > 0) {
                    Log log = LogCache.get(logid);
                    if (log.getEntlisttemplateid() > 0) {
                        templateText = reger.template.AllTemplatesInSystem.getTemplateByTemplateid(log.getEntlisttemplateid(), Template.TEMPLATETYPEENTRYLIST).getTemplate();
                    }
                }

                //Get log name
                String logname = "";
                Log log = reger.cache.LogCache.get(entry.logid);
                if (log != null) {
                    logname = log.getName();
                }

                //If we're on edit.log and the logged-in user can't administer this logid then don't display the result.
                if (!thispagename.equals("entries.log")) {
                    list.append(reger.template.EntryListTemplateProcessor.entryout(templateText, reger.core.TimeUtils.gmttousertime(entry.dateGmt, userSession.getAccount().getTimezoneid()), entry.title, entryurl, entrybody, logname, entry.filecount, entry.messagecount, entry.accountuserid, entry));
                } else if ((thispagename.equals("entries.log") && userSession.getAccountuser().userCanViewLog(entry.logid))) {
                    list.append(reger.template.EntryListTemplateProcessor.entryout(templateText, reger.core.TimeUtils.gmttousertime(entry.dateGmt, userSession.getAccount().getTimezoneid()), entry.title, entryurladmin, entrybody, logname, entry.filecount, entry.messagecount, entry.accountuserid, entry));
                }
            }
        } else {
            //list.append("<font class=bigfont face=arial size=+1>No entries found.</font><br>");
        }

        //Append the paginglinks to the bottom of the page
        if (displaypagingnumbers) {
            list.append(pagingLinks);
        }

        //Return StringBuffer to the caller
        return list;
    }
}