package reger;

import reger.mega.Field;
import reger.mega.FieldType;
import reger.mega.FieldTypeFactory;
import reger.core.db.Db;
import reger.core.Util;


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
        Util.debug(5, "allFields.refresh().");

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
                Util.debug(5, "AllFieldsInSystem.java<br>");
            }
        }
        }
        }

    }



    /**
     * Refreshes a single megafieldid.
     */
    public static void refresh(int megafieldid){
        Util.debug(5, "allFields.refresh(megafieldid="+megafieldid+").");
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
                    Util.debug(5, "allFields - megafieldid=."+rstFields[i][0]+" updated.");
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

    public static FieldType[] copyFieldTypeArray(FieldType[] src){
		//If the source isn't null
		if (src!=null){
            FieldType[] outArr = new FieldType[src.length];
            for(int i=0; i < (src.length); i++) {
                outArr[i]=FieldTypeFactory.getCopyOfField(src[i]);
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




    public static FieldType[] allMegaFieldsForEventtypeid(int eventtypeid, boolean getCopyOfFieldInsteadOfReference){
        reger.core.Util.debug(5, "AllFieldsInSystem.allMegaFieldsForEventtypeid() - eventtypeid=" + eventtypeid);
        FieldType[] out = new FieldType[0];
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
                                out = AddToArray.addToFieldTypeArray(out, FieldTypeFactory.getCopyOfField(field));
                            } else {
                                //Add a reference of the field to the array
                                out = AddToArray.addToFieldTypeArray(out, field);
                            }
                        }
                    }
                }
            }


//            //Go to the lookup table
//            Set megafieldidsForThisEventtypeid = (Set)eventtypeidToMegafieldid.get(new Integer(eventtypeid));
//            if (megafieldidsForThisEventtypeid!=null){
//
//                //Create a map for the usage info
//                HashMap fieldsHandled = new HashMap();
//                for (Iterator iterator = megafieldidsForThisEventtypeid.iterator(); iterator.hasNext();) {
//                    int megafieldid = ((Integer) iterator.next()).intValue();
//                    fieldsHandled.put(new Integer(megafieldid), new Boolean(false));
//                }
//
//                //Order according to mlt.fieldorder
//                for (int i = 0; i < fieldorder.length; i++) {
//                    //Update the fieldsHandled map which essentially tells me that this field has been dealt with
//                    fieldsHandled.put(new Integer(fieldorder[i]), new Boolean(true));
//                    //Make sure the entry in fieldorder is a valid field for this log type
//                    if (megafieldidsForThisEventtypeid.contains(new Integer(fieldorder[i]))){
//                        //Go to the allFieldsInSystem and get this field
//                        FieldType field = (FieldType)allFieldsInSystem.get(new Integer(fieldorder[i]));
//                        if (field!=null){
//                            //Quick safety check to make sure this is the correct eventtypeid
//                            if (field.getEventtypeid()==eventtypeid){
//                                //Check visibility
//                                if (!reger.core.Util.isIntInIntArray(field.getMegafieldid(), hiddenfields) || includeHiddenFields){
//                                    if (getCopyOfFieldInsteadOfReference){
//                                        //Add a copy of the field to the array
//                                        outSorted = reger.core.Util.addToFieldTypeArray(outSorted, FieldTypeFactory.getCopyOfField(field));
//                                    } else {
//                                        //Add a reference of the field to the array
//                                        outSorted = reger.core.Util.addToFieldTypeArray(outSorted, field);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                //Iterate the fieldsHandled map and find those where the value is false, meaning they haven't been dealt with
//                reger.core.Util.debug(5, "AllFieldsInSystem.java - Checking to see if there are any fields that haven't been dealt with.");
//                if (fieldsHandled.containsValue(new Boolean(false))){
//                    reger.core.Util.debug(5, "AllFieldsInSystem.java - There are fields that haven't been dealt with.");
//                    for (Iterator i=fieldsHandled.entrySet().iterator(); i.hasNext(); ) {
//                        Map.Entry e = (Map.Entry) i.next();
//                        //e.getKey()
//                        //e.getValue()
//                        reger.core.Util.debug(5, "AllFieldsInSystem.java - e.getKey()=" + e.getKey() + " e.getValue()=" + e.getValue());
//                        if (((Boolean)e.getValue()).booleanValue()==false){
//                            reger.core.Util.debug(5, "AllFieldsInSystem.java - Value is false.");
//                            //This field hasn't been added yet
//                            //Go to the allFieldsInSystem and get this field
//                            FieldType field = (FieldType)allFieldsInSystem.get((Integer)e.getKey());
//                            if (field!=null){
//                                //Quick safety check to make sure this is the correct eventtypeid
//                                if (field.getEventtypeid()==eventtypeid){
//                                    //Check visibility
//                                    if (!reger.core.Util.isIntInIntArray(field.getMegafieldid(), hiddenfields) || includeHiddenFields){
//                                        if (getCopyOfFieldInsteadOfReference){
//                                            //Add a copy of the field to the array
//                                            outSorted = reger.core.Util.addToFieldTypeArray(outSorted, FieldTypeFactory.getCopyOfField(field));
//                                        } else {
//                                            //Add a reference of the field to the array
//                                            outSorted = reger.core.Util.addToFieldTypeArray(outSorted, field);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }

        }
        return out;
    }

    public static FieldType[] getFieldsExplicitylAssignedToLogid(int logid, boolean getCopyOfFieldInsteadOfReference){
        reger.core.Util.debug(5, "AllFieldsInSystem.getFieldsExplicitylAssignedToLogid() - logid=" + logid);
        FieldType[] out = new FieldType[0];
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
                                out = AddToArray.addToFieldTypeArray(out, FieldTypeFactory.getCopyOfField(field));
                            } else {
                                //Add a reference of the field to the array
                                out = AddToArray.addToFieldTypeArray(out, field);
                            }
                        }
                    }
                }
            }



