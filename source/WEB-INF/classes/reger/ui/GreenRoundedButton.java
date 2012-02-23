package reger.ui;

/**
 *
 */
public class GreenRoundedButton {



    public static StringBuffer get(String pathToAppRoot, String textOnButton){
        StringBuffer mb = new StringBuffer();


        mb.append("<a class=\"btn btn-success disabled\" href=\"#\" style=\"width: 100%;\">"+textOnButton+"</a>");


        return mb;
    }

    public static StringBuffer getOLD(String pathToAppRoot, String textOnButton){
        StringBuffer mb = new StringBuffer();
        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td valign=center background='"+pathToAppRoot+"myhome/images/accordion/greenbar-leftcap.gif' align=left width=13>");
        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' height=41 width=1 border=0>");
        mb.append("</td>");
        mb.append("<td valign=center background='"+pathToAppRoot+"myhome/images/accordion/greenbar-center.gif' align=center>");
        mb.append(textOnButton);
        mb.append("</td>");
        mb.append("<td valign=center background='"+pathToAppRoot+"myhome/images/accordion/greenbar-rightcap.gif' align=right width=13>");
        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' height=1 width=1 border=0>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");
        return mb;
    }


}
