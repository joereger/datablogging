package reger;

/**
 * Displays information in boxes
 */
public class InfoBox {

    public static int BOXTYPEINFO = 1;
    public static int BOXTYPEERROR = 2;
    public static int BOXTYPECOMPLETE = 3;

    public static String getRound(int boxType, String pathToAppRoot, String text){
        StringBuffer mb = new StringBuffer();

        //mb.append("<br>");
        String bgcolor = "ffffff";
        String fontcolor = "000000";
        String bordercolor = "999999";
        if (boxType==BOXTYPEERROR){
            bgcolor = "ff0000";
            fontcolor = "ffffff";
            bordercolor = "000000";
        } else if (boxType==BOXTYPECOMPLETE){
            bgcolor = "00ff00";
            fontcolor = "000000";
            bordercolor = "999999";
        } else {
            bgcolor = "98a8d3";
            fontcolor = "ffffff";
            bordercolor = "666666";
        }
        mb.append(reger.ui.RoundedCorners.start(bgcolor, bordercolor, 100));

		mb.append("<table cellspacing=0 cellpadding=1 border=0>");
		mb.append("<tr>");
		mb.append("<td valign=top>");
		mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=1 border=0>");
		mb.append("</td>");
		mb.append("<td valign=top width=50 align=left>");
		mb.append("<img src='"+pathToAppRoot+getIcon(boxType)+"' border=0 align=center>");
		mb.append("</td>");
		mb.append("<td valign=top>");
		mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=10 border=0>");
		mb.append("</td>");
		mb.append("<td valign=top>");
		mb.append("<font face=arial size=-1 color=#"+fontcolor+"><b>" + text + "</b></font>");
		if (boxType==BOXTYPEERROR){
            mb.append("<br><font face=arial color=#"+fontcolor+" size=-2>Visit the <a href='http://www.reger.com/jforum/'>support forum</a> if you still have questions.</font>");
        }
		mb.append("</td></tr></table>");

        mb.append(reger.ui.RoundedCorners.end());
        mb.append("<br>");




        return mb.toString();
    }

    public static String get(int boxType, String pathToAppRoot, String text){
//        StringBuffer mb = new StringBuffer();
//		mb.append("<br><center>");
//		mb.append("<table width=100% cellpadding=5 cellspacing=0 border=0 class=infobox>");
//		mb.append("<tr><td bgcolor=#ffffff valign=top align=left width=128>");
//		mb.append("<img src='"+pathToAppRoot+getIcon(boxType)+"' border=0 align=center>");
//		mb.append("</td>");
//		mb.append("<td bgcolor=#ffffff valign=left>");
//		mb.append("<font face=arial size=+1 color=#000000><b>" + text + "</b></font>");
//		if (boxType==BOXTYPEERROR){
//            mb.append("<br><font face=arial size=-2>Visit the <a href='http://www.reger.com/jforum/'>support forum</a> if you still have questions.</font>");
//        }
//		mb.append("</td></tr></table></center><br>");


        return getRound(boxType, pathToAppRoot, text);
    }

    private static String getIcon(int boxType){
        if (boxType==BOXTYPEINFO){
            return "images/infobox-info-new.gif";
        } else if (boxType==BOXTYPEERROR){
            return "images/infobox-error-new.gif";
        }  else if (boxType==BOXTYPECOMPLETE){
            return "images/infobox-complete-new.gif";
        }
        return "images/infobox-info.gif";
    }

}
