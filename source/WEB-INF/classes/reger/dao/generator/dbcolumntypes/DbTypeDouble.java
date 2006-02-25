package reger.dao.generator.dbcolumntypes;

/**
 * DbType
 */
public class DbTypeDouble implements DbColumnType {


    public String getProperty(String colname) {
        return "    protected double "+colname+" = 0;\n";
    }

    public String getValueForInsertIntoDb(String colname) {
        return "String.valueOf("+colname+")";
    }

    public String getValueFromDb(String colname, int rstDataIndex) {
        StringBuffer mb = new StringBuffer();
        mb.append("\n                    if (reger.core.Util.isnumeric(rstData[0]["+rstDataIndex+"])){");
        mb.append("\n                        "+colname+" = Double.parseDouble(rstData[0]["+rstDataIndex+"]);");
        mb.append("\n                    } else {");
        mb.append("\n                        "+colname+" = 0;");
        mb.append("\n                    }");
        return mb.toString();
    }

    public String getJavaType(){
        return "double";
    }
}
