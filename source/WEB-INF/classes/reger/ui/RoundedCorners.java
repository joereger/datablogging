package reger.ui;

/**
 * Pretty little bubble box.
 */
public class RoundedCorners {

    public static StringBuffer start(String title, String bodycolor, String bordercolor, int widthinpercent){
        return start(title, "", bodycolor, bordercolor, "000000", "000000", widthinpercent);
    }

    public static StringBuffer start(String title, String bodycolor, String bordercolor){
        return start(title, "", bodycolor, bordercolor, "000000", "000000", 100);
    }

    public static StringBuffer start(String bodycolor, String bordercolor, int widthinpercent){
        return start("", "", bodycolor, bordercolor, "000000", "000000", widthinpercent);
    }

    public static StringBuffer start(String bodycolor, String bordercolor){
        return start("", "", bodycolor, bordercolor, "000000", "000000", 100);
    }

    public static StringBuffer start(String title){
        return start(title, "", "cccccc", "999999", "000000", "000000", 100);
    }

    public static StringBuffer start(){
        return start("", "", "cccccc", "999999", "000000", "000000", 100);
    }

    public static StringBuffer start(String title, String subtitle, String bodycolor, String bordercolor, String titlecolor, String subtitlecolor, int widthinpercent){
        StringBuffer mb = new StringBuffer();
       

        String width = "width=100%";
        if (widthinpercent>0){
            width = "width="+widthinpercent+"%";
        }

        mb.append("<!-- Start Rounded Corner Box -->\n" +
                "<style type=\"text/css\">\n" +
                "#xsnazzy h1, #xsnazzy h2, #xsnazzy p {margin:0 10px; letter-spacing:1px;}\n" +
                "#xsnazzy h1 {font-size:2.5em; color:#"+titlecolor+";}\n" +
                "#xsnazzy h2 {font-size:2em;color:#"+subtitlecolor+"; border:0;}\n" +
                "#xsnazzy p {padding-bottom:0.5em;}\n" +
                "#xsnazzy h2 {padding-top:0.5em;}\n" +
                "#xsnazzy {background: transparent; margin:1em;}\n" +
                ".xtop, .xbottom {display:block; background:transparent; font-size:1px;}\n" +
                ".xb1, .xb2, .xb3, .xb4 {display:block; overflow:hidden;}\n" +
                ".xb1, .xb2, .xb3 {height:1px;}\n" +
                ".xb2, .xb3, .xb4 {background:#"+bodycolor+"; border-left:1px solid #"+bordercolor+"; border-right:1px solid #"+bordercolor+";}\n" +
                ".xb1 {margin:0 5px; background:#"+bordercolor+";}\n" +
                ".xb2 {margin:0 3px; border-width:0 2px;}\n" +
                ".xb3 {margin:0 2px;}\n" +
                ".xb4 {height:2px; margin:0 1px;}\n" +
                ".xboxcontent {display:block; background:#"+bodycolor+"; border:0 solid #"+bordercolor+"; border-width:0 1px;}\n" +
                "</style>\n" +
                "<div id=\"xsnazzy\" "+width+" >\n" +
                "<b class=\"xtop\"><b class=\"xb1\"></b><b class=\"xb2\"></b><b class=\"xb3\"></b><b class=\"xb4\"></b></b>\n" +
                "<div class=\"xboxcontent\">\n");
         if(!title.equals("")){
            mb.append("<h1>"+title+"</h1>\n");
         }
         if(!subtitle.equals("")){
            mb.append("<h2>"+subtitle+"</h2>\n");
         }
         mb.append("<p>");

        return mb;
    }

    public static StringBuffer end(){
        StringBuffer mb = new StringBuffer();

        mb.append("</p>\n" +
                "</div>\n" +
                "<b class=\"xbottom\"><b class=\"xb4\"></b><b class=\"xb3\"></b><b class=\"xb2\"></b><b class=\"xb1\"></b></b>\n" +
                "</div>\n" +
                "<!-- End Rounded Corner Box -->");

        return mb;
    }




}
