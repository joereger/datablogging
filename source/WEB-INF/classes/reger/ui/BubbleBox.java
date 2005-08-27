package reger.ui;

/**
 * Pretty little bubble box.
 */
public class BubbleBox {

    public static StringBuffer wholebox(String title, String body, String pathtoapproot){
        StringBuffer mb = new StringBuffer();
        mb.append(start(title, pathtoapproot));
        mb.append(body);
        mb.append(end(pathtoapproot));
        return mb;
    }

    public static StringBuffer start(String title, String pathtoapproot){
        StringBuffer mb = new StringBuffer();

        String titletext = "title";
        if (title.equals("")){
            titletext = "notitle";
        }


        mb.append("<table width=100% cellspacing='0' cellpadding='0' border='0'>");
        mb.append("<tr>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/bubblebox/upperleft-"+titletext+".gif' width=30><img src="+pathtoapproot+"myhome/images/bubblebox/clear.gif width=30></td>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/bubblebox/top-"+titletext+".gif'><img src="+pathtoapproot+"myhome/images/bubblebox/clear.gif width=1 height=5><br><font face=arial size=+1 color=#e6e6e6><b>"+title+"</b></font><br><img src="+pathtoapproot+"myhome/images/bubblebox/clear.gif width=1 height=5></td>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/bubblebox/upperright-"+titletext+".gif' width=30><img src="+pathtoapproot+"myhome/images/bubblebox/clear.gif width=30></td>");
        mb.append("</tr>");

        if (!title.equals("")){
            //mb.append("<tr>");
	        //mb.append("<td bgcolor=#cccccc colspan=3><img src="+pathtoapproot+"myhome/images/bubblebox/clear.gif height=4></td>");
            //mb.append("</tr>");
        }

        mb.append("<tr>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/bubblebox/left.gif'></td>");
        mb.append("<td>");

        return mb;
    }

    public static StringBuffer end(String pathtoapproot){
        StringBuffer mb = new StringBuffer();

        mb.append("</td>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/bubblebox/right.gif'></td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/bubblebox/lowerleft-notitle.gif' width=30><img src="+pathtoapproot+"myhome/images/bubblebox/clear.gif width=30></td>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/bubblebox/bottom.gif'></td>");
        mb.append("<td background='"+pathtoapproot+"myhome/images/bubblebox/lowerright-notitle.gif' width=30><img src="+pathtoapproot+"myhome/images/bubblebox/clear.gif width=30></td>");
        mb.append("</tr>");
        mb.append("</table>");

        return mb;
    }




}
