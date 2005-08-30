package reger.search;

import reger.Log;
import reger.MegaLogType;
import reger.cache.LogCache;
import reger.mega.FieldType;

import java.util.Vector;

/**
 * Keyword portion of searches
 */
public class SearchUIChunkMegadata implements SearchUIChunk{

    public String getName(){
        return "Data";
    }

    public String getUniqueIdentifier() {
        return "chunk-megadata";
    }

    public String getPageTitle(){
        return "Advanced Activity-Specific Data Search:";
    }

    public StringBuffer getHtml(SearchEntries se, reger.UserSession userSession){
        StringBuffer mb = new StringBuffer();

        //Working with all log types
        if (se.getSearchParameters().isAccountBeingSearched(SearchParameters.ALL)){

            mb.append("<table cellpadding=5 cellspacing=1 border=0>");

            Vector eventTypeidsForPlid = reger.AllMegaLogTypesInSystem.allMegaLogTypesForPlid(userSession.getPl().getPlid());

            for (int j = 0; j < eventTypeidsForPlid.size(); j++) {
                MegaLogType logType = (MegaLogType) eventTypeidsForPlid.elementAt(j);
                //If this is being searched
                if(se.getSearchParameters().isEventtypeidBeingSearched(logType.getEventtypeid()) || se.getSearchParameters().isEventtypeidBeingSearched(SearchParameters.ALL)){

                    //Log type title and check box
                    mb.append("<tr>");
                    mb.append("<td colspan=2 bgcolor=#cccccc>");
                    mb.append("<font face=arial size=-1 class=smallfont>");
                    mb.append(logType.getMegalogname());
                    mb.append("</font>");
                    mb.append("</td>");
                    mb.append("</tr>");

                    //Now add on the activity-specific search options
                    FieldType[] megaFields = logType.getMegaFields();
                    if (megaFields!=null && megaFields.length>0){

                        for (int k = 0; k < megaFields.length; k++) {
                            FieldType field = megaFields[k];
                            field.loadDefaultData(-1);

                            mb.append("<tr>");

                            mb.append("<td valign=top bgcolor=#e6e6e6>");
                            mb.append("<font face=arial size=-1 class=tinyfont>");
                            mb.append(field.getFieldname());
                            mb.append("</font>");
                            mb.append("</td>");

                            mb.append("<td valign=top>");
                            //mb.append(field.queryDisplayHtml(field.listOfQueryElementsAccepted()));
                            mb.append(field.queryDisplayHtml(se.getSearchParameters().fieldQueryElements, logType.getEventtypeid()));
                            mb.append("&nbsp;");
                            mb.append("</td>");

                            mb.append("</tr>");
                        }
                    } else {
                        mb.append("<tr>");

                        mb.append("<td valign=top bgcolor=#e6e6e6>");
                        mb.append("<font face=arial size=-1 class=tinyfont>");
                        mb.append("&nbsp;");
                        mb.append("</font>");
                        mb.append("</td>");

                        mb.append("<td valign=top bgcolor=#ffffff>");
                        mb.append("<font face=arial size=-1 class=tinyfont>");
                        mb.append("This log does not have any activity-specific data fields that can be searched.");
                        mb.append("</font>");
                        mb.append("</td>");



                        mb.append("</tr>");
                    }

                }
            }

            mb.append("</table>");


        //Working with specific logs
        } else {


            if (se.getSearchParameters().accountidsToSearch!=null){
                mb.append("<table cellpadding=5 cellspacing=1 border=0>");
                for (int i = 0; i < se.getSearchParameters().accountidsToSearch.length; i++) {
                    Vector logsForAcct = LogCache.allLogsForAccount(se.getSearchParameters().accountidsToSearch[i]);
                    reger.Account acct = new reger.Account(se.getSearchParameters().accountidsToSearch[i]);
                    mb.append("<tr>");
                    mb.append("<td colspan=2 bgcolor=#999999>");
                    mb.append("<font face=arial size=-1 class=mediumfont>");
                    mb.append(acct.getHomepagetitle());
                    mb.append("</font>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    for (int j = 0; j < logsForAcct.size(); j++) {
                        Log log = (Log) logsForAcct.elementAt(j);
                        //If this is being searched
                        if(se.getSearchParameters().isLogidBeingSearched(log.getLogid()) || se.getSearchParameters().isLogidBeingSearched(SearchParameters.ALL)){
                            //If the user can view this log
                            if (userSession.getAccountuser().userCanViewLog(log.getLogid())){
                                //Log title and check box
                                mb.append("<tr>");
                                mb.append("<td colspan=2 bgcolor=#cccccc>");
                                mb.append("<font face=arial size=-1 class=smallfont>");
                                mb.append(log.getName());
                                mb.append("</font>");
                                mb.append("</td>");
                                mb.append("</tr>");

                                //Now add on the activity-specific search options
                                FieldType[] megaFields = log.getFields();
                                if (megaFields!=null && megaFields.length>0){

                                    for (int k = 0; k < megaFields.length; k++) {
                                        FieldType field = megaFields[k];
                                        field.loadDefaultData(log.getLogid());

                                        mb.append("<tr>");

                                        mb.append("<td valign=top bgcolor=#e6e6e6>");
                                        mb.append("<font face=arial size=-1 class=tinyfont>");
                                        mb.append(field.getFieldname());
                                        mb.append("</font>");
                                        mb.append("</td>");

                                        mb.append("<td valign=top>");
                                        //mb.append(field.queryDisplayHtml(field.listOfQueryElementsAccepted()));
                                        mb.append(field.queryDisplayHtml(se.getSearchParameters().fieldQueryElements, log.getLogid()));
                                        mb.append("&nbsp;");
                                        mb.append("</td>");

                                        mb.append("</tr>");
                                    }
                                } else {
                                    mb.append("<tr>");

                                    mb.append("<td valign=top bgcolor=#e6e6e6>");
                                    mb.append("<font face=arial size=-1 class=tinyfont>");
                                    mb.append("&nbsp;");
                                    mb.append("</font>");
                                    mb.append("</td>");

                                    mb.append("<td valign=top bgcolor=#ffffff>");
                                    mb.append("<font face=arial size=-1 class=tinyfont>");
                                    mb.append("This log does not have any activity-specific data fields that can be searched.");
                                    mb.append("</font>");
                                    mb.append("</td>");



                                    mb.append("</tr>");
                                }
                            }
                        }
                    }

                }
            mb.append("</table>");
            } else {
                mb.append("<font face=arial size=-1 class=tinyfont>");
                mb.append("No sites are being searched so no activity-specific data fields are available.");
                mb.append("</font>");
            }




        }

        return mb;
    }

    public SearchEntries processRequest(SearchEntries se, javax.servlet.http.HttpServletRequest request, reger.UserSession userSession){
        //Override the fieldqueryelements with any from the actual request.
        //Note that this first wipes current values and then adds ones from the request.
        se.setFieldQueryElements(reger.mega.FieldQueryElement.getElementsFromRequest(request));
        return se;
    }


}
