package reger;

import java.util.HashMap;
import java.util.Calendar;

/**
 * Plugins that control the display of a single day in a calendar.
 */
public interface CalendarDayPlugin {

    public HashMap cellHtml = new HashMap();

    public void getHtml(Calendar startdate, Calendar enddate, int logid, reger.UserSession userSession, boolean showtitles, String thisPageName);


}
