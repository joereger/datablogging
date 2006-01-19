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

    //Map (logid, Set megafieldidsForThisLogid)... this is only the explicit association, not the final
    private static Map logidExplicitlyToMegafieldid;


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
        logidExplicitlyToMegafieldid = Collections.synchronizedMap(new HashMap());


        synchronized(allFieldsInSystem){
        synchronized(eventtypeidToMegafieldid){
        synchronized(logidExplicitlyToMegafieldid){

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
                        //Add the logid-megafieldid mapping... this is the explicit mapping, not the overall
                        if (f.getLogid()>0){
                            Set megafieldidsExplicitlyForThisLogid = (Set)logidExplicitlyToMegafieldid.get(new Integer(f.getLogid()));
                            if (megafieldidsExplicitlyForThisLogid==null){
                                megafieldidsExplicitlyForThisLogid = Collections.synchronizedSet(new HashSet());
                            }
                            megafieldidsExplicitlyForThisLogid.add(new Integer(f.getMegafieldid()));

                            logidExplicitlyToMegafieldid.put(new Integer(f.getLogid()), megafieldidsExplicitlyForThisLogid);

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
                    //Add the logid-megafieldid mapping... this is the explicit mapping, not the overall
                    if (f.getLogid()>0){
                        Set megafieldidsExplicitlyForThisLogid = (Set)logidExplicitlyToMegafieldid.get(new Integer(f.getLogid()));
                        if (megafieldidsExplicitlyForThisLogid==null){
                            megafieldidsExplicitlyForThisLogid = Collections.synchronizedSet(new HashSet());
                        }
                        megafieldidsExplicitlyForThisLogid.add(new Integer(f.getMegafieldid()));
                        synchronized(logidExplicitlyToMegafieldid){
                            logidExplicitlyToMegafieldid.put(new Integer(f.getLogid()), megafieldidsExplicitlyForThisLogid);
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
        //Iterate the logid to megafieldid lookup table
        synchronized(logidExplicitlyToMegafieldid){
            for (Iterator i=logidExplicitlyToMegafieldid.entrySet().iterator(); i.hasNext(); ) {
                Map.Entry e = (Map.Entry) i.next();
                //e.getKey()
                //e.getValue()
                //Call remove on each of the Set objects that is a list of megafieldids for the logid
                Set megafieldidsExplicitlyForThisLogid = Collections.synchronizedSet((Set)e.getValue());
                megafieldidsExplicitlyForThisLogid.remove(new Integer(megafieldid));
                e.setValue(megafieldidsExplicitlyForThisLogid);
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

    public static ArrayList<FieldType> getFieldsExplicitylAssignedToLogid(int logid, boolean getCopyOfFieldInsteadOfReference){
        Debug.debug(5, "", "AllFieldsInSystem.getFieldsExplicitylAssignedToLogid() - logid=" + logid);
        ArrayList<FieldType> out = new ArrayList<FieldType>();
        if (allFieldsInSystem==null){
            refresh();
        }

        if (allFieldsInSystem!=null){

            //Go to the lookup table
            Set megafieldidsExplicitlyForThisLogid = (Set)logidExplicitlyToMegafieldid.get(new Integer(logid));
            if (megafieldidsExplicitlyForThisLogid!=null){
                //Iterate the megafieldids that belong to this eventtypeid
                for (Iterator iterator = megafieldidsExplicitlyForThisLogid.iterator(); iterator.hasNext();) {
                    int megafieldid = ((Integer) iterator.next()).intValue();
                    //Go to the allFieldsInSystem and get this field
                    FieldType field = (FieldType)allFieldsInSystem.get(new Integer(megafieldid));
                    if (field!=null){
                        //Quick safety check to make sure this is the correct eventtypeid
                        if (field.getLogid()==logid){
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

    /**
     * Eventtypeid must be provided to prevent a call to the database
     */
    public static ArrayList<FieldType> allMegaFieldsForLog(int logid, int eventtypeid){
        if (allFieldsInSystem==null){
            refresh();
        }

        //Set this to watch a specific megafieldid.  0 to watch all.
        int debugMegafieldidToWatch = 130;

        //Get the system fields for this megalogtype
        Debug.debug(5, "", "AllFieldsInSystem.allMegaFieldsForLog() - logid="+logid+" eventtypeid=" + eventtypeid);
        ArrayList<FieldType> systemFields = allMegaFieldsForEventtypeid(eventtypeid, true);

        //Get the log fields for this logid
        ArrayList<FieldType> logFields = getFieldsExplicitylAssignedToLogid(logid, true);

        //Combine systemFields and logFields into interimFields
        //Start with systemFields as a base and then iterate logFields.
        //A logField can either a) overwrite a systemField or b) be added to the list of fields
        ArrayList<FieldType> interimFields = systemFields;
        if (logFields!=null){
            for (Iterator it = logFields.iterator(); it.hasNext(); ) {
                FieldType tmpLogField = (FieldType)it.next();
                boolean logFieldOverridesSystemField = false;
                for (Iterator itA = interimFields.iterator(); itA.hasNext(); ) {
                    if (!logFieldOverridesSystemField){
                        FieldType tmpInterimField = (FieldType)itA.next();
                        if (tmpLogField.getMegafieldid()==tmpInterimField.getMegafieldid()){
                            //Replace systemField with the userField
                            if (tmpLogField.getMegafieldid()==debugMegafieldidToWatch){
                                Debug.debug(5, "", "AllFieldsInSystem.java - Replacing megafieldid=" + tmpLogField.getMegafieldid());
                            }
                            tmpInterimField=tmpLogField;
                            logFieldOverridesSystemField=true;
                        }
                    }
                }
                //If, after looking for a field this logField, there isn't one, add it
                if (!logFieldOverridesSystemField){
                    if (tmpLogField.getMegafieldid()==debugMegafieldidToWatch){
                        Debug.debug(5, "", "AllFieldsInSystem.java - logid="+logid+" - Adding userField.megafieldid=" + tmpLogField.getMegafieldid());
                    }
                    interimFields.add(tmpLogField);
                }
            }
        }

        //Debug
        StringBuffer tmp0 = new StringBuffer();
        if (interimFields!=null){
            for (Iterator it = interimFields.iterator(); it.hasNext(); ) {
                FieldType ft = (FieldType)it.next();
                tmp0.append(ft.getMegafieldid() + "<br>fieldname=" + ft.getFieldname() + "<br>");
            }
        }
        Debug.debug(5, "", "AllFieldsInSystem.java - logid="+logid+" interimFields Before Assignment<br>" + tmp0.toString());



        return interimFields;
    }



}
