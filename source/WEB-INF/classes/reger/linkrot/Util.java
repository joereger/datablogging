package reger.linkrot;

import reger.core.db.Db;
import reger.core.Debug;

/**
 * Utility functions for the linkrot system
 */
public class Util {


    //Add/update linkrot
    public static int updateLinkrot(String url, String keywords, boolean isbroken, String recommendation, int httpstatuscode){
        //Debug
        Debug.debug(5, "", "url:"+url+"<br>LinkrotProcessRequests.updateLinkrot() - start");
        //Convert boolean to int
        int isbrokenint = 0;
        if (isbroken){
            isbrokenint = 1;
        }

        //This holds the current linkrotid that we're working with
        int linkrotid = -1;

        //Check for the url in the linkrot tables
        //-----------------------------------
        //-----------------------------------
        String[][] rstUrl= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE url='"+reger.core.Util.cleanForSQL(url)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstUrl!=null && rstUrl.length>0){
            for(int i=0; i<rstUrl.length; i++){
                if (!keywords.equals("") && httpstatuscode==200){
                    //Update the table and the keywords
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("UPDATE linkrot SET lastcheckeddate='"+reger.core.TimeUtils.nowInGmtString()+"', keywords='"+reger.core.Util.cleanForSQL(keywords)+"', isbroken='"+isbrokenint+"', httpstatuscode='"+httpstatuscode+"' WHERE linkrotid='"+rstUrl[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                } else {
                    //Update the table - not the keywords
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("UPDATE linkrot SET lastcheckeddate='"+reger.core.TimeUtils.nowInGmtString()+"', isbroken='"+isbrokenint+"', httpstatuscode='"+httpstatuscode+"' WHERE linkrotid='"+rstUrl[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }

                //Set the linkrotid
                linkrotid = Integer.parseInt(rstUrl[i][0]);
            }
        } else {
            //Add to the linkrot table
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO linkrot(url, keywords, lastcheckeddate, isbroken, httpstatuscode) VALUES('"+reger.core.Util.cleanForSQL(url)+"', '"+reger.core.Util.cleanForSQL(keywords)+"', '"+reger.core.TimeUtils.nowInGmtString()+"', '"+isbrokenint+"', '"+httpstatuscode+"')");
            //-----------------------------------
            //-----------------------------------

            //Set the linkrotid
            linkrotid = identity;
        }

        //Add/update recommendation
        if (!recommendation.equals("")){
            if (httpstatuscode>=300 && httpstatuscode<=399){
                addUpdateRecommendation(linkrotid, recommendation, "The Site Recommended It (301 Redirect)");
            } else {
                addUpdateRecommendation(linkrotid, recommendation, "");
            }
        }

        //Debug
        Debug.debug(5, "", "url:"+url+"<br>LinkrotProcessRequests.updateLinkrot() - end");

        return linkrotid;
    }

    //Add/update linkrot->eventid relationship
    public static void updateLinkrotEventidRelationship(String[] urls, int eventid){
        for (int i = 0; i < urls.length; i++) {
            updateLinkrotEventidRelationship(urls[i], eventid);
        }
    }


    //Add/update linkrot->eventid relationship
    public static void updateLinkrotEventidRelationship(String url, int eventid){
        //Debug
        Debug.debug(5, "", "reger.linkrot.Util.updateLinkrotEventidRelationship() - start");

        //See if the url exists in the linkrot table
        int linkrotid = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstLr= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE url='"+reger.core.Util.cleanForSQL(url)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstLr!=null && rstLr.length>0){
            for(int i=0; i<rstLr.length; i++){
                linkrotid = Integer.parseInt(rstLr[i][0]);
            }
        }

        //If it doesn't, create it
        if (linkrotid==0){
            //-----------------------------------
            //-----------------------------------
            linkrotid = Db.RunSQLInsert("INSERT INTO linkrot(url, keywords, lastcheckeddate, isbroken, httpstatuscode) VALUES('"+reger.core.Util.cleanForSQL(url)+"', '', '"+reger.core.TimeUtils.nowInGmtString()+"', '0', '200')");
            //-----------------------------------
            //-----------------------------------
        }


        //See if the relationship exists now
        //-----------------------------------
        //-----------------------------------
        String[][] rstRel= Db.RunSQL("SELECT linkroteventlookupid FROM linkroteventlookup WHERE linkrotid='"+linkrotid+"' AND eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstRel!=null && rstRel.length>0){
            for(int i=0; i<rstRel.length; i++){
                //Do nothing, the relationship exists
            }
        } else {
            //Add the relationship
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO linkroteventlookup(linkrotid, eventid) VALUES('"+linkrotid+"', '"+eventid+"')");
            //-----------------------------------
            //-----------------------------------
        }
        //Debug
        Debug.debug(5, "", "reger.linkrot.Util.updateLinkrotEventidRelationship() - end");
    }

    /**
     * This is called after a user has manually fixed a link.  It's purpose is
     * to clean up the database relationship table between event and linkrotid.
     * It also stores what the user did as a recommendation for others with the
     * same link.
     * @param linkrotid
     * @param eventid
     */
    public static void completeFixForEventid(int linkrotid, int eventid, String chosenUrlReplacement){
        //Debug
        Debug.debug(5, "", "chosenUrlReplacement:"+chosenUrlReplacement+"<br>LinkrotProcessRequests.completefixforeventid() - start");
        //Now see how many others have the url that was just replaced
        //-----------------------------------
        //-----------------------------------
        String[][] rstCount= Db.RunSQL("SELECT count(*) FROM linkroteventlookup WHERE linkrotid='"+linkrotid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCount!=null && rstCount.length>0){
            //Break the relationship between the eventid and the linkrot
            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("DELETE FROM linkroteventlookup WHERE eventid='"+eventid+"' AND linkrotid='"+linkrotid+"'");
            //-----------------------------------
            //-----------------------------------

            if (Integer.parseInt(rstCount[0][0])==1){
                //Only this user has this url so we need to delete it from the linkrot tables
                //-----------------------------------
                //-----------------------------------
                int count3 = Db.RunSQLUpdate("DELETE FROM linkrot WHERE linkrotid='"+linkrotid+"'");
                //-----------------------------------
                //-----------------------------------

            } else if (Integer.parseInt(rstCount[0][0])>1) {
                //Others have the same url in their entries, so just record a recommendation
                addUpdateRecommendation(linkrotid, chosenUrlReplacement, "Another User Used To Fix The Same URL");
            }
        }
        //Debug
        Debug.debug(5, "", "chosenurlreplacement:"+chosenUrlReplacement+"<br>LinkrotProcessRequests.completeFixForEventid() - end");
    }

    public static void addUpdateRecommendation(int linkrotid, String url, String source){
        //Debug
        Debug.debug(5, "", "url:"+url+"<br>LinkrotProcessRequests.addUpdateRecommendation() - start");
        //See if the recommendation exists now
        //-----------------------------------
        //-----------------------------------
        String[][] rstRel= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE linkrotid='"+linkrotid+"' AND url='"+reger.core.Util.cleanForSQL(url)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstRel!=null && rstRel.length>0){
            for(int i=0; i<rstRel.length; i++){
                //Do nothing, the relationship exists
            }
        } else {
            //Add the relationship
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO linkrotrecommendation(linkrotid, url, source) VALUES('"+linkrotid+"', '"+reger.core.Util.cleanForSQL(url)+"', '"+reger.core.Util.cleanForSQL(source)+"')");
            //-----------------------------------
            //-----------------------------------
        }
        //Debug
        Debug.debug(5, "", "url:"+url+"<br>LinkrotProcessRequests.addUpdateRecommendation() - end");
    }

    public static void deleteOrphanLinkrotids(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstCnt= Db.RunSQL("SELECT (SELECT count(*) FROM linkroteventlookup WHERE linkrotid=a.linkrotid) as cnt, linkrotid FROM linkrot a ORDER BY cnt ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstCnt!=null && rstCnt.length>0){
            for(int i=0; i<rstCnt.length; i++){
                //If there are no events using it
                if (Integer.parseInt(rstCnt[i][0])==0){
                    //Delete the linkrotid because it has no events using it
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("DELETE FROM linkrot WHERE linkrotid='"+rstCnt[i][1]+"'");
                    //-----------------------------------
                    //-----------------------------------

                    //Delete any recommendations too
                    //-----------------------------------
                    //-----------------------------------
                    int count2 = Db.RunSQLUpdate("DELETE FROM linkrotrecommendation WHERE linkrotid='"+rstCnt[i][1]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }
    }



    public static void randomizeDates(int maxAgeInDays){



        //-----------------------------------
        //-----------------------------------
        String[][] rstLr= Db.RunSQL("SELECT linkrotid FROM linkrot");
        //-----------------------------------
        //-----------------------------------
        if (rstLr!=null && rstLr.length>0){
           for(int i=0; i<rstLr.length; i++){


                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE linkrot SET lastcheckeddate='"+reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.getRandomDateInPast(maxAgeInDays))+"' WHERE linkrotid='"+rstLr[i][0]+"'");
                //-----------------------------------
                //-----------------------------------

           }
        }
    }




}
