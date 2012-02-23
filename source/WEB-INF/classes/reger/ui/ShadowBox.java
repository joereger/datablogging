package reger.ui;

/**
 * Pretty little shadow box.
 */
public class ShadowBox {

    public static StringBuffer wholebox(String body, String pathtoapproot){
        StringBuffer mb = new StringBuffer();
        mb.append(start(pathtoapproot));
        mb.append(body);
        mb.append(end(pathtoapproot));
        return mb;
    }

    public static StringBuffer start(String pathtoapproot){
        StringBuffer mb = new StringBuffer();

        mb.append("<div class=\"newshadowbox\">");

        return mb;
    }

    public static StringBuffer end(String pathtoapproot){
        StringBuffer mb = new StringBuffer();

        mb.append("</div>");


        return mb;
    }




}
