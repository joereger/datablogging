package reger.search;

/**
 * Holds displayable search results.
 */
public class SearchResult {

    public static int SEARCHRESULTOBJECTTYPEENTRY = 1;
    public static int SEARCHRESULTOBJECTTYPEFILE = 2;
    public static int SEARCHRESULTOBJECTTYPETRACKBACK = 3;
    public static int SEARCHRESULTOBJECTTYPEMESSAGE = 4;

    public int typeOfObjectReturned;
    public int idOfObjectReturned;
    public int associatedEventid;
    public int associatedAccountid;
    public String url;
    public String title;
    public String excerpt;
    public String score;
    public String siteName;

    public String standardHtmlDisplay(){
        StringBuffer mb = new StringBuffer();
        mb.append("<font face=arial size=-1>");
        mb.append("<a href='"+url+"'>");
        mb.append("<strong>");
        mb.append(title);
        mb.append("</strong>");
        mb.append("</a>");
        mb.append("</font>");

        mb.append("<br>");
        mb.append("<font face=arial size=-2>");
        mb.append(excerpt.replaceAll("<", "&lt;"));
        mb.append("</font>");


        mb.append("<br>");
        mb.append("<font face=arial size=-2 color=#339900>");
        if (typeOfObjectReturned==SEARCHRESULTOBJECTTYPEENTRY){
            mb.append("Found: Entry On Site: ");
        } else if (typeOfObjectReturned==SEARCHRESULTOBJECTTYPEFILE) {
            mb.append("Found: File On Site: ");
        } else if (typeOfObjectReturned==SEARCHRESULTOBJECTTYPETRACKBACK) {
            mb.append("Found: Trackback On Site: ");
        } else if (typeOfObjectReturned==SEARCHRESULTOBJECTTYPEMESSAGE) {
            mb.append("Found: Message On Site: ");    
        }
        if (siteName!=null){
            mb.append(siteName);
        }
        mb.append("</font>");




        return mb.toString();
    }
    

}
