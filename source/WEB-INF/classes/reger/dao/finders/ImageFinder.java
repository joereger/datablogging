package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.ImageDAO;

/**
 * Finder for the 'image' DAO
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

public class ImageFinder {


    public static ArrayList<ImageDAO> findByImageid(int imageid) {
        return findByImageid(imageid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageid(int imageid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImage(String image) {
        return findByImage(image, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImage(String image, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE image='"+reger.core.Util.cleanForSQL(image)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByDescription(String description) {
        return findByDescription(description, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByDescription(String description, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findBySizeinbytes(int sizeinbytes) {
        return findBySizeinbytes(sizeinbytes, 0, 50000);
    }

    public static ArrayList<ImageDAO> findBySizeinbytes(int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByOrder(int order) {
        return findByOrder(order, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByOrder(int order, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByOriginalfilename(String originalfilename) {
        return findByOriginalfilename(originalfilename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByOriginalfilename(String originalfilename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE originalfilename='"+reger.core.Util.cleanForSQL(originalfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByFilename(String filename) {
        return findByFilename(filename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByFilename(String filename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageidEventid(int imageid, int eventid) {
        return findByImageidEventid(imageid, eventid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageidEventid(int imageid, int eventid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageidAccountuserid(int imageid, int accountuserid) {
        return findByImageidAccountuserid(imageid, accountuserid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageidAccountuserid(int imageid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageidImage(int imageid, String image) {
        return findByImageidImage(imageid, image, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageidImage(int imageid, String image, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid+"', image='"+reger.core.Util.cleanForSQL(image)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageidDescription(int imageid, String description) {
        return findByImageidDescription(imageid, description, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageidDescription(int imageid, String description, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageidSizeinbytes(int imageid, int sizeinbytes) {
        return findByImageidSizeinbytes(imageid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageidSizeinbytes(int imageid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageidOrder(int imageid, int order) {
        return findByImageidOrder(imageid, order, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageidOrder(int imageid, int order, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid+"', order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageidOriginalfilename(int imageid, String originalfilename) {
        return findByImageidOriginalfilename(imageid, originalfilename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageidOriginalfilename(int imageid, String originalfilename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid+"', originalfilename='"+reger.core.Util.cleanForSQL(originalfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageidAccountid(int imageid, int accountid) {
        return findByImageidAccountid(imageid, accountid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageidAccountid(int imageid, int accountid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageidFilename(int imageid, String filename) {
        return findByImageidFilename(imageid, filename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageidFilename(int imageid, String filename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid+"', filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByEventidAccountuserid(int eventid, int accountuserid) {
        return findByEventidAccountuserid(eventid, accountuserid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByEventidAccountuserid(int eventid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE eventid='"+eventid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByEventidImage(int eventid, String image) {
        return findByEventidImage(eventid, image, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByEventidImage(int eventid, String image, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE eventid='"+eventid+"', image='"+reger.core.Util.cleanForSQL(image)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByEventidDescription(int eventid, String description) {
        return findByEventidDescription(eventid, description, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByEventidDescription(int eventid, String description, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE eventid='"+eventid+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByEventidSizeinbytes(int eventid, int sizeinbytes) {
        return findByEventidSizeinbytes(eventid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByEventidSizeinbytes(int eventid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE eventid='"+eventid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByEventidOrder(int eventid, int order) {
        return findByEventidOrder(eventid, order, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByEventidOrder(int eventid, int order, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE eventid='"+eventid+"', order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByEventidOriginalfilename(int eventid, String originalfilename) {
        return findByEventidOriginalfilename(eventid, originalfilename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByEventidOriginalfilename(int eventid, String originalfilename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE eventid='"+eventid+"', originalfilename='"+reger.core.Util.cleanForSQL(originalfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByEventidAccountid(int eventid, int accountid) {
        return findByEventidAccountid(eventid, accountid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByEventidAccountid(int eventid, int accountid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE eventid='"+eventid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByEventidFilename(int eventid, String filename) {
        return findByEventidFilename(eventid, filename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByEventidFilename(int eventid, String filename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE eventid='"+eventid+"', filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByAccountuseridImage(int accountuserid, String image) {
        return findByAccountuseridImage(accountuserid, image, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByAccountuseridImage(int accountuserid, String image, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE accountuserid='"+accountuserid+"', image='"+reger.core.Util.cleanForSQL(image)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByAccountuseridDescription(int accountuserid, String description) {
        return findByAccountuseridDescription(accountuserid, description, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByAccountuseridDescription(int accountuserid, String description, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE accountuserid='"+accountuserid+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByAccountuseridSizeinbytes(int accountuserid, int sizeinbytes) {
        return findByAccountuseridSizeinbytes(accountuserid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByAccountuseridSizeinbytes(int accountuserid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE accountuserid='"+accountuserid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByAccountuseridOrder(int accountuserid, int order) {
        return findByAccountuseridOrder(accountuserid, order, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByAccountuseridOrder(int accountuserid, int order, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE accountuserid='"+accountuserid+"', order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByAccountuseridOriginalfilename(int accountuserid, String originalfilename) {
        return findByAccountuseridOriginalfilename(accountuserid, originalfilename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByAccountuseridOriginalfilename(int accountuserid, String originalfilename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE accountuserid='"+accountuserid+"', originalfilename='"+reger.core.Util.cleanForSQL(originalfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByAccountuseridAccountid(int accountuserid, int accountid) {
        return findByAccountuseridAccountid(accountuserid, accountid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByAccountuseridAccountid(int accountuserid, int accountid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE accountuserid='"+accountuserid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByAccountuseridFilename(int accountuserid, String filename) {
        return findByAccountuseridFilename(accountuserid, filename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByAccountuseridFilename(int accountuserid, String filename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE accountuserid='"+accountuserid+"', filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageDescription(String image, String description) {
        return findByImageDescription(image, description, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageDescription(String image, String description, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE image='"+reger.core.Util.cleanForSQL(image)+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageSizeinbytes(String image, int sizeinbytes) {
        return findByImageSizeinbytes(image, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageSizeinbytes(String image, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE image='"+reger.core.Util.cleanForSQL(image)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageOrder(String image, int order) {
        return findByImageOrder(image, order, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageOrder(String image, int order, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE image='"+reger.core.Util.cleanForSQL(image)+"', order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageOriginalfilename(String image, String originalfilename) {
        return findByImageOriginalfilename(image, originalfilename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageOriginalfilename(String image, String originalfilename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE image='"+reger.core.Util.cleanForSQL(image)+"', originalfilename='"+reger.core.Util.cleanForSQL(originalfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageAccountid(String image, int accountid) {
        return findByImageAccountid(image, accountid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageAccountid(String image, int accountid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE image='"+reger.core.Util.cleanForSQL(image)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByImageFilename(String image, String filename) {
        return findByImageFilename(image, filename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByImageFilename(String image, String filename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE image='"+reger.core.Util.cleanForSQL(image)+"', filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByDescriptionSizeinbytes(String description, int sizeinbytes) {
        return findByDescriptionSizeinbytes(description, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByDescriptionSizeinbytes(String description, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE description='"+reger.core.Util.cleanForSQL(description)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByDescriptionOrder(String description, int order) {
        return findByDescriptionOrder(description, order, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByDescriptionOrder(String description, int order, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE description='"+reger.core.Util.cleanForSQL(description)+"', order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByDescriptionOriginalfilename(String description, String originalfilename) {
        return findByDescriptionOriginalfilename(description, originalfilename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByDescriptionOriginalfilename(String description, String originalfilename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE description='"+reger.core.Util.cleanForSQL(description)+"', originalfilename='"+reger.core.Util.cleanForSQL(originalfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByDescriptionAccountid(String description, int accountid) {
        return findByDescriptionAccountid(description, accountid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByDescriptionAccountid(String description, int accountid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE description='"+reger.core.Util.cleanForSQL(description)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByDescriptionFilename(String description, String filename) {
        return findByDescriptionFilename(description, filename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByDescriptionFilename(String description, String filename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE description='"+reger.core.Util.cleanForSQL(description)+"', filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findBySizeinbytesOrder(int sizeinbytes, int order) {
        return findBySizeinbytesOrder(sizeinbytes, order, 0, 50000);
    }

    public static ArrayList<ImageDAO> findBySizeinbytesOrder(int sizeinbytes, int order, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE sizeinbytes='"+sizeinbytes+"', order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findBySizeinbytesOriginalfilename(int sizeinbytes, String originalfilename) {
        return findBySizeinbytesOriginalfilename(sizeinbytes, originalfilename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findBySizeinbytesOriginalfilename(int sizeinbytes, String originalfilename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE sizeinbytes='"+sizeinbytes+"', originalfilename='"+reger.core.Util.cleanForSQL(originalfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findBySizeinbytesAccountid(int sizeinbytes, int accountid) {
        return findBySizeinbytesAccountid(sizeinbytes, accountid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findBySizeinbytesAccountid(int sizeinbytes, int accountid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE sizeinbytes='"+sizeinbytes+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findBySizeinbytesFilename(int sizeinbytes, String filename) {
        return findBySizeinbytesFilename(sizeinbytes, filename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findBySizeinbytesFilename(int sizeinbytes, String filename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE sizeinbytes='"+sizeinbytes+"', filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByOrderOriginalfilename(int order, String originalfilename) {
        return findByOrderOriginalfilename(order, originalfilename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByOrderOriginalfilename(int order, String originalfilename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE order='"+order+"', originalfilename='"+reger.core.Util.cleanForSQL(originalfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByOrderAccountid(int order, int accountid) {
        return findByOrderAccountid(order, accountid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByOrderAccountid(int order, int accountid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE order='"+order+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByOrderFilename(int order, String filename) {
        return findByOrderFilename(order, filename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByOrderFilename(int order, String filename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE order='"+order+"', filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByOriginalfilenameAccountid(String originalfilename, int accountid) {
        return findByOriginalfilenameAccountid(originalfilename, accountid, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByOriginalfilenameAccountid(String originalfilename, int accountid, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE originalfilename='"+reger.core.Util.cleanForSQL(originalfilename)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByOriginalfilenameFilename(String originalfilename, String filename) {
        return findByOriginalfilenameFilename(originalfilename, filename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByOriginalfilenameFilename(String originalfilename, String filename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE originalfilename='"+reger.core.Util.cleanForSQL(originalfilename)+"', filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ImageDAO> findByAccountidFilename(int accountid, String filename) {
        return findByAccountidFilename(accountid, filename, 0, 50000);
    }

    public static ArrayList<ImageDAO> findByAccountidFilename(int accountid, String filename, int limitmin, int limitmax) {
        ArrayList<ImageDAO> resultarraylist = new ArrayList<ImageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE accountid='"+accountid+"', filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ImageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}