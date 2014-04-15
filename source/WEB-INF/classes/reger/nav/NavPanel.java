package reger.nav;

import reger.UserSession;
import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;

/**
 * A NavPanel displays a tier of navigation
 */
public class NavPanel {

    private NavButton[] navButtons;
    private String parentNavButtonName;
    private String currentNavButtonName;
    private int navLevel;

    //private NavPanelConfig navPanelConfig;

    /**
     * Creates the panel with a set of NavButtons.
     * The parentNavButton determines which level this is operating at.
     * ParentNavButton filters out irrelevant buttons.
     */
    public NavPanel(String parentNavButtonName, String currentNavButtonName){
        this.navButtons = AllNavButtons.getAllButtonsWithSameParent(parentNavButtonName);
        this.parentNavButtonName = parentNavButtonName;
        this.currentNavButtonName = currentNavButtonName;
        //Debug.debug(5, "", "NavPanel Created.  <br>currentNavButtonName = " + currentNavButtonName + "<br>parentNavButton = " + parentNavButtonName);
        navLevel = levelsNested();
        //this.navPanelConfig = new NavPanelConfig(levelsNested());

    }

    /**
     * Creates the panel with a custom set of navbuttons
     */
    public NavPanel(String parentNavButtonName, String currentNavButtonName, NavButton[] navButtons, int initialNavLevel){
        this.navButtons = navButtons;
        this.parentNavButtonName = parentNavButtonName;
        this.currentNavButtonName = currentNavButtonName;
        //Debug.debug(5, "", "Custom NavPanel Created.  <br>currentNavButtonName = " + currentNavButtonName + "<br>parentNavButton = " + parentNavButtonName);
        navLevel = initialNavLevel;
        //this.navPanelConfig = new NavPanelConfig(levelsNested());

    }

    public String getHtmlStart(String pathToAppRoot, UserSession userSession, HttpServletRequest request){
        if (navLevel==0){
            return NavPanelLevelZero.getHtmlStart(pathToAppRoot, userSession, navButtons, currentNavButtonName, request);
        } else if (navLevel==1){
            return NavPanelLevelOne.getHtmlStart(pathToAppRoot, userSession, navButtons, currentNavButtonName, request);
        } else if (navLevel==2){
            return NavPanelLevelTwo.getHtmlStart(pathToAppRoot, userSession, navButtons, currentNavButtonName, request);
        } else {
            return NavPanelLevelTwo.getHtmlStart(pathToAppRoot, userSession, navButtons, currentNavButtonName, request);
        }
    }

    public String getHtmlEnd(String pathToAppRoot, HttpServletRequest request){
        if (navLevel==0){
            return NavPanelLevelZero.getHtmlEnd(pathToAppRoot, navButtons, currentNavButtonName, request);
        } else if (navLevel==1){
            return NavPanelLevelOne.getHtmlEnd(pathToAppRoot, navButtons, currentNavButtonName, request);
        } else if (navLevel==2){
            return NavPanelLevelTwo.getHtmlEnd(pathToAppRoot, navButtons, currentNavButtonName, request);
        } else {
            return NavPanelLevelTwo.getHtmlEnd(pathToAppRoot, navButtons, currentNavButtonName, request);
        }
    }



    public int levelsNested(){
        //Safety in case pageProps.navButtonName is not set
//        if (this.currentNavButtonName==null){
//            this.currentNavButtonName = "adminhome";
//            reger.core.Util.logtodb("Navpanel.currentNavButtonName not set.");
//        }

        //Get the current NavButton
        NavButton currentNavButton = AllNavButtons.getByName(this.currentNavButtonName);
        //SafetyCounter prevents infinite loops created by poorly nested never-terminating nav sections
        int safetyCounter = 0;

        //Count number of levels
        int levelsNested = 0;

        while (true){
            //Debug.debug(5, "", "NavPanel While Loop.  <br>currentNavButton.navButtonName = " + currentNavButton.navButtonName);
            //Increment the safety counter
            safetyCounter = safetyCounter + 1;

            //Move to the parent of this button
            if (!currentNavButton.parentNavButton.equals("")){
                currentNavButton = AllNavButtons.getByName(currentNavButton.parentNavButton);
                levelsNested = levelsNested + 1;
            } else {
                break;
            }
            //For safety
            if (safetyCounter>=100){
                break;
            }

        }

        return levelsNested;
    }




}
