package reger.ui;

/**
 * UI Element
 */
public class RoundedCornersFixedWidthAnyColor {

    public static String get(String title, String body, String pathToAppRoot, String titlebgcolor, String titletextcolor, String contentbgcolor){
        StringBuffer mb = new StringBuffer();

        mb.append("<div style=\"width: 220px; background: #"+contentbgcolor+"; font-size: xx-small; f\\ont-size: x-small; margin-top: 20px; margin-left: 10px; margin-right: 10px;\">");
        mb.append("<div style=\"font-family: Verdana, Arial, Helvetica, sans-serif; color: #"+titletextcolor+"; background: #"+titlebgcolor+" url("+pathToAppRoot+"/images/r_top_220.gif) no-repeat top; margin: 0; font: arial; padding: 7px 11px; font-size: 20px;\">");
        mb.append("<b>"+title+"</b>");
        mb.append("</div>");
        mb.append("<div style=\"padding: 10px; font-family: Verdana, Arial, Helvetica, sans-serif;\">");
        mb.append(body);
        mb.append("</div>");
        mb.append("<div style=\"background: #"+titlebgcolor+" url("+pathToAppRoot+"/images/r_bot_220.gif) no-repeat bottom; padding: 7px 11px; margin: 0;\"></div>");
        mb.append("</div>");

        return mb.toString();
    }


}
