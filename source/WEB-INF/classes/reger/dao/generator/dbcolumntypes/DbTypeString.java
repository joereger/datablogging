package reger.dao.generator.dbcolumntypes;

/**
 * DbType
 */
public class DbTypeString implements DbColumnType {


    public String getProperty(String colname) {
        return "    protected String "+colname+" = \"\";\n";
    }

    public String getValueForInsertIntoDb(String colname) {
        return "reger.core.Util.cleanForSQL("+colname+")";
    }

    public String getValueFromDb(String colname, int rstDataIndex) {
        StringBuffer mb = new StringBuffer();
        mb.append("\n            "+colname+" = rstData[0]["+rstDataIndex+"];");
        return mb.toString();
    }

    public String getJavaType(){
        return "String";
    }
}
