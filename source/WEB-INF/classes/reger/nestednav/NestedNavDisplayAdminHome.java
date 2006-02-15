package reger.nestednav;

import reger.UserSession;
import reger.Help;
import reger.core.Debug;
import reger.cache.LogCache;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Creates the screen to manage nav item layout
 */
public class NestedNavDisplayAdminHome implements NestedNavDisplay{

    private String cellbgcolor="#ffffff";

    public String outputNavBarHtml(NestedNavCollection nestedNavCollection, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();



        mb.append("\n\n\t<script type=\"text/javascript\" src=\"../js/moofx/prototype.lite.js\"></script>\n" +
                "\t<script type=\"text/javascript\" src=\"../js/moofx/moo.fx.js\"></script>\n" +
                "\t<script type=\"text/javascript\" src=\"../js/moofx/moo.fx.pack.js\"></script>\n" +
                "\t<script language=\"JavaScript\" type=\"text/javascript\"><!--\n" +
                "\t//the main function, call to the effect object\n" +
                "\tfunction init(){\n" +
                "\t\t\n" +
                "\t\tvar stretchers = document.getElementsByClassName('stretcher'); //div that stretches\n" +
                "\t\tvar toggles = document.getElementsByClassName('display'); //h3s where I click on\n" +
                "\n" +
                "\t\t//accordion effect\n" +
                "\t\tvar myAccordion = new fx.Accordion(\n" +
                "\t\t\ttoggles, stretchers, {opacity: true, duration: 400}\n" +
                "\t\t);\n" +
                "\n" +
                "\t\t//hash functions\n" +
                "\t\tvar found = false;\n" +
                "\t\ttoggles.each(function(h3, i){\n" +
                "\t\t\tvar div = Element.find(h3, 'nextSibling'); //element.find is located in prototype.lite\n" +
                "\t\t\tif (window.location.href.indexOf(h3.title) > 0) {\n" +
                "\t\t\t\tmyAccordion.showThisHideOpen(div);\n" +
                "\t\t\t\tfound = true;\n" +
                "\t\t\t}\n" +
                "\t\t});\n" +
                "\t\tif (!found) myAccordion.showThisHideOpen(stretchers[0]);\n" +
                "\t}\n" +
                "\twindow.onload = function(){ Element.cleanWhitespace('content'); init(); };\n"+
                "\t--></script>\n" +
//                "\t<script language=\"JavaScript\" type=\"text/javascript\"><!--\n" +
//                "\tfunction addLoadEvent(func) {\n"+
//                "\tvar oldonload = window.onload;\n" +
//                "\tif (typeof window.onload != 'function') {\n" +
//                "\twindow.onload = func;\n" +
//                "\t} else {\n" +
//                "\twindow.onload = function() {\n" +
//                "\toldonload();\n" +
//                "\tfunc();\n" +
//                "\t}\n" +
//                "\t}\n" +
//                "\t}\n" +
//                "\t/* addLoadEvent(init()); */\n" +
//                "\taddLoadEvent(function() {\n" +
//                "\t/* more code to run on page load */\n" +
//                "\tinit();\n"+
//                "\t});\n" +
//                "\t--></script>\n" +
                "\t\n" +
                "\t<style>\n" +
                "\th3 {\n" +
                "\t\tmargin: 1px;\n" +
                "\t\twidth: 100%;\n" +
                "\t\tcursor: pointer;\n" +
                "\t\tfont-size: 0.99em;\n" +
                "\t\tfont: verdana, arial, helvetica, sans-serif;\n" +
                "\t\tcolor: #333333;\n" +
                "\t\tbackground: #ffffff;\n" +
                "\t}\n" +
                "\t</style>");



        Debug.debug(5, "", "NestedNavDisplayAdminHome.java - Navbar start.");
        mb.append(reger.ui.BubbleBox.start("", "../"));



//        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#ffffff>");
//        mb.append("<tr>");
//        mb.append("<td valign=bottom align=left bgcolor="+ cellbgcolor +" nowrap><font face=arial size=-2 color=#666666></font></td>");
//        String helpLastEntry = Help.tip("Last Entry", "Shows how long ago the most recently dated entry was made.", false, "../");
//        mb.append("<td valign=center align=center bgcolor="+ cellbgcolor +"><font face=arial size=-2 color=#666666>Last Entry</font></td>");
//        String helpNoEntries = Help.tip("Total Entries", "The number of entries that have been made in this log.", false, "../");
//        mb.append("<td valign=center align=center bgcolor="+ cellbgcolor +"><font face=arial size=-2 color=#666666>Total Entries</font></td>");
//        String helpShowOnHp = reger.Help.tip("Show on Homepage","Your web log homepage is an important place. It's the place where your visitors get their first glimpse of you and where they find updates.<br><br>Sometimes you want to keep track of things and keep them public, but you don't necessarily want them to take up space on your homepage.<br><br>This feature allows you to have a log's entries not appear on the home page. Note: This is different than making a log private.<br><br>By deciding to not show on the homepage you are not restricting access to the log... you are just making users click the log directly before they see its log entries.",false,"../");
//        mb.append("<td valign=center align=center bgcolor="+ cellbgcolor +"><font face=arial size=-2 color=#666666></font></td>");
//        String helpAccess = reger.Help.tip("Log Access", "Your logs can be Public or Private.  Private logs are not visible to anybody who does not have the password to your site.  Change the access rules for each log by clicking the link in this column.", false, "../");
//        mb.append("<td valign=center align=left bgcolor="+ cellbgcolor +"><font face=arial size=-2 color=#666666></font></td>");
//        mb.append("</tr>");

        mb.append("<div id=\"content\">");

        mb.append(outputItemHtml(new NestedNavItemBase(), userSession.getAccount().getNestedNavCollection(), 0, userSession, request));

        mb.append("</div>");

        //New Log Anybody?
        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#ffffff>");
        mb.append("<tr>");
        mb.append("<td valign=top align=left bgcolor=#e6e6e6 colspan=5 nowrap><a href='logs-newlog.log'><img src='images/add_16.gif' width=16 height=16 border=0 align=middle><font face=arial size=-1 color=#0000ff><b>Create a New Log</b></a></td>");
        mb.append("</tr>");
        mb.append("</table><!-- End navigation -->");
        mb.append(reger.ui.BubbleBox.end("../"));

//        mb.append("<script type=\"text/javascript\">\n" +
//                "\t\tElement.cleanWhitespace('content');\n" +
//                "\t\tinit();\n" +
//                "\t</script>");

        Debug.debug(5, "", "NestedNavDisplayAdminHome.java - Navbar end.");

        return mb.toString();
    }


