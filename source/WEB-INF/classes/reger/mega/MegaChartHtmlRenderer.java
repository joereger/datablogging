package reger.mega;

import reger.*;
import reger.core.db.Db;

import java.util.Vector;

/**
 * Renders a chart into html screen with options to set, etc.
 */
public class MegaChartHtmlRenderer {


    public static String getHtml(MegaChart megaChart, UserSession userSession, boolean isPreview, String pathToAppRoot, boolean isLOEPage, boolean showOnlyImage){
        StringBuffer mb = new StringBuffer();


        //Table-creation html joy.

        mb.append("<table cellpadding=0 cellspacing=0 border=0 width=100% bgcolor=#666666><tr><td>");
        mb.append("<table cellpadding=5 cellspacing=1 width=100% border=0>");

        //Output the img tag that calls the chart.
        //The url line is my only interface to the graph object.
        //I create the url line delicately.
        StringBuffer urlP=new StringBuffer();

        //Working
        //http://bob.reger.com/graph.log?xMegafieldChoice=-7_0_0&yMegafieldChoice=108_2_108&yMegafieldChoice=113_2_113&yMegafieldChoice=101_2_101&yaxiswhattodo=2&chartsize=3&charttype=12&daterange=1&lastxdays=1&lastxweeks=1&lastxmonths=16&lastxyears=1&daterangefromyyyy=2003&daterangefrommm=4&daterangefromdd=8&daterangetoyyyy=2004&daterangetomm=4&daterangetodd=8&daterangesavedsearchid=1&
        //Broken
        //http://bob.reger.com/graph.log?xMegafieldChoice=-7_0_16&yMegafieldChoice=113_0_16&yMegafieldChoice=101_0_16&yMegafieldChoice=108_0_16&yaxiswhattodo=2&chartsize=3&charttype=12&daterange=1&lastxdays=1&lastxweeks=1&lastxmonths=16&lastxyears=1&daterangefromyyyy=2003&daterangefrommm=4&daterangefromdd=8&daterangetoyyyy=2004&daterangetomm=4&daterangetodd=8&daterangesavedsearchid=0&

        //If there's no logid, I have to choose one.  This happens
        //when a user clicks on a system graph.  There is an eventtypeid,
        //but no logid.  So I'll choose the first logid that is of the type
        //that the system graph needs. This is kind of ugly.
        int tmpxLogid = megaChart.getxLogid();
        if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
            Vector tmpLogs = AllLogsInSystem.allLogsForAccount(userSession.getAccount().getAccountid());
            if(tmpxLogid<=0 && megaChart.getXeventtypeid()>0){
                if (!isLOEPage){
                    for (int j = 0; j < tmpLogs.size(); j++) {
                        Log log = (Log) tmpLogs.elementAt(j);
                        if (log.getEventtypeid()==megaChart.getXeventtypeid()){
                            tmpxLogid=log.getLogid();
                        }
                    }
                }
            }
        }
        //Reconstruct the xMegaFieldChoice
        urlP.append("xMegafieldChoice="+ megaChart.getxMegafieldid()+"_"+tmpxLogid+"_"+megaChart.getXeventtypeid() +"&");


