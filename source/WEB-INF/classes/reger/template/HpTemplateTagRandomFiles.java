package reger.template;

import org.apache.commons.io.FilenameUtils;
import reger.UserSession;
import reger.core.Util;
import reger.core.db.Db;
import reger.pageFramework.PageProps;

/**
 *
 */
public class HpTemplateTagRandomFiles implements HpTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Random.File.Thumbnails";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A random list of thumbnails drawn from available files that have been uploaded.";
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

        StringBuffer mb = new StringBuffer();

        //Set number to return
        int maxinlist = 10;

        //Put the header on
//        mb.append("<font face=arial size=-1 class=mediumfont color=#cccccc>");
//        mb.append("Random Images");
//        mb.append("</font>");
//        mb.append("<br>");

        //Limit to logid, if required
        String logidSql = "";
        if (pageProps.logProps.logid>0){
            logidSql = " AND event.logid='"+pageProps.logProps.logid+"'";
        }

        //Get the list
        String sql="SELECT image.imageid, image.image, event.eventid, event.logid, event.title, image.filename, image.description FROM image, event WHERE image.eventid=event.eventid AND  event.accountid='"+ userSession.getAccount().getAccountid() +"' AND "+userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid())+" "+logidSql+" ORDER BY RAND() DESC LIMIT 0,"+maxinlist;




        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstToday!=null && rstToday.length>0){
        	int i=0;
            int counter=0;
            int activeCounter=0;

            mb.append("<h2>Random Images</h2>");

            //mb.append("<div style=\"width:100%; text-align:right;\">"+"\n");
            mb.append("<div style=\"width:100px;\">"+"\n");
            mb.append("<ul class=\"thumbnails\">"+"\n");






        	while(i<rstToday.length && counter<maxinlist){


                String ext = FilenameUtils.getExtension(rstToday[i][5]);



                if (ext.toLowerCase().indexOf("jpg")>-1 || ext.toLowerCase().indexOf("gif")>-1 || ext.toLowerCase().indexOf("png")>-1 || ext.toLowerCase().indexOf("bmp")>-1){
                    counter++;




                    String bigurl = "mediaout/file."+ext+"?imageid="+rstToday[i][0];
                    String thumburl =  "mediaout.log?imageid="+rstToday[i][0]+"&isthumbnail=yes";
                    String entryurl = "entry.log?eventid="+rstToday[i][2];

                    mb.append("<li>"+"\n");
                    mb.append("<a class=\"thumbnail\" href=\""+bigurl+"\" rel=\"prettyPhoto[ImagesRandomPics]\" title=\"<a href='"+entryurl+"'>"+Util.cleanRemoveDoubleQuotes(rstToday[i][4])+"</a>\" >"+"\n");
                    mb.append("<img alt=\"<a href='"+entryurl+"'>"+Util.cleanRemoveDoubleQuotes(rstToday[i][4])+"</a>\" src=\""+thumburl+"\" width=\"100\" >"+"\n");
                    mb.append("</a>"+"\n");
                    mb.append("</li>"+"\n");


                }




                i=i+1;

        	}

            mb.append("</ul>"+"\n");
            mb.append("</div>"+"\n");
            //mb.append("</div>"+"\n");

        }



        return mb.toString();

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
