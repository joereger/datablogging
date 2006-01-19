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

        Debug.debug(5, "", "NestedNavDisplayAdminHome.java - Navbar start.");
        mb.append(reger.ui.BubbleBox.start("My Logs", "../"));
        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#ffffff>");
        mb.append("<tr>");
        //mb.append("<td valign=bottom align=left bgcolor="+ cellbgcolor +" nowrap><font face=arial size=-2 color=#666666></font></td>");
        mb.append("<td valign=bottom align=left bgcolor="+ cellbgcolor +" nowrap><font face=arial size=-2 color=#666666></font></td>");
        String helpLastEntry = Help.tip("Last Entry", "Shows how long ago the most recently dated entry was made.", false, "../");
        mb.append("<td valign=center align=center bgcolor="+ cellbgcolor +"><font face=arial size=-2 color=#666666>Last Entry</font></td>");
        String helpNoEntries = Help.tip("Total Entries", "The number of entries that have been made in this log.", false, "../");
        mb.append("<td valign=center align=center bgcolor="+ cellbgcolor +"><font face=arial size=-2 color=#666666>Total Entries</font></td>");
        String helpShowOnHp = reger.Help.tip("Show on Homepage","Your web log homepage is an important place. It's the place where your visitors get their first glimpse of you and where they find updates.<br><br>Sometimes you want to keep track of things and keep them public, but you don't necessarily want them to take up space on your homepage.<br><br>This feature allows you to have a log's entries not appear on the home page. Note: This is different than making a log private.<br><br>By deciding to not show on the homepage you are not restricting access to the log... you are just making users click the log directly before they see its log entries.",false,"../");
        mb.append("<td valign=center align=center bgcolor="+ cellbgcolor +"><font face=arial size=-2 color=#666666></font></td>");
        String helpAccess = reger.Help.tip("Log Access", "Your logs can be Public or Private.  Private logs are not visible to anybody who does not have the password to your site.  Change the access rules for each log by clicking the link in this column.", false, "../");
        mb.append("<td valign=center align=left bgcolor="+ cellbgcolor +"><font face=arial size=-2 color=#666666></font></td>");
        mb.append("</tr>");



        mb.append(outputItemHtml(new NestedNavItemBase(), userSession.getAccount().getNestedNavCollection(), 0, userSession, request));



        //New Log Anybody?
        mb.append("<tr>");
        mb.append("<td valign=top align=left bgcolor=#e6e6e6 colspan=5 nowrap><a href='logs-newlog.log'><img src='images/add_16.gif' width=16 height=16 border=0 align=middle><font face=arial size=-1 color=#0000ff><b>Create a New Log</b></a></td>");
        mb.append("</tr>");
        mb.append("</table><!-- End navigation -->");
        mb.append(reger.ui.BubbleBox.end("../"));

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



                    //Top line
                    mb.append("<tr>");
                    mb.append("<td valign=top align=left bgcolor=#999999 colspan=5><img src='../images/white.gif' border=0 width="+nestingPixels+" height=5></td>");
                    mb.append("</tr>");

                    //Each log type output
                    mb.append("<tr>");
                    mb.append("<td align=left valign=top bgcolor=#ffffff class=adminhometopborder><img src='images/clear.gif' border=0 width="+nestingPixels+" height=1><a href='entry.log?logid="+ log.getLogid() +"&action=add'><!--img src='../images/plus-icon.gif' width='15' height='15' alt='' border='0'--><font face=arial size=-1 color=#0000ff style=\"font-size: 16px;\"><b>"+ log.getName() +"</b></a></td>");
                    mb.append("<td align=center valign=top bgcolor=#ffffff nowrap class=adminhometopborder><font face=arial size=-2 color=#000000>"+ lastentrydate +"</td>");
                    mb.append("<td align=center valign=top bgcolor=#ffffff nowrap class=adminhometopborder><font face=arial size=-2 color=#000000>"+ entrycount +"</td>");
                    mb.append("<td valign=top align=left bgcolor='#e6e6e6' nowrap rowspan=2 class=adminhomelogactions>");
                    mb.append("<font face=arial size=-2 color=#000000>");
                    mb.append("<a href='entry.log?logid="+log.getLogid()+"&action=add'><img src='images/icon-edit.gif' border=0>Add an Entry</a><br>");
                    mb.append("<a href='../logmain"+log.getLogid()+".log'><img src='images/icon-post.gif' border=0>View this Log</a><br>");
                    mb.append("<a href='logs-log-properties.log?logid="+log.getLogid()+"'><img src='images/icon-configure.gif' border=0>Customize this Log</a><br>");
                    mb.append("<a href='people-friends-invite.log?logid="+log.getLogid()+"'><img src='images/icon-configure.gif' border=0>Invite Friends</a><br>");
                    //mb.append("<br>");
                    //mb.append("<a href='logs-log-delete.log?logid="+log.getLogid()+"'><img src='images/icon-delete.gif' border=0>Delete this Log</a><br>");
                    mb.append("</font>");
                    mb.append("</td>");
                    mb.append("<td valign=center align=left bgcolor='#e6e6e6' class=adminhomeprivate><a href='logs-log-properties.log?logid="+log.getLogid()+"'><font face=arial size=-2 color=#0000ff>"+ logaccesstext +"</font></a></td>");
                    mb.append("</tr>");



                    mb.append("<tr>");
                    mb.append("<td valign=top align=left bgcolor='#ffffff' colspan=3>");

                    //mb.append("<a href='traffic.log'><font face=arial size=-2 color=#000000>Traffic Stats</font></a><br>");
                    //mb.append("<a href='people-friends-invite.log'><font face=arial size=-2 color=#000000>Invite Friends</font></a><br>");
                    mb.append("");
                    mb.append("</td>");
                    mb.append("<td valign=center align=left bgcolor='#e6e6e6' class=adminhomevisible>");
                    //Create showonhomepagetext
                    mb.append("<font face=arial size=-2 color=#0000ff><a href='logs-log-properties.log?logid="+log.getLogid()+"'>");
                    String showonhomepagetext = "<img src='../images/home-visible.gif' border=0>Visible on Home";
                    if (!log.getShowonhomepage()){
                        showonhomepagetext = "<img src='../images/home-hidden.gif' border=0>Hidden on Home";
                    }
                    mb.append(showonhomepagetext);
                    mb.append("</font></a>");
                    mb.append("</td>");
                    mb.append("</tr>");

                    //Bottom White space
                    mb.append("<tr>");
                    mb.append("<td valign=top align=left bgcolor=#ffffff colspan=5><img src='images/clear.gif' border=0 width=1 height=15></td>");
                    mb.append("</tr>");

                }


            } else if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPECONTENTPAGE){



                    //Top line
                    mb.append("<tr>");
                    mb.append("<td valign=top align=left bgcolor=#999999 colspan=5><img src='../images/white.gif' border=0 width="+nestingPixels+" height=5></td>");
                    mb.append("</tr>");

                    //Each log type output
                    mb.append("<tr>");
                    mb.append("<td align=left valign=top bgcolor=#ffffff class=adminhometopborder><img src='images/clear.gif' border=0 width="+nestingPixels+" height=1><a href='logs-contentpage-edit.log?contentpageid="+navItem.getThisNestedNavId()+"'><!--img src='../images/plus-icon.gif' width='15' height='15' alt='' border='0'--><font face=arial size=-1 color=#0000ff style=\"font-size: 16px;\"><b>"+ navItem.getNestedNavLinkText() +"</b></a></td>");
                    mb.append("<td align=center valign=top bgcolor=#ffffff nowrap class=adminhometopborder><font face=arial size=-2 color=#000000>&nbsp;</td>");
                    mb.append("<td align=center valign=top bgcolor=#ffffff nowrap class=adminhometopborder><font face=arial size=-2 color=#000000>&nbsp;</td>");
                    mb.append("<td valign=top align=left bgcolor='#e6e6e6' nowrap colspan=2 class=adminhomecpactions>");
                    mb.append("<font face=arial size=-2 color=#000000>");
                    mb.append("<a href='logs-contentpage-edit.log?contentpageid="+navItem.getThisNestedNavId()+"'><img src='images/icon-edit.gif' border=0>Edit Static Content Page</a><br>");
                    mb.append("<a href='../contentpage"+navItem.getThisNestedNavId()+".log'><img src='images/icon-post.gif' border=0>View Static Content Page</a><br>");
                    mb.append("<a href='logs-contentpage-delete.log?contentpageid="+navItem.getThisNestedNavId()+"'><img src='images/icon-configure.gif' border=0>Delete</a><br>");
                    mb.append("</font>");
                    mb.append("</td>");
                    mb.append("</tr>");


                    //Bottom White space
                    mb.append("<tr>");
                    mb.append("<td valign=top align=left bgcolor=#ffffff colspan=5><img src='images/clear.gif' border=0 width=1 height=15></td>");
                    mb.append("</tr>");

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
