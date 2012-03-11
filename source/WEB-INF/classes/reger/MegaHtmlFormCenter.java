package reger;

import reger.mega.FieldLayout;
import reger.mega.Field;
import reger.pageFramework.PageProps;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class MegaHtmlFormCenter {

    public static StringBuffer getHtml(reger.UserSession userSession, PageProps pageProps, boolean displayasadmin, HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        boolean editLayout = false;
        String disabledFormText = "";
        if (request.getParameter("mode")!=null && request.getParameter("mode").equals("editlayout")){
            editLayout = true;
            disabledFormText = "disabled=\"true\"";
        }

        //Set the logid and eventtypeid
        int logid = 0;


        mb.append("<div class=\"row\">");
        mb.append("<div class=\"span2\">");
        mb.append("<br/>");
        mb.append("</div>");
        mb.append("<div class=\"span10\">");


//        if (displayasadmin && userSession.getAccountuser().userCanDoAcl("MASTERADMIN", userSession.getAccount().getAccountid())){
//            //Display the link to turn edit fields on/off
//
//            mb.append("<table cellpadding=5 cellspacing=1 border=0 class=greysolidborder>");
//            mb.append("<tr>");
//            mb.append("<td bgcolor=#e6e6e6 align=left>");
//
//            mb.append("<font face=arial size=-2>");
//            mb.append("Customize this log's datablogging fields: ");
//            mb.append("</font>");
//            mb.append("<font face=arial size=-1 color=#333333>");
//            mb.append("<b>");
//            if (editLayout){
//                mb.append("On");
//                mb.append(" | ");
//                mb.append("<a href='entry.log?logid="+pageProps.logProps.logid+"&action=add' onclick=\"javascript: savelayout();\">");
//                mb.append("Off");
//                mb.append("</a>");
//            } else {
//                mb.append("<a href='entry.log?logid="+pageProps.logProps.logid+"&mode=editlayout'>");
//                mb.append("On");
//                mb.append("</a>");
//                mb.append(" | ");
//                mb.append("Off");
//            }
//
//            mb.append(" &nbsp;&nbsp;&nbsp; ");
//            StringBuffer helpContent = new StringBuffer();
//            helpContent.append("Did you know that you're able to customize/add extra data fields?  These fields will be added to your log entries.  You'll be able to graph, search and publish this data quickly and easily.  It's called datablogging.  Click the On button to get started.  Drag the fields around.  Edit some.  Then click Off to get back to logging.");
//            helpContent.append("</ul>");
//            String help = reger.Help.tip("Turn Customization On/Off", helpContent.toString(), false, pageProps.pathToAppRoot);
//            mb.append(help);
//
//
//            mb.append("</b>");
//            mb.append("</font>");
//            mb.append("</td>");
//            mb.append("</tr>");
//            mb.append("</table>");
//            mb.append("<img src=images/clear.gif width=1 height=2 border=0>");
//        }

        //Define mode
        int LAYOUTMODE = FieldLayout.LAYOUTMODEPUBLIC;
        if (displayasadmin){
            if (editLayout){
                //Process any layout changes
                FieldLayout.processLayoutChange(request);
                LAYOUTMODE = FieldLayout.LAYOUTMODEEDIT;
            } else {
                LAYOUTMODE = FieldLayout.LAYOUTMODEADMIN;
            }
        }

        //Display the fields
        mb.append(FieldLayout.getHtml(0, pageProps.logProps.logid, LAYOUTMODE, userSession, "entry.log", "logs-field.log", "logs-newfield.log", pageProps));

        mb.append("</div>");
        mb.append("</div>");
        mb.append("<br/><br/>");



        return mb;
    }

}
