package reger.search;

import reger.mega.FieldQueryElement;
import reger.core.db.Db;
import reger.core.db.Db;
import reger.AddToArray;

import java.io.Serializable;
import java.util.Calendar;

/**
 * This class holds the user-defined search parameters.
 */
public class SearchParameters implements Serializable{

    public static final int ALL = -1;
    public static final int NONE = 0;

    public int savedSearchId=-1;
    public String name="";
    public String searchTerms="";
    public int[] logsToSearch=null;
    public int numberOfResultsToReturn=25;
    public int[] accountidsToSearch = null;
    public int[] locationidsToSearch = null;
    public int[] eventtypeidsToSearch = null;
    public boolean linkResultsToAdmin = false;
    public FieldQueryElement[] fieldQueryElements;
    public int daterange = reger.Vars.DATERANGEALLTIME;
    public int lastx;
    public int lastxunits;
    public Calendar dateFromGmt;
    public Calendar dateToGmt;
    public int accountid;

    final static long serialVersionUID = 1L;

    public SearchParameters(){

    }

    public SearchParameters(int savedSearchId){
        loadSearchFromDB(savedSearchId);
    }

    public String getLogsToSearchAsSqlStatement(){
        StringBuffer whereClause = new StringBuffer();
        if (logsToSearch!=null  && logsToSearch.length>0){
            //If searching ALL set SQL to nothing
            for (int i = 0; i < logsToSearch.length; i++) {
                if (logsToSearch[i]==SearchParameters.ALL){
                    return "";
                }
            }
            //Otherwise, add individuals
            whereClause.append("AND megalog.logid IN(");
            for (int i = 0; i < logsToSearch.length; i++) {
                whereClause.append(logsToSearch[i]);
                if (i<logsToSearch.length-1){
                    whereClause.append(",");
                }
            }
            whereClause.append(") ");
        } //else {
            //whereClause.append(" AND megalog.logid<-1");
        //}
        return whereClause.toString();
    }

    public String getAccountsToSearchAsSqlStatement(){
        StringBuffer whereClause = new StringBuffer();
        if (accountidsToSearch!=null  && accountidsToSearch.length>1){
            //If searching ALL set SQL to nothing
            for (int i = 0; i < accountidsToSearch.length; i++) {
                if (accountidsToSearch[i]==SearchParameters.ALL){
                    return "";
                }
            }
            //Otherwise, add individuals
            whereClause.append("AND account.accountid IN(");
            for (int i = 0; i < accountidsToSearch.length; i++) {
                whereClause.append(accountidsToSearch[i]);
                if (i<accountidsToSearch.length-1){
                    whereClause.append(",");
                }
            }
            whereClause.append(") ");
        } //else if (accountidsToSearch!=null  && accountidsToSearch.length==1){
        //    whereClause.append(" AND account.accountid='" + accountidsToSearch[0] + "'");
        //}
        return whereClause.toString();
    }

    public String getLocationssToSearchAsSqlStatement(){
        StringBuffer whereClause = new StringBuffer();
        if (locationidsToSearch!=null  && locationidsToSearch.length>0){
            //If searching ALL set SQL to nothing
            for (int i = 0; i < locationidsToSearch.length; i++) {
                if (locationidsToSearch[i]==SearchParameters.ALL){
                    return "";
                }
            }
            //Otherwise, add individuals
            whereClause.append("AND location.locationid IN(");
            for (int i = 0; i < locationidsToSearch.length; i++) {
                whereClause.append(locationidsToSearch[i]);
                if (i<locationidsToSearch.length-1){
                    whereClause.append(",");
                }
            }
            whereClause.append(") ");
        }
        return whereClause.toString();
    }

    public String getEventtypesToSearchAsSqlStatement(){
        StringBuffer whereClause = new StringBuffer();
        if (eventtypeidsToSearch!=null  && eventtypeidsToSearch.length>0){
            //If searching ALL set SQL to nothing
            for (int i = 0; i < eventtypeidsToSearch.length; i++) {
                if (eventtypeidsToSearch[i]==SearchParameters.ALL){
                    return "";
                }
            }
            //Otherwise, add individuals
            whereClause.append("AND megalog.eventtypeid IN(");
            for (int i = 0; i < eventtypeidsToSearch.length; i++) {
                whereClause.append(eventtypeidsToSearch[i]);
                if (i<eventtypeidsToSearch.length-1){
                    whereClause.append(",");
                }
            }
            whereClause.append(") ");
        } //else {
            //whereClause.append(" AND megalog.eventtypeid<-1");
        //}
        return whereClause.toString();
    }

