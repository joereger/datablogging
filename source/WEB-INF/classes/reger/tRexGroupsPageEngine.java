package reger;

import reger.pageFramework.PageProps;
import reger.core.Util;

import java.util.regex.*;

public class tRexGroupsPageEngine {

   /**
    * tRex Admin page engine
    */
    public static StringBuffer pageout(StringBuffer mb, StringBuffer sc, UserSession userSession, PageProps pageProps, javax.servlet.http.HttpServletRequest request) {

		StringBuffer ap = new StringBuffer();

		ap.append("<html><head><title>Groups</title></head>");
		ap.append("<body bgcolor=#ffffff link='#0000ff' vlink='#0000ff' text='#000000' LEFTMARGIN='0' TOPMARGIN='0' MARGINWIDTH='0' MARGINHEIGHT='0'");
		//Onload handler
		if (pageProps.onloadJavascriptMethod!=null && !pageProps.onloadJavascriptMethod.equals("")){
            ap.append(" onLoad=\""+pageProps.onloadJavascriptMethod+"\"");
        }
        //Onunload handler
		if (pageProps.onunloadJavascriptMethod!=null && !pageProps.onunloadJavascriptMethod.equals("")){
            ap.append(" onUnload=\""+pageProps.onunloadJavascriptMethod+"\"");
        }
		ap.append(">");

       //Figure out what AdminTools and LoggedInBar look like
       StringBuffer appendToTop = new StringBuffer();
       if (userSession.getAccountuser().getIsLoggedIn()){
           appendToTop.append(LoggedInBar.getHtml(userSession, pageProps));
           if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && userSession.getAccount().getAdmintools()==1 && userSession.getAccountuser().getAccountid()==userSession.getAccount().getAccountid()){
               //appendToTop.append(reger.AdminTools.getHtml(userSession, pageProps.logProps.logid, pageProps.entry.eventid));
           }
       }
       ap.append(appendToTop);

		//Start dHtml Help Scripts
		mb.append("<!-- Begin dHTML Help Scripts -->");
        mb.append("<DIV id=\"TipLayer\" style=\"visibility:hidden;position:absolute;z-index:1000;top:-100\"></DIV>");
        mb.append("<SCRIPT language=\"JavaScript1.2\" src=\""+pageProps.pathToAppRoot+"js/dhtmlhelp/main.js\"type=\"text/javascript\"></SCRIPT>");
        mb.append("<SCRIPT language=\"JavaScript1.2\" src=\""+pageProps.pathToAppRoot+"js/dhtmlhelp/style.js\" type=\"text/javascript\"></SCRIPT>");
        mb.append("<!-- End dHTML Help Scripts -->");
        //End dHtml Help Scripts

		//Start Top Navbar
//		ap.append("<!-- start top navbar-->");
//
//		//Create a vactor to hold the buttons with initial capacity of 10
//		java.Util.Vector buttons = new java.Util.Vector(10);
//		String defaultBgColor = "#e6e6e6";
//		buttons.add(new tRexAdminNavBarButton("ADD", pageProps.pathToAppRoot+"myhome/index.log", "MY HOME", defaultBgColor));
//		//buttons.add(new reger.tRexAdminNavBarButton("LOGS", pageProps.pathToAppRoot+"myhome/newlog.log", "LOGS", defaultBgColor));
//		buttons.add(new tRexAdminNavBarButton("ENTRIES", pageProps.pathToAppRoot+"myhome/entries.log", "ENTRIES", defaultBgColor));
//		//buttons.add(new reger.tRexAdminNavBarButton("EPISODES", pageProps.pathToAppRoot+"myhome/entries.log", "EPISODES", defaultBgColor));
//		buttons.add(new tRexAdminNavBarButton("TIMEPERIODS", pageProps.pathToAppRoot+"myhome/timeperiods.log", "TIME PERIODS", defaultBgColor));
//		buttons.add(new tRexAdminNavBarButton("TRAFFIC", pageProps.pathToAppRoot+"myhome/traffic.log", "TRAFFIC", defaultBgColor));
//		buttons.add(new tRexAdminNavBarButton("PEOPLE", pageProps.pathToAppRoot+"myhome/people.log", "PEOPLE", defaultBgColor));
//		buttons.add(new tRexAdminNavBarButton("GROUPS", pageProps.pathToAppRoot+"myhome/groups.log", "GROUPS", defaultBgColor));
//		buttons.add(new tRexAdminNavBarButton("SETTINGS", pageProps.pathToAppRoot+"myhome/settings.log", "SETTINGS", defaultBgColor));
//        if (userSession.getAccountuser().userCanDoAcl("PLADMIN", userSession.getAccount().getAccountid())){
//            buttons.add(new tRexAdminNavBarButton("PL", pageProps.pathToAppRoot+"pl/index.log", "PRIVATE LABEL", "#ffffcc"));
//        }
//        if (userSession.getAccountuser().userCanDoAcl("MASTERADMIN", userSession.getAccount().getAccountid())){
//		    buttons.add(new tRexAdminNavBarButton("LOE", pageProps.pathToAppRoot+"loe/index.log", "LOE ADMIN", "#ffffcc"));
//        }
//
//
//		//Actually append the bar by passing the buttons to the navbar creator
//		ap.append(topNavbar(buttons, pageProps.adminSection, pageProps.pathToAppRoot));
//
//		ap.append("<!-- end top navbar-->");
//		//End Top Navbar


