package reger.mega;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.log4j.Logger;
import reger.UserSession;
import reger.MegaLogType;
import reger.Log;
import reger.core.Debug;
import reger.cache.LogCache;
import reger.pageFramework.PageProps;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Manages the layout of fields in a log
 */
public class FieldLayout {

    public static final int LAYOUTMODEPUBLIC = 1;
    public static final int LAYOUTMODEADMIN = 2;
    public static final int LAYOUTMODEEDIT = 3;

    public static String getHtml(int eventtypeid, int logid, int LAYOUTMODE, UserSession userSessionOfSaver, String pageName, String fieldPageName, String newFieldPageName, reger.pageFramework.PageProps pageProps){
        Logger logger = Logger.getLogger(FieldLayout.class);
        StringBuffer mb = new StringBuffer();

        Debug.debug(5, "FieldLayout.java", "FieldLayout.java getHtml(eventtypeid="+eventtypeid+", logid="+logid+", LAYOUTMODE="+LAYOUTMODE+")");

        //If this is edit mode
        if (LAYOUTMODE==LAYOUTMODEEDIT) {
            mb.append(topLayoutBar(eventtypeid, logid, pageName, newFieldPageName, pageProps));
        }

        //Go get the fields to work with, either from the entry, log or the log type
        ArrayList<FieldType> fields = null;
        String fieldorder = "";
        if (eventtypeid>0){
            fields = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getMegaFields();
            fieldorder = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getFieldorder();
            Debug.debug(5, "FieldLayout.java", "Using fields from AllMegaLogTypesInSystem");
        }
        if (logid>0){
            fields = LogCache.get(logid).getFields();
            fieldorder = LogCache.get(logid).getFieldorder();
            Debug.debug(5, "FieldLayout.java", "Using fields from LogCache");
        }
        if (pageProps.entry.eventid>0){
            fields=pageProps.entry.fields;
            fieldorder = LogCache.get(pageProps.entry.logid).getFieldorder();
            Debug.debug(5, "FieldLayout.java", "Using fields from pageProps.entry");
        }

        //Empty the columns
        ArrayList<FieldType> megaFieldsVisibleCol1 = new ArrayList<FieldType>();
        ArrayList<FieldType> megaFieldsVisibleCol2 = new ArrayList<FieldType>();
        ArrayList<FieldType> megaFieldsVisibleCol3 = new ArrayList<FieldType>();

        if (fieldorder!=null && !fieldorder.equals("")){
            try{
                //Parse fieldorder and extract name/value pairs
                List<NameValuePair> nvs = URLEncodedUtils.parse(URI.create("http://foo.com/bar.html?" + fieldorder), "UTF-8");

                //First iterate by the fieldorder-derived name/value pairs... this keeps things in order
                for (Iterator<NameValuePair> it = nvs.iterator(); it.hasNext();) {
                    NameValuePair nv = it.next();
                    for (Iterator<FieldType> iterator = fields.iterator(); iterator.hasNext();) {
                        FieldType fieldType = iterator.next();
                        //Is this the correct megafieldid
                        if (String.valueOf(fieldType.getMegafieldid()).equals(nv.getValue())){
                            //Which col?
                            if (nv.getName().equals("megafieldidcol1")){
                                megaFieldsVisibleCol1.add(fieldType);
                            } else if (nv.getName().equals("megafieldidcol2")){
                                megaFieldsVisibleCol2.add(fieldType);
                            } else if (nv.getName().equals("megafieldidcol3")){
                                megaFieldsVisibleCol3.add(fieldType);
                            }
                        }
                    }
                }
            } catch (Exception e){
                logger.error(e);
            }
        }


        //Find fields that aren't in any column and add them to the first
        for (Iterator<FieldType> iterator = fields.iterator(); iterator.hasNext();) {
            FieldType fieldType = iterator.next();
            boolean isInACol = false;
            //Iterate first col to check
            for (Iterator<FieldType> it1 = megaFieldsVisibleCol1.iterator(); it1.hasNext();) {
                FieldType f = it1.next();
                if (f.getMegafieldid()==fieldType.getMegafieldid()){
                    isInACol = true;
                }
            }
            //Iterate second col to check
            for (Iterator<FieldType> it1 = megaFieldsVisibleCol2.iterator(); it1.hasNext();) {
                FieldType f = it1.next();
                if (f.getMegafieldid()==fieldType.getMegafieldid()){
                    isInACol = true;
                }
            }
            //Iterate third col to check
            for (Iterator<FieldType> it1 = megaFieldsVisibleCol3.iterator(); it1.hasNext();) {
                FieldType f = it1.next();
                if (f.getMegafieldid()==fieldType.getMegafieldid()){
                    isInACol = true;
                }
            }
            //If it's not in a col, add it to the first
            if (!isInACol){
                megaFieldsVisibleCol1.add(fieldType);
            }
        }

        //Calculate Twitter Bootstrap column span size
        int totalColumns = 0;
        if (megaFieldsVisibleCol1!=null && megaFieldsVisibleCol1.size()>0){
            totalColumns = totalColumns + 1;
        }
        if (megaFieldsVisibleCol2!=null && megaFieldsVisibleCol2.size()>0){
            totalColumns = totalColumns + 1;
        }
        if (megaFieldsVisibleCol3!=null && megaFieldsVisibleCol3.size()>0){
            totalColumns = totalColumns + 1;
        }
        String spansize1 = "";
        String spansize2 = "";
        String spansize3 = "";
        if (totalColumns==1){
            spansize1 = "col-md-8";
            spansize2 = "col-md-1";
            spansize3 = "col-md-1";
        } else if (totalColumns==2){
            spansize1 = "col-md-4";
            spansize2 = "col-md-4";
            spansize3 = "col-md-1";
        } else {
            spansize1 = "col-md-3";
            spansize2 = "col-md-3";
            spansize3 = "col-md-3";
        }


        mb.append("<script>");
        mb.append("function saveSort(event, ui){\n" +
                "    if (!ui.sender) {\n"+
                "       var col1 = $(\"#fieldlayoutlistcol1\").sortable('serialize', {key:\"megafieldidcol1\"});\n"+
                "       var col2 = $(\"#fieldlayoutlistcol2\").sortable('serialize', {key:\"megafieldidcol2\"});\n"+
                "       var col3 = $(\"#fieldlayoutlistcol3\").sortable('serialize', {key:\"megafieldidcol3\"});\n"+
                "       $.get(\""+pageProps.pathToAppRoot+"FieldLayoutSaveAjax?logid="+logid+"&eventtypeid="+eventtypeid+"&\"+col1+\"&\"+col2+\"&\"+col3);"+
                "       //alert(col1+\"&\"+col2+\"&\"+col3);\n" +
                "    }\n"+
                "}");
        mb.append("</script>");

        //Wrap all 3 columns in fieldlayout div
        mb.append("<div id=\"fieldlayout\">");

        mb.append("\n\n<!-- Start FieldLayout.java Megafields Col 1 -->");
        mb.append("<div class=\""+spansize1+"\">");
        mb.append("<ul id=\"fieldlayoutlistcol1\" class=\"sortable-list\" style=\"list-style: none;\">");
        boolean haveFieldInCol1 = false;
        if (megaFieldsVisibleCol1!=null){
            for (Iterator it = megaFieldsVisibleCol1.iterator(); it.hasNext(); ) {
                FieldType fld = (FieldType)it.next();
                if (fld!=null){
                    haveFieldInCol1 = true;
                    mb.append("<li class=\"sortable-item\" id=\"megafieldid_"+fld.getMegafieldid()+"\" style=\"border-left: thick solid #e6e6e6; padding-left: 3px; margin-top: 20px;\">");
                    mb.append("<h5>");
                    mb.append(fld.getFieldname());
                    mb.append("</h5>");
                    if (LAYOUTMODE==LAYOUTMODEADMIN){
                        mb.append(fld.getHtmlAdmin(logid, true));
                    } else if (LAYOUTMODE==LAYOUTMODEEDIT) {
                        mb.append(fld.getHtmlAdmin(logid, false));
                    } else {
                        String tmp = fld.getHtmlPublic(logid);
                        if (tmp.equals("")){
                            mb.append("&nbsp;");
                        } else {
                            mb.append(tmp);
                        }

                    }
                    mb.append("</li>");
                }
            }
        }
        if (!haveFieldInCol1 && (LAYOUTMODE==LAYOUTMODEADMIN || LAYOUTMODE==LAYOUTMODEEDIT)){
            mb.append("<li class=\"sortable-item\" id=\"placeholdercol1\" style=\"border-left: thick solid #e6e6e6; padding-left: 3px; margin-top: 20px;\"><img src=\""+pageProps.pathToAppRoot+"images/clear.gif\" border=\"0\" width=\"50\" height=\"1\"></li>");
        }
        mb.append("</ul>");
        mb.append("</div>");
        mb.append("\n<!-- End FieldLayout.java Megafields Col 1 -->\n");


        mb.append("\n\n<!-- Start FieldLayout.java Megafields Col 2 -->");
        mb.append("<div class=\""+spansize2+"\">");
        mb.append("<ul id=\"fieldlayoutlistcol2\" class=\"sortable-list\" style=\"list-style: none;\">");
        boolean haveFieldInCol2 = false;
        if (megaFieldsVisibleCol2!=null){
            for (Iterator it = megaFieldsVisibleCol2.iterator(); it.hasNext(); ) {
                FieldType fld = (FieldType)it.next();
                if (fld!=null){
                    haveFieldInCol2 = true;
                    mb.append("<li class=\"sortable-item\" id=\"megafieldid_"+fld.getMegafieldid()+"\" style=\"border-left: thick solid #e6e6e6; padding-left: 3px; margin-top: 20px;\">");
                    mb.append("<h5>");
                    mb.append(fld.getFieldname());
                    mb.append("</h5>");
                    if (LAYOUTMODE==LAYOUTMODEADMIN){
                        mb.append(fld.getHtmlAdmin(logid, true));
                    } else if (LAYOUTMODE==LAYOUTMODEEDIT) {
                        mb.append(fld.getHtmlAdmin(logid, false));
                    } else {
                        String tmp = fld.getHtmlPublic(logid);
                        if (tmp.equals("")){
                            mb.append("&nbsp;");
                        } else {
                            mb.append(tmp);
                        }

                    }
                    mb.append("</li>");
                }
            }
        }
        if (!haveFieldInCol2 && (LAYOUTMODE==LAYOUTMODEADMIN || LAYOUTMODE==LAYOUTMODEEDIT)){
            mb.append("<li class=\"sortable-item\" id=\"placeholdercol2\" style=\"border-left: thick solid #e6e6e6; padding-left: 3px; margin-top: 20px;\"><img src=\""+pageProps.pathToAppRoot+"images/clear.gif\" border=\"0\" width=\"50\" height=\"1\"></li>");
        }
        mb.append("</ul>");
        mb.append("</div>");
        mb.append("\n<!-- End FieldLayout.java Megafields Col 2 -->\n");



        mb.append("\n\n<!-- Start FieldLayout.java Megafields Col 3 -->");
        mb.append("<div class=\""+spansize3+"\">");
        mb.append("<ul id=\"fieldlayoutlistcol3\" class=\"sortable-list\" style=\"list-style: none;\">");
        boolean haveFieldInCol3 = false;
        if (megaFieldsVisibleCol3!=null){
            for (Iterator it = megaFieldsVisibleCol3.iterator(); it.hasNext(); ) {
                FieldType fld = (FieldType)it.next();
                if (fld!=null){
                    haveFieldInCol3 = true;
                    mb.append("<li class=\"sortable-item\" id=\"megafieldid_"+fld.getMegafieldid()+"\" style=\"border-left: thick solid #e6e6e6; padding-left: 3px; margin-top: 20px;\">");
                    mb.append("<h5>");
                    mb.append(fld.getFieldname());
                    mb.append("</h5>");
                    if (LAYOUTMODE==LAYOUTMODEADMIN){
                        mb.append(fld.getHtmlAdmin(logid, true));
                    } else if (LAYOUTMODE==LAYOUTMODEEDIT) {
                        mb.append(fld.getHtmlAdmin(logid, false));
                    } else {
                        String tmp = fld.getHtmlPublic(logid);
                        if (tmp.equals("")){
                            mb.append("&nbsp;");
                        } else {
                            mb.append(tmp);
                        }

                    }
                    mb.append("</li>");
                }
            }
        }
        if (!haveFieldInCol3 && (LAYOUTMODE==LAYOUTMODEADMIN || LAYOUTMODE==LAYOUTMODEEDIT)){
            mb.append("<li class=\"sortable-item\" id=\"placeholdercol3\" style=\"border-left: thick solid #e6e6e6; padding-left: 3px; margin-top: 20px;\"><img src=\""+pageProps.pathToAppRoot+"images/clear.gif\" border=\"0\" width=\"50\" height=\"1\"></li>");
        }
        mb.append("</ul>");
        mb.append("</div>");
        mb.append("\n<!-- End FieldLayout.java Megafields Col 3 -->\n");

        //Close fieldlayout div that wraps all 3 columns
        mb.append("</div>\n\n");



        return mb.toString();
    }

