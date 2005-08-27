package reger;

/**
 * Displays information in boxes
 */
public class InfoBox {

    public static int BOXTYPEINFO = 1;
    public static int BOXTYPEERROR = 2;
    public static int BOXTYPECOMPLETE = 3;

    public static String get(int boxType, String pathToAppRoot, String text){
        StringBuffer mb = new StringBuffer();


		mb.append("<br><center>");
		mb.append("<table width=100% cellpadding=5 cellspacing=0 border=0 class=infobox>");
		mb.append("<tr><td bgcolor=#ffffff valign=top align=left width=128>");
		mb.append("<img src='"+pathToAppRoot+getIcon(boxType)+"' border=0 align=center>");
		mb.append("</td>");
		mb.append("<td bgcolor=#ffffff valign=left>");
		mb.append("<font face=arial size=+1 color=#000000><b>" + text + "</b></font>");
		mb.append("</td></tr></table></center><br>");


        return mb.toString();
    }

    private static String getIcon(int boxType){
        if (boxType==BOXTYPEINFO){
            return "images/infobox-info.gif";
        } else if (boxType==BOXTYPEERROR){
            return "images/infobox-error.gif";
        }  else if (boxType==BOXTYPECOMPLETE){
            return "images/infobox-complete.gif";
        }
        return "images/infobox-info.gif";
    }

}
