<%@ page import="java.util.Iterator,
                 java.util.Map"%>
<%

java.util.TreeMap pagetitle = new java.util.TreeMap();
pagetitle.put("settings", "Email Gateway Settings");
pagetitle.put("emailaddresses", "Email Addresses");
pagetitle.put("phoneaddresses", "Phone Cam Addresses");


java.util.TreeMap pagetext = new java.util.TreeMap();
pagetext.put("settings", "These settings control how email posts are handled.");
pagetext.put("emailaddresses", "Use these addresses to post via email.  Simply put one of the addresses from below into your email client (i.e. Microsoft Outlook, Eudora, etc.) as the To: address.  Then type a subject and a regular email.  Click send.  That's it!<br><br>The subject will become your web log entry title and the body will be the body of the post.");
pagetext.put("phoneaddresses", "Use these addresses to send camera phone pics to your web log.  Note that you can control how your web log treats these incoming images in the Settings tab.<br><br>Most camera phones allow you to send pictures to an email address.  Use the email addresses below and your images will be added to your web log.  Because typing these addresses is tough on a cell phone, create phone book entries on your cell phone for easy access.");

java.util.TreeMap pageurl = new java.util.TreeMap();
pageurl.put("settings", "tools-emailapi-settings.log");
pageurl.put("emailaddresses", "tools-emailapi-emailaddresses.log");
pageurl.put("phoneaddresses", "tools-emailapi-phoneaddresses.log");


mb.append("<table cellpadding=5 cellspacing=1 border=0 width=100% bgcolor=#000000>");


//mb.append("<tr>");
//
//for (Iterator i=pagetitle.entrySet().iterator(); i.hasNext(); ) {
//    Map.Entry e = (Map.Entry) i.next();
//    String key = (String)e.getKey();
//    String value = (String)e.getValue();
//
//    String tabcolor = "#e6e6e6";
//    String textcolor = "#0000ff";
//    if (key.equals(emailapisection)){
//        tabcolor="#000000";
//        textcolor="#999999";
//    }
//
//    mb.append("<td bgcolor="+tabcolor+">");
//    mb.append("<a href='"+pageurl.get(key)+"'>");
//    mb.append("<font face=arial size=-1 color="+textcolor+">");
//    mb.append("<strong>");
//    mb.append(value);
//    mb.append("</strong>");
//    mb.append("</font>");
//    mb.append("</a>");
//    mb.append("</td>");
//}




mb.append("<tr>");
mb.append("<td bgcolor=#cccccc colspan=3>");
mb.append("<font face=arial size=+1 color=#000000>");
mb.append("<strong>");
mb.append(pagetitle.get(emailapisection));
mb.append("</strong>");
mb.append("</font>");
mb.append("<br>");
mb.append("<font face=arial size=-2 color=#000000>");
mb.append("<strong>");
mb.append(pagetext.get(emailapisection));
mb.append("</strong>");
mb.append("</font>");
mb.append("</td>");
mb.append("</tr>");
mb.append("</table>");

%>