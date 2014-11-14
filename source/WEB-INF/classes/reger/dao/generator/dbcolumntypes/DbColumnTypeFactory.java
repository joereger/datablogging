package reger.dao.generator.dbcolumntypes;

/**
 * Gets a column type
 */
public class DbColumnTypeFactory {

    public static DbColumnType getByMySqlTypeValue(String type){
        if (type.indexOf("tinyint")>-1){
            return new DbTypeTinyint();
        } else if (type.indexOf("int")>-1){
            return new DbTypeInt();
        } else if (type.indexOf("varchar")>-1){
            return new DbTypeString();
        } else if (type.indexOf("longtext")>-1){
            return new DbTypeString();
        } else if (type.indexOf("text")>-1){
            return new DbTypeString();
        } else if (type.indexOf("char")>-1){
            return new DbTypeString();
        } else if (type.indexOf("datetime")>-1){
            return new DbTypeDatetime();
        } else if (type.indexOf("double")>-1){
            return new DbTypeDouble();
        } else if (type.indexOf("float")>-1){
            return new DbTypeDouble();
        } else {
            System.out.println("DbColumnTypeFactory: Unknown database column type encountered: " + type);
            return new DbTypeString();
        }
    }

}
