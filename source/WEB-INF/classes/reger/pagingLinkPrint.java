package reger;

import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;

public class pagingLinkPrint {

    public static StringBuffer getHtml(int counttotal, int currentpage, int perpage, HttpServletRequest request){

        Debug.debug(5, "pagingLinkPrint.java", "getHtml(counttotal=" + counttotal + ", currentpage=" + currentpage + ", perpage=" + perpage);

        //Parse request object.
        //Remove references to currentpage
        StringBuffer querystring = new StringBuffer();
        java.util.Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = (String) parameterNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                //Can't append currentpage because we're going to append that below
                if (!paramName.equals("currentpage")){
                    querystring.append( paramName + "=" + paramValues[i] + "&");
                }
            }
        }

        //Get the script name
        //String thispagename = request.getServletPath();
        reger.core.Debug.debug(5, "pagingLinkPrint.java", reger.core.ErrorDissect.ServletUtilsdissect(request));
        String thispagename = reger.core.Util.getJspName(request.getRequestURL().toString());
        if (thispagename.equals(request.getServerName().toString())){
            thispagename = "index.log";
        }
        //reger.core.Util.logtodb(reger.core.ErrorDissect.ServletUtilsdissect(request));


        //Create the output stringbuffer
        StringBuffer html = new StringBuffer();

        if (perpage<=0){
            perpage=10;
        }

        int numberofpages=counttotal / perpage;
        if (perpage*numberofpages < counttotal) {
            numberofpages=numberofpages+1;
        }

        //html.append("<br>perpage: " + perpage);
        //html.append("<br>counttotal: " + counttotal);
        //html.append("<br>numberofpages: " + numberofpages);

        if (numberofpages>1){
            //Start the html table
            html.append("<table cellpadding=2 cellspacing=0 width=100% border=0><tr><td class=pagingnumbers align=center valign=middle>");

            if (currentpage>1) {
                html.append("<font class=smallfont face=arial size=-2><a href='" + thispagename + "?currentpage=" + (currentpage-1) + "&" + querystring.toString() + "'><< Previous</a></font> ");
            }

            int x=1;
            while (x<=numberofpages) {

                if ( ( (((currentpage-x)<5) && ((currentpage-x)>(-5))) || ((x<=10) && (currentpage<=5)) ) && (currentpage!=x) ) {
                    //The link should be on
                    html.append("<font class=smallfont face=arial size=-2> <a href='" + thispagename + "?currentpage=" + x + "&" + querystring.toString() + "'>" + x + "</a> </font>");
                } else if (currentpage==x) {
                    //The link should be off
                    html.append("<font class=mediumfont face=arial size=+1>" + x + "</font>");
                }

                x++;
            }


            if (currentpage < numberofpages) {
                html.append("<font class=smallfont face=arial size=-2> <a href='" + thispagename + "?currentpage=" + (currentpage+1) + "&" + querystring.toString() + "'>Next >></a></font> ");
            }

            html.append("</td></tr></table>");
        }

        //Return StringBuffer to the caller
        return html;
    }

public static StringBuffer getImagePageNumbers(int counttotal, int currentpage, int perpage, HttpServletRequest request){

        Debug.debug(5, "", "pagingLinkPrint.java - getHtml(counttotal=" + counttotal + ", currentpage=" + currentpage + ", perpage=" + perpage);

        //Parse request object.
        //Remove references to currentpage
        StringBuffer querystring = new StringBuffer();
        java.util.Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = (String) parameterNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                //Can't append currentpage because we're going to append that below
                if (!paramName.equals("currentImagePage")){
                    querystring.append( paramName + "=" + paramValues[i] + "&");
                }
            }
        }

        //Get the script name
        //String thispagename = request.getServletPath();
        String thispagename = reger.core.Util.getJspName(request.getRequestURL().toString());
        //reger.core.Util.logtodb(reger.core.ErrorDissect.ServletUtilsdissect(request));
        //thispagename = "http://localhost/~pawan/tag-detail.log";

        //Create the output stringbuffer
        StringBuffer html = new StringBuffer();

        if (perpage<=0){
            perpage=10;
        }

        int numberofpages=counttotal / perpage;
        if (perpage*numberofpages < counttotal) {
            numberofpages=numberofpages+1;
        }

        //html.append("<br>perpage: " + perpage);
        //html.append("<br>counttotal: " + counttotal);
        //html.append("<br>numberofpages: " + numberofpages);
        if (numberofpages>1){
            //Start the html table
            html.append("<table cellpadding=2 cellspacing=0 width=100% border=0><tr><td class=pagingnumbers align=center valign=middle>");

            if (currentpage>1) {
                html.append("<font class=smallfont face=arial size=-2><a href='" + thispagename + "?currentImagePage=" + (currentpage-1) + "&" + querystring.toString() + "'><< Previous</a></font> ");
            }

            int x=1;
            while (x<=numberofpages) {

                if ( ( (((currentpage-x)<5) && ((currentpage-x)>(-5))) || ((x<=10) && (currentpage<=5)) ) && (currentpage!=x) ) {
                    //The link should be on
                    html.append("<font class=smallfont face=arial size=-2> <a href='" + thispagename + "?currentImagePage=" + x + "&" + querystring.toString() + "'>" + x + "</a> </font>");
                } else if (currentpage==x) {
                    //The link should be off
                    html.append("<font class=mediumfont face=arial size=+1>" + x + "</font>");
                }

                x++;
            }


            if (currentpage < numberofpages) {
                html.append("<font class=smallfont face=arial size=-2> <a href='" + thispagename + "?currentImagePage=" + (currentpage+1) + "&" + querystring.toString() + "'>Next >></a></font> ");
            }

            html.append("</td></tr></table>");
        }

        //Return StringBuffer to the caller
        return html;
    }
}