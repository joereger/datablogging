package reger.dao.generator.dbcolumntypes;

/**
 * DbType
 */
public class DbTypeTinyint implements DbColumnType {


    public String getProperty(String colname) {
        return "    protected boolean "+colname+" = true;\n";
    }

    public String getValueForInsertIntoDb(String colname) {
        return "reger.core.Util.booleanAsSQLText("+colname+")";
    }

    public String getValueFromDb(String colname, int rstDataIndex) {
        StringBuffer mb = new StringBuffer();
        mb.append("\n                    "+colname+" = reger.core.TimeUtils.booleanFromSQLText(rstData[0]["+rstDataIndex+"];");
        return mb.toString();
    }

    public String getJavaType(){
        return "boolean";
    }
}
