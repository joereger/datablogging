package reger;

/**
 * Displays the dynamic editor.
 */
public class MegaHtmlFormFckeditor {


    public static StringBuffer getHtml(reger.UserSession userSession, reger.pageFramework.PageProps pageProps, boolean displayasadmin, String initialvalue){
        StringBuffer mb = new StringBuffer();

        mb.append("<script type=\"text/javascript\" src=\"/js/fckeditor/fckeditor.js\"></script>" + "\n");
        mb.append("<script type=\"text/javascript\">" + "\n");
        mb.append("var oFCKeditor = new FCKeditor( 'comments' ) ;" + "\n");
        mb.append("oFCKeditor.BasePath = \"/js/fckeditor/\" ;" + "\n");
        initialvalue=initialvalue.replaceAll("(\n|\r)", "").replaceAll("\"", "\\\\\"");
        mb.append("oFCKeditor.Value = \""+initialvalue+"\" ;" + "\n");
        mb.append("oFCKeditor.Create();" + "\n");
        mb.append("</script>" + "\n");


        return mb;
    }

}
