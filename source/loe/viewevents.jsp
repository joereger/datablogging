
<%@ page import="java.util.*,
                 reger.core.db.Db" %>

<%
/*----------------------------------------------------*/
/*                  Page Config                       */
reger.pageFramework.PageProps pageProps = new reger.pageFramework.PageProps();
pageProps.siteSection=pageProps.MASTERADMINSITE;
pageProps.title = "Those Crazy, Crazy Events";
pageProps.isPasswordProtected = true;
pageProps.navButtonName = "loeeventlog";
pageProps.aclObjectName = "MASTERADMIN";
pageProps.pathToAppRoot="../";
/*----------------------------------------------------*/
%>

<%@ include file="../globalheader.jsp" %>

<%
/*----------------------------------------------------*/
/*                  Main Body                         */
    StringBuffer mb = new StringBuffer();
/*----------------------------------------------------*/


//Delete string
if (pageProps.action.equals("deletesearch") && request.getParameter("searcherror")!=null && !request.getParameter("searcherror").equals("")){

    //-----------------------------------
    //-----------------------------------
    int count = reger.core.db.Db.RunSQLUpdate("DELETE FROM error WHERE description like '%"+reger.core.Util.cleanForSQL(request.getParameter("searcherror"))+"%'");
    //-----------------------------------
    //-----------------------------------

    response.sendRedirect("viewevents.jsp?numdeleted=" + count);
    return;

}

//Delete label
if (pageProps.action.equals("deletelabel")){

    String label = "";
    if (request.getParameter("label")!=null){
        label = request.getParameter("label");
    }

    //-----------------------------------
    //-----------------------------------
    int count = reger.core.db.Db.RunSQLUpdate("DELETE FROM error WHERE label='"+reger.core.Util.cleanForSQL(label)+"'");
    //-----------------------------------
    //-----------------------------------

    response.sendRedirect("viewevents.jsp?numdeleted=" + count);
    return;

}

//Delete old
if (pageProps.action.equals("deleteold")){

    //-----------------------------------
    //-----------------------------------
    int count = reger.core.db.Db.RunSQLUpdate("DELETE FROM error WHERE status='1'");
    //-----------------------------------
    //-----------------------------------

    response.sendRedirect("viewevents.jsp?numdeleted=" + count);
    return;

}

//Delete all
if (pageProps.action.equals("deleteall")){

    //-----------------------------------
    //-----------------------------------
    int count = reger.core.db.Db.RunSQLUpdate("DELETE FROM error");
    //-----------------------------------
    //-----------------------------------

    response.sendRedirect("viewevents.jsp?numdeleted=" + count);
    return;

}

//Delete all not flagged... including new
if (pageProps.action.equals("deleteallnotflagged")){

    //-----------------------------------
    //-----------------------------------
    int count = reger.core.db.Db.RunSQLUpdate("DELETE FROM error WHERE status<>'2'");
    //-----------------------------------
    //-----------------------------------

    response.sendRedirect("viewevents.jsp?numdeleted=" + count);
    return;

}

//Set debug level
if (pageProps.action.equals("setdebuglevel")) {
    if (request.getParameter("debuglevel")!=null && reger.core.Util.isinteger(request.getParameter("debuglevel"))){
        if (Integer.parseInt(request.getParameter("debuglevel"))<=5 && Integer.parseInt(request.getParameter("debuglevel"))>=0){
            reger.core.DegubLevel.setDebugLevel(Integer.parseInt(request.getParameter("debuglevel")));
        }
    }
}

//Update
if (pageProps.action.equals("update")){

    for (Enumeration e = request.getParameterNames(); e.hasMoreElements(); ) {
        String key = (String) e.nextElement();
        String value = request.getParameter(key);

        if (key.length()>7){
            //reger.core.Util.logtodb("key: " + key + " - substring(0,7): " + key.substring(0,7));
        }


        if (key.length()>7 && key.substring(0,7).equals("errorid")){
            int errorid = Integer.parseInt(key.substring(8,key.length()));
            //reger.core.Util.logtodb("key: " + key + " - value: " + value + " - errorid: " + errorid);
            //Update
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE error SET status='"+value+"' WHERE errorid='"+errorid+"'");
            //-----------------------------------
            //-----------------------------------
        }
    }

    response.sendRedirect("viewevents.jsp?currentpage=" + request.getParameter("currentpage"));
    return;

}


mb.append("<br><br>");

String labelSql = "";
if (request.getParameter("label")!=null && !request.getParameter("label").equals("")){
    labelSql = " AND label='"+reger.core.Util.cleanForSQL(request.getParameter("label"))+"' ";
}

