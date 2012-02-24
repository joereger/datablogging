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


        String type = "";
        if (boxType==BOXTYPEINFO){
            type = "alert-info";
        } else if (boxType==BOXTYPEERROR){
            type = "alert-error";
        } else if (boxType==BOXTYPECOMPLETE){
            type = "alert-success";
        }

		mb.append("    <div class=\"alert "+type+"\">\n" +
                "    <a class=\"close\" data-dismiss=\"alert\">×</a>\n" +
                "    <strong>"+text+"</strong>\n" +
                "    </div>");




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
//		mb.append("</td></tr></table></center><br>");


        return getRound(boxType, pathToAppRoot, text);
    }


}
