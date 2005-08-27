package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version26ToVersion27 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `imagetag` (`imagetagid` int(11) NOT NULL auto_increment, `tag` varchar(255) NOT NULL, PRIMARY KEY  (`imagetagid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `imagetagimagelink` (`imagetagimagelinkid` int(11) NOT NULL auto_increment, `imageid` int(11) NOT NULL, `imagetagid` int(11) NOT NULL, PRIMARY KEY  (`imagetagimagelinkid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------




            //Move imagecategories to imagetags
            //-----------------------------------
            //-----------------------------------
            String[][] rstImgCats= Db.RunSQL("SELECT imagecategory.imagecategoryid, imagecategory, imageid FROM image, imagecategory WHERE image.imagecategoryid=imagecategory.imagecategoryid");
            //-----------------------------------
            //-----------------------------------
            if (rstImgCats!=null && rstImgCats.length>0){
            	for(int i=0; i<rstImgCats.length; i++){
                    reger.ImageTag.saveImageTag(Integer.parseInt(rstImgCats[i][2]), rstImgCats[i][1]);
            	}
            }


            //-----------------------------------
            //-----------------------------------
            int count4 = Db.RunSQLUpdate("ALTER TABLE image DROP imagecategoryid");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count5 = Db.RunSQLUpdate("DROP TABLE imagecategory");
            //-----------------------------------
            //-----------------------------------



    }


}
