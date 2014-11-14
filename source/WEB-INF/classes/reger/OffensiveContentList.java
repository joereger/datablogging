package reger;

import reger.core.db.Db;

import java.util.Vector;
import java.util.TreeMap;

/**
 * A list of unacceptable content, bad words, bad phrases, etc.
 * CAUTION: This class contains vulgar words.  If you are sensitive
 * to certain words please do not view the contents of this class.
 */
public class OffensiveContentList {

    private static Vector offensivesystem = null;
    private static TreeMap treemapOfOffensivePlVectors = null;

    /**
     * Returns a vector of all words for the entire system.
     * See also: getWordsForPl which includes this and words
     * setup for a particular pL.
     */
    public Vector getWordsDefaults(){
        if (offensivesystem==null){
            forceReloadDefaults();
        }
        return offensivesystem;
    }

    /**
     * Returns the words specific to a particular pl.
     * Note that this Vector also includes words from the
     * default system list.
     */
    public Vector getWordsForPl(int plid){
        Vector out = new Vector();
        if (treemapOfOffensivePlVectors==null || !treemapOfOffensivePlVectors.containsKey(new Integer(plid))){
            forceReloadPlid(plid);
        }
        out.addAll(getWordsDefaults());
        out.addAll((Vector)treemapOfOffensivePlVectors.get(new Integer(plid)));
        return out;
    }

    private void forceReloadDefaults(){
        offensivesystem = new java.util.Vector();
        //-----------------------------------
        //-----------------------------------
        String[][] rstDef= Db.RunSQL("SELECT content FROM offensivecontentdefaults ORDER BY content ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstDef!=null && rstDef.length>0){
        	for(int i=0; i<rstDef.length; i++){
        	    offensivesystem.add(rstDef[i][0]);
        	}
        }
    }

    private void forceReloadPlid(int plid){
        Vector offensivepl = new java.util.Vector();
        //-----------------------------------
        //-----------------------------------
        String[][] rstDef= Db.RunSQL("SELECT content FROM offensivecontentpl WHERE plid='"+plid+"' ORDER BY content ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstDef!=null && rstDef.length>0){
            for(int i=0; i<rstDef.length; i++){
                offensivepl.add(rstDef[i][0]);
            }
        }
        //Make sure it's not null
        if (treemapOfOffensivePlVectors==null){
            treemapOfOffensivePlVectors = new TreeMap();
        }
        //Put into the treemap keyed to this plid
        treemapOfOffensivePlVectors.put(new Integer(plid), offensivepl);
    }


}
