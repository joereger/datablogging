package reger;

/**
 * Displays the dynamic editor.
 */
public class MegaHtmlFormFckeditor {


    public static StringBuffer getHtml(reger.UserSession userSession, reger.pageFramework.PageProps pageProps, boolean displayasadmin, String initialvalue, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        initialvalue=initialvalue.replaceAll("(\n|\r)", "").replaceAll("\"", "\\\\\"");



        mb.append("\n");
        mb.append("\n");
        mb.append("<script type=\"text/javascript\" src=\"/js/fckeditor/fckeditor.js\"></script>" + "\n");
        mb.append("<script type=\"text/javascript\">" + "\n");
        mb.append("<!--" + "\n");
        mb.append("var oFCKeditor = new FCKeditor( 'comments' ) ;" + "\n");
        mb.append("oFCKeditor.BasePath = \""+pageProps.pathToAppRoot+"js/fckeditor/\" ;" + "\n");
        mb.append("oFCKeditor.Config[\"LinkBrowserURL\"]  = \"../filemanager/browser/default/browser.html?Connector=connectors/jsp/connector\" ;" + "\n");
        mb.append("oFCKeditor.Config[\"ImageBrowserURL\"]  = \"../filemanager/browser/default/browser.html?Type=Image&Connector=connectors/jsp/connector\" ;" + "\n");
        mb.append("oFCKeditor.Config[\"FlashBrowserURL\"]  = \"../filemanager/browser/default/browser.html?Type=Flash&Connector=connectors/jsp/connector\" ;" + "\n");
        mb.append("oFCKeditor.Config[\"LinkUploadURL\"]  = \"../filemanager/upload/simpleuploader?Type=File\" ;" + "\n");
        mb.append("oFCKeditor.Config[\"FlashUploadURL\"]  = \"../filemanager/upload/simpleuploader?Type=Flash\" ;" + "\n");
        mb.append("oFCKeditor.Config[\"ImageUploadURL\"]  = \"../filemanager/upload/simpleuploader?Type=Image\" ;" + "\n");
        mb.append("oFCKeditor.Value = \""+initialvalue+"\" ;" + "\n");
        mb.append("oFCKeditor.Create();" + "\n");
        mb.append("//-->" + "\n");
        mb.append("</script>" + "\n");
        mb.append("\n");
        mb.append("\n");

//        mb.append("\n");
//        mb.append("\n");
//        mb.append("<script type=\"text/javascript\" src=\"/js/fckeditor/fckeditor.js\"></script>" + "\n");
//        mb.append("<script type=\"text/javascript\">" + "\n");
//        mb.append("<!--" + "\n");
//        mb.append("var oFCKeditor = new FCKeditor( 'comments' ) ;" + "\n");
//        mb.append("oFCKeditor.BasePath = \"/js/fckeditor/\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"LinkBrowserURL\"]  = \"/js/fckeditor/editor/filemanager/browser/default/browser.html?Connector=connectors/jsp/connector\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"ImageBrowserURL\"]  = \"/js/fckeditor/editor/filemanager/browser/default/browser.html?Type=Image&Connector=connectors/jsp/connector\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"FlashBrowserURL\"]  = \"/js/fckeditor/editor/filemanager/browser/default/browser.html?Type=Flash&Connector=connectors/jsp/connector\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"LinkUploadURL\"]  = \"/js/fckeditor/editor/filemanager/upload/simpleuploader?Type=File\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"FlashUploadURL\"]  = \"/js/fckeditor/editor/filemanager/upload/simpleuploader?Type=Flash\" ;" + "\n");
//        mb.append("oFCKeditor.Config[\"ImageUploadURL\"]  = \"/js/fckeditor/editor/filemanager/upload/simpleuploader?Type=Image\" ;" + "\n");
//        mb.append("oFCKeditor.Value = \""+initialvalue+"\" ;" + "\n");
//        mb.append("oFCKeditor.Create();" + "\n");
//        mb.append("//-->" + "\n");
//        mb.append("</script>" + "\n");
//        mb.append("\n");
//        mb.append("\n");

        return mb;
    }

}
