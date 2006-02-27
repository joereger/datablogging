package reger.dao;

/**
 * Main DAO interface for objects implementing
 */
public interface DAO {

    public void load();
    public void save() throws reger.core.ValidationException;
    public void delete();
    public void validate() throws reger.core.ValidationException;
    public int getPrimaryKeyValue();
    public String getPrimaryKeyName();
    public String getTableName();

}