        for(int i=0; i<megaChart.getyMegafieldid().length; i++){
            //If there's no logid, I have to choose one.  This happens
            //when a user clicks on a system graph.  There is an eventtypeid,
            //but no logid.  So I'll choose the first logid that is of the type
            //that the system graph needs. This is kind of ugly.
            int tmpyLogid = megaChart.getyLogid()[i];
            if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
                Vector tmpLogs = AllLogsInSystem.allLogsForAccount(userSession.getAccount().getAccountid());
                if(tmpyLogid<=0 && megaChart.getyEventtypeid()[i]>0){
                    if (!isLOEPage){
                        for (int j = 0; j < tmpLogs.size(); j++) {
                            Log log = (Log) tmpLogs.elementAt(j);
                            if (log.getEventtypeid()==megaChart.getyEventtypeid()[i]){
                                tmpyLogid=log.getLogid();
                            }
                        }
                    }
                }
            }
            //Reconstruct the yMegaFieldChoice
            urlP.append("yMegafieldChoice="+ megaChart.getyMegafieldid()[i]+"_"+tmpyLogid+"_"+megaChart.getyEventtypeid()[i] +"&");
        }



        urlP.append("yaxiswhattodo="+ megaChart.getYaxiswhattodo() +"&");
        urlP.append("chartsize="+ megaChart.getChartsize() +"&");
        urlP.append("charttype="+ megaChart.getCharttype() +"&");
        urlP.append("daterange="+ megaChart.getDaterange() +"&");
        urlP.append("lastxdays="+ megaChart.getLastxdays() +"&");
        urlP.append("lastxweeks="+ megaChart.getLastxweeks() +"&");
        urlP.append("lastxmonths="+ megaChart.getLastxmonths() +"&");
        urlP.append("lastxyears="+ megaChart.getLastxyears() +"&");
        urlP.append("daterangefromyyyy="+ megaChart.getDaterangefromyyyy() +"&");
        urlP.append("daterangefrommm="+ megaChart.getDaterangefrommm() +"&");
        urlP.append("daterangefromdd="+ megaChart.getDaterangefromdd() +"&");
        urlP.append("daterangetoyyyy="+ megaChart.getDaterangetoyyyy() +"&");
        urlP.append("daterangetomm="+ megaChart.getDaterangetomm() +"&");
        urlP.append("daterangetodd="+ megaChart.getDaterangetodd() +"&");
        urlP.append("daterangesavedsearchid="+ megaChart.getDaterangesavedsearchid() +"&");
        //Append whether it's a preview
        if (isPreview){
            urlP.append("ispreview=1&");
        }


        mb.append("<tr><td bgcolor=#ffffff align=center valign=top>");
        //Chart title
        if (!showOnlyImage){
            mb.append("<font face=arial size=+1 class=bigfont>");
            if (!megaChart.getChartname().equals("")){
                mb.append(megaChart.getChartname());
            } else {
                mb.append("Custom Graph");
            }
            mb.append("</font><br>");
        }

        //Chart image
        mb.append("<img src='"+pathToAppRoot+"graph.log?"+urlP+"' border=0>");
        mb.append("</td></tr>");


        //If we're only showing the image, go ahead and close the table
        if (showOnlyImage){
            mb.append("</table>");
            mb.append("</td></tr></table>");
        } else {


            //The goal here is to display any situation where I'm diverging from what the user has selected on the form.
            //For example, when you choose multiple Y-Axis checkboxes and a pie chart type I'll only use the last y-Axis selected in the list.
            //So I should display a message to that effect.

            //charttype=pie or 3dpie and multiple Y-Axis values are chosen.  I only use last Y-Axis.
            if (megaChart.getyMegafieldid().length==1 && megaChart.getyMegafieldid()[0]==0){
                mb.append("<tr><td bgcolor=#ffffff>");
                mb.append(reger.InfoBox.get(reger.InfoBox.BOXTYPEERROR, pathToAppRoot, "No Y-Axis is selected.  Please choose at least one below."));
                mb.append("</td></tr>");
            }

            //xMegafieldid=Date/Time and anything other than charttype=Line is selected.  I override with Line chart type.
            if (megaChart.getxMegafieldid()==FieldType.XAXISDATETIME && megaChart.getCharttype()!=reger.Vars.CHARTTYPELINE){
                mb.append("<tr><td bgcolor=#ffffff>");
                mb.append(reger.InfoBox.get(reger.InfoBox.BOXTYPEINFO, pathToAppRoot, "Quick note: When you choose Date/Time for the X-Axis you can only choose a Chart Type of Line.  We've automatically adjusted for you."));
                mb.append("</td></tr>");
            }

            //xMegafieldid=Day of the Week and anything other than charttype=bar, 3dbar, stacked bar, horizontal bar, horizontal3d bar
            if (megaChart.getxMegafieldid()==FieldType.XAXISDAYOFWEEK && !(megaChart.getCharttype()==reger.Vars.CHARTTYPE3DBAR || megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTALBAR || megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTAL3DBAR || megaChart.getCharttype()==reger.Vars.CHARTTYPEBAR  || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART  || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3D || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHARTHORIZONTAL || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3DHORIZONTAL)) {
                mb.append("<tr><td bgcolor=#ffffff>");
                mb.append(reger.InfoBox.get(reger.InfoBox.BOXTYPEINFO, pathToAppRoot, "Quick note: When you choose Day of the Week for the X-Axis you can only choose one of the Bar chart types.  We've automatically adjusted for you."));
                mb.append("</td></tr>");
            }

            //megaChart.getCharttype()=pie or 3dpie and multiple Y-Axis values are chosen.  I only use last Y-Axis.
            if ((megaChart.getCharttype()==reger.Vars.CHARTTYPE3DPIE || megaChart.getCharttype()==reger.Vars.CHARTTYPEPIE) && (megaChart.getyMegafieldid().length>1)){
                mb.append("<tr><td bgcolor=#ffffff>");
                mb.append(reger.InfoBox.get(reger.InfoBox.BOXTYPEINFO, pathToAppRoot, "Quick note: When you choose multiple Y-Axis series and a Chart Type of Pie or 3D Pie only the last Y-Axis selected will be charted."));
                mb.append("</td></tr>");
            }


            //A dropdown formatting string
            String dropdownstyle="style=\"font-family: Arial, Helvetica, sans-serif; font-size: 10px; color: #000000; background-color: #ffffff; border: #000000; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px\"";

            //Create the chart-customizing form
            mb.append("<tr><td bgcolor=#ffffff>");

                mb.append("<form action=graphs-detail.log method=post>");
                mb.append("<center><input type=submit value='Redraw Graph'></center>");

                if (isPreview) {
                    mb.append("<input type=hidden name=ispreview value='1'>");
                    mb.append("<input type=hidden name=megachartid value=\""+megaChart.getMegachartid()+"\">");
                } else {
                    mb.append("<input type=hidden name=ispreview value='0'>");
                }


                mb.append("<table cellpadding=8 width=100% cellspacing=1 border=0>");



                //Save row
                if (userSession.getAccountuser()!=null && userSession.getAccountuser().userCanDoAcl("SAVECHARTS", userSession.getAccount().getAccountid())) {
                    //Title row
    //                mb.append("<tr>");
    //                mb.append("<td valign=top bgcolor=#e6e6e6 colspan=3>");
    //                mb.append("<font face=arial size=-2>");
    //                mb.append("&nbsp;");
    //                mb.append("</font>");
    //                mb.append("</td>");
    //                mb.append("</tr>");

                    //Save chart?
                    mb.append("<tr>");
                    mb.append("<td valign=top bgcolor=#ffffff colspan=3>");
                    mb.append("<center>");
    //                if (userSession.getAccountuser().userCanDoAcl("MASTERDAMIN", userSession.getAccount().getAccountid())){
    //                    mb.append("<input type=checkbox name=savechartforall value=1>");
    //                    mb.append("<font face=arial size=-1>");
    //                    mb.append("Do for all users of log type.<br>");
    //                }
                    mb.append("<input type=checkbox name=savechart value=1>");
                    mb.append("<font face=arial size=-1>");
                    mb.append("Save this graph and name it:<br>");
                    mb.append("<input type=textbox name=chartname value=\""+reger.core.Util.cleanForHtml(megaChart.getChartname())+"\" size=25 maxlength=100>");
                    mb.append("</font>");
                    mb.append("</center>");
                    mb.append("</td>");
                    mb.append("</tr>");
                }



                //Title row
                mb.append("<tr>");
                mb.append("<td valign=top bgcolor=#e6e6e6>");
                mb.append("<font face=arial size=+1 color=#666666>");
                mb.append("X-Axis (Choose One)");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=top bgcolor=#e6e6e6>");
                mb.append("<font face=arial size=+1 color=#666666>");
                mb.append("Y-Axis (Choose Any)");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=top bgcolor=#e6e6e6>");
                mb.append("<font face=arial size=+1 color=#666666>");
                mb.append("Graph These Entries");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");

                //New row
                mb.append("<tr>");

                mb.append("<td valign=top>");

                reger.core.Util.debug(5, "MegaChartHtmlRenderer.java: xMegafieldid="+megaChart.getxMegafieldid());

                mb.append("<font face=arial size=-1 class=smallfont>");
                mb.append("<b>");
                mb.append("System Fields");
                mb.append("</b>");
                mb.append("</font>");
                mb.append("</br>");

                mb.append("<font face=arial size=-1>");
                //Derived xAxis types
                mb.append("<input name=xMegafieldChoice type=radio value='"+FieldType.XAXISDATETIME+"_0_0'");
                if (megaChart.getxMegafieldid()==FieldType.XAXISDATETIME){
                    mb.append(" checked");
                }
                mb.append("> Exact Date/Time<br>");
                mb.append("<input name=xMegafieldChoice type=radio value='"+FieldType.XAXISCALENDARDAYS+"_0_0'");
                if (megaChart.getxMegafieldid()==FieldType.XAXISCALENDARDAYS){
                    mb.append(" checked");
                }
                mb.append("> Days Ago<br>");
                mb.append("<input name=xMegafieldChoice type=radio value='"+FieldType.XAXISCALENDARWEEKS+"_0_0'");
                if (megaChart.getxMegafieldid()==FieldType.XAXISCALENDARWEEKS){
                    mb.append(" checked");
                }
                mb.append("> Weeks Ago<br>");
                mb.append("<input name=xMegafieldChoice type=radio value='"+FieldType.XAXISCALENDARMONTHS+"_0_0'");
                if (megaChart.getxMegafieldid()==FieldType.XAXISCALENDARMONTHS){
                    mb.append(" checked");
                }
                mb.append("> Months Ago<br>");
                mb.append("<input name=xMegafieldChoice type=radio value='"+FieldType.XAXISTIMEOFDAY+"_0_0'");
                if (megaChart.getxMegafieldid()==FieldType.XAXISTIMEOFDAY){
                    mb.append(" checked");
                }
                mb.append("> Hour of the Day<br>");
                mb.append("<input name=xMegafieldChoice type=radio value='"+FieldType.XAXISDAYOFWEEK+"_0_0'");
                if (megaChart.getxMegafieldid()==FieldType.XAXISDAYOFWEEK){
                    mb.append(" checked");
                }
                mb.append("> Day of the Week<br>");
                mb.append("<input name=xMegafieldChoice type=radio value='"+FieldType.XAXISDAYOFMONTH+"_0_0'");
                if (megaChart.getxMegafieldid()==FieldType.XAXISDAYOFMONTH){
                    mb.append(" checked");
                }
                mb.append("> Day of the Month<br>");
                mb.append("<input name=xMegafieldChoice type=radio value='"+FieldType.XAXISENTRYORDER+"_0_0'");
                if (megaChart.getxMegafieldid()==FieldType.XAXISENTRYORDER){
                    mb.append(" checked");
                }
                mb.append("> Entry Order<br>");


                //Output xAxis fields
                if (!isLOEPage){
                    //It's not an LOE page so I should show the user the logs for this account
                    Vector logsForAcct = AllLogsInSystem.allLogsForAccount(userSession.getAccount().getAccountid());
                    for (int j = 0; j < logsForAcct.size(); j++) {
                        Log log = (Log) logsForAcct.elementAt(j);

                        //If the user can view this log
                        if (userSession.getAccountuser().userCanViewLog(log.getLogid())){
                            //Log title and check box

                            mb.append("<font face=arial size=-1 class=smallfont>");
                            mb.append("<b>");
                            mb.append(log.getName());
                            mb.append("</b>");
                            mb.append("</font>");
                            mb.append("</br>");

                            //Now add on the activity-specific search options
                            FieldType[] megaFields = log.getFields();
                            boolean foundAtLeastOneField = false;
                            if (megaFields!=null && megaFields.length>0){
                                for (int k = 0; k < megaFields.length; k++) {
                                    foundAtLeastOneField = true;
                                    FieldType field = megaFields[k];
                                    String xMegaFieldChoiceString = field.getMegafieldid()+"_"+log.getLogid()+"_"+log.getEventtypeid();
                                    mb.append("<font face=arial size=-1 class=smallfont>");
                                    mb.append("<input name=xMegafieldChoice type=radio value='"+xMegaFieldChoiceString+"'");
                                    if (megaChart.getxMegafieldid()==field.getMegafieldid()){
                                        mb.append(" checked");
                                    }
                                    mb.append("> "+field.getFieldname()+"<br>");
                                    mb.append("</font>");
                                }
                            }
                            if (!foundAtLeastOneField) {
                                mb.append("<font face=arial size=-2 class=tinyfont>");
                                mb.append("No graphable fields in this log.<br>");
                                mb.append("</font>");
                            }
                        }

                    }
                } else {
                    //It's an LOE page and I should display eventtypes, not logs
                    MegaLogType[] logTypes = AllMegaLogTypesInSystem.allLogTypesInSystem();
                    for (int i = 0; i < logTypes.length; i++) {
                        MegaLogType logType = (MegaLogType) logTypes[i];

                        //Title and check box
                        mb.append("<font face=arial size=-1 class=smallfont>");
                        mb.append("<b>");
                        mb.append(logType.getMegalogname());
                        mb.append("</b>");
                        mb.append("</font>");
                        mb.append("</br>");

                        //Now add on the activity-specific search options
                        FieldType[] megaFields = logType.getMegaFields();
                        boolean foundAtLeastOneField = false;
                        if (megaFields!=null && megaFields.length>0){
                            for (int k = 0; k < megaFields.length; k++) {
                                foundAtLeastOneField = true;
                                FieldType field = megaFields[k];
                                String xMegaFieldChoiceString = field.getMegafieldid()+"_"+0+"_"+logType.getEventtypeid();
                                mb.append("<font face=arial size=-1 class=smallfont>");
                                mb.append("<input name=xMegafieldChoice type=radio value='"+xMegaFieldChoiceString+"'");
                                if (megaChart.getxMegafieldid()==field.getMegafieldid()){
                                    mb.append(" checked");
                                }
                                mb.append("> "+field.getFieldname()+"<br>");
                                mb.append("</font>");
                            }
                        }
                        if (!foundAtLeastOneField) {
                            mb.append("<font face=arial size=-2 class=tinyfont>");
                            mb.append("No graphable fields in this log.<br>");
                            mb.append("</font>");
                        }


                    }
                }
                mb.append("</font>");
                mb.append("</td>");

                mb.append("<td valign=top>");
                mb.append("<font face=arial size=-1>");
                mb.append("<input name=yMegafieldChoice type=checkbox value='"+FieldType.YAXISCOUNT+"_0_0'");
                for(int j=0; j<megaChart.getyMegafieldid().length; j++){
                    if (megaChart.getyMegafieldid()[j]==FieldType.YAXISCOUNT){
                        mb.append(" checked");
                    }
                }
                mb.append("> Number of Entries<br>");
                //Output y axis fields... only numerics
                if (!isLOEPage){
                    //It's not an LOE page so I should show the user the logs for this account
                    Vector logsForAcct = AllLogsInSystem.allLogsForAccount(userSession.getAccount().getAccountid());
                    for (int j = 0; j < logsForAcct.size(); j++) {
                        Log log = (Log) logsForAcct.elementAt(j);

                        //If the user can view this log
                        if (userSession.getAccountuser().userCanViewLog(log.getLogid())){
                            //Log title and check box

                            mb.append("<font face=arial size=-1 class=smallfont>");
                            mb.append("<b>");
                            mb.append(log.getName());
                            mb.append("</b>");
                            mb.append("</font>");
                            mb.append("</br>");

                            //Now add on the activity-specific search options
                            FieldType[] megaFields = log.getFields();
                            boolean foundAtLeastOneField = false;
                            if (megaFields!=null && megaFields.length>0){
                                for (int k = 0; k < megaFields.length; k++) {
                                    FieldType field = megaFields[k];
                                    if (field.getMegadatatypeid()!=reger.mega.DataTypeString.DATATYPEID){
                                        foundAtLeastOneField=true;
                                        String yMegaFieldChoiceString = field.getMegafieldid()+"_"+log.getLogid()+"_"+log.getEventtypeid();
                                        mb.append("<font face=arial size=-1 class=smallfont>");
                                        mb.append("<input name=yMegafieldChoice type=checkbox value='"+yMegaFieldChoiceString+"'");
                                        for(int l=0; l<megaChart.getyMegafieldid().length; l++){
                                            if (megaChart.getyMegafieldid()[l]==field.getMegafieldid()){
                                                mb.append(" checked");
                                            }
                                        }
                                        mb.append("> "+field.getFieldname());
                                        mb.append("</font><br>");
                                    }
                                }
                            }
                            if (!foundAtLeastOneField) {
                                mb.append("<font face=arial size=-2 class=tinyfont>");
                                mb.append("No graphable fields in this log.<br>");
                                mb.append("</font>");
                            }
                        }

                    }
                } else {
                    //It's an LOE page and I should display eventtypes, not logs
                    MegaLogType[] logTypes = AllMegaLogTypesInSystem.allLogTypesInSystem();
                    for (int i = 0; i < logTypes.length; i++) {
                        MegaLogType logType = (MegaLogType) logTypes[i];

                        //Title and check box
                        mb.append("<font face=arial size=-1 class=smallfont>");
                        mb.append("<b>");
                        mb.append(logType.getMegalogname());
                        mb.append("</b>");
                        mb.append("</font>");
                        mb.append("</br>");

                        //Now add on the activity-specific search options
                        FieldType[] megaFields = logType.getMegaFields();
                        boolean foundAtLeastOneField = false;
                        if (megaFields!=null && megaFields.length>0){
                            for (int k = 0; k < megaFields.length; k++) {
                                FieldType field = megaFields[k];
                                if (field.getMegadatatypeid()!=reger.mega.DataTypeString.DATATYPEID){
                                    foundAtLeastOneField=true;
                                    String yMegaFieldChoiceString = field.getMegafieldid()+"_"+0+"_"+logType.getEventtypeid();
                                    mb.append("<font face=arial size=-1 class=smallfont>");
                                    mb.append("<input name=yMegafieldChoice type=checkbox value='"+yMegaFieldChoiceString+"'");
                                    for(int l=0; l<megaChart.getyMegafieldid().length; l++){
                                        if (megaChart.getyMegafieldid()[l]==field.getMegafieldid()){
                                            mb.append(" checked");
                                        }
                                    }
                                    mb.append("> "+field.getFieldname());
                                    mb.append("</font><br>");
                                }
                            }
                        }
                        if (!foundAtLeastOneField) {
                            mb.append("<font face=arial size=-2 class=tinyfont>");
                            mb.append("No graphable fields in this log.<br>");
                            mb.append("</font>");
                        }


                    }
                }



                mb.append("</font>");
                mb.append("</td>");


                //Saved search/date range - which entries to graph?
                mb.append("<td valign=top nowrap>");
                mb.append("<font face=arial size=-1>");
                mb.append("<input name=daterange type=radio value="+reger.Vars.DATERANGEALLTIME);
                if (megaChart.getDaterange()==reger.Vars.DATERANGEALLTIME){
                    mb.append(" checked");
                }
                mb.append("> All Time");
                //
                mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGETHISWEEK);
                if (megaChart.getDaterange()==reger.Vars.DATERANGETHISWEEK){
                    mb.append(" checked");
                }
                mb.append("> This Week");
                //
                mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGETHISMONTH);
                if (megaChart.getDaterange()==reger.Vars.DATERANGETHISMONTH){
                    mb.append(" checked");
                }
                mb.append("> This Month");
                //
                mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGETHISYEAR);
                if (megaChart.getDaterange()==reger.Vars.DATERANGETHISYEAR){
                    mb.append(" checked");
                }
                mb.append("> This Year");
                //
                mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGELASTWEEK);
                if (megaChart.getDaterange()==reger.Vars.DATERANGELASTWEEK){
                    mb.append(" checked");
                }
                mb.append("> Last Week");
                //
                mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGELASTMONTH);
                if (megaChart.getDaterange()==reger.Vars.DATERANGELASTMONTH){
                    mb.append(" checked");
                }
                mb.append("> Last Month");
                //
                mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGELASTXDAYS);
                if (megaChart.getDaterange()==reger.Vars.DATERANGELASTXDAYS){
                    mb.append(" checked");
                }
                mb.append("> Last ");
                mb.append("<select name=lastxdays "+dropdownstyle+">");
                for(int i=0; i<60; i++){
                   mb.append("<option value="+i);
                   if (megaChart.getLastxdays()==i){
                       mb.append(" selected");
                   }
                   mb.append(">"+i+"</option>");
                }
                mb.append("</select>");
                mb.append(" Day(s)");
                //
                mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGELASTXWEEKS);
                if (megaChart.getDaterange()==reger.Vars.DATERANGELASTXWEEKS){
                    mb.append(" checked");
                }
                mb.append("> Last ");
                mb.append("<select name=lastxweeks "+dropdownstyle+">");
                for(int i=0; i<16; i++){
                   mb.append("<option value="+i);
                   if (megaChart.getLastxweeks()==i){
                       mb.append(" selected");
                   }
                   mb.append(">"+i+"</option>");
                }
                mb.append("</select>");
                mb.append(" Week(s)");
                //
                mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGELASTXMONTHS);
                if (megaChart.getDaterange()==reger.Vars.DATERANGELASTXMONTHS){
                    mb.append(" checked");
                }
                mb.append("> Last ");
                mb.append("<select name=lastxmonths "+dropdownstyle+">");
                for(int i=0; i<24; i++){
                   mb.append("<option value="+i);
                   if (megaChart.getLastxmonths()==i){
                       mb.append(" selected");
                   }
                   mb.append(">"+i+"</option>");
                }
                mb.append("</select>");
                mb.append(" Month(s)");
                //
                mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGELASTXYEARS);
                if (megaChart.getDaterange()==reger.Vars.DATERANGELASTXYEARS){
                    mb.append(" checked");
                }
                mb.append("> Last ");
                mb.append("<select name=lastxyears "+dropdownstyle+">");
                for(int i=0; i<100; i++){
                   mb.append("<option value="+i);
                   if (megaChart.getLastxyears()==i){
                       mb.append(" selected");
                   }
                   mb.append(">"+i+"</option>");
                }
                mb.append("</select>");
                mb.append(" Year(s)");
                //
                mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGESPECIFIED);
                if (megaChart.getDaterange()==reger.Vars.DATERANGESPECIFIED){
                    mb.append(" checked");
                }
                mb.append("> Date Range:");
                mb.append("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From:<br>");
                mb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                mb.append("<select name=daterangefromyyyy "+dropdownstyle+">");
                for(int i=1900; i<=2010; i++){
                   mb.append("<option value="+i);
                   if (megaChart.getDaterangefromyyyy()==i){
                       mb.append(" selected");
                   }
                   mb.append(">"+i+"</option>");
                }
                mb.append("</select>");
                mb.append(" / ");
                mb.append("<select name=daterangefrommm "+dropdownstyle+">");
                for(int i=1; i<=12; i++){
                   mb.append("<option value="+i);
                   if (megaChart.getDaterangefrommm()==i){
                       mb.append(" selected");
                   }
                   mb.append(">"+i+"</option>");
                }
                mb.append("</select>");
                mb.append(" / ");
                mb.append("<select name=daterangefromdd "+dropdownstyle+">");
                for(int i=0; i<=31; i++){
                   mb.append("<option value="+i);
                   if (megaChart.getDaterangefromdd()==i){
                       mb.append(" selected");
                   }
                   mb.append(">"+i+"</option>");
                }
                mb.append("</select>");
                mb.append("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To:<br>");
                mb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                mb.append("<select name=daterangetoyyyy "+dropdownstyle+">");
                for(int i=1900; i<=2010; i++){
                   mb.append("<option value="+i);
                   if (megaChart.getDaterangetoyyyy()==i){
                       mb.append(" selected");
                   }
                   mb.append(">"+i+"</option>");
                }
                mb.append("</select>");
                mb.append(" / ");
                mb.append("<select name=daterangetomm "+dropdownstyle+">");
                for(int i=1; i<=12; i++){
                   mb.append("<option value="+i);
                   if (megaChart.getDaterangetomm()==i){
                       mb.append(" selected");
                   }
                   mb.append(">"+i+"</option>");
                }
                mb.append("</select>");
                mb.append(" / ");
                mb.append("<select name=daterangetodd "+dropdownstyle+">");
                for(int i=1; i<=31; i++){
                   mb.append("<option value="+i);
                   if (megaChart.getDaterangetodd()==i){
                       mb.append(" selected");
                   }
                   mb.append(">"+i+"</option>");
                }
                mb.append("</select>");
                //
                mb.append("<br><input name=daterange type=radio value="+reger.Vars.DATERANGESAVEDSEARCH);
                if (megaChart.getDaterange()==reger.Vars.DATERANGESAVEDSEARCH){
                    mb.append(" checked");
                }
                mb.append("> Use Entries from a Saved Search:");
                mb.append("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                mb.append("<select name=daterangesavedsearchid "+dropdownstyle+">");
                //-----------------------------------
                //-----------------------------------
                String[][] rstSavedSearch= Db.RunSQL("SELECT savedsearch.savedsearchid, savedsearch.name FROM savedsearch, megalog, savedsearchlog WHERE savedsearch.savedsearchid=savedsearchlog.savedsearchid AND savedsearchlog.logid=megalog.logid AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+" GROUP BY savedsearchid ORDER BY savedsearch.name ASC");
                //-----------------------------------
                //-----------------------------------
                if (rstSavedSearch!=null && rstSavedSearch.length>0){
                    for(int i=0; i<rstSavedSearch.length; i++){
                        mb.append("<option value="+rstSavedSearch[i][0]);
                       if (megaChart.getDaterangesavedsearchid()==Integer.parseInt(rstSavedSearch[i][0])){
                           mb.append(" selected");
                       }
                       mb.append(">"+rstSavedSearch[i][1]+"</option>");
                    }
                } else {
                    mb.append("<option value=''>None.</option>");
                }
                mb.append("</select>");

                mb.append("</font>");
                mb.append("</td>");

                mb.append("</tr>");


                //Title row
                mb.append("<tr>");
                mb.append("<td valign=top bgcolor=#e6e6e6>");
                mb.append("<font face=arial size=+1 color=#666666>");
                mb.append("Chart Type");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=top bgcolor=#e6e6e6>");
                mb.append("<font face=arial size=+1 color=#666666>");
                mb.append("Size of Chart");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=top bgcolor=#e6e6e6>");
                mb.append("<font face=arial size=+1 color=#666666>");
                mb.append("Handle Multiple Y Values For Same X Value By");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");


                //New row
                mb.append("<tr>");


                mb.append("<td valign=top>");
                mb.append("<font face=arial size=-1>");
                mb.append("<input name=charttype type=radio value="+reger.Vars.CHARTTYPELINE);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPELINE){
                    mb.append(" checked");
                }
                mb.append("> Line");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPEBAR);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPEBAR){
                    mb.append(" checked");
                }
                mb.append("> Bar");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPE3DBAR);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPE3DBAR){
                    mb.append(" checked");
                }
                mb.append("> 3D Bar");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPESTACKEDBARCHART);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART){
                    mb.append(" checked");
                }
                mb.append("> Stacked Bar");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPESTACKEDBARCHART3D);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3D){
                    mb.append(" checked");
                }
                mb.append("> Stacked 3D Bar");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPEHORIZONTALBAR);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTALBAR){
                    mb.append(" checked");
                }
                mb.append("> Horizontal Bar");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPEHORIZONTAL3DBAR);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTAL3DBAR){
                    mb.append(" checked");
                }
                mb.append("> Horizontal 3D Bar");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPESTACKEDBARCHARTHORIZONTAL);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHARTHORIZONTAL){
                    mb.append(" checked");
                }
                mb.append("> Stacked Horiz Bar");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPESTACKEDBARCHART3DHORIZONTAL);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3DHORIZONTAL){
                    mb.append(" checked");
                }
                mb.append("> Stacked Horiz 3D Bar");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPEPIE);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPEPIE){
                    mb.append(" checked");
                }
                mb.append("> Pie Chart");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPE3DPIE);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPE3DPIE){
                    mb.append(" checked");
                }
                mb.append("> 3D Pie Chart");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPESCATTERPLOT);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPESCATTERPLOT){
                    mb.append(" checked");
                }
                mb.append("> Scatter Plot");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPESTEPCHART);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTEPCHART){
                    mb.append(" checked");
                }
                mb.append("> Step Chart");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPEAREACHART);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPEAREACHART){
                    mb.append(" checked");
                }
                mb.append("> Area Chart");
                mb.append("<br><input name=charttype type=radio value="+reger.Vars.CHARTTYPESTACKEDAREA);
                if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDAREA){
                    mb.append(" checked");
                }
                mb.append("> Stacked Area Chart");
                mb.append("</font>");
                mb.append("</td>");


                mb.append("<td valign=top>");
                mb.append("<font face=arial size=-1>");
                mb.append("<input name=chartsize type=radio value="+reger.Vars.CHARTSIZEMINISCULE);
                if (megaChart.getChartsize()==reger.Vars.CHARTSIZEMINISCULE){
                    mb.append(" checked");
                }
                mb.append("> Miniscule");
                mb.append("<br><input name=chartsize type=radio value="+reger.Vars.CHARTSIZESMALL);
                if (megaChart.getChartsize()==reger.Vars.CHARTSIZESMALL){
                    mb.append(" checked");
                }
                mb.append("> Small");
                mb.append("<br><input name=chartsize type=radio value="+reger.Vars.CHARTSIZEMEDIUM);
                if (megaChart.getChartsize()==reger.Vars.CHARTSIZEMEDIUM){
                    mb.append(" checked");
                }
                mb.append("> Medium");
                mb.append("<br><input name=chartsize type=radio value="+reger.Vars.CHARTSIZELARGE);
                if (megaChart.getChartsize()==reger.Vars.CHARTSIZELARGE){
                    mb.append(" checked");
                }
                mb.append("> Large");
                mb.append("<br><input name=chartsize type=radio value="+reger.Vars.CHARTSIZEMASSIVE);
                if (megaChart.getChartsize()==reger.Vars.CHARTSIZEMASSIVE){
                    mb.append(" checked");
                }
                mb.append("> Massive");
                mb.append("</font>");
                mb.append("</td>");

                mb.append("<td valign=top>");
                mb.append("<font face=arial size=-1>");
                mb.append("<input name=yaxiswhattodo type=radio value="+reger.Vars.YAXISWHATTODOAVG);
                if (megaChart.getYaxiswhattodo()==reger.Vars.YAXISWHATTODOAVG){
                    mb.append(" checked");
                }
                mb.append("> Averaging Them");
                mb.append("<br><input name=yaxiswhattodo type=radio value="+reger.Vars.YAXISWHATTODOSUM);
                if (megaChart.getYaxiswhattodo()==reger.Vars.YAXISWHATTODOSUM){
                    mb.append(" checked");
                }
                mb.append("> Adding Them Together");
                //@todo Consider allowing the user to return percentages of total.
                mb.append("</font>");
                mb.append("</td>");


                mb.append("</tr>");






                mb.append("</table>");

                mb.append("</form>");

            mb.append("</td></tr>");





            //Raw Data Output
            //int megaChart.getxMegafieldid()=-1;
            //if (request.getParameter("megaChart.getxMegafieldid()")!=null && reger.core.Util.isinteger(request.getParameter("megaChart.getxMegafieldid()"))){
            //    megaChart.getxMegafieldid()=Integer.parseInt(request.getParameter("megaChart.getxMegafieldid()"));
            //}
            //int[] megaChart.getyMegafieldid() = new int[1];
            //if (request.getParameter("megaChart.getyMegafieldid()")!=null && reger.core.Util.isinteger(request.getParameter("megaChart.getyMegafieldid()"))){
            //    megaChart.getyMegafieldid()[0]=Integer.parseInt(request.getParameter("megaChart.getyMegafieldid()"));
            //}
            //int yaxiswhattodo=-1;
            //if (request.getParameter("yaxiswhattodo")!=null && reger.core.Util.isinteger(request.getParameter("yaxiswhattodo"))){
            //    yaxiswhattodo=Integer.parseInt(request.getParameter("yaxiswhattodo"));
            //}
            //int megaChart.getChartsize()=-1;
            //if (request.getParameter("megaChart.getChartsize()")!=null && reger.core.Util.isinteger(request.getParameter("megaChart.getChartsize()"))){
            //    megaChart.getChartsize()=Integer.parseInt(request.getParameter("megaChart.getChartsize()"));
            //}
            //Create a reger chart object
