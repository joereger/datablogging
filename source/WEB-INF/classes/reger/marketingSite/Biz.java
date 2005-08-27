package reger.marketingSite;

/**
 *
 */
public class Biz {

    public static StringBuffer leftNav(String pathToAppRoot){
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellpadding=5 cellspacing=1 width=100% border=0>");

        mb.append(mainButton("Business Overview", "index.log", pathToAppRoot));

        mb.append(mainButton("Contact Us", "contactus.log", pathToAppRoot));

        mb.append(mainButton("What is datablogging?", "what-is-datablogging.log", pathToAppRoot));
        mb.append(smallButton("Adding Custom Fields to a Log", "what-is-datablogging-newfield.log", pathToAppRoot));
        mb.append(smallButton("Graph Custom Data", "what-is-datablogging-graphs.log", pathToAppRoot));
        mb.append(smallButton("Advanced Search Using Data", "what-is-datablogging-search.log", pathToAppRoot));
        mb.append(smallButton("RSS Includes Custom Data", "what-is-datablogging-rss.log", pathToAppRoot));
        mb.append(smallButton("RSS Embedded in Html", "what-is-datablogging-rss-in-html.log", pathToAppRoot));
        mb.append(smallButton("Structured Blogging Support", "what-is-datablogging-preliminary-structured-blogging-support.log", pathToAppRoot));
        mb.append(smallButton("Log Types as XML Schema", "what-is-datablogging-xml-schema.log", pathToAppRoot));
        mb.append(smallButton("Advanced Data Search + Graphing", "what-is-datablogging-graphandsearch.log", pathToAppRoot));



        mb.append(mainButton("Knowledge Management", "knowledge-management.log", pathToAppRoot));
        mb.append(smallButton("An ROI Analysis", "knowledge-management-roi.log", pathToAppRoot));
        mb.append(smallButton("Launching into an Organization", "knowledge-management-launching.log", pathToAppRoot));


        mb.append(mainButton("Industries", "industries.log", pathToAppRoot));
        mb.append(smallButton("Portals/Aggregators", "industries-portals.log", pathToAppRoot));
        mb.append(smallButton("Telco Carriers", "industries-telco.log", pathToAppRoot));
        mb.append(smallButton("OEM", "industries-oem.log", pathToAppRoot));
        mb.append(smallButton("Music Industry", "industries-music.log", pathToAppRoot));
        mb.append(smallButton("Newspaper/Magazine Publishers", "industries-publishers.log", pathToAppRoot));
        mb.append(smallButton("Marketers", "industries-marketers.log", pathToAppRoot));
        mb.append(smallButton("Military", "industries-military.log", pathToAppRoot));
        mb.append(smallButton("Politicians", "industries-politicians.log", pathToAppRoot));
        mb.append(smallButton("Education", "industries-education.log", pathToAppRoot));
        mb.append(smallButton("Corporate IT", "industries-corporateit.log", pathToAppRoot));
        mb.append(smallButton("Radio", "industries-radio.log", pathToAppRoot));

        mb.append(mainButton("Products", "products.log", pathToAppRoot));
        mb.append(smallButton("Enterprise Web Logging Service", "productsenterpriseweblogging.log", pathToAppRoot));
        mb.append(smallButton("Private Labeling", "productsprivatelabel.log", pathToAppRoot));
        mb.append(smallButton("Camera Phone Service", "productscamphone.log", pathToAppRoot));
        mb.append(smallButton("Corporate Intranet", "productscorpintranet.log", pathToAppRoot));
        mb.append(smallButton("VIP Web Log", "productsvipweblog.log", pathToAppRoot));
        mb.append(smallButton("Custom Log Type Development", "productscustomlogtype.log", pathToAppRoot));
        mb.append(smallButton("Data API Service", "productsapiservice.log", pathToAppRoot));







        mb.append(mainButton("Technology", "technology.log", pathToAppRoot));
        mb.append(smallButton("Deployment Options", "technology-deploymentoptions.log", pathToAppRoot));


        mb.append(mainButton("Press/Media", "pr-overview.log", pathToAppRoot));
        mb.append(smallButton("Storylines", "pr-storylines.log", pathToAppRoot));

        mb.append(mainButton("Investors", "investors.log", pathToAppRoot));



        mb.append("</table>");

        return mb;
    }

