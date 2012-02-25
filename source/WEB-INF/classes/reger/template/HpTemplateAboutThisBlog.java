package reger.template;

import org.apache.commons.io.FilenameUtils;
import reger.UserSession;
import reger.core.db.Db;
import reger.pageFramework.PageProps;

/**
 *
 */
public class HpTemplateAboutThisBlog implements HpTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "About";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "About this blog.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getHtml(UserSession userSession, javax.servlet.http.HttpServletRequest request, PageProps pageProps){

        SiteTemplateTagAboutThisBlog tmp = new SiteTemplateTagAboutThisBlog();
        return tmp.getValue(new StringBuffer(), new StringBuffer(), pageProps, userSession, request);

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        StringBuffer mb = new StringBuffer();

        //Set number to return
        int maxinlist = 15;

//        //Put the header on
//        mb.append("<font face=arial size=-1 class=mediumfont color=#cccccc>");
//        mb.append("Random Images");
//        mb.append("</font>");
//        mb.append("<br>");
//
//        mb.append("<table cellpadding=0 cellspacing=1 border=0>" );
//
//
//        for(int i=0; i<=15; i++){
//            mb.append("<tr>" );
//            mb.append("<td valign=top bgcolor=#ffffff><font face=arial size=-2>" );
//            mb.append("<a href='#'>" );
//            mb.append("<img src='mediaout.log?imageid=-1&isthumbnail=yes' border=0>" );
//            mb.append("</a>" );
//            mb.append("</font></td>" );
//            mb.append("</tr>" );
//        }
//
//
//
//
//        mb.append("</table>" );

        return mb.toString();
    }

}