		ap.append("<!-- main outer table with two columns... left and right-->");
		ap.append("<table width=100% cellpadding=0 cellspacing=0 border=0>");


		ap.append("<!-- main outer table center row... left column-->");
		ap.append("<tr><td valign=top align=left bgcolor=#ffffff>");



//		//Put the vertical Google banner on the left side if the account isn't Pro or Trial
//        if (userSession.getAccount().getAccounttypeid()==Vars.ACCTYPEFREE && !pageProps.isPreview){
//            ap.append("<img src='../images/clear.gif' width='1' height='75' alt='' border='0'>");
//            ap.append("<br>") ;
//            ap.append("<a href='accountstatus.log'>");
//            ap.append("<font face=arial size=-2>");
//            ap.append("Remove These Ads");
//            ap.append("</font>");
//            ap.append("</a>");
//            ap.append("<br>") ;
//            ap.append(Banner.getVerticalGoogleBanner());
//            ap.append("<br>") ;
//            ap.append("<br>") ;
//            ap.append("<br>") ;
//        }

		ap.append("<!-- end  left side table -->");
		ap.append("<!-- main outer table... creating gutter-->");
		ap.append("</td><td valign=top nowrap>&nbsp;&nbsp;&nbsp;</td>");
		ap.append("<!-- main outer table... creating right column-->");
		ap.append("</td><td valign=top width=100% >");
		ap.append("<!-- main body of the admin page begins here-->");
		ap.append("<!-- main body of the admin page begins here-->");
		ap.append("<!-- main body of the admin page begins here-->");

        //Page title
        if (pageProps.title!=null && !pageProps.title.equals("")) {
            ap.append("<br><font face=arial size=+3>"+pageProps.title+"</font><br>");
        }

		//Insert main body of Admin Page
		ap.append(mb);
		ap.append("<br><br><br>");

		//Now show footer
		ap.append("<!-- main body of the admin page ends here-->");
		ap.append("<!-- main body of the admin page ends here-->");
		ap.append("<!-- main body of the admin page ends here-->");


		ap.append("</td>");

		ap.append("<!-- Right Column -->");
		ap.append("<td valign=top nowrap>&nbsp;&nbsp;&nbsp;</td>");
		ap.append("<td valign=top>");
		ap.append(sc);
		ap.append("</td>");
		ap.append("<!-- End Right Column -->");

		ap.append("</tr>");

		ap.append("<tr><td bgcolor=#000000 colspan=5>");
		ap.append("<img src=../images/clear.gif width=1 height=1>");
		ap.append("</td></tr>");

		ap.append("<tr><td bgcolor=#ffcc00 colspan=5>");
		ap.append("<img src=../images/clear.gif width=1 height=45>");
		ap.append("</td></tr>");

		ap.append("</table>");

		ap.append(Util.pageFooter(pageProps.pathToAppRoot, userSession.getPl()));

		ap.append("</body>");
		ap.append("</html>");


