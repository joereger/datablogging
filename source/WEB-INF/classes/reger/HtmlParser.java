package reger;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Utilities for parsing head tags out of html
 */
public class HtmlParser {


    public static String combineTagContentFromTwoHtmlDocs(String htmlDoc1, String htmlDoc2, String tagName){
        String contentsFromHtmlDoc1 = getContentsOfHtmlTag(htmlDoc1, tagName);
        String contentsFromHtmlDoc2 = getContentsOfHtmlTag(htmlDoc2, tagName);
        if (!contentsFromHtmlDoc1.equals("") && contentsFromHtmlDoc2.equals("")){
            return htmlDoc1;
        }
        if (contentsFromHtmlDoc1.equals("") && !contentsFromHtmlDoc2.equals("")){
            return htmlDoc2;
        }
        StringBuffer out = new StringBuffer();
        Pattern p = getPatternForContentsOfTag(tagName);
        Matcher m = p.matcher(htmlDoc1);
        if(m!=null && m.find()) {
            String combinedContents = contentsFromHtmlDoc1 + " " + contentsFromHtmlDoc2;
            String attributesFromHtmlDoc1 = getAttributesOfTag(m.group().toString(), tagName);
            String attributesFromHtmlDoc2 = getAttributesOfTag(htmlDoc2, tagName);
            String combinedAttributes = attributesFromHtmlDoc1 + " " + attributesFromHtmlDoc2;
            m.appendReplacement(out, reger.core.Util.cleanForAppendreplacement("<"+tagName+" "+combinedAttributes+">"+combinedContents+"</"+tagName+">"));
        }
        try{
            m.appendTail(out);
        } catch (Exception e){
        }
        reger.core.Debug.debug(3, "HtmlParser.java", "After combining "+tagName+ " tags:<br>" + out.toString().replaceAll("<", "&lt;"));
        return out.toString();
    }


    public static String combineTagAttributesForOneTagFromTwoHtmlDocs(String htmlDoc1, String htmlDoc2, String tagName){
        StringBuffer out = new StringBuffer();
        Pattern p = getPatternForTagItself(tagName);
        Matcher m = p.matcher(htmlDoc1);
        if(m!=null && m.find()) {
            String attributesFromHtmlDoc1 = getAttributesOfTag(m.group().toString(), tagName);
            String attributesFromHtmlDoc2 = getAttributesOfTag(htmlDoc2, tagName);
            String combinedAttributes = attributesFromHtmlDoc1 + " " + attributesFromHtmlDoc2;
            m.appendReplacement(out, reger.core.Util.cleanForAppendreplacement("<"+tagName+" "+combinedAttributes+">"));
        }
        try{
            m.appendTail(out);
        } catch (Exception e){
        }
        return out.toString();
    }



    public static String getContentsOfHtmlTag(String in, String tagName){
        Pattern p = getPatternForContentsOfTag(tagName);
        Matcher m = p.matcher(in);
        if(m!=null && m.find()) {
            return m.group(2).toString();
        }
        return "";
    }


    public static String getTag(String in, String tagName){
        Pattern p = getPatternForTagItself(tagName);
        Matcher m = p.matcher(in);
        if(m!=null && m.find()) {
            return m.group().toString();
        }
        return "";
    }

    public static String getAttributesOfTag(String in, String tagName){
        Pattern p = getPatternForTagItself(tagName);
        Matcher m = p.matcher(in);
        if(m!=null && m.find()) {
            return m.group(2).toString();
        }
        return "";
    }




    private static Pattern getPatternForContentsOfTag(String tagName){
        String flag1 = String.valueOf(Pattern.CASE_INSENSITIVE);
        String flag2 = String.valueOf(Pattern.DOTALL);
        String allFlags = flag1+flag2;
        int allFlagsAsInt = Integer.parseInt(allFlags);
        return Pattern.compile("(<\\s*"+tagName+"[^>]*>(.*?)</\\s*"+tagName+"[^>]*>)", allFlagsAsInt);
    }

    private static Pattern getPatternForTagItself(String tagName){
        String flag1 = String.valueOf(Pattern.CASE_INSENSITIVE);
        String flag2 = String.valueOf(Pattern.DOTALL);
        String allFlags = flag1+flag2;
        int allFlagsAsInt = Integer.parseInt(allFlags);
        return Pattern.compile("(\\<"+tagName+"(.*?)\\>)", allFlagsAsInt);
    }



}
