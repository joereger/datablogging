package reger;

import reger.core.db.Db;

import java.util.Calendar;

/**
 * This class represents a timeperiod.  A time period is just that,
 * a period in time.  A start and an end.
 */
public class TimePeriod {

    private int timeperiodid = -1;
    private int accountid;

    //Dates are stored here in GMT
    private java.util.Calendar startDateGMT;
    private java.util.Calendar endDateGMT;
    private String title;
    private String description;
    private int isPrivate;
    private int isOpenEnded;


    //These are all in user or site timezoneid
    private int startMonth = 1;
    private int startDay = 1;
    private int startYear = 2004;
    private int startHour = 1;
    private int startMin = 1;
    private String startAmpm = "am";

    private int endMonth = 1;
    private int endDay = 1;
    private int endYear = 2004;
    private int endHour = 1;
    private int endMin = 1;
    private String endAmpm = "am";

    //Reger.UserSession
    reger.UserSession userSession = null;

    /**
     * Load the time period from the database.
     */
    public TimePeriod(int timeperiodid, reger.UserSession userSession){
        this.userSession = userSession;
        this.timeperiodid = timeperiodid;
        //-----------------------------------
        //-----------------------------------
        String[][] rstTp= Db.RunSQL("SELECT accountid, startDate, endDate, description, isPrivate, title, isopenended FROM timeperiod WHERE timeperiodid='"+timeperiodid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTp!=null && rstTp.length>0){
        	this.accountid = Integer.parseInt(rstTp[0][0]);
            this.startDateGMT = reger.core.TimeUtils.dbstringtocalendar(rstTp[0][1]);
            this.endDateGMT = reger.core.TimeUtils.dbstringtocalendar(rstTp[0][2]);
            this.description = rstTp[0][3];
            this.isPrivate = Integer.parseInt(rstTp[0][4]);
            this.title = rstTp[0][5];
            this.isOpenEnded = Integer.parseInt(rstTp[0][6]);

            if (isOpenEnded==1){
                this.endDateGMT = reger.core.TimeUtils.nowInUserTimezone("GMT");
            }

            //reger.core.Util.logtodb("In DB:<br>startDateGMT: " + rstTp[0][1] + "<br>endDateGMT: " + rstTp[0][2]);

            populateStartTimeFromCal(startDateGMT);
            populateEndTimeFromCal(endDateGMT);
        }
    }

    /**
     * Construct a time period.  Not yet saved to DB.
     */
    public TimePeriod(int timeperiodid, int accountid, java.util.Calendar startDateGMT, java.util.Calendar endDateGMT, String description, int isPrivate, String title, int isOpenEnded, reger.UserSession userSession){
        this.userSession = userSession;
        this.timeperiodid = timeperiodid;
        this.accountid = accountid;
        this.startDateGMT = startDateGMT;
        this.endDateGMT = endDateGMT;
        this.description = description;
        this.isPrivate = isPrivate;
        this.title = title;
        this.isOpenEnded=isOpenEnded;

        populateStartTimeFromCal(startDateGMT);
        populateEndTimeFromCal(endDateGMT);
    }

    /**
     * Construct a time period.  Not yet saved to DB.
     */
    public TimePeriod(int accountid, java.util.Calendar startDateGMT, java.util.Calendar endDateGMT, String description, int isPrivate, String title, int isOpenEnded, reger.UserSession userSession){
        this.userSession = userSession;
        this.accountid = accountid;
        this.startDateGMT = startDateGMT;
        this.endDateGMT = endDateGMT;
        this.description = description;
        this.isPrivate = isPrivate;
        this.title = title;
        this.isOpenEnded = isOpenEnded;

        populateStartTimeFromCal(startDateGMT);
        populateEndTimeFromCal(endDateGMT);
    }

    /**
     * Construct a time period using a request from a form.  Not yet saved to DB.
     */
    public TimePeriod(int accountid, javax.servlet.http.HttpServletRequest request, reger.UserSession userSession){
        this.userSession = userSession;
        populateFromRequest(request);
        this.accountid = accountid;
        this.startDateGMT = reger.core.TimeUtils.formtocalendar(startYear, startMonth+1, startDay, startHour, startMin, 0, startAmpm);
        this.endDateGMT = reger.core.TimeUtils.formtocalendar(endYear, endMonth+1, endDay, endHour, endMin, 0, endAmpm);
        this.startDateGMT = reger.core.TimeUtils.usertogmttime(this.startDateGMT, userSession.getAccount().getTimezoneid());
        this.endDateGMT = reger.core.TimeUtils.usertogmttime(this.endDateGMT, userSession.getAccount().getTimezoneid());

    }

