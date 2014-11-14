package reger;

import reger.mega.MegaChart;
import reger.mega.MegaChartHtmlRenderer;
import reger.template.Template;
import reger.core.db.Db;
import reger.core.Debug;
import reger.pageFramework.PageProps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Renders a MegaLogType to html summary form
 */
public class MegaLogTypeHtmlrender {

    public static int LOGTYPEDETAILTOSHOWENTRYPAGE = 1;
    public static int LOGTYPEDETAILTOSHOWGRAPHS = 2;
    public static int LOGTYPEDETAILTOSHOWUSERLOGS = 3;
    public static int LOGTYPEDETAILTOSHOWENTRIES = 4;
    public static int LOGTYPEDETAILOWNER = 5;
    public static int LOGTYPEXMLSCHEMA = 6;

    public static String getSummary(MegaLogType logType, int logtypedetailtoshow, String urlforAddLogForm, String thispagename, HttpServletRequest request, HttpServletResponse response, UserSession userSession, PageProps pageProps){
        StringBuffer mb = new StringBuffer();

        //If it's not system log type and the pl forces login and the user isn't logged in, don't do anything
        if(logType.getIssystemlogtype()==0 && (userSession.getPl().getForcelogintoviewsites() && (userSession.getAccountuser()==null || !userSession.getAccountuser().isLoggedIn))){
            mb.append("<font face=arial size=-1 color=#666666><b>Log Type Not Found</b></font>");
        } else{

            //Wrapper table
            mb.append("<table cellpadding=5 cellspacing=1 width=100% border=0>");
            mb.append("<tr>");
            mb.append("<td width=25% valign=top>");

                mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
                mb.append("<br>");
                mb.append("<center>");
                mb.append("<form action="+urlforAddLogForm+" method=post>");
                mb.append("<input type=hidden name=action value=addlogtype>");
                mb.append("<input type=hidden name=eventtypeid value="+logType.getEventtypeid()+">");
                mb.append("<input class=\"btn btn-primary btn-large\" type='submit' value='+ Create a Log of this Type' style=\"font-size: 10px;\">");
                mb.append("</td>");
                mb.append("</form>");
                mb.append("</center>");
                mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));



                mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
                mb.append("<font face=arial size=+3 color=#666666><b>"+logType.getMegalogname()+"</b></font>");

//                mb.append("<br>");
//                mb.append("<br>");
//                mb.append("<img src='"+pageProps.pathToAppRoot+"about/images/arrow-sm-yellow.gif' border=0 valign=bottom> ");
//                mb.append("<a href='"+thispagename+"?eventtypeid="+logType.getEventtypeid()+"&logtypedetailtoshow="+LOGTYPEDETAILTOSHOWENTRYPAGE+"'>");
//                mb.append("<font face=arial size=-2 color=#0000ff><b>Log Entry Page for this Log Type</b></font>");
//                mb.append("</a>");
//                if(!(userSession.getPl().getForcelogintoviewsites() && (userSession.getAccountuser()==null || !userSession.getAccountuser().isLoggedIn))){
//                    int numOfGraphs = graphsBasedOnEventtypeid(logType.getEventtypeid(), userSession);
//                    if (numOfGraphs>0){
//                        mb.append("<br>");
//                        mb.append("<img src='"+pageProps.pathToAppRoot+"about/images/arrow-sm-yellow.gif' border=0 valign=bottom> ");
//                        mb.append("<a href='"+thispagename+"?eventtypeid="+logType.getEventtypeid()+"&logtypedetailtoshow="+LOGTYPEDETAILTOSHOWGRAPHS+"'>");
//                        mb.append("<font face=arial size=-2 color=#0000ff><b>"+numOfGraphs+" Graphs for this Type</b></font>");
//                        mb.append("</a>");
//                    }
//                     mb.append("<br>");
//                    mb.append("<img src='"+pageProps.pathToAppRoot+"about/images/arrow-sm-yellow.gif' border=0 valign=bottom> ");
//                    mb.append("<a href='"+thispagename+"?eventtypeid="+logType.getEventtypeid()+"&logtypedetailtoshow="+LOGTYPEDETAILTOSHOWUSERLOGS+"'>");
//                    mb.append("<font face=arial size=-2 color=#0000ff><b>"+numberOfUserLogsBasedOnEventtypeid(logType.getEventtypeid(), userSession)+" User Logs of this Type</b></font>");
//                    mb.append("</a>");
//                    mb.append("<br>");
//                    mb.append("<img src='"+pageProps.pathToAppRoot+"about/images/arrow-sm-yellow.gif' border=0 valign=bottom> ");
//                    mb.append("<a href='"+thispagename+"?eventtypeid="+logType.getEventtypeid()+"&logtypedetailtoshow="+LOGTYPEDETAILTOSHOWENTRIES+"'>");
//                    mb.append("<font face=arial size=-2 color=#0000ff><b>"+numberOfRecentEntriesBasedOnEventtypeid(logType.getEventtypeid(), userSession)+" Log Entries of this Type</b></font>");
//                    mb.append("</a>");
//                    mb.append("<br>");
//                    mb.append("<img src='"+pageProps.pathToAppRoot+"about/images/arrow-sm-yellow.gif' border=0 valign=bottom> ");
//                    mb.append("<a href='"+thispagename+"?eventtypeid="+logType.getEventtypeid()+"&logtypedetailtoshow="+LOGTYPEDETAILOWNER+"'>");
//                    mb.append("<font face=arial size=-2 color=#0000ff><b>Owner of this Type</b></font>");
//                    mb.append("</a>");
//                }
////                mb.append("<br>");
////                mb.append("<img src='"+pageProps.pathToAppRoot+"about/images/arrow-sm-yellow.gif' border=0 valign=bottom> ");
////                mb.append("<a href='"+thispagename+"?eventtypeid="+logType.getEventtypeid()+"&logtypedetailtoshow="+LOGTYPEXMLSCHEMA+"'>");
////                mb.append("<font face=arial size=-2 color=#0000ff><b>XML Schema</b></font>");
////                mb.append("</a>");
//                mb.append("<br>");
//                //@todo List APIs for this log type

                mb.append("<br>");
                mb.append("<font face=arial size=-1 color=#666666><b>"+logType.getDescription()+"</b></font>");
                if (!logType.getLongdescription().equals("")){
                    mb.append("<br>");
                    mb.append("<font face=arial size=-2 color=#666666><b>"+logType.getLongdescription()+"</b></font>");
                }

                mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));



            //Wrapper table
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td valign=top>");


                mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
                //If it's a system log but the user is trying to display anything besides the entry page, no go
                if(logtypedetailtoshow!=LOGTYPEDETAILTOSHOWENTRYPAGE && (userSession.getPl().getForcelogintoviewsites() && (userSession.getAccountuser()==null || !userSession.getAccountuser().isLoggedIn))){
                    mb.append("<font face=arial size=-1 color=#666666><b>Not Found</b></font>");
                } else {
                    if (logtypedetailtoshow<=0 || logtypedetailtoshow==LOGTYPEDETAILTOSHOWENTRYPAGE){
                        //Log Type Entry Page
                        mb.append(reger.marketingSite.TourHtml.logDetail(logType.getEventtypeid(), pageProps.pathToAppRoot, request, userSession, pageProps, response));
                    } else if (logtypedetailtoshow==LOGTYPEDETAILTOSHOWUSERLOGS){
                        //User logs based on this log type
                        int currentpage = 1;
                        if (request.getParameter("currentpage")!=null && reger.core.Util.isinteger(request.getParameter("currentpage"))){
                            currentpage = Integer.parseInt(request.getParameter("currentpage"));
                        }
                        mb.append("<font face=arial size=+2 color=#666666><b>User Logs Based on this Log Type</b></font>");
                        mb.append("<br>");
                        mb.append("<font face=arial size=-1 color=#666666><b>This is a list of logs that users have set up using this log type.</b></font>");
                        mb.append("<br><br>");
                        mb.append(userLogsBasedOnEventtypeid(logType.getEventtypeid(), currentpage, request, userSession));
                    } else if (logtypedetailtoshow==LOGTYPEDETAILTOSHOWENTRIES){
                        //Recent entries
                        int currentpage = 1;
                        if (request.getParameter("currentpage")!=null && reger.core.Util.isinteger(request.getParameter("currentpage"))){
                            currentpage = Integer.parseInt(request.getParameter("currentpage"));
                        }
                        mb.append("<font face=arial size=+2 color=#666666><b>Entries Made with this Log Type</b></font>");
                        mb.append("<br>");
                        mb.append("<font face=arial size=-1 color=#666666><b>This is a list of log entries of this log type made by users.</b></font>");
                        mb.append("<br><br>");
                        mb.append(recentEntriesBasedOnEventtypeid(logType.getEventtypeid(),  currentpage, request, userSession));
                    } else if (logtypedetailtoshow==LOGTYPEDETAILTOSHOWGRAPHS){
                        //Graphs
                        mb.append(getChartsPreview(logType.getEventtypeid(), userSession));
                    } else if (logtypedetailtoshow==LOGTYPEDETAILOWNER){
                        //Profile of owner
                        mb.append(getOwnerSummaryPage(logType, userSession, pageProps.pathToAppRoot));
                    }  else if (logtypedetailtoshow==LOGTYPEXMLSCHEMA){
                        //Profile of owner
                        mb.append(getXMLSchema(logType, userSession, pageProps.pathToAppRoot));
                    }
                }
                mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));

            //Wrapper table
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("</table>");
        }


        return mb.toString();
    }


    private static int numberOfUserLogsBasedOnEventtypeid(int eventtypeid, UserSession userSession){
        //Count total records
        //-----------------------------------
        //-----------------------------------
        String[][] rstLogCount= reger.core.db.Db.RunSQL("SELECT count(*) FROM megalog, account, pl WHERE "+userSession.getPl().getPeerSql()+" AND account.plid=pl.plid AND megalog.accountid=account.accountid AND account.islistedindirectory='1' AND eventtypeid='"+eventtypeid+"' AND logaccess='"+reger.Vars.LOGACCESSPUBLIC+"'");
        //-----------------------------------
        //-----------------------------------
        int counttotal=0;
        if (rstLogCount!=null){
            counttotal = Integer.parseInt(rstLogCount[0][0]);
        }
        return counttotal;
    }



    private static StringBuffer userLogsBasedOnEventtypeid(int eventtypeid, int currentpage, HttpServletRequest request, UserSession userSession){
        StringBuffer mb = new StringBuffer();



        //Deal with paging
        int limitMin = (currentpage * 25) - 25;
        int limitMax = 25;

        //This section builds one of two sets of SQL queries.
        //In each set is a main that returns a limited number of records.
        //And a count that only returns the count of all records fulfilling criteria.
        String sql="";

        //It's the homepage or a log homepage
        sql = "SELECT logid, name, account.accountid FROM megalog, account, pl WHERE  "+userSession.getPl().getPeerSql()+" AND account.plid=pl.plid AND megalog.accountid=account.accountid AND account.islistedindirectory='1' AND  eventtypeid='"+eventtypeid+"' AND logaccess='"+reger.Vars.LOGACCESSPUBLIC+"' ORDER BY logid DESC" + " LIMIT "+ limitMin +","+ limitMax;



        //For debugging, output the sql to the screen
        //list.append("<br>" + sql);

        Debug.debug(5, "", "TourHtml.java - <br>sql:<br>"+sql);


        int counttotal=numberOfUserLogsBasedOnEventtypeid(eventtypeid, userSession);



        //Return the actual records needed
        //-----------------------------------
        //-----------------------------------
        String[][] rstLog= reger.core.db.Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------


        //Create the paging links
        StringBuffer pagingLinks = new StringBuffer();
        pagingLinks.append(reger.pagingLinkPrint.getHtml(counttotal, currentpage, 25, request));


        //Append the paginglinks to the top of the page
        mb.append(pagingLinks);


        if (rstLog!=null &&  rstLog.length>0) {
            for(int i=0; i<rstLog.length; i++){
                //The link
                String logurl="blog/"+rstLog[i][0]+"/";

                //The baseurl
                reger.Account acct = new reger.Account(Integer.parseInt(rstLog[i][2]));



                mb.append("<font face=arial size=-1>");
                mb.append("<a href='"+acct.getSiteRootUrl(userSession)+"/"+logurl+"'>");
                mb.append(rstLog[i][1]);
                mb.append("</a>");
                mb.append(" from: " + acct.getSiteRootUrl(userSession)+"/");
                mb.append("</font>");
                mb.append("<br>");

            }
        } else {
            mb.append("<font class=smallfont face=arial size=-2>No user logs based on this log type are made public.</font><br>");
        }

        //Append the paginglinks to the bottom of the page
        mb.append(pagingLinks);


        return mb;
    }

    private static int graphsBasedOnEventtypeid(int eventtypeid, UserSession userSession){
        //@todo Find graphs that use only this eventtypeid, display links to user examples of them
        //-----------------------------------
        //-----------------------------------
        String[][] rstChart= Db.RunSQL("SELECT DISTINCT megachart.megachartid, chartname FROM megachart, megachartyaxis WHERE megachart.megachartid=megachartyaxis.megachartid AND (megachart.xeventtypeid='"+eventtypeid+"' OR megachartyaxis.yeventtypeid='"+eventtypeid+"')");
        //-----------------------------------
        //-----------------------------------
        if (rstChart!=null && rstChart.length>0){
            return rstChart.length;
        }
        return 0;
    }

    private static StringBuffer getChartsPreview(int eventtypeid, UserSession userSession){
        //@todo Find graphs that use only this eventtypeid, display links to user examples of them
        StringBuffer mb = new StringBuffer();
        //List charts
        //-----------------------------------
        //-----------------------------------
        String[][] rstChart= Db.RunSQL("SELECT DISTINCT megachart.megachartid, chartname FROM megachart, megachartyaxis WHERE megachart.megachartid=megachartyaxis.megachartid AND (megachart.xeventtypeid='"+eventtypeid+"' OR megachartyaxis.yeventtypeid='"+eventtypeid+"')");
        //-----------------------------------
        //-----------------------------------
        if (rstChart!=null && rstChart.length>0){

            mb.append("<br><br>");

            mb.append("<center>");
            mb.append("<font face=arial size=+2 color=#666666>");
            mb.append("<b>");
            mb.append("This log comes with pre-defined graphs:");
            mb.append("</b>");
            mb.append("</font>");
            mb.append("<font face=arial size=-2 color=#666666>");
            mb.append("<b>");
            mb.append("<br>(You can also define and save an unlimited number of your own.)");
            mb.append("</b>");
            mb.append("<br><br>Note that the preview data in these graphs is only representative. Your data will be named more appropriately and will make more intuitive sense.");
            mb.append("</font>");
            mb.append("</center>");

            mb.append("<table width=80% align=center cellpadding=0 cellspacing=10 bgcolor=#e6e6e6 border=0>");
            mb.append("<tr>");
            mb.append("<td valign=top bgcolor=#ffffff>");

            for(int i=0; i<rstChart.length; i++){
                mb.append("<br><br>");
                mb.append("<font face=arial size=-1>");
                mb.append("<center>");
                mb.append(rstChart[i][1]);
                mb.append("<br>");
                //mb.append("<img src='"+pathToRoot+reger.mega.MegaChartSeries.imageUrlForPreviewFromMegachartid(Integer.parseInt(rstChart[i][0]))+"' border=0>");

                //MegaChart mc = new MegaChart(Integer.parseInt(rstChart[i][0]));
                //mb.append(MegaChartHtmlRenderer.getHtml(mc, userSession, true, "../", false, true));

                mb.append("</center>");
                mb.append("</font>");

            }

            mb.append("</td>");
            mb.append("</tr>");
            mb.append("</table>");
        } else {
            mb.append("<center>");
            mb.append("<font face=arial size=+2 color=#666666>");
            mb.append("<b>");
            mb.append("This log type does not come with any pre-built graphs.");
            mb.append("</b>");
            mb.append("</font>");

            mb.append("<br><br>However, you'll be able to create and save as many custom graphs as you like.");
            mb.append("</font>");
            mb.append("</center>");
        }
        return mb;
    }

    private static int numberOfRecentEntriesBasedOnEventtypeid(int eventtypeid, UserSession userSession){
        //Count total records
        //-----------------------------------
        //-----------------------------------
        String[][] rstEntryCount= reger.core.db.Db.RunSQL("SELECT count(*) FROM event event, megalog, account, pl WHERE  "+userSession.getPl().getPeerSql()+" AND account.plid=pl.plid AND megalog.accountid=account.accountid AND account.islistedindirectory='1' AND megalog.eventtypeid='"+eventtypeid+"' AND "+reger.Entry.sqlOfLiveEntry+" AND event.logid=megalog.logid AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"'");
        //-----------------------------------
        //-----------------------------------
        int counttotal=0;
        if (rstEntryCount!=null){
            counttotal = Integer.parseInt(rstEntryCount[0][0]);
        }
        return counttotal;
    }

    private static StringBuffer recentEntriesBasedOnEventtypeid(int eventtypeid, int currentpage, HttpServletRequest request, UserSession userSession){
        StringBuffer mb = new StringBuffer();

        //Deal with paging
        int limitMin = (currentpage * 25) - 25;
        int limitMax = 25;

        //Field list.  Do this to keep the resulting array the same for all queries
        String fieldSql = "title, event.comments, megalog.name, event.date, eventid, event.logid, 0, 0, event.accountuserid, event.accountid";

        //This section builds one of two sets of SQL queries.
        //In each set is a main that returns a limited number of records.
        //And a count that only returns the count of all records fulfilling criteria.
        String sql="";

        //It's the homepage or a log homepage
        sql = "SELECT "+ fieldSql +" FROM event event, megalog, account, pl WHERE "+userSession.getPl().getPeerSql()+" AND account.plid=pl.plid AND megalog.accountid=account.accountid AND account.islistedindirectory='1' AND megalog.eventtypeid='"+eventtypeid+"' AND "+reger.Entry.sqlOfLiveEntry+" AND event.logid=megalog.logid AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"' ORDER BY event.date DESC" + " LIMIT "+ limitMin +","+ limitMax;

        Debug.debug(5, "", "TourHtml.java - <br>sql:<br>"+sql);

        int counttotal=numberOfRecentEntriesBasedOnEventtypeid(eventtypeid, userSession);


        //Return the actual records needed
        //-----------------------------------
        //-----------------------------------
        String[][] rsEvent= reger.core.db.Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------



        //Create the paging links
        StringBuffer pagingLinks = new StringBuffer();
        pagingLinks.append(reger.pagingLinkPrint.getHtml(counttotal, currentpage, 25, request));


        //Append the paginglinks to the top of the page
        mb.append(pagingLinks);

        int numberOnPage = 0;

        String author="";

        if (rsEvent!=null &&  rsEvent.length>0) {
            for(int i=0; i<rsEvent.length; i++){
                //The link
                //String entryurl="entry.log?logid=" + rsEvent[i][5] + "&eventid=" + rsEvent[i][4];
                //String entryurl="entry-logid" + rsEvent[i][5] + "-eventid" + rsEvent[i][4] + ".log";
                String entryurl=reger.Entry.entryFileNameStatic(Integer.parseInt(rsEvent[i][5]), Integer.parseInt(rsEvent[i][4]), rsEvent[i][0]);

                //The baseurl
                reger.Account acct = reger.cache.AccountCache.get(Integer.parseInt(rsEvent[i][9]));


                entryurl = "" + acct.getSiteRootUrl(userSession) + "/" + entryurl;



                //How many chars to display?
                int displaycharsinsummary=500;
                //The Entry body
                //String entrybody="";
                //entrybody=rsEvent[i][1].substring(0,displaycharsinsummary);
                //Put line breaks in there
                //entrybody=replace(entrybody, VbCrlf  & VbCrlf, "<br><br>")
                //entrybody=entrybody.replaceAll( reger.Vars.LINEBREAKCHAR, "<br><br>");
                //Add the More Link if needed
//				if (rsEvent[i][1].length()>displaycharsinsummary){
//					entrybody=entrybody + " ...<a href="+ entryurl +">More</a>";
//				}

                //Get the message and image counts
                //This creates two extra Db calls per entry... very slow
                //Not happy about this code.
                int imagecount=0;
                int messagecount=0;
//				if (!rsEvent[i][7].equals("")){
//					imagecount=Integer.parseInt(rsEvent[i][7]);
//				}
//				if (!rsEvent[i][6].equals("")){
//					messagecount=Integer.parseInt(rsEvent[i][6]);
//				}

                //Author
//				author = rsEvent[i][8];
//				if (!rsEvent[i][9].equals("")){
//                    author = rsEvent[i][9];
//                }


                //Call the tRexEntry Engine
                String templateText = reger.template.AllTemplatesInSystem.getSystemDefaultByType(Template.TEMPLATETYPEENTRYLIST).getTemplate();

                 numberOnPage++;


                //If we're on edit.log and the logged-in user can't administer this logid then don't display the result
                mb.append( reger.template.EntryListTemplateProcessor.entryout(templateText, reger.core.TimeUtils.dbstringtocalendar(rsEvent[i][3]), rsEvent[i][0], entryurl, reger.core.Util.truncateString(rsEvent[i][1], displaycharsinsummary), rsEvent[i][2], 0, 0, Integer.parseInt(rsEvent[i][8]), reger.cache.EntryCache.get(Integer.parseInt(rsEvent[i][4]))));

            }
        } else {
            mb.append("<font class=smallfont face=arial size=-2>No recent entries found.</font><br>");
        }

        //Append the paginglinks to the bottom of the page
        mb.append(pagingLinks);

        return mb;
    }

    private static String getOwnerSummaryPage(MegaLogType logType, UserSession userSession, String pathToAppRoot){
        StringBuffer mb = new StringBuffer();
        if (logType.getIssystemlogtype()==1){
            mb.append("<font face=arial size=+1>This log type is owned by the system administrator.</font>");
        } else {
            if (logType.getAccountuserid()>0){
                //User log type
                reger.Accountuser au = new reger.Accountuser(logType.getAccountuserid(), false);
                mb.append(reger.Profile.getHtmlProfile(au, userSession, false, pathToAppRoot));
            } else {
                //Orphan log type
                mb.append("<font face=arial size=+1>This log type has been orphaned.</font>");
            }
        }

        return mb.toString();
    }

    private static String getXMLSchema(MegaLogType logType, UserSession userSession, String pathToAppRoot){
        StringBuffer mb = new StringBuffer();

        mb.append("<font face=arial size=+1>This XML represents the log type as an XML Schema document.</font>");
        mb.append("<br>");
        mb.append("You can also <a href='../logtype-as-schema.log?eventtypeid="+logType.getEventtypeid()+"'>view this file directly</a>.");
        mb.append("<br><br>");

        mb.append("<pre>");
        mb.append(reger.MegaLogTypeXmlSchemaRenderer.getSchema(logType).replaceAll("<", "&lt;").replaceAll(">", ">"+reger.Vars.LINEBREAKCHARFORHTML).replaceAll("XXXxmlns", "xmlns"));
        mb.append("</pre>");


        ////Create input and output streams for Tidy to use
//        java.io.ByteArrayInputStream inStr = new java.io.ByteArrayInputStream(reger.MegaLogTypeXmlSchemaRenderer.getSchema(logType).replaceAll("XXXxmlns", "xmlns").getBytes());
//        ByteArrayOutputStream outStr = new ByteArrayOutputStream();
//        ////Create the Tidy object and clean the output
//        Tidy tidy = new Tidy();
//        //tidy.setXHTML(true);
//        tidy.setIndentContent(true);
//        tidy.setWraplen(300);
//        tidy.parse(inStr, outStr);
//
//        mb.append(outStr.toString().replaceAll("<", "&lt;"));



        return mb.toString();
    }

}
