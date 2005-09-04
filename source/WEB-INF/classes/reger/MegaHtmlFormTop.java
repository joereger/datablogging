package reger;

import reger.core.Debug;

/**
 *
 */
public class MegaHtmlFormTop {

    public static StringBuffer getHtml(reger.UserSession userSession, reger.pageFramework.PageProps pageProps, boolean displayasadmin, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();


        //Output in RSS
//        try{
//            mb.append(reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append(reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append("<script type=\"text/xml\">");
//            mb.append(reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append("<!-- This is the entry represented as an RSS 2.0 feed.  It is encapsulated inside of a script tag. -->");
//            mb.append(reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append(RssRome.getFeed(userSession, 0, 1, "rss_2.0", "", pageProps.entry.eventid));
//            mb.append(reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append("</script>");
//            mb.append(reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append(reger.Vars.LINEBREAKCHARFORHTML);
//        } catch (Exception e){
//            reger.core.Util.errorsave(e, "Problem outputting entry as rss 2.0 inside of the entry html.");
//        }

        //Output structuredblogging method
        try{
            mb.append(reger.Vars.LINEBREAKCHARFORHTML);
            mb.append(reger.Vars.LINEBREAKCHARFORHTML);
            mb.append(reger.EntryXmlRenderer.getWrappedInHtmlScript(pageProps.entry));
            mb.append(reger.Vars.LINEBREAKCHARFORHTML);
            mb.append(reger.Vars.LINEBREAKCHARFORHTML);
        } catch (Exception e){
            Debug.errorsave(e, "", "Problem outputting entry as structured blogging xml.");
        }


        boolean editLayout = false;
        String disabledFormText = "";
        if (request.getParameter("mode")!=null && request.getParameter("mode").equals("editlayout")){
            editLayout = true;
            disabledFormText = "disabled=\"true\"";
        }

        //This is the hidelayer/showlayer
        mb.append("<SCRIPT language=\"JavaScript1.2\" src=\""+pageProps.pathToAppRoot+"js/hideshowlayer.js\" type=\"text/javascript\"></SCRIPT>");


        //Popup script
        mb.append(reger.core.Util.popup());

        //Leave entry page script
        mb.append("<script type='text/javascript' src='"+pageProps.pathToAppRoot+"/js/leaveentrypage.js'></script>" + reger.Vars.LINEBREAKCHARFORHTML);


        //This displays the top of the main body and the top of the input/edit form
        mb.append("<br>");


        String submitstring="";
        if (displayasadmin) {
            if (pageProps.logProps.megalogtypeicon.equals("")) {
                pageProps.logProps.megalogtypeicon="logmega.gif";
            }

            //mb.append("<img src='../images/logimages/"+ pageProps.logProps.megalogtypeicon +"' width=100 height=50 border=0 align=top>");


            if (pageProps.action.equals("edit") || pageProps.action.equals("editsubmit")) {
                mb.append("<span style=\"background: #f6f6f6; float: right; border: 1px dotted #999; padding:3px; width: 25%;\">");
                mb.append("<font face=arial size=-2>Add <a href='entry.log?logid="+pageProps.logProps.logid+"&action=default'>default values</a> to "+reger.core.Util.cleanForHtml(pageProps.logProps.megalogname)+" for faster logging.</font><br>");
                mb.append("<font face=arial size=-2>Post to this log via <a href='tools-emailapi-emailaddresses.log'>email</a>.</font><br>");
                mb.append("</span>");
                mb.append("<img src='../images/logimages/"+ pageProps.logProps.megalogtypeicon +"' width=100 height=50 border=0 align=top>");
                mb.append("<font face=arial size=+3>Edit Log Entry: "+ reger.core.Util.cleanForHtml(pageProps.logProps.megalogname)+"</font><br>");
                mb.append("<div style=\"clear:both;\"><br><br></div>");
            } else if (pageProps.action.equals("default") || pageProps.action.equals("defaultsubmit")) {
                mb.append("<span style=\"background: #f6f6f6; float: right; border: 1px dotted #999; padding:3px; width: 25%;\">");
                mb.append("<font face=arial size=-1><b>These default values make it faster and easier to log.  You can always change values when you create or edit an entry.</b></font><br>");
                mb.append("</span>");
                mb.append("<img src='../images/logimages/"+ pageProps.logProps.megalogtypeicon +"' width=100 height=50 border=0 align=top>");
                mb.append("<font face=arial size=+3>Default Values For: "+reger.core.Util.cleanForHtml(pageProps.logProps.megalogname)+"</font><br>");
                mb.append("<div style=\"clear:both;\"><br><br></div>");
            } else {
                //Override with some settings for layout mode
                if (request.getParameter("mode")!=null && request.getParameter("mode").equals("editlayout")){
                    mb.append("<font face=arial size=+3>Customize Log Fields: "+reger.core.Util.cleanForHtml(pageProps.logProps.megalogname)+"</font><br>");
                    mb.append(reger.InfoBox.get(reger.InfoBox.BOXTYPEINFO, pageProps.pathToAppRoot, "You are now customizing the activity-specific fields of this log.  You can change the arrangement of fields, edit the properties of a field, add new fields and remove fields.  When you're done, click Off to go back to normal entry mode."));
                }  else {
                    mb.append("<span style=\"background: #f6f6f6; float: right; border: 1px dotted #999; padding:3px; width: 25%;\">");
                    mb.append("<font face=arial size=-2>Add <a href='entry.log?logid="+pageProps.logProps.logid+"&action=default'>default values</a> to this log for faster logging.</font><br>");
                    mb.append("<font face=arial size=-2>Post to this log via <a href='tools-emailapi-emailaddresses.log'>email</a>.</font><br>");
                    mb.append("<font face=arial size=-2><a href='logs-log-properties.log?logid="+pageProps.logProps.logid+"'>Customize</a> this log.</font><br>");
                    mb.append("</span>");
                    mb.append("<img src='../images/logimages/"+ pageProps.logProps.megalogtypeicon +"' width=100 height=50 border=0 align=top>");
                    mb.append("<font face=arial size=+3>Add Log Entry: "+reger.core.Util.cleanForHtml(pageProps.logProps.megalogname)+"</font><br>");
                    mb.append("<div style=\"clear:both;\"><br><br></div>");

                }
            }



            if (pageProps.action.equals("edit")) {
                submitstring="editsubmit";
            } else if (pageProps.action.equals("editsubmit")) {
                submitstring="editsubmit";
            } else if (pageProps.action.equals("leavepage")) {
                submitstring="leavepage";
            } else if (pageProps.action.equals("default")) {
                submitstring="defaultsubmit";
            } else if (pageProps.action.equals("defaultsubmit")) {
                submitstring="defaultsubmit";
            } else {
                if (pageProps.entry.eventid>0){
                    submitstring="editsubmit";
                } else {
                    submitstring="addsubmit";
                }
            }


        }

//        if (pageProps.entry.gooddata==false && !pageProps.entry.errortext.equals("")) {
//            mb.append(reger.InfoBox.get(reger.InfoBox.BOXTYPEERROR, pageProps.pathToAppRoot,pageProps.entry.errortext));
//        }




        if (displayasadmin) {

            //Start form
            if (!editLayout){
                mb.append("<form name='entryform' id='entryform' method='post' action='entry.log' name='post'>");
                //dHtml jscalendar - also note script call below date/time fields
                String initialDate = pageProps.entry.yyyy+"-"+(pageProps.entry.mm+1)+"-"+pageProps.entry.dd+" "+pageProps.entry.h+":"+pageProps.entry.m+" "+pageProps.entry.ampm.toUpperCase();
                mb.append(reger.MegaHtmlFormJscalendar.scriptHtmlSetup(pageProps.pathToAppRoot, initialDate));
                mb.append("<input type=hidden name=action value='"+submitstring+"'>");
                mb.append("<input type=hidden name=eventid value='"+pageProps.entry.eventid+"'>");
                mb.append("<input type=hidden name=logid value="+pageProps.logProps.logid+">");
                mb.append("<input type=hidden name=popuphref value="+request.getParameter("popuphref")+">");
                mb.append("<input type=hidden name=gotopage id='gotopage' value="+request.getParameter("gotopage")+">");
                mb.append("<input type=hidden name=originalEntryTextBeforeSpellcheck value=\""+reger.core.Util.cleanForHtml(pageProps.entry.originalEntryTextBeforeSpellcheck)+"\">");
                //Return to AdminTools
                if (request.getParameter("returntoadmintools")!=null && !request.getParameter("returntoadmintools").equals("")){
                    mb.append("<input type=hidden name=returntoadmintools value="+request.getParameter("returntoadmintools")+">");
                }
            }

        }





        //---------------------------------------------------------
        //---------------------------------------------------------
        //Now we decide whether to put the default form up or the regular form up
        if (pageProps.action.equals("default") || pageProps.action.equals("defaultsubmit")) {
            //Default top
            mb.append("<!-- begin  log entry table -->");
            //mb.append("<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 ><tr><td>");
            mb.append("<table cellpadding=5 cellspacing=1  border=0>");

            //Else display the normal form
        } else {
           if (!displayasadmin) {
                if (userSession.getAccountuser().userCanAuthorLog(pageProps.logProps.logid)){
                    mb.append("<a href='myhome/entry.log?eventid="+pageProps.entry.eventid+"&action=edit'><font face=arial size=-1 class=mediumfont>Edit this Entry</font></a>");
                }
           }


            mb.append("<!-- begin  log entry table -->");



            //mb.append("<table cellpadding=0 cellspacing=0 border=0 bgcolor='#999999' width=100% ><tr><td>");
            mb.append("<table cellpadding=5 cellspacing=1 width=100% bgcolor='#999999' border=0>");



            mb.append("<tr>");
            //Month
            mb.append("<td bgcolor='#cccccc' width=50 align=left valign=top class=logentryheader>");
            if (displayasadmin){


                mb.append("<select name='mm' id=\"j_mm\" "+disabledFormText+">");
                for(int i=0; i<=11; i++){
                    mb.append("<option value='" + i + "' ");
                    if (i==pageProps.entry.mm) {
                        mb.append("selected");
                    }
                    mb.append(">" + (i+1) + "</option>");
                }
                mb.append("</select>");
            } else {
                mb.append((pageProps.entry.mm+1));
            }
            mb.append("<br><font face=arial size=-2 class=smallfont>Month</font></td>");

            //Day
            mb.append("<td bgcolor='#cccccc' width=50 align=left valign=top class=logentryheader>");
            if (displayasadmin) {
                mb.append("<select name='dd' id=\"j_dd\" "+disabledFormText+">");
                for(int i=1; i<=31; i++){
                    mb.append("<option value='" + i + "' ");
                    if (i==pageProps.entry.dd) {
                        mb.append("selected");
                    }
                    mb.append(">" + i + "</option>");
                }
                mb.append("</select>");
            } else {
                mb.append(pageProps.entry.dd);
            }
            mb.append("<br><font face=arial size=-2 class=smallfont>Day</font></td>");

            //Year
            mb.append("<td bgcolor='#cccccc' width=50 align=left valign=top class=logentryheader>");
            if (displayasadmin) {
                mb.append("<select name='yyyy' id=\"j_yyyy\" "+disabledFormText+">");
                for(int i=1900; i<=2020; i++){
                    mb.append("<option value='" + i + "' ");
                    if (i==pageProps.entry.yyyy) {
                        mb.append("selected");
                    }
                    mb.append(">" + i + "</option>");
                }
                mb.append("</select>");
            } else {
                mb.append(pageProps.entry.yyyy);
            }
            mb.append("<br><font face=arial size=-2 class=smallfont>Year</font></td>");

            //Title
            mb.append("<td bgcolor='#ffffff' align=left valign=top nowrap width=100% colspan=3 class=logentryheader>");
            //@todo Tabindex working on main entry page
            if (displayasadmin) {
                mb.append("<font face=arial size=-1><b>Title:</b></font><br>");
                mb.append("<input type='text' name='title' maxlength=255 size=40 value=\"" + reger.core.Util.cleanForHtml(pageProps.entry.title) + "\" tabindex=1 "+disabledFormText+">");
            } else {
                mb.append(reger.core.Util.cleanForHtml(pageProps.entry.title));
            }
            mb.append("</td>");

            mb.append("</tr>");

            //Hour
            mb.append("<tr><td bgcolor='#cccccc' align=left valign=top class=logentryheader>");
            if (displayasadmin) {
                mb.append("<select name='h' id=\"j_h\" "+disabledFormText+">");
                int h=pageProps.entry.h;
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
                int h=pageProps.entry.h;
                if (h>=13) {
                    h=h-12;
                } else if (h==0){
                    h=12;
                }
                mb.append(h);
            }
            mb.append("<br><font face=arial size=-2 class=smallfont>Hour</font></td>");

            //Minute
            mb.append("<td bgcolor='#cccccc' align=left valign=top class=logentryheader>");
            if (displayasadmin) {
                mb.append("<select name='m' id=\"j_m\" "+disabledFormText+">");
                for(int i=0; i<=59; i++){
                    mb.append("<option value='" + i + "' ");
                    if (i==pageProps.entry.m) {
                        mb.append("selected");
                    }
                    mb.append(">" + i + "</option>");
                }
                mb.append("</select>");
            } else {
                mb.append(pageProps.entry.m);
            }
            mb.append("<br><font face=arial size=-2 class=smallfont>Minute</font></td>");

            //AMPM
            mb.append("<td bgcolor='#cccccc' align=left valign=top class=logentryheader>");
            if (displayasadmin) {
                mb.append("<select name='ampm' id=\"j_ampm\" "+disabledFormText+">");
                mb.append("<option value='AM' ");
                if (pageProps.entry.ampm!=null && pageProps.entry.ampm.equals("AM")) {
                    mb.append("selected");
                }
                mb.append(">AM</option>");
                mb.append("<option value='PM' ");
                if (pageProps.entry.ampm!=null && pageProps.entry.ampm.equals("PM")) {
                    mb.append("selected");
                }
                mb.append(">PM</option>");
                mb.append("</select>");
            } else {
                if (pageProps.entry.ampm!=null && pageProps.entry.ampm.equals("AM")) {
                    mb.append("AM");
                } else {
                    mb.append("PM");
                }
            }

            mb.append("</td>");

            //Comments
            mb.append("<td bgcolor='#ffffff' align=left valign=top rowspan=5 colspan=3 class=logentrycontent>");

            //Update the entrymode if necessary
            if (request.getParameter("toggleentrymode")!=null && request.getParameter("toggleentrymode").equals("true")){
                userSession.getAccountuser().toggleEntryMode();
            }

            //Show the editor or the post itself
            if (!editLayout){
                mb.append(reger.MegaHtmlFormEditor.getHtml(userSession, pageProps, displayasadmin));
            }

            mb.append("</td>");
            mb.append("</tr>");


            //Show the timezone
            mb.append("<tr><td colspan=3 bgcolor=#cccccc valign=top class=logentryheader>");
            mb.append("<font face=arial size=-2 class=smallfont>Timezone: <b>"+pageProps.entry.entryTimezoneid+"</b></font>");
            mb.append("</td></tr>");

            //Show the calendar chooser or the Ago Text
            mb.append("<tr><td colspan=3 bgcolor=#cccccc valign=top class=logentryheader>");
            if (displayasadmin){
                if (!editLayout){
                    mb.append("<a href='#' id=\"f_trigger_a\"><img src=\""+pageProps.pathToAppRoot+"js/jscalendar/img.gif\" id=\"f_trigger_a\" style=\"cursor: pointer; border: 1px solid red;\" title=\"Date selector\" onmouseover=\"this.style.background='red';\" onmouseout=\"this.style.background=''\"/><font face=arial size=-2><b>Date Chooser</b></font></a>" + "\n");
                    //dhtml Date script - must go below forms for best compatibility
                    mb.append(reger.MegaHtmlFormJscalendar.theScript(pageProps));
                }
            } else {
                mb.append(reger.core.TimeUtils.agoText(reger.core.TimeUtils.convertFromOneTimeZoneToAnother(pageProps.entry.getCalendar(), userSession.getAccount().getTimezoneid(), "GMT")));
            }
            mb.append("</td></tr>");



            //Show the author
            mb.append("<tr><td colspan=3 bgcolor=#cccccc valign=top class=logentryheader>");
            //mb.append("<font face=arial size=-2 class=smallfont>Author: <b><a href='"+pageProps.pathToAppRoot+"author.log?accountuserid="+pageProps.entry.accountuserid+"' onclick=\"leaveEntryPage(this.href); return false;\">"+pageProps.entry.author+"</b></font>");
            if (!editLayout){
                mb.append("<font face=arial size=-2 class=smallfont>Author: <b><a href='"+pageProps.pathToAppRoot+"author.log?accountuserid="+pageProps.entry.accountuserid+"'>"+pageProps.entry.author+"</b></font>");
            }
            mb.append("</td></tr>");


            //Editor toggle
            mb.append("<tr height=100% ><td colspan=3 bgcolor=#cccccc valign=top class=logentryheader>");
            if (displayasadmin) {
                //mb.append("<font face=arial size=-2>This is the date and time that you want to appear on the log entry.<br><br>");

                //Display the toggle entry mode link
                if (!editLayout){
                    if (userSession.getAccountuser().getEntrymode()==1) {
                        mb.append("<font face=arial size=-2>If your browser is having trouble displaying this page then go</font> ");
                        //mb.append("<a href='entry.log?toggleentrymode=true&action=edit&logid="+ pageProps.logProps.logid +"&eventid=" + pageProps.entry.eventid + "' onclick=\"leaveEntryPage(this.href); return false;\">");
                        mb.append("<a href='entry.log?toggleentrymode=true&action=edit&logid="+ pageProps.logProps.logid +"&eventid=" + pageProps.entry.eventid + "'>");
                        mb.append("<br><font face=arial size=-1 color=#0000ff><b>To Simple Entry Mode</b></font>");
                        mb.append("</a>");
                        mb.append("<br>");
                    } else {
                        mb.append("<font face=arial size=-2>If you're using Internet Explorer 4+ want to try more advanced text formatting then go</font><br>");
                        //mb.append("<a href='entry.log?toggleentrymode=true&action=edit&logid="+ pageProps.logProps.logid +"&eventid=" + pageProps.entry.eventid + "' onclick=\"leaveEntryPage(this.href); return false;\">");
                        mb.append("<a href='entry.log?toggleentrymode=true&action=edit&logid="+ pageProps.logProps.logid +"&eventid=" + pageProps.entry.eventid + "'>");
                        mb.append("<font face=arial size=-1 color=#0000ff><b>To Advanced Entry Mode</b></font>");
                        mb.append("</a>");
                        mb.append("<br>");
                    }
                }
                mb.append("</font><br>");
            }
            mb.append("</td></tr>");

            mb.append("<!-- Start log-type-specific fields -->");

        } //End if that looks for default form




        return mb;
    }


}
