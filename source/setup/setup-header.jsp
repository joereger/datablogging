<%
StringBuffer sh = new StringBuffer();

sh.append("<br>");

sh.append("<table width=70% align=center cellpadding=0 cellspacing=0 border=0>");
sh.append("<tr>");
sh.append("<td valign=bottom align=left>");
sh.append("<img src='../images/reger-logo.gif'>");
sh.append("</td>");
sh.append("<td valign=bottom align=right>");
sh.append("<font style=\"font-family: impact, arial; font-size: 75px; color: #e6e6e6;\">");
sh.append("System Setup");
sh.append("</font>");
sh.append("</td>");
sh.append("</tr>");
sh.append("</table>");



sh.append("<table width=75% align=center cellpadding=0 cellspacing=0 border=0>");
sh.append("<tr>");
sh.append("<td valign=top>");
sh.append(reger.ui.ShadowBox.start("../"));

out.print(sh.toString());
%>