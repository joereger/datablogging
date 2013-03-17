package reger.template;

import org.apache.commons.io.FilenameUtils;
import reger.UserSession;
import reger.core.Util;
import reger.core.db.Db;
import reger.pageFramework.PageProps;

/**
 *
 */
public class SiteTemplateTagBackgroundSlideshow implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Background.Slideshow";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A slideshow in your background based on random images from your blog.";
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
     */
    public String getValue(StringBuffer mb, StringBuffer sc, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {

        StringBuffer out = new StringBuffer();

        out.append("<link rel=\"stylesheet\" href=\"/js/buildinternet-supersized-2ccedfd/slideshow/css/supersized.css\" type=\"text/css\" media=\"screen\" />\n" +
                "    <link rel=\"stylesheet\" href=\"/js/buildinternet-supersized-2ccedfd/slideshow/theme/supersized.shutter.css\" type=\"text/css\" media=\"screen\" />\n" +
                "\n" +
                "    <!--<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js\"></script>-->\n" +
                "    <script type=\"text/javascript\" src=\"/js/buildinternet-supersized-2ccedfd/slideshow/js/jquery.easing.min.js\"></script>\n" +
                "\n" +
                "    <script type=\"text/javascript\" src=\"/js/buildinternet-supersized-2ccedfd/slideshow/js/supersized.3.2.7.min.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"/js/buildinternet-supersized-2ccedfd/slideshow/theme/supersized.shutter.min.js\"></script>\n" +
                "\n" +
                "    <script type=\"text/javascript\">\n" +
                "\n" +
                "        jQuery(function($){\n" +
                "\n" +
                "            $.supersized({\n" +
                "\n" +
                "                // Functionality\n" +
                "                fit_landscape           :   1,\n" +
                "                fit_portrait            :   0,\n" +
                "                image_protect           :   0,\n" +
                "                slide_interval          :   1500,\t\t// Length between transitions\n" +
                "                transition              :   1, \t\t\t// 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left\n" +
                "                transition_speed\t\t:\t700,\t\t// Speed of transition\n" +
                "\n" +
                "                // Components\n" +
                "                slide_links\t\t\t\t:\t'blank',\t// Individual links for each slide (Options: false, 'num', 'name', 'blank')\n" +
                "                slides \t\t\t\t\t:  \t[\t\t\t// Slideshow Images\n");


                //Set number to return
                int maxinlist = 50;
                //Get the list
                String sql="SELECT image.imageid, image.image, event.eventid, event.logid, event.title, image.filename, image.description FROM image, event WHERE image.eventid=event.eventid AND  event.accountid='"+ userSession.getAccount().getAccountid() +"' AND "+userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid())+" ORDER BY imageid DESC LIMIT 0,"+maxinlist;
                //-----------------------------------
                //-----------------------------------
                String[][] rstToday= Db.RunSQL(sql);
                //-----------------------------------
                //-----------------------------------
                if (rstToday!=null && rstToday.length>0){
                    int i=0;
                    int counter=0;
                    int activeCounter=0;
                    while(i<rstToday.length && counter<maxinlist){
                        String ext = FilenameUtils.getExtension(rstToday[i][5]);
                        if (ext.toLowerCase().indexOf("jpg")>-1 || ext.toLowerCase().indexOf("gif")>-1 || ext.toLowerCase().indexOf("png")>-1 || ext.toLowerCase().indexOf("bmp")>-1){
                            counter++;
                            String bigurl = "mediaout/file."+ext+"?imageid="+rstToday[i][0];
                            String thumburl =  "mediaout.log?imageid="+rstToday[i][0]+"&isthumbnail=yes";
                            String entryurl = "entry.log?eventid="+rstToday[i][2];
                            //mb.append("  {image : 'http://buildinternet.s3.amazonaws.com/projects/supersized/3.2/slides/kazvan-1.jpg', title : 'Image Credit: Maria Kazvan', thumb : 'http://buildinternet.s3.amazonaws.com/projects/supersized/3.2/thumbs/kazvan-1.jpg', url : 'http://www.nonsensesociety.com/2011/04/maria-kazvan/'},\n");
                            out.append("  {image : '"+bigurl+"', title : '', thumb : '"+thumburl+"', url : '"+entryurl+"'},\n");
                        }
                        i=i+1;
                    }
                }


                //rest of background slideshow js
                out.append("                                            ]\n" +
                "\n" +
                "            });\n" +
                "        });\n" +
                "\n" +
                "    </script>");


                return out.toString();



    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "Hard to preview";
    }

}
