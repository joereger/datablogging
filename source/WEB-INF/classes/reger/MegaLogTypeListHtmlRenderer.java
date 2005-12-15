package reger;

import reger.core.db.Db;
import reger.core.Debug;
import reger.pageFramework.PageProps;
import reger.cache.LogCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Lists log types to html
 */
public class MegaLogTypeListHtmlRenderer {


    public static String getLogTypeList(String urlforAddLogForm, String thispagename, String urlForMoreInfo, HttpServletRequest request, HttpServletResponse response, UserSession userSession, PageProps pageProps){
        StringBuffer mb = new StringBuffer();


        //Wrapper table
        mb.append("<table cellpadding=5 width=100% cellspacing=1 border=0>");
        mb.append("<tr>");
        mb.append("<td align=left valign=top>");

            //Starter Log Type Start
            mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
            mb.append("<table cellpadding=0 cellspacing=1 border=0>");
            mb.append("<tr>");
            mb.append("<td align=left valign=center bgcolor=#ffffff colspan=2>");
            mb.append("<font face=arial size=+2 color=#666666><b>Not Sure?</b></font>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2 color=#666666><b>There's no need to choose some fancy log type. You can always add logs of any type later on.  You can even create log types of your own.  Use this one to get started quickly and simply:</b></font>");
            mb.append("<br><br>");
            mb.append("</td>");
            mb.append("</tr>");
            Debug.debug(5, "", "MegaLogTypeListHtmlRenderer.java - userSession.getPl().getDefaulteventtypeid():" + userSession.getPl().getDefaulteventtypeid());
            MegaLogType basicLogType = AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(userSession.getPl().getDefaulteventtypeid());
            if (basicLogType==null){
                basicLogType = AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(reger.Vars.DEFAULTLOGEVENTTYPEID);
            }
            mb.append("<!-- begin log type -->");
            mb.append("<tr>");
            mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=2>");
            mb.append("<font face=arial size=+1 color=#000000><b>"+basicLogType.getMegalogname() +"</b></font>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2 color=#333333>" + basicLogType.getDescription() + "");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td bgcolor='#ffffff' align=left width=10% valign=top>");
            mb.append("<form action="+urlforAddLogForm+" method=post>");
            mb.append("<input type=hidden name=action value=addlogtype>");
            mb.append("<input type=hidden name=eventtypeid value="+basicLogType.getEventtypeid()+">");
            mb.append("<input type='submit' value='+ Create a Log' style=\"font-size: 10px;\">");
            mb.append("</form>");
            mb.append("</td>");
            mb.append("<td bgcolor='#ffffff' align=left valign=top>");
            mb.append("<form action="+urlForMoreInfo+" method=GET>");
            mb.append("<input type=hidden name=eventtypeid value="+basicLogType.getEventtypeid()+">");
            mb.append("<input type='submit' value='Learn More' style=\"font-size: 10px;\">");
            mb.append("</form>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=2>");
            mb.append("<font face=arial size=+1><b>&nbsp;</b></font>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<!-- end log type -->");
            mb.append("</table>");
            mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));



            //System Log Types Start
            mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
            mb.append("<table cellpadding=0 cellspacing=1 border=0>");
            mb.append("<tr>");
            mb.append("<td align=left valign=center bgcolor=#ffffff colspan=2>");
            mb.append("<font face=arial size=+2 color=#666666><b>System Log Types</b></font>");
            mb.append("<br><br>");
            mb.append("</td>");
            mb.append("</tr>");
            String sqlSubselectCountLogsEt = "(SELECT count(*) FROM megalog megalog WHERE megalog.eventtypeid=megalogtype.eventtypeid AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"') as logcount";
            //-----------------------------------
            //-----------------------------------
            String[][] rstEventtype= Db.RunSQL("SELECT pleventtypeid.eventtypeid, megalogname, description, icon, "+sqlSubselectCountLogsEt+"  FROM pleventtypeid, megalogtype megalogtype WHERE pleventtypeid.plid='"+ userSession.getPl().getPlid() +"' AND pleventtypeid.eventtypeid=megalogtype.eventtypeid ORDER BY pleventtypeid.priority ASC");
            //-----------------------------------
            //-----------------------------------
            if (rstEventtype!=null && rstEventtype.length>0){
                for(int i=0; i<rstEventtype.length; i++){

                    mb.append(compactLogTypeHtml(Integer.parseInt(rstEventtype[i][0]), rstEventtype[i][1], Integer.parseInt(rstEventtype[i][4]), rstEventtype[i][2], urlforAddLogForm, urlForMoreInfo));

                }
            }
            mb.append("</table>");
            mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));
            //System Log Types End

        //Wrapper table
        mb.append("</td>");
        mb.append("<td align=left valign=top>");

            //Search box
            mb.append("<form action="+thispagename+" method=GET style=\"margin: 0px;\">");
            mb.append("<input type=hidden name=action value=search>");
            mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
            mb.append("<center>");
            mb.append("<font face=arial size=+2 color=#666666><b>Find a Log Type</b></font>");
            mb.append("<br>");
            mb.append("<input type=text name=searchterms size=20 maxlength=50 style=\"font-size: 12px;\">");
            mb.append("<input type=submit value='Go'>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2 color=#666666><b>Search for anything you're interested in.<br>A sport.  A hobby.  A type of technology.</b></font>");
            mb.append("</center>");
            mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));
            mb.append("</form>");


            //Custom log types?
            if (userSession.getAccountuser()!=null && !userSession.getAccountuser().isLoggedIn){
                mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
                mb.append("<font face=arial size=+2 color=#666666><b>Create Your Own Custom Log Type?</b></font>");
                mb.append("<br>");
                mb.append("<font face=arial size=-2 color=#666666><b>It's quick and easy to define your own custom log type, but you have to have an account to do so.  Choose any log type to get started and once you're logged-in click on your Logs tab.  It only takes a minute or two to get your custom log type going.</b></font>");
                mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));
            } else {
                mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
                mb.append("<font face=arial size=+2 color=#666666><b>Create Your Own Custom Log Type?</b></font>");
                mb.append("<br>");
                mb.append("<font face=arial size=-2 color=#666666><b>You can create your own custom log type to track anything. Create your log type <a href='"+pageProps.pathToAppRoot+"myhome/logs-type-properties.log?action=startadd'>here</a>.</b></font>");
                mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));
                //Invited to log types
                try{
                    mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
                    mb.append("<font face=arial size=+2 color=#666666><b>You've Been Invited To</b></font>");
                    mb.append("<br>");
                    mb.append("<font face=arial size=-2 color=#666666><b>These are the custom log types that other people have invited you to.</b></font>");
                    mb.append("<table cellpadding=3 cellspacing=1 width=100% border=0 bgcolor=#ffffff>");
                    int acctidtouse = 0;
                    if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
                        acctidtouse = userSession.getAccount().getAccountid();
                    } else if (userSession.getAccountuser()!=null){
                        acctidtouse =  userSession.getAccountuser().getAccountid();
                    }
                    String sqlSubselectCountLogsLt = "(SELECT count(*) FROM megalog megalog WHERE megalog.eventtypeid=megalogtype.eventtypeid AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"') as logcount";
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstLogtype= Db.RunSQL("SELECT megalogtype.eventtypeid, megalogname, description, icon, "+sqlSubselectCountLogsLt+" FROM megalogtype megalogtype, friendinvitation, friendinvitationeventtypeid, accountuser WHERE accountuser.accountuserid='"+userSession.getAccountuser().getAccountuserid()+"' AND accountuser.accountuserid=friendinvitation.accountuseridtarget AND friendinvitation.friendinvitationid=friendinvitationeventtypeid.friendinvitationid AND friendinvitationeventtypeid.eventtypeid=megalogtype.eventtypeid  ORDER BY logcount DESC LIMIT 0,25");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstLogtype!=null && rstLogtype.length>0){
                        for(int i=0; i<rstLogtype.length; i++){
                            mb.append(superCompactLogTypeHtml(Integer.parseInt(rstLogtype[i][0]), rstLogtype[i][1], Integer.parseInt(rstLogtype[i][4]), rstLogtype[i][2], urlforAddLogForm, urlForMoreInfo));
                        }
                    } else {
                        mb.append("<tr><td valign=top align=left bgcolor=#ffffff nowrap><img src='../images/info-icon.gif' alt='' border='0'><font face=arial size=-2>None.</td><td valign=center align=left bgcolor=#ffffff><font face=arial size=-2>&nbsp;</td></tr>");
                    }
                    mb.append("</table>");
                    mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));
                } catch (Exception e){
                    Debug.errorsave(e, "");
                }


                //Your own custom log types
                try{
                    mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
                    mb.append("<font face=arial size=+2 color=#666666><b>Your Own Custom Log Types</b></font>");
                    mb.append("<br>");
                    mb.append("<font face=arial size=-2 color=#666666><b>These are the custom log types that you have created.</b></font>");
                    mb.append("<table cellpadding=3 cellspacing=1 width=100% border=0 bgcolor=#ffffff>");
                    int acctidtouse = 0;
                    if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
                        acctidtouse = userSession.getAccount().getAccountid();
                    } else if (userSession.getAccountuser()!=null){
                        acctidtouse =  userSession.getAccountuser().getAccountid();
                    }

                    String sqlSubselectCountLogsLt = "(SELECT count(*) FROM megalog megalog WHERE megalog.eventtypeid=megalogtype.eventtypeid AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"') as logcount";
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstLogtype= Db.RunSQL("SELECT eventtypeid, megalogname, description, icon, "+sqlSubselectCountLogsLt+" FROM megalogtype megalogtype WHERE megalogtype.accountuserid='"+userSession.getAccountuser().getAccountuserid()+"' ORDER BY logcount DESC");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstLogtype!=null && rstLogtype.length>0){
                        for(int i=0; i<rstLogtype.length; i++){
                            mb.append(superCompactLogTypeHtml(Integer.parseInt(rstLogtype[i][0]), rstLogtype[i][1], Integer.parseInt(rstLogtype[i][4]), rstLogtype[i][2], urlforAddLogForm, urlForMoreInfo));
                        }
                    } else {
                        mb.append("<tr><td valign=top align=left bgcolor=#ffffff nowrap><img src='../images/info-icon.gif' alt='' border='0'><font face=arial size=-2>None.</td><td valign=center align=left bgcolor=#ffffff><font face=arial size=-2>&nbsp;</td></tr>");
                    }
                    mb.append("</table>");
                    mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));
                } catch (Exception e){
                    Debug.errorsave(e, "");
                }

                //Friends Using
                try{
                    mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
                    mb.append("<font face=arial size=+2 color=#666666><b>Your Friends are Using</b></font>");
                    mb.append("<br>");
                    mb.append("<font face=arial size=-2 color=#666666><b>These are the custom log types that people designated as your friends are using.</b></font>");
                    mb.append("<table cellpadding=3 cellspacing=1 width=100% border=0 bgcolor=#ffffff>");
                    String sqlSubselectCountLogsLt = "(SELECT count(*) FROM megalog megalog WHERE megalog.eventtypeid=megalogtype.eventtypeid AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"') as logcount";
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstLogtype= Db.RunSQL("SELECT DISTINCT megalogtype.eventtypeid, megalogname, description, icon, "+sqlSubselectCountLogsLt+" FROM megalogtype megalogtype, account, friend, event, megalog WHERE account.islistedindirectory='1' AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"' AND friend.accountuseridsource='"+userSession.getAccountuser().getAccountuserid()+"' AND friend.accountuseridtarget=event.accountuserid AND event.accountid=account.accountid AND event.logid=megalog.logid AND megalog.eventtypeid=megalogtype.eventtypeid ORDER BY logcount DESC LIMIT 0,50");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstLogtype!=null && rstLogtype.length>0){
                        for(int i=0; i<rstLogtype.length; i++){
                            mb.append(superCompactLogTypeHtml(Integer.parseInt(rstLogtype[i][0]), rstLogtype[i][1], Integer.parseInt(rstLogtype[i][4]), rstLogtype[i][2], urlforAddLogForm, urlForMoreInfo));
                        }
                    } else {
                        mb.append("<tr><td valign=top align=left bgcolor=#ffffff nowrap><img src='../images/info-icon.gif' alt='' border='0'><font face=arial size=-2>None.</td><td valign=center align=left bgcolor=#ffffff><font face=arial size=-2>&nbsp;</td></tr>");
                    }
                    mb.append("</table>");
                    mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));
                } catch (Exception e){
                    Debug.errorsave(e, "");
                }

            }




            //User Log Types Start
