package reger;

/**
 * Displays the dynamic editor.
 */
public class MegaHtmlFormFckeditor {


    public static StringBuffer getHtml(reger.UserSession userSession, reger.pageFramework.PageProps pageProps, boolean displayasadmin, String initialvalue, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();


        //initialvalue=initialvalue.replaceAll("(\n|\r)", "").replaceAll("\"", "\\\\\"");
        mb.append("\n");
        mb.append("\n");
        mb.append("<script type=\"text/javascript\" src=\"/js/ckeditor/ckeditor.js\"></script>" + "\n");

        mb.append("<textarea id=\"comments\" name=\"comments\">"+initialvalue+"</textarea>" + "\n");
		mb.append("<script type=\"text/javascript\">" + "\n");
		mb.append("CKEDITOR.replace( 'comments', {" + "\n");

        mb.append("on :" + "\n");
        mb.append("{" + "\n");
        mb.append("    instanceReady : function( ev )" + "\n");
        mb.append("    {" + "\n");
        mb.append("        this.dataProcessor.writer.setRules( 'p'," + "\n");
        mb.append("            {" + "\n");
        mb.append("                indent : false," + "\n");
        mb.append("                breakBeforeOpen : false," + "\n");
        mb.append("                breakAfterOpen : false," + "\n");
        mb.append("                breakBeforeClose : false," + "\n");
        mb.append("                breakAfterClose : false" + "\n");
        mb.append("            });" + "\n");
        mb.append("    }" + "\n");
        mb.append("}" + "\n");

        mb.append("} );" + "\n");
		mb.append("</script>" + "\n");
        mb.append("\n");
        mb.append("\n");




//        initialvalue=initialvalue.replaceAll("(\n|\r)", "").replaceAll("\"", "\\\\\"");
//        mb.append("\n");
//        mb.append("\n");
//        mb.append("<script type=\"text/javascript\" src=\"/js/fckeditor/fckeditor.js\"></script>" + "\n");
//        mb.append("<script type=\"text/javascript\">" + "\n");
//        mb.append("<!--" + "\n");
//        mb.append("var oFCKeditor = new FCKeditor( 'comments' ) ;" + "\n");
//        mb.append("oFCKeditor.BasePath = \""+pageProps.pathToAppRoot+"js/fckeditor/\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"LinkBrowserURL\"]  = \"../filemanager/browser/default/browser.html?Connector=connectors/jsp/connector\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"ImageBrowserURL\"]  = \"../filemanager/browser/default/browser.html?Type=Image&Connector=connectors/jsp/connector\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"FlashBrowserURL\"]  = \"../filemanager/browser/default/browser.html?Type=Flash&Connector=connectors/jsp/connector\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"LinkUploadURL\"]  = \"../filemanager/upload/simpleuploader?Type=File\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"FlashUploadURL\"]  = \"../filemanager/upload/simpleuploader?Type=Flash\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"ImageUploadURL\"]  = \"../filemanager/upload/simpleuploader?Type=Image\" ;" + "\n");
//        mb.append("oFCKeditor.Value = \""+initialvalue+"\" ;" + "\n");
//        mb.append("oFCKeditor.Create();" + "\n");
//        mb.append("//-->" + "\n");
//        mb.append("</script>" + "\n");
//        mb.append("\n");
//        mb.append("\n");


        return mb;
    }

}
