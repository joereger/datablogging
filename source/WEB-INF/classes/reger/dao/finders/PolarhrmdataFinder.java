package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PolarhrmdataDAO;

/**
 * Finder for the 'polarhrmdata' DAO
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

public class PolarhrmdataFinder {


    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataid(int polarhrmdataid) {
        return findByPolarhrmdataid(polarhrmdataid, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataid(int polarhrmdataid, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmid(int polarhrmid) {
        return findByPolarhrmid(polarhrmid, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmid(int polarhrmid, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmid='"+polarhrmid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinseconds(int timeinseconds) {
        return findByTimeinseconds(timeinseconds, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinseconds(int timeinseconds, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE timeinseconds='"+timeinseconds+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartrate(int heartrate) {
        return findByHeartrate(heartrate, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartrate(int heartrate, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE heartrate='"+heartrate+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeed(double speed) {
        return findBySpeed(speed, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeed(double speed, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE speed='"+String.valueOf(speed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByCadence(double cadence) {
        return findByCadence(cadence, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByCadence(double cadence, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE cadence='"+String.valueOf(cadence)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByAltitude(double altitude) {
        return findByAltitude(altitude, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByAltitude(double altitude, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE altitude='"+String.valueOf(altitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPower(double power) {
        return findByPower(power, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPower(double power, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE power='"+String.valueOf(power)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByLeftpowerbalance(double leftpowerbalance) {
        return findByLeftpowerbalance(leftpowerbalance, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByLeftpowerbalance(double leftpowerbalance, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE leftpowerbalance='"+String.valueOf(leftpowerbalance)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPedalingindex(double pedalingindex) {
        return findByPedalingindex(pedalingindex, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPedalingindex(double pedalingindex, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE pedalingindex='"+String.valueOf(pedalingindex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidPolarhrmid(int polarhrmdataid, int polarhrmid) {
        return findByPolarhrmdataidPolarhrmid(polarhrmdataid, polarhrmid, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidPolarhrmid(int polarhrmdataid, int polarhrmid, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"', polarhrmid='"+polarhrmid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidTimeinseconds(int polarhrmdataid, int timeinseconds) {
        return findByPolarhrmdataidTimeinseconds(polarhrmdataid, timeinseconds, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidTimeinseconds(int polarhrmdataid, int timeinseconds, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"', timeinseconds='"+timeinseconds+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidHeartrate(int polarhrmdataid, int heartrate) {
        return findByPolarhrmdataidHeartrate(polarhrmdataid, heartrate, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidHeartrate(int polarhrmdataid, int heartrate, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"', heartrate='"+heartrate+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidSpeed(int polarhrmdataid, double speed) {
        return findByPolarhrmdataidSpeed(polarhrmdataid, speed, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidSpeed(int polarhrmdataid, double speed, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"', speed='"+String.valueOf(speed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidCadence(int polarhrmdataid, double cadence) {
        return findByPolarhrmdataidCadence(polarhrmdataid, cadence, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidCadence(int polarhrmdataid, double cadence, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"', cadence='"+String.valueOf(cadence)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidAltitude(int polarhrmdataid, double altitude) {
        return findByPolarhrmdataidAltitude(polarhrmdataid, altitude, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidAltitude(int polarhrmdataid, double altitude, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"', altitude='"+String.valueOf(altitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidPower(int polarhrmdataid, double power) {
        return findByPolarhrmdataidPower(polarhrmdataid, power, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidPower(int polarhrmdataid, double power, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"', power='"+String.valueOf(power)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidLeftpowerbalance(int polarhrmdataid, double leftpowerbalance) {
        return findByPolarhrmdataidLeftpowerbalance(polarhrmdataid, leftpowerbalance, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidLeftpowerbalance(int polarhrmdataid, double leftpowerbalance, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"', leftpowerbalance='"+String.valueOf(leftpowerbalance)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidPedalingindex(int polarhrmdataid, double pedalingindex) {
        return findByPolarhrmdataidPedalingindex(polarhrmdataid, pedalingindex, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmdataidPedalingindex(int polarhrmdataid, double pedalingindex, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"', pedalingindex='"+String.valueOf(pedalingindex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidTimeinseconds(int polarhrmid, int timeinseconds) {
        return findByPolarhrmidTimeinseconds(polarhrmid, timeinseconds, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidTimeinseconds(int polarhrmid, int timeinseconds, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmid='"+polarhrmid+"', timeinseconds='"+timeinseconds+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidHeartrate(int polarhrmid, int heartrate) {
        return findByPolarhrmidHeartrate(polarhrmid, heartrate, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidHeartrate(int polarhrmid, int heartrate, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmid='"+polarhrmid+"', heartrate='"+heartrate+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidSpeed(int polarhrmid, double speed) {
        return findByPolarhrmidSpeed(polarhrmid, speed, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidSpeed(int polarhrmid, double speed, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmid='"+polarhrmid+"', speed='"+String.valueOf(speed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidCadence(int polarhrmid, double cadence) {
        return findByPolarhrmidCadence(polarhrmid, cadence, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidCadence(int polarhrmid, double cadence, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmid='"+polarhrmid+"', cadence='"+String.valueOf(cadence)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidAltitude(int polarhrmid, double altitude) {
        return findByPolarhrmidAltitude(polarhrmid, altitude, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidAltitude(int polarhrmid, double altitude, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmid='"+polarhrmid+"', altitude='"+String.valueOf(altitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidPower(int polarhrmid, double power) {
        return findByPolarhrmidPower(polarhrmid, power, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidPower(int polarhrmid, double power, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmid='"+polarhrmid+"', power='"+String.valueOf(power)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidLeftpowerbalance(int polarhrmid, double leftpowerbalance) {
        return findByPolarhrmidLeftpowerbalance(polarhrmid, leftpowerbalance, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidLeftpowerbalance(int polarhrmid, double leftpowerbalance, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmid='"+polarhrmid+"', leftpowerbalance='"+String.valueOf(leftpowerbalance)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidPedalingindex(int polarhrmid, double pedalingindex) {
        return findByPolarhrmidPedalingindex(polarhrmid, pedalingindex, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPolarhrmidPedalingindex(int polarhrmid, double pedalingindex, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmid='"+polarhrmid+"', pedalingindex='"+String.valueOf(pedalingindex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsHeartrate(int timeinseconds, int heartrate) {
        return findByTimeinsecondsHeartrate(timeinseconds, heartrate, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsHeartrate(int timeinseconds, int heartrate, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE timeinseconds='"+timeinseconds+"', heartrate='"+heartrate+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsSpeed(int timeinseconds, double speed) {
        return findByTimeinsecondsSpeed(timeinseconds, speed, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsSpeed(int timeinseconds, double speed, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE timeinseconds='"+timeinseconds+"', speed='"+String.valueOf(speed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsCadence(int timeinseconds, double cadence) {
        return findByTimeinsecondsCadence(timeinseconds, cadence, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsCadence(int timeinseconds, double cadence, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE timeinseconds='"+timeinseconds+"', cadence='"+String.valueOf(cadence)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsAltitude(int timeinseconds, double altitude) {
        return findByTimeinsecondsAltitude(timeinseconds, altitude, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsAltitude(int timeinseconds, double altitude, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE timeinseconds='"+timeinseconds+"', altitude='"+String.valueOf(altitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsPower(int timeinseconds, double power) {
        return findByTimeinsecondsPower(timeinseconds, power, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsPower(int timeinseconds, double power, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE timeinseconds='"+timeinseconds+"', power='"+String.valueOf(power)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsLeftpowerbalance(int timeinseconds, double leftpowerbalance) {
        return findByTimeinsecondsLeftpowerbalance(timeinseconds, leftpowerbalance, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsLeftpowerbalance(int timeinseconds, double leftpowerbalance, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE timeinseconds='"+timeinseconds+"', leftpowerbalance='"+String.valueOf(leftpowerbalance)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsPedalingindex(int timeinseconds, double pedalingindex) {
        return findByTimeinsecondsPedalingindex(timeinseconds, pedalingindex, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByTimeinsecondsPedalingindex(int timeinseconds, double pedalingindex, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE timeinseconds='"+timeinseconds+"', pedalingindex='"+String.valueOf(pedalingindex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartrateSpeed(int heartrate, double speed) {
        return findByHeartrateSpeed(heartrate, speed, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartrateSpeed(int heartrate, double speed, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE heartrate='"+heartrate+"', speed='"+String.valueOf(speed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartrateCadence(int heartrate, double cadence) {
        return findByHeartrateCadence(heartrate, cadence, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartrateCadence(int heartrate, double cadence, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE heartrate='"+heartrate+"', cadence='"+String.valueOf(cadence)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartrateAltitude(int heartrate, double altitude) {
        return findByHeartrateAltitude(heartrate, altitude, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartrateAltitude(int heartrate, double altitude, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE heartrate='"+heartrate+"', altitude='"+String.valueOf(altitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartratePower(int heartrate, double power) {
        return findByHeartratePower(heartrate, power, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartratePower(int heartrate, double power, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE heartrate='"+heartrate+"', power='"+String.valueOf(power)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartrateLeftpowerbalance(int heartrate, double leftpowerbalance) {
        return findByHeartrateLeftpowerbalance(heartrate, leftpowerbalance, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartrateLeftpowerbalance(int heartrate, double leftpowerbalance, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE heartrate='"+heartrate+"', leftpowerbalance='"+String.valueOf(leftpowerbalance)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartratePedalingindex(int heartrate, double pedalingindex) {
        return findByHeartratePedalingindex(heartrate, pedalingindex, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByHeartratePedalingindex(int heartrate, double pedalingindex, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE heartrate='"+heartrate+"', pedalingindex='"+String.valueOf(pedalingindex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeedCadence(double speed, double cadence) {
        return findBySpeedCadence(speed, cadence, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeedCadence(double speed, double cadence, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE speed='"+String.valueOf(speed)+"', cadence='"+String.valueOf(cadence)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeedAltitude(double speed, double altitude) {
        return findBySpeedAltitude(speed, altitude, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeedAltitude(double speed, double altitude, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE speed='"+String.valueOf(speed)+"', altitude='"+String.valueOf(altitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeedPower(double speed, double power) {
        return findBySpeedPower(speed, power, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeedPower(double speed, double power, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE speed='"+String.valueOf(speed)+"', power='"+String.valueOf(power)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeedLeftpowerbalance(double speed, double leftpowerbalance) {
        return findBySpeedLeftpowerbalance(speed, leftpowerbalance, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeedLeftpowerbalance(double speed, double leftpowerbalance, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE speed='"+String.valueOf(speed)+"', leftpowerbalance='"+String.valueOf(leftpowerbalance)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeedPedalingindex(double speed, double pedalingindex) {
        return findBySpeedPedalingindex(speed, pedalingindex, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findBySpeedPedalingindex(double speed, double pedalingindex, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE speed='"+String.valueOf(speed)+"', pedalingindex='"+String.valueOf(pedalingindex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByCadenceAltitude(double cadence, double altitude) {
        return findByCadenceAltitude(cadence, altitude, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByCadenceAltitude(double cadence, double altitude, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE cadence='"+String.valueOf(cadence)+"', altitude='"+String.valueOf(altitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByCadencePower(double cadence, double power) {
        return findByCadencePower(cadence, power, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByCadencePower(double cadence, double power, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE cadence='"+String.valueOf(cadence)+"', power='"+String.valueOf(power)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByCadenceLeftpowerbalance(double cadence, double leftpowerbalance) {
        return findByCadenceLeftpowerbalance(cadence, leftpowerbalance, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByCadenceLeftpowerbalance(double cadence, double leftpowerbalance, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE cadence='"+String.valueOf(cadence)+"', leftpowerbalance='"+String.valueOf(leftpowerbalance)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByCadencePedalingindex(double cadence, double pedalingindex) {
        return findByCadencePedalingindex(cadence, pedalingindex, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByCadencePedalingindex(double cadence, double pedalingindex, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE cadence='"+String.valueOf(cadence)+"', pedalingindex='"+String.valueOf(pedalingindex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByAltitudePower(double altitude, double power) {
        return findByAltitudePower(altitude, power, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByAltitudePower(double altitude, double power, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE altitude='"+String.valueOf(altitude)+"', power='"+String.valueOf(power)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByAltitudeLeftpowerbalance(double altitude, double leftpowerbalance) {
        return findByAltitudeLeftpowerbalance(altitude, leftpowerbalance, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByAltitudeLeftpowerbalance(double altitude, double leftpowerbalance, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE altitude='"+String.valueOf(altitude)+"', leftpowerbalance='"+String.valueOf(leftpowerbalance)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByAltitudePedalingindex(double altitude, double pedalingindex) {
        return findByAltitudePedalingindex(altitude, pedalingindex, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByAltitudePedalingindex(double altitude, double pedalingindex, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE altitude='"+String.valueOf(altitude)+"', pedalingindex='"+String.valueOf(pedalingindex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPowerLeftpowerbalance(double power, double leftpowerbalance) {
        return findByPowerLeftpowerbalance(power, leftpowerbalance, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPowerLeftpowerbalance(double power, double leftpowerbalance, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE power='"+String.valueOf(power)+"', leftpowerbalance='"+String.valueOf(leftpowerbalance)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByPowerPedalingindex(double power, double pedalingindex) {
        return findByPowerPedalingindex(power, pedalingindex, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByPowerPedalingindex(double power, double pedalingindex, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE power='"+String.valueOf(power)+"', pedalingindex='"+String.valueOf(pedalingindex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmdataDAO> findByLeftpowerbalancePedalingindex(double leftpowerbalance, double pedalingindex) {
        return findByLeftpowerbalancePedalingindex(leftpowerbalance, pedalingindex, 0, 50000);
    }

    public static ArrayList<PolarhrmdataDAO> findByLeftpowerbalancePedalingindex(double leftpowerbalance, double pedalingindex, int limitmin, int limitmax) {
        ArrayList<PolarhrmdataDAO> resultarraylist = new ArrayList<PolarhrmdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE leftpowerbalance='"+String.valueOf(leftpowerbalance)+"', pedalingindex='"+String.valueOf(pedalingindex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}