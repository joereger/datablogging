package reger;

import reger.nav.NestedNavPanels;
import reger.template.SiteTemplateProcessor;

public class tRexAdminPageEngine {



    public static StringBuffer pageout(StringBuffer mb, StringBuffer sc, reger.UserSession userSession, reger.pageFramework.PageProps pageProps, javax.servlet.http.HttpServletRequest request) {

        StringBuffer ap = new StringBuffer();


        ap.append("<!DOCTYPE html>" + "\n");
        ap.append("<html lang=\"en\">" + "\n");
        ap.append("  <head>" + "\n");
        ap.append("    <meta charset=\"utf-8\">" + "\n");

        ap.append("    <title>"+ userSession.getAccount().getSiteRootUrl(userSession) +"/ Administration</title>" + "\n");
        ap.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" + "\n");
        ap.append("    <meta name=\"description\" content=\"\"/>" + "\n");
        ap.append("    <meta name=\"keywords\" content=\"\"/>" + "\n");
        ap.append("    <meta name=\"author\" content=\"Joe Reger, Jr.\">" + "\n");


        //ap.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/nav.css\" type=\"text/css\" />" + "\n");
        //ap.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/cssobjectlayouts.css\" type=\"text/css\" />" + "\n");
        //ap.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/style.css\" type=\"text/css\" />" + "\n");

        ap.append("    <link href=\"/css/twitter-bootstrap-2.0.1/css/bootstrap.css\" rel=\"stylesheet\">" + "\n");
        ap.append("    <style type=\"text/css\">" + "\n");
        ap.append("      body { " + "\n");
        ap.append("        padding-top: 90px; " + "\n");
        ap.append("        padding-bottom: 40px; " + "\n");
        ap.append("      } " + "\n");
        ap.append("    </style>" + "\n");
        ap.append("    <link href=\"/css/twitter-bootstrap-2.0.1/css/bootstrap-responsive.css\" rel=\"stylesheet\">" + "\n");

        //jQuery
        ap.append("<script type=\"text/javascript\" src=\""+pageProps.pathToAppRoot+"js/jQuery/js/jquery-1.7.1.min.js\"></script>"+"\n");
        ap.append("<script type=\"text/javascript\" src=\""+pageProps.pathToAppRoot+"js/jQuery/js/jquery-ui-1.8.18.custom.min.js\"></script>"+"\n");
        ap.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"js/jQuery/css/smoothness/jquery-ui-1.8.18.custom.css\" type=\"text/css\" />"+"\n");

        //prettyPhoto
        ap.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"js/prettyPhoto3.1.3/css/prettyPhoto.css\" type=\"text/css\" />"+"\n");
        ap.append("<script type=\"text/javascript\" src=\""+pageProps.pathToAppRoot+"js/prettyPhoto3.1.3/js/jquery.prettyPhoto.js\"></script>"+"\n");

        ap.append("<link href=\""+pageProps.pathToAppRoot+"css/admin.css\" rel=\"stylesheet\" type=\"text/css\">" + "\n");

        //Valums File Uploader
        ap.append("<link href=\""+pageProps.pathToAppRoot+"js/valums-file-uploader-0c701eb/client/fileuploader.css\" rel=\"stylesheet\" type=\"text/css\">" + "\n");

        ap.append("    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->" + "\n");
        ap.append("    <!--[if lt IE 9]> " + "\n");
        ap.append("      <script src=\"//html5shim.googlecode.com/svn/trunk/html5.js\"></script>" + "\n");
        ap.append("   <![endif]--> " + "\n");

        ap.append("    <!-- Le fav and touch icons -->" + "\n");
        ap.append("    <link rel=\"shortcut icon\" href=\"/favicon.ico\">" + "\n");


        ap.append("  </head>" + "\n");

        ap.append("  <body " + "\n");
        //Onload handler
        if (pageProps.onloadJavascriptMethod!=null && !pageProps.onloadJavascriptMethod.equals("")){
            ap.append(" onLoad=\""+pageProps.onloadJavascriptMethod+"\"");
        }
        //Onunload handler
        if (pageProps.onunloadJavascriptMethod!=null && !pageProps.onunloadJavascriptMethod.equals("")){
            ap.append(" onUnload=\""+pageProps.onunloadJavascriptMethod+"\"");
        }
        ap.append(">"+"\n");

        //Figure out what AdminTools and LoggedInBar look like
//       StringBuffer appendToTop = new StringBuffer();
//       if (userSession.getAccountuser().getIsLoggedIn()){
//           appendToTop.append(reger.LoggedInBar.getHtml(userSession, pageProps));
//       }
//       ap.append(appendToTop);


        //Start dHtml Help Scripts
