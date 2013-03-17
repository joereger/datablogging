package reger.template;

import reger.core.WebAppRootDir;

import java.util.Hashtable;

/**
 * Collection of the one-click templates in the system.
 *
 * The oneClickTemplateSetid is not stored in the database.
 * Think of this as a utility class that helps users quickly
 * set three templateid's to values uniting their templates together
 * into one look.
 */
public class AllOneClickTemplateSets {

    private static Hashtable allOneClickTemplateSets;

    public static void load(){
        allOneClickTemplateSets = new Hashtable();
        allOneClickTemplateSets.put(0, new OneClickTemplateSet(0, 0, 0, 0, "Default System", WebAppRootDir.getWebAppRootPath()+"templates/site/default/images/thumbnail.jpg"));
        //allOneClickTemplateSets.put(1, new OneClickTemplateSet(1, -1, -101, 0, "Beautiful", WebAppRootDir.getWebAppRootPath()+"templates/site/beautiful/images/thumbnail.jpg"));
        //allOneClickTemplateSets.put(2, new OneClickTemplateSet(2, -2, -102, 0, "Branches", WebAppRootDir.getWebAppRootPath()+"templates/site/branches/images/thumbnail.jpg"));
        //allOneClickTemplateSets.put(3, new OneClickTemplateSet(3, -3, -103, 0, "Gothic Trees", WebAppRootDir.getWebAppRootPath()+"templates/site/gothictrees/images/thumbnail.jpg"));
        //allOneClickTemplateSets.put(4, new OneClickTemplateSet(4, -4, -104, 0, "Nigglish", WebAppRootDir.getWebAppRootPath()+"templates/site/nigglish/images/thumbnail.jpg"));
        //allOneClickTemplateSets.put(5, new OneClickTemplateSet(5, -5, -105, 0, "Spanish Vacation", WebAppRootDir.getWebAppRootPath()+"templates/site/spanishvacation/images/thumbnail.jpg"));

    }

    public static Hashtable getAllOneClickTemplateSets(){
        if (allOneClickTemplateSets==null){
            load();
        }
        return allOneClickTemplateSets;
    }

    public static OneClickTemplateSet get(int oneClickTemplateSetid){
        if (allOneClickTemplateSets==null){
            load();
        }
        return (OneClickTemplateSet)allOneClickTemplateSets.get(oneClickTemplateSetid);
    }




}
