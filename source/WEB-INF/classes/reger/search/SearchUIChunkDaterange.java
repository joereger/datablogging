package reger.search;

import reger.core.Debug;

import java.util.Calendar;

/**
 * Date Range portion of searches
 */
public class SearchUIChunkDaterange implements SearchUIChunk{

    public String getName(){
        return "Dates";
    }

    public String getUniqueIdentifier() {
        return "chunk-daterange";
    }

    public String getPageTitle(){
        return "Find Entries in This Date Range:";
    }

    public StringBuffer getHtml(SearchEntries se, reger.UserSession userSession){
        StringBuffer mb = new StringBuffer();

        //A dropdown formatting string
        String dropdownstyle="style=\"font-family: Arial, Helvetica, sans-serif; font-size: 10px; color: #000000; background-color: #ffffff; border: #000000; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px\"";



        //All Time
        mb.append("<font face=arial size=-1>");
        mb.append("<input name=daterange type=radio value="+reger.Vars.DATERANGEALLTIME);
        if (se.getSearchParameters().daterange==reger.Vars.DATERANGEALLTIME){
            mb.append(" checked");
        }
        mb.append("> All Time");
        mb.append("<br>");

        //Last X
        mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGELASTXUNITS);
        if (se.getSearchParameters().daterange==reger.Vars.DATERANGELASTXUNITS){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("<select name=lastx "+dropdownstyle+">");
        for(int i=0; i<100; i++){
           mb.append("<option value="+i);
           if (se.getSearchParameters().lastx==i){
               mb.append(" selected");
           }
           if (i==0){
                mb.append(">This</option>");
           } else {
                mb.append(">Last "+i+"</option>");
           }
        }
        mb.append("</select>");

        //Last X units
        mb.append("<select name=lastxunits "+dropdownstyle+">");
        //Days
        mb.append("<option value='" + Calendar.DATE + "' ");
        if (se.getSearchParameters().lastxunits==Calendar.DATE){
            mb.append(" selected");
        }
        mb.append(">Day(s)</option>");
        //Weeks
        mb.append("<option value='" + Calendar.WEEK_OF_YEAR + "' ");
        if (se.getSearchParameters().lastxunits==Calendar.WEEK_OF_YEAR){
            mb.append(" selected");
        }
        mb.append(">Week(s)</option>");
        //Months
        mb.append("<option value='" + Calendar.MONTH + "' ");
        if (se.getSearchParameters().lastxunits==Calendar.MONTH){
            mb.append(" selected");
        }
        mb.append(">Month(s)</option>");
        //Years
        mb.append("<option value='" + Calendar.YEAR + "' ");
        if (se.getSearchParameters().lastxunits==Calendar.YEAR){
            mb.append(" selected");
        }
        mb.append(">Year(s)</option>");
        //End
        mb.append("</select>");
//        mb.append("<br>");
//        mb.append("<font face=arial size=-2 class=tinyfont>");
//        mb.append("Use 0 for Today, This Week, ");
//        mb.append("</font>");
//        mb.append("<font face=arial size=-1>");
        mb.append("<br>");

        //Convert from a Calendar object in the SearchParameters object to a set of individual fields
        Calendar now = Calendar.getInstance();
        if (userSession.getAccount()!=null){
            now = reger.core.TimeUtils.nowInUserTimezone(userSession.getAccount().getTimezoneid());
        }
        int daterangefromyyyy = now.get(Calendar.YEAR);
        int daterangefrommm = now.get(Calendar.MONTH);
        int daterangefromdd = now.get(Calendar.DATE);
        int daterangetoyyyy = now.get(Calendar.YEAR);
        int daterangetomm = now.get(Calendar.MONTH);
        int daterangetodd = now.get(Calendar.DATE);

        Calendar tmpFromCal = se.getSearchParameters().dateFromGmt;
        Calendar tmpToCal = se.getSearchParameters().dateToGmt;

        //Convert timezones
        if (userSession.getAccount()!=null){
            tmpFromCal = reger.core.TimeUtils.gmttousertime(tmpFromCal, userSession.getAccount().getTimezoneid());
            tmpToCal = reger.core.TimeUtils.gmttousertime(tmpToCal, userSession.getAccount().getTimezoneid());
        }

        if (tmpFromCal!=null){
            daterangefromyyyy = tmpFromCal.get(Calendar.YEAR);
            daterangefrommm = tmpFromCal.get(Calendar.MONTH);
            daterangefromdd = tmpFromCal.get(Calendar.DATE);
        }
        if (tmpToCal!=null){
            daterangetoyyyy = tmpToCal.get(Calendar.YEAR);
            daterangetomm = tmpToCal.get(Calendar.MONTH);
            daterangetodd = tmpToCal.get(Calendar.DATE);
        }

        //DateRange
        mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGESPECIFIED);
        if (se.getSearchParameters().daterange==reger.Vars.DATERANGESPECIFIED){
            mb.append(" checked");
        }
        mb.append("> Date Range:");
        mb.append("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From:<br>");
        mb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        mb.append("<select name=daterangefromyyyy "+dropdownstyle+">");
        for(int i=1900; i<=2010; i++){
           mb.append("<option value="+i);
           if (daterangefromyyyy==i){
               mb.append(" selected");
           }
           mb.append(">"+i+"</option>");
        }
        mb.append("</select>");
        mb.append(" / ");
        mb.append("<select name=daterangefrommm "+dropdownstyle+">");
        for(int i=1; i<=12; i++){
           mb.append("<option value="+i);
           if (daterangefrommm==i-1){
               mb.append(" selected");
           }
           mb.append(">"+i+"</option>");
        }
        mb.append("</select>");
        mb.append(" / ");
        mb.append("<select name=daterangefromdd "+dropdownstyle+">");
        for(int i=1; i<=31; i++){
           mb.append("<option value="+i);
           if (daterangefromdd==i){
               mb.append(" selected");
           }
           mb.append(">"+i+"</option>");
        }
        mb.append("</select>");
        mb.append("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To:<br>");
        mb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        mb.append("<select name=daterangetoyyyy "+dropdownstyle+">");
        for(int i=1900; i<=2010; i++){
           mb.append("<option value="+i);
           if (daterangetoyyyy==i){
               mb.append(" selected");
           }
           mb.append(">"+i+"</option>");
        }
        mb.append("</select>");
        mb.append(" / ");
        mb.append("<select name=daterangetomm "+dropdownstyle+">");
        for(int i=1; i<=12; i++){
           mb.append("<option value="+i);
           if (daterangetomm==i-1){
               mb.append(" selected");
           }
           mb.append(">"+i+"</option>");
        }
        mb.append("</select>");
        mb.append(" / ");
        mb.append("<select name=daterangetodd "+dropdownstyle+">");
        for(int i=1; i<=31; i++){
           mb.append("<option value="+i);
           if (daterangetodd==i){
               mb.append(" selected");
           }
           mb.append(">"+i+"</option>");
        }
        mb.append("</select>");
        mb.append("<br>");
        mb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        if (userSession.getAccount()!=null){
            mb.append("Timezone: "+userSession.getAccount().getTimezoneid());
        } else {
            mb.append("Timezone: GMT");
        }
        mb.append("</font>");


