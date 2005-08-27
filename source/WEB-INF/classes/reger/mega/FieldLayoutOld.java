package reger.mega;

import reger.UserSession;
import reger.MegaLogType;
import reger.Log;
import reger.pageFramework.PageProps;


/**
 * Manages the layout of fields in a log
 */
public class FieldLayoutOld {

//    public static final int LAYOUTMODEPUBLIC = 1;
//    public static final int LAYOUTMODEADMIN = 2;
//    public static final int LAYOUTMODEEDIT = 3;
//
//    public static String getHtml(int eventtypeid, int logid, int LAYOUTMODE, int EDITFIELDFOR, int EDITFIELDAS, UserSession userSessionOfSaver, String pageName, String fieldPageName, String newfieldPageName, pageProps pageProps){
//        StringBuffer mb = new StringBuffer();
//
//        //Just a debugging tool
//        boolean showCoords = false;
//
//        if (LAYOUTMODE==LAYOUTMODEEDIT) {
//            mb.append(topLayoutBar(eventtypeid, logid, LAYOUTMODE, EDITFIELDFOR, EDITFIELDAS, userSessionOfSaver, pageName, fieldPageName, newfieldPageName, pageProps));
//            mb.append("<img src=images/clear.gif width=1 height=2 border=0>");
//        }
//
//        //Go get the fields to work with
//        FieldType[] fields = null;
//        if (eventtypeid>0){
//            fields = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getMegaFields();
//        }
//        if (logid>0){
//            fields = reger.AllLogsInSystem.getLogByLogid(logid).getFields();
//        }
//        reger.core.Util.debug(5, "FieldLayout.java getHtml(eventtypeid="+eventtypeid+", logid="+logid+", LAYOUTMODE="+LAYOUTMODE+")");
//        //Output fields
//        if (LAYOUTMODE==LAYOUTMODEEDIT) {
//            mb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"../js/tool-man-dhtml-drag/common/lists.css\"/>" + reger.Vars.LINEBREAKCHARFORHTML);
//        } else {
//            mb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"../js/tool-man-dhtml-drag/listsnonedit.css\"/>" + reger.Vars.LINEBREAKCHARFORHTML);
//        }
//        mb.append("<ul id=\"fieldlist\" class=\"boxy\">");
//        for (int i = 0; i < fields.length; i++) {
//            FieldType fld = fields[i];
//            if (fld!=null){
//                reger.core.Util.debug(5, "FieldLayout.java field not null.  fld.getFieldname()" + fld.getFieldname());
//                //Create a list item
//                mb.append("<li id=\""+fld.getMegafieldid()+"\">");
//
//
//                mb.append("<div class=fieldbasicinfo id=\"fieldid-"+fld.getMegafieldid()+"\">");
//                //The control buttons
//                if (LAYOUTMODE==LAYOUTMODEEDIT) {
//                    if (fld.isFieldOwnedByAccountuser(userSessionOfSaver.getAccountuser())){
//                        mb.append("<a href='"+fieldPageName+"?logid="+logid+"&eventtypeid="+eventtypeid+"&action=edit&megafieldid="+fld.getMegafieldid()+"&returntopage="+pageName+"'>");
//                        mb.append("<font face=arial size=-2>");
//                        mb.append("Edit Field Properties");
//                        mb.append("</font>");
//                        mb.append("</a>");
//                        mb.append("<br>");
//                    }
//
//
//                    mb.append("<a href='"+pageName+"?logid="+logid+"&eventtypeid="+eventtypeid+"&action=remove&megafieldid="+fld.getMegafieldid()+"&mode=editlayout'>");
//                    mb.append("<font face=arial size=-2>");
//                    mb.append("Remove Field");
//                    mb.append("</font>");
//                    mb.append("</a>");
//                    mb.append("<br>");
//                }
//
//                //Field Name
//                mb.append("<font face=arial size=-1><b>"+ fld.getFieldname() +"</b></font>");
//                //Requiredness
//                if (fld.getIsrequired()==1){
//                    mb.append("<font face=arial size=-2 color=#ff0000>");
//                    mb.append("&nbsp;&nbsp;");
//                    mb.append("Required");
//                    mb.append("</font>");
//                }
//
//                //The description
//                if (!fld.getFielddescription().equals("")) {
//                    mb.append("<br>");
//                    mb.append("<font face=arial size=-2>");
//                    mb.append(fld.getFielddescription());
//                    mb.append("</font>");
//                }
//
//                mb.append("</div>");
//
//
//                //Show the field html
//                mb.append("<div class=fielddata id=\"fieldid-"+fld.getMegafieldid()+"\">");
//                if (LAYOUTMODE==LAYOUTMODEADMIN){
//                    mb.append(fld.getHtmlAdmin(logid, true));
//                } else if (LAYOUTMODE==LAYOUTMODEEDIT) {
//                    mb.append(fld.getHtmlAdmin(logid, false));
//                } else {
//                    String tmp = fld.getHtmlPublic(logid);
//                    if (tmp.equals("")){
//                        mb.append("&nbsp;");
//                    } else {
//                        mb.append(tmp);
//                    }
//                }
//                mb.append("</div>");
//
//                //Close the list item
//                mb.append("</li>");
//            }
//        }
//        mb.append("</ul>");
//        mb.append(reger.Vars.LINEBREAKCHARFORHTML);
//
//
//        return mb.toString();
//    }
//
//    public static void processLayoutChange(javax.servlet.http.HttpServletRequest request, UserSession userSessionOfSaver, int EDITFIELDAS){
//        int logid=0;
//        if (request.getParameter("logid")!=null && reger.core.Util.isinteger(request.getParameter("logid"))){
//            logid = Integer.parseInt(request.getParameter("logid"));
//        }
//        int eventtypeid=0;
//        if (request.getParameter("eventtypeid")!=null && reger.core.Util.isinteger(request.getParameter("eventtypeid"))){
//            eventtypeid = Integer.parseInt(request.getParameter("eventtypeid"));
//        }
//        String action = "";
//        if (request.getParameter("action")!=null && !request.getParameter("action").equals("")){
//            action = request.getParameter("action");
//        }
//
//        //If we have an action and a logid or eventtypeid
//        if (!action.equals("") && (logid>0 || eventtypeid>0)){
//
//            //Handle field ordering
//            if (action.equals("savelayout")){
//                if (request.getParameter("fieldorderholder")!=null && !request.getParameter("fieldorderholder").equals("")){
//                    reger.core.Util.debug(5, "FieldLayout.java - request.getParameter(\"fieldorderholder\")=" + request.getParameter("fieldorderholder"));
//                    //Convert to an array
//                    int[] fldorder = new int[0];
//                    try{
//                        String[] fo = request.getParameter("fieldorderholder").split("\\|");
//                        fldorder = new int[fo.length];
//                        for (int j = 0; j < fo.length; j++) {
//                            if (reger.core.Util.isinteger(fo[j])){
//                                fldorder[j] = Integer.parseInt(fo[j]);
//                            }
//                        }
//                    } catch (Exception e){
//                        reger.core.Util.errorsave(e);
//                    }
//                    //Save to appropriate object
//                    if (eventtypeid>0){
//                        MegaLogType mlt = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid);
//                        mlt.setFieldorder(fldorder);
//                        mlt.save();
//                    }
//                    if (logid>0){
//                        Log log = reger.AllLogsInSystem.getLogByLogid(logid);
//                        log.setFieldorder(fldorder);
//                        log.save();
//                    }
//                }
//            }
//
//            //Make sure we have a fieldid to work with
//            if (request.getParameter("megafieldid")!=null && reger.core.Util.isinteger(request.getParameter("megafieldid"))){
//                //Get all fields for this eventtype or logtype
//                FieldType[] fields = null;
//                if (eventtypeid>0){
//                    fields = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getMegaFields();
//                }
//                if (logid>0){
//                    fields = reger.AllLogsInSystem.getLogByLogid(logid).getFields();
//                }
//                FieldType fld = null;
//                //Iterate and find field with the correct megafieldid
//                for (int i = 0; i < fields.length; i++) {
//                    if (fields[i].getMegafieldid()==Integer.parseInt(request.getParameter("megafieldid"))){
//                        fld = fields[i];
//                    }
//                }
//
//                //Special handling for action=unhide because acting on a hidden field requires a call to the DB
//                if (action.equals("unhide")){
//                      fld = reger.AllFieldsInSystem.getMegaFieldByMegafieldid(Integer.parseInt(request.getParameter("megafieldid")));
//                }
//
//                //If the field isn't null
//                if (fld!=null){
//                    //Remove
//                    if (action.equals("remove")){
//                        if (eventtypeid>0){
//                            reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).removeField(fld.getMegafieldid());
//                        }
//                        if (logid>0){
//                            reger.AllLogsInSystem.getLogByLogid(logid).removeField(fld.getMegafieldid());
//                        }
//                    }
//                    //Unhide
//                    if (action.equals("unhide")){
//                        if (eventtypeid>0){
//                            reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).unhideField(fld.getMegafieldid());
//                        }
//                        if (logid>0){
//                            reger.AllLogsInSystem.getLogByLogid(logid).unhideField(fld.getMegafieldid());
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//
//
//    private static String topLayoutBar(int eventtypeid, int logid, int LAYOUTMODE, int EDITFIELDFOR, int EDITFIELDAS, UserSession userSessionOfSaver, String pageName, String fieldPageName, String newfieldPageName, pageProps pageProps){
//        StringBuffer mb = new StringBuffer();
//
//        //Scripts
//        mb.append("<script language=\"JavaScript\" type=\"text/javascript\" src=\"../js/tool-man-dhtml-drag/source/org/tool-man/core.js\"></script>" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("<script language=\"JavaScript\" type=\"text/javascript\" src=\"../js/tool-man-dhtml-drag/source/org/tool-man/events.js\"></script>" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("<script language=\"JavaScript\" type=\"text/javascript\" src=\"../js/tool-man-dhtml-drag/source/org/tool-man/css.js\"></script>" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("<script language=\"JavaScript\" type=\"text/javascript\" src=\"../js/tool-man-dhtml-drag/source/org/tool-man/coordinates.js\"></script>" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("<script language=\"JavaScript\" type=\"text/javascript\" src=\"../js/tool-man-dhtml-drag/source/org/tool-man/drag.js\"></script>" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("<script language=\"JavaScript\" type=\"text/javascript\" src=\"../js/tool-man-dhtml-drag/source/org/tool-man/dragsort.js\"></script>" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("<script language=\"JavaScript\" type=\"text/javascript\" src=\"../js/tool-man-dhtml-drag/source/org/tool-man/cookies.js\"></script>" + reger.Vars.LINEBREAKCHARFORHTML);
//
//        mb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"../js/tool-man-dhtml-drag/regercomentrypage.css\"/>" + reger.Vars.LINEBREAKCHARFORHTML);
//
//        mb.append("<script language=\"JavaScript\" type=\"text/javascript\"><!--" + reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append("var dragsort = ToolMan.dragsort()" + reger.Vars.LINEBREAKCHARFORHTML);
//	        mb.append("var junkdrawer = ToolMan.junkdrawer()" + reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append("window.onload = function() {" + reger.Vars.LINEBREAKCHARFORHTML);
//                //mb.append("alert(\"hideho.\")" + reger.Vars.LINEBREAKCHARFORHTML);
//                mb.append("junkdrawer.restoreListOrder(\"fieldlist\")" + reger.Vars.LINEBREAKCHARFORHTML);
//		        mb.append("dragsort.makeListSortable(document.getElementById(\"fieldlist\"), verticalOnly)" + reger.Vars.LINEBREAKCHARFORHTML);
//                mb.append("regerInspectListOrder('fieldlist')"+ reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append("}" + reger.Vars.LINEBREAKCHARFORHTML);
//
//
//            mb.append("function verticalOnly(item) {" + reger.Vars.LINEBREAKCHARFORHTML);
//		        mb.append("item.toolManDragGroup.verticalOnly()" + reger.Vars.LINEBREAKCHARFORHTML);
//	        mb.append("}" + reger.Vars.LINEBREAKCHARFORHTML);
//
//	        mb.append("function saveLayout(id){" + reger.Vars.LINEBREAKCHARFORHTML);
//                 //mb.append("document.getElementById(\"fieldorderholderdisplay\").value = regerSerializeList(document.getElementById(id))" + reger.Vars.LINEBREAKCHARFORHTML);
//                 mb.append("document.getElementById(\"fieldorderholder\").value = regerSerializeList(document.getElementById(id))" + reger.Vars.LINEBREAKCHARFORHTML);
//                 mb.append("document.getElementById(\"savelayoutform\").submit()"+ reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append("}" + reger.Vars.LINEBREAKCHARFORHTML);
//
//            mb.append("function regerInspectListOrder(id){" + reger.Vars.LINEBREAKCHARFORHTML);
//                 //mb.append("document.getElementById(\"fieldorderholderdisplay\").value = regerSerializeList(document.getElementById(id))" + reger.Vars.LINEBREAKCHARFORHTML);
//                 mb.append("document.getElementById(\"fieldorderholder\").value = regerSerializeList(document.getElementById(id))" + reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append("}" + reger.Vars.LINEBREAKCHARFORHTML);
//
//            mb.append("function regerSerializeList(list){" + reger.Vars.LINEBREAKCHARFORHTML);
//                mb.append("var items = list.getElementsByTagName(\"li\")" + reger.Vars.LINEBREAKCHARFORHTML);
//                mb.append("var array = new Array()" + reger.Vars.LINEBREAKCHARFORHTML);
//                mb.append("for (var i = 0, n = items.length; i < n; i++) {" + reger.Vars.LINEBREAKCHARFORHTML);
//                    mb.append("var item = items[i]" + reger.Vars.LINEBREAKCHARFORHTML);
//
//                    mb.append("array.push(ToolMan.junkdrawer()._identifier(item))" + reger.Vars.LINEBREAKCHARFORHTML);
//                mb.append("}" + reger.Vars.LINEBREAKCHARFORHTML);
//                mb.append("return array.join('|')" + reger.Vars.LINEBREAKCHARFORHTML);
//            mb.append("}" + reger.Vars.LINEBREAKCHARFORHTML);
//
//        mb.append("" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("//-->" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("</script>" + reger.Vars.LINEBREAKCHARFORHTML);
//
//
//        //mb.append("<input type=text name=fieldorderholderdisplay id=\"fieldorderholderdisplay\" size=25 value=\"\">");
//        //mb.append("<p><input class=\"inspector\" type=\"button\" value=\"Inspect Order\" onclick=\"regerInspectListOrder('fieldlist')\"/></p>");
//        mb.append("<table cellpadding=5 cellspacing=1 border=0 class=greysolidborder>");
//        mb.append("<tr>");
//
//
//
//        //Save layout button
//        mb.append("<td bgcolor=#e6e6e6 align=center>");
//        mb.append("<form id=\"savelayoutform\" action="+pageName+" method=post style=\"margin:0px;border:0px;\">");
//        mb.append("<input type=hidden name=action value=savelayout>");
//        mb.append("<input id=\"fieldorderholder\" type=hidden name=fieldorderholder>");
//        mb.append("<input type=hidden name=eventtypeid value="+eventtypeid+">");
//        mb.append("<input type=hidden name=logid value="+logid+">");
//        mb.append("<input type=hidden name=returntopage value="+pageName+">");
//        mb.append("<input type=hidden name=mode value=editlayout>");
//        mb.append("<input type=submit value='Save Layout' onclick=\"regerInspectListOrder('fieldlist');\" style=\"font-size: 10px;\">");
//        mb.append("</form>");
//        mb.append("</td>");
//
//
//
//        //Add field
//        mb.append("<td bgcolor=#e6e6e6 align=center>");
//        mb.append("<a href='"+newfieldPageName+"?logid="+logid+"&eventtypeid="+eventtypeid+"&action=addfield&returntopage="+pageName+"'>");
//        mb.append("<font face=arial size=-2>");
//        mb.append("<img src='images/add_16.gif' width=16 height=16 border=0 align=middle>");
//        mb.append("Add Field");
//        mb.append("</font>");
//        mb.append("</a>");
//        mb.append("</td>");
//
//
//
//        //Unhide start
//        FieldType[] hiddenfields = null;
//        if (eventtypeid>0){
//            hiddenfields = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getMegaFieldsHidden();
//        }
//        if (logid>0){
//            hiddenfields = reger.AllLogsInSystem.getLogByLogid(logid).getFieldshidden();
//        }
//        if (hiddenfields!=null && hiddenfields.length>0){
//            mb.append("<td bgcolor=#e6e6e6 align=center>");
//            mb.append("<form action="+pageName+" method=post style=\"margin:0px;border:0px;\">");
//            mb.append("<input type=hidden name=action value=unhide>");
//            mb.append("<input type=hidden name=eventtypeid value="+eventtypeid+">");
//            mb.append("<input type=hidden name=logid value="+logid+">");
//            mb.append("<input type=hidden name=returntopage value="+pageName+">");
//            mb.append("<input type=hidden name=mode value=editlayout>");
//            mb.append("<select name='megafieldid' style=\"font-size: 10px;\">");
//            for (int i = 0; i < hiddenfields.length; i++) {
//                mb.append("<option value='"+hiddenfields[i].getMegafieldid()+"'>"+hiddenfields[i].getFieldname()+"</option>");
//            }
//            mb.append("</select>");
//            mb.append("<input type=submit value='Unhide Field' style=\"font-size: 10px;\">");
//            mb.append("</form>");
//            mb.append("</td>");
//        }
//        //Unhide end
//
//        //Help start
//        mb.append("<td bgcolor=#e6e6e6 align=center>");
//        mb.append("<a href='"+newfieldPageName+"?logid="+logid+"&eventtypeid="+eventtypeid+"&action=addfield&returntopage="+pageName+"'>");
//        StringBuffer helpContent = new StringBuffer();
//        helpContent.append("This screen allows you to customize the extra fields that go with your log entries.  Using this capability you are able to compile, organize and publish data on any activity quickly and easily.");
//        helpContent.append("<br>");
//        helpContent.append("<ul>");
//        helpContent.append("<li>Start by adding a field.</li>");
//        helpContent.append("<li>Drag and drop fields to rearrange them.  Make sure that you click Save Layout when you're done.</li>");
//        helpContent.append("<li>Click Remove to get rid of fields.  If there is data in the system for that field, or if you don't own that field, it will be hidden.  You can unhide hidden fields.</li>");
//        helpContent.append("<li>You can edit properties for fields that you own.  Click the edit button.</li>");
//        helpContent.append("</ul>");
//        String help = reger.Help.tip("Customizing datablogging Fields", helpContent.toString(), false, pageProps.pathToAppRoot);
//        mb.append("<font face=arial size=-2>");
//        mb.append(help);
//        mb.append("</font>");
//        mb.append("</a>");
//        mb.append("</td>");
//        //Help end
//
//        mb.append("</tr>");
//        mb.append("</table>");
//
//        return mb.toString();
//    }

}