//            if (userSession.getAccountuser()==null){
//                reger.core.Util.debug(5, "MegaLogTypeListHtmlRenderer.java - userSession.getAccountuser()==null");
//            } else {
//                reger.core.Util.debug(5, "MegaLogTypeListHtmlRenderer.java - userSession.getAccountuser().isLoggedIn=" + userSession.getAccountuser().isLoggedIn);
//            }
            if(userSession.getPl().getForcelogintoviewsites() && (userSession.getAccountuser()==null || !userSession.getAccountuser().isLoggedIn)){
                //Can't display user log types... pl is locked down
            } else {
                mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
                mb.append("<table cellpadding=0 cellspacing=1 border=0>");
                mb.append("<tr>");
                mb.append("<td align=left valign=center bgcolor=#ffffff colspan=2>");
                mb.append("<font face=arial size=+2 color=#666666><b>User-created Log Types</b></font>");
                mb.append("<br>");
                mb.append("<font face=arial size=-2 color=#666666><b>These log types are created and maintained by users. Communities can grow around log types for you to engage in.  Once you're signed up you can create your own custom log types. Some of the more popular user-created log types are listed below:</b></font>");
                mb.append("<br><br>");
                mb.append("</td>");
                mb.append("</tr>");
                String sqlSubselectCountLogs = "(SELECT count(*) FROM megalog megalog WHERE megalog.eventtypeid=megalogtype.eventtypeid AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"') as logcount";
                //-----------------------------------
                //-----------------------------------
                String[][] rstUserLogType= Db.RunSQL("SELECT eventtypeid, megalogname, description, icon, "+sqlSubselectCountLogs+" FROM megalogtype megalogtype, account, pl, accountuser WHERE "+userSession.getPl().getPeerSql()+" AND account.plid=pl.plid AND megalogtype.accountuserid=accountuser.accountuserid AND account.islistedindirectory='1' AND issystemlogtype='0' AND megalogtype.isprivate='0' AND accountuser.accountid=account.accountid ORDER BY logcount DESC LIMIT 0,25");
                //-----------------------------------
                //-----------------------------------
                if (rstUserLogType!=null && rstUserLogType.length>0){
                    for(int i=0; i<rstUserLogType.length; i++){

                        mb.append(compactLogTypeHtml(Integer.parseInt(rstUserLogType[i][0]), rstUserLogType[i][1], Integer.parseInt(rstUserLogType[i][4]), rstUserLogType[i][2], urlforAddLogForm, urlForMoreInfo));

                    }
                }
                mb.append("</table>");
                mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));
                //User Log Types End
            }
        //Wrapper table
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");

        return mb.toString();
    }