        return mb;
    }

    public SearchEntries processRequest(SearchEntries se, javax.servlet.http.HttpServletRequest request, reger.UserSession userSession){
        //Date fields start
        se.getSearchParameters().daterange=reger.Vars.DATERANGEALLTIME;
        if (request.getParameter("daterange")!=null && reger.core.Util.isinteger(request.getParameter("daterange"))){
            se.getSearchParameters().daterange=Integer.parseInt(request.getParameter("daterange"));
        }
        se.getSearchParameters().lastx=0;
        if (request.getParameter("lastx")!=null && reger.core.Util.isinteger(request.getParameter("lastx"))){
            se.getSearchParameters().lastx=Integer.parseInt(request.getParameter("lastx"));
        }
        se.getSearchParameters().lastxunits=Calendar.DATE;
        if (request.getParameter("lastxunits")!=null && reger.core.Util.isinteger(request.getParameter("lastxunits"))){
            se.getSearchParameters().lastxunits=Integer.parseInt(request.getParameter("lastxunits"));
        }
        int daterangefromyyyy=Calendar.getInstance().get(Calendar.YEAR)-1;
        if (request.getParameter("daterangefromyyyy")!=null && reger.core.Util.isinteger(request.getParameter("daterangefromyyyy"))){
            daterangefromyyyy=Integer.parseInt(request.getParameter("daterangefromyyyy"));
        }
        int daterangefrommm=Calendar.getInstance().get(Calendar.MONTH)+1;
        if (request.getParameter("daterangefrommm")!=null && reger.core.Util.isinteger(request.getParameter("daterangefrommm"))){
            daterangefrommm=Integer.parseInt(request.getParameter("daterangefrommm"));
        }
        int daterangefromdd=Calendar.getInstance().get(Calendar.DATE);
        if (request.getParameter("daterangefromdd")!=null && reger.core.Util.isinteger(request.getParameter("daterangefromdd"))){
            daterangefromdd=Integer.parseInt(request.getParameter("daterangefromdd"));
        }
        int daterangetoyyyy=Calendar.getInstance().get(Calendar.YEAR);
        if (request.getParameter("daterangetoyyyy")!=null && reger.core.Util.isinteger(request.getParameter("daterangetoyyyy"))){
            daterangetoyyyy=Integer.parseInt(request.getParameter("daterangetoyyyy"));
        }
        int daterangetomm=Calendar.getInstance().get(Calendar.MONTH)+1;
        if (request.getParameter("daterangetomm")!=null && reger.core.Util.isinteger(request.getParameter("daterangetomm"))){
            daterangetomm=Integer.parseInt(request.getParameter("daterangetomm"));
        }
        int daterangetodd=Calendar.getInstance().get(Calendar.DATE);
        if (request.getParameter("daterangetodd")!=null && reger.core.Util.isinteger(request.getParameter("daterangetodd"))){
            daterangetodd=Integer.parseInt(request.getParameter("daterangetodd"));
        }
        //Convert the dates to GMT time
        Calendar dateFrom = reger.core.TimeUtils.formtocalendar(daterangefromyyyy, daterangefrommm, daterangefromdd, 0, 0, 0, "am");
        if (userSession.getAccount()!=null){
            dateFrom = reger.core.TimeUtils.usertogmttime(dateFrom, userSession.getAccount().getTimezoneid());
        }
        Debug.debug(5, "", "SearchUIChunkDateRange.java - processing inbound date - dateFromGmt=<br>" + reger.core.TimeUtils.dateformatfordb(dateFrom));
        se.getSearchParameters().dateFromGmt = dateFrom;
        Calendar dateTo = reger.core.TimeUtils.formtocalendar(daterangetoyyyy, daterangetomm, daterangetodd, 23, 59, 59, "pm");
        if (userSession.getAccount()!=null){
            dateTo = reger.core.TimeUtils.usertogmttime(dateTo, userSession.getAccount().getTimezoneid());
        }
        Debug.debug(5, "", "SearchUIChunkDateRange.java - processing inbound date - dateToGmt=<br>" + reger.core.TimeUtils.dateformatfordb(dateTo));
        se.getSearchParameters().dateToGmt = dateTo;
        //Date fields end
        return se;
    }


}
