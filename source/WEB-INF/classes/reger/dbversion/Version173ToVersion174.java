package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * This creates the base database if none exists.
 */
public class Version173ToVersion174 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){


        fixProd();



    }

    private static void fixProd() {
    try {
            //-----------------------------------
            //-----------------------------------
            String[][] rstTags = Db.RunSQL("select tagid, tag from tag");
            //-----------------------------------
            //-----------------------------------
            System.out.println("#####################################################");
            if ( (rstTags != null) && (rstTags.length > 0) ) {
                int index = 0;
                HashMap tagMap = new HashMap(rstTags.length);
                String[] tagArr = new String[rstTags.length];
                String[] htmlTagArr = new String[rstTags.length];
                String tag = null;
                String tagId = null;
                String imageId = null;
                for (int i=0;i<rstTags.length;i++) {
                    tagId = rstTags[i][0];
                    tag = rstTags[i][1];
                    tagMap.put(tagId, tag);
                    tagArr[index] = tag;
                    htmlTagArr[index] = tag;
                    index++;
                }
                String htmlTag = null;
                Set tagSet = null;
                Iterator iter = null;
                String tg = null;
                String tgId = null;
                HashMap tMap = new HashMap();
                HashMap htmltMap = new HashMap();
                for (int j=0;j<tagArr.length;j++) {
                    tag = tagArr[j];
                    if ( (tag.indexOf(">") > -1) || (tag.indexOf("<") > -1) || (tag.indexOf("/") > -1) || (tag.indexOf(";") > -1) || (tag.indexOf(":") > -1) || (tag.indexOf("=") > -1) || (tag.indexOf("-") > -1) || (tag.indexOf("?") > -1) || (tag.indexOf("&") > -1) || (tag.indexOf("tag-detail.log") > -1) ) {
                        tagSet = tagMap.keySet();
                        iter = tagSet.iterator();
                        while (iter.hasNext()) {
                            tgId = (String)iter.next();
                            tg = (String)tagMap.get(tgId);
                            if (tag.equals(tg)) {
                                htmltMap.put(tgId, tg);
                            }
                        }
                        for (int k=0;k<htmlTagArr.length;k++) {
                            htmlTag = htmlTagArr[k];
                            if ( (tag.indexOf(htmlTag) > -1) && (!tag.equals(htmlTag)) ) {
                                tagSet = tagMap.keySet();
                                iter = tagSet.iterator();
                                while (iter.hasNext()) {
                                    String tid = (String)iter.next();
                                    //tgId = (String)iter.next();
                                    tg = (String)tagMap.get(tid);
                                    if (tg.equals(htmlTag)) {
                                        tMap.put(tgId, tid);
                                    }
                                }
                            }
                        }
                    }
                }
                // Update the other tags.
                if (tMap.size() > 0) {
                    tagSet = tMap.keySet();
                    iter = tagSet.iterator();
                    while (iter.hasNext()) {
                        tgId = (String) iter.next();
                        String tid = (String) tMap.get(tgId);
                        //-----------------------------------
                        //-----------------------------------
                        int count = Db.RunSQLUpdate("update eventtaglink set tagid=" + tid + " where tagid=" + tgId);
                        //-----------------------------------
                        //-----------------------------------
                        //-----------------------------------
                        //-----------------------------------
                        count = Db.RunSQLUpdate("update tagimagelink set tagid=" + tid + " where tagid=" + tgId);
                        //-----------------------------------
                        //-----------------------------------
                    }
                }
                // Delete the html tags.
                if (htmltMap.size() > 0) {
                    tagSet = htmltMap.keySet();
                    iter = tagSet.iterator();
                    while (iter.hasNext()) {
                        tgId = (String) iter.next();
                        //-----------------------------------
                        //-----------------------------------
                        int count = Db.RunSQLUpdate("delete from tag where tagid=" + tgId);
                        //-----------------------------------
                        //-----------------------------------
                        //-----------------------------------
                        //-----------------------------------
                        String[][] rstImages = Db.RunSQL("select DISTINCT imageid from tagimagelink where tagid=" + tgId);
                        //-----------------------------------
                        //-----------------------------------
                        if ( (rstImages != null) && (rstImages.length > 0)) {
                            for (int j=0;j<rstImages.length;j++) {
                                //-----------------------------------
                                //-----------------------------------
                                count = Db.RunSQLUpdate("delete from tagimagelink where tagid=" + tgId + " and imageid=" + rstImages[j][0]);
                                //-----------------------------------
                                //-----------------------------------
                            }
                        }

                        //-----------------------------------
                        //-----------------------------------
                        String[][] rstEvents = Db.RunSQL("select DISTINCT eventid from eventtaglink where tagid=" + tgId);
                        //-----------------------------------
                        //-----------------------------------
                        if ( (rstEvents != null) && (rstEvents.length > 0)) {
                            for (int k=0;k<rstEvents.length;k++) {
                                //-----------------------------------
                                //-----------------------------------
                                count = Db.RunSQLUpdate("delete from eventtaglink where tagid=" + tgId + " and eventid=" + rstEvents[k][0]);
                                //-----------------------------------
                                //-----------------------------------
                            }
                        }
                    }
                }
            }
            System.out.println("#####################################################");
        } catch (Exception e) {
            reger.core.Debug.errorsave(e, "Version173ToVersion174.java", "Exception removing html from tags.");
        }
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
