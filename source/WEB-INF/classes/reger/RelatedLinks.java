package reger;

import reger.core.db.Db;
import reger.cache.providers.jboss.Cacheable;

import java.util.ArrayList;

/**
 * The Related Links feature
 */
@Cacheable
public class RelatedLinks {

    //These are the outputs of the object
    //These are guaranteed to be of the same index... in other words,
    //relatedEventid[1] goes with relatedTitles[1]
//    public int[] relatedEventid = new int[0];
//    public String[] relatedTitles = new String[0];
//    public String[] relatedRank = new String[0];

    private ArrayList<RelatedLink> relatedLinks = new ArrayList<RelatedLink>();

    //Internal vars
    private int eventid = -1;
    private String searchterms = "";
    private int accountid = -1;
    private String LogsUserCanViewQueryend = "";



    /**
     * A constructor to use if all you know is the eventid.  The object will be populated with only public log related entries.
     * @param eventid
     */
    public RelatedLinks(int eventid){
        this.eventid=eventid;
        this.accountid=Entry.getAccountidFromEventid(eventid);
        this.LogsUserCanViewQueryend="";
        this.searchterms=getSearchTermsFromEventid(eventid);
        //Actually find the links
        findRelatedLinks();

    }

    /**
     * A constructor to use if you know the eventid .
     * @param eventid
     */
    public RelatedLinks(int eventid, reger.UserSession userSession){
        this.eventid=eventid;
        this.accountid=userSession.getAccount().getAccountid();
        this.LogsUserCanViewQueryend=userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid());
        this.searchterms=getSearchTermsFromEventid(eventid);
        //Actually find the links
        findRelatedLinks();
    }

    /**
     * This is the fastest constructor because some of the work is done previously.
     */
    public RelatedLinks(int eventid, String searchterms, reger.UserSession userSession){
        this.eventid=eventid;
        this.searchterms=searchterms;
        this.accountid=userSession.getAccount().getAccountid();
        this.LogsUserCanViewQueryend=userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid());
        //Actually find the links
        findRelatedLinks();
    }


    /**
     * Actually finds the related links
     */

    private void findRelatedLinks(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstRelatedLinks= Db.RunSQL("SELECT eventid, title, MATCH (title,comments) AGAINST ('"+ reger.core.Util.cleanForSQL(searchterms) +"') As score FROM event event, megalog WHERE MATCH (title,comments) AGAINST ('"+ reger.core.Util.cleanForSQL(searchterms) +"')>0 AND event.logid=megalog.logid AND (event.accountid='" + accountid + "') AND "+ LogsUserCanViewQueryend + " AND event.eventid<>'"+eventid+"' AND "+reger.Entry.sqlOfLiveEntry+" ORDER BY score DESC LIMIT 0,5");
        //-----------------------------------
        //-----------------------------------
        if (rstRelatedLinks!=null && rstRelatedLinks.length>0){
            //Initialize our main output vars to the correct size
//            relatedEventid = new int[rstRelatedLinks.length];
//            relatedTitles = new String[rstRelatedLinks.length];
//            relatedRank = new String[rstRelatedLinks.length];
            //Iterate the results
            for(int i=0; i<rstRelatedLinks.length; i++){
//                relatedEventid[i] = Integer.parseInt(rstRelatedLinks[i][0]);
//                relatedTitles[i] = rstRelatedLinks[i][1];
//                relatedRank[i] = rstRelatedLinks[i][2];
                relatedLinks.add(new RelatedLink(Integer.parseInt(rstRelatedLinks[i][0]), rstRelatedLinks[i][1], rstRelatedLinks[i][2]));
            }
        }
        //Clear the memory required for searchterms
        searchterms="";
    }

    private String getSearchTermsFromEventid(int eventid){
        String sterms = "";
        //Need to find the searchterms
        //-----------------------------------
        //-----------------------------------
        String[][] rstSearchterms= Db.RunSQL("SELECT title, comments FROM event WHERE eventid='"+eventid+"' LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if (rstSearchterms!=null && rstSearchterms.length>0){
            sterms = rstSearchterms[0][0] + " " +rstSearchterms[0][1];
        }
        return sterms;
    }

    public ArrayList<RelatedLink> getRelatedLinks() {
        return relatedLinks;
    }

}
