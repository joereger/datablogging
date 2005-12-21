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

    public static Hashtable allOneClickTemplateSets;

    public void load(){
        allOneClickTemplateSets = new Hashtable();
        int i = 0;
        allOneClickTemplateSets.put(i++, new OneClickTemplateSet(i, -1, -101, 0, "Beautiful", WebAppRootDir.getWebAppRootPath()+"templates/site/beautiful/images/thumbnail.jpg"));
        allOneClickTemplateSets.put(i++, new OneClickTemplateSet(i, -2, -102, 0, "Branches", WebAppRootDir.getWebAppRootPath()+"templates/site/branches/images/thumbnail.jpg"));
        allOneClickTemplateSets.put(i++, new OneClickTemplateSet(i, -3, -103, 0, "Gothic Trees", WebAppRootDir.getWebAppRootPath()+"templates/site/gothictrees/images/thumbnail.jpg"));
        allOneClickTemplateSets.put(i++, new OneClickTemplateSet(i, -4, -104, 0, "Nigglish", WebAppRootDir.getWebAppRootPath()+"templates/site/nigglish/images/thumbnail.jpg"));
        allOneClickTemplateSets.put(i++, new OneClickTemplateSet(i, -5, -105, 0, "Spanish Vacation", WebAppRootDir.getWebAppRootPath()+"templates/site/spanishvacation/images/thumbnail.jpg"));

    }

    public Hashtable getAllOneClickTemplateSets(){
        if (allOneClickTemplateSets==null){
            load();
        }
        return allOneClickTemplateSets;
    }

    public OneClickTemplateSet get(int oneClickTemplateSetid){
        if (allOneClickTemplateSets==null){
            load();
        }
        return (OneClickTemplateSet)allOneClickTemplateSets.get(oneClickTemplateSetid);
    }




}