    public boolean isLogidBeingSearched(int logid){
        if (logsToSearch!=null){
            for (int i = 0; i < logsToSearch.length; i++) {
                if (logsToSearch[i]==logid){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isLocationidBeingSearched(int locationid){
        if (locationidsToSearch!=null){
            for (int i = 0; i < locationidsToSearch.length; i++) {
                if (locationidsToSearch[i]==locationid){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAccountBeingSearched(int accountid){
        if (accountidsToSearch!=null){
            for (int i = 0; i < accountidsToSearch.length; i++) {
                if (accountidsToSearch[i]==accountid){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEventtypeidBeingSearched(int eventtypeid){
        if (eventtypeidsToSearch!=null){
            for (int i = 0; i < eventtypeidsToSearch.length; i++) {
                if (eventtypeidsToSearch[i]==eventtypeid){
                    return true;
                }
            }
        }
        return false;
    }


    public void saveToDB(int accountidToSaveTo){
        //If name is blank, assign one
        if (name.equals("")){
            name = "Saved Search";
        }

        //Create dates as Strings
        String dateFromGmtString = "";
        String dateToGmtString = "";
        try{
            dateFromGmtString = reger.core.TimeUtils.dateformatfordb(dateFromGmt);
        } catch (Exception e){
            reger.core.Util.debug(5, e);
        }
        try{
            dateToGmtString = reger.core.TimeUtils.dateformatfordb(dateToGmt);
        } catch (Exception e){
            reger.core.Util.debug(5, e);
        }

        //The accountidToSaveTo is a tag for the saved search but does not affect which accounts are searched.

        //Save the core
        if (savedSearchId>0){
            //Edit a saved search
            reger.core.Util.debug(5, "SearchParameters.java - Editing saved savedSearchId=" + savedSearchId);
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE savedsearch SET searchterms='"+reger.core.Util.cleanForSQL(searchTerms)+"', accountid='"+accountidToSaveTo+"', name='"+reger.core.Util.cleanForSQL(name)+"', lastx='"+lastx+"', lastxunits='"+lastxunits+"', daterange='"+daterange+"', datefromgmt='"+dateFromGmtString+"', datetogmt='"+dateToGmtString+"' WHERE savedsearchid='"+savedSearchId+"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //Create a new one
            reger.core.Util.debug(5, "SearchParameters.java - Creating new savedSearchId.");
            //-----------------------------------
            //-----------------------------------
            savedSearchId = Db.RunSQLInsert("INSERT INTO savedsearch(searchterms, accountid, name, lastx, lastxunits, daterange, datefromgmt, datetogmt) VALUES('"+reger.core.Util.cleanForSQL(searchTerms)+"', '"+accountidToSaveTo+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+lastx+"', '"+lastxunits+"', '"+daterange+"', '"+dateFromGmtString+"', '"+dateToGmtString+"')");
            //-----------------------------------
            //-----------------------------------
            reger.core.Util.debug(5, "SearchParameters.java - Done creating new savedSearchId=" + savedSearchId);
        }

        //Delete all log relationships
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM savedsearchlog WHERE savedsearchid='"+savedSearchId+"'");
        //-----------------------------------
        //-----------------------------------
        //And add them back
        if (logsToSearch!=null){
            //If All is checked
            if (isLogidBeingSearched(SearchParameters.ALL)){
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO savedsearchlog(savedsearchid, logid) VALUES('"+savedSearchId+"', '"+SearchParameters.ALL+"')");
                //-----------------------------------
                //-----------------------------------
            } else {
                for (int i = 0; i < logsToSearch.length; i++) {
                    //-----------------------------------
                    //-----------------------------------
                    int identity = Db.RunSQLInsert("INSERT INTO savedsearchlog(savedsearchid, logid) VALUES('"+savedSearchId+"', '"+logsToSearch[i]+"')");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }

        //Delete all location relationships
        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("DELETE FROM savedsearchlocation WHERE savedsearchid='"+savedSearchId+"'");
        //-----------------------------------
        //-----------------------------------
        //And add them back
        if (locationidsToSearch!=null){
            //If All is checked
            if (isLocationidBeingSearched(SearchParameters.ALL)){
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO savedsearchlocation(savedsearchid, locationid) VALUES('"+savedSearchId+"', '"+SearchParameters.ALL+"')");
                //-----------------------------------
                //-----------------------------------
            } else {
                for (int i = 0; i < locationidsToSearch.length; i++) {
                    //-----------------------------------
                    //-----------------------------------
                    int identity = Db.RunSQLInsert("INSERT INTO savedsearchlocation(savedsearchid, locationid) VALUES('"+savedSearchId+"', '"+locationidsToSearch[i]+"')");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }

        //Delete all account relationships
        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("DELETE FROM savedsearchaccount WHERE savedsearchid='"+savedSearchId+"'");
        //-----------------------------------
        //-----------------------------------
        //And add them back
        if (accountidsToSearch!=null){
            //If All is checked
            if (isAccountBeingSearched(SearchParameters.ALL)){
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO savedsearchaccount(savedsearchid, accountid) VALUES('"+savedSearchId+"', '"+SearchParameters.ALL+"')");
                //-----------------------------------
                //-----------------------------------
            } else {
                for (int i = 0; i < accountidsToSearch.length; i++) {
                    //-----------------------------------
                    //-----------------------------------
                    int identity = Db.RunSQLInsert("INSERT INTO savedsearchaccount(savedsearchid, accountid) VALUES('"+savedSearchId+"', '"+accountidsToSearch[i]+"')");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }

        //Delete all eventtype relationships
        //-----------------------------------
        //-----------------------------------
        int count4 = Db.RunSQLUpdate("DELETE FROM savedsearcheventtype WHERE savedsearchid='"+savedSearchId+"'");
        //-----------------------------------
        //-----------------------------------
        //And add them back
        if (eventtypeidsToSearch!=null){
            //If All is checked
            if (isEventtypeidBeingSearched(SearchParameters.ALL)){
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO savedsearcheventtype(savedsearchid, eventtypeid) VALUES('"+savedSearchId+"', '"+SearchParameters.ALL+"')");
                //-----------------------------------
                //-----------------------------------
            } else {
                for (int i = 0; i < eventtypeidsToSearch.length; i++) {
                    //-----------------------------------
                    //-----------------------------------
                    int identity = Db.RunSQLInsert("INSERT INTO savedsearcheventtype(savedsearchid, eventtype) VALUES('"+savedSearchId+"', '"+eventtypeidsToSearch[i]+"')");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }

        //Now save each FieldQueryElement
        reger.core.Util.debug(5, "SearchParameters.java: Saving search.");
        if (fieldQueryElements!=null){
            reger.core.Util.debug(5, "SearchParameters.java: fieldQueryElements!=null.");
            for (int i = 0; i < fieldQueryElements.length; i++) {
                fieldQueryElements[i].saveToDB(savedSearchId);
            }
        } else {
            reger.core.Util.debug(5, "SearchParameters.java: fieldQueryElements==null.");
        }

        //Update the AccountCounts cache
        reger.cache.AccountCountCache.flushByAccountid(accountidToSaveTo);

    }

    public void loadSearchFromDB(int savedSearchId){
        //-----------------------------------
        //-----------------------------------
        String[][] rstSearch= Db.RunSQL("SELECT savedsearchid, name, lastx, lastxunits, daterange, datefromgmt, datetogmt, accountid, searchterms FROM savedsearch WHERE savedsearchid='"+savedSearchId+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstSearch!=null && rstSearch.length>0){
        	this.savedSearchId=savedSearchId;
        	name = rstSearch[0][1];
        	lastx = Integer.parseInt(rstSearch[0][2]);
        	lastxunits = Integer.parseInt(rstSearch[0][3]);
        	daterange = Integer.parseInt(rstSearch[0][4]);
        	dateFromGmt = reger.core.TimeUtils.dbstringtocalendar(rstSearch[0][5]);
        	dateToGmt = reger.core.TimeUtils.dbstringtocalendar(rstSearch[0][6]);
        	accountid = Integer.parseInt(rstSearch[0][7]);
        	searchTerms = rstSearch[0][8];
        	//Load the logids
        	//-----------------------------------
        	//-----------------------------------
        	String[][] rstLogids= Db.RunSQL("SELECT logid FROM savedsearchlog WHERE savedsearchid='"+savedSearchId+"'");
        	//-----------------------------------
        	//-----------------------------------
        	logsToSearch = new int[0];
        	if (rstLogids!=null && rstLogids.length>0){
        		for(int i=0; i<rstLogids.length; i++){
        		    logsToSearch = reger.core.Util.addToIntArray(logsToSearch, Integer.parseInt(rstLogids[i][0]));
        		}
        	}
        	//Load the locations
        	//-----------------------------------
        	//-----------------------------------
        	String[][] rstLocationids= Db.RunSQL("SELECT locationid FROM savedsearchlocation WHERE savedsearchid='"+savedSearchId+"'");
        	//-----------------------------------
        	//-----------------------------------
        	locationidsToSearch = new int[0];
        	if (rstLocationids!=null && rstLocationids.length>0){
        		for(int i=0; i<rstLocationids.length; i++){
        		    locationidsToSearch = reger.core.Util.addToIntArray(locationidsToSearch, Integer.parseInt(rstLocationids[i][0]));
        		}
        	}
        	//Load the accounts
        	//-----------------------------------
        	//-----------------------------------
        	String[][] rstAccountids= Db.RunSQL("SELECT accountid FROM savedsearchaccount WHERE savedsearchid='"+savedSearchId+"'");
        	//-----------------------------------
        	//-----------------------------------
        	accountidsToSearch = new int[0];
        	if (rstAccountids!=null && rstAccountids.length>0){
        		for(int i=0; i<rstAccountids.length; i++){
        		    accountidsToSearch = reger.core.Util.addToIntArray(accountidsToSearch, Integer.parseInt(rstAccountids[i][0]));
        		}
        	}
        	//Load the eventtypes
        	//-----------------------------------
        	//-----------------------------------
        	String[][] rstEventtypeids= Db.RunSQL("SELECT eventtypeid FROM savedsearcheventtype WHERE savedsearchid='"+savedSearchId+"'");
        	//-----------------------------------
        	//-----------------------------------
        	eventtypeidsToSearch = new int[0];
        	if (rstEventtypeids!=null && rstEventtypeids.length>0){
        		for(int i=0; i<rstEventtypeids.length; i++){
        		    eventtypeidsToSearch = reger.core.Util.addToIntArray(eventtypeidsToSearch, Integer.parseInt(rstEventtypeids[i][0]));
        		}
        	}
        	//Load the searchParameters
        	//-----------------------------------
        	//-----------------------------------
        	String[][] rstFqe= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE savedsearchid='"+savedSearchId+"'");
        	//-----------------------------------
        	//-----------------------------------
        	fieldQueryElements = new FieldQueryElement[0];
        	if (rstFqe!=null && rstFqe.length>0){
        		for(int i=0; i<rstFqe.length; i++){
        		    FieldQueryElement tmpFqe = new FieldQueryElement(Integer.parseInt(rstFqe[i][0]));
        		    fieldQueryElements = AddToArray.addFieldQueryElementArray(fieldQueryElements, tmpFqe);
        		}
        	}

        }
    }

    public void delete(){

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM savedsearch WHERE savedsearchid='"+savedSearchId+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count1 = Db.RunSQLUpdate("DELETE FROM savedsearchaccount WHERE savedsearchid='"+savedSearchId+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("DELETE FROM savedsearchfqe WHERE savedsearchid='"+savedSearchId+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("DELETE FROM savedsearchlocation WHERE savedsearchid='"+savedSearchId+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count4 = Db.RunSQLUpdate("DELETE FROM savedsearchlog WHERE savedsearchid='"+savedSearchId+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count5 = Db.RunSQLUpdate("DELETE FROM savedsearcheventtype WHERE savedsearchid='"+savedSearchId+"'");
        //-----------------------------------
        //-----------------------------------

        //Update the AccountCounts cache
        reger.cache.AccountCountCache.flushByAccountid(accountid);

    }

    public int[] getAccountidsToSearch() {
        return accountidsToSearch;
    }

    public void setAccountidsToSearch(int[] accountidsToSearch) {
        this.accountidsToSearch = accountidsToSearch;
    }
}
