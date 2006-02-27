package reger.dao.generator;

import reger.core.db.Db;
import reger.dao.generator.dbcolumntypes.DbColumnType;
import reger.dao.generator.dbcolumntypes.DbColumnTypeFactory;

import java.util.ArrayList;

/**
 * Generates java code
 */
public class FinderGenerator {

    private String nameOfPrimaryKeyColumn = null;
    private ArrayList<String> methodsAlreadyCreated = new ArrayList<String>();

    public String getDaoForTable(String tablename){
        StringBuffer mb = new StringBuffer();

        mb.append("package reger.dao.finders;\n" +
                "\n" +
                "import reger.core.db.Db;\n" +
                "import java.util.ArrayList;\n" +
                "import reger.dao.db."+getFirstCharUpperCased(tablename)+"DAO;\n" +
                "\n" +
                "/**\n" +
                " * Finder for the '"+tablename+"' DAO\n" +
                " * \n" +
                " * DO NOT EDIT MANUALLY\n" +
                " * \n" +
                " *   ______             ____  _____         _     ________        __   _   _   \n" +
                " *  |_   _ `.          |_   \\|_   _|       / |_  |_   __  |      |  ] (_) / |_ \n" +
                " *    | | `. \\  .--.     |   \\ | |   .--. `| |-'   | |_ \\_|  .--.| |  __ `| |-'\n" +
                " *    | |  | |/ .'`\\ \\   | |\\ \\| | / .'`\\ \\| |     |  _| _ / /'`\\' | [  | | |  \n" +
                " *   _| |_.' /| \\__. |  _| |_\\   |_| \\__. || |,   _| |__/ || \\__/  |  | | | |, \n" +
                " *  |______.'  '.__.'  |_____|\\____|'.__.' \\__/  |________| '.__.;__][___]\\__/\n" +
                " * \n" +
                " */\n" +
                "\n" +
                "public class "+ FinderGenerator.getFirstCharUpperCased(tablename)+"Finder {\n" +
                "\n" +
                "\n" + getFinderMethods(tablename) +
                "\n" +
                "}");



        return mb.toString();
    }