    /**
     * Save the timeperiod to the database.  If it's already in the DB it'll be updated.  If not, it'll be created.
     */
    public String save(){
        String errortext = "";

        if (reger.core.DateDiff.dateDiff("second", endDateGMT, startDateGMT)<0){
            java.util.Calendar tmpStart = (java.util.Calendar)startDateGMT.clone();
            java.util.Calendar tmpEnd = (java.util.Calendar)endDateGMT.clone();
            startDateGMT = tmpEnd;
            endDateGMT = tmpStart;
        }

        if (title==null || title.equals("")){
            title = reger.core.TimeUtils.dateformatfordb(startDateGMT) + " - " + reger.core.TimeUtils.dateformatfordb(endDateGMT);
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstTp= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE timeperiodid='"+timeperiodid+"' AND accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTp!=null && rstTp.length>0){
            //The record already exists, we just need to update
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE timeperiod SET startDate='"+reger.core.TimeUtils.dateformatfordb(startDateGMT)+"', endDate='"+reger.core.TimeUtils.dateformatfordb(endDateGMT)+"', description='"+reger.core.Util.cleanForSQL(description)+"', isprivate='"+isPrivate+"', title='"+reger.core.Util.cleanForSQL(title)+"', isopenended='"+isOpenEnded+"' WHERE timeperiodid='"+timeperiodid+"' AND accountid='"+accountid+"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //Need to insert a new one
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO timeperiod(accountid, startDate, endDate, description, isprivate, title, isopenended) VALUES('"+accountid+"', '"+reger.core.TimeUtils.dateformatfordb(startDateGMT)+"', '"+reger.core.TimeUtils.dateformatfordb(endDateGMT)+"', '"+reger.core.Util.cleanForSQL(description)+"', '"+isPrivate+"', '"+reger.core.Util.cleanForSQL(title)+"', '"+isOpenEnded+"')");
            //-----------------------------------
            //-----------------------------------
            this.timeperiodid = identity;

            //Update the AccountCounts cache
            reger.cache.AccountCountCache.flushByAccountid(accountid);
        }

        return errortext;
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM timeperiod WHERE timeperiodid='"+timeperiodid+"' AND accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        //Update the AccountCounts cache
        reger.cache.AccountCountCache.flushByAccountid(accountid);
    }



