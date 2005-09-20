<%
StringBuffer sf = new StringBuffer();

sf.append(reger.ui.ShadowBox.end("../"));
sf.append("</td>");
sf.append("</tr>");
sf.append("</table>");


sf.append("<table width=70% align=center cellpadding=0 cellspacing=0 border=0>");
sf.append("<tr>");
sf.append("<td valign=bottom align=right>");
sf.append("<a href='http://www.reger.com/jforum/' style=\"text-decoration: none;\">");
sf.append("<font style=\"font-family: impact, arial; font-size: 15px; color: #e6e6e6; text-decoration: none;\">");
sf.append("Questions About Setup?");
sf.append("</font>");
sf.append("</a>");
sf.append("</td>");
sf.append("</tr>");
sf.append("</table>");

out.print(sf.toString());

%>