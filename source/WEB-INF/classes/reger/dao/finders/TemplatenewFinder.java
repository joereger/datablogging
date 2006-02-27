package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.TemplatenewDAO;

/**
 * Finder for the 'templatenew' DAO
 * 
 * DO NOT EDIT MANUALLY
 * 
 *   ______             ____  _____         _     ________        __   _   _   
 *  |_   _ `.          |_   \|_   _|       / |_  |_   __  |      |  ] (_) / |_ 
 *    | | `. \  .--.     |   \ | |   .--. `| |-'   | |_ \_|  .--.| |  __ `| |-'
 *    | |  | |/ .'`\ \   | |\ \| | / .'`\ \| |     |  _| _ / /'`\' | [  | | |  
 *   _| |_.' /| \__. |  _| |_\   |_| \__. || |,   _| |__/ || \__/  |  | | | |, 
 *  |______.'  '.__.'  |_____|\____|'.__.' \__/  |________| '.__.;__][___]\__/
 * 
 */

public class TemplatenewFinder {


    public static ArrayList<TemplatenewDAO> findByTemplateid(int templateid) {
        return findByTemplateid(templateid, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTemplateid(int templateid, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE templateid='"+templateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTemplate(String template) {
        return findByTemplate(template, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTemplate(String template, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE template='"+reger.core.Util.cleanForSQL(template)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByType(int type) {
        return findByType(type, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByType(int type, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE type='"+type+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByIssystemtemplate(boolean issystemtemplate) {
        return findByIssystemtemplate(issystemtemplate, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByIssystemtemplate(boolean issystemtemplate, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE issystemtemplate='"+reger.core.Util.booleanAsSQLText(issystemtemplate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByName(String name) {
        return findByName(name, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByName(String name, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTemplateidTemplate(int templateid, String template) {
        return findByTemplateidTemplate(templateid, template, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTemplateidTemplate(int templateid, String template, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE templateid='"+templateid+"', template='"+reger.core.Util.cleanForSQL(template)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTemplateidType(int templateid, int type) {
        return findByTemplateidType(templateid, type, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTemplateidType(int templateid, int type, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE templateid='"+templateid+"', type='"+type+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTemplateidAccountid(int templateid, int accountid) {
        return findByTemplateidAccountid(templateid, accountid, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTemplateidAccountid(int templateid, int accountid, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE templateid='"+templateid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTemplateidIssystemtemplate(int templateid, boolean issystemtemplate) {
        return findByTemplateidIssystemtemplate(templateid, issystemtemplate, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTemplateidIssystemtemplate(int templateid, boolean issystemtemplate, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE templateid='"+templateid+"', issystemtemplate='"+reger.core.Util.booleanAsSQLText(issystemtemplate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTemplateidName(int templateid, String name) {
        return findByTemplateidName(templateid, name, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTemplateidName(int templateid, String name, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE templateid='"+templateid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTemplateType(String template, int type) {
        return findByTemplateType(template, type, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTemplateType(String template, int type, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE template='"+reger.core.Util.cleanForSQL(template)+"', type='"+type+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTemplateAccountid(String template, int accountid) {
        return findByTemplateAccountid(template, accountid, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTemplateAccountid(String template, int accountid, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE template='"+reger.core.Util.cleanForSQL(template)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTemplateIssystemtemplate(String template, boolean issystemtemplate) {
        return findByTemplateIssystemtemplate(template, issystemtemplate, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTemplateIssystemtemplate(String template, boolean issystemtemplate, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE template='"+reger.core.Util.cleanForSQL(template)+"', issystemtemplate='"+reger.core.Util.booleanAsSQLText(issystemtemplate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTemplateName(String template, String name) {
        return findByTemplateName(template, name, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTemplateName(String template, String name, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE template='"+reger.core.Util.cleanForSQL(template)+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTypeAccountid(int type, int accountid) {
        return findByTypeAccountid(type, accountid, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTypeAccountid(int type, int accountid, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE type='"+type+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTypeIssystemtemplate(int type, boolean issystemtemplate) {
        return findByTypeIssystemtemplate(type, issystemtemplate, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTypeIssystemtemplate(int type, boolean issystemtemplate, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE type='"+type+"', issystemtemplate='"+reger.core.Util.booleanAsSQLText(issystemtemplate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByTypeName(int type, String name) {
        return findByTypeName(type, name, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByTypeName(int type, String name, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE type='"+type+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByAccountidIssystemtemplate(int accountid, boolean issystemtemplate) {
        return findByAccountidIssystemtemplate(accountid, issystemtemplate, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByAccountidIssystemtemplate(int accountid, boolean issystemtemplate, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE accountid='"+accountid+"', issystemtemplate='"+reger.core.Util.booleanAsSQLText(issystemtemplate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByAccountidName(int accountid, String name) {
        return findByAccountidName(accountid, name, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByAccountidName(int accountid, String name, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE accountid='"+accountid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TemplatenewDAO> findByIssystemtemplateName(boolean issystemtemplate, String name) {
        return findByIssystemtemplateName(issystemtemplate, name, 0, 50000);
    }

    public static ArrayList<TemplatenewDAO> findByIssystemtemplateName(boolean issystemtemplate, String name, int limitmin, int limitmax) {
        ArrayList<TemplatenewDAO> resultarraylist = new ArrayList<TemplatenewDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE issystemtemplate='"+reger.core.Util.booleanAsSQLText(issystemtemplate)+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TemplatenewDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}