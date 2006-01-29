package reger;

import reger.mega.FieldType;
import reger.mega.FieldTypeFactory;
import reger.core.db.Db;
import reger.core.Debug;


import java.util.*;

/**
 * Static hold of allFields in system.  Note that these are not representative of
 * different FieltTypes.
 * Important to note is the concept that a Field can be used in many logs.  When
 * returning a field I must return a clone of the field because otherwise there will
 * be massive data swapping as different users load different logs using the same
 * fields.
 */
public class AllFieldsInSystem {

    //private static Hashtable allFields;

    //Map (megafieldid, FieldType)
    private static Map allFieldsInSystem;

    //Map (eventtypeid, Set megafieldidsForThisEventtypeid)
    private static Map eventtypeidToMegafieldid;



    public AllFieldsInSystem(){
        if (allFieldsInSystem==null){
            refresh();
        }
    }

    public static Map getAllFieldsInSystem(){
        return allFieldsInSystem;
    }

    /**
     * Empties and then refreshes all logs in the system.
     */
    public static void refresh(){
        Debug.debug(5, "", "allFields.refresh().");

        allFieldsInSystem = Collections.synchronizedMap(new HashMap());
        eventtypeidToMegafieldid = Collections.synchronizedMap(new HashMap());

        synchronized(allFieldsInSystem){
        synchronized(eventtypeidToMegafieldid){

            //First, figure out how many there are in the system
            int numberInSystem = 0;
            //-----------------------------------
            //-----------------------------------
            String[][] rstCount= Db.RunSQL("SELECT count(*) FROM megafield");
            //-----------------------------------
            //-----------------------------------
            if (rstCount!=null && rstCount.length>0){
                numberInSystem = Integer.parseInt(rstCount[0][0]);
            }

            //Load the field
            //-----------------------------------
            //-----------------------------------
            String[][] rstFields= Db.RunSQL("SELECT megafieldid, fieldtype FROM megafield", numberInSystem+1);
            //-----------------------------------
            //-----------------------------------
            if (rstFields!=null && rstFields.length>0){
                StringBuffer debug = new StringBuffer();
                for(int i=0; i<rstFields.length; i++){
                    //Figure out which type of field this is
                    reger.mega.FieldType f = reger.mega.FieldTypeFactory.getHandlerByFieldtype(Integer.parseInt(rstFields[i][1]));
                    if (f!=null){
                        //Populate the field with title, description and all that good stuff in the database
                        f.populateFromMegafieldid(Integer.parseInt(rstFields[i][0]));
                        //Initialize the field.  This is part of the FieldType interface.
                        f.initialize();
                        //Add to the main Map of all fields in the system
                        allFieldsInSystem.put(new Integer(Integer.parseInt(rstFields[i][0])), f);
                        //Add the eventtypeid-megafieldid mapping
                        if (f.getEventtypeid()>0){
                            Set megafieldidsForThisEventtypeid = (Set)eventtypeidToMegafieldid.get(new Integer(f.getEventtypeid()));
                            if (megafieldidsForThisEventtypeid==null){
                                megafieldidsForThisEventtypeid = Collections.synchronizedSet(new HashSet());
                            }
                            megafieldidsForThisEventtypeid.add(new Integer(f.getMegafieldid()));

                            eventtypeidToMegafieldid.put(new Integer(f.getEventtypeid()), megafieldidsForThisEventtypeid);

                        }

                        //Debug statement
                        debug.append("allFields - megafieldid=."+rstFields[i][0]+" updated.<br>");
                    }
                }
                Debug.debug(5, "", "AllFieldsInSystem.java<br>");
            }
        }
        }

    }



