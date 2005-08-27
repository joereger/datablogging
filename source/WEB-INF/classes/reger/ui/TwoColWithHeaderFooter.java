package reger.ui;

/**
 * A two column fluid layout with header and footer.
 * Accepts a header, leftcol, maincontent and footer.
 * Footer is optional.
 * Requires css file cssobjectlayouts.css
 */
public class TwoColWithHeaderFooter {

    public static String htmlCss(String header, String footer, String mainbody, String leftcol){
        StringBuffer mb = new StringBuffer();

        mb.append("<div id=\"tchfcontainercss\">");
		mb.append("<div id=\"tchfbannercss\">"+header+"</div>");

		mb.append("<div id=\"tchfsidebarcss\">"+leftcol+"</div>");

        mb.append("<div id=\"tchfcontentcss\">"+mainbody+"</div>");

        if (footer!=null && !footer.equals("")){
		    mb.append("<div id=\"tchffootercss\">"+footer+"</div>");
        }
	    mb.append("</div>");

        return mb.toString();
    }

    public static String html(String header, String footer, String mainbody, String leftcol, int widthPercent){
        StringBuffer mb = new StringBuffer();

        if (widthPercent<=0){
            widthPercent=100;
        }

        mb.append("<table cellpadding=0 cellspacing=0 width="+widthPercent+"% border=0 id=\"tchfcontainer\">");

        mb.append("<tr>");
        mb.append("<td valign=top id=\"tchfbanner\" colspan=2>");
        mb.append(header);
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top  id=\"tchffooter\">");
        mb.append(footer);
        mb.append("</td>");
        mb.append("<td valign=top rowspan=2 width=33% id=\"tchfsidebar\">");
        mb.append(leftcol);
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top id=\"tchfcontent\">");
        mb.append(mainbody);
        mb.append("</td>");
        mb.append("</tr>");




        mb.append("</table>");

        return mb.toString();
    }




}
