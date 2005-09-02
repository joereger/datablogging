package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.pageFramework.PageProps;
import reger.core.db.Db;

import java.util.Calendar;

/**
 *
 */
public class HpTemplateTagMostRecentFiles implements HpTemplateTag{

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
     * @return
     */
    public String getHtml(UserSession userSession, javax.servlet.http.HttpServletRequest request, PageProps pageProps){

        StringBuffer mb = new StringBuffer();

        //Set number to return
        int maxinlist = 15;

        //Put the header on
//        mb.append("<font face=arial size=-1 class=mediumfont color=#cccccc>");
//        mb.append("Most Recent Images");
//        mb.append("</font>");
//        mb.append("<br>");

        //Limit to logid, if required
        String logidSql = "";
        if (pageProps.logProps.logid>0){
            logidSql = " AND event.logid='"+pageProps.logProps.logid+"'";
        }

        //Get the list
        String sql="SELECT image.imageid, image.image, event.eventid, event.logid, event.title FROM image, event WHERE image.eventid=event.eventid AND event.accountid='"+ userSession.getAccount().getAccountid() +"' AND "+userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid())+" AND "+reger.Entry.sqlOfLiveEntry+" "+logidSql+" ORDER BY event.date DESC, image.order ASC LIMIT 0,"+maxinlist;

        mb.append("<table cellpadding=0 cellspacing=1 border=0>" );

        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstToday!=null && rstToday.length>0){
        	int i=0;
            int counter=0;
        	while(i<rstToday.length && counter<maxinlist){
        		counter=counter+1;

        		mb.append("<tr>" );
                //mb.append("<td valign=top bgcolor=#ffffff align=right nowrap><font face=arial size=-2>" );
                //mb.append("<strong>" );
                //mb.append(counter);
                //mb.append("&nbsp;&nbsp;</strong>" );
                //mb.append("</font></td>" );
                String entryurl=reger.Entry.entryFileNameStatic(Integer.parseInt(rstToday[i][3]), Integer.parseInt(rstToday[i][2]), rstToday[i][4]);
                mb.append("<td valign=top bgcolor=#ffffff><font face=arial size=-2>" );
                mb.append("<a href='"+entryurl+"'>" );
                mb.append("<img src='../mediaout.log?imageid="+ rstToday[i][0] +"&isthumbnail=yes' border=0>" );
                mb.append("</a>" );
                mb.append("</font></td>" );
                mb.append("</tr>" );

                i=i+1;

        	}
        }

        mb.append("</table>" );

        return mb.toString();

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
