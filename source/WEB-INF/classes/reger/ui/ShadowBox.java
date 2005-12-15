package reger.ui;

/**
 * Pretty little shadow box.
 */
public class ShadowBox {

    public static StringBuffer wholebox(String body, String pathtoapproot){
        StringBuffer mb = new StringBuffer();
        mb.append(start(pathtoapproot));
        mb.append(body);
        mb.append(end(pathtoapproot));
        return mb;
    }

    public static StringBuffer start(String pathtoapproot){
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellspacing=0 width=100% cellpadding=0 border=0>");
        mb.append("<tr>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/shadowbox/corner-upper-left.gif' width=26><img src='"+pathtoapproot+"images/clear.gif' width=26 height=23></td>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/shadowbox/border-top.gif'></td>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/shadowbox/corner-upper-right.gif' width=26><img src='"+pathtoapproot+"images/clear.gif' width=26 height=23></td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/shadowbox/border-left.gif'></td>");
        mb.append("<td valign=top bgcolor=#ffffff>");
        mb.append("<font face=arial size=-2>");

        return mb;
    }

    public static StringBuffer end(String pathtoapproot){
        StringBuffer mb = new StringBuffer();

        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/shadowbox/border-right.gif'></td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/shadowbox/corner-lower-left.gif'><img src='"+pathtoapproot+"images/clear.gif' width=26 height=23></td>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/shadowbox/border-bottom.gif'></td>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/shadowbox/corner-lower-right.gif'><img src='"+pathtoapproot+"images/clear.gif' width=26 height=23></td>");
        mb.append("</tr>");
        mb.append("</table>");

        return mb;
    }




}
