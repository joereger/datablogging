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
        ap.append("        padding-top: 120px; " + "\n");
        ap.append("        padding-bottom: 40px; " + "\n");
        ap.append("      } " + "\n");
        ap.append("    </style>" + "\n");
        ap.append("    <link href=\"/css/twitter-bootstrap-2.0.1/css/bootstrap-responsive.css\" rel=\"stylesheet\">" + "\n");

        //jQuery
        ap.append("<script type=\"text/javascript\" src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/jquery-1.7.1.min.js\"></script>"+"\n");

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


        ap.append("  </body>" + "\n");
        ap.append("</html>" + "\n");

        //Wrap in a plusertemplate
        ap = SiteTemplateProcessor.wrapInPlUserTemplate(ap, pageProps, userSession, request);

        return ap;
    }



    public static StringBuffer pageoutOLD(StringBuffer mb, StringBuffer sc, reger.UserSession userSession, reger.pageFramework.PageProps pageProps, javax.servlet.http.HttpServletRequest request) {

        StringBuffer ap = new StringBuffer();



        //ap.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");

        ap.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");

        ap.append("<html><head><title>" + userSession.getAccount().getSiteRootUrl(userSession) + "/ Admin Section</title>");

        ap.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/nav.css\" type=\"text/css\" />");
        ap.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/cssobjectlayouts.css\" type=\"text/css\" />");
        ap.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/style.css\" type=\"text/css\" />");


        //Twitter Bootstrap
        ap.append("<link href=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/css/bootstrap.css\" rel=\"stylesheet\">\n" +
                "    <link href=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/css/bootstrap-responsive.css\" rel=\"stylesheet\">");

        //jQuery
        ap.append("<script type=\"text/javascript\" src=\""+pageProps.pathToAppRoot+"css/twitter-bootstrap-2.0.1/js/jquery-1.7.1.min.js\"></script>"+"\n");

        //Valums File Uploader
        ap.append("<link href=\""+pageProps.pathToAppRoot+"js/valums-file-uploader-0c701eb/client/fileuploader.css\" rel=\"stylesheet\" type=\"text/css\">");


        ap.append("</head>");
        ap.append("<body bgcolor=#ffffff link='#0000ff' vlink='#0000ff' text='#000000' LEFTMARGIN='0' TOPMARGIN='0' MARGINWIDTH='0' MARGINHEIGHT='0'");
        //Onload handler
        if (pageProps.onloadJavascriptMethod!=null && !pageProps.onloadJavascriptMethod.equals("")){
            ap.append(" onLoad=\""+pageProps.onloadJavascriptMethod+"\"");
        }
        //Onunload handler
        if (pageProps.onunloadJavascriptMethod!=null && !pageProps.onunloadJavascriptMethod.equals("")){
            ap.append(" onUnload=\""+pageProps.onunloadJavascriptMethod+"\"");
        }
        ap.append(">");

       //Figure out what AdminTools and LoggedInBar look like
       StringBuffer appendToTop = new StringBuffer();
       if (userSession.getAccountuser().getIsLoggedIn()){
           appendToTop.append(reger.LoggedInBar.getHtml(userSession, pageProps));
       }
       ap.append(appendToTop);

        //Start dHtml Help Scripts
        mb.append("<!-- Begin dHTML Help Scripts -->");
        mb.append("<DIV id=\"TipLayer\" style=\"visibility:hidden;position:absolute;z-index:1000;top:-100\"></DIV>");
        mb.append("<SCRIPT language=\"JavaScript1.2\" src=\""+pageProps.pathToAppRoot+"js/dhtmlhelp/main.js\"type=\"text/javascript\"></SCRIPT>");
        mb.append("<SCRIPT language=\"JavaScript1.2\" src=\""+pageProps.pathToAppRoot+"js/dhtmlhelp/style.js\" type=\"text/javascript\"></SCRIPT>");
        mb.append("<!-- End dHTML Help Scripts -->");
        //End dHtml Help Scripts

        //Start Top Navbar
        ap.append("<!-- start top navbar-->");


        //NestedNavPanels Object Creation
        NestedNavPanels nnp = new NestedNavPanels(pageProps, userSession, request);
        //NestedNavPanels Open
        ap.append(nnp.getTopHtml());



        ap.append("<!-- end top navbar-->");
        //End Top Navbar






        ap.append("<!-- main outer table with two columns... left and right-->");
        ap.append("<table width=100% cellpadding=0 cellspacing=0 border=0>");




        ap.append("<!-- main outer table center row... left column-->");
        ap.append("<tr><td valign=top align=left bgcolor=#ffffff>");



        //Put the vertical Google banner on the left side if the account isn't Pro or Trial
//        if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && !userSession.getAccount().isPro()){
//            ap.append("<br><font face=arial size=+3>&nbsp;</font><br>");
//            //ap.append(reger.ui.BubbleBox.start("", pageProps.pathToAppRoot));
//            ap.append(reger.Banner.getVerticalGoogleBanner());
//            //ap.append(reger.ui.BubbleBox.end(pageProps.pathToAppRoot));
//            ap.append("<br>") ;
//            ap.append("<br>") ;
//            ap.append("<br>") ;
//        }

        ap.append("<!-- end  left side table -->");
        ap.append("<!-- main outer table... creating gutter-->");
        ap.append("</td><td valign=top nowrap>&nbsp;&nbsp;&nbsp;</td>");
        ap.append("<!-- main outer table... creating right column-->");
        ap.append("</td><td valign=top width=100% >");
        ap.append("<!-- main body of the admin page begins here-->");
        ap.append("<!-- main body of the admin page begins here-->");
        ap.append("<!-- main body of the admin page begins here-->");

        //Page title
        if (pageProps.title!=null && !pageProps.title.equals("")) {
            ap.append("<br><font face=arial size=+3>"+pageProps.title+"</font><br>");
        }

        //Insert main body of Admin Page
        ap.append(mb);
        ap.append("<br><br><br>");

        //Now show footer
        ap.append("<!-- main body of the admin page ends here-->");
        ap.append("<!-- main body of the admin page ends here-->");
        ap.append("<!-- main body of the admin page ends here-->");


        ap.append("</td>");

        ap.append("<!-- Right Column -->");
        ap.append("<td valign=top nowrap>&nbsp;&nbsp;&nbsp;</td>");
        ap.append("<td valign=top>");

        ap.append("<br><font face=arial size=+3>&nbsp;</font><br>");

        ap.append(sc);

        ap.append("</td>");
        ap.append("<!-- End Right Column -->");
        ap.append("<td valign=top nowrap>&nbsp;&nbsp;&nbsp;</td>");
        ap.append("</tr>");



        ap.append("</table>");

        //NestedNavPanels Close
        ap.append(nnp.getBottomHtml());

        ap.append(reger.core.Util.pageFooter(pageProps.pathToAppRoot, userSession.getPl()));

        ap.append("</body>");
        ap.append("</html>");

        //Wrap in a plusertemplate
        ap = SiteTemplateProcessor.wrapInPlUserTemplate(ap, pageProps, userSession, request);


        return ap;
    }






















}