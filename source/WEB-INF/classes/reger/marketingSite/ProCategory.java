package reger.marketingSite;

import java.util.Vector;

/**
 * Holds a single feature
 */
public class ProCategory {

    public String name = "";
    public Vector features = new Vector();


    public ProCategory(String name){
        this.name = name;
    }

    public void addFeature(ProFeature proFeature){
        features.add(proFeature);
    }
}