int errorcount = 0;
//-----------------------------------
//-----------------------------------
String[][] rstCountErrors= Db.RunSQL("SELECT count(*) FROM error WHERE errorid>'0' "+labelSql);
//-----------------------------------
//-----------------------------------
if (rstCountErrors!=null && rstCountErrors.length>0){
	errorcount = Integer.parseInt(rstCountErrors[0][0]);
	pageProps.title = pageProps.title + " ("+errorcount+")";
}
int currentpage=1;
if (request.getParameter("currentpage")!=null && reger.core.Util.isinteger(request.getParameter("currentpage"))){
    currentpage=Integer.parseInt(request.getParameter("currentpage"));
}
int perpage = 50;
mb.append(reger.pagingLinkPrint.getHtml(errorcount, currentpage, perpage, request));
//Limit vars
int limitMin = (currentpage * perpage) - perpage;
int limitMax = perpage;

if (request.getParameter("numdeleted")!=null){
    mb.append(reger.InfoBox.get(reger.InfoBox.BOXTYPECOMPLETE, pageProps.pathToAppRoot, request.getParameter("numdeleted")+" events deleted."));
}

//Get array of labels
//-----------------------------------
//-----------------------------------
String[][] rstLabels= reger.core.db.Db.RunSQL("SELECT DISTINCT(label) FROM error");
//-----------------------------------
//-----------------------------------
String[] labels = new String[0];
if (rstLabels!=null && rstLabels.length>0){
    labels = new String[rstLabels.length];
    for(int i=0; i<rstLabels.length; i++){
        labels[i] = rstLabels[i][0];
    }
}


//Start the page display


mb.append("<table cellpadding=10 cellspacing=0 border=0>");
mb.append("<tr>");
mb.append("<td valign=top>");
mb.append("<form action=viewevents.jsp method=post>");
mb.append("<input type=submit value='Delete All'>");
mb.append("<input type=hidden name=action value=deleteall>");
mb.append("</form>");
//mb.append("</td>");
//mb.append("<td valign=top>");
mb.append("<form action=viewevents.jsp method=post>");
mb.append("<input type=submit value='Delete All Not Flagged'>");
mb.append("<input type=hidden name=action value=deleteallnotflagged>");
mb.append("</form>");
//mb.append("</td>");
//mb.append("<td valign=top>");
mb.append("<form action=viewevents.jsp method=post>");
mb.append("<input type=submit value='Delete Old'>");
mb.append("<input type=hidden name=action value=deleteold>");
mb.append("</form>");
mb.append("</td>");
mb.append("<td valign=top>");
mb.append("<form action=viewevents.jsp method=post>");
mb.append("<font face=arial size=-2>Delete events that contain the following string:</font><br>");
mb.append("<input type=hidden name=action value=deletesearch>");
mb.append("<input type=text name=searcherror value='' size=15 maxlength=500>");
mb.append("<input type=submit value='Delete'>");
mb.append("</form>");
mb.append("<form action=viewevents.jsp method=post>");
mb.append("<font face=arial size=-2>Delete events that contain the following label:</font><br>");
mb.append("<input type=hidden name=action value=deletelabel>");
mb.append("<select name=label>");
for (int i = 0; i < labels.length; i++) {
    mb.append("<option value=\""+reger.core.Util.cleanForHtml(labels[i])+"\">"+labels[i]+"</option>");
}
mb.append("</select>");
mb.append("<input type=submit value='Delete'>");
mb.append("</form>");
mb.append("</td>");
mb.append("<td valign=top>");
mb.append("<form action=viewevents.jsp method=get>");
mb.append("<font face=arial size=-2>Show only events that contain the following label:</font><br>");
mb.append("<select name=label>");
for (int i = 0; i < labels.length; i++) {
    mb.append("<option value=\""+reger.core.Util.cleanForHtml(labels[i])+"\">"+labels[i]+"</option>");
}
mb.append("</select>");
mb.append("<input type=submit value='Show'>");
mb.append("</form>");
mb.append("</td>");
mb.append("<td valign=top nowrap>");
mb.append("<form action=viewevents.jsp method=post>");
mb.append("<input type=hidden name=action value=setdebuglevel>");
mb.append("<font face=arial size=-2>Debug level:</font><br>");
mb.append("<select name=debuglevel style=\"font-size: 20px;\">");
for(int i=0; i<=5; i++){
    mb.append("<option value="+i);
    if (i==reger.core.DegubLevel.getDebugLevel()){
        mb.append(" selected");
    }
    mb.append(">");
    mb.append(" " + i + " ");
    mb.append("</option>");
}
mb.append("</select>");
mb.append("<input type=submit value='Set'>");
mb.append("</form>");
mb.append("</td>");
mb.append("</tr>");
mb.append("<tr>");
mb.append("<td valign=top colspan=4>");
mb.append("<form action=viewevents.jsp method=post>");
mb.append("<input type=submit value='Update Statuses'>");
mb.append("<input type=hidden name=action value=update>");
mb.append("<input type=hidden name=currentpage value='"+currentpage+"'>");
mb.append("</td>");
mb.append("</tr>");
mb.append("</table>");


