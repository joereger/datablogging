package reger.api;

import reger.core.db.Db;
import reger.core.db.Db;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.Hashtable;
import java.util.Enumeration;

/**
 *
 */
public class Rss {

    public static StringBuffer getFeed(reger.UserSession userSession, int logid,int limititems){
        StringBuffer fd = new StringBuffer();

        //Output RSS top
        String homepagetitle = userSession.getAccount().getHomepagetitle();
        if (homepagetitle.equals("")) {
            homepagetitle="" + userSession.getAccount().getSiteRootUrl(userSession) + "/";
        }

        String homepagehtml = userSession.getAccount().getHomepagehtml();
        if (homepagehtml.equals("")) {
            homepagehtml="A web log called " + userSession.getAccount().getSiteRootUrl(userSession) + "/";
        }

        fd.append("<rss version=\"2.0\">");
        fd.append("<channel>");
        fd.append("<title>" + reger.core.Util.xmlclean(homepagetitle) + "</title>");
        fd.append("<link>" +  userSession.getAccount().getSiteRootUrl(userSession) + "/" + "</link>");
        fd.append("<description>" + reger.core.Util.xmlclean(homepagehtml) + "</description>");
        fd.append("<generator>Reger.com Activity-specific Weblogging Server Technology</generator>");

        //Build logid-dependent sql
        String logidSql="";
        if (logid>0) {
            logidSql=" AND event.logid='"+logid+"'";
        }

        //Output RSS items
        //-----------------------------------
        //-----------------------------------
        String[][] rstEvent= Db.RunSQL("SELECT date, eventid, event.logid, title, comments, megalog.name FROM event, megalog WHERE "+reger.Entry.sqlOfLiveEntry+" AND event.logid=megalog.logid AND megalog.accountid='" + userSession.getAccount().getAccountid() + "' AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+""+logidSql+" ORDER BY event.date DESC LIMIT 0, "+limititems+"");
        //-----------------------------------
        //-----------------------------------
        if (rstEvent!=null && rstEvent.length>0){
        	for(int i=0; i<rstEvent.length; i++){
        		//Correct format
                //Sat, 07 Sep 2002 0:00:01 GMT
                Calendar gmttime = reger.core.TimeUtils.gmttousertime(rstEvent[i][0], userSession.getAccount().getTimezoneid());
                //reger.core.Util.logtodb("after gmttousertime() - " + reger.core.TimeUtils.dateformatfordb(gmttime) + " - " + gmttime.toString());
                gmttime = reger.core.TimeUtils.usertogmttime(gmttime, userSession.getAccount().getTimezoneid());
                //reger.core.Util.logtodb("after usertogmttime() - " + reger.core.TimeUtils.dateformatfordb(gmttime) + " - " + gmttime.toString());

                //Founder & Owner Rights
                //String jrdirectory="";
                //if (request.servervariables("SERVER_NAME")="weblog.joereger.com") {
                    //jrdirectory="/reger"
                //}

                //Link
                String link="" + userSession.getAccount().getSiteRootUrl(userSession) +"/entry-logid"+rstEvent[i][2]+"-eventid"+rstEvent[i][1]+".log";

                fd.append("<item>");
                fd.append("<title>" + reger.core.Util.xmlclean(rstEvent[i][3]) + "</title>");
                fd.append("<link>" + link + "</link>");
                fd.append("<guid isPermaLink=\"true\">" + link + "</guid>");
                if (userSession.getAccount().getMessagesstatus()==1) {
                    fd.append("<comments>" + link + "</comments>");
                }
                fd.append("<description>" + reger.core.Util.xmlclean(rstEvent[i][4]) + "</description>");
                //@!todo Figure out why this is posting EST instead of GMT
                fd.append("<pubDate>" +reger.core.TimeUtils.dateformatUtc(gmttime)+ "</pubDate>");

                fd.append("<category>"+reger.core.Util.xmlclean(rstEvent[i][5])+"</category>");

                //@todo Implement <author> tag.

                //@todo Implement enclosure tag for all media
                //<enclosure url="http://www.scripting.com/mp3s/weatherReportSuite.mp3" length="12216320" type="audio/mpeg" />


                //Megalog Start

                //Grab the data
                //reger.MegaGetSingleEventData eventData = new reger.MegaGetSingleEventData(Integer.parseInt(rstEvent[i][1]));

                //The data is now in eventData.cleanData with fieldtypes in eventData.fieldTypes
//                for ( Enumeration e = eventData.cleanData.keys() ; e.hasMoreElements() ; ) {
//                	// retrieve the object_key
//                	String fieldname = (String)e.nextElement();
//                	// retrieve the object associated with the key
//                	String data = String.valueOf(eventData.cleanData.get(fieldname));
//                	//Output the correct tags
//                	fd.append(outputMegaDataTag(fieldname, data, Integer.parseInt(String.valueOf(eventData.fieldTypes.get(fieldname)))));
//                }


                //Megalog end

                fd.append("</item>");
        	}
        }

        //Output RSS bottom
        fd.append("</channel>");
        fd.append("</rss>");

        return fd;
    }

    private static StringBuffer outputMegaDataTag(String fieldname, String data, int megadatatypeid) {
        StringBuffer dt = new StringBuffer();

        //@todo Research Rss spec and figure out how to add data type to this

        //Clean the fieldname
        fieldname = reger.core.Util.xmlFieldNameClean(fieldname);

        dt.append("<"+fieldname+">" +data+ "</"+fieldname+">");

        return dt;
    }

}