//            if (1==2){
//                //Now output with the new
//                mb.append("<tr><td bgcolor=#ffffff align=left valign=top>");
//                mb.append("<font face=arial size=+3>New MegaChartNew</font>");
//                mb.append("</td></tr>");
//                reger.executionTime executionTimeNew = new reger.executionTime();
//                //Go get the entries that relate to this graph
//                reger.mega.MegaChartEntryChooser entryChooser = new reger.mega.MegaChartEntryChooser(userSession, xLogid, yLogid, daterange, daterangesavedsearchid, lastxdays, lastxweeks, lastxmonths, lastxyears, daterangetoyyyy, daterangetomm, daterangetodd, daterangefromyyyy, daterangefrommm, daterangefromdd);
//                entryChooser.populate();
//                for(int j=0; j<megaChart.getyMegafieldid().length; j++){
//                    //Create the chart object
//                    reger.mega.MegaChartSeries megaChartSeries=new reger.mega.MegaChartSeries(userSession, megaChart.getxMegafieldid(), megaChart.getxLogid(), megaChart.getyMegafieldid()[j], megaChart.getyLogid()[j], megaChart.getYaxiswhattodo(), megaChart.getChartsize(), megaChart.getDaterange(), megaChart.getLastxdays(), megaChart.getLastxweeks(), megaChart.getLastxmonths(), megaChart.getLastxyears(), megaChart.getDaterangefromyyyy(), megaChart.getDaterangefrommm(), megaChart.getDaterangefromdd(), megaChart.getDaterangetoyyyy(), megaChart.getDaterangetomm(), megaChart.getDaterangetodd(), megaChart.getDaterangesavedsearchid());
//                    //Output the data to the screen
//                    mb.append("<tr><td bgcolor=#ffffff align=left valign=top>");
//                    //@todo Figure out how to display the chart series name here.  Probably create another array along with rawChartData that holds the names and is indexed by the same number.
//                    mb.append("<font face=arial size=+1>Chart Data ("+j+")</font><br>");
//                    mb.append("<table cellpadding=2 cellspacing=1 border=0>");
//                    if (megaChartSeries.cleanData!=null && megaChartSeries.cleanData.length>0){
//                        for(int i=0; i<megaChartSeries.cleanData.length; i++){
//                            //@todo On date types convert back to date for display to user.
//                            mb.append("<tr><td valign=top align=left bgcolor=#e6e6e6>" + megaChartSeries.cleanData[i][1] + "</td><td valign=top align=left colspan=2>" + megaChartSeries.cleanData[i][2] + "</td></tr>");
//                        }
//                    }
//                    mb.append("</table>");
//
//                    //Show raw data for debugging purposes. Set showrawdata to true to show.  False to hide. Doi.
//                    boolean showrawdata=false;
//                    if (showrawdata) {
//                        mb.append("<font face=arial size=+1><br><br>Chart Raw Data ("+j+")</font><br>");
//                        mb.append("<table cellpadding=2 cellspacing=1 border=0>");
//                        if (megaChartSeries.rawChartData!=null && megaChartSeries.rawChartData.length>0){
//                            for(int i=0; i<megaChartSeries.rawChartData.length; i++){
//                                mb.append("<tr><td valign=top align=left bgcolor=#e6e6e6>" + megaChartSeries.rawChartData[i][1] + "</td><td valign=top align=left>" + megaChartSeries.rawChartData[i][2] + "</td><td valign=top align=left> Eventid:" + megaChartSeries.rawChartData[i][0] + "</td></tr>");
//                            }
//                        }
//                        mb.append("</table>");
//                    }
//
//                }
//                mb.append("<tr><td bgcolor=#ffffff align=left valign=top>");
//                mb.append("<font face=arial size=+2>"+executionTimeNew.getElapsed()+"</font>");
//                mb.append("</td></tr>");
//
//
//            }



            mb.append("</td></tr>");
            //Debug End

            mb.append("</table>");
            mb.append("</td></tr></table>");

        }

        return mb.toString();
    }


}
