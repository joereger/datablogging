package reger;

import reger.core.db.Db;

import java.util.Calendar;

/**
 * On This Day Feature
 */
public class OnThisDay {

    public static StringBuffer getHtml(int accountid, String queryend, boolean displayassidecolumn, String timezoneid, int logid){
        StringBuffer ott = new StringBuffer();

        //Header
        if (displayassidecolumn){
            ott.append(SideColumn.sideColTableStart("Onthisday"));
            ott.append(SideColumn.sideColHeaderRow("On This Day"));
        }


		//Get the start date.  Just to be safe and make sure we don't grab today's entries which would be so uncool.
		//Calendar now = Calendar.getInstance();
		Calendar onagodate=Calendar.getInstance();
		onagodate.add(Calendar.DATE, -3);



		//Get the real now in user timezone
		Calendar now = Calendar.getInstance();
		now = reger.core.TimeUtils.nowInUserTimezone(timezoneid);
		now = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(now, timezoneid, "GMT");

		//Some vars for the loop below
        int lastago=0;
		int currentago=0;
		int totalcounter=0;
		StringBuffer tmp = new StringBuffer();

		//Limit to logid, if required
        String logidSql = "";
        if (logid>0){
            logidSql = " AND megalog.logid='"+logid+"'";
        }

		//-----------------------------------
		//-----------------------------------
		String[][] rstOnthisDay= Db.RunSQL("SELECT eventid, event.logid, title, date FROM event, megalog WHERE "+reger.Entry.sqlOfLiveEntry+" AND event.logid=megalog.logid AND megalog.accountid='" + accountid + "' AND " + queryend + " AND DAYOFMONTH(date)='"+ now.get(Calendar.DATE) +"' AND MONTH(date)='"+ (now.get(Calendar.MONTH)+1) +"' AND date<'"+ reger.core.TimeUtils.dateformatfordb(onagodate) +"' "+logidSql+" ORDER BY date DESC");
		//-----------------------------------
		//-----------------------------------
		if (rstOnthisDay!=null && rstOnthisDay.length>0){
			for(int i=0; i<rstOnthisDay.length; i++){

				totalcounter=totalcounter+1;

                currentago=(now.get(Calendar.YEAR) - reger.core.TimeUtils.dbstringtocalendar(rstOnthisDay[i][3]).get(Calendar.YEAR));

                //If we've switched years, output a year header row
                if (lastago!=currentago) {
                    tmp.append("<font face=arial class=mediumfont size=-1>");
                    tmp.append(currentago + " Year");
                    if (currentago>1) {
                        tmp.append("s");
                    }
                    tmp.append(" Ago:");
                    tmp.append("</font>");

                    //Now append this to the main ott
                    if (displayassidecolumn){
                        ott.append(SideColumn.sideColContentRow(tmp.toString()));
                    } else {
                        ott.append(tmp + "<br>");
                    }

                    //And blank the tmp
                    tmp.delete(0,tmp.length());
                }

                //Set the current to the last
                lastago=currentago;

                //Otherwise, just output the entry itself
                tmp.append("<font face=arial class=smallfont size=-1>");
                tmp.append("<a href='entry-logid"+rstOnthisDay[i][1]+"-eventid"+rstOnthisDay[i][0]+".log'>");
                tmp.append("<img src=images/bullet-arrow.gif border=0>");
                tmp.append(rstOnthisDay[i][2] + "</a>");
                tmp.append("</font>");

                //Now append this to the main ott
                if (displayassidecolumn){
                    ott.append(SideColumn.sideColContentRow(tmp.toString()));
                } else {
                    ott.append(tmp + "<br>");
                }

                //And blank the tmp
                tmp.delete(0,tmp.length());
			}
		}

		if (displayassidecolumn){
            ott.append(SideColumn.sideColTableEnd("Onthisday"));
        }

        //If we have no entries, leave this thing blank
		if (totalcounter==0) {
			ott.delete(0,ott.length());
        }

        return ott;
    }

}
