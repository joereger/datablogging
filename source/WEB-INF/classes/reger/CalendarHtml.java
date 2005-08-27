package reger;

import java.util.Calendar;

/**
 * Displays calendars as html
 */
public class CalendarHtml {

    public static StringBuffer smallcalendar(int calendartype, String viewmonth, int logid, String thispagename, reger.UserSession userSession) {

        StringBuffer sc = new StringBuffer();

        //Get default date in case no viewmonth was provided
        Calendar nowTmp = Calendar.getInstance();
        nowTmp=reger.core.TimeUtils.convertFromOneTimeZoneToAnother(nowTmp, nowTmp.getTimeZone().getID(), userSession.getAccount().getTimezoneid());
        int year=nowTmp.get(Calendar.YEAR);
        int month=nowTmp.get(Calendar.MONTH);

        //Override if we have a nice viewmonth. Convert "2003-12-23" to ints.
        if (viewmonth!=null && !viewmonth.equals("") && reger.core.Util.isinteger(viewmonth.substring(0,4))){
            year=Integer.parseInt(viewmonth.substring(0,4));
        }
        if (viewmonth!=null && !viewmonth.equals("") && reger.core.Util.isinteger(viewmonth.substring(5,7))){
            month=Integer.parseInt(viewmonth.substring(5,7))-1;
        }

        //Convert incoming date into a calendar
        Calendar startdate = Calendar.getInstance();
        startdate.set(year, month, 15, 0, 0, 0);

        //Find the start of the month
        startdate=reger.core.TimeUtils.xMonthsAgoStart(startdate, 0);


        //Convert incoming date into a calendar
        Calendar enddate = Calendar.getInstance();
        enddate.set(year, month, 15, 0, 0, 0);

        //Find the start of the month
        enddate=reger.core.TimeUtils.xMonthsAgoEnd(enddate, 0);


        //Call the plugin
        reger.CalendarHtmlPlugin plugin = new CalendarHtmlPlugin(calendartype, startdate, enddate, logid, userSession, thispagename);
        if (calendartype==reger.Vars.CALENDARTYPEEMPTYEVENTFINDER){
            plugin = new reger.CalendarHtmlPlugin(calendartype, startdate, enddate, logid, userSession, thispagename);
        } else if (calendartype==reger.Vars.CALENDARTYPEEMPTYEVENTLINKS){
            plugin = new reger.CalendarHtmlPlugin(calendartype, startdate, enddate, logid, userSession, thispagename);
        }


        //Setup some vars
        Calendar dDate;
        int iDOW;
        int iCurrent;
        int iDIM;
        int iPosition;
        String thisdate="";
        int cellOnFlag=0;
        String inCell="";

        //The main date variable that is iterated to create the calendar
        dDate = (Calendar)startdate.clone();

        //Now we've got the date.  Now get Days in the choosen month and the day of the week it starts on.
        iDIM = reger.core.TimeUtils.GetDaysInMonth(dDate.get(Calendar.MONTH), dDate.get(Calendar.YEAR));
        iDOW = reger.core.TimeUtils.GetWeekdayMonthStartsOn(dDate.get(Calendar.MONTH), dDate.get(Calendar.YEAR));

        //Start the html
        sc.append("<TABLE BORDER=0 CELLSPACING=1 CELLPADDING=1 class=sidecolunit>");
        sc.append("<TR>");
        sc.append("<td class=sidecolheader  ALIGN='center' COLSPAN=7>");

        //Need to calculate the month/year integers for last month and next month
        String thismonthname = reger.core.TimeUtils.monthname(dDate);

        int thisyear = dDate.get(Calendar.YEAR);

        //Tmpcal for finding links to next and prev months
        Calendar tmpcal;

        //Drop back to last month
        tmpcal = (Calendar)startdate.clone();
        tmpcal.add(Calendar.MONTH, -1);
        String viewdatelastmonth = reger.core.TimeUtils.dateformatdate(tmpcal);

        //Zoom ahead to next month
        tmpcal = (Calendar)startdate.clone();
        tmpcal.add(Calendar.MONTH, 1);
        String viewdatenextmonth = reger.core.TimeUtils.dateformatdate(tmpcal);

        //The month name and next/previous links
        sc.append("<a href='" + thispagename + "?logid=" + logid + "&viewmonth="  + viewdatelastmonth + "'><</a> ");
        sc.append(thismonthname + "  " + thisyear);
        sc.append("<a href='" + thispagename + "?logid=" + logid + "&viewmonth="  + viewdatenextmonth + "'>></a> ");
        sc.append("</TD>");
        sc.append("</TR>");

        //The day names
        sc.append("<TR>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=14%>Sun</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=14%>Mon</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=14%>Tue</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=14%>Wed</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=14%>Thu</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=14%>Fri</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=14%>Sat</TD>");
        sc.append("</TR>");

        //Write spacer cells at beginning of first row if month doesn't start on a Sunday.
        if (iDOW != 1) {
            sc.append("<TR>");
            iPosition = 1;
            while (iPosition < iDOW) {
                sc.append("<TD width=14% ></TD>");
                iPosition = iPosition + 1;
            }
        }

        //Write days of month in proper day slots
        iCurrent = 1;
        iPosition = iDOW;
        while (iCurrent <= iDIM) {
            //If we're at the begginning of a row then write TR
            if (iPosition == 1) {
                sc.append("<TR>");
            }

            //Get a simple string from the current date
            thisdate=reger.core.TimeUtils.dateformatdate(dDate);

            //See if we have anything to put inside this cell
//            if (plugin.cellHtml.get(thisdate)!=null) {
//                cellOnFlag=cellOnFlag+1;
//                inCell=(String)plugin.cellHtml.get(thisdate);
//            } else {
//                cellOnFlag=0;
//                inCell="";
//            }

            //If the day we're writing is the selected day then highlight it somehow.
//            if (cellOnFlag >= 1) {
//                sc.append("<TD class=calendardayboxtoday BGCOLOR=#ffffcc valign=top width=25><a href='" + thispagename + "?logid=" + logid + "&viewdate="+ year +"-"+reger.core.Util.prefillZeroes(String.valueOf(month+1), 2)+"-"+reger.core.Util.prefillZeroes(String.valueOf(iCurrent), 2)+"'>" + iCurrent + "</a><br>"+inCell+"</TD>");
//            } else {
//                sc.append("<TD class=calendardaybox valign=top>" + iCurrent + "<BR>"+inCell+"</TD>");
//            }

            //Append the correct cell
            if (plugin.cellHtml.get(thisdate)!=null){
                sc.append((String)plugin.cellHtml.get(thisdate) + reger.Vars.LINEBREAKCHARFOREMAIL);
            } else {
                sc.append("<TD class=calendardaybox width=14% valign=top>" + iCurrent + "<BR></TD>" + reger.Vars.LINEBREAKCHARFOREMAIL);
            }

            //If we're at the endof a row then write /TR
            if (iPosition == 7) {
                sc.append("</TR>");
                iPosition = 0;
            }

            //Increment variables
            iCurrent = iCurrent + 1;
            iPosition = iPosition + 1;
            dDate.add(Calendar.DATE, 1);
        }

        //Write spacer cells at end of last row if month doesn't end on a Saturday.
        if (iPosition != 1) {
            while (iPosition <= 7) {
                sc.append("<TD width=14% ></TD>");
                iPosition = iPosition + 1;
            }
            sc.append("</TR>");
        }

        //@todo Implement this Expand Calendar link outside of this class
        if (calendartype==reger.Vars.CALENDARTYPEEMPTYEVENTFINDER){
            sc.append("<tr><td ALIGN=center COLSPAN=7>");
            sc.append("<a href='calendar.log'><font face=arial size=-2>Expand Calendar</font>");
            sc.append("</td></tr>");
        }

        sc.append("</TABLE>");



        return sc;
    }






}
