package reger.demos;

/**
 * A single demo
 */
public class Demo {

    private String demoName = "";
    private String demoFilename = "";
    private String demoDescription = "";

    public static String demoBaseUrl;


    public Demo(String demoName, String demoFilename, String demoDescription){
        this.demoName=demoName;
        this.demoFilename=demoFilename;
        this.demoDescription=demoDescription;
    }

    public String getDemoBaseUrl(){
        if (demoBaseUrl==null || demoBaseUrl.equals("")){
            demoBaseUrl = reger.systemprops.AllSystemProperties.getProp("DEMOSDIRECTORYURL");
        }
        if (demoBaseUrl==null || demoBaseUrl.equals("")){
            return "http://www.reger.com/demos/";
        }
        return demoBaseUrl;
    }

    public String getDemoFilename() {
        return demoFilename;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }



    public void setDemoFilename(String demoFilename) {
        this.demoFilename = demoFilename;
    }

    public String getDemoDescription() {
        return demoDescription;
    }

    public void setDemoDescription(String demoDescription) {
        this.demoDescription = demoDescription;
    }


}
