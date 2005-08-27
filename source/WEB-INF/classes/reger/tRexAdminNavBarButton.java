package reger;

/**
 * Created by IntelliJ IDEA.
 * User: jreger
 * Date: Feb 29, 2004
 * Time: 9:05:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class tRexAdminNavBarButton {

    public String adminsection = "";
    public String url = "";
    public String buttontext = "";
    public String buttonbgcolor = "";

    public tRexAdminNavBarButton(String adminsection, String url, String buttontext, String buttonbgcolor){
        this.adminsection = adminsection;
        this.url = url;
        this.buttontext = buttontext;
        this.buttonbgcolor = buttonbgcolor;   
    }

}
