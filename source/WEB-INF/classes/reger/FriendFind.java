package reger;

import java.util.HashMap;

/**
 *
 */
public class FriendFind {

    public int[][] successFullPaths;

    public FriendFind(int[] path, int lookingfor, int currentLevel, int levelToSearchTo){

        //Get the last thing in the path
        int currentnode = path[path.length-1];

        //Get the friends of the current node
        int[] friendstosearch = (int[]) reger.Friend.friends.get(new Integer(currentnode));

        //Search this node's friends and see if there's a match
        if (reger.core.Util.isIntInIntArray(lookingfor, friendstosearch)){
            //Add the final found value to the path
            int[] tmpPath = reger.core.Util.addToIntArray(path, lookingfor);
            //Debug
            //reger.core.Util.logDoubleIntArrayToDb("Before Adding to successfulPaths.  Level("+currentLevel+")", this.successFullPaths);
            //Add to the list of all successfulpaths
            addToSuccessFullPaths(tmpPath);
            //Debug
            //reger.core.Util.logDoubleIntArrayToDb("After Adding to successfulPaths.  Level("+currentLevel+")", this.successFullPaths);

        }

        //Make sure we're not going too deep
        if (friendstosearch!=null && currentLevel<=levelToSearchTo) {
            for (int i = 0; i < friendstosearch.length; i++) {
                //Don't tree out on nodes of the one we're looking for
                if (friendstosearch[i]!=lookingfor){
                    //Don't search down paths when we've already seen this friend previously in the path... i.e. a loop
                    //i.e. 25-456-324-25
                    //Once we see 25 the second time we shouldn't continue
                    if (!reger.core.Util.isIntInIntArray(friendstosearch[i], path)){
                        //Moving down chain
                        int[] nextPath = reger.core.Util.addToIntArray(path, friendstosearch[i]);
                        //Start a new object
                        reger.FriendFind nextFriend = new reger.FriendFind(nextPath, lookingfor, currentLevel+1, levelToSearchTo);
                        //If the object found
                        //Debug
                        //reger.core.Util.logDoubleIntArrayToDb("()()()()()<br>nextFriend.successFullPaths.  Level("+currentLevel+")", nextFriend.successFullPaths);
                        addToSuccessFullPaths(nextFriend.successFullPaths);
                        //Debug
                        //reger.core.Util.logDoubleIntArrayToDb("After Adding to successfulPaths.  Level("+currentLevel+")", this.successFullPaths);
                        nextFriend = null;
                    }
                }
            }
        }
    }

    /**
     * Adds a single successful path to the variable holding all successful paths
     * @param successfullPath
     */
    private void addToSuccessFullPaths(int[] successfullPath){
        //if (successfullPath!=null &&  successfullPath.length>0){
            //Debug
            //reger.core.Util.logDoubleIntArrayToDb("Before Adding to successfulPaths in ((((int[])))).", this.successFullPaths);
            //reger.core.Util.logIntArrayToDb("What's being added:", successfullPath);
        //}
        if (!isPathAlreadySaved(successfullPath)){
            this.successFullPaths = reger.core.Util.extendArray(this.successFullPaths, 1);
            this.successFullPaths[this.successFullPaths.length-1] = successfullPath;
        }
        //if (successfullPath!=null && successfullPath.length>0){
            //reger.core.Util.logDoubleIntArrayToDb("After Adding to successfulPaths in int[].", this.successFullPaths);
        //}
    }

    /**
     * Combines another double array of successful paths with the current one
     * @param successfullpath
     */
    private void addToSuccessFullPaths(int[][] successfullpath){
        //Iterate on each element of the double array
        if (successfullpath!=null){
            //Debug
            //reger.core.Util.logDoubleIntArrayToDb("----Double Array Being Added:", successfullpath);

            for (int i = 0; i < successfullpath.length; i++) {
                addToSuccessFullPaths(successfullpath[i]);
            }
        }
    }

    private boolean isPathAlreadySaved(int[] pathtocheck){
        //If there is at least one already saved
        if (this.successFullPaths!=null){
            //Iterate the saved paths
            for (int i = 0; i < this.successFullPaths.length; i++) {
                //If the current saved path has the same length as the pathtocheck
                if (this.successFullPaths[i].length == pathtocheck.length){
                    //Iterate the paths, looking for an exact match
                    boolean foundmatch = true;
                    for (int j = 0; j < this.successFullPaths[i].length; j++) {
                        if (this.successFullPaths[i][j]!=pathtocheck[j]){
                            foundmatch = false;
                        }
                    }
                    //Return true if we've got a match
                    if (foundmatch){
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