//            //Go to the lookup table
//            Set megafieldidsForThisLogid = (Set)logidExplicitlyToMegafieldid.get(new Integer(logid));
//            if (megafieldidsForThisLogid!=null){
//
//                //Create a map for the usage info
//                HashMap fieldsHandled = new HashMap();
//                for (Iterator iterator = megafieldidsForThisLogid.iterator(); iterator.hasNext();) {
//                    int megafieldid = ((Integer) iterator.next()).intValue();
//                    fieldsHandled.put(new Integer(megafieldid), new Boolean(false));
//                }
//
//                //Order according to mlt.fieldorder
//                for (int i = 0; i < fieldorder.length; i++) {
//                    //Update the fieldsHandled map which essentially tells me that this field has been dealt with
//                    fieldsHandled.put(new Integer(fieldorder[i]), new Boolean(true));
//                    //Make sure the entry in fieldorder is a valid field for this log type
//                    if (megafieldidsForThisLogid.contains(new Integer(fieldorder[i]))){
//                        //Go to the allFieldsInSystem and get this field
//                        FieldType field = (FieldType)allFieldsInSystem.get(new Integer(fieldorder[i]));
//                        if (field!=null){
//                            //Quick safety check to make sure this is the correct eventtypeid
//                            if (field.getEventtypeid()==logid){
//                                //Check visibility
//                                if (!reger.core.Util.isIntInIntArray(field.getMegafieldid(), hiddenfields) || includeHiddenFields){
//                                    if (getCopyOfFieldInsteadOfReference){
//                                        //Add a copy of the field to the array
//                                        outSorted = reger.core.Util.addToFieldTypeArray(outSorted, FieldTypeFactory.getCopyOfField(field));
//                                    } else {
//                                        //Add a reference of the field to the array
//                                        outSorted = reger.core.Util.addToFieldTypeArray(outSorted, field);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                //Iterate the fieldsHandled map and find those where the value is false, meaning they haven't been dealt with
//                reger.core.Util.debug(5, "AllFieldsInSystem.java - Checking to see if there are any fields that haven't been dealt with.");
//                if (fieldsHandled.containsValue(new Boolean(false))){
//                    reger.core.Util.debug(5, "AllFieldsInSystem.java - There are fields that haven't been dealt with.");
//                    for (Iterator i=fieldsHandled.entrySet().iterator(); i.hasNext(); ) {
//                        Map.Entry e = (Map.Entry) i.next();
//                        //e.getKey()
//                        //e.getValue()
//                        reger.core.Util.debug(5, "AllFieldsInSystem.java - e.getKey()=" + e.getKey() + " e.getValue()=" + e.getValue());
//                        if (((Boolean)e.getValue()).booleanValue()==false){
//                            reger.core.Util.debug(5, "AllFieldsInSystem.java - Value is false.");
//                            //This field hasn't been added yet
//                            //Go to the allFieldsInSystem and get this field
//                            FieldType field = (FieldType)allFieldsInSystem.get((Integer)e.getKey());
//                            if (field!=null){
//                                //Quick safety check to make sure this is the correct eventtypeid
//                                if (field.getEventtypeid()==logid){
//                                    //Check visibility
//                                    if (!reger.core.Util.isIntInIntArray(field.getMegafieldid(), hiddenfields) || includeHiddenFields){
//                                        if (getCopyOfFieldInsteadOfReference){
//                                            //Add a copy of the field to the array
//                                            outSorted = reger.core.Util.addToFieldTypeArray(outSorted, FieldTypeFactory.getCopyOfField(field));
//                                        } else {
//                                            //Add a reference of the field to the array
//                                            outSorted = reger.core.Util.addToFieldTypeArray(outSorted, field);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }



        }

        return out;
    }

    /**
     * Eventtypeid must be provided to prevent a call to the database
     */
    public static FieldType[] allMegaFieldsForLog(int logid, int eventtypeid){
        if (allFieldsInSystem==null){
            refresh();
        }

        //Set this to watch a specific megafieldid.  0 to watch all.
        int debugMegafieldidToWatch = 130;

        //Get the system fields for this megalogtype
        reger.core.Util.debug(5, "AllFieldsInSystem.allMegaFieldsForLog() - logid="+logid+" eventtypeid=" + eventtypeid);
        FieldType[] systemFields = allMegaFieldsForEventtypeid(eventtypeid, true);

        //Get the log fields for this logid
        FieldType[] logFields = getFieldsExplicitylAssignedToLogid(logid, true);

        //Combine systemFields and logFields into interimFields
        //Start with systemFields as a base and then iterate logFields.
        //A logField can either a) overwrite a systemField or b) be added to the list of fields
        FieldType[] interimFields = systemFields;
        if (logFields!=null){
            for (int k = 0; k < logFields.length; k++) {
                boolean logFieldOverridesSystemField = false;
                for (int l = 0; l < interimFields.length && !logFieldOverridesSystemField; l++) {
                    if (logFields[k].getMegafieldid()==interimFields[l].getMegafieldid()){
                        //Replace systemField with the userField
                        if (logFields[k].getMegafieldid()==debugMegafieldidToWatch){
                            reger.core.Util.debug(5, "AllFieldsInSystem.java - Replacing megafieldid=" + logFields[k].getMegafieldid());
                        }
                        interimFields[l] = logFields[k];
                        logFieldOverridesSystemField=true;
                    }
                }
                //If, after looking for a field this logField, there isn't one, add it
                if (!logFieldOverridesSystemField){
                    if (logFields[k].getMegafieldid()==debugMegafieldidToWatch){
                        reger.core.Util.debug(5, "AllFieldsInSystem.java - logid="+logid+" - Adding userField.megafieldid=" + logFields[k].getMegafieldid());
                    }
                    interimFields = AddToArray.addToFieldTypeArray(interimFields, logFields[k]);
                }
            }
        }

        //Debug
        StringBuffer tmp0 = new StringBuffer();
        if (interimFields!=null){
            for (int cc = 0; cc < interimFields.length; cc++) {
                tmp0.append(interimFields[cc].getMegafieldid() + "<br>fieldname=" + interimFields[cc].getFieldname() + "<br>");
            }
        }
        reger.core.Util.debug(5, "AllFieldsInSystem.java - logid="+logid+" interimFields Before Assignment<br>" + tmp0.toString());



        return interimFields;
    }



}
