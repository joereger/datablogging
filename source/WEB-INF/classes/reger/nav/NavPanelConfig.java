package reger.nav;

/**
 * These are the properties of a navpanel
 */
public class NavPanelConfig {

    public int insetFromMargins = 15;
    public String fontcolor = "#333333";
    public String outlinecolor = "#999999";
    public String tabbgoffcolor = "#e6e6e6";
    public String tabbgoncolor = "#ffffff";
    public int spaceBetweenTabs = 3;
    public int tabheight = 21;

    public NavPanelConfig(int levelsNested){
        if (levelsNested==0){
            configLevel0();
        } else if (levelsNested==1){
            configLevel1();
        }  else if (levelsNested==2){
            configLevel2();
        }
    }

    private void configLevel0(){
        insetFromMargins = 15;
        fontcolor = "#333333";
        outlinecolor = "#999999";
        tabbgoffcolor = "#e6e6e6";
        tabbgoncolor = "#666666";
        spaceBetweenTabs = 3;
        tabheight = 30;
    }

    private void configLevel1(){
        insetFromMargins = 15;
        fontcolor = "#333333";
        outlinecolor = "#999999";
        tabbgoffcolor = "#e6e6e6";
        tabbgoncolor = "#ffffff";
        spaceBetweenTabs = 3;
        tabheight = 20;
    }

    private void configLevel2(){
        insetFromMargins = 15;
        fontcolor = "#333333";
        outlinecolor = "#999999";
        tabbgoffcolor = "#e6e6e6";
        tabbgoncolor = "#ffffff";
        spaceBetweenTabs = 3;
        tabheight = 20;
    }

}
