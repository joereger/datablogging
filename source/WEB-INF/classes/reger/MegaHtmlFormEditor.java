package reger;

/**
 *
 */
public class MegaHtmlFormEditor {

    public static StringBuffer getHtml(reger.UserSession userSession, reger.pageFramework.PageProps pageProps, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();


        if (userSession.getAccountuser().getEntrymode()==reger.Vars.ENTRYMODESIMPLE) {
            //Get the text-based editor
            mb.append("\n" + "<script language=\"JavaScript\"><!--" + "\n");
            mb.append("function submitPost() {" + "\n");
            //mb.append("    document.entryform.submit();" + "\n");
            mb.append("    xGetElementById('entryform').submit();");
            mb.append("}" + "\n");
            mb.append("//--></script>" + "\n");

            mb.append("\n" + "<script language=\"JavaScript\"><!--" + "\n");
            mb.append("function appendImageTag(imageid) {" + "\n");
            mb.append("    $(\"#entrybodyinput\").append('<$image id=\"' + imageid + '\"$>');");
            //mb.append("    $(\"#entrybodyinput\").append('<$image id=\"').append($imageid).append('\"$>');");
            mb.append("}" + "\n");
            mb.append("//--></script>" + "\n");

            //mb.append("<textarea cols='45' rows='10' name='comments' wrap='virtual' style='width: 75%;font: 10pt monospace' class=\"expandify\">"+pageProps.entry.comments+"</textarea>");
            //mb.append("<textarea name=\"comments\" id=\"entrybodyinput\" wrap=\"virtual\" rows=\"10\" style=\"overflow: hidden; height: 200px; width: 100%;\" class=\"expand200-200000\">"+pageProps.entry.comments+"</textarea>");
            //mb.append("<textarea name=\"comments\" id=\"entrybodyinput\" wrap=\"virtual\" rows=\"10\" style=\"overflow: hidden; height: 200px; width: 100%;\">"+pageProps.entry.comments+"</textarea>");


            mb.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"js/redactor/redactor.css\" />\n" +
                    "<script src=\""+pageProps.pathToAppRoot+"js/redactor/redactor.js\"></script>");

            mb.append("<script type=\"text/javascript\">\n" +
                    "$(document).ready(\n" +
                    "   function()\n" +
                    "   {\n" +
                    "      $('#redactor_content').redactor({" +
                    "         imageUpload: '"+pageProps.pathToAppRoot+"UploadAjax?eventid="+pageProps.entry.eventid+"'" +
                    "      });\n" +
                    "   }\n" +
                    ");\n" +
                    "</script>");

            mb.append("<textarea id=\"redactor_content\" name=\"comments\">"+pageProps.entry.comments+"</textarea>");






            mb.append("");
        } else {
            //Get the Wysiwyg editor
            mb.append(reger.MegaHtmlFormFckeditor.getHtml(userSession, pageProps, true, pageProps.entry.comments, request));
        }


        if (1==2 || pageProps.entry.haveSpellingErrors){
            mb.append("</div>");
        }


        return mb;
    }

}
