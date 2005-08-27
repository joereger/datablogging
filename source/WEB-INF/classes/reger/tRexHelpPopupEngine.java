package reger;

public class tRexHelpPopupEngine {

    /**
     * tRex Help Popup engine
     */
    public static StringBuffer pageout(StringBuffer mb, StringBuffer sc, reger.UserSession userSession, reger.pageFramework.PageProps pageProps) {

        StringBuffer ap = new StringBuffer();

        ap.append("<html><head><title>Help</title></head><body bgcolor=#ff9933 link='#0000ff' vlink='#0000ff' text='#000000' LEFTMARGIN='0' TOPMARGIN='0' MARGINWIDTH='0' MARGINHEIGHT='0' background='images/help-popup-bg.gif'>");

        ap.append(mb);

        ap.append("</body>");
        ap.append("</html>");


        return ap;
    }




}