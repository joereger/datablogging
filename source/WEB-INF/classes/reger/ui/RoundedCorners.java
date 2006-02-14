package reger.ui;

/**
 * Pretty little bubble box.
 */
public class RoundedCorners {

    public static StringBuffer start(String uniqueboxname, String title, String bodycolor, String bordercolor, int widthinpercent){
        return start(uniqueboxname, title, "", bodycolor, bordercolor, "000000", "000000", widthinpercent);
    }

    public static StringBuffer start(String uniqueboxname, String title, String bodycolor, String bordercolor){
        return start(uniqueboxname, title, "", bodycolor, bordercolor, "000000", "000000", 100);
    }

    public static StringBuffer start(String uniqueboxname, String bodycolor, String bordercolor, int widthinpercent){
        return start(uniqueboxname, "", "", bodycolor, bordercolor, "000000", "000000", widthinpercent);
    }

    public static StringBuffer start(String uniqueboxname, String bodycolor, String bordercolor){
        return start(uniqueboxname, "", "", bodycolor, bordercolor, "000000", "000000", 100);
    }

    public static StringBuffer start(String uniqueboxname, String title){
        return start(uniqueboxname, title, "", "cccccc", "999999", "000000", "000000", 100);
    }

    public static StringBuffer start(String uniqueboxname){
        return start(uniqueboxname, "", "", "cccccc", "999999", "000000", "000000", 100);
    }

    public static StringBuffer start(String uniqueboxname, String title, String subtitle, String bodycolor, String bordercolor, String titlecolor, String subtitlecolor, int widthinpercent){
        StringBuffer mb = new StringBuffer();

        String x = uniqueboxname;

        String width = "width=100%";
        if (widthinpercent>0){
            width = "width="+widthinpercent+"%";
        }

        mb.append("<!-- Start Rounded Corner Box -->\n" +
                "<style type=\"text/css\">\n" +
                "#xsnazzy"+x+" h1, #xsnazzy"+x+" h2, #xsnazzy"+x+" p {margin:0 10px; letter-spacing:1px;}\n" +
                "#xsnazzy"+x+" h1 {font-size:2.5em; color:#"+titlecolor+";}\n" +
                "#xsnazzy"+x+" h2 {font-size:2em;color:#"+subtitlecolor+"; border:0;}\n" +
                "#xsnazzy"+x+" p {padding-bottom:0.5em;}\n" +
                "#xsnazzy"+x+" h2 {padding-top:0.5em;}\n" +
                "#xsnazzy"+x+" {background: transparent; margin:1em;}\n" +
                ".xtop"+x+", .xbottom"+x+" {display:block; background:transparent; font-size:1px;}\n" +
                ".xb1"+x+", .xb2"+x+", .xb3"+x+", .xb4"+x+" {display:block; overflow:hidden;}\n" +
                ".xb1"+x+", .xb2"+x+", .xb3"+x+" {height:1px;}\n" +
                ".xb2"+x+", .xb3"+x+", .xb4"+x+" {background:#"+bodycolor+"; border-left:1px solid #"+bordercolor+"; border-right:1px solid #"+bordercolor+";}\n" +
                ".xb1"+x+" {margin:0 5px; background:#"+bordercolor+";}\n" +
                ".xb2"+x+" {margin:0 3px; border-width:0 2px;}\n" +
                ".xb3"+x+" {margin:0 2px;}\n" +
                ".xb4"+x+" {height:2px; margin:0 1px;}\n" +
                ".xboxcontent"+x+" {display:block; background:#"+bodycolor+"; border:0 solid #"+bordercolor+"; border-width:0 1px;}\n" +
                "</style>\n" +
                "<div id=\"xsnazzy"+x+"\" "+width+" >\n" +
                "<b class=\"xtop"+x+"\"><b class=\"xb1"+x+"\"></b><b class=\"xb2"+x+"\"></b><b class=\"xb3"+x+"\"></b><b class=\"xb4"+x+"\"></b></b>\n" +
                "<div class=\"xboxcontent"+x+"\">\n");
         if(!title.equals("")){
            mb.append("<h1>"+title+"</h1>\n");
         }
         if(!subtitle.equals("")){
            mb.append("<h2>"+subtitle+"</h2>\n");
         }
         mb.append("<p>");

        return mb;
    }

    public static StringBuffer end(String uniqueboxname){
        StringBuffer mb = new StringBuffer();
        String x = uniqueboxname;
        mb.append("</p>\n" +
                "</div>\n" +
                "<b class=\"xbottom\"><b class=\"xb4"+x+"\"></b><b class=\"xb3"+x+"\"></b><b class=\"xb2"+x+"\"></b><b class=\"xb1"+x+"\"></b></b>\n" +
                "</div>\n" +
                "<!-- End Rounded Corner Box -->");

        return mb;
    }




}
