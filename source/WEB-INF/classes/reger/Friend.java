package reger;

import reger.core.db.Db;
import reger.core.Debug;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Calendar;

/**
 * This holds the static list of friends
 */
public class Friend {

    //Important HashMap:
    //Index is user, second dimension is that user's friends
    //friends(17)[{34,56,134,567}]
    //friends(18)[{12,16}]
    //friends(19)[{278,678,3324,2234}]
    public static HashMap friends = new HashMap(100);
    public static boolean isLocked = false;
    public static boolean hasBeenPopulatedFromDB = false;
    public static Calendar lastPopulatedDate;
    public static int maxFriendidAtLastUpdate;
    public static int countFriendsAtLastUpdate;


    /**
     *  Constructor, loads friends from the database to the double array
     */
    public Friend(){

        //Log that the freind object has been called
        Debug.debug(5, "", "An instance of reger.Friend() has been constructed.");

        //Only refresh friends from Db if we haven't done so already.
        Calendar fiveMinutesAgo = Calendar.getInstance();
        fiveMinutesAgo.add(Calendar.MINUTE, -5);
        //if (!hasBeenPopulatedFromDB || (lastPopulatedDate!=null && lastPopulatedDate.before(fiveMinutesAgo))){
        if (!hasBeenPopulatedFromDB || ((maxFriendidAtLastUpdate!=maxFriendid() || countFriendsAtLastUpdate!=countFriends()))){
            refreshFriendsFromDb();
        }

    }

    public void refreshFriendsFromDb(){
        while (isLocked){
            try{
                //@todo Find proper way to wait... this wait throws an exception... uncomment below to see it.
                this.wait(100);
            } catch (Exception e){
                //reger.core.Util.errorsave(e);
            }
        }

        try {
            //Lock the object
            isLocked = true;

            //Empty out the array
            friends.clear();

            //Debug
            Debug.debug(5, "", "Populating reger.Friend object from the database.");

            //Populate from the database
            //-----------------------------------
            //-----------------------------------
            String[][] rstFriends= Db.RunSQL("SELECT friendid, accountuseridsource, accountuseridtarget FROM friend");
            //-----------------------------------
            //-----------------------------------
            if (rstFriends!=null && rstFriends.length>0){

                //Initialize the friend var
                friends = new HashMap(rstFriends.length);

                for(int i=0; i<rstFriends.length; i++){
                    //Add each friend to the Vector
                    addFriendToHashMap(Integer.parseInt(rstFriends[i][1]), Integer.parseInt(rstFriends[i][2]));
                }
            }

            //Update the status vars
            hasBeenPopulatedFromDB = true;
            lastPopulatedDate=Calendar.getInstance();
            maxFriendidAtLastUpdate = maxFriendid();
            countFriendsAtLastUpdate = countFriends();

        } catch (Exception e) {
            Debug.errorsave(e, "");
        } finally {
            //Unlock the object
            isLocked=false;
        }
    }

    /**
     * Adds the target to the source's entry in the big imporatant friends double array
     * @param accountuseridsource
     * @param accountuseridtarget
     */
    private void addFriendToHashMap(int accountuseridsource, int accountuseridtarget){
        //Append to the array of friends
        int[] tmp = reger.core.Util.addToIntArray((int[]) friends.get(new Integer(accountuseridsource)), accountuseridtarget);
        //Put that array into the HashMap
        friends.put(new Integer(accountuseridsource), tmp);
    }




    /**
     * Returns the relationship between one friend and another. If there is no relationship it returns a single-valued array with the source as the value
     */
    public int[][] getAllRelationships(int accountuseridsource, int accountuseridtarget){
        //Path array
        int [] path = new int[0];

        //Add accountuseridsource to the path
        path = reger.core.Util.addToIntArray(path, accountuseridsource);

        //Define some constants
        int maxLevelToSearchTo = 5;

        //Start a new object which will recusrively find the target
        reger.FriendFind friendFinder = new reger.FriendFind(path, accountuseridtarget, 1, maxLevelToSearchTo);

        //Debug
        //reger.core.Util.logDoubleIntArrayToDb("Final Relationship:", friendFinder.successFullPaths);

        //Return
        return friendFinder.successFullPaths;
    }

    /**
     * Returns the shortest-route relationship
     */
    public int[] getShortestRelationship(int accountuseridsource, int accountuseridtarget){
        //First, get all relationships
        int[][] allRels = getAllRelationships(accountuseridsource, accountuseridtarget);
        //Next, loop through
        int[] shortestPath = new int[0];
        for (int i = 0; i < allRels.length; i++) {
            //If the current path is shorter than the one we have currently... or if there's nothing there
            if (allRels[i].length<shortestPath.length || shortestPath.length==0){
                //The shortest path is now the current one
                shortestPath = allRels[i];
            }
        }
        //Return
        return shortestPath;
    }



    public int[] getFriends(int accountuserid){
        return (int[]) friends.get(new Integer(accountuserid));
    }





    /**
     * Utility to return friendsHashmap
     */
    public HashMap getFriends(){
        return this.friends;
    }

    /**
     * Util to write HashMap to DB
     */
     public void debugWriteFriendsToDb(){
        StringBuffer tst = new StringBuffer();
        for (Iterator i=friends.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            //out.println(e.getKey() + ": " + e.getValue());
            int[] tmpArray = (int[]) friends.get(e.getKey());
            StringBuffer tstTmp = new StringBuffer();
            for (int j = 0; j < tmpArray.length; j++) {
                tstTmp.append(tmpArray[j] + ", ");
            }
            tst.append("<br><b>HashMap("+e.getKey()+"):</b> " + tstTmp);
        }
        Debug.logtodb("<br><b>Contents of the Friends HashMap:</b>" + tst, "");

    }

    public void dataload(int size){
        //Create one entry for each accountuser
        for(int i=0; i<size; i++){
            //Each person gets between one and 25 friends
            int numberoffriends = reger.core.Util.randomInt(25);
            for(int j=0; j<=numberoffriends; j++){
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO friend(accountuseridsource, accountuseridtarget) VALUES('"+i+"', '"+reger.core.Util.randomInt(size)+"')");
                //-----------------------------------
                //-----------------------------------
            }

        }

    }

    private int maxFriendid(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstMax= Db.RunSQL("SELECT MAX(friendid) FROM friend");
        //-----------------------------------
        //-----------------------------------
        if (rstMax!=null && rstMax.length>0){
            if (reger.core.Util.isinteger(rstMax[0][0])){
        	    return Integer.parseInt(rstMax[0][0]);
            }
        }

        return 0;
    }

    private int countFriends(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstCount= Db.RunSQL("SELECT count(*) FROM friend");
        //-----------------------------------
        //-----------------------------------
        if (rstCount!=null && rstCount.length>0){
            if (reger.core.Util.isinteger(rstCount[0][0])){
        	    return Integer.parseInt(rstCount[0][0]);
            }
        }

        return 0;
    }



}
