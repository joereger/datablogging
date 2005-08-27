package reger;

import java.util.*;
import java.lang.reflect.*;

/**
 * A class that outputs debug info to the bottom of the screen.
 */
public class debugInfo {

    /**
     * Just a friendly way to call the request, pageProps and logProps vars to the screen.
     * @param request
     * @param pageProps
     * @return StringBuffer filled with debug info joy.
     */
    public static StringBuffer monsterDebug(javax.servlet.http.HttpServletRequest request, reger.pageFramework.PageProps pageProps){
        StringBuffer md = new StringBuffer();

        md.append(examineClass(pageProps));
        md.append(examineClass(pageProps.logProps));
        md.append(examineClass(pageProps.entry));
        md.append(requestVars(request));

        return md;
    }



    public static StringBuffer requestVars(javax.servlet.http.HttpServletRequest request){
        StringBuffer db = new StringBuffer();

        db.append("<br>");
        db.append("<table cellpadding=3 cellspacing=1 border=0 width=100%>");

        db.append("<tr>");
        db.append("<td valign=top bgcolor=#cccccc width=25%>");
        db.append("<font face=arial size=-1><b>Request Name</b></font>");
        db.append("</td>");
        db.append("<td valign=top bgcolor=#cccccc>");
        db.append("<font face=arial size=-1><b>Request Value</b></font>");
        db.append("</td>");
        db.append("</tr>");

        Map requestMap = request.getParameterMap();

        for (Iterator i=requestMap.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();

            db.append("<tr>");
            db.append("<td valign=top bgcolor=#efefef>");
            db.append(e.getKey());
            db.append("</td>");
            db.append("<td valign=top bgcolor=#efefef>");

            String[] myString = (String[])e.getValue();
            for(int j=0; j<myString.length; j++) {
            	if (j>0) {
                    db.append("<br><br>");
                }
                db.append(myString[j]);
            }

            db.append("</td>");
            db.append("</tr>");
        }



        db.append("</table>");

        return db;
    }

    public static StringBuffer exececutionTimeOutput(long elapsedmillis){

        StringBuffer eo = new StringBuffer();

        eo.append("<br>");
        eo.append("<br>");
        eo.append("<table cellpadding=3 cellspacing=1 border=0 width=100%>");

        eo.append("<tr>");
        eo.append("<td valign=top bgcolor=#cccccc align=left width=25%>");
        eo.append("<font face=arial size=-1><b>Elapsed Milliseconds</b></font>");
        eo.append("</td>");
        eo.append("<td valign=top bgcolor=#cccccc>");
        eo.append("<font face=arial size=-1><b>"+elapsedmillis+"</b></font>");
        eo.append("</td>");
        eo.append("</tr>");

        eo.append("</table>");

        return eo;
    }


    public static StringBuffer pagePropsOut(reger.pageFramework.PageProps pageProps){
        StringBuffer eo = new StringBuffer();

        eo.append(examineClass(pageProps));
        eo.append(examineClass(pageProps.logProps));
        eo.append(examineClass(pageProps.entry));

        return eo;
    }

    public static StringBuffer examineClass(Object inObject){
        StringBuffer eo = new StringBuffer();

        eo.append("<br>");
        eo.append("<table cellpadding=3 cellspacing=1 border=0 width=100%>");

        eo.append("<tr>");
        eo.append("<td valign=top bgcolor=#cccccc align=left colspan=2>");
        eo.append("<font face=arial size=-1><b>"+inObject.getClass().getName()+"</b></font>");
        eo.append("</td>");
        eo.append("</tr>");

        if (inObject!=null) {

            Field[] myFieldArray = inObject.getClass().getDeclaredFields();
            String myVal = "";

            for(int i=0; i<myFieldArray.length; i++) {
                try{
                     eo.append("<tr>");
                     eo.append("<td valign=top bgcolor=#efefef align=left width=25%>");
                     eo.append("<font face=arial size=-1><b>"+myFieldArray[i].getName()+"</b></font>");
                     eo.append("</td>");
                     eo.append("<td valign=top bgcolor=#efefef>");
                     eo.append("<font face=arial size=-1>");
                     try {
                         if (myFieldArray[i].get(inObject)!=null) {
                             myVal = myFieldArray[i].get(inObject).toString();
                             eo.append(myVal.replaceAll("<", "&lt;"));
                         }
                     } catch (Exception e) {
                         eo.append("Private");
                     }
                     eo.append("</font>");
                     eo.append("</td>");
                     eo.append("</tr>");
                } catch (Exception e) {
                    reger.core.Util.errorsave(e);
                }
            }

        } else {
            eo.append("<tr>");
            eo.append("<td valign=top bgcolor=#efefef align=left colspan=2>");
            eo.append("<font face=arial size=-1><b>Null</b></font>");
            eo.append("</td>");
            eo.append("</tr>");
        }

        eo.append("</table>");


        return eo;
    }

}
