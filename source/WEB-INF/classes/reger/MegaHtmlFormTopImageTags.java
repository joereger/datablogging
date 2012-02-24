package reger;

import reger.template.SiteTemplateTag;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: joereger
 * Date: 11/16/11
 * Time: 8:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class MegaHtmlFormTopImageTags {


    public static String replaceImageTagsWithHtml(Entry entry, String entrykey){
        StringBuffer mb = new StringBuffer();

        String body = entry.comments;


        // Create a pattern to match
        String flag1 = String.valueOf(Pattern.CASE_INSENSITIVE);
        String flag2 = String.valueOf(Pattern.DOTALL);
        String allFlags = flag1+flag2;
        int allFlagsAsInt = Integer.parseInt(allFlags);
        Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>)", allFlagsAsInt);
        // Create a matcher with an input string
        Matcher m = p.matcher(body);
        // Loop through
        while(m!=null && m.find()) {

            if (m.group().substring(0,7).equalsIgnoreCase("<$image")) {

                int imageid = 0;
                Pattern p2 = Pattern.compile("id=\"(.*?)\"", allFlagsAsInt);
                Matcher m2 = p2.matcher(m.group());
                while(m2!=null && m2.find()) {
                    if (reger.core.Util.isinteger(m2.group(1))){
                        imageid = Integer.parseInt(m2.group(1));
                    }
                }

                String width = "";
                Pattern p3 = Pattern.compile("width=\"(.*?)\"", allFlagsAsInt);
                Matcher m3 = p3.matcher(m.group());
                while(m3!=null && m3.find()) {
                    //if (reger.core.Util.isinteger(m3.group(1))){
                        width = m3.group(1);
                    //}
                }

                String height = "";
                Pattern p4 = Pattern.compile("height=\"(.*?)\"", allFlagsAsInt);
                Matcher m4 = p4.matcher(m.group());
                while(m4!=null && m4.find()) {
                    //if (reger.core.Util.isinteger(m4.group(1))){
                        height = m4.group(1);
                    //}
                }

                String align = "";
                Pattern p5 = Pattern.compile("align=\"(.*?)\"", allFlagsAsInt);
                Matcher m5 = p5.matcher(m.group());
                while(m5!=null && m5.find()) {
                    //if (reger.core.Util.isinteger(m5.group(1))){
                        align = m5.group(1);
                    //}
                }


                String mediaouturl = "mediaout.log?imageid="+imageid+"&entrykey="+entrykey;
                String widthStr = "";
                if (!width.equals("")){widthStr="width=\""+width+"\"";}
                String heightStr = "";
                if (!height.equals("")){heightStr="height=\""+height+"\"";}
                String alignStr = "";
                if (!align.equals("")){alignStr="align=\""+align+"\"";}
                StringBuffer imgtag = new StringBuffer();

                imgtag.append("<ul class=\"thumbnails\">" + "\n");
                imgtag.append("<li style=\"width:100%;\">" + "\n");
//                imgtag.append("<div class=\"thumbnail\">" + "\n");
                imgtag.append("<a class=\"thumbnail\" rel=\"prettyPhoto[Images"+entry.eventid+"]\" title=\"\" href=\""+mediaouturl+"\">" +
                        "<img class=\"entryimageembed\" id=\""+imageid+"\" src=\""+mediaouturl+"\" "+widthStr+" "+heightStr+" "+alignStr+" >" +
                        "</a>");
//                imgtag.append("</div>" + "\n");
                imgtag.append("</li>" + "\n");
                imgtag.append("</ul>" + "\n");

                m.appendReplacement(mb, reger.core.Util.cleanForAppendreplacement(imgtag.toString()));

            } else {

                m.appendReplacement(mb, reger.core.Util.cleanForAppendreplacement(m.group()));
            }

        }
        // Add the last segment
        try{
            m.appendTail(mb);
        } catch (Exception e){
            //Do nothing... just null pointer... there was no tail because a tag was last char
        }







        return mb.toString();
    }



}
