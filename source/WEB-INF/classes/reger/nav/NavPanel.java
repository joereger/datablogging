package reger.nav;

import reger.UserSession;
import reger.core.Debug;

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
        Debug.debug(5, "", "NavPanel Created.  <br>currentNavButtonName = " + currentNavButtonName + "<br>parentNavButton = " + parentNavButtonName);
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
        Debug.debug(5, "", "Custom NavPanel Created.  <br>currentNavButtonName = " + currentNavButtonName + "<br>parentNavButton = " + parentNavButtonName);
        navLevel = initialNavLevel;
        //this.navPanelConfig = new NavPanelConfig(levelsNested());

    }

    public String getHtmlStart(String pathToAppRoot, UserSession userSession){
        if (navLevel==0){
            return NavPanelLevelZero.getHtmlStart(pathToAppRoot, userSession, navButtons, currentNavButtonName);
        } else if (navLevel==1){
            return NavPanelLevelOne.getHtmlStart(pathToAppRoot, userSession, navButtons, currentNavButtonName);
        } else if (navLevel==2){
            return NavPanelLevelTwo.getHtmlStart(pathToAppRoot, userSession, navButtons, currentNavButtonName);
        } else {
            return NavPanelLevelTwo.getHtmlStart(pathToAppRoot, userSession, navButtons, currentNavButtonName);
        }
    }

    public String getHtmlEnd(String pathToAppRoot){
        if (navLevel==0){
            return NavPanelLevelZero.getHtmlEnd(pathToAppRoot, navButtons, currentNavButtonName);
        } else if (navLevel==1){
            return NavPanelLevelOne.getHtmlEnd(pathToAppRoot, navButtons, currentNavButtonName);
        } else if (navLevel==2){
            return NavPanelLevelTwo.getHtmlEnd(pathToAppRoot, navButtons, currentNavButtonName);
        } else {
            return NavPanelLevelTwo.getHtmlEnd(pathToAppRoot, navButtons, currentNavButtonName);
        }
    }