//        mb.append("<!-- Begin dHTML Help Scripts -->");
//        mb.append("<DIV id=\"TipLayer\" style=\"visibility:hidden;position:absolute;z-index:1000;top:-100\"></DIV>");
//        mb.append("<SCRIPT language=\"JavaScript1.2\" src=\""+pageProps.pathToAppRoot+"js/dhtmlhelp/main.js\"type=\"text/javascript\"></SCRIPT>");
//        mb.append("<SCRIPT language=\"JavaScript1.2\" src=\""+pageProps.pathToAppRoot+"js/dhtmlhelp/style.js\" type=\"text/javascript\"></SCRIPT>");
//        mb.append("<!-- End dHTML Help Scripts -->");
        //End dHtml Help Scripts





        //Start Top Navbar
        ap.append("<!-- Start top navbars-->");

        //NestedNavPanels Object Creation
        NestedNavPanels nnp = new NestedNavPanels(pageProps, userSession, request);
        //NestedNavPanels Open
        ap.append(nnp.getTopHtml());

        ap.append("<!-- End top navbars-->");
        //End Top Navbar


        ap.append("    <div class=\"container\">" + "\n");

        ap.append("     <div class=\"row\">" + "\n");
        ap.append("          <div class=\"span12\">" + "\n");

        ap.append("            <!-- Start Main Body -->" + "\n");
        //Page title
        if (pageProps.title!=null && !pageProps.title.equals("")) {
            ap.append("<br><font face=arial size=+3>"+pageProps.title+"</font><br>");
        }

        //Insert main body of Admin Page
        ap.append(mb);
        ap.append("<br/><br/>"+sc);//On the off chance that something's in there
        ap.append("<br><br><br>");
        ap.append("            <!-- End Main Body -->" + "\n");

        ap.append("          </div>" + "\n");
        ap.append("     </div>" + "\n");



        ap.append("      <br/><br/>" + "\n");
        ap.append("      <hr>" + "\n");

        ap.append("      <footer>" + "\n");
        ap.append("        <p></p>" + "\n");
        ap.append("      </footer>" + "\n");

        ap.append("    </div> <!-- /container -->" + "\n");

         //NestedNavPanels Close
        //ap.append(nnp.getBottomHtml());

        ap.append(reger.core.Util.pageFooter(pageProps.pathToAppRoot, userSession.getPl()));


        ap.append("    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-transition.js\"></script>\n" +
                "    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-alert.js\"></script>\n" +
                "    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-modal.js\"></script>\n" +
                "    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-dropdown.js\"></script>\n" +
                "    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-scrollspy.js\"></script>\n" +
                "    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-tab.js\"></script>\n" +
                "    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-tooltip.js\"></script>\n" +
                "    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-popover.js\"></script>\n" +
                "    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-button.js\"></script>\n" +
                "    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-collapse.js\"></script>\n" +
                "    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-carousel.js\"></script>\n" +
                "    <script src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/bootstrap-typeahead.js\"></script>\n\n");


        ap.append("<script type=\"text/javascript\" charset=\"utf-8\">\n" +
                "  $(document).ready(function(){\n" +
                "    $(\"a[rel^='prettyPhoto']\").prettyPhoto();\n" +
                "  });\n" +
                "</script>");


//        ap.append("\n\n<script>\n" +
//                "\t$(function() {\n" +
//                "\t\t$( \".fieldbox\" ).draggable({ grid: [ 10,10 ], opacity: 0.7, helper: \"clone\" });\n" +
//                "\t});\n" +
//                "\t</script>");

        //Field layout Javascript
//        ap.append("\n\n<script src=\""+pageProps.pathToAppRoot+"js/fieldlayout/customfunctions.js\"></script>\n");
//        ap.append("<script>\n" +
//                "\t$(function() {\n" +
//                "\t\t$( \".fieldbox\" ).draggable({\n" +
//                "\t\t\tstop: function(event, ui){" +
//                "\t\t\tsaveFieldPosition(event, ui);\n" +
//                "\t\t\t}\n" +
//                "\t\t});\n" +
//                "\t});\n" +
//                "\t</script>");


        //Field layout Javascript
        //ap.append("\n\n<script src=\""+pageProps.pathToAppRoot+"js/fieldlayout/customfunctions.js\"></script>\n");

        ap.append("<script>\n" +
                "            $(function() {        \n" +
                "                $('#fieldlayout .sortable-list').sortable({\n" +
                "                    placeholder: 'ui-state-highlight', \n"+
                "                    connectWith: '#fieldlayout .sortable-list',\n" +
                "                    update: function(event, ui){\n" +
                "                        saveSort(event, ui);\n" +
                "                    }\n" +
                "                });\n" +
                "            });\n" +
                "        </script>");




        ap.append("  </body>" + "\n");
        ap.append("</html>" + "\n");

        //Wrap in a plusertemplate
        ap = SiteTemplateProcessor.wrapInPlUserTemplate(ap, pageProps, userSession, request);

        return ap;
    }









}