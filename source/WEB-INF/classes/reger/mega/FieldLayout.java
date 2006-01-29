package reger.mega;

import reger.UserSession;
import reger.MegaLogType;
import reger.Log;
import reger.core.Debug;
import reger.cache.LogCache;
import reger.pageFramework.PageProps;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Manages the layout of fields in a log
 */
public class FieldLayout {

    public static final int LAYOUTMODEPUBLIC = 1;
    public static final int LAYOUTMODEADMIN = 2;
    public static final int LAYOUTMODEEDIT = 3;

    public static String getHtml(int eventtypeid, int logid, int LAYOUTMODE, UserSession userSessionOfSaver, String pageName, String fieldPageName, String newFieldPageName, reger.pageFramework.PageProps pageProps){
        StringBuffer mb = new StringBuffer();

        Debug.debug(5, "FieldLayout.java", "FieldLayout.java getHtml(eventtypeid="+eventtypeid+", logid="+logid+", LAYOUTMODE="+LAYOUTMODE+")");

        //If this is edit mode
        if (LAYOUTMODE==LAYOUTMODEEDIT) {
            mb.append(topLayoutBar(eventtypeid, logid, pageName, newFieldPageName, pageProps));
            mb.append("<img src=images/clear.gif width=1 height=2 border=0>");
        }

        //Go get the fields to work with, either from the entry, log or the log type
        ArrayList<FieldType> fields = null;
        FieldOrderCollection fieldOrderCollection = null;
        if (eventtypeid>0){
            fields = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getMegaFields();
            fieldOrderCollection = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getFieldOrderCollection();
            Debug.debug(5, "FieldLayout.java", "Using fields from AllMegaLogTypesInSystem");
        }
        if (logid>0){
            fields = LogCache.get(logid).getFields();
            fieldOrderCollection = LogCache.get(logid).getFieldOrderCollection();
            Debug.debug(5, "FieldLayout.java", "Using fields from LogCache");
        }
        if (pageProps.entry.eventid>0){
            fields=pageProps.entry.fields;
            Debug.debug(5, "FieldLayout.java", "Using fields from pageProps.entry");
        }


        //Javascript for dhtml
        mb.append("<script type='text/javascript' src='../js/cross-browser.com/x/x_core.js'></script>" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("<script type='text/javascript' src='../js/cross-browser.com/x/x_event.js'></script>" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("<script type='text/javascript' src='../js/cross-browser.com/x/x_drag.js'></script>" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("<script type='text/javascript' src='../js/cross-browser.com-regercomadditional/resizablewindow.js'></script>" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("<script type='text/javascript' src='../js/cross-browser.com-regercomadditional/sethiddenformfieldtolayoutvalues.js'></script>" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("<script type='text/javascript' src='../js/cross-browser.com-regercomadditional/savelayout.js'></script>" + reger.Vars.LINEBREAKCHARFORHTML);

        //Javascript for remoting
        mb.append("<script src='/dwr/interface/FieldLayoutSave.js'></script>" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("<script src='/dwr/engine.js'></script>" + reger.Vars.LINEBREAKCHARFORHTML);

        //Javascript window.onload
        String isMovableAndDraggable = "false";
        if (LAYOUTMODE==LAYOUTMODEEDIT) {
            isMovableAndDraggable = "true";
        }
        mb.append("<script language=\"JavaScript\" type=\"text/javascript\"><!--" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("var fen = new Array();" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("var wrapper;" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("window.onload = function()" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("{" + reger.Vars.LINEBREAKCHARFORHTML);
        int wrapperWidth = 0;
        int wrapperHeight = 0;
        if (fields!=null){
            int i = 0;
            for (Iterator it = fields.iterator(); it.hasNext(); ) {
                FieldType fld = (FieldType)it.next();
                if (fld!=null){
                    int x = 0;
                    int y = wrapperHeight + 2;
                    int w = 400;
                    int h = 150;
                    FieldOrder fo = fieldOrderCollection.getFieldOrderForMegafieldid(fld.getMegafieldid());
                    if (fo!=null){
                        x = fo.getX();
                        y = fo.getY();
                        w = fo.getW();
                        h = fo.getH();
                    }
                    if ((x+w)>wrapperWidth){
                        wrapperWidth = x+w;
                    }
                    if ((y+h)>wrapperHeight){
                        wrapperHeight = y+h;
                    }
                    mb.append("    fen["+i+"] = new xFenster('"+fld.getMegafieldid()+"', 'fieldBox"+fld.getMegafieldid()+"', "+x+", "+y+", "+w+", "+h+", 'fieldBoxBar"+fld.getMegafieldid()+"', 'fieldBoxResBtn"+fld.getMegafieldid()+"', 'fieldBoxContent"+fld.getMegafieldid()+"', "+isMovableAndDraggable+", "+isMovableAndDraggable+");" + reger.Vars.LINEBREAKCHARFORHTML);
                    i++;
                }
            }
        }
        mb.append("    wrapper = new xFenster('0', 'fieldBoxWrapper', 0, 0, "+(wrapperWidth+50)+", "+(wrapperHeight+50)+", 'fieldBoxBarWrapper', 'fieldBoxResBtnWrapper', 'fieldBoxContentWrapper', "+isMovableAndDraggable+", "+isMovableAndDraggable+");" + reger.Vars.LINEBREAKCHARFORHTML);
        //Resize wrapper to browser window, if that's larger than the current work space
        if (LAYOUTMODE==LAYOUTMODEEDIT) {
            mb.append("    var newWidth = xClientWidth()-xPageX('fieldBoxWrapper')-20;" + reger.Vars.LINEBREAKCHARFORHTML);
            mb.append("    if (xClientWidth() > ("+(wrapperWidth+30)+"+xPageX('fieldBoxWrapper')+20)){;" + reger.Vars.LINEBREAKCHARFORHTML);
            mb.append("        wrapper.resizeAbsolute(newWidth, "+(wrapperHeight+50)+");" + reger.Vars.LINEBREAKCHARFORHTML);
            mb.append("    }" + reger.Vars.LINEBREAKCHARFORHTML);
        }
        mb.append("}" + reger.Vars.LINEBREAKCHARFORHTML);

        //Javascript window.onunload
        mb.append("window.onunload = function()" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("{" + reger.Vars.LINEBREAKCHARFORHTML);
        if (LAYOUTMODE==LAYOUTMODEEDIT) {
            mb.append("  savelayout();" + reger.Vars.LINEBREAKCHARFORHTML);
        }
        mb.append("  for (var i = 0; i < fen.length; ++i) {" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("    fen[i].onunload();" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("  }" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("}" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("--></script>" + reger.Vars.LINEBREAKCHARFORHTML);

        //Box Style
        if (LAYOUTMODE==LAYOUTMODEEDIT) {
            mb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"../js/cross-browser.com-regercomadditional/boxstyleedit.css\"/>" + reger.Vars.LINEBREAKCHARFORHTML);
        } else {
            mb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"../js/cross-browser.com-regercomadditional/boxstylenoedit.css\"/>" + reger.Vars.LINEBREAKCHARFORHTML);
        }

        //Fields wrapper start
        mb.append("<div id='fieldBoxWrapper' class='fieldBoxWrapper'>" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("    <div id='fieldBoxBarWrapper' class='fieldBoxBarWrapper' title='Drag to Move'>");
        mb.append("    </div>" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("    <div id='fieldBoxContentWrapper' class='fieldBoxContent'>" + reger.Vars.LINEBREAKCHARFORHTML);

            //Start invividual fields
            if (fields!=null){
                for (Iterator it = fields.iterator(); it.hasNext(); ) {
                    FieldType fld = (FieldType)it.next();
                    if (fld!=null){
                        Debug.debug(5, "FieldLayout.java", "FieldLayout.java field not null.  fld.getFieldname()" + fld.getFieldname());
                        mb.append("<div id='fieldBox"+fld.getMegafieldid()+"' class='fieldBox'>" + reger.Vars.LINEBREAKCHARFORHTML);
                        mb.append("    <div id='fieldBoxBar"+fld.getMegafieldid()+"' class='fieldBoxBar' title='Drag to Move'>");
                        //Remove field button
                        if (LAYOUTMODE==LAYOUTMODEEDIT) {
                            mb.append("    <div style=\"float: right; width: 15px;\" title='Click to Remove'><a href='"+pageName+"?logid="+logid+"&eventtypeid="+eventtypeid+"&action=remove&megafieldid="+fld.getMegafieldid()+"&mode=editlayout' onclick=\"javascript: savelayout();\"><img src='"+pageProps.pathToAppRoot+"js/cross-browser.com-regercomadditional/images/closebox15-yel.gif' border=0 width=15 height=15 align=right alt='Click to Remove'></a></div>");
                        }
                        //Edit button
                        if (LAYOUTMODE==LAYOUTMODEEDIT) {
                            if (fld.isFieldOwnedByAccountuser(userSessionOfSaver.getAccountuser())){
                                mb.append("<div style=\"float: right; width: 35px;\" title='Click to Edit'>");
                                mb.append("<a href='"+fieldPageName+"?logid="+logid+"&eventtypeid="+eventtypeid+"&action=edit&megafieldid="+fld.getMegafieldid()+"&returntopage="+pageName+"'>");
                                mb.append("Edit");
                                mb.append("</a>");
                                mb.append("</div>");
                            }
                        }
                        //Field name
                        mb.append(fld.getFieldname());
                        //Requiredness
                        if (fld.getIsrequired()==1){
                            mb.append(" (Required)");
                        }
                        mb.append(     "</div>" + reger.Vars.LINEBREAKCHARFORHTML);
                        //Field description
                        if (!fld.getFielddescription().equals("")) {
                            mb.append("    <div id='fieldBoxDesc"+fld.getMegafieldid()+"' class='fieldBoxDesc' title=''>"+fld.getFielddescription()+"</div>" + reger.Vars.LINEBREAKCHARFORHTML);
                        }
                        //Field content
                        mb.append("    <div id='fieldBoxContent"+fld.getMegafieldid()+"' class='fieldBoxContent'>" + reger.Vars.LINEBREAKCHARFORHTML);

                        //Start field output, synchronize the field
                        //synchronized(fld){
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
                            }
                        //}
                        //End field output

                        mb.append("    </div>" + reger.Vars.LINEBREAKCHARFORHTML);
                        mb.append("    <div id='fieldBoxResBtn"+fld.getMegafieldid()+"' class='fieldBoxResBtn' title='Drag to Resize'>");
                        //Bottom right corner drag button
                        if (LAYOUTMODE==LAYOUTMODEEDIT) {
                            mb.append("<img src='"+pageProps.pathToAppRoot+"js/cross-browser.com-regercomadditional/images/resize_blue.gif' border=0 valign=bottom align=right>");
                        }
                        mb.append("</div>" + reger.Vars.LINEBREAKCHARFORHTML);
                        mb.append("</div>" + reger.Vars.LINEBREAKCHARFORHTML);
                    }
                }
            }
            //End invividual fields

        mb.append("    </div>" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("    <div id='fieldBoxResBtnWrapper' class='fieldBoxResBtn' title='Drag to Resize'>");
        if (LAYOUTMODE==LAYOUTMODEEDIT) {
            mb.append("<img src='"+pageProps.pathToAppRoot+"js/cross-browser.com-regercomadditional/images/resize_blue.gif' border=0 valign=bottom align=right>");
        }
        mb.append("</div>" + reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("</div>" + reger.Vars.LINEBREAKCHARFORHTML);
        //Fields wrapper end

        mb.append(reger.Vars.LINEBREAKCHARFORHTML);

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
