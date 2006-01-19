package reger.api.rome;

import com.sun.syndication.feed.module.ModuleImpl;

import reger.mega.FieldType;
import reger.core.Debug;

import java.util.ArrayList;

/**
 * MegaDataRSSModule implementation
 */
public class MegaDataRSSModuleImpl extends ModuleImpl implements MegaDataRSSModule{


    private ArrayList<FieldType> _foos;

    public MegaDataRSSModuleImpl() {

        super(MegaDataRSSModule.class,MegaDataRSSModule.URI);
        Debug.debug(5, "", "MegaDataRSSModuleImpl.java - Instantiated.");

    }

    public Class getInterface() {
        return MegaDataRSSModule.class;
    }

    public void copyFrom(Object obj) {
        MegaDataRSSModule tm = (MegaDataRSSModule) obj;
        ArrayList<FieldType> foos = tm.getFields();
        setFields(foos);
    }

    public ArrayList<FieldType> getFields() {
        return (_foos==null) ? (_foos=new ArrayList<FieldType>()) : _foos;
    }

    public void setFields(ArrayList<FieldType> foos) {
        _foos = foos;
        Debug.debug(5, "", "MegaDataRSSModuleImpl.java - setFields() called.");
    }







}
