package reger;

import reger.core.db.Db;


/**
 * Represents an image tag.
 */
public class Tag {

    private int tagid = -1;
    private String tag = "";

    public Tag(int tagid){
        loadImageTag(tagid);
    }

    public Tag(String tag){
        this.tag = tag.toLowerCase();
    }

    public void loadImageTag(int tagid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstImgTag= Db.RunSQL("SELECT tagid, tag FROM tag WHERE tagid='"+tagid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstImgTag!=null && rstImgTag.length>0){
        	this.tagid = Integer.parseInt(rstImgTag[0][0]);
        	this.tag = rstImgTag[0][1].toLowerCase();
        }
    }

    public static int saveImageTag(int imageid, String tag){
        tag=tag.toLowerCase();
        if (!tag.equals("")){
            //reger.core.Util.logtodb("Tag.saveImageTag("+imageid+", "+tag+")");
            //First, see if the tag exists
            int tagid = gettagidFromTagText(tag);
            //reger.core.Util.logtodb("Checked for existing: tagid=" + tagid);
            if (tagid<0){
                //If not, create it
                //-----------------------------------
                //-----------------------------------
                tagid = Db.RunSQLInsert("INSERT INTO tag(tag) VALUES('"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(tag, 254))+"')");
                //-----------------------------------
                //-----------------------------------
            }
            //Next, see if the image has this tag associated with it yet
            //-----------------------------------
            //-----------------------------------
            String[][] rstImage= Db.RunSQL("SELECT tagimagelinkid, imageid, tagid FROM tagimagelink WHERE imageid='"+imageid+"' AND tagid='"+tagid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstImage!=null && rstImage.length>0){
                //If so, do nothing
                //reger.core.Util.logtodb("Nothing to do.");
            } else {
                //If not, create the association
                //reger.core.Util.logtodb("Creating the tagimagelink.");
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO tagimagelink(imageid, tagid) VALUES('"+imageid+"', '"+tagid+"')");
                //-----------------------------------
                //-----------------------------------
            }
            return tagid;
        } else {
            return -1;
        }
    }

    public static int gettagidFromTagText(String tag){
        tag=tag.toLowerCase();
        //-----------------------------------
        //-----------------------------------
        String[][] rstTag= Db.RunSQL("SELECT tagid FROM tag WHERE tag='"+reger.core.Util.cleanForSQL(tag)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTag!=null && rstTag.length>0){
        	return Integer.parseInt(rstTag[0][0]);
        } else {
            return -1;
        }
    }

    public static void removeAllImageTagsFromImage(int imageid){
        //First, find all tags associated with this imageid
        //-----------------------------------
        //-----------------------------------
        String[][] rstTags= Db.RunSQL("SELECT tagid FROM tagimagelink WHERE imageid='"+imageid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTags!=null && rstTags.length>0){
        	for(int i=0; i<rstTags.length; i++){
                //See if there are other imageids using this same tag
                //-----------------------------------
                //-----------------------------------
                String[][] rstCountTags= Db.RunSQL("SELECT tagimagelinkid FROM tagimagelink WHERE imageid<>'"+imageid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstCountTags!=null && rstCountTags.length>0){
                	//Leave the tag in place
                } else {
                    //Delete the tag itself
                    //-----------------------------------
                    //-----------------------------------
                    //int count = Db.RunSQLUpdate("DELETE FROM tag WHERE tagid='"+rstTags[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
        	}
        }

        //Delete any links for this imageid
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM tagimagelink WHERE imageid='"+imageid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    public static void addMultipleTagsToImage(String manytags, int imageid){

        //Remove any existing tags from the image
        removeAllImageTagsFromImage(imageid);
        
        if (manytags!=null){
            manytags=manytags.toLowerCase();
            //Break the manytags up into individual tags
            //String[] result = manytags.split("\\s");
            //for (int x=0; x<result.length; x++){
                //saveImageTag(imageid, result[x]);
            //}
            //@todo Uses StringTokenizer which may be deprecated in 1.5
            reger.TagParser itp = new reger.TagParser(manytags);
            String[] tags = itp.parseImageTagText();
            for (int i = 0; i < tags.length; i++) {
                saveImageTag(imageid, tags[i]);
            }
        }

    }

    public static Tag[] getAllTagsForImageid(int imageid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstTags= Db.RunSQL("SELECT tagid FROM tagimagelink WHERE imageid='"+imageid+"' ORDER BY tagimagelinkid ASC");
        //-----------------------------------
        //-----------------------------------
        Tag[] imageTags = new Tag[rstTags.length-1];
        if (rstTags!=null && rstTags.length>0){
        	for(int i=0; i<rstTags.length; i++){
        	    //Create a new image tag
        	    imageTags[i]=new reger.Tag(Integer.parseInt(rstTags[i][0]));
        	}
        }
        return imageTags;
    }

    public static String getStringOfAllTagsForImage(int imageid){
        String out = "";
        //-----------------------------------
        //-----------------------------------
        String[][] rstTags= Db.RunSQL("SELECT tag.tagid, tag FROM tagimagelink, tag WHERE tag.tagid=tagimagelink.tagid AND tagimagelink.imageid='"+imageid+"' ORDER BY tagimagelink.tagimagelinkid ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstTags!=null && rstTags.length>0){
        	for(int i=0; i<rstTags.length; i++){
        	    //Parse this tag to see if it's got multiple tokens in it
        	    reger.TagParser itp = new reger.TagParser(rstTags[i][1]);
                String[] tags = itp.parseImageTagText();
        	    //If there's a space, add quotes
        	    if (tags.length>1){
                    //Create a new image tag but quote it
        	        out = out + "\"" + rstTags[i][1] + "\" ";
                } else {
                    //Create a new image tag
        	        out = out + rstTags[i][1] + " ";
                }

        	}
        }
        return out.toLowerCase();
    }

    public static String getStringOfAllTagsForImageAsLinks(int imageid, String pathToAppRoot){
        String out = "";
        //-----------------------------------
        //-----------------------------------
        String[][] rstTags= Db.RunSQL("SELECT tag.tagid, tag FROM tagimagelink, tag WHERE tag.tagid=tagimagelink.tagid AND tagimagelink.imageid='"+imageid+"' ORDER BY tagimagelink.tagimagelinkid ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstTags!=null && rstTags.length>0){
        	for(int i=0; i<rstTags.length; i++){
                out = out + "<a href='"+pathToAppRoot+"files.log?tagid="+rstTags[i][0]+"&tag="+rstTags[i][1]+"'>" + rstTags[i][1] + "</a> ";
        	}
        }
        return out.toLowerCase();
    }

    public static String getTagsAndLinksHtml(int accountid, reger.UserSession userSessionOfViewer, boolean breakTagBetweenEach){
        String out = "";
        //(SELECT COUNT(*) FROM tagimagelink WHERE tagid=itid)
        //-----------------------------------
        //-----------------------------------
        String[][] rstTags= Db.RunSQL("SELECT DISTINCT tag.tagid, tag FROM image, tag, tagimagelink, event, account, megalog WHERE image.imageid=tagimagelink.imageid AND tagimagelink.tagid=tag.tagid AND image.eventid=event.eventid AND event.accountid=account.accountid AND account.accountid='"+accountid+"' AND event.logid=megalog.logid AND " + userSessionOfViewer.getAccountuser().LogsUserCanViewQueryend(accountid) + "ORDER BY tag ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstTags!=null && rstTags.length>0){
        	for(int i=0; i<rstTags.length; i++){
        	    out = out + "<a href='tag-detail.log?tagid="+rstTags[i][0]+"&tag="+rstTags[i][1]+"'>";
                out = out + "<font face=arial style=\"font-size: 12px;\">"+rstTags[i][1]+"</font>";
                out = out + "</a>";
                if (breakTagBetweenEach){
                    out = out + "<br>";
                } else {
                    out = out + " ";
                }
        	}
        }


        return out.toLowerCase();
    }
}
