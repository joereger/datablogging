package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

/**
 *
 */
public class SiteTemplateTagMostRecentFiles implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Most.Recent.File.Thumbnails";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A list of thumbnails drawn from the most recent files that have been uploaded.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     *
     * @param mb
     * @param sc
     * @param pageProps
     * @param userSession
     * @return
     */
    public String getValue(StringBuffer mb, StringBuffer sc, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {
        HpTemplateTagMostRecentFiles mr = new HpTemplateTagMostRecentFiles();
        return mr.getHtml(userSession, request, pageProps);
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       StringBuffer mb = new StringBuffer();

        //Set number to return
        int maxinlist = 15;

        //Put the header on
    

        mb.append("<table cellpadding=0 cellspacing=1 border=0>" );


        for(int i=0; i<=15; i++){
            mb.append("<tr>" );
            mb.append("<td valign=top bgcolor=#ffffff><font face=arial size=-2>" );
            mb.append("<a href='#'>" );
            mb.append("<img src='mediaout.log?imageid=-1&isthumbnail=yes' border=0>" );
            mb.append("</a>" );
            mb.append("</font></td>" );
            mb.append("</tr>" );
        }

        mb.append("</table>" );

        return mb.toString();
    }

}
