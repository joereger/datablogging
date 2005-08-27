package reger.search;

import reger.core.db.Db;
import reger.mega.FieldType;

import java.util.Calendar;

/**
 * User interface wizard for advanced searches and other things that leverage this infrastructure.
 */
public class SearchUI {

    private reger.search.SearchEntries se = new reger.search.SearchEntries();

    //Page sections
    String title = "&nbsp;";
    StringBuffer searchSummary = new StringBuffer();
    StringBuffer steps = new StringBuffer();
    StringBuffer body = new StringBuffer();
    StringBuffer nav = new StringBuffer();
    StringBuffer formTop = new StringBuffer();
    StringBuffer header = new StringBuffer();
    String thisPageName = "";

    public SearchUI(javax.servlet.http.HttpServletRequest request, reger.UserSession userSession, SearchUIFlow flow){

        //Get the current page name
        thisPageName = reger.core.Util.getJspName(request.getRequestURI());

        //Set the core of the searcher
        se.setCoreOfSearcher(userSession);

        //Deserialize the searchParameters stored in the hidden serialized form field
        se.populateSearchParametersFromSerializedFormField(request);

        //Also take any incoming searchname
        if (request.getParameter("searchname")!=null && !request.getParameter("searchname").equals("")){
            se.getSearchParameters().name = request.getParameter("searchname");
        }

        //Create the two objects that do the work
        SearchUIChunk chunkToProcess=null;
        SearchUIChunk chunkToDisplay=null;

        //A simple request parameter called "thischunkuniqueidentifier" tells me which chunk is being submitted
        if (request.getParameter("thischunkuniqueidentifier")!=null && !request.getParameter("thischunkuniqueidentifier").equals("")){
            String thischunkuniqueidentifier = request.getParameter("thischunkuniqueidentifier");
            //Find the chunk to process the request
            chunkToProcess = SearchUIChunkFactory.getHandlerByUniqueIdentifier(thischunkuniqueidentifier);
            if (chunkToProcess!=null){
                chunkToProcess.processRequest(se, request, userSession);
            }
            //Find the chunk to display
            if (chunkToProcess!=null){
                chunkToDisplay = flow.getNext(chunkToProcess.getUniqueIdentifier());
            }
        }

        //Override that with an explicit call to load a search
        if (request.getParameter("savedsearchid")!=null && reger.core.Util.isinteger(request.getParameter("savedsearchid"))){
            se.populateSearchParametersFromDB(request);
            //Also set the flow to the last one
            chunkToDisplay = flow.getFlow()[flow.getFlow().length-1];
        }

        //And the next chunk can be manually set
        if (request.getParameter("nextchunktodisplay")!=null && !request.getParameter("nextchunktodisplay").equals("")){
            String nextchunktodisplay = request.getParameter("nextchunktodisplay");
            chunkToDisplay = flow.get(nextchunktodisplay);
        }

        //For safety in case any of the other methods didn't find a chunk to display
        if (chunkToDisplay==null){
            chunkToDisplay = flow.getFlow()[0];
        }

        //Set the body
        for (int i = 0; i < flow.getFlow().length; i++) {
            if (chunkToDisplay.getUniqueIdentifier().equals(flow.getFlow()[i].getUniqueIdentifier())){
                body.append("<font face=arial size=-1 class=mediumfont color=#cccccc>");
                body.append("Step "+(i+1)+" of "+(flow.getFlow().length));
                body.append("</font>");
                body.append("<br>");
            }
        }
        body.append("<font face=arial size=+1 class=largefont color=#cccccc>");
        body.append(chunkToDisplay.getPageTitle());
        body.append("</font>");
        body.append("<br>");
        //First set of next/back
        if (!flow.isFirst(chunkToDisplay.getUniqueIdentifier())){
            body.append("<input type=submit value='<< Back' onclick=\"this.form.elements['nextchunktodisplay'].value = '"+flow.getPrevious(chunkToDisplay.getUniqueIdentifier()).getUniqueIdentifier()+"';\" style=\"font-size: 14px;\">");
        }
        if (!flow.isLast(chunkToDisplay.getUniqueIdentifier())){
            //body.append("<br>");
            body.append("<input type=submit value='Skip to the End' valign=bottom onclick=\"this.form.elements['nextchunktodisplay'].value = '"+flow.getFlow()[flow.getFlow().length-1].getUniqueIdentifier()+"';\" style=\"font-size: 14px;\">");
        }
        if (!flow.isLast(chunkToDisplay.getUniqueIdentifier())){
            body.append("<input type=submit value='Next >>'  onclick=\"this.form.elements['nextchunktodisplay'].value = '"+flow.getNext(chunkToDisplay.getUniqueIdentifier()).getUniqueIdentifier()+"';\" style=\"font-size: 14px;\">");
        }
        //Main Body start
        body.append("<br><br>");
        body.append("<input type=hidden name=\"thischunkuniqueidentifier\" value=\""+reger.core.Util.cleanForHtml(chunkToDisplay.getUniqueIdentifier())+"\">");
        body.append(chunkToDisplay.getHtml(se, userSession));
        body.append("<br><br>");
        //Main body end
        //Second set of next/back
        if (!flow.isFirst(chunkToDisplay.getUniqueIdentifier())){
            body.append("<input type=submit value='<< Back' onclick=\"this.form.elements['nextchunktodisplay'].value = '"+flow.getPrevious(chunkToDisplay.getUniqueIdentifier()).getUniqueIdentifier()+"';\" style=\"font-size: 14px;\">");
        }
        if (!flow.isLast(chunkToDisplay.getUniqueIdentifier())){
            //body.append("<br>");
            body.append("<input type=submit value='Skip to the End'  onclick=\"this.form.elements['nextchunktodisplay'].value = '"+flow.getFlow()[flow.getFlow().length-1].getUniqueIdentifier()+"';\" style=\"font-size: 14px;\">");
        }
        if (!flow.isLast(chunkToDisplay.getUniqueIdentifier())){
            body.append("<input type=submit value='Next >>'  onclick=\"this.form.elements['nextchunktodisplay'].value = '"+flow.getNext(chunkToDisplay.getUniqueIdentifier()).getUniqueIdentifier()+"';\" style=\"font-size: 14px;\">");
        }
        body.append("<br><br><br>");





        //Save search box
        searchSummary.append("<font face=arial size=+1 class=largefont color=#cccccc>");
        searchSummary.append("Summary");
        searchSummary.append("</font>");
        if (userSession.getAccountuser()!=null && userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && userSession.getAccountuser().userCanDoAcl("SAVESEARCHES", userSession.getAccount().getAccountid())){
            //Must have at least one log defined to save a search.
            if (se.getSearchParameters().logsToSearch!=null && se.getSearchParameters().logsToSearch.length>0){
                searchSummary.append("<br>");
                searchSummary.append("<br>");
                searchSummary.append("<font face=arial size=-2 class=tinyfont color=#cccccc>");
                searchSummary.append("Name this Search:");
                searchSummary.append("<br>");
                searchSummary.append("<input type=text name='searchname' size=20 maxlength=255 value=\""+reger.core.Util.cleanForHtml(se.getSearchParameters().name)+"\" style=\"font-size: 10px;\">");
                searchSummary.append("<br>");
                searchSummary.append("<input type=submit value='Save Search' onclick=\"this.form.elements['action'].value = 'savesearch';\" style=\"font-size: 10px;\">");
                searchSummary.append("</font>");
            }
        }
        searchSummary.append("<br><br>");

        //Add the search summary
        searchSummary.append(se.getSearchSummaryHtml());


        //Saved Searches Start
        if (userSession.getAccountuser()!=null && userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && userSession.getAccountuser().userCanDoAcl("SAVESEARCHES", userSession.getAccount().getAccountid())){
            if (request.getParameter("action")!=null){
                if (request.getParameter("action").equals("savesearch")){
                    if (!se.getSearchParameters().name.equals("")){
                        reger.core.Util.debug(5, "SearchUI.java - Trying to save searchname=" + se.getSearchParameters().name);
                        se.getSearchParameters().saveToDB(userSession.getAccount().getAccountid());
                    }
                }
            }
        }
        //Saved Search End

        //Nav header
        header.append("<table cellpadding=5 cellspacing=2 border=0>");
        header.append("<tr>");
        for (int i = 0; i < flow.getFlow().length; i++) {
            if (chunkToDisplay.getUniqueIdentifier().equals(flow.getFlow()[i].getUniqueIdentifier())){
                //Highlight current step
                header.append("<td valign=top bgcolor=#cccccc nowrap align=center>");
                header.append("<input type=submit value='"+flow.getFlow()[i].getName()+"'  onclick=\"this.form.elements['nextchunktodisplay'].value = '"+flow.getFlow()[i].getUniqueIdentifier()+"';\" style=\"font-size: 10px;\">");
                header.append("<br>");
                header.append("<font face=arial size=-2 class=tinyfont>");
                header.append("Step "+(i+1)+" of "+(flow.getFlow().length));
                header.append("</font>");
                header.append("</td>");
            } else {
                //Show normal step
                header.append("<td valign=top bgcolor=#e6e6e6 nowrap align=center>");
                header.append("<input type=submit value='"+flow.getFlow()[i].getName()+"'  onclick=\"this.form.elements['nextchunktodisplay'].value = '"+flow.getFlow()[i].getUniqueIdentifier()+"';\" style=\"font-size: 10px;\">");
                header.append("<br>");
                header.append("<font face=arial size=-2 class=tinyfont>");
                header.append("Step "+(i+1)+" of "+(flow.getFlow().length));
                header.append("</font>");
                header.append("</td>");
            }

        }
        header.append("</tr>");
        header.append("</table>");

    }


    public StringBuffer wrapperHtml(){
        StringBuffer mb = new StringBuffer();

        mb.append("<form action="+thisPageName+" method=post id=searchuiform>");
        mb.append("<input type=hidden name=action value=''>");
        mb.append("<input type=hidden name=nextchunktodisplay value=''>");
        mb.append(se.getSearchParametersAsSerializedFormTag());

        //The body of the page
        mb.append(reger.ui.TwoColWithHeaderFooter.html(title, header.toString(), body.toString(), searchSummary.toString(), 95));

        mb.append("</form>");

        return mb;
    }



    public SearchEntries getSearchEntries() {
        return se;
    }



}
