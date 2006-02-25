package reger.dao.generator.dbcolumntypes;

/**
 * DbType
 */
public class DbTypeDatetime implements DbColumnType {


    public String getProperty(String colname) {
        return "    protected java.util.Calendar "+colname+" = java.util.Calendar.getInstance();\n";
    }

    public String getValueForInsertIntoDb(String colname) {
        return "reger.core.TimeUtils.dateformatfordb("+colname+")";
    }

    public String getValueFromDb(String colname, int rstDataIndex) {
        StringBuffer mb = new StringBuffer();
        mb.append("\n            "+colname+" = reger.core.TimeUtils.dbstringtocalendar(rstData[0]["+rstDataIndex+"]);");
        return mb.toString();
    }

    public String getJavaType(){
        return "java.util.Calendar";
    }
}
