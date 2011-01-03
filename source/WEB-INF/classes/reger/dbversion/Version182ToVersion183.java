package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.File;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * This creates the base database if none exists.
 */
public class Version182ToVersion183 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("ALTER TABLE image ADD filename longtext");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        String[][] rstUlDir= Db.RunSQL("SELECT propertyvalue FROM systemproperty WHERE propertyname='PATHUPLOADMEDIA'");
        //-----------------------------------
        //-----------------------------------
        String pathuploadmedia = "C:\\blogserver-data\\";
        if (rstUlDir!=null && rstUlDir.length>0){
            pathuploadmedia = rstUlDir[0][0];
        }
        if(pathuploadmedia.length()>1){
            if (pathuploadmedia.substring(pathuploadmedia.length()-1).equals("/") || pathuploadmedia.substring(pathuploadmedia.length()-1).equals("\\")){
                pathuploadmedia =  pathuploadmedia.substring(0, pathuploadmedia.length()-1);
            }
        }

        StringBuffer debug = new StringBuffer();
        debug.append("Beginning file location change:");
        debug.append("<br>pathuploadmedia="+pathuploadmedia);


        //-----------------------------------
        //-----------------------------------
        String[][] rstImage= Db.RunSQL("SELECT imageid, event.accountid, image, originalfilename, event.date FROM image, event WHERE image.eventid=event.eventid ORDER BY imageid ASC", 500000);
        //-----------------------------------
        //-----------------------------------
        if (rstImage!=null && rstImage.length>0){
            for(int i=0; i<rstImage.length; i++){
                int imageid = Integer.parseInt(rstImage[i][0]);
                int accountid = Integer.parseInt(rstImage[i][1]);
                String currentFilename = rstImage[i][2];
                String originalFilename = rstImage[i][3];
                Calendar cal = reger.core.TimeUtils.dbstringtocalendar(rstImage[i][4]);
                cal = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(cal, "GMT", "EST");

                //Load the old file
                File oldFile = new File(pathuploadmedia + "/" + currentFilename);
                File oldFileThumbnail = new File(pathuploadmedia + "/thumbnails/" + currentFilename);
                reger.core.Debug.debug(5, "Version182ToVersion183.java", "Tried to create oldFile with<br>" + pathuploadmedia + "/" + currentFilename);
                if (oldFile.exists() && oldFile.canRead()){

                    //Calculate the new dated directory name
                    //Calendar cal = Calendar.getInstance();
                    //cal.setTimeInMillis(oldFile.lastModified());
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH)+1;
                    String monthStr = String.valueOf(month);
                    if (monthStr.length()==1){
                        monthStr = "0"+monthStr;
                    }
                    String datedDirectoryName = year+"/"+monthStr;

                    //Create directory
                    String filesdirectory = pathuploadmedia + java.io.File.separator +"files" + java.io.File.separator + accountid + java.io.File.separator + datedDirectoryName + java.io.File.separator;
                    File dir = new File(filesdirectory);
                    dir.mkdirs();
                    File dirThumbs = new File(filesdirectory+".thumbnails/");
                    dirThumbs.mkdirs();

                    //Name of new file
                    String newFilename = originalFilename;
                    if(originalFilename.equals("")){
                        newFilename = currentFilename;
                    }

                    //Make sure file doesn't already exist
                    int index = 0;
                    String finalNewFileName = newFilename;
                    String incomingname = newFilename;
                    String incomingnamebase = reger.core.Util.getFilenameBase(incomingname);
                    String incomingnameext = reger.core.Util.getFilenameExtension(incomingname);

                    File newFile = new File(filesdirectory+finalNewFileName);
                    File newFileThumbnail = new File(filesdirectory+".thumbnails/"+finalNewFileName);
                    while(newFile.exists()){
                        index=index+1;
                        finalNewFileName = incomingnamebase + "-" + index;
                        if (!incomingnameext.equals("")){
                            finalNewFileName = finalNewFileName + "." + incomingnameext;
                        }
                        newFile = new File(filesdirectory+finalNewFileName);
                        newFileThumbnail = new File(filesdirectory+".thumbnails/"+finalNewFileName);
                    }

                    //Do the copy
                    try{
                        FileUtils.copyFile(oldFile, newFile, true);
                        FileUtils.copyFile(oldFileThumbnail, newFileThumbnail, true);
                    } catch (Exception e){
                        reger.core.Debug.errorsave(e, "Version182ToVersion183.java", "Problem copying:<br>oldFile=" +oldFile.getAbsolutePath()+"<br>newFile="+newFile.getAbsolutePath());
                    }

                    debug.append("<br>");
                    debug.append("<br>currentFilename="+currentFilename);
                    debug.append("<br>originalFilename="+originalFilename);
                    debug.append("<br>filename="+FilenameUtils.normalize(datedDirectoryName+java.io.File.separator+finalNewFileName));
                    debug.append("<br>UPDATE image SET filename='"+ reger.core.Util.cleanForSQL(FilenameUtils.normalize(datedDirectoryName+java.io.File.separator+finalNewFileName))+"' WHERE imageid='"+imageid+"'");

                    //Update the image table
                    //-----------------------------------
                    //-----------------------------------
                    int count2 = Db.RunSQLUpdate("UPDATE image SET filename='"+ reger.core.Util.cleanForSQL(FilenameUtils.normalize(datedDirectoryName+java.io.File.separator+finalNewFileName))+"' WHERE imageid='"+imageid+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }
        reger.core.Debug.logtodb(debug.toString(), "Version182ToVersion183.java");
    }

    //Sample sql statements

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("CREATE TABLE `pltemplate` (`pltemplateid` int(11) NOT NULL auto_increment, logid int(11), plid int(11), type int(11), templateid int(11), PRIMARY KEY  (`pltemplateid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
    //-----------------------------------
    //-----------------------------------

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("ALTER TABLE megachart CHANGE daterangesavedsearchid daterangesavedsearchid int(11) NOT NULL default '0'");
    //-----------------------------------
    //-----------------------------------

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("ALTER TABLE account DROP gps");
    //-----------------------------------
    //-----------------------------------

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("ALTER TABLE megalogtype ADD isprivate int(11) NOT NULL default '0'");
    //-----------------------------------
    //-----------------------------------

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("DROP TABLE megafielduser");
    //-----------------------------------
    //-----------------------------------

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("CREATE INDEX name_of_index ON table (field1, field2)");
    //-----------------------------------
    //-----------------------------------


}
