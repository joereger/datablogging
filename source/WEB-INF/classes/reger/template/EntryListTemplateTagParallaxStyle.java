package reger.template;

import reger.Entry;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class EntryListTemplateTagParallaxStyle implements EntryListTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Parallax.Style";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Parallax bg and other styling.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getValue(String templateentry, Calendar entrydate, String logentrytitle, String logentryurl, String logentrybody, String logname, int imagescount, int messagescount, int accountuserid, reger.Entry entry, int numberOnPage) {
        int firstImage = getImageidOfMainImage(entry);
        if (firstImage>0){
            return "background: url(/mediaout.log?imageid="+firstImage+") 50% 0% fixed repeat; background-size: 100%;";
        }
        return "background-color: "+getRandomColor()+";";
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "No preview.";
    }




    private static String getRandomColor(){
        String color;
        int which = (int)(Math.random() * 5);  //  Result is 0, 1, or 2.

        switch (which) {
            case 0:  color = "#3f5c81";
                     break;
            case 1:  color = "#969ec2";
                     break;
            case 2:  color = "#83a7df";
                     break;
            case 3:  color = "#aacef6";
                     break;
            case 4:  color = "#d1edfd";
                     break;
            default: color = "#3f5c81";
        }
        return color;
    }




    private static int getImageidOfMainImage(Entry entry){


        // STRATEGY 1: Find first image inserted into body of post
        String body = entry.comments;
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
                        return imageid;
                    }
                }


            }

        }

        //STRATEGY 2: Use first image in the entry
        if (entry.firstImageid>0){
            return entry.firstImageid;
        }




        return 0;
    }

}