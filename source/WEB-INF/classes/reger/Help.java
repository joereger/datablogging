package reger;

/**
 * The help subsystem class.
 */
public class Help {

    /**
     * The preferred way to call for an html help button because it doesn't require a database call.
     */
    public static String tip(String title, String body, boolean stayInPlace, String pathtoroot){
        StringBuffer sb = new StringBuffer();

        sb.append(htmlTipLink(title, body, stayInPlace));
        sb.append("<img src='"+pathtoroot+"images/help-question.gif' border=0>");
        sb.append("</a>");

        return sb.toString();
    }

    public static String spellTip(String title, String body, boolean stayInPlace, String word){
        StringBuffer sb = new StringBuffer();

        sb.append(htmlTipLink(title, body, stayInPlace));
        sb.append(word);
        sb.append("</a>");

        return sb.toString();
    }

    public static StringBuffer htmlTipLink(String title, String body, boolean stayInPlace){
        StringBuffer sb = new StringBuffer();

        if (title.equals("")){
            title = "Help";
        }

        if (stayInPlace){
            sb.append("<a href=\"#\" onMouseOver=\"stm(['"+reger.core.Util.cleanForjavascript(title)+"','"+reger.core.Util.cleanForjavascript(body)+"'],Style[1])\" onmouseout=\"htm()\">");
        } else {
            sb.append("<a href=\"#\" onMouseOver=\"stm(['"+reger.core.Util.cleanForjavascript(title)+"','"+reger.core.Util.cleanForjavascript(body)+"'],Style[0])\" onmouseout=\"htm()\">");
        }

        return sb;
    }

    public static StringBuffer htmlLinkPopup(String helpkey, String pathtoroot){
        StringBuffer sb = new StringBuffer();

        sb.append("<a href='"+pathtoroot+"myhome/help-popup.log?helpkey="+helpkey+"' onClick=\"window.open('','helppopup','height=425, width=350, scrollbars=yes, resizable=yes, toolbar=no, menubar=no')\" target='helppopup'>");

        return sb;
    }

    public static StringBuffer helpOnEachPage(String helpText, String pathToAppRoot){
        //Format the text
        StringBuffer mb = new StringBuffer();
        mb.append("<table cellpadding=4 cellspacing=0 border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top width=31>");
        //mb.append("<img src='"+pathToAppRoot+"myhome/images/shadowbox/help-icon.gif'>");
        mb.append("<img src='"+pathToAppRoot+"myhome/images/shadowbox/help-person.gif' align=left>");
        mb.append("</td>");
        mb.append("<td valign=top>");
        mb.append("<font face=arial size=-1 color=#666666>");
        mb.append("<strong>");
        mb.append(helpText);
        //mb.append("<br><br>");
        mb.append("</font>");
//        mb.append("<font face=arial size=-2 color=#666666>");
//        mb.append("<a href='"+pathToAppRoot+"myhome/index.log?action=togglehelp'>");
//        mb.append("Turn Help Off");
//        mb.append("</a>");
//        mb.append("</font>");
        mb.append("</strong>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");

        //Now put into a box
        StringBuffer sb = new StringBuffer();
        sb.append(reger.ui.ShadowBox.wholebox(mb.toString(), pathToAppRoot));

        return sb;
    }

    
}