//    public String getHtmlStartOLD(String pathToAppRoot){
//        StringBuffer mb = new StringBuffer();
//
//        mb.append("<style>");
//        mb.append("\n");
//        mb.append("a:link	{ text-decoration: underline }");
//        mb.append("\n");
//        mb.append("a:visited { text-decoration: underline }");
//        mb.append("\n");
//        mb.append("a:hover { text-decoration: underline; }");
//        mb.append("\n");
//        mb.append(".adminbutton { color: "+navPanelConfig.fontcolor+"; font-size: 12px; font-family: Arial, Geneva, Helvetica, Swiss, SunSans-Regular;  text-decoration: none; letter-spacing: 0px; font-weight : bold;}");
//        mb.append("\n");
//        mb.append(".admintab{}");
//        mb.append("\n");
//        mb.append("td.admintab:hover { background: #ffffff; }");
//        mb.append("\n");
//        mb.append("</style>");
//        mb.append("\n");
//
//        //Need to create a count of buttons to display
//        //int numberofbuttons = navButtons.length;
//
//        mb.append("<table width=100% cellspacing=0 cellpadding=0 border=0>");
//        mb.append("<tr>");
//        //Inset from left col
//        mb.append("<td nowrap align=center width="+navPanelConfig.insetFromMargins+">");
//        mb.append("<img src="+pathToAppRoot+"images/clear.gif border=0 width="+navPanelConfig.insetFromMargins+" height=1>");
//        mb.append("</td>");
//        mb.append("<td nowrap align=center width=1>");
//        mb.append("<img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=0>");
//        mb.append("</td>");
//        mb.append("<td nowrap align=center width="+navPanelConfig.insetFromMargins+">");
//        mb.append("<img src="+pathToAppRoot+"images/clear.gif border=0 width="+navPanelConfig.insetFromMargins+" height=55>");
//        mb.append("</td>");
//        mb.append("<td rowspan=2 valign=bottom>");
//
//
//        mb.append("<!-- Start Navbar -->");
//        mb.append("<table cellspacing=0 cellpadding=0 border=0>");
//        mb.append("<tr>");
//        //Need one for each button
//        for(int i=0; i<navButtons.length; i++){
//            mb.append("<td bgcolor="+navPanelConfig.outlinecolor+" width=1><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//            mb.append("<td bgcolor="+navPanelConfig.outlinecolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//            mb.append("<td bgcolor="+navPanelConfig.outlinecolor+" width=1><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//            mb.append("<td width="+navPanelConfig.spaceBetweenTabs+"><img src="+pathToAppRoot+"images/clear.gif border=0 width="+navPanelConfig.spaceBetweenTabs+" height=1></td>");
//        }
//        mb.append("</tr>");
//        mb.append("<tr>");
//        //Need one for each button
//        String url = "";
//        String text = "";
//        String thisTabColor = "";
//        for(int i=0; i<navButtons.length; i++){
//            url = navButtons[i].buttonUrlFromSiteRoot;
//            text = navButtons[i].buttonTitle;
//            if (navButtons[i].navButtonName.equals(currentNavButtonName)){
//                thisTabColor = navPanelConfig.tabbgoncolor;
//            } else {
//                thisTabColor = navPanelConfig.tabbgoffcolor;
//            }
//            mb.append("<td bgcolor="+navPanelConfig.outlinecolor+" width=1><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//            mb.append("<td bgcolor="+thisTabColor+" class=admintab align=center height=21 onclick=\"document.location.href='"+pathToAppRoot+url+"'\">");
//            mb.append("<font face=arial size=-2><a href='"+pathToAppRoot+url+"' class=adminbutton>"+text+"</a></font>");
//            mb.append("</td>");
//            mb.append("<td bgcolor="+navPanelConfig.outlinecolor+" width=1><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//            mb.append("<td width="+navPanelConfig.spaceBetweenTabs+"><img src="+pathToAppRoot+"images/clear.gif border=0 width="+navPanelConfig.spaceBetweenTabs+" height=1></td>");
//        }
//        mb.append("</tr>");
//        mb.append("<tr>");
//        //Need one for each button
//        String linebgcolor = "";
//        for(int i=0; i<navButtons.length; i++){
//            linebgcolor = navPanelConfig.outlinecolor;
//            if (navButtons[i].navButtonName.equals(currentNavButtonName)){
//                linebgcolor = navPanelConfig.tabbgoncolor;
//            }
//            mb.append("<td bgcolor="+navPanelConfig.outlinecolor+" width=1><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//            mb.append("<td bgcolor="+linebgcolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//            mb.append("<td bgcolor="+navPanelConfig.outlinecolor+" width=1><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//            mb.append("<td bgcolor="+navPanelConfig.outlinecolor+" width="+navPanelConfig.spaceBetweenTabs+"><img src="+pathToAppRoot+"images/clear.gif border=0 width="+navPanelConfig.spaceBetweenTabs+" height=1></td>");
//        }
//        mb.append("</tr>");
//        mb.append("</table>");
//        mb.append("<!-- End Navbar -->");
//
//
//        mb.append("</td>");
//        mb.append("<td>");
//        mb.append("<img src="+pathToAppRoot+"images/clear.gif border=0 width="+navPanelConfig.insetFromMargins+" height=55>");
//        mb.append("</td>");
//        mb.append("<td nowrap align=center width=1>");
//        mb.append("<img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=0>");
//        mb.append("</td>");
//        //Inset from right col
//        mb.append("<td nowrap align=center width="+navPanelConfig.insetFromMargins+">");
//        mb.append("<img src="+pathToAppRoot+"images/clear.gif border=0 width="+navPanelConfig.insetFromMargins+" height=1>");
//        mb.append("</td>");
//        mb.append("</tr>");
//
//        //Line under buttons
//        mb.append("<tr>");
//        mb.append("<td><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td bgcolor="+navPanelConfig.outlinecolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td bgcolor="+navPanelConfig.outlinecolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td bgcolor="+navPanelConfig.outlinecolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td bgcolor="+navPanelConfig.outlinecolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("</tr>");
//
//        //Build side margins
//        mb.append("<tr>");
//        mb.append("<td width="+navPanelConfig.insetFromMargins+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td bgcolor="+navPanelConfig.outlinecolor+" width=1><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td bgcolor="+navPanelConfig.tabbgoncolor+" colspan='3'>");
//
//        //Body of page goes here
//
//        return mb.toString();
//    }


//    public String getHtmlEndOLD(String pathToAppRoot){
//        StringBuffer mb = new StringBuffer();
//
//        mb.append("</td>");
//        mb.append("<td bgcolor="+navPanelConfig.outlinecolor+" width=1><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td width="+navPanelConfig.insetFromMargins+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("</tr>");
//
//        //Line at bottom of NavPanel
//        mb.append("<tr>");
//        mb.append("<td><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td bgcolor="+navPanelConfig.outlinecolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td bgcolor="+navPanelConfig.tabbgoncolor+" colspan=3><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height="+navPanelConfig.insetFromMargins+"></td>");
//        mb.append("<td bgcolor="+navPanelConfig.outlinecolor+"><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("</tr>");
//
//        //Line at bottom of NavPanel
//        mb.append("<tr>");
//        mb.append("<td><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td bgcolor="+navPanelConfig.outlinecolor+" colspan=5><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("<td><img src="+pathToAppRoot+"images/clear.gif border=0 width=1 height=1></td>");
//        mb.append("</tr>");
//
//        mb.append("</table>");
//        return mb.toString();
//    }


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
            Debug.debug(5, "", "NavPanel While Loop.  <br>currentNavButton.navButtonName = " + currentNavButton.navButtonName);
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
