package reger.cache;

import reger.TrafficHit;
import reger.core.Debug;

import java.util.HashSet;
import java.util.Collections;
import java.util.Set;
import java.util.Iterator;

/**
 * Caches traffic hits.  Scheduler/MasterThread
 */
public class TrafficHitCache {

    private static Set trafficHits;

    public static void addTrafficHit(TrafficHit hit){
        if (trafficHits==null){
            trafficHits = Collections.synchronizedSet(new HashSet());
        }
        synchronized(trafficHits){
            if (hit!=null && trafficHits!=null){
                if (!trafficHits.contains(hit)){
                    trafficHits.add(hit);
                } else {
                    trafficHits.remove(hit);
                    hit.incrementCount();
                    trafficHits.add(hit);
                }
            } else {
                Debug.debug(4, "", "TrafficHitCache.java - NULL TrafficHit handed to TrafficHitCache.addTrafficHit().");
            }
        }
    }

    public static void saveAndPurge(){
        if (trafficHits!=null){
            synchronized(trafficHits){
                //Save
                for (Iterator iterator = trafficHits.iterator(); iterator.hasNext();) {
                    TrafficHit trafficHit = (TrafficHit) iterator.next();
                    trafficHit.save();
                    //Purge
                    iterator.remove();
                }
                //Purge
                trafficHits = null;
            }
        }
    }

    public static int getNumberOfCachedTrafficHits(){
        if (trafficHits!=null){
            return trafficHits.size();
        } else {
            return 0;
        }
    }

    public static int getEstimatedMemoryUsage(){
        int usage = 0;
        if (trafficHits!=null){
            synchronized(trafficHits){
                //Calculate memory usage
                for (Iterator iterator = trafficHits.iterator(); iterator.hasNext();) {
                    TrafficHit trafficHit = (TrafficHit) iterator.next();
                    usage = usage + trafficHit.getEstimatedMemoryUsage();
                }
            }
        }
        return usage;
    }


    public static StringBuffer getHitsAsBigLongUglyString() {
        StringBuffer mb = new StringBuffer();
        if (trafficHits!=null){
            synchronized(trafficHits){
                for (Iterator iterator = trafficHits.iterator(); iterator.hasNext();) {
                    TrafficHit trafficHit = (TrafficHit) iterator.next();
                    mb.append(trafficHit.getHitAsAnnotatedString() + "<br>");
                }
            }
        }
        return mb;
    }

}