    private static String getGraphLinks(FieldType fld, int logid){
        StringBuffer mb = new StringBuffer();
        //Output graph links
        if (fld.getMegadatatypeid()!=reger.mega.DataTypeString.DATATYPEID){
            //Numeric fields
            String fieldNameUrlEncoded = "";
            try{
                fieldNameUrlEncoded = java.net.URLEncoder.encode(fld.getFieldname() + " vs. Time","UTF-8");
            } catch(Exception e){
                reger.core.Debug.debug(4, "FieldLayout.java", e);
                fieldNameUrlEncoded = fld.getFieldname() + " vs. Time";
            }
            mb.append("<br>");
            mb.append("<font face=arial class=smallfont size=-2>");
            mb.append("Graph this field:");
            mb.append("<br>");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+FieldType.XAXISDATETIME+"_0_0&yMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&daterange="+reger.Vars.DATERANGETHISWEEK+"&charttype="+reger.Vars.CHARTTYPELINE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("This Week");
            mb.append("</a>");
            mb.append(" | ");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+FieldType.XAXISDATETIME+"_0_0&yMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&daterange="+reger.Vars.DATERANGETHISMONTH+"&charttype="+reger.Vars.CHARTTYPELINE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("This Month");
            mb.append("</a>");
            mb.append(" | ");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+FieldType.XAXISDATETIME+"_0_0&yMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&daterange="+reger.Vars.DATERANGETHISYEAR+"&charttype="+reger.Vars.CHARTTYPELINE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("This Year");
            mb.append("</a>");
            mb.append("<br>");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+FieldType.XAXISDATETIME+"_0_0&yMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&daterange="+reger.Vars.DATERANGELASTXDAYS+"&lastxdays=7&charttype="+reger.Vars.CHARTTYPELINE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("Last 7 Days");
            mb.append("</a>");
            mb.append(" | ");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+FieldType.XAXISDATETIME+"_0_0&yMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&daterange="+reger.Vars.DATERANGELASTXDAYS+"&lastxdays=30&charttype="+reger.Vars.CHARTTYPELINE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("Last 30 Days");
            mb.append("</a>");
            mb.append(" | ");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+FieldType.XAXISDATETIME+"_0_0&yMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&daterange="+reger.Vars.DATERANGELASTXDAYS+"&lastxdays=365&charttype="+reger.Vars.CHARTTYPELINE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("Last 365 Days");
            mb.append("</a>");
            mb.append("</font>");
        } else {
            //Alpha fields
            String fieldNameUrlEncoded = "";
            try{
                fieldNameUrlEncoded = java.net.URLEncoder.encode(fld.getFieldname() + " vs. Time","UTF-8");
            } catch(Exception e){
                reger.core.Debug.debug(4, "FieldLayout.java", e);
                fieldNameUrlEncoded = fld.getFieldname() + " vs. Time";
            }
            mb.append("<br>");
            mb.append("<font face=arial class=smallfont size=-2>");
            mb.append("Graph this field:");
            mb.append("<br>");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&yMegafieldChoice="+FieldType.YAXISCOUNT+"_0_0&daterange="+reger.Vars.DATERANGETHISWEEK+"&charttype="+reger.Vars.CHARTTYPE3DPIE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("This Week");
            mb.append("</a>");
            mb.append(" | ");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&yMegafieldChoice="+FieldType.YAXISCOUNT+"_0_0&daterange="+reger.Vars.DATERANGETHISMONTH+"&charttype="+reger.Vars.CHARTTYPE3DPIE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("This Month");
            mb.append("</a>");
            mb.append(" | ");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&yMegafieldChoice="+FieldType.YAXISCOUNT+"_0_0&daterange="+reger.Vars.DATERANGETHISYEAR+"&charttype="+reger.Vars.CHARTTYPE3DPIE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("This Year");
            mb.append("</a>");
            mb.append("<br>");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&yMegafieldChoice="+FieldType.YAXISCOUNT+"_0_0&daterange="+reger.Vars.DATERANGELASTXDAYS+"&lastxdays=7&charttype="+reger.Vars.CHARTTYPE3DPIE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("Last 7 Days");
            mb.append("</a>");
            mb.append(" | ");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&yMegafieldChoice="+FieldType.YAXISCOUNT+"_0_0&daterange="+reger.Vars.DATERANGELASTXDAYS+"&lastxdays=30&charttype="+reger.Vars.CHARTTYPE3DPIE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("Last 30 Days");
            mb.append("</a>");
            mb.append(" | ");
            mb.append("<a href='graphs-detail.log?ispreview=0&chartname="+fieldNameUrlEncoded+"&xMegafieldChoice="+fld.getMegafieldid()+"_"+logid+"_"+fld.getEventtypeid()+"&yMegafieldChoice="+FieldType.YAXISCOUNT+"_0_0&daterange="+reger.Vars.DATERANGELASTXDAYS+"&lastxdays=365&charttype="+reger.Vars.CHARTTYPE3DPIE+"&chartsize="+reger.Vars.CHARTSIZEMEDIUM+"&yaxiswhattodo="+reger.Vars.YAXISWHATTODOSUM+"'>");
            mb.append("Last 365 Days");
            mb.append("</a>");
            mb.append("</font>");
        }

        return mb.toString();
    }