    /**
     * Refreshes a single megafieldid.
     */
    public static void refresh(int megafieldid){
        Debug.debug(5, "", "allFields.refresh(megafieldid="+megafieldid+").");
        if (allFieldsInSystem==null){
            refresh();
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstFields= Db.RunSQL("SELECT megafieldid, fieldtype FROM megafield WHERE megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstFields!=null && rstFields.length>0){
        	for(int i=0; i<rstFields.length; i++){
        	    //Figure out which type of field this is
                reger.mega.FieldType f = reger.mega.FieldTypeFactory.getHandlerByFieldtype(Integer.parseInt(rstFields[i][1]));
                if (f!=null){
                    //Populate the field with title, description and all that good stuff in the database
                    f.populateFromMegafieldid(Integer.parseInt(rstFields[i][0]));
                    //Add to the main Map of all fields in the system
                    //allFields.put(new Integer(Integer.parseInt(rstFields[i][0])), f);
                    synchronized(allFieldsInSystem){
                        allFieldsInSystem.put(new Integer(Integer.parseInt(rstFields[i][0])), f);
                    }
                    //Add the eventtypeid-megafieldid mapping
                    if (f.getEventtypeid()>0){
                        Set megafieldidsForThisEventtypeid = (Set)eventtypeidToMegafieldid.get(new Integer(f.getEventtypeid()));
                        if (megafieldidsForThisEventtypeid==null){
                            megafieldidsForThisEventtypeid = Collections.synchronizedSet(new HashSet());
                        }
                        megafieldidsForThisEventtypeid.add(new Integer(f.getMegafieldid()));
                        synchronized(eventtypeidToMegafieldid){
                            eventtypeidToMegafieldid.put(new Integer(f.getEventtypeid()), megafieldidsForThisEventtypeid);
                        }
                    }

                    //Debug statement
                    Debug.debug(5, "", "allFields - megafieldid=."+rstFields[i][0]+" updated.");
                }
        	}
        } else {
            //Somebody has tried to refresh a field, but that field is not in the database
            synchronized(allFieldsInSystem){
                allFieldsInSystem.remove(new Integer(megafieldid));
            }
        }
    }

    private static void removeField(int megafieldid){
        //Need to remove it from the array
        synchronized(allFieldsInSystem){
            allFieldsInSystem.remove(new Integer(megafieldid));
        }
        //Iterate the eventtype to megafieldid lookup table
        synchronized(eventtypeidToMegafieldid){
            for (Iterator i=eventtypeidToMegafieldid.entrySet().iterator(); i.hasNext(); ) {
                Map.Entry e = (Map.Entry) i.next();
                //e.getKey()
                //e.getValue()
                //Call remove on each of the Set objects that is a list of megafieldids for the eventtypeid
                Set megafieldidsForThisEventtypeid = Collections.synchronizedSet((Set)e.getValue());
                megafieldidsForThisEventtypeid.remove(new Integer(megafieldid));
                e.setValue(megafieldidsForThisEventtypeid);
            }
        }
    }

    public static ArrayList<FieldType> copyFieldTypeArray(ArrayList<FieldType> src){
		//If the source isn't null
		if (src!=null){
            ArrayList<FieldType> outArr = new ArrayList<FieldType>();
            for (Iterator it = src.iterator(); it.hasNext(); ) {
                FieldType ft = (FieldType)it.next();
                outArr.add(FieldTypeFactory.getCopyOfField(ft));
            }
            return outArr;
        //If the source is null, just return an empty array
        } else {
            return null;
        }
	}



    public static FieldType getMegaFieldByMegafieldid(int megafieldid){
        if (allFieldsInSystem==null){
            refresh();
        }

        //Go get the correct one
        if (allFieldsInSystem!=null){
            return (FieldType)allFieldsInSystem.get(new Integer(megafieldid));
        } else {
            return null;
        }
    }




    public static ArrayList<FieldType> allMegaFieldsForEventtypeid(int eventtypeid, boolean getCopyOfFieldInsteadOfReference){
        Debug.debug(5, "", "AllFieldsInSystem.allMegaFieldsForEventtypeid() - eventtypeid=" + eventtypeid);
        ArrayList<FieldType> out = new ArrayList<FieldType>();
        if (allFieldsInSystem==null){
            refresh();
        }
        
        if (allFieldsInSystem!=null){
            //Go to the lookup table
            Set megafieldidsExplicitlyForThisEventtypeid = (Set)eventtypeidToMegafieldid.get(new Integer(eventtypeid));
            if (megafieldidsExplicitlyForThisEventtypeid!=null){
                //Iterate the megafieldids that belong to this eventtypeid
                for (Iterator iterator = megafieldidsExplicitlyForThisEventtypeid.iterator(); iterator.hasNext();) {
                    int megafieldid = ((Integer) iterator.next()).intValue();
                    //Go to the allFieldsInSystem and get this field
                    FieldType field = (FieldType)allFieldsInSystem.get(new Integer(megafieldid));
                    if (field!=null){
                        //Quick safety check to make sure this is the correct eventtypeid
                        if (field.getEventtypeid()==eventtypeid){
                            if (getCopyOfFieldInsteadOfReference){
                                //Add a copy of the field to the array
                                out.add(FieldTypeFactory.getCopyOfField(field));
                            } else {
                                //Add a reference of the field to the array
                                out.add(field);
                            }
                        }
                    }
                }
            }
        }
        return out;
    }

}
