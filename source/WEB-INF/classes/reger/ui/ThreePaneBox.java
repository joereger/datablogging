package reger.ui;

/**
 * A simple three pane box... initially used for template main page.
 */
public class ThreePaneBox {


    public static String getHtml(String topLeft, String topRight, String bottom){
        StringBuffer mb = new StringBuffer();

        mb.append("<table width=100% cellpadding=5 cellspacing=0 border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top width=25% bgcolor=#cccccc>");
        mb.append(topLeft);
        mb.append("</td>");
        mb.append("<td valign=top width=75% bgcolor=#e6e6e6>");
        mb.append(topRight);
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td valign=top colspan=2>");
        mb.append(bottom);
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");

        return mb.toString();
    }

}