    public static void processLayoutChange(javax.servlet.http.HttpServletRequest request){
        int logid=0;
        if (request.getParameter("logid")!=null && reger.core.Util.isinteger(request.getParameter("logid"))){
            logid = Integer.parseInt(request.getParameter("logid"));
        }
        int eventtypeid=0;
        if (request.getParameter("eventtypeid")!=null && reger.core.Util.isinteger(request.getParameter("eventtypeid"))){
            eventtypeid = Integer.parseInt(request.getParameter("eventtypeid"));
        }
        String action = "";
        if (request.getParameter("action")!=null && !request.getParameter("action").equals("")){
            action = request.getParameter("action");
        }
        String fieldorderholder = "";
        if (request.getParameter("fieldorderholder")!=null && !request.getParameter("fieldorderholder").equals("")){
            fieldorderholder = request.getParameter("fieldorderholder");
        }
        int megafieldid=0;
        if (request.getParameter("megafieldid")!=null && reger.core.Util.isinteger(request.getParameter("megafieldid"))){
            megafieldid = Integer.parseInt(request.getParameter("megafieldid"));
        }
        //Do the work
        processLayoutChange(logid, eventtypeid, megafieldid, action, fieldorderholder);
    }


    public static void processLayoutChange(int logid, int eventtypeid, int megafieldid, String action, String fieldorderholder){
        Debug.debug(5, "", "FieldLayout.processLayoutChange() called. action=" + action);
        //If we have an action and a logid or eventtypeid
        if (!action.equals("") && (logid>0 || eventtypeid>0)){
            //Handle field ordering
            if (action.equals("savelayout")){
                if (!fieldorderholder.equals("")){
                    Debug.debug(5, "", "FieldLayout.java - fieldorderholder=" + fieldorderholder);
                    //Save to appropriate object
                    if (logid>0){
                        Log log = LogCache.get(logid);
                        log.setFieldorder(fieldorderholder);
                        log.save();
                    } else if (eventtypeid>0){
                        MegaLogType mlt = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid);
                        mlt.setFieldorder(fieldorderholder);
                        mlt.save();
                    }
                }
            }

            //If we're working with a particular field
            if (megafieldid>0){
                //Get all fields for this eventtype or logtype
                ArrayList<FieldType> fields = new ArrayList<FieldType>();
                if (eventtypeid>0){
                    fields = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getMegaFields();
                }
                if (logid>0){
                    fields = LogCache.get(logid).getFields();
                }
                FieldType fld = null;
                //Iterate and find field with the correct megafieldid
                for (Iterator it = fields.iterator(); it.hasNext(); ) {
                    FieldType ft = (FieldType)it.next();
                    if (ft.getMegafieldid()==megafieldid){
                        fld = ft;
                    }
                }

                //Special handling for action=unhide because acting on a hidden field requires a call to the DB
                if (action.equals("unhide")){
                      fld = reger.AllFieldsInSystem.getMegaFieldByMegafieldid(megafieldid);
                }

                //If the field isn't null
                if (fld!=null){
                    //Remove
                    if (action.equals("remove")){
                        if (eventtypeid>0){
                            reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).removeField(fld.getMegafieldid());
                        }
                        if (logid>0){
                            LogCache.get(logid).removeField(fld.getMegafieldid());
                        }
                    }
                    //Unhide
                    if (action.equals("unhide")){
                        if (eventtypeid>0){
                            reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).unhideField(fld.getMegafieldid());
                        }
                        if (logid>0){
                            LogCache.get(logid).unhideField(fld.getMegafieldid());
                        }
                    }
                }
            }
        }
    }



    private static String topLayoutBar(int eventtypeid, int logid, String pageName, String newfieldPageName, PageProps pageProps){
        StringBuffer mb = new StringBuffer();

        //mb.append("<input type=text name=fieldorderholderdisplay id=\"fieldorderholderdisplay\" size=25 value=\"\">");
        //mb.append("<p><input class=\"inspector\" type=\"button\" value=\"Inspect Order\" onclick=\"regerInspectListOrder('fieldlist')\"/></p>");
        mb.append("<table cellpadding=5 cellspacing=1 border=0 class=greysolidborder>");
        mb.append("<tr>");

        //Save layout form


        //Customize toolbar
        mb.append("<td bgcolor=#e6e6e6 align=center>");
        mb.append("<font face=arial size=-2>");
        mb.append("<form id=\"savelayoutform\" action="+pageName+" method=post style=\"margin:0px;border:0px;\">");
        mb.append("<input type=hidden name=action value=savelayout>");
        mb.append("<input id=\"fieldorderholder\" type=hidden name=fieldorderholder>");
        mb.append("<input id=\"slf-eventtypeid\" type=hidden name=eventtypeid value="+eventtypeid+">");
        mb.append("<input id=\"slf-logid\" type=hidden name=logid value="+logid+">");
        mb.append("<input id=\"slf-returntopage\" type=hidden name=returntopage value="+pageName+">");
        mb.append("<input id=\"slf-mode\" type=hidden name=mode value=editlayout>");
        mb.append("<input type=submit value='Save Layout' onclick=\"setHiddenFormFieldToLayoutValues(fen);\" style=\"font-size: 10px;\">");
        mb.append("</form>");
        mb.append("</font>");
        mb.append("</td>");



        //Add field
        mb.append("<td bgcolor=#e6e6e6 align=center>");
        mb.append("<a href='"+newfieldPageName+"?logid="+logid+"&eventtypeid="+eventtypeid+"&action=addfield&returntopage="+pageName+"'>");
        mb.append("<font face=arial size=-2>");
        mb.append("<img src='images/add_16.gif' width=16 height=16 border=0 align=middle>");
        mb.append("Add Field");
        mb.append("</font>");
        mb.append("</a>");
        mb.append("</td>");



        //Unhide start
        ArrayList<FieldType> hiddenfields = null;
        if (eventtypeid>0){
            hiddenfields = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getMegaFieldsHidden();
        }
        if (logid>0){
            hiddenfields = LogCache.get(logid).getFieldshidden();
        }
        if (hiddenfields!=null && hiddenfields.size()>0){
            mb.append("<td bgcolor=#e6e6e6 align=center>");
            mb.append("<form action="+pageName+" method=post style=\"margin:0px;border:0px;\">");
            mb.append("<input type=hidden name=action value=unhide>");
            mb.append("<input type=hidden name=eventtypeid value="+eventtypeid+">");
            mb.append("<input type=hidden name=logid value="+logid+">");
            mb.append("<input type=hidden name=returntopage value="+pageName+">");
            mb.append("<input type=hidden name=mode value=editlayout>");
            mb.append("<select name='megafieldid' style=\"font-size: 10px;\">");
            for (Iterator it = hiddenfields.iterator(); it.hasNext(); ) {
                FieldType ft = (FieldType)it.next();
                mb.append("<option value='"+ft.getMegafieldid()+"'>"+ft.getFieldname()+"</option>");
            }
            mb.append("</select>");
            mb.append("<input type=submit value='Unhide Field' onclick=\"javascript: savelayout();\" style=\"font-size: 10px;\">");
            mb.append("</form>");
            mb.append("</td>");
        }
        //Unhide end

        //Help start
        mb.append("<td bgcolor=#e6e6e6 align=center>");
        mb.append("<a href='"+newfieldPageName+"?logid="+logid+"&eventtypeid="+eventtypeid+"&action=addfield&returntopage="+pageName+"'>");
        StringBuffer helpContent = new StringBuffer();
        helpContent.append("This screen allows you to customize the extra fields that go with your log entries.  Using this capability you are able to compile, organize and publish data on any activity quickly and easily.");
        helpContent.append("<br>");
        helpContent.append("<ul>");
        helpContent.append("<li>Start by adding a field.</li>");
        helpContent.append("<li>Drag and drop fields to rearrange them.  Make sure that you click Save Layout when you're done.</li>");
        helpContent.append("<li>Click Remove to get rid of fields.  If there is data in the system for that field, or if you don't own that field, it will be hidden.  You can unhide hidden fields.</li>");
        helpContent.append("<li>You can edit properties for fields that you own.  Click the edit button.</li>");
        helpContent.append("</ul>");
        String help = reger.Help.tip("Customizing datablogging Fields", helpContent.toString(), false, pageProps.pathToAppRoot);
        mb.append("<font face=arial size=-2>");
        mb.append(help);
        mb.append("</font>");
        mb.append("</a>");
        mb.append("</td>");
        //Help end

        mb.append("</tr>");
        mb.append("</table>");

        return mb.toString();
    }

}
