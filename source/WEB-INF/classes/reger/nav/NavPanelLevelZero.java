package reger.nav;

import reger.Accountuser;
import reger.UserSession;

import javax.servlet.http.HttpServletRequest;

/**
 * A NavPanel displays a tier of navigation
 */
public class NavPanelLevelZero {



    public static String getHtmlStart(String pathToAppRoot, UserSession userSession, NavButton[] navButtons, String currentNavButtonName, HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        mb.append("    <div class=\"navbar navbar-fixed-top\">" + "\n");
        mb.append("      <div class=\"navbar-inner\">" + "\n");
        mb.append("        <div class=\"container\">" + "\n");
        mb.append("            <ul class=\"nav navbar-nav\">" + "\n");

        //Need one for each button
        String url = "";
        String text = "";
        for(int i=0; i<navButtons.length; i++){
            if (navButtons[i].aclNameRequiredToShowButton.equals("") || (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && userSession.getAccountuser()!=null)){
                //Make sure the user has enough permissions to view this button
                if (navButtons[i].aclNameRequiredToShowButton.equals("") || userSession.getAccountuser().userCanDoAcl(navButtons[i].aclNameRequiredToShowButton, userSession.getAccount().getAccountid())){

                    url = pathToAppRoot + navButtons[i].buttonUrlFromSiteRoot + navButtons[i].getQueryStringIncludingRequestVars(request);
                    text = navButtons[i].buttonTitle;
                    String isOn = "";
                    if (navButtons[i].navButtonName.equals(currentNavButtonName)){
                        isOn = " class=\"active\"";
                    }

                    mb.append("                    <li "+isOn+">" + "\n");
                    mb.append("                        <a href=\""+url+"\">" + "\n");
                    mb.append("                        "+ text + "\n");
                    mb.append("                        </a>" + "\n");
                    mb.append("                    </li>" + "\n");

                }
            }
        }


        mb.append("                    <li>" + "\n");
        mb.append("                        <a href=\"../login.log?action=logout\">" + "\n");
        mb.append("                        log out" + "\n");
        mb.append("                        </a>" + "\n");
        mb.append("                    </li>" + "\n");

        mb.append("            </ul>" + "\n");






        mb.append("            <ul class=\"nav pull-right\">" + "\n");
        mb.append("                    <li>" + "\n");
        mb.append("                        <a href=\"../\">" + "\n");
        mb.append("                        visit your site" + "\n");
        mb.append("                        </a>" + "\n");
        mb.append("                    </li>" + "\n");
        mb.append("            </ul>" + "\n");


        mb.append("        </div>" + "\n");
        mb.append("      </div>" + "\n");
        mb.append("    </div>" + "\n");


        return mb.toString();
    }

    public static String getHtmlEnd(String pathToAppRoot, NavButton[] navButtons, String currentNavButtonName, HttpServletRequest request){
        StringBuffer mb = new StringBuffer();



        return mb.toString();
    }

}
