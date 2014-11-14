package reger.dbversion;

import reger.core.db.Db;
import reger.core.PasswordHash;
import reger.UserSession;
import reger.mega.FieldType;
import reger.mega.Field;
import reger.mega.FieldLayout;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version92ToVersion93 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



//            //Check all fields by eventtypeid
//            //-----------------------------------
//            //-----------------------------------
//            String[][] rstEvType= Db.RunSQL("SELECT eventtypeid FROM megalogtype");
//            //-----------------------------------
//            //-----------------------------------
//            if (rstEvType!=null && rstEvType.length>0){
//                for(int i=0; i<rstEvType.length; i++){
//                    fixFields(Integer.parseInt(rstEvType[i][0]));
//                }
//            }

            


    }

//    private void fixFields(int eventtypeid){
//
//        //Go get the fields to work with
//        FieldType[] fields = Field.getFieldsForEventTypeOrLogid(eventtypeid, 0);
//        int[] fieldsDisplayed = new int[0];
//        int maxX = FieldLayout.getMaxX(fields);
//        int maxY = FieldLayout.getMaxY(fields);
//
//        //Rows
//        for(int y=1; y<=maxY; y++){
//            //Columns
//            for(int x=1; x<=maxX; x++){
//                FieldType fld = FieldLayout.getByUpperLeftCoordinates(x, y, fields);
//                if (fld!=null){
//                    reger.core.Util.debug(5, "FieldLayout.java field not null.  fld.getFieldname()" + fld.getFieldname());
//                    //Record this field as having been displayed
//                    fieldsDisplayed = reger.core.Util.addToIntArray(fieldsDisplayed, fld.getMegafieldid());
//                }
//
//            }
//        }
//
//
//        //Display fields that didn't get displayed in the grid's cell-by-cell sweep.
//        int initialMaxY=FieldLayout.getMaxY(fields);
//        int initialMaxX=FieldLayout.getMaxX(fields);
//        int countUndisplayedFields = 0;
//        if (fields!=null){
//            for (int i = 0; i < fields.length; i++) {
//                if (!reger.core.Util.valueIsInIntArray(fieldsDisplayed, fields[i].getMegafieldid())){
//                    //See if I can fix the field so that next time it appears on the grid
//                    int newUlx = 1;
//                    int newUly = initialMaxY+(countUndisplayedFields+1);
//                    int newLrx=1;
//                    int newLry = initialMaxY+(countUndisplayedFields+1);
//
//                    //Increment the counter
//                    countUndisplayedFields = countUndisplayedFields+1;
//
//                    //Fix the field directly at the database level
//                    //-----------------------------------
//                    //-----------------------------------
//                    int count = Db.RunSQLUpdate("UPDATE megafield SET upperleftx='"+newUlx+"', upperlefty='"+newUly+"', lowerrightx='"+newLrx+"', lowerrighty='"+newLry+"' WHERE megafieldid='"+fields[i].getMegafieldid()+"'");
//                    //-----------------------------------
//                    //-----------------------------------
//
//                }
//            }
//        }
//        //Close the table
//
//
//    }


}
