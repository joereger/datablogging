package reger.files;

import reger.Account;
import reger.core.db.Db;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * Used to represent a filesystem user file
 */
public class File {

    private java.io.File file;
    private Account account;
    private String filePathAndOrFilename;

    public File(Account account, String filePathAndOrFilename){
        this.account = account;
        this.filePathAndOrFilename = filePathAndOrFilename;
        file = new java.io.File(account.getPathToAccountFiles()+filePathAndOrFilename);
    }


    public void delete(){
        //Safety check to make sure nothing out of the account path is deleted
        if(file.getAbsolutePath().length()<account.getPathToAccountFiles().length()){
            return;
        }
        if (file.isFile()){
            //-----------------------------------
            //-----------------------------------
            String[][] rstImg= Db.RunSQL("SELECT imageid FROM image WHERE filename='"+reger.core.Util.cleanForSQL(filePathAndOrFilename)+"' AND accountid='"+account.getAccountid()+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstImg!=null && rstImg.length>0){
                for(int i=0; i<rstImg.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    int count2 = Db.RunSQLUpdate("DELETE FROM image WHERE imageid='"+rstImg[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        } else if (file.isDirectory()){
            //-----------------------------------
            //-----------------------------------
            String[][] rstImg= Db.RunSQL("SELECT imageid, filename FROM image WHERE accountid='"+account.getAccountid()+"' AND LEFT(filename, "+FilenameUtils.normalize(filePathAndOrFilename).length()+")='"+reger.core.Util.cleanForSQL(FilenameUtils.normalize(filePathAndOrFilename))+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstImg!=null && rstImg.length>0){
                for(int i=0; i<rstImg.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    int count2 = Db.RunSQLUpdate("DELETE FROM image WHERE imageid='"+rstImg[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }
        try{
            if (file.isFile()){
                String filename = FilenameUtils.getName(filePathAndOrFilename);
                String filepath = FilenameUtils.normalize(FilenameUtils.getPath(filePathAndOrFilename));
                String filenamebase = FilenameUtils.removeExtension(filename);
                String filenameextension = FilenameUtils.getExtension(filename);
                FileUtils.forceDelete(file);
                FileUtils.forceDelete(new java.io.File(account.getPathToAccountFiles()+filepath+".thumbnails/"+filename));
            } else if (file.isDirectory()){
                FileUtils.deleteDirectory(file);
            }
            file = null;
            filePathAndOrFilename = "";
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "File.java", "Unable to delete file and/or thumbnail.");
        }
    }


    public java.io.File getThumbnail(){
        String thumbfilename = FilenameUtils.getName(filePathAndOrFilename);
        String thumbfilepath = FilenameUtils.normalize(FilenameUtils.getPath(filePathAndOrFilename)) + ".thumbnails"+java.io.File.separator;
        java.io.File thumbnail = new java.io.File(account.getPathToAccountFiles()+thumbfilepath+thumbfilename);
        return thumbnail;
    }

    public void rename(String newPathAndFilename){
        move(newPathAndFilename);
    }

    public void move(String newPathAndFilename){
        reger.core.Debug.debug(5, "File.java", "move("+newPathAndFilename+") called");
        try{
            newPathAndFilename = FilenameUtils.normalize(newPathAndFilename);
            String newfilename = FilenameUtils.getName(newPathAndFilename);
            String newfilepath = FilenameUtils.normalize(FilenameUtils.getPath(newPathAndFilename));
            String newfilenamebase = FilenameUtils.removeExtension(newfilename);
            String newfilenameextension = FilenameUtils.getExtension(newfilename);

            reger.core.Debug.debug(5, "File.java", "newPathAndFilename="+newPathAndFilename+"<br>newfilename="+newfilename+"<br>newfilepath="+newfilepath+"<br>newfilenamebase="+newfilenamebase+"<br>newfilenameextension="+newfilenameextension);

            int index = 0;
            java.io.File newFile = new java.io.File(account.getPathToAccountFiles()+newfilepath+newfilename);
            while (newFile.exists()){
                index = index + 1;
                newfilename = newfilenamebase + "-" + index + "." + newfilenameextension;
                newFile = new java.io.File(account.getPathToAccountFiles()+newfilepath+newfilename);
            }

            reger.core.Debug.debug(3, "File.java", "newfilepath+newfilename="+newfilepath+newfilename);
    
            if (file.isFile()){
                String newthumbfilename = newfilename;
                String newthumbfilepath = newfilepath + ".thumbnails/";
                java.io.File dir = new java.io.File(newthumbfilepath);
                dir.mkdirs();
                java.io.File newthumbnail = new java.io.File(account.getPathToAccountFiles()+newthumbfilepath+newthumbfilename);
                FileUtils.copyFile(file, newFile, true);
                FileUtils.copyFile(getThumbnail(), newthumbnail, true);
                FileUtils.forceDelete(file);
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE image SET filename='"+reger.core.Util.cleanForSQL(newfilepath+newfilename)+"' WHERE accountid='"+account.getAccountid()+"' AND filename='"+reger.core.Util.cleanForSQL(filePathAndOrFilename)+"'");
                //-----------------------------------
                //-----------------------------------
            } else if (file.isDirectory()){
                FileUtils.copyDirectory(file, newFile, true);
                FileUtils.deleteDirectory(file);
                String dirSql = "SELECT imageid, filename FROM image WHERE accountid='"+account.getAccountid()+"' AND LEFT(filename, "+FilenameUtils.normalize(filePathAndOrFilename).length()+")='"+reger.core.Util.cleanForSQL(FilenameUtils.normalize(filePathAndOrFilename))+"'";
                reger.core.Debug.debug(3, "File.java", "dirSql=<br>"+dirSql);
                //-----------------------------------
                //-----------------------------------
                String[][] rstImg= Db.RunSQL(dirSql);
                //-----------------------------------
                //-----------------------------------
                if (rstImg!=null && rstImg.length>0){
                    for(int i=0; i<rstImg.length; i++){
                        int imageid = Integer.parseInt(rstImg[i][0]);
                        String currFilenameAndPath = FilenameUtils.normalize(rstImg[i][1]);
                        String currFilename = FilenameUtils.getName(currFilenameAndPath);
                        String currPath = FilenameUtils.getPath(currFilenameAndPath);
                        String currPathMinusPathOfRenamedDir = currPath.substring(FilenameUtils.normalize(filePathAndOrFilename).length(), currPath.length());
                        if (currPathMinusPathOfRenamedDir.length()>0){
                            currPathMinusPathOfRenamedDir = java.io.File.separator + currPathMinusPathOfRenamedDir;        
                        }
                        String newFilename = FilenameUtils.normalize(newfilepath+newfilename+currPathMinusPathOfRenamedDir+java.io.File.separator+currFilename);
                        //-----------------------------------
                        //-----------------------------------
                        int count = Db.RunSQLUpdate("UPDATE image SET filename='"+reger.core.Util.cleanForSQL(newFilename)+"' WHERE imageid='"+imageid+"'");
                        //-----------------------------------
                        //-----------------------------------
                    }
                }
            }
            this.filePathAndOrFilename = newfilepath + newfilename;
            file = new java.io.File(account.getPathToAccountFiles()+filePathAndOrFilename);

        } catch (Exception e){
            reger.core.Debug.errorsave(e, "File.java", "Unable to copy file.");
        }
    }




}
