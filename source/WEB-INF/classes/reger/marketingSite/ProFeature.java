package reger.marketingSite;

/**
 * Holds a single feature
 */
public class ProFeature {

    public String name = "";
    public String description = "";
    public boolean isfree = false;
    public String freetext = "";
    public String protext = "";
    public String url = "";
    public String screenshot = "";

    /**
     * Main constructor
     * @param name
     * @param isfree
     * @param url
     * @param description
     * @param freetext
     * @param protext
     * @param screenshot
     */
    public ProFeature(String name, boolean isfree, String url, String screenshot, String description, String freetext, String protext){
        this.name = name;
        this.description = description;
        this.isfree = isfree;
        this.url = url;
        this.freetext = freetext;
        this.protext = protext;
        this.screenshot = screenshot;
    }

    /**
     * Override making it easy to send without a screenshot
     * @param name
     * @param isfree
     * @param url
     * @param description
     * @param freetext
     * @param protext
     */
    public ProFeature(String name, boolean isfree, String url, String description, String freetext, String protext){
        this.name = name;
        this.description = description;
        this.isfree = isfree;
        this.url = url;
        this.freetext = freetext;
        this.protext = protext;
        this.screenshot = "";
    }

}