//    public static String getSearchResults(String searchterms, String urlforAddLogForm, String thispagename, String urlForMoreInfo, HttpServletRequest request, HttpServletResponse response, UserSession userSession, pageProps pageProps){
//        StringBuffer mb = new StringBuffer();
//
//        mb.append("<table cellpadding=5 cellspacing=1 width=100% border=0>");
//        //Wrapper table
//        mb.append("<tr>");
//        mb.append("<td align=left valign=top colspan=2>");
//        mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
//        //Search results
//        mb.append("<table cellpadding=0 cellspacing=1 border=0>");
//        mb.append("<tr>");
//        mb.append("<td align=left valign=center bgcolor=#ffffff colspan=1>");
//        mb.append("<font face=arial size=+1 color=#666666><b>Search Results</b></font>");
//        mb.append("<br>");
//        mb.append("</td>");
//        mb.append("</tr>");
//        String onlySystemLogSql = "";
//        if(userSession.getPl().getForcelogintoviewsites() && (userSession.getAccountuser()==null || !userSession.getAccountuser().isLoggedIn)){
//            onlySystemLogSql = " AND megalogtype.issystemlogtype='1' ";
//        }
//        String sqlSubselectCountLogs = "(SELECT count(*) FROM megalog megalog WHERE megalog.eventtypeid=megalogtype.eventtypeid AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"') as logcount";
//        //-----------------------------------
//        //-----------------------------------
//        String[][] rstSearch= Db.RunSQL("SELECT DISTINCT megalogtype.eventtypeid, megalogname, description, icon, "+sqlSubselectCountLogs+" FROM pleventtypeid, megalogtype, pl, account, accountuser WHERE "+userSession.getPl().getPeerSql()+" AND ( (megalogtype.accountuserid=accountuser.accountuserid AND accountuser.accountid=account.accountid AND account.islistedindirectory='1' AND account.plid=pl.plid) OR (pleventtypeid.plid='"+ userSession.getPl().getPlid() +"' AND pleventtypeid.eventtypeid=megalogtype.eventtypeid) ) AND (megalogname LIKE '%"+reger.core.Util.cleanForSQL(searchterms)+"%' OR description LIKE '%"+reger.core.Util.cleanForSQL(searchterms)+"%' OR longdescription LIKE '%"+reger.core.Util.cleanForSQL(searchterms)+"%') AND megalogtype.isprivate='0' "+onlySystemLogSql+" ORDER BY logcount DESC LIMIT 0,50");
//        //-----------------------------------
//        //-----------------------------------
//        if (rstSearch!=null && rstSearch.length>0){
//            for(int i=0; i<rstSearch.length; i++){
//
//                mb.append(compactLogTypeHtml(Integer.parseInt(rstSearch[i][0]), rstSearch[i][1], Integer.parseInt(rstSearch[i][4]), rstSearch[i][2], urlforAddLogForm, urlForMoreInfo));
//
//            }
//        }
//        mb.append("</table>");
//        mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));
//
//
//        //Wrapper table
//        mb.append("</td>");
//        mb.append("</tr>");
//        mb.append("</table>");
//
//
//        return mb.toString();
//    }

    public static String getSearchResults(String searchterms, String urlforAddLogForm, String thispagename, String urlForMoreInfo, HttpServletRequest request, HttpServletResponse response, UserSession userSession, PageProps pageProps){
        StringBuffer mb = new StringBuffer();

        if (searchterms.equals("")){
            mb.append("<font face=arial size=+1 color=#666666><b>You must provide a search term.</b></font>");
        } else {
            mb.append("<table cellpadding=5 cellspacing=1 width=100% border=0>");
            //Wrapper table
            mb.append("<tr>");
            mb.append("<td align=left valign=top colspan=2>");
            mb.append(reger.ui.ShadowBox.start(pageProps.pathToAppRoot));
            //Search results
            mb.append("<table cellpadding=0 cellspacing=1 border=0>");
            mb.append("<tr>");
            mb.append("<td align=left valign=center bgcolor=#ffffff colspan=1>");
            mb.append("<font face=arial size=+1 color=#666666><b>Search Results</b></font>");
            mb.append("<br>");
            mb.append("</td>");
            mb.append("</tr>");
    //        String onlySystemLogSql = "";
    //        if(userSession.getPl().getForcelogintoviewsites() && (userSession.getAccountuser()==null || !userSession.getAccountuser().isLoggedIn)){
    //            onlySystemLogSql = " AND megalogtype.issystemlogtype='1' ";
    //        }
    //        String sqlSubselectCountLogs = "(SELECT count(*) FROM megalog megalog WHERE megalog.eventtypeid=megalogtype.eventtypeid AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"') as logcount";
    //        //-----------------------------------
    //        //-----------------------------------
    //        String[][] rstSearch= Db.RunSQL("SELECT DISTINCT megalogtype.eventtypeid, megalogname, description, icon, "+sqlSubselectCountLogs+" FROM pleventtypeid, megalogtype, pl, account, accountuser WHERE "+userSession.getPl().getPeerSql()+" AND ( (megalogtype.accountuserid=accountuser.accountuserid AND accountuser.accountid=account.accountid AND account.islistedindirectory='1' AND account.plid=pl.plid) OR (pleventtypeid.plid='"+ userSession.getPl().getPlid() +"' AND pleventtypeid.eventtypeid=megalogtype.eventtypeid) ) AND (megalogname LIKE '%"+reger.core.Util.cleanForSQL(searchterms)+"%' OR description LIKE '%"+reger.core.Util.cleanForSQL(searchterms)+"%' OR longdescription LIKE '%"+reger.core.Util.cleanForSQL(searchterms)+"%') AND megalogtype.isprivate='0' "+onlySystemLogSql+" ORDER BY logcount DESC LIMIT 0,50");
    //        //-----------------------------------
    //        //-----------------------------------
    //        if (rstSearch!=null && rstSearch.length>0){
    //            for(int i=0; i<rstSearch.length; i++){
    //
    //                mb.append(compactLogTypeHtml(Integer.parseInt(rstSearch[i][0]), rstSearch[i][1], Integer.parseInt(rstSearch[i][4]), rstSearch[i][2], urlforAddLogForm, urlForMoreInfo));
    //
    //            }
    //        }

            Vector tps = reger.AllMegaLogTypesInSystem.allMegaLogTypesForPlid(userSession.getPl().getPlid());
            List typesSorted = new ArrayList();
            for (int i = 0; i < tps.size(); i++) {
                MegaLogType type = (MegaLogType)tps.elementAt(i);
                boolean isMatch = false;
                //Search term vs. name
                if (type.getMegalogname().indexOf(searchterms)>-1){
                    isMatch = true;
                }
                //Search term vs. description
                if (type.getDescription().indexOf(searchterms)>-1){
                    isMatch = true;
                }
                //Search term vs. long description
                if (type.getLongdescription().indexOf(searchterms)>-1){
                    isMatch = true;
                }
                //If pl requires login to view user content, only display system log types
                //Note that this overrides any match from above
                if(userSession.getPl().getForcelogintoviewsites() && (userSession.getAccountuser()==null || !userSession.getAccountuser().isLoggedIn)){
                    if (type.getIssystemlogtype()==0){
                        isMatch = false;
                    }
                }
                //If there's a match, display the type
                if (isMatch){
                    //Add to the list
                    typesSorted.add(type);
                }
            }

            //Now use treemap to sort
            Collections.sort(typesSorted, new LogTypeNumberOfLogsComparator());
            MegaLogType[] sortedArray = (MegaLogType[]) typesSorted.toArray(new MegaLogType[typesSorted.size()]);
            //Iterate sorted, but remember that it's sorted ascending right now, so reverse it
            for (int i = sortedArray.length - 1; i >= 0; i--) {
                MegaLogType mlt = sortedArray[i];
                //Get number of logs of this type
                int numOfLogs = LogCache.howManyOfThisTypeExist(mlt.getEventtypeid());
                //Append the html
                mb.append(compactLogTypeHtml(mlt.getEventtypeid(), mlt.getMegalogname(), numOfLogs, mlt.getDescription(), urlforAddLogForm, urlForMoreInfo));

            }
          








            mb.append("</table>");
            mb.append(reger.ui.ShadowBox.end(pageProps.pathToAppRoot));


            //Wrapper table
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("</table>");
        }


        return mb.toString();
    }

    private static String compactLogTypeHtml(int eventtypeid, String logtypename, int numberoflogsofthistype, String description, String urlforAddLogForm, String urlForMoreInfo){
        StringBuffer mb = new StringBuffer();
        mb.append("<!-- begin log type -->");
        mb.append("<tr>");
        mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=2>");
        mb.append("<font face=arial size=+1 color=#000000><b>"+logtypename+"</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-1 color=#333333><b>" + numberoflogsofthistype + " Logs of this Type Exist<b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2 color=#333333>" + description + "</font>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td bgcolor='#ffffff' align=left width=150 valign=top>");
        mb.append("<form action="+urlforAddLogForm+" method=post>");
        mb.append("<input type=hidden name=action value=addlogtype>");
        mb.append("<input type=hidden name=eventtypeid value="+eventtypeid+">");
        mb.append("<input type='submit' value='+ Create a Log' style=\"font-size: 10px;\">");
        mb.append("</form>");
        mb.append("</td>");
        mb.append("<td bgcolor='#ffffff' align=left valign=top>");
        mb.append("<form action="+urlForMoreInfo+" method=GET>");
        mb.append("<input type=hidden name=eventtypeid value="+eventtypeid+">");
        mb.append("<input type='submit' value='Learn More' style=\"font-size: 10px;\">");
        mb.append("</form>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=2>");
        mb.append("<font face=arial size=+1><b>&nbsp;</b></font>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("<!-- end log type -->");
        return mb.toString();
    }

    private static String superCompactLogTypeHtml(int eventtypeid, String logtypename, int numberoflogsofthistype, String description, String urlforAddLogForm, String urlForMoreInfo){
        StringBuffer mb = new StringBuffer();
        mb.append("<!-- begin log type -->");
        mb.append("<tr>");
        mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=1>");
        mb.append("<font face=arial size=+1 color=#000000><b>"+logtypename+"</b></font>");
        mb.append("</td>");
        mb.append("<td bgcolor='#ffffff' align=left valign=top>");
        mb.append("<form action="+urlForMoreInfo+" method=GET>");
        mb.append("<input type=hidden name=eventtypeid value="+eventtypeid+">");
        mb.append("<input type='submit' value='Learn More' style=\"font-size: 10px;\">");
        mb.append("</form>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("<!-- end log type -->");
        return mb.toString();
    }


}
