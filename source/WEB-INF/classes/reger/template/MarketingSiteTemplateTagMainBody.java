package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.pageFramework.PageProps;

import java.util.Calendar;

import org.apache.commons.io.FilenameUtils;

/**
 *
 */
public class MarketingSiteTemplateTagMainBody implements MarketingSiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Main.Body";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The main body of the marketing site page.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getHtml(StringBuffer mb, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request){

        StringBuffer hd = new StringBuffer();

//        if (!FilenameUtils.getName(request.getServletPath()).equals("signup.log")){
//            hd.append("<table cellpadding=0 width=150 align=right cellspacing=0 border=0>");
//            hd.append("<tr>");
//            hd.append("<td align=left>");
//            hd.append("</td>");
//            hd.append("<td align=right width=150>");
//            hd.append(reger.ui.GreenRoundedButton.get("../", "<a href='signup.log' style=\"color: #ffffff; text-decoration: none;\"><font face=arial size=-1 color=#ffffff><b>Sign Up Now!</b></font></a>"));
//            hd.append("</td>");
//            hd.append("</tr>");
//            hd.append("</table>");
//            hd.append("<br clear=all>");
//        }

        return hd.toString() + mb.toString();

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "No preview available.";
    }

}
