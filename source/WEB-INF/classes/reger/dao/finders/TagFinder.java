package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.TagDAO;

/**
 * Finder for the 'tag' DAO
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

public class TagFinder {


    public static ArrayList<TagDAO> findByTagid(int tagid) {
        return findByTagid(tagid, 0, 50000);
    }

    public static ArrayList<TagDAO> findByTagid(int tagid, int limitmin, int limitmax) {
        ArrayList<TagDAO> resultarraylist = new ArrayList<TagDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT tagid FROM tag WHERE tagid='"+tagid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TagDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TagDAO> findByTag(String tag) {
        return findByTag(tag, 0, 50000);
    }

    public static ArrayList<TagDAO> findByTag(String tag, int limitmin, int limitmax) {
        ArrayList<TagDAO> resultarraylist = new ArrayList<TagDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT tagid FROM tag WHERE tag='"+reger.core.Util.cleanForSQL(tag)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TagDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TagDAO> findByTagidTag(int tagid, String tag) {
        return findByTagidTag(tagid, tag, 0, 50000);
    }

    public static ArrayList<TagDAO> findByTagidTag(int tagid, String tag, int limitmin, int limitmax) {
        ArrayList<TagDAO> resultarraylist = new ArrayList<TagDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT tagid FROM tag WHERE tagid='"+tagid+"', tag='"+reger.core.Util.cleanForSQL(tag)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TagDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}