    public static StringBuffer mainButton(String text, String url, String pathToAppRoot){
        StringBuffer mb = new StringBuffer();

        mb.append("<tr>");
        mb.append("<td align=left valign=top bgcolor=#e6e6e6 colspan=3>");
        mb.append("<font face=arial size=-1 class=mainbutton>");
        mb.append("<img src='"+pathToAppRoot+"about/images/arrow-sm-yellow.gif' width=9 height=9 border=0 align=middle>");
        mb.append(" ");
        mb.append("<a href='"+url+"'>");
        mb.append(text);
        mb.append("</a>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        return mb;
    }

    public static StringBuffer smallButton(String text, String url, String pathToAppRoot){
        StringBuffer mb = new StringBuffer();

        mb.append("<tr>");
        mb.append("<td align=left valign=top width=5>");
        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=5 height=1 border=0>");
        mb.append("</td>");
        mb.append("<td align=right valign=top width=9>");
        mb.append("<img src='"+pathToAppRoot+"about/images/arrow-sm-yellow.gif' width=9 height=9 border=0 align=middle>");
        //mb.append("<font face=arial size=-2 class=smallbutton>");
        //mb.append("</font>");
        mb.append("</td>");
        mb.append("<td align=left valign=top>");

        //mb.append(" ");
        mb.append("<a href='"+url+"'>");
        mb.append("<font face=arial size=-2 class=smallbutton>");
        mb.append(text);
        mb.append("</font>");
        mb.append("</a>");

        mb.append("</td>");
        mb.append("</tr>");

        return mb;
    }

    public static StringBuffer pageTitle(String title){
        StringBuffer mb = new StringBuffer();

        mb.append("<br><br>");
        mb.append("<font face=arial size=+2 color=#666666 class=pagetitle>");
        mb.append("<strong>");
        mb.append(title);
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("<br><br>");

        return mb;
    }

    public static StringBuffer getCss(){
        StringBuffer mb = new StringBuffer();

        mb.append("<style type=\"text/css\">");


        mb.append("blockquote");
        mb.append("{");
            mb.append("color:#000000;");
            mb.append("font-family: Geneva, Arial, Helvetica, Swiss, SunSans-Regular;");
            mb.append("font-size:12px;");
        mb.append("}");

        mb.append("a");
        mb.append("{");
            mb.append("color:#0000ff;");
            mb.append("font-size:12px;");
        mb.append("}");

        mb.append("a:hover");
        mb.append("{");
            mb.append("background-color:#e6e6e6;");
            mb.append("color:#000000;");
            mb.append("font-size:12px;");
        mb.append("}");

        mb.append(".headertitle");
        mb.append("{");
            mb.append("color:#ffffcc;");
            mb.append("font-weight:bold;");
            mb.append("font-family: Geneva, Arial, Helvetica, Swiss, SunSans-Regular;");
            mb.append("font-size:45px;");
        mb.append("}");

        mb.append(".pagetitle");
        mb.append("{");
            mb.append("color:#999999;");
            mb.append("font-weight:bold;");
            mb.append("font-family: Geneva, Arial, Helvetica, Swiss, SunSans-Regular;");
            mb.append("font-size:35px;");
        mb.append("}");

        mb.append("h1");
        mb.append("{");
            mb.append("color:#999999;");
            mb.append("font-weight:bold;");
            mb.append("font-family: Geneva, Arial, Helvetica, Swiss, SunSans-Regular;");
            mb.append("font-size:20px;");
        mb.append("}");

        mb.append(".mainbutton");
        mb.append("{");
            mb.append("font-weight:bold;");
            mb.append("font-family: Geneva, Arial, Helvetica, Swiss, SunSans-Regular;");
            mb.append("font-size:15px;");
        mb.append("}");

        mb.append(".smallbutton");
        mb.append("{");
            mb.append("font-weight:bold;");
            mb.append("font-family: Geneva, Arial, Helvetica, Swiss, SunSans-Regular;");
            mb.append("font-size:10px;");
        mb.append("}");



        mb.append("</style>");

        return mb;
    }

}
