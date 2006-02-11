package reger.scheduledtasks;

import reger.core.db.Db;
import reger.core.scheduler.ScheduledTask;
import reger.core.Debug;

/**
 * Gets the filesize and entry size and updates them.
 */
public class StorageSpaceUpdate implements ScheduledTask{


    private String result = "";

    public String getTaskName() {
        return "Storage Space Update";
    }

    public int getRunEveryXMinutes() {
        return 1600;
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

            //Update the image sizes
            recordsupdated = recordsupdated + updateImages();
            //Update the entry sizes
            recordsupdated = recordsupdated + updateEntries();
            //Update the message sizes
            recordsupdated = recordsupdated + updateMessages();
        } catch (Exception e){
            Debug.errorsave(e, "");
        }
        result = recordsupdated + " records updated.";
    }

    private static int updateImages(){
        int recordsupdated = 0;
        //Get images
        //-----------------------------------
        //-----------------------------------
        String[][] rstImages= Db.RunSQL("SELECT imageid, image, sizeinbytes FROM image");
        //-----------------------------------
        //-----------------------------------
        if (rstImages!=null && rstImages.length>0){
            for(int i=0; i<rstImages.length; i++){
                //Setup the vars
                int imageid = Integer.parseInt(rstImages[i][0]);
                String image = rstImages[i][1];
                long sizeinbytes = Long.parseLong(rstImages[i][2]);
                //Now go get the actual size from the file system
                java.io.File file = new java.io.File((String)reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA"), image);
                long sizereportedfromfilesystem = file.length();
                //If the two are different, update with the one from the file system
                if (sizeinbytes!=sizereportedfromfilesystem){
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("UPDATE image SET sizeinbytes='"+sizereportedfromfilesystem+"' WHERE imageid='"+imageid+"'");
                    //-----------------------------------
                    //-----------------------------------
                    recordsupdated=recordsupdated+count;
                }
            }
        }
        return recordsupdated;
    }

    private static int updateEntries(){
        int recordsupdated = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstEntries= Db.RunSQL("SELECT eventid, comments, sizeinbytes FROM event");
        //-----------------------------------
        //-----------------------------------
        if (rstEntries!=null && rstEntries.length>0){
            for(int i=0; i<rstEntries.length; i++){
                //Setup the vars
                int eventid = Integer.parseInt(rstEntries[i][0]);
                String comments = rstEntries[i][1];
                long sizeinbytes = Long.parseLong(rstEntries[i][2]);
                //Get the length
                long sizereportedfromtest = comments.length();
                //If the two are different, update with the one from the test
                if (sizeinbytes!=sizereportedfromtest){
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("UPDATE event SET sizeinbytes='"+sizereportedfromtest+"' WHERE eventid='"+eventid+"'");
                    //-----------------------------------
                    //-----------------------------------
                    recordsupdated=recordsupdated+count;
                }
            }
        }
        return recordsupdated;
    }

    private static int updateMessages(){
        int recordsupdated = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstMessage= Db.RunSQL("SELECT messageid, message, sizeinbytes FROM message");
        //-----------------------------------
        //-----------------------------------
        if (rstMessage!=null && rstMessage.length>0){
            for(int i=0; i<rstMessage.length; i++){
                //Setup the vars
                int messageid = Integer.parseInt(rstMessage[i][0]);
                String message = rstMessage[i][1];
                long sizeinbytes = Long.parseLong(rstMessage[i][2]);
                //Get the length
                long sizereportedfromtest = message.length();
                //If the two are different, update with the one from the test
                if (sizeinbytes!=sizereportedfromtest){
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("UPDATE message SET sizeinbytes='"+sizereportedfromtest+"' WHERE messageid='"+messageid+"'");
                    //-----------------------------------
                    //-----------------------------------
                    recordsupdated=recordsupdated+count;
                }
            }
        }
        return recordsupdated;
    }

}
