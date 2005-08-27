package reger.api.rome;

import com.sun.syndication.feed.module.Module;

import reger.mega.FieldType;

/**
 * First RSS Module Attempt
 */
public interface  MegaDataRSSModule extends Module{

    public static final String URI = "http://www.reger.com/about/specs/entrydata.rddl";

    public FieldType[] getFields();
    public void setFields(FieldType[] fields);


}