    public String getHtml(boolean displayasadmin, String action){
        StringBuffer mb = new StringBuffer();



        if (displayasadmin){
            mb.append("<form action=timeperiods.log method=post>");
            mb.append("<input type=hidden name=action value=\""+action+"\">");
            mb.append("<input type=hidden name=timeperiodid value='"+timeperiodid+"'>");
        }


        mb.append("<table cellpadding=5 cellspacing=1 width=100% border=0>");


        mb.append("<tr>");
        mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3>");
        mb.append("<font face=arial size=+3>Start</font>");
        mb.append("</td>");
        mb.append("<td bgcolor='#ffffff' width=60% align=left valign=top>");
        mb.append("<font face=arial size=-1> </font>");
        mb.append("</td>");
        mb.append("<td bgcolor='#ffffff' align=right valign=top colspan=3>");
        mb.append("<font face=arial size=+3>End</font>");
        mb.append("</td>");
        mb.append("</tr>");


        mb.append("<tr>");
        //StartMonth
        mb.append("<td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin){
            mb.append("<select name='startMonth'>");
            for(int i=0; i<=11; i++){
                mb.append("<option value='" + i + "' ");
                if (i==startMonth) {
                    mb.append("selected");
                }
                mb.append(">" + (i+1) + "</option>");
            }
            mb.append("</select>");
        } else {
            mb.append((startMonth+1));
        }
        mb.append("<br><font face=arial size=-2 class=smallfont>Month</font></td>");

        //StartDay
        mb.append("<td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin) {
            mb.append("<select name='startDay'>");
            for(int i=1; i<=31; i++){
                mb.append("<option value='" + i + "' ");
                if (i==startDay) {
                    mb.append("selected");
                }
                mb.append(">" + i + "</option>");
            }
            mb.append("</select>");
        } else {
            mb.append(startDay);
        }
        mb.append("<br><font face=arial size=-2 class=smallfont>Day</font></td>");

        //StartYear
        mb.append("<td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin) {
            mb.append("<select name='startYear'>");
            for(int i=1900; i<=2020; i++){
                mb.append("<option value='" + i + "' ");
                if (i==startYear) {
                    mb.append("selected");
                }
                mb.append(">" + i + "</option>");
            }
            mb.append("</select>");
        } else {
            mb.append(startYear);
        }
        mb.append("<br><font face=arial size=-2 class=smallfont>Year</font></td>");

        //Title & Description
        mb.append("<td bgcolor='#ffffff' align=left valign=top rowspan=3>");

        if (displayasadmin) {
            mb.append("<font face=arial size=-1>");
            mb.append("<b>Time Period Title:</b> (Required)<br>");
            mb.append("<input type=text name=title value=\""+reger.core.Util.cleanForHtml(title)+"\" size=25 maxlength=255>");
            mb.append("</font>");
        } else {
            mb.append(reger.core.Util.cleanForHtml(title));
        }

        mb.append("<br>");

        if (displayasadmin) {
            mb.append("<font face=arial size=-1>");
            mb.append("<b>Description:</b> (Optional) <br>");
            mb.append("<textarea name=description cols=35 rows=5 style='width: 100%'>");
            mb.append(description);
            mb.append("</textarea>");
            mb.append("</font>");
        } else {
            mb.append("<font face=arial size=-2>");
            mb.append(reger.core.Util.cleanForHtml(description));
            mb.append("</font>");
        }
        mb.append("<br><font face=arial size=-1>");
        if (displayasadmin){
            mb.append("<input type=checkbox name=isprivate value=1");
            if (isPrivate==1){
                mb.append(" checked");
            }
            mb.append("> Private?");
        }
        mb.append("</font>");
        //mb.append("<br>");
        //mb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;");
        mb.append("</font>");
        mb.append("</td>");







        //EndMonth
        mb.append("<td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin){
            mb.append("<select name='endMonth'>");
            for(int i=0; i<=11; i++){
                mb.append("<option value='" + i + "' ");
                if (i==endMonth) {
                    mb.append("selected");
                }
                mb.append(">" + (i+1) + "</option>");
            }
            mb.append("</select>");
        } else {
            mb.append((endMonth+1));
        }
        mb.append("<br><font face=arial size=-2 class=smallfont>Month</font></td>");

        //EndDay
        mb.append("<td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin) {
            mb.append("<select name='endDay'>");
            for(int i=1; i<=31; i++){
                mb.append("<option value='" + i + "' ");
                if (i==endDay) {
                    mb.append("selected");
                }
                mb.append(">" + i + "</option>");
            }
            mb.append("</select>");
        } else {
            mb.append(endDay);
        }
        mb.append("<br><font face=arial size=-2 class=smallfont>Day</font></td>");

        //EndYear
        mb.append("<td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin) {
            mb.append("<select name='endYear'>");
            for(int i=1900; i<=2020; i++){
                mb.append("<option value='" + i + "' ");
                if (i==endYear) {
                    mb.append("selected");
                }
                mb.append(">" + i + "</option>");
            }
            mb.append("</select>");
        } else {
            mb.append(endYear);
        }
        mb.append("<br><font face=arial size=-2 class=smallfont>Year</font></td>");






        mb.append("</tr>");










        //StartHour
        mb.append("<tr><td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin) {
            mb.append("<select name='startHour'>");
            int h=startHour;
            if (h>=13) {
                h=h-12;
            } else if (h==0){
                h=12;
            }
            for(int i=1; i<=12; i++){
                mb.append("<option value='" + i + "' ");
                if (i==h) {
                    mb.append("selected");
                }
                mb.append(">" + i + "</option>");
            }
            mb.append("</select>");
        } else {
            int h=startHour;
            if (h>=13) {
                h=h-12;
            } else if (h==0){
                h=12;
            }
            mb.append(h);
        }
        mb.append("<br><font face=arial size=-2 class=smallfont>Hour</font></td>");

        //StartMinute
        mb.append("<td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin) {
            mb.append("<select name='startMin'>");
            for(int i=0; i<=59; i++){
                mb.append("<option value='" + i + "' ");
                if (i==startMin) {
                    mb.append("selected");
                }
                mb.append(">" + i + "</option>");
            }
            mb.append("</select>");
        } else {
            mb.append(startMin);
        }
        mb.append("<br><font face=arial size=-2 class=smallfont>Minute</font></td>");

        //StartAMPM
        mb.append("<td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin) {
            mb.append("<select name='startAmpm'>");
            mb.append("<option value='AM' ");
            if (startAmpm!=null && startAmpm.equals("AM")) {
                mb.append("selected");
            }
            mb.append(">AM</option>");
            mb.append("<option value='PM' ");
            if (startAmpm!=null && startAmpm.equals("PM")) {
                mb.append("selected");
            }
            mb.append(">PM</option>");
            mb.append("</select>");
        } else {
            if (startAmpm!=null && startAmpm.equals("AM")) {
                mb.append("AM");
            } else {
                mb.append("PM");
            }
        }



        mb.append("</td>");










        //EndHour
        mb.append("<td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin) {
            mb.append("<select name='endHour'>");
            int h=endHour;
            if (h>=13) {
                h=h-12;
            } else if (h==0){
                h=12;
            }
            for(int i=1; i<=12; i++){
                mb.append("<option value='" + i + "' ");
                if (i==h) {
                    mb.append("selected");
                }
                mb.append(">" + i + "</option>");
            }
            mb.append("</select>");
        } else {
            int h=endHour;
            if (h>=13) {
                h=h-12;
            } else if (h==0){
                h=12;
            }
            mb.append(h);
        }
        mb.append("<br><font face=arial size=-2 class=smallfont>Hour</font></td>");

        //EndMinute
        mb.append("<td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin) {
            mb.append("<select name='endMin'>");
            for(int i=0; i<=59; i++){
                mb.append("<option value='" + i + "' ");
                if (i==endMin) {
                    mb.append("selected");
                }
                mb.append(">" + i + "</option>");
            }
            mb.append("</select>");
        } else {
            mb.append(endMin);
        }
        mb.append("<br><font face=arial size=-2 class=smallfont>Minute</font></td>");

        //EndAMPM
        mb.append("<td bgcolor='#cccccc' align=left valign=top>");
        if (displayasadmin) {
            mb.append("<select name='endAmpm'>");
            mb.append("<option value='AM' ");
            if (endAmpm!=null && endAmpm.equals("AM")) {
                mb.append("selected");
            }
            mb.append(">AM</option>");
            mb.append("<option value='PM' ");
            if (endAmpm!=null && endAmpm.equals("PM")) {
                mb.append("selected");
            }
            mb.append(">PM</option>");
            mb.append("</select>");
        } else {
            if (endAmpm!=null && endAmpm.equals("AM")) {
                mb.append("AM");
            } else {
                mb.append("PM");
            }
        }



        mb.append("</td>");
        mb.append("</tr>");


        //isOpenEnded Row
        mb.append("<tr>");
        mb.append("<td bgcolor='#cccccc' align=left colspan=3 valign=top>");
        mb.append("<font face=arial size=-2>");
        mb.append(userSession.getAccount().getTimezoneid());
        mb.append("</font>");
        mb.append("<br>");
        mb.append("</td>");
        mb.append("<td bgcolor='#cccccc' align=left colspan=3 valign=top>");
        mb.append("<font face=arial size=-2>");
        mb.append(userSession.getAccount().getTimezoneid());
        mb.append("</font>");
        mb.append("<br><br>");
        if (displayasadmin){
            mb.append("<font face=arial size=-1>");
            mb.append("<input type=checkbox name=isopenended value=1 ");
            if (isOpenEnded==1){
                mb.append(" checked");
            }
            mb.append(">");
            mb.append("Open Ended?");
            mb.append("</font>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append("Open ended time periods don't yet have an end date.  They represent time periods that are contemporary and always extend to the current date/time automatically.");
            mb.append("</font>");
        } else {
            if (isOpenEnded==1){
                mb.append("<font face=arial size=-1>");
                mb.append("This time period is Open Ended.");
                mb.append("</font>");
            }
        }
        mb.append("</td>");
        mb.append("</tr>");


        mb.append("<tr>");
        mb.append("<td bgcolor='#ffffff' align=center valign=top colspan=7>");

        if (displayasadmin){
            mb.append("<br>");
            mb.append("<input type=submit value='Save Time Period'>");
        }

        if (displayasadmin && timeperiodid>0){
            mb.append("<br>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append("<a href='timeperiods.log?action=delete&timeperiodid="+timeperiodid+"'>");
            mb.append("Delete this Time Period");
            mb.append("</a>");
            mb.append("</font>");
        }

        mb.append("</td>");
        mb.append("</tr>");


        if (displayasadmin){
            mb.append("</form>");
        }

        mb.append("</table>");


        return mb.toString();
    }


    /*
	* Populates this object's h,m,ampm,mm,dd,yyyy with values from a calendar
	*/
	public void populateStartTimeFromCal(Calendar cal) {

	        Calendar c2 = reger.core.TimeUtils.gmttousertime(cal, userSession.getAccount().getTimezoneid());
            String date = reger.core.TimeUtils.dateformatfordb(c2);

	        //Date, ugly way
	        //2004-02-05 12:44:31
	        startHour=Integer.parseInt(date.substring(11,13));
			startMin=Integer.parseInt(date.substring(14,16));
			startMonth = Integer.parseInt(date.substring(5,7))-1;
			startDay = Integer.parseInt(date.substring(8,10));
			startYear = Integer.parseInt(date.substring(0,4));

			if (startHour>=13){
                startAmpm = "PM";
                startHour=startHour-12;
            } else if (startHour==12){
                startAmpm = "PM";
                startHour=12;
            } else if (startHour==0){
                startAmpm = "AM";
                startHour=12;
            } else {
                startAmpm = "AM";
                startHour=startHour;
            }

            //reger.core.Util.logtodb("Start Time is set by cal=" + reger.core.TimeUtils.dateformatfordb(cal));

	}

	/*
	* Populates this object's h,m,ampm,mm,dd,yyyy with values from a calendar
	*/
	public void populateEndTimeFromCal(Calendar cal) {

	        Calendar c2 = reger.core.TimeUtils.gmttousertime(cal, userSession.getAccount().getTimezoneid());
            String date = reger.core.TimeUtils.dateformatfordb(c2);

	        //Date, ugly way
	        //2004-02-05 12:44:31
	        endHour=Integer.parseInt(date.substring(11,13));
			endMin=Integer.parseInt(date.substring(14,16));
			endMonth = Integer.parseInt(date.substring(5,7))-1;
			endDay = Integer.parseInt(date.substring(8,10));
			endYear = Integer.parseInt(date.substring(0,4));

			if (endHour>=13){
                endAmpm = "PM";
                endHour=endHour-12;
            } else if (endHour==12){
                endAmpm = "PM";
                endHour=12;
            } else if (endHour==0){
                endAmpm = "AM";
                endHour=12;
            } else {
                endAmpm = "AM";
                endHour=endHour;
            }

	}



	private void populateFromRequest(javax.servlet.http.HttpServletRequest request){
        //Main vars
        if (request.getParameter("description")!=null && !request.getParameter("description").equals("")) {
            description=request.getParameter("description");
        }
        if (request.getParameter("title")!=null && !request.getParameter("title").equals("")) {
            title=request.getParameter("title");
        }
        if (request.getParameter("isprivate")!=null && reger.core.Util.isinteger(request.getParameter("isprivate"))) {
            isPrivate=Integer.parseInt(request.getParameter("isprivate"));
        }
        if (request.getParameter("timeperiodid")!=null && reger.core.Util.isinteger(request.getParameter("timeperiodid"))) {
            timeperiodid=Integer.parseInt(request.getParameter("timeperiodid"));
        }
        if (request.getParameter("isopenended")!=null && reger.core.Util.isinteger(request.getParameter("isopenended"))) {
            isOpenEnded=Integer.parseInt(request.getParameter("isopenended"));
        }

        //Start Vars
        if (request.getParameter("startMonth")!=null && reger.core.Util.isinteger(request.getParameter("startMonth"))) {
            startMonth=Integer.parseInt(request.getParameter("startMonth"));
        }
        if (request.getParameter("startDay")!=null && reger.core.Util.isinteger(request.getParameter("startDay"))) {
            startDay=Integer.parseInt(request.getParameter("startDay"));
        }
        if (request.getParameter("startYear")!=null && reger.core.Util.isinteger(request.getParameter("startYear"))) {
            startYear=Integer.parseInt(request.getParameter("startYear"));
        }
        if (request.getParameter("startHour")!=null && reger.core.Util.isinteger(request.getParameter("startHour"))) {
            startHour=Integer.parseInt(request.getParameter("startHour"));
        }
        if (request.getParameter("startMin")!=null && reger.core.Util.isinteger(request.getParameter("startMin"))) {
            startMin=Integer.parseInt(request.getParameter("startMin"));
        }
        if (request.getParameter("startAmpm")!=null) {
            startAmpm=request.getParameter("startAmpm");
        }

        //End Vars
        if (request.getParameter("endMonth")!=null && reger.core.Util.isinteger(request.getParameter("endMonth"))) {
            endMonth=Integer.parseInt(request.getParameter("endMonth"));
        }
        if (request.getParameter("endDay")!=null && reger.core.Util.isinteger(request.getParameter("endDay"))) {
            endDay=Integer.parseInt(request.getParameter("endDay"));
        }
        if (request.getParameter("endYear")!=null && reger.core.Util.isinteger(request.getParameter("endYear"))) {
            endYear=Integer.parseInt(request.getParameter("endYear"));
        }
        if (request.getParameter("endHour")!=null && reger.core.Util.isinteger(request.getParameter("endHour"))) {
            endHour=Integer.parseInt(request.getParameter("endHour"));
        }
        if (request.getParameter("endMin")!=null && reger.core.Util.isinteger(request.getParameter("endMin"))) {
            endMin=Integer.parseInt(request.getParameter("endMin"));
        }
        if (request.getParameter("endAmpm")!=null) {
            endAmpm=request.getParameter("endAmpm");
        }
    }




    public int getTimeperiodid() {
        return timeperiodid;
    }


    public int getAccountid() {
        return accountid;
    }


    public java.util.Calendar getStartDateGMT() {
        return startDateGMT;
    }


    public java.util.Calendar getEndDateGMT() {
        return endDateGMT;
    }


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }


    public int getPrivate() {
        return isPrivate;
    }

    public String getTimePeriodRowHtml(Calendar lowestDateGMT, Calendar highestDateGMT, Calendar boundaryDateGMT, String pathToAppRoot, int widthInPixels, reger.UserSession userSession){
        StringBuffer mb = new StringBuffer();

        widthInPixels = 100;

        if (isOpenEnded==1){
            endDateGMT = reger.core.TimeUtils.nowInUserTimezone("GMT");
        }

        boolean startIsBeforeLowestDate = false;
        if (startDateGMT.before(lowestDateGMT)){
            startIsBeforeLowestDate = true;
            startDateGMT = lowestDateGMT;
        }

        boolean endIsAfterHighestDate = false;
        if (endDateGMT.after(highestDateGMT)){
            endIsAfterHighestDate = true;
            endDateGMT = highestDateGMT;
        }

        if (boundaryDateGMT==null){
            boundaryDateGMT = (Calendar)endDateGMT.clone();
        }

        // leftPadding - centerLeft - centerRight - rightPadding

        //Get number of seconds in the whole chart
        int totalSecondsInTimeline = reger.core.DateDiff.dateDiff("second", highestDateGMT, lowestDateGMT);

        //leftPadding
        int leftPaddingSeconds = reger.core.DateDiff.dateDiff("second", startDateGMT, lowestDateGMT);
        int leftPaddingPixels = (int)((new Double(leftPaddingSeconds).doubleValue()/new Double(totalSecondsInTimeline).doubleValue()) * widthInPixels);

        //centerLeft
        int centerLeftSeconds = reger.core.DateDiff.dateDiff("second", boundaryDateGMT, startDateGMT);
        int centerLeftPixels = (int)((new Double(centerLeftSeconds).doubleValue()/new Double(totalSecondsInTimeline).doubleValue()) * widthInPixels);

        //centerRight
        int centerRightSeconds = reger.core.DateDiff.dateDiff("second", endDateGMT, boundaryDateGMT);
        int centerRightPixels = (int)((new Double(centerRightSeconds).doubleValue()/new Double(totalSecondsInTimeline).doubleValue()) * widthInPixels);

        //rightPadding
        int rightPaddingSeconds = reger.core.DateDiff.dateDiff("second", highestDateGMT, endDateGMT);
        int rightPaddingPixels = (int)((new Double(rightPaddingSeconds).doubleValue()/new Double(totalSecondsInTimeline).doubleValue()) * widthInPixels);

        //If there is any free space, add it to the rightPaddingPixels
        rightPaddingPixels = rightPaddingPixels + (widthInPixels - (leftPaddingPixels + centerLeftPixels + centerRightPixels));


        //Debug
        boolean debug = false;


        //START NEW
        mb.append("<!-- Start TimePeriod -->");
        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td class=tpleftpadding colspan=4>");
        if (debug){
            mb.append("<br>lowestDateGMT:" + reger.core.TimeUtils.dateformatfordb(lowestDateGMT) + "<br>highestDateGMT:" + reger.core.TimeUtils.dateformatfordb(highestDateGMT) + "<br>startDateGMT:" + reger.core.TimeUtils.dateformatfordb(startDateGMT) +"<br>boundaryDateGMT:" + reger.core.TimeUtils.dateformatfordb(boundaryDateGMT) + "<br>endDateGMT:" + reger.core.TimeUtils.dateformatfordb(endDateGMT) + "<br>totalSecondsInTimeline: " + totalSecondsInTimeline + "<br>leftPadding: " + leftPaddingPixels + "<br>centerLeft: " + centerLeftPixels + "<br>centerRight: " + centerRightPixels + "<br>rightPadding: " + rightPaddingPixels + "<br>isOpenEnded: " + isOpenEnded);
        }
        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=1 height=8></td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td width="+leftPaddingPixels+"% class=tpleftpadding><img src='"+pathToAppRoot+"images/clear.gif' width=1 height=8></td>");
        mb.append("<td width="+(centerLeftPixels + centerRightPixels)+"% class=tpleftpadding colspan=2>");
        mb.append("<font face=arial size=-2 style=\"font-size: 9px\">");
        mb.append(" " + reger.core.Util.truncateString(title, 50));
        if (userSession.getAccountuser().userCanDoAcl("CREATETIMEPERIODS", userSession.getAccount().getAccountid())){
            mb.append("&nbsp;(<a href='"+pathToAppRoot+"myhome/timeperiods.log?timeperiodid="+timeperiodid+"&action=edit'>edit/delete</a>)");
        }
        mb.append("&nbsp;(<a href='"+pathToAppRoot+"timeperiod-detail.log?timeperiodid="+timeperiodid+"'>view</a>)");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td width="+rightPaddingPixels+"% class=tpleftpadding><img src='"+pathToAppRoot+"images/clear.gif' width=1 height=8></td>");
        mb.append("</tr>");
        mb.append("</table>");

        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td width="+leftPaddingPixels+"% class=tpleftpadding><img src='"+pathToAppRoot+"images/clear.gif' width=1 height=8></td>");
        mb.append("<td width="+(centerLeftPixels + centerRightPixels)+"% class=tpleftpadding colspan=2><img src='"+pathToAppRoot+"images/timeperiod/top-arrow-vert.gif' width=8 height=12 align=top></td>");
        mb.append("<td width="+rightPaddingPixels+"% class=tpleftpadding><img src='"+pathToAppRoot+"images/clear.gif' width=1 height=8></td>");
        mb.append("</tr>");
        mb.append("</table>");

        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td width="+leftPaddingPixels+"% class=tpleftpadding><img src='"+pathToAppRoot+"images/clear.gif' width=1 height=8></td>");
        mb.append("<td width="+centerLeftPixels+"% class=tpcenter><img src='"+pathToAppRoot+"images/clear.gif' width=1 height=8></td>");
        mb.append("<td width="+centerRightPixels+"% class=tpright><img src='"+pathToAppRoot+"images/clear.gif' width=1 height=8></td>");
        mb.append("<td width="+rightPaddingPixels+"% class=tpleftpadding><img src='"+pathToAppRoot+"images/clear.gif' width=1 height=8></td>");
        mb.append("</tr>");
        mb.append("</table>");
        mb.append("<!-- End TimePeriod -->");
        //END NEW





        return mb.toString();
    }







}
