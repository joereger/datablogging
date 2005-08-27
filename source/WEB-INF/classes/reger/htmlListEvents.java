package reger;

import reger.template.Template;
import reger.core.TimeUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class htmlListEvents {

	public static StringBuffer getList(reger.UserSession userSession, int logid, int currentpage, String viewdate, String viewmonth, String thispagename, int locationid, boolean displaypagingnumbers, HttpServletRequest request){

		//Create the output stringbuffer
		StringBuffer list = new StringBuffer();

		//Deal with paging
		int limitMin = (currentpage * userSession.getAccount().getDisplaynumberofentries()) - userSession.getAccount().getDisplaynumberofentries();
		int limitMax = userSession.getAccount().getDisplaynumberofentries();

		//Logid SQL clause
		String logidSql="";
		if (logid>0) {
			logidSql = " AND megalog.logid='" + logid + "' ";
		}

		//Locationid SQL clause
		String locationidSql="";
		if (locationid>0) {
			locationidSql = " AND locationid='" + locationid + "' ";
		}

		//Show on homepage sql
		String showonhomepageSql = "";
		//if (locationid<0){
            //showonhomepageSql = " AND megalog.showonhomepage=1 ";
        //}
        if (logid<=0){
            showonhomepageSql = " AND megalog.showonhomepage='1' ";
        }

		//@!todo Setting a viewdate in the url line doesn't work.  It returns no results.  Possibly a timezone issue.
		//Viewdate SQL - 2003-12-23
		String viewdatesql = "";
		String tmp="";
		String viewdateusermessage="";
		if ((viewdate!=null && !viewdate.equals("")) || (viewmonth!=null && !viewmonth.equals(""))){
            //Start date
            if (viewmonth!=null && !viewmonth.equals("") && viewmonth.length()>=7) {
                tmp = viewmonth.substring(0,7) + "-01";
            } else {
                tmp = viewdate;
            }
            Calendar viewstart = TimeUtils.dbstringtocalendar(tmp + " 00:00:00");
            viewdateusermessage=reger.core.TimeUtils.dateformatdate(viewstart);;
            viewstart = TimeUtils.usertogmttime(viewstart, userSession.getAccount().getTimezoneid());
            String viewstartStr = TimeUtils.dateformatfordb(viewstart);


			//End date
			if (viewmonth!=null && !viewmonth.equals("")) {
                tmp = viewmonth.substring(0,7) + "-01 00:00:00";
                Calendar tmpCal = reger.core.TimeUtils.xMonthsAgoEnd(reger.core.TimeUtils.dbstringtocalendar(tmp), 0);
                tmp = reger.core.TimeUtils.dateformatdate(tmpCal);
            } else {
                tmp = viewdate;
            }
			Calendar viewend = TimeUtils.dbstringtocalendar(tmp + " 23:59:59");
			viewdateusermessage=viewdateusermessage + " - " + reger.core.TimeUtils.dateformatdate(viewend) + "<br>";
			viewend = TimeUtils.usertogmttime(viewend, userSession.getAccount().getTimezoneid());
			String viewendStr = TimeUtils.dateformatfordb(viewend);

			//Create the sql
			viewdatesql=" AND event.date>'" + viewstartStr + "' AND event.date<'" + viewendStr + "'";

			//reger.core.Util.logtodb("viewdatesql: " + viewdatesql);
		}

		//Field list.  Do this to keep the resulting array the same for all queries
		String fieldSql = "title, comments, name, date, eventid, event.logid, (SELECT count(*) FROM message m WHERE m.eventid=event.eventid and m.isapproved='1'), (SELECT count(*) FROM image i WHERE i.eventid=event.eventid), event.accountuserid";

		//This section builds one of two sets of SQL queries.
		//In each set is a main that returns a limited number of records.
		//And a count that only returns the count of all records fulfilling criteria.
		String sql="";
		String sqlCount="";

        //It's the homepage or a log homepage
        sql = "SELECT "+ fieldSql +" FROM event event, megalog WHERE "+reger.Entry.sqlOfLiveEntry+" AND event.logid=megalog.logid AND megalog.accountid='" + userSession.getAccount().getAccountid() + "' AND " + userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid()) + "" + logidSql + viewdatesql + locationidSql + showonhomepageSql +"ORDER BY event.date DESC" + " LIMIT "+ limitMin +","+ limitMax;
        sqlCount = "SELECT count(*) FROM event event, megalog WHERE "+reger.Entry.sqlOfLiveEntry+" AND event.logid=megalog.logid AND megalog.accountid='" + userSession.getAccount().getAccountid() + "' AND " + userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid()) + "" + logidSql + viewdatesql + locationidSql + showonhomepageSql;


		//For debugging, output the sql to the screen
		//list.append("<br>" + sql);

		reger.core.Util.debug(5, "htmlListEvents.java - <br>sql:<br>"+sql+"<br><br>sqlCount:<br>"+sqlCount);
		//Count total records
		//-----------------------------------
		//-----------------------------------
		String[][] rsEventCount= reger.core.db.Db.RunSQL(sqlCount);
		//-----------------------------------
		//-----------------------------------
		int counttotal=0;
		if (rsEventCount!=null){
			counttotal = Integer.parseInt(rsEventCount[0][0]);
		}


		//reger.core.Util.logtodb("sql htmlListEvents.java: "+sql);
		//Return the actual records needed
		//-----------------------------------
		//-----------------------------------
		String[][] rsEvent= reger.core.db.Db.RunSQL(sql);
		//-----------------------------------
		//-----------------------------------

		//SHow the date message
		if (!viewdateusermessage.equals("")){
            list.append("<font class=bigfont face=arial size=+1>" + viewdateusermessage + "</font>");
        }

		//Create the paging links
		StringBuffer pagingLinks = new StringBuffer();
		if (userSession!=null && userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && reger.core.Util.isinteger(String.valueOf(userSession.getAccount().getDisplaynumberofentries())) && request!=null){
		    pagingLinks.append(reger.pagingLinkPrint.getHtml(counttotal, currentpage, userSession.getAccount().getDisplaynumberofentries(), request));
        }

		//Append the paginglinks to the top of the page
		if (displaypagingnumbers){
		    list.append(pagingLinks);
        }



		String author="";

		if (rsEvent!=null &&  rsEvent.length>0) {
			for(int i=0; i<rsEvent.length; i++){
				//The link
				//String entryurl="entry.log?logid=" + rsEvent[i][5] + "&eventid=" + rsEvent[i][4];
				//String entryurl="entry-logid" + rsEvent[i][5] + "-eventid" + rsEvent[i][4] + ".log";
				String entryurl=reger.Entry.entryFileNameStatic(Integer.parseInt(rsEvent[i][5]), Integer.parseInt(rsEvent[i][4]), rsEvent[i][0]);
                String entryurladmin="entry.log?logid="+rsEvent[i][5]+"&eventid="+rsEvent[i][4]+"&action=edit";
                //Add the servername and port
                if (request.getLocalPort()==80 || request.getLocalPort()==443){
                    entryurl = "" + reger.Vars.getHttpUrlPrefix() + userSession.getSiteRootUrl() + "/" + entryurl;
                    entryurladmin = "" + reger.Vars.getHttpUrlPrefix() + userSession.getSiteRootUrl() + "/myhome/" + entryurladmin;
                } else {
                    entryurl = "" + reger.Vars.getHttpUrlPrefix() + userSession.getSiteRootUrl() + ":" + request.getLocalPort() + "/" + entryurl;
                    entryurladmin = "" + reger.Vars.getHttpUrlPrefix() + userSession.getSiteRootUrl() +  ":" + request.getLocalPort() + "/myhome/" + entryurladmin;
                }


				//How many chars to display?
				int displaycharsinsummary=userSession.getAccount().getDisplaycharsinsummary();
				if ((displaycharsinsummary<=0) || (displaycharsinsummary>=rsEvent[i][1].length())) {
					displaycharsinsummary=rsEvent[i][1].length();
				}
				//The Entry body
				String entrybody="";
				entrybody=rsEvent[i][1].substring(0,displaycharsinsummary);
				//Put line breaks in there
				//entrybody=replace(entrybody, VbCrlf  & VbCrlf, "<br><br>")
				entrybody=entrybody.replaceAll( reger.Vars.LINEBREAKCHAR, "<br><br>");
				//Add the More Link if needed
				if (rsEvent[i][1].length()>displaycharsinsummary){
					entrybody=entrybody + " ...<a href="+ entryurl +">More</a>";
				}

				//Get the message and image counts
				//This creates two extra Db calls per entry... very slow
				//Not happy about this code.
				int imagecount=0;
				int messagecount=0;
				if (!rsEvent[i][7].equals("")){
					imagecount=Integer.parseInt(rsEvent[i][7]);
				}
				if (!rsEvent[i][6].equals("")){
					messagecount=Integer.parseInt(rsEvent[i][6]);
				}

				//Author
//				author = rsEvent[i][8];
//				if (!rsEvent[i][9].equals("")){
//                    author = rsEvent[i][9];
//                }


				//Call the tRexEntry Engine
				String templateText = reger.template.AllTemplatesInSystem.getTemplateByTemplateid(userSession.getAccount().getEntlisttemplateid(), Template.TEMPLATETYPEENTRYLIST).getTemplate();

				//Try to override with specific template for log
				if(logid>0){
                    Log log = AllLogsInSystem.getLogByLogid(logid);
                    if (log.getEntlisttemplateid()>0){
                        templateText = reger.template.AllTemplatesInSystem.getTemplateByTemplateid(log.getEntlisttemplateid(), Template.TEMPLATETYPEENTRYLIST).getTemplate();
                    }
                }
			

                //If we're on edit.log and the logged-in user can't administer this logid then don't display the result.
                if (!thispagename.equals("entries.log")){
				    list.append( reger.template.EntryListTemplateProcessor.entryout(templateText, reger.core.TimeUtils.gmttousertime(rsEvent[i][3], userSession.getAccount().getTimezoneid()), rsEvent[i][0], entryurl, reger.core.Util.truncateString(rsEvent[i][1], userSession.getAccount().getDisplaycharsinsummary()), rsEvent[i][2], imagecount, messagecount, Integer.parseInt(rsEvent[i][8])));
                } else if ((thispagename.equals("entries.log") && userSession.getAccountuser().userCanViewLog(Integer.parseInt(rsEvent[i][5])))){
                    list.append( reger.template.EntryListTemplateProcessor.entryout(templateText, reger.core.TimeUtils.gmttousertime(rsEvent[i][3], userSession.getAccount().getTimezoneid()), rsEvent[i][0], entryurladmin, reger.core.Util.truncateString(rsEvent[i][1], userSession.getAccount().getDisplaycharsinsummary()), rsEvent[i][2], imagecount, messagecount, Integer.parseInt(rsEvent[i][8])));
                }
            }
		} else {
			list.append("<font class=bigfont face=arial size=+1>No entries found.</font><br>");
		}

		//Append the paginglinks to the bottom of the page
		if (displaypagingnumbers){
		    list.append(pagingLinks);
        }

		//Return StringBuffer to the caller
		return list;
	}



}