    public String outputItemHtml(NestedNavItem navItem, NestedNavCollection collection, int currentNestedLevel, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        String thisPageName = reger.core.Util.getJspName(request.getRequestURI());

        Debug.debug(5, "", "NestedNavDisplayAdminHome.java - Item output called.");

        String isOnText = "off";
        if (navItem.isActive(request)){
            isOnText = "on";
        }

        int nestingPixels = 1;
        for(int i=2; i<=currentNestedLevel; i++){
            nestingPixels = nestingPixels + 20;
        }



        //Output this item in html format
        if (navItem!=null && navItem.getThisNestedNavType()!=NestedNavItem.NESTEDNAVITEMBASE){

            String divTitle = "tab"+currentNestedLevel+""+navItem.getThisNestedNavType()+""+navItem.getThisNestedNavId();

            if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPEMEGALOG){

                //Get the log
                reger.Log log = LogCache.get(navItem.getThisNestedNavId());

                if (log!=null){

                    //Most recent entry
                    String lastentrydate=reger.core.TimeUtils.agoText(log.getMostRecentEntryDateGMT());

                    //Entrycount
                    String entrycount=String.valueOf(log.getNumberOfLiveEntriesInLog());

                    //Massage the logaccesstext
                    String logaccesstext="<img src='../images/icon-public.gif' width='16' height='16' alt='' border='0'>Public";
                    if (log.getLogaccess()==reger.Vars.LOGACCESSPRIVATE) {
                        logaccesstext="<img src='../images/icon-private.gif' width='16' height='16' alt='' border='0'>Private";
                    }

                    //Top of accordion start
                    mb.append("\n\n\n");
                    mb.append("<h3 class=\"display\" title=\""+divTitle+"\">");

                    mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
                    mb.append("<tr>");
                    mb.append("<td valign=center background='images/accordion/greenbar-leftcap.gif' align=left width=13>");
                    mb.append("<img src='images/clear.gif' height=41 width=1 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/greenbar-center.gif' align=left>");
                    mb.append("<font face=arial size=-1 style=\"font-face: arial; text-decoration: none; font-size: 10px; color: #ffffff; font-weight: bold;\">"+log.getName()+"</font></a>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/greenbar-center.gif' align=right>");
                    mb.append("<a href='entry.log?logid="+ log.getLogid() +"&action=add' style=\"text-decoration: none\"><font face=arial size=-1 style=\"font-face: arial; text-decoration: none; font-size: 10px; color: #ffffff; font-weight: bold;\">Add Entry</font><img src='../images/plus-icon.gif' width='15' height='15' alt='' border='0' align=top></a>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/greenbar-rightcap.gif' align=right width=13>");
                    mb.append("<img src='images/clear.gif' height=1 width=1 border=0>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("</table>");

                    mb.append("</h3>\n");
                    //Top of accordion end



                    mb.append("\t\t\t<div class=\"stretcher\">");



                    mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
                    mb.append("<tr>");
                    mb.append("<td valign=center align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=1 width=25 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-leftside.gif' align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=100 width=12 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-centerbody.gif' align=left>");
                    //Start accordion content
                    mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
                    mb.append("<tr>");
                    mb.append("<td valign=top align=left>");
                    mb.append("<font face=arial size=-2 color=#000000>");
                    mb.append("<a href='entry.log?logid="+log.getLogid()+"&action=add'><img src='images/icon-edit.gif' border=0>Add an Entry</a><br>");
                    mb.append("<a href='../logmain"+log.getLogid()+".log'><img src='images/icon-post.gif' border=0>View this Log</a><br>");
                    mb.append("<a href='logs-log-properties.log?logid="+log.getLogid()+"'><img src='images/icon-configure.gif' border=0>Customize this Log</a><br>");
                    mb.append("<a href='people-friends-invite.log?logid="+log.getLogid()+"'><img src='images/icon-configure.gif' border=0>Invite Friends</a><br>");
                    mb.append("</font>");
                    mb.append("</td>");
                    mb.append("<td valign=top align=left>");
                    mb.append("<font face=arial size=-2 color=#000000>Total Entries: "+ entrycount+"</font>");
                    mb.append("<br>");
                    mb.append("<font face=arial size=-2 color=#000000>Last Entry: "+ lastentrydate+"</font>");
                    mb.append("<br>");
                    mb.append("<font face=arial size=-2 color=#0000ff>"+ logaccesstext +"</font></a>");
                    mb.append("<br>");
                    mb.append("<font face=arial size=-2 color=#0000ff><a href='logs-log-properties.log?logid="+log.getLogid()+"'>");
                    String showonhomepagetext = "<img src='../images/home-visible.gif' border=0>Visible on Home";
                    if (!log.getShowonhomepage()){
                        showonhomepagetext = "<img src='../images/home-hidden.gif' border=0>Hidden on Home";
                    }
                    mb.append(showonhomepagetext);
                    mb.append("</font></a>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("</table>");
                    //End accordion content
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-rightside.gif' align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=100 width=12 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=1 width=25 border=0>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("<tr>");
                    mb.append("<td valign=center align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=1 width=25 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-leftcorner.gif' align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=13 width=12 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-centerbottom.gif' align=left>");
                    mb.append(" ");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-rightcorner.gif' align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=13 width=12 border=0>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("<td valign=center align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=1 width=25 border=0>");
                    mb.append("</td>");
                    mb.append("</table>");



                    mb.append("</div>");

                }


            } else if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPECONTENTPAGE){

                    mb.append("<h3 class=\"display\" title=\""+divTitle+"\">");
                    mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
                    mb.append("<tr>");
                    mb.append("<td valign=center background='images/accordion/greenbar-leftcap.gif' align=left width=13>");
                    mb.append("<img src='images/clear.gif' height=41 width=1 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/greenbar-center.gif' align=left>");
                    mb.append("<font face=arial size=-1 style=\"font-face: arial; text-decoration: none; font-size: 10px; color: #ffffff; font-weight: bold;\">"+navItem.getNestedNavLinkText()+"</font></a>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/greenbar-center.gif' align=right>");
                    //mb.append("<a href='entry.log?logid="+ log.getLogid() +"&action=add' style=\"text-decoration: none\"><font face=arial size=-1 style=\"font-face: arial; text-decoration: none; font-size: 10px; color: #ffffff; font-weight: bold;\">Add Entry</font><img src='../images/plus-icon.gif' width='15' height='15' alt='' border='0' align=top></a>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/greenbar-rightcap.gif' align=right width=13>");
                    mb.append("<img src='images/clear.gif' height=1 width=1 border=0>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("</table>");
                    mb.append("</h3>\n");
                    mb.append("\t\t\t<div class=\"stretcher\">");



                    //New
                    mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
                    mb.append("<tr>");
                    mb.append("<td valign=center align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=1 width=25 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-leftside.gif' align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=100 width=12 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-centerbody.gif' align=left>");
                    //Start accordion content
                    mb.append("<font face=arial size=-2 color=#000000>");
                    mb.append("<a href='logs-contentpage-edit.log?contentpageid="+navItem.getThisNestedNavId()+"'><img src='images/icon-edit.gif' border=0>Edit Static Content Page</a><br>");
                    mb.append("<a href='../contentpage"+navItem.getThisNestedNavId()+".log'><img src='images/icon-post.gif' border=0>View Static Content Page</a><br>");
                    mb.append("<a href='logs-contentpage-delete.log?contentpageid="+navItem.getThisNestedNavId()+"'><img src='images/icon-configure.gif' border=0>Delete</a><br>");
                    mb.append("</font>");
                    //End accordion content
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-rightside.gif' align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=100 width=12 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=1 width=25 border=0>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("<tr>");
                    mb.append("<td valign=center align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=1 width=25 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-leftcorner.gif' align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=13 width=12 border=0>");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-centerbottom.gif' align=left>");
                    mb.append(" ");
                    mb.append("</td>");
                    mb.append("<td valign=center background='images/accordion/accordion-rightcorner.gif' align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=13 width=12 border=0>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("<td valign=center align=left width=12>");
                    mb.append("<img src='images/clear.gif' height=1 width=25 border=0>");
                    mb.append("</td>");
                    mb.append("</table>");
                    //End new






                    mb.append("</div>");

            }

            mb.append("<!-- End NavItem -->");



        }

        //Go get children and append output from each of them.
        //This is the recursive function.
        //@todo Only show logs user can post to
        ArrayList<NestedNavItem> children = collection.getChildrenUserCanView(navItem, userSession.getAccountuser());
        for (Iterator it = children.iterator(); it.hasNext(); ) {
             NestedNavItem childNavItem = (NestedNavItem)it.next();
             mb.append(outputItemHtml(childNavItem, collection, currentNestedLevel+1, userSession, request));
        }

        return mb.toString();
    }





}
