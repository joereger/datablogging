package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.pageFramework.PageProps;
import reger.core.db.Db;
import reger.core.db.Db;

import java.util.Calendar;

/**
 *
 */
public class MarketingHpTemplateTagLogTypeList implements MarketingHpTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "LogTypeList";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A list of log types available to this private label.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     * @return
     */
    public String getHtml(UserSession userSession, javax.servlet.http.HttpServletRequest request, PageProps pageProps){

        StringBuffer mb = new StringBuffer();

        mb.append("<table width=100% cellpadding=4 cellspacing=0 border=0>");


        //This code gets the list of eventtypes available to this private label

        int icount=0;
        String listcolor="";


        //-----------------------------------
        //-----------------------------------
        String[][] rstEventtype= Db.RunSQL("SELECT megalogtype.eventtypeid, megalogname FROM megalogtype, pleventtypeid WHERE plid='"+ userSession.getPl().getPlid() +"' AND pleventtypeid.eventtypeid=megalogtype.eventtypeid ORDER BY priority ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstEventtype!=null && rstEventtype.length>0){
            for(int i=0; i<rstEventtype.length; i++){
                icount=icount+1;

                //Alternate Colors
                if (listcolor.equals("#e6e6e6")) {
                    listcolor="#ffffff";
                } else {
                    listcolor="#e6e6e6";
                }

                mb.append("<!-- Begin Button -->");
                mb.append("<tr>");
                mb.append("<td bgcolor='" + listcolor + "' nowrap>");
                //mb.append("<img src='images/clear.gif' width='10' height='1' alt='' border='0'><font face=arial size=-1><b>" + icount + ") </b></font><a href='features.log?eventtypeid=" + rstEventtype[i][0] + "'><!--<img src='../images/icon-log.gif' border=0 align=middle>--><font face=arial size=-1><b>" + rstEventtype[i][1] + "</b></font></a>&nbsp;<br>");
                mb.append("<img src='images/clear.gif' width='10' height='1' alt='' border='0'><a href='signup-log-type-detail.log?eventtypeid=" + rstEventtype[i][0] + "'><font face=arial size=-1><b>" + rstEventtype[i][1] + "</b></font></a>&nbsp;<br>");
                mb.append("</td>");
                mb.append("</tr>");
                mb.append("<!-- End Button -->");

            }
        }

        mb.append("</table>");


        return mb.toString();

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "No preview available.";
    }

}
