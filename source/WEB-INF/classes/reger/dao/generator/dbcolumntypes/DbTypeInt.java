package reger.dao.generator.dbcolumntypes;

/**
 * DbType
 */
public class DbTypeInt implements DbColumnType {


    public String getProperty(String colname) {
        return "    protected int "+colname+" = 0;\n";
    }

    public String getValueForInsertIntoDb(String colname) {
        return colname;
    }

    public String getValueFromDb(String colname, int rstDataIndex) {
        StringBuffer mb = new StringBuffer();
        mb.append("\n                    if (reger.core.Util.isinteger(rstData[0]["+rstDataIndex+"])){");
        mb.append("\n                        "+colname+" = Integer.parseInt(rstData[0]["+rstDataIndex+"]);");
        mb.append("\n                    } else {");
        mb.append("\n                        "+colname+" = 0;");
        mb.append("\n                    }");
        return mb.toString();
    }

    public String getJavaType(){
        return "int";
    }
}
