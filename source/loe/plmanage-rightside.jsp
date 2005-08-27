
<%

sc.append("<!-- Begin Right Side Pl List -->");

sc.append("<br><br>");

sc.append("<DIV class=bluebox>");

sc.append("<table cellpadding=5 cellspacing=1 border=0>");

sc.append("<tr><td valign=top nowrap>");
sc.append("<font face=arial size=-1><strong>");
sc.append("<a href='plmanage.log?action=addstart'>");
sc.append("<img src='../images/plus-icon.gif' width='15' height='15' alt='' border='0'>");
sc.append("Add New PL</strong>");
sc.append("</font>");
sc.append("</a><br>");
sc.append("</td></tr>");


//-----------------------------------
//-----------------------------------
String[][] rstData= Db.RunSQL("SELECT plid, plname FROM pl WHERE islive='1'");
//-----------------------------------
//-----------------------------------
if (rstData!=null && rstData.length>0){
	for(int i=0; i<rstData.length; i++){
	    sc.append("<tr><td valign=top nowrap>");
	    sc.append("<DIV class=yellowbox>");
        sc.append("<font face=arial size=-1><strong>"+rstData[i][0]+") <a href='plmanage.log?action=editstart&plid="+rstData[i][0]+"'>"+rstData[i][1]+"</strong></font></a>");
        sc.append("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='pleventtype.log?plid="+rstData[i][0]+"'><font face=arial size=-2><strong>Log Types</strong></font></a>");
        sc.append("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='pltemplates.log?plid="+rstData[i][0]+"'><font face=arial size=-2><strong>Templates</strong></font></a>");
        sc.append("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='plpeers.log?plid="+rstData[i][0]+"'><font face=arial size=-2><strong>Peers</strong></font></a>");
        sc.append("</DIV>");
        sc.append("</td></tr>");
	}
}

sc.append("</table>");

sc.append("</DIV>");

sc.append("<br><br>");

sc.append("<!-- End Right Side Pl List -->");

%>