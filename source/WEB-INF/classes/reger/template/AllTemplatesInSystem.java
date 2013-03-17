package reger.template;

import reger.core.db.Db;
import reger.AddToArray;
import reger.core.Debug;
import reger.core.WebAppRootDir;


import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.io.File;


/**
 * Static hold of all templates in system.
 */
public class AllTemplatesInSystem {

    private static Hashtable allTemplates;

    //This is where system default templates are set
    public static Template getSystemDefaultByType(int type){
        TemplateProcessor processor = TemplateProcessorFactory.getProcessorByType(type);
        if (processor!=null){
            String defaultTemplate = processor.getDefaultTemplate();
            Template tmp = new Template(defaultTemplate, type, 0, true, "Default Template");
            return tmp;
        }
        return null;
    }

    public AllTemplatesInSystem(){
        if (allTemplates==null){
            refresh();
        }
    }

    /**
     * Empties and then refreshes all templates in the system.
     */
    public static void refresh(){
        Debug.debug(5, "", "AllTemplatesInSystem.refresh().");
        allTemplates=null;
        allTemplates=new Hashtable();

        //First, figure out how many there are in the system
        int numberInSystem = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstCount= Db.RunSQL("SELECT count(*) FROM templatenew");
        //-----------------------------------
        //-----------------------------------
        if (rstCount!=null && rstCount.length>0){
            numberInSystem = Integer.parseInt(rstCount[0][0]);
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstTemplates= Db.RunSQL("SELECT templateid FROM templatenew", numberInSystem+1);
        //-----------------------------------
        //-----------------------------------
        if (rstTemplates!=null && rstTemplates.length>0){
            for(int i=0; i<rstTemplates.length; i++){
                Template template = new Template(Integer.parseInt(rstTemplates[i][0]));
                allTemplates.put(new Integer(Integer.parseInt(rstTemplates[i][0])), template);
            }
        }


        try{

            //Append the static templates from the filesystem.
            //MY GOSH MAN... WHAT WERE YOU THINKING?
            //DO NOT CHANGE THE HASHTABLE INDEXES OR THE TEMPLATEIDS
            //because they're stored in the database to reference the template.

            //Site Templates
            //allTemplates.put(-1, new Template(new File(WebAppRootDir.getWebAppRootPath()+"templates/site/beautiful/template.html"), -1, Template.TEMPLATETYPESITE, "Beautiful"));
            //allTemplates.put(-2, new Template(new File(WebAppRootDir.getWebAppRootPath()+"templates/site/branches/template.html"), -2, Template.TEMPLATETYPESITE, "Branches"));
            //allTemplates.put(-3, new Template(new File(WebAppRootDir.getWebAppRootPath()+"templates/site/gothictrees/template.html"), -3, Template.TEMPLATETYPESITE, "Gothic Trees"));
            //allTemplates.put(-4, new Template(new File(WebAppRootDir.getWebAppRootPath()+"templates/site/nigglish/template.html"), -4, Template.TEMPLATETYPESITE, "Nigglish"));
            //allTemplates.put(-5, new Template(new File(WebAppRootDir.getWebAppRootPath()+"templates/site/spanishvacation/template.html"), -5, Template.TEMPLATETYPESITE, "Spanish Vacation"));
            allTemplates.put(-6, new Template(new File(WebAppRootDir.getWebAppRootPath()+"templates/site/bigbgimage/template.html"), -6, Template.TEMPLATETYPESITE, "Background Slideshow"));

            //Entry Templates
            //allTemplates.put(-101, new Template(new File(WebAppRootDir.getWebAppRootPath()+"templates/entrylist/beautiful/template.html"), -101, Template.TEMPLATETYPEENTRYLIST, "Beautiful"));
            //allTemplates.put(-102, new Template(new File(WebAppRootDir.getWebAppRootPath()+"templates/entrylist/branches/template.html"), -102, Template.TEMPLATETYPEENTRYLIST, "Branches"));
            //allTemplates.put(-103, new Template(new File(WebAppRootDir.getWebAppRootPath()+"templates/entrylist/gothictrees/template.html"), -103, Template.TEMPLATETYPEENTRYLIST, "Gothic Trees"));
            //allTemplates.put(-104, new Template(new File(WebAppRootDir.getWebAppRootPath()+"templates/entrylist/nigglish/template.html"), -104, Template.TEMPLATETYPEENTRYLIST, "Nigglish"));
            //allTemplates.put(-105, new Template(new File(WebAppRootDir.getWebAppRootPath()+"templates/entrylist/spanishvacation/template.html"), -105, Template.TEMPLATETYPEENTRYLIST, "Spanish Vacation"));

        } catch (Exception e){
            reger.core.Debug.errorsave(e, "Failed to load a template from the filesystem: AllTemplatesInSystem.");
        }
    }

    public static void refresh(int templateid){
        Debug.debug(5, "AllTemplatesInSystem.java", "AllTemplatesInSystem.refresh(templateid="+templateid+").");
        //If it's null, refresh.  Generally won't happen.
        if (allTemplates==null){
            refresh();
        }

        allTemplates.remove(new Integer(templateid));

        //-----------------------------------
        //-----------------------------------
        String[][] rstTemplates= Db.RunSQL("SELECT templateid FROM templatenew WHERE templateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTemplates!=null && rstTemplates.length>0){
            for(int i=0; i<rstTemplates.length; i++){
                Template template = new Template(Integer.parseInt(rstTemplates[i][0]));
                allTemplates.put(new Integer(Integer.parseInt(rstTemplates[i][0])), template);
            }
        }
    }


    public static void removeTemplate(int templateid){
        allTemplates.remove(new Integer(templateid));
    }

    public static Template getTemplateByTemplateid(int templateid, int type){
        //If it's null, refresh.  Generally won't happen.
        if (allTemplates==null){
            refresh();
        }

        //See if it contains the logid. Most should get caught here.
        if (allTemplates.containsKey(new Integer(templateid))){
            return (Template)allTemplates.get(new Integer(templateid));
        }

        //If we still don't have it, return null.
        return getSystemDefaultByType(type);
    }


    public static Template[] getTemplatesByTypeAndAccountid(int type, int accountid){
        //If it's null, refresh.  Generally won't happen.
        if (allTemplates==null){
            refresh();
        }

        Template[] out = new Template[0];

        if (allTemplates!=null){
            for (Iterator i=allTemplates.entrySet().iterator(); i.hasNext(); ) {
                Map.Entry e = (Map.Entry) i.next();
                //out.println(e.getKey() + ": " + e.getValue());
                //Get each log
                Template template = (Template)e.getValue();
                if (template.getType()==type && template.getAccountid()==accountid){
                    out = AddToArray.addToTemplateArray(out, template);
                }

            }
        }


        return out;
    }

    public static Template[] getSystemTemplatesByType(int type){
        //If it's null, refresh.  Generally won't happen.
        if (allTemplates==null){
            refresh();
        }

        Template[] out = new Template[0];

        if (allTemplates!=null){
            for (Iterator i=allTemplates.entrySet().iterator(); i.hasNext(); ) {
                Map.Entry e = (Map.Entry) i.next();
                //out.println(e.getKey() + ": " + e.getValue());
                //Get each log
                Template template = (Template)e.getValue();
                if (template.getType()==type && template.getIssystemtemplate()){
                    out = AddToArray.addToTemplateArray(out, template);
                }

            }
        }

        return out;
    }

    public static Template[] getUserTemplatesByType(int type){
        //If it's null, refresh.  Generally won't happen.
        if (allTemplates==null){
            refresh();
        }

        Template[] out = new Template[0];

        if (allTemplates!=null){
            for (Iterator i=allTemplates.entrySet().iterator(); i.hasNext(); ) {
                Map.Entry e = (Map.Entry) i.next();
                //out.println(e.getKey() + ": " + e.getValue());
                //Get each log
                Template template = (Template)e.getValue();
                if (template.getType()==type && !template.getIssystemtemplate()){
                    out = AddToArray.addToTemplateArray(out, template);
                }

            }
        }

        return out;
    }


    public static String debugPrintHtmlListOfTemplates(){
        if (allTemplates==null){
            refresh();
        }

        StringBuffer out = new StringBuffer();

        if (allTemplates!=null){
            for (Iterator i=allTemplates.entrySet().iterator(); i.hasNext(); ) {
                Map.Entry e = (Map.Entry) i.next();
                //out.println(e.getKey() + ": " + e.getValue());
                //Get each log
                Template template = (Template)e.getValue();

                out.append("<br><b>"+template.getName() + "</b> - templateid=" + template.getTemplateid() + " - type=" + template.getType());

            }
        }

        return out.toString();
    }


}
