<%@ page import="com.sun.syndication.io.WireFeedOutput"%>
<%

String xmlUrl="";


mb.append("<br><br>");

mb.append("<font face=arial size=+2>");
mb.append("<strong>");
mb.append("Available XML Feeds");
mb.append("</strong>");
mb.append("</font>");

mb.append("<br><br>");

mb.append("<font face=arial size=-2>");
mb.append("This is a list of available XML feeds.  These feeds allow you to aggregate this site with others for easier reading using any of a number of <a href='http://blogs.law.harvard.edu/tech/directory/5/aggregators'>tools</a>. The main link is a great one to use.  You can also link directly to a particular format.");
mb.append("</font>");

mb.append("<br><br>");

mb.append("<table cellpadding=10 cellspacing=1 width=100% border=0>");

//mb.append("<tr>");
//mb.append("<td valign=top>");
//mb.append("<font face=arial size=+1>");
//mb.append("<strong>");
//mb.append("Log:");
//mb.append("</strong>");
//mb.append("</font>");
//mb.append("</td>");
//mb.append("<td valign=top>");
//mb.append("<font face=arial size=+1>");
//mb.append("<strong>");
//mb.append("XML Feed:");
//mb.append("</strong>");
//mb.append("</font>");
//mb.append("</td>");
//mb.append("</tr>");


mb.append("<tr>");
mb.append("<td valign=top bgcolor=#cccccc>");
mb.append("<font face=arial size=-1>");
mb.append("<strong>");
mb.append("All Logs in One Feed");
mb.append("</strong>");
mb.append("</font>");
mb.append("</td>");
mb.append("<td valign=top bgcolor=#e6e6e6>");
mb.append("<font face=arial size=-1>");
mb.append("<strong>");
mb.append("<a href='"+reger.Vars.getHttpUrlPrefix()+userSession.getAccount().getSiteRootUrl()+"/rss.xml'>");
mb.append(""+reger.Vars.getHttpUrlPrefix()+userSession.getAccount().getSiteRootUrl()+"/rss.xml");
mb.append("</a>");
mb.append("</td>");
mb.append("</tr>");


//Output all feeds available
mb.append("<tr>");
mb.append("<td valign=top align=right bgcolor=#ffffff>");
mb.append("<font face=arial size=-2>");
mb.append("Formats:");
mb.append("</font>");
mb.append("</td>");
mb.append("<td valign=top bgcolor=#ffffff>");
java.util.List supportedTypes = WireFeedOutput.getSupportedFeedTypes();
for (int j = 0; j < supportedTypes.size(); j++) {

    Object o = (Object) supportedTypes.get(j);

    xmlUrl = ""+reger.Vars.getHttpUrlPrefix()+userSession.getAccount().getSiteRootUrl()+"/"+o.toString()+"-all.xml";

    mb.append("<font face=arial size=-2>");
    mb.append("(<a href='"+xmlUrl+"'>");
    mb.append(o.toString());
    mb.append("</a>)");
    mb.append("</font>");
}
mb.append("<br><br>");
mb.append("</strong>");
mb.append("</font>");
mb.append("</td>");
mb.append("</tr>");



//Only display logs that an accountuser explicitly has access to... in other words, an account owner may want to create a contributor who can't contribute to a particular public log.
String sql = "SELECT logid, name, eventtypeid, logaccess, password FROM megalog WHERE accountid='"+ userSession.getAccount().getAccountid() +"' AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+" ORDER BY name ASC";



//-----------------------------------
//-----------------------------------
String[][] rstEventtype= reger.core.db.Db.RunSQL(sql);
//-----------------------------------
//-----------------------------------
if (rstEventtype!=null){
	for(int i=0; i<rstEventtype.length; i++){

	    String qs = "";
	    if (rstEventtype[i][3].equals(String.valueOf(reger.Vars.LOGACCESSPRIVATE)) && !rstEventtype[i][4].equals("")){
            qs = "?qpass=" + rstEventtype[i][4];
        }

        xmlUrl = ""+reger.Vars.getHttpUrlPrefix()+userSession.getAccount().getSiteRootUrl()+"/rss-logid"+rstEventtype[i][0]+".xml" + qs;

	    //Output to the user
        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#cccccc>");
        mb.append("<font face=arial size=-1>");
        mb.append("<strong>");
        mb.append(rstEventtype[i][1]);
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<a href='"+xmlUrl+"'>");
        mb.append("<font face=arial size=-1>");
        mb.append(xmlUrl);
        mb.append("</font>");
        mb.append("</a>");
        mb.append("</td>");
        mb.append("</tr>");


        //Output all feeds available
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#ffffff>");
        mb.append("<font face=arial size=-2>");
        mb.append("Formats:");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#ffffff>");
        supportedTypes = WireFeedOutput.getSupportedFeedTypes();
        for (int j = 0; j < supportedTypes.size(); j++) {

            Object o = (Object) supportedTypes.get(j);

            xmlUrl = ""+reger.Vars.getHttpUrlPrefix()+userSession.getAccount().getSiteRootUrl()+"/"+o.toString()+"-logid"+rstEventtype[i][0]+".xml";

            mb.append("<font face=arial size=-2>");
            mb.append("(<a href='"+xmlUrl+"'>");
            mb.append(o.toString());
            mb.append("</a>)");
            mb.append("</font>");
        }
        mb.append("<br><br>");
        mb.append("</td>");
        mb.append("</tr>");

    }
}




mb.append("</table>");

mb.append("<br><br>");
%>