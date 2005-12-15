package reger.nav;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;

/**
 * Nests NavPanels
 */
public class NestedNavPanels {

    String topHtml;
    String bottomHtml;

    public NestedNavPanels(PageProps pageProps, UserSession userSession, HttpServletRequest request){

        Debug.debug(5, "", "NestedNavPanels Created.  <br>pageProps.navButtonName = " + pageProps.navButtonName);

        //Reset the html vars
        topHtml="";
        bottomHtml="";

        //Safety in case pageProps.navButtonName is not set
        if (pageProps.navButtonName==null){
            pageProps.navButtonName = "";
            Debug.logtodb("PageProps.navButtonName not set.  PageProps.title=" + pageProps.title, "");
        }

        //Get the current NavButton
        NavButton currentNavButton = AllNavButtons.getByName(pageProps.navButtonName);
        //SafetyCounter prevents infinite loops created by poorly nested never-terminating nav sections
        int safetyCounter = 0;
        String[] navPathToLevelZero = new String[0];


        while (true){
            Debug.debug(5, "", "NestedNavPanels While Loop.  <br>currentNavButton.navButtonName = " + currentNavButton.navButtonName);
            //Add the current button
            navPathToLevelZero = reger.core.Util.addToStringArray(navPathToLevelZero, currentNavButton.navButtonName);
            //Increment the safety counter
            safetyCounter = safetyCounter + 1;
            //Move to the parent of this button
            if (!currentNavButton.parentNavButton.equals("")){
                currentNavButton = AllNavButtons.getByName(currentNavButton.parentNavButton);
            } else {
                break;
            }
            //For safety
            if (safetyCounter>=100){
                break;
            }

        }

        //At this point we have a breadcrumb trail back to level zero
        //Need to reverse the array so we're going from top level to bottom
        String[] navPathZeroToFinal = reger.core.Util.reverseStringArray(navPathToLevelZero);

        for (int i = 0; i < navPathZeroToFinal.length; i++) {
            //Get the current NavButton
            currentNavButton = AllNavButtons.getByName(navPathZeroToFinal[i]);
            //Create the navpanel
            NavPanel np = new NavPanel(currentNavButton.parentNavButton, currentNavButton.navButtonName);
            //Append the top and bottom. Note the order in which things are appended and prepended.
            topHtml = topHtml + np.getHtmlStart(pageProps.pathToAppRoot, userSession, request);
            bottomHtml =  np.getHtmlEnd(pageProps.pathToAppRoot, request) + bottomHtml;
        }


    }

    public String getTopHtml(){
        return topHtml;
    }

    public String getBottomHtml(){
        return bottomHtml;
    }


}