    private String getNameOfPrimaryKeyColumn(String tablename){
        if (nameOfPrimaryKeyColumn!=null && !nameOfPrimaryKeyColumn.equals("")){
            return nameOfPrimaryKeyColumn;
        } else {
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
                        nameOfPrimaryKeyColumn = colname;
                        return nameOfPrimaryKeyColumn;
                    }
                }
            }
        }
        reger.core.Debug.logtodb("Unable to find primary key for table: "+tablename, "Generator.java");
        return "";
    }



    private String getFinderMethods(String tablename){
        StringBuffer mb = new StringBuffer();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SHOW COLUMNS FROM "+tablename);
        //-----------------------------------
        //-----------------------------------
        ArrayList<Col> allcolumns = new ArrayList<Col>();
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                String colname = rstData[i][0];
                String type = rstData[i][1];
                String key = rstData[i][3];
                //DbColumnType dbColType = DbColumnTypeFactory.getByMySqlTypeValue(type);

                allcolumns.add(new Col(colname, type));

                //String methodName = "findBy" + FinderGenerator.getFirstCharUpperCased(colname);
                //String methodSignature = dbColType.getJavaType()+" "+colname;
                //String methodParamPass = colname;
                //String whereSql = colname+"='\"+"+dbColType.getValueForInsertIntoDb(colname)+"+\"'";

                //Get the simple one-column finder
                //mb.append(getMethodJavaCode(methodName, methodSignature, methodParamPass, whereSql, tablename));
            }
        }
        if (allcolumns.size()>0){
            int maxnumofcolsincombo = 2;
            if (allcolumns.size()<maxnumofcolsincombo){
                maxnumofcolsincombo = allcolumns.size();
            }
            for(int i=1; i<=maxnumofcolsincombo; i++){
                mb.append(getMethodsForCombosOfCertainLength(allcolumns, i, tablename));
            }
        }
        return mb.toString();
    }

    private StringBuffer getMethodsForCombosOfCertainLength(ArrayList<Col> allcolumns, int numberofcolsincombo, String tablename){
        StringBuffer mb = new StringBuffer();
        int[] indices;
        CombinationGenerator x = new CombinationGenerator (allcolumns.size(), numberofcolsincombo);
        while (x.hasMore()) {
            indices = x.getNext();
            String methodName = "findBy";
            String methodSignature = "";
            String methodParamPass = "";
            String whereSql = "";
            reger.core.Debug.debug(5, "FinderGenerator.java", "Start Iteration of Indices numberofcolsincombo="+numberofcolsincombo+"<br>================");
            boolean hasonebeenadded = false;
            for (int i = 0; i<indices.length; i++) {
                reger.core.Debug.debug(5, "FinderGenerator.java", "indices["+i+"]="+indices[i]);
                Col col = allcolumns.get(indices[i]);
                reger.core.Debug.debug(5, "FinderGenerator.java", "col.getColname()="+col.getColname());
                if (col!=null && !col.getColname().equals("")){
                    DbColumnType dbColType = DbColumnTypeFactory.getByMySqlTypeValue(col.getColtype());
                    String comma = "";
                    reger.core.Debug.debug(5, "FinderGenerator.java", "i="+i+"<br>indices.length="+indices.length+"<br>(indices.length-1)="+(indices.length-1));
                    if (hasonebeenadded){
                        reger.core.Debug.debug(5, "FinderGenerator.java", "Appending the comma.");
                        comma = ", ";
                    } else {
                        hasonebeenadded = true;
                        reger.core.Debug.debug(5, "FinderGenerator.java", "NOT Appending the comma.");
                    }
                    methodName = methodName + FinderGenerator.getFirstCharUpperCased(col.getColname());
                    methodSignature = methodSignature + comma + dbColType.getJavaType()+" "+col.getColname();
                    methodParamPass = methodParamPass + comma + col.getColname();
                    whereSql = whereSql + comma + col.getColname()+"='\"+"+dbColType.getValueForInsertIntoDb(col.getColname())+"+\"'";

                    if (!methodsAlreadyCreated.contains(methodName)){
                        methodsAlreadyCreated.add(methodName);
                        mb.append(getMethodJavaCode(methodName, methodSignature, methodParamPass, whereSql, tablename));
                    }
                } else {
                    reger.core.Debug.debug(5, "FinderGenerator.java", "****col not found indices[i]="+indices[i]+"<br>allcolumns.size()="+allcolumns.size());
                }
            }
            reger.core.Debug.debug(5, "FinderGenerator.java", "================<br>End Iteration of Indices numberofcolsincombo="+numberofcolsincombo);
        }
        return mb;
    }



    private StringBuffer getMethodJavaCode(String methodName, String methodSignature, String methodParamPass, String whereSql, String tablename){
        StringBuffer mb = new StringBuffer();
        mb.append("    public static ArrayList<"+getFirstCharUpperCased(tablename)+"DAO> "+methodName+"("+methodSignature+") {\n" +
                  "        return "+methodName+"("+methodParamPass+", 0, 50000);\n" +
                  "    }\n" +
                  "\n" +
                  "    public static ArrayList<"+getFirstCharUpperCased(tablename)+"DAO> "+methodName+"("+methodSignature+", int limitmin, int limitmax) {\n" +
                  "        ArrayList<"+getFirstCharUpperCased(tablename)+"DAO> resultarraylist = new ArrayList<"+getFirstCharUpperCased(tablename)+"DAO>();\n" +
                  "        //-----------------------------------\n" +
                  "        //-----------------------------------\n" +
                  "        String[][] rstData= Db.RunSQL(\"SELECT "+getNameOfPrimaryKeyColumn(tablename)+" FROM "+tablename+" WHERE "+whereSql+" LIMIT \"+limitmin+\", \"+limitmax+\" \");\n" +
                  "        //-----------------------------------\n" +
                  "        //-----------------------------------\n" +
                  "        if (rstData!=null && rstData.length>0){\n" +
                  "            for(int i=0; i<rstData.length; i++){\n" +
                  "                 resultarraylist.add(new "+getFirstCharUpperCased(tablename)+"DAO(Integer.parseInt(rstData[i][0])));\n" +
                  "            }\n" +
                  "        }\n" +
                  "        return resultarraylist;\n" +
                  "    }\n" +
                  "\n");

         return mb;
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