mb.append("<table cellpadding=5 cellspacing=0 width=100% border=1>");





//-----------------------------------
//-----------------------------------
    String[][] rs = reger.core.db.Db.RunSQL("SELECT errorid, description, date, status, accountid, error.count, label FROM error WHERE errorid>0 "+labelSql+" ORDER BY errorid DESC LIMIT "+ limitMin +","+ limitMax);
//-----------------------------------
//-----------------------------------
    if (rs!=null && rs.length>0){
        for(int i=0; i<rs.length; i++){
            mb.append("<tr>");
            //Status
            String bgcolor = "";
            String status = rs[i][3];
            if (status.equals("0")){
                bgcolor = "#ff0000";
            } else if (status.equals("1")) {
                bgcolor = "#cccccc";
            } else if (status.equals("2")) {
                bgcolor = "#00ff00";
            } else {
                bgcolor = "#ff0000";
                status = "0";
            }
            String isChecked="";

            //Status
            mb.append("<td valign=top bgcolor="+bgcolor+" align=left>");
            mb.append("<font face=arial size=-1>");
            if (status.equals("0")){
                isChecked="checked";
            } else {
                isChecked="";
            }
            mb.append("<input type=radio name=errorid-"+rs[i][0]+" value='0' "+isChecked+">");
            mb.append("New");
            mb.append("<br>");
            if (status.equals("1")){
                isChecked="checked";
            } else {
                isChecked="";
            }
            mb.append("<input type=radio name=errorid-"+rs[i][0]+" value='1' "+isChecked+">");
            mb.append("Old");
            mb.append("<br>");
            if (status.equals("2")){
                isChecked="checked";
            } else {
                isChecked="";
            }
            mb.append("<input type=radio name=errorid-"+rs[i][0]+" value='2' "+isChecked+">");
            mb.append("Flag");
            mb.append("<br>");
            mb.append("</font>");
            mb.append("</td>");
            //Date
            mb.append("<td valign=top align=left nowrap>");
            mb.append("<font face=arial size=-2>");
            mb.append(rs[i][2]);
            mb.append("</font>");
            mb.append("</td>");
            //Count
            mb.append("<td valign=top align=left nowrap>");
            mb.append("<font face=arial size=-2>");
            if (!rs[i][5].equals("")){
                mb.append(rs[i][5]);
            } else {
                mb.append("1");
            }
            mb.append("</font>");
            mb.append("</td>");
            //Error description
            mb.append("<td valign=top align=left>");
            mb.append("<font face=arial size=-1>");
            mb.append(rs[i][1]);
            mb.append("</font>");
            mb.append("</td>");
            //Accountid
            mb.append("<td valign=top align=left>");
            mb.append("<font face=arial size=-1>");
            if (!rs[i][4].equals("")){
                mb.append("<a href='accountdetail.log?accountid="+rs[i][4]+"'>");
                mb.append(rs[i][4]);
                mb.append("</a>");
            } else {
                mb.append("&nbsp;");
            }
            mb.append("</font>");
            mb.append("</td>");
            //Label
            mb.append("<td valign=top align=left>");
            mb.append("<font face=arial size=-1>");
            if (!rs[i][6].equals("")){
                mb.append("<a href='viewevents.jsp?label="+rs[i][6]+"'>");
                mb.append(rs[i][6]);
                mb.append("</a>");
            } else {
                mb.append("&nbsp;");
            }
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
        }
    } else {
        mb.append("<td valign=top align=left colspan=5>");
        mb.append("<font face=arial size=-1>");
        mb.append("No logged events found.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");
    }


mb.append("</form>");
mb.append("</table>");



%>


<%
/*----------------------------------------------------*/
/*                  Side Column                       */
    StringBuffer sc = new StringBuffer();
/*----------------------------------------------------*/

    //sc.append("This is a ");
    //sc.append("side column section.");
%>


<%@ include file="../globalfooter.jsp" %>







