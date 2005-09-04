package reger.dwr;

import uk.ltd.getahead.dwr.ExecutionContext;

import javax.servlet.http.HttpServletRequest;

import reger.UserSession;
import reger.MegaLogType;
import reger.core.Debug;

/**
 * Saves field layout changes
 */
public class FieldLayoutSave {

    private UserSession userSession;

    public FieldLayoutSave(){
        Debug.debug(5, "DWR FieldLayoutSave", "FieldLayoutSave() object created.");
        HttpServletRequest request = ExecutionContext.get().getHttpServletRequest();
        reger.AllUserSessions allUserSessions = new reger.AllUserSessions();
        userSession = allUserSessions.getUserSession(request, null);
    }

    public String processLayoutChange(int logid, int eventtypeid, int megafieldid, String action, String fieldorderholder){
        Debug.debug(5, "DWR FieldLayoutSave", "FieldLayoutSave.processLayoutChange() called. action=" + action);
        //Security check
        boolean doUpdate = false;

        //Log security
        if (logid>0){
            if (userSession.getAccountuser().userCanViewLog(logid)){
                if (userSession.getAccountuser().userCanDoAcl("CUSTOMIZELOG", userSession.getAccount().getAccountid())){
                    doUpdate = true;
                }
            }
        }

        //Log type security
        if (eventtypeid>0){
            MegaLogType mlt = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid);
            if (mlt!=null){
                if (mlt.getAccountuserid()==userSession.getAccountuser().getAccountuserid()){
                    doUpdate = true;
                }
            }
        }

        //Do the update
        if (doUpdate){
            reger.mega.FieldLayout.processLayoutChange(logid, eventtypeid, megafieldid, action, fieldorderholder);
            return "Layout saved!";
        }

        //Default return
        return "Sorry, permission denied.";
    }


}
