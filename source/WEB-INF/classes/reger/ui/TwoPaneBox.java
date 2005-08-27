package reger.ui;

/**
 * A simple three pane box... initially used for template main page.
 */
public class TwoPaneBox {


    public static String getHtml(String topLeft, String topRight){
        StringBuffer mb = new StringBuffer();

        mb.append("<table width=100% cellpadding=5 cellspacing=0 border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top width=25% class=twopaneboxleft bgcolor=#e6e6e6>");
        mb.append(topLeft);
        mb.append("</td>");
        mb.append("<td valign=top width=75% class=twopaneboxright bgcolor=#ffffff>");
        mb.append(topRight);
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");

        return mb.toString();
    }

}
