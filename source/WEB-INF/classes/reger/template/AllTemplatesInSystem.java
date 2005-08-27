package reger.template;

import reger.core.db.Db;
import reger.Log;
import reger.PrivateLabel;
import reger.AddToArray;
import reger.core.db.Db;


import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;


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
        reger.core.Util.debug(5, "AllTemplatesInSystem.refresh().");
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
    }

    public static void refresh(int templateid){
        reger.core.Util.debug(5, "AllTemplatesInSystem.refresh(templateid="+templateid+").");
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

//    public static Template getTemplateByTemplateid(int templateid){
//        //If it's null, refresh.  Generally won't happen.
//        if (allTemplates==null){
//            refresh();
//        }
//
//        //See if it contains the logid. Most should get caught here.
//        if (allTemplates.containsKey(new Integer(templateid))){
//            return (Template)allTemplates.get(new Integer(templateid));
//        }
//
//        //If we still don't have it, return null.
//        return null;
//    }

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





}
