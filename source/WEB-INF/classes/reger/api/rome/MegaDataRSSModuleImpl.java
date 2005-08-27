package reger.api.rome;

import com.sun.syndication.feed.module.ModuleImpl;

import java.util.List;
import java.util.ArrayList;

import reger.mega.FieldType;

/**
 * MegaDataRSSModule implementation
 */
public class MegaDataRSSModuleImpl extends ModuleImpl implements MegaDataRSSModule{


    private FieldType[] _foos;

    public MegaDataRSSModuleImpl() {

        super(MegaDataRSSModule.class,MegaDataRSSModule.URI);
        reger.core.Util.debug(5, "MegaDataRSSModuleImpl.java - Instantiated.");

    }

    public Class getInterface() {
        return MegaDataRSSModule.class;
    }

    public void copyFrom(Object obj) {
        MegaDataRSSModule tm = (MegaDataRSSModule) obj;
        FieldType[] foos = tm.getFields();
        setFields(foos);
    }

    public FieldType[] getFields() {
        return (_foos==null) ? (_foos=new FieldType[0]) : _foos;
    }

    public void setFields(FieldType[] foos) {
        _foos = foos;
        reger.core.Util.debug(5, "MegaDataRSSModuleImpl.java - setFields() called.");
    }







}
