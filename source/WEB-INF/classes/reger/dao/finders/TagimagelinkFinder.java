package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.TagimagelinkDAO;

/**
 * Finder for the 'tagimagelink' DAO
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

public class TagimagelinkFinder {


    public static ArrayList<TagimagelinkDAO> findByTagimagelinkid(int tagimagelinkid) {
        return findByTagimagelinkid(tagimagelinkid, 0, 50000);
    }

    public static ArrayList<TagimagelinkDAO> findByTagimagelinkid(int tagimagelinkid, int limitmin, int limitmax) {
        ArrayList<TagimagelinkDAO> resultarraylist = new ArrayList<TagimagelinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT tagimagelinkid FROM tagimagelink WHERE tagimagelinkid='"+tagimagelinkid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TagimagelinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TagimagelinkDAO> findByImageid(int imageid) {
        return findByImageid(imageid, 0, 50000);
    }

    public static ArrayList<TagimagelinkDAO> findByImageid(int imageid, int limitmin, int limitmax) {
        ArrayList<TagimagelinkDAO> resultarraylist = new ArrayList<TagimagelinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT tagimagelinkid FROM tagimagelink WHERE imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TagimagelinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TagimagelinkDAO> findByTagid(int tagid) {
        return findByTagid(tagid, 0, 50000);
    }

    public static ArrayList<TagimagelinkDAO> findByTagid(int tagid, int limitmin, int limitmax) {
        ArrayList<TagimagelinkDAO> resultarraylist = new ArrayList<TagimagelinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT tagimagelinkid FROM tagimagelink WHERE tagid='"+tagid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TagimagelinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TagimagelinkDAO> findByTagimagelinkidImageid(int tagimagelinkid, int imageid) {
        return findByTagimagelinkidImageid(tagimagelinkid, imageid, 0, 50000);
    }

    public static ArrayList<TagimagelinkDAO> findByTagimagelinkidImageid(int tagimagelinkid, int imageid, int limitmin, int limitmax) {
        ArrayList<TagimagelinkDAO> resultarraylist = new ArrayList<TagimagelinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT tagimagelinkid FROM tagimagelink WHERE tagimagelinkid='"+tagimagelinkid+"', imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TagimagelinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TagimagelinkDAO> findByTagimagelinkidTagid(int tagimagelinkid, int tagid) {
        return findByTagimagelinkidTagid(tagimagelinkid, tagid, 0, 50000);
    }

    public static ArrayList<TagimagelinkDAO> findByTagimagelinkidTagid(int tagimagelinkid, int tagid, int limitmin, int limitmax) {
        ArrayList<TagimagelinkDAO> resultarraylist = new ArrayList<TagimagelinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT tagimagelinkid FROM tagimagelink WHERE tagimagelinkid='"+tagimagelinkid+"', tagid='"+tagid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TagimagelinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TagimagelinkDAO> findByImageidTagid(int imageid, int tagid) {
        return findByImageidTagid(imageid, tagid, 0, 50000);
    }

    public static ArrayList<TagimagelinkDAO> findByImageidTagid(int imageid, int tagid, int limitmin, int limitmax) {
        ArrayList<TagimagelinkDAO> resultarraylist = new ArrayList<TagimagelinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT tagimagelinkid FROM tagimagelink WHERE imageid='"+imageid+"', tagid='"+tagid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TagimagelinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}