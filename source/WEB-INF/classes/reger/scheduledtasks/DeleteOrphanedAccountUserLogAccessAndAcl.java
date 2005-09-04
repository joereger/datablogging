package reger.scheduledtasks;

import reger.core.db.Db;
import reger.core.scheduler.ScheduledTask;
import reger.core.Debug;

/**
 * Delete all invalid logaccess.  This can happen when crappy code is written
 * elsewhere, particularly in log delete scenarios.
 */

public class DeleteOrphanedAccountUserLogAccessAndAcl implements ScheduledTask{

    private String result = "";

    public String getTaskName() {
        return "Delete Orphaned AccountUserLogAccess and ACL";
    }

    public int getRunEveryXMinutes() {
        return 3600;
    }

    public boolean getOnlyRunOnceAtStartup() {
        return false;
    }

    public String getResult() {
        return result;
    }

    public void doTask(){
        int recordsupdated = 0;
        try {


            int count = 0;

            //Delete invalid logaccess entries where the log no longer exists
            //-----------------------------------
            //-----------------------------------
            String[][] rs= reger.core.db.Db.RunSQL("SELECT accountuserlogaccess.logid FROM accountuserlogaccess LEFT JOIN megalog ON accountuserlogaccess.logid=megalog.logid WHERE megalog.logid IS NULL");
            //-----------------------------------
            //-----------------------------------
            if (rs.length>0) {
                for(int i=0; i<rs.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    count = reger.core.db.Db.RunSQLUpdate("DELETE FROM accountuserlogaccess WHERE logid='"+ rs[i][0] +"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }


            //Delete invalid acls where the aclobject id no longer exists    
//            //-----------------------------------
//            //-----------------------------------
//            String[][] rs2= reger.core.Db.Db.RunSQL("SELECT accountuseracl.aclobjectid FROM accountuseracl LEFT JOIN aclobject ON accountuseracl.aclobjectid=aclobject.aclobjectid WHERE aclobject.aclobjectid IS NULL");
//            //-----------------------------------
//            //-----------------------------------
//            if (rs2.length>0) {
//                for(int i=0; i<rs2.length; i++){
//                    //-----------------------------------
//                    //-----------------------------------
//                    count = count + reger.core.Db.Db.RunSQLUpdate("DELETE FROM accountuseracl WHERE aclobjectid='"+ rs2[i][0] +"'");
//                    //-----------------------------------
//                    //-----------------------------------
//                }
//            }

            //-----------------------------------
            //-----------------------------------
            String[][] rstAcl= Db.RunSQL("SELECT DISTINCT aclobjectid FROM accountuseracl");
            //-----------------------------------
            //-----------------------------------
            if (rstAcl!=null && rstAcl.length>0){
                for(int i=0; i<rstAcl.length; i++){
                    if (reger.acl.AllAclObjects.getAclObjectById(Integer.parseInt(rstAcl[i][0]))==null){
                        //-----------------------------------
                        //-----------------------------------
                        count = count + reger.core.db.Db.RunSQLUpdate("DELETE FROM accountuseracl WHERE aclobjectid='"+ rstAcl[i][0] +"'");
                        //-----------------------------------
                        //-----------------------------------
                    }
                }
            }


            recordsupdated = count;

        } catch (Exception e){
            Debug.errorsave(e, "");
            result = "Error.  Check event log.";
        }
        result = recordsupdated + " records updated.";
    }


}
