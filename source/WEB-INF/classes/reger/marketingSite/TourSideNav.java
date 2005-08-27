package reger.marketingSite;

/**
 * Side Navbar for the tour section of the marketing site.
 */
public class TourSideNav {

    public static StringBuffer navBar(String selectedtab){
        StringBuffer nb = new StringBuffer();


        nb.append("<!-- Begin left side buttons -->");
        nb.append("<table cellspacing='1' cellpadding='1' width=250 border='0'>");

        //Button Begin----------------------
        //@todo Make tour home button highlighting work.
        nb.append("<!-- Begin Button -->");
        nb.append("<tr>");
        nb.append("<td bgcolor="+bgcolor("", selectedtab)+" align=right valign=top>");
            nb.append("<a href='features.log'><font face=arial size=-1 color="+fontcolor("", selectedtab)+"><b>Tour Home</b></font><img src='../images/clear.gif' width='5' height='15' alt='' border='0' align=middle><img src='../images/round-arrow-green.gif' width='15' height='15' alt='' border='0' align=middle></a></td>");
        nb.append("</tr>");
        nb.append("<!-- End Button -->");

        //Button Begin----------------------
        nb.append("<!-- Begin Button -->");
        nb.append("<tr>");
        nb.append("<td bgcolor="+bgcolor("", selectedtab)+" align=right valign=top>");
            nb.append("<a href='signup.log'><font face=arial size=-1 color="+fontcolor("", selectedtab)+"><b>Signup Now</b></font><img src='../images/clear.gif' width='5' height='15' alt='' border='0' align=middle><img src='../images/round-arrow-green.gif' width='15' height='15' alt='' border='0' align=middle></a></td>");
        nb.append("</tr>");
        nb.append("<!-- End Button -->");


        //Now go get the massive features list
        nb.append("<!-- Begin Button -->");
        nb.append("<tr>");
        nb.append("<td bgcolor='#ffffff' align=right valign=top>");
        nb.append(reger.marketingSite.ProFeaturesGrid.getHtml(false, "../"));
        nb.append("</tr>");
        nb.append("<!-- End Button -->");

//


        nb.append("</table>");
        nb.append("<!-- End Left Side Buttons -->");





        return nb;
    }

    private static String bgcolor(String thistab, String selectedtab){
        if (thistab.equals(selectedtab)){
            return "#000000";
        } else {
            return "#cccccc";
        }
    }

    private static String fontcolor(String thistab, String selectedtab){
        if (thistab.equals(selectedtab)){
            return "#ffffff";
        } else {
            return "#000000";
        }
    }

}