		return ap;
	}


	private static StringBuffer adminTab(String thistabsection, String activetabsection, String tabtext, String taburl){
		StringBuffer at = new StringBuffer();

		String admintaboncolor="#ffcc00";
		String admintaboffcolor="#003333";
		String adminfontoncolor="#000000";
		String adminfontoffcolor="#ffffff";
		String arrow;

		at.append("<td bgcolor=");
		if (thistabsection.equals(activetabsection)) {
			at.append(admintaboncolor);
            arrow="round-down-arrow-green.gif";
		} else {
			at.append(admintaboffcolor);
            arrow="round-arrow-blue.gif";
		}
		at.append(" valign=top><center><a href='"+ taburl +"'><img src='../images/"+arrow+"' width='15' height='15' alt='' border='0' align=middle><font face=arial size=-1 color=");
		if (thistabsection.equals(activetabsection)) {
			at.append(adminfontoncolor);
		} else {
			at.append(adminfontoffcolor);
		}
		at.append("><b>"+ tabtext +"</b></a></font></center></td>");

		return at;
	}



	public static StringBuffer topNavbar(java.util.Vector buttons, String adminSection, String pathToAppRoot){
        StringBuffer mb = new StringBuffer();

        //Colors
        String fontcolor = "#333333";
        String outlinecolor = "#999999";
        String bgcolor = "#ffcc00";


        mb.append("<style>");
        mb.append("\n");
        mb.append("a:link	{ text-decoration: underline }");
        mb.append("\n");
        mb.append("a:visited { text-decoration: underline }");
        mb.append("\n");
        mb.append("a:hover { text-decoration: underline; }");
        mb.append("\n");
        mb.append(".adminbutton { color: "+fontcolor+"; font-size: 12px; font-family: Arial, Geneva, Helvetica, Swiss, SunSans-Regular;  text-decoration: none; letter-spacing: 0px; font-weight : bold;}");
        mb.append("\n");
        mb.append(".admintab{}");
        mb.append("\n");
        mb.append("td.admintab:hover { background: #ffffff; }");
        mb.append("\n");
        mb.append("</style>");
        mb.append("\n");

        //Need to create a count of buttons to display
        int numberofbuttons = buttons.size();

        mb.append("<table width=100% cellspacing=0 cellpadding=0 border=0>");
        mb.append("<tr>");
        //Alternate color = #e6cb4a
        mb.append("<td bgcolor="+bgcolor+" nowrap align=center>");
        mb.append("<img src="+pathToAppRoot+"images/clear.gif border=0 width=15 height=55>");
        mb.append("</td>");
        mb.append("<td rowspan=2 bgcolor="+bgcolor+" valign=bottom>");
        mb.append("<!-- Start Navbar -->");
        mb.append("<table width=100% cellspacing=0 cellpadding=0 border=0>");
        mb.append("<tr>");
        //Need one for each button
        for(int i=0; i<numberofbuttons; i++){
            mb.append("<td rowspan=3 bgcolor="+outlinecolor+" width=1><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
            mb.append("<td bgcolor="+outlinecolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
        }
        mb.append("<td rowspan=3 bgcolor="+outlinecolor+" width=1><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
        mb.append("</tr>");
        mb.append("<tr>");
        //Need one for each button
        String tabbgcolor = "";
        String url = "";
        String text = "";
        for(int i=0; i<numberofbuttons; i++){
            tRexAdminNavBarButton thisButton = (tRexAdminNavBarButton)buttons.get(i);
            url = thisButton.url;
            text = thisButton.buttontext;
            tabbgcolor = thisButton.buttonbgcolor;
            if (thisButton.adminsection.equals(adminSection)){
                tabbgcolor = "#ffffff";
            }
            mb.append("<td bgcolor="+tabbgcolor+" class=admintab align=center height=21 onclick=\"document.location.href='"+url+"'\">");
            mb.append("<font face=arial size=-2><a href='"+url+"' class=adminbutton>"+text+"</a></font>");
            mb.append("</td>");
        }
        mb.append("</tr>");
        mb.append("<tr>");
        //Need one for each button
        String linebgcolor = "";
        for(int i=0; i<numberofbuttons; i++){
            tRexAdminNavBarButton thisButton = (tRexAdminNavBarButton)buttons.get(i);
            linebgcolor = outlinecolor;
            if (thisButton.adminsection.equals(adminSection)){
                linebgcolor = "#ffffff";
            }
            mb.append("<td bgcolor="+linebgcolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
        }
        mb.append("</tr>");
        mb.append("</table>");
        mb.append("<!-- End Navbar -->");
        mb.append("</td>");
        mb.append("<td bgcolor="+bgcolor+">");
        mb.append("<img src="+pathToAppRoot+"images/clear.gif border=0 width=15 height=55>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td bgcolor="+outlinecolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
        mb.append("<td bgcolor="+outlinecolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
        mb.append("</tr>");
        mb.append("</table>");





        return mb;
    }

}