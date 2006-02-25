package reger.dao.generator.dbcolumntypes;

/**
 * Represents a database column type
 */
public interface DbColumnType {

    public String getProperty(String colname);
    public String getValueForInsertIntoDb(String colname);
    public String getValueFromDb(String colname, int rstDataIndex);
    public String getJavaType();

}
