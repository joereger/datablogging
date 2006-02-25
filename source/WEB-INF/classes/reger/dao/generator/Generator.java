package reger.dao.generator;

import reger.core.db.Db;
import reger.dao.generator.dbcolumntypes.DbColumnType;
import reger.dao.generator.dbcolumntypes.DbColumnTypeFactory;

/**
 * Generates java code
 */
public class Generator {

    public String getDaoForTable(String tablename){
        StringBuffer mb = new StringBuffer();

        mb.append("package reger.dao;\n" +
                "\n" +
                "import reger.core.db.Db;\n" +
                "\n" +
                "/**\n" +
                " * DAO for "+tablename+" database table - DO NOT EDIT MANUALLY\n" +
                " * \n" +
                " *  ______             ____  _____         _     ________        __   _   _   \n" +
                " *  |_   _ `.          |_   \\|_   _|       / |_  |_   __  |      |  ] (_) / |_ \n" +
                " *    | | `. \\  .--.     |   \\ | |   .--. `| |-'   | |_ \\_|  .--.| |  __ `| |-'\n" +
                " *    | |  | |/ .'`\\ \\   | |\\ \\| | / .'`\\ \\| |     |  _| _ / /'`\\' | [  | | |  \n" +
                " *   _| |_.' /| \\__. |  _| |_\\   |_| \\__. || |,   _| |__/ || \\__/  |  | | | |, \n" +
                " *  |______.'  '.__.'  |_____|\\____|'.__.' \\__/  |________| '.__.;__][___]\\__/\n" +
                " * \n" +
                " */\n" +
                "\n" +
                "public class "+getFirstCharUpperCased(tablename)+"DAO {\n" +
                "\n" +
                "" + getProperties(tablename) +
                "\n" +
                "\n" +
                "    public "+getFirstCharUpperCased(tablename)+"DAO (int "+getNameOfPrimaryKeyColumn(tablename)+"){\n" +
                "        this."+getNameOfPrimaryKeyColumn(tablename)+" = "+getNameOfPrimaryKeyColumn(tablename)+";\n" +
                "        load();\n" +
                "    }\n" +
                "\n" +
                "    public "+getFirstCharUpperCased(tablename)+"DAO(){\n" +
                "\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    public void load(){\n" +
                "        //-----------------------------------\n" +
                "        //-----------------------------------\n" +
                "        String[][] rstData= Db.RunSQL(\"SELECT "+getCommaSeparatedListOfColumnsInTable(tablename)+" FROM "+tablename+" WHERE "+getNameOfPrimaryKeyColumn(tablename)+"='\"+"+getNameOfPrimaryKeyColumn(tablename)+"+\"'\");\n" +
                "        //-----------------------------------\n" +
                "        //-----------------------------------\n" +
                "        if (rstData!=null && rstData.length>0){\n" +
                "            " + getLoadSection(tablename) +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    public void save() throws reger.core.ValidationException{\n" +
                "        try{\n" +
                "            validate();\n" +
                "        } catch (reger.core.ValidationException vex){\n" +
                "            throw vex;\n" +
                "        }\n" +
                "\n" +
                "        //-----------------------------------\n" +
                "        //-----------------------------------\n" +
                "        String[][] rstData= Db.RunSQL(\"SELECT "+getNameOfPrimaryKeyColumn(tablename)+" FROM "+tablename+" WHERE "+getNameOfPrimaryKeyColumn(tablename)+"='\"+"+getNameOfPrimaryKeyColumn(tablename)+"+\"' AND "+getNameOfPrimaryKeyColumn(tablename)+">'0'\");\n" +
                "        //-----------------------------------\n" +
                "        //-----------------------------------\n" +
                "        if (rstData!=null && rstData.length>0){\n" +
                "            //-----------------------------------\n" +
                "            //-----------------------------------\n" +
                "            int fsdfsdf = Db.RunSQLUpdate(\"UPDATE "+tablename+" SET "+getSaveSetStatement(tablename)+" WHERE "+getNameOfPrimaryKeyColumn(tablename)+"='\"+"+getNameOfPrimaryKeyColumn(tablename)+"+\"'\");\n" +
                "            //-----------------------------------\n" +
                "            //-----------------------------------\n" +
                "        } else {\n" +
                "            //-----------------------------------\n" +
                "            //-----------------------------------\n" +
                "            "+getNameOfPrimaryKeyColumn(tablename)+" = Db.RunSQLInsert(\"INSERT INTO "+tablename+"("+getCommaSeparatedListOfColumnsInTableWithoutPrimary(tablename)+") VALUES("+getSaveUpdateStatement(tablename)+")\");\n" +
                "            //-----------------------------------\n" +
                "            //-----------------------------------\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    public void delete(){\n" +
                "        //-----------------------------------\n" +
                "        //-----------------------------------\n" +
                "        int count = Db.RunSQLUpdate(\"DELETE FROM "+tablename+" WHERE "+getNameOfPrimaryKeyColumn(tablename)+"='\"+"+getNameOfPrimaryKeyColumn(tablename)+"+\"'\");\n" +
                "        //-----------------------------------\n" +
                "        //-----------------------------------\n" +
                "    }\n" +
                "\n" +
                "    public void validate() throws reger.core.ValidationException{\n" +
                "        try{\n" +
                "            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName(\"reger.dao.validators.Validator"+getFirstCharUpperCased(tablename)+"DAO\").newInstance());\n" +
                "            try{\n" +
                "                validator.validate(this);\n"+
                "            } catch (reger.core.ValidationException vex){\n" +
                "                throw vex;\n" +
                "            }\n" +
                "        } catch (ClassNotFoundException ex){\n" +
                "            \n" +
                "        } catch (Throwable e){\n" +
                "            reger.core.Debug.errorsave(e, \""+tablename+"DAO.java\");\n" +
                "            \n" +
                "        }\n"+
                "    }\n" +
                "\n" + getGettersAndSetters(tablename) +
                "\n" +
                "}");



        return mb.toString();
    }

    private String getProperties(String tablename){
        StringBuffer mb = new StringBuffer();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SHOW COLUMNS FROM "+tablename);
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                String colname = rstData[i][0];
                String type = rstData[i][1];
                String key = rstData[i][3];

                DbColumnType dbColType = DbColumnTypeFactory.getByMySqlTypeValue(type);
                mb.append(dbColType.getProperty(colname));
            }
        }
        return mb.toString();
    }

    private String getNameOfPrimaryKeyColumn(String tablename){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SHOW COLUMNS FROM "+tablename);
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                String colname = rstData[i][0];
                String type = rstData[i][1];
                String key = rstData[i][3];

                if (key.indexOf("PRI")>-1){
                    return colname;
                }
            }
        }
        reger.core.Debug.logtodb("Unable to find primary key for table: "+tablename, "Generator.java");
        return "";
    }

    private String getCommaSeparatedListOfColumnsInTable(String tablename){
        StringBuffer mb = new StringBuffer();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SHOW COLUMNS FROM "+tablename);
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                String colname = rstData[i][0];
                String type = rstData[i][1];
                String key = rstData[i][3];

                mb.append(colname);
                if (i<(rstData.length-1)){
                    mb.append(", ");
                } else {
                    mb.append(" ");
                }
            }
        }
        return mb.toString();
    }

    private String getLoadSection(String tablename){
        StringBuffer mb = new StringBuffer();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SHOW COLUMNS FROM "+tablename);
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                String colname = rstData[i][0];
                String type = rstData[i][1];
                String key = rstData[i][3];

                DbColumnType dbColType = DbColumnTypeFactory.getByMySqlTypeValue(type);
                mb.append(dbColType.getValueFromDb(colname, i));
                mb.append("\n");
            }
        }
        return mb.toString();
    }



    private String getSaveSetStatement(String tablename){
        StringBuffer mb = new StringBuffer();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SHOW COLUMNS FROM "+tablename);
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                String colname = rstData[i][0];
                String type = rstData[i][1];
                String key = rstData[i][3];

                DbColumnType dbColType = DbColumnTypeFactory.getByMySqlTypeValue(type);

                mb.append(colname+"='\"+"+dbColType.getValueForInsertIntoDb(colname)+"+\"'");

                if (i<(rstData.length-1)){
                    mb.append(", ");
                } else {
                    mb.append(" ");
                }
            }
        }
        return mb.toString();
    }

    private String getCommaSeparatedListOfColumnsInTableWithoutPrimary(String tablename){
        StringBuffer mb = new StringBuffer();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SHOW COLUMNS FROM "+tablename);
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                String colname = rstData[i][0];
                String type = rstData[i][1];
                String key = rstData[i][3];

                if (!(key.indexOf("PRI")>-1)){
                    mb.append(colname);
                    if (i<(rstData.length-1)){
                        mb.append(", ");
                    } else {
                        mb.append(" ");
                    }
                }
            }
        }
        return mb.toString();
    }

    private String getSaveUpdateStatement(String tablename){
        StringBuffer mb = new StringBuffer();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SHOW COLUMNS FROM "+tablename);
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                String colname = rstData[i][0];
                String type = rstData[i][1];
                String key = rstData[i][3];

                DbColumnType dbColType = DbColumnTypeFactory.getByMySqlTypeValue(type);

                mb.append("'\"+"+dbColType.getValueForInsertIntoDb(colname)+"+\"'");

                if (i<(rstData.length-1)){
                    mb.append(", ");
                } else {
                    mb.append(" ");
                }
            }
        }
        return mb.toString();
    }

    private String getGettersAndSetters(String tablename){
        StringBuffer mb = new StringBuffer();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SHOW COLUMNS FROM "+tablename);
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                String colname = rstData[i][0];
                String type = rstData[i][1];
                String key = rstData[i][3];

                DbColumnType dbColType = DbColumnTypeFactory.getByMySqlTypeValue(type);

                mb.append("\n    public "+dbColType.getJavaType()+" get"+getFirstCharUpperCased(colname)+"() {\n" +
                        "        return "+colname+";\n" +
                        "    }\n" +
                        "\n");

                if (!(key.indexOf("PRI")>-1)){
                    mb.append("\n    public void set"+getFirstCharUpperCased(colname)+"("+dbColType.getJavaType()+" "+colname+") {\n" +
                        "        this."+colname+" = "+colname+";\n" +
                        "    }\n\n");
                }

            }
        }
        return mb.toString();
    }

    public static String getFirstCharUpperCased(String in){
        if (in!=null && in.length()>0){
            String firstchar = in.substring(0,1);
            String firstcharuppercase = firstchar.toUpperCase();
            if (in.length()>1){
                return firstcharuppercase + in.substring(1, in.length());
            } else {
                return firstcharuppercase;
            }
        }
        return in;
    }

}
