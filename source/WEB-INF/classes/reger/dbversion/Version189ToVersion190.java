package reger.dbversion;

import reger.core.dbupgrade.UpgradeDatabaseOneVersion;
import reger.core.db.Db;
import reger.dao.generator.dbcolumntypes.*;

/**
 *
 *
 */
public class Version189ToVersion190 implements UpgradeDatabaseOneVersion {

    public void doUpgrade(){

        System.out.println("Reger.com: Beginning db upgrade.");

        //-----------------------------------
        //-----------------------------------
        String[][] rstData= reger.core.db.Db.RunSQL("SHOW TABLES");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                String tablename = rstData[i][0];
                System.out.println("Reger.com: Beginning table " + tablename);
                try{

                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstTab = Db.RunSQL("SHOW COLUMNS FROM "+tablename);
                    //-----------------------------------
                    //-----------------------------------
                    if (rstTab !=null && rstTab.length>0){
                        for(int j =0; j <rstTab.length; j++){
                            String colname = rstTab[j][0];
                            String type = rstTab[j][1];
                            String nulltxt = rstTab[j][2];
                            String key = rstTab[j][3];
                            String defaulttxt = rstTab[j][4];

                            System.out.println("Reger.com: Beginning column " + colname);

                            if (type.indexOf("tinyint")>-1){
                                if (nulltxt.equals("YES") || defaulttxt.equals("")){
                                    if (key.indexOf("PRI")<0){
                                        //-----------------------------------
                                        //-----------------------------------
                                        int count2 = Db.RunSQLUpdate("ALTER IGNORE TABLE "+tablename+" MODIFY COLUMN "+tablename+"."+colname+" "+type+" NOT NULL default '0'");
                                        //-----------------------------------
                                        //-----------------------------------
                                    }
                                }
                            } else if (type.indexOf("int")>-1){
                                if (nulltxt.equals("YES") || defaulttxt.equals("")){
                                    if (key.indexOf("PRI")<0){
                                        //-----------------------------------
                                        //-----------------------------------
                                        int count2 = Db.RunSQLUpdate("ALTER IGNORE TABLE "+tablename+" MODIFY COLUMN "+tablename+"."+colname+" "+type+" NOT NULL default '0'");
                                        //-----------------------------------
                                        //-----------------------------------
                                    }
                                }
                            } else if (type.indexOf("varchar")>-1){

                            } else if (type.indexOf("longtext")>-1){

                            } else if (type.indexOf("text")>-1){

                            } else if (type.indexOf("char")>-1){

                            } else if (type.indexOf("datetime")>-1){
                                //-----------------------------------
                                //-----------------------------------
                                //int count2 = Db.RunSQLUpdate("ALTER IGNORE TABLE "+tablename+" CHANGE "+colname+" "+colname+" "+type+" NOT NULL default '0000-00-00 00:00:00'");
                                //-----------------------------------
                                //-----------------------------------
                            } else if (type.indexOf("double")>-1){
                                if (nulltxt.equals("YES") || defaulttxt.equals("")){
                                    //-----------------------------------
                                    //-----------------------------------
                                    int count2 = Db.RunSQLUpdate("ALTER IGNORE TABLE "+tablename+" MODIFY COLUMN "+tablename+"."+colname+" "+type+" NOT NULL default '0'");
                                    //-----------------------------------
                                    //-----------------------------------
                                }
                            } else if (type.indexOf("float")>-1){
                                if (nulltxt.equals("YES") || defaulttxt.equals("")){
                                    //-----------------------------------
                                    //-----------------------------------
                                    int count2 = Db.RunSQLUpdate("ALTER IGNORE TABLE "+tablename+" MODIFY COLUMN "+tablename+"."+colname+" "+type+" NOT NULL default '0'");
                                    //-----------------------------------
                                    //-----------------------------------
                                }
                            } else {

                            }

                            System.out.println("Reger.com: Done with " + colname);

                        }
                    }

                } catch (Exception e){
                    reger.core.Debug.errorsave(e, "Version189ToVersion190.java");
                }
                System.out.println("Reger.com: Done with table " + tablename);
            }
        }



    }

        //Sample sql statements

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("CREATE TABLE `pltemplate` (`pltemplateid` int(11) NOT NULL auto_increment, logid int(11), plid int(11), type int(11), templateid int(11), PRIMARY KEY  (`pltemplateid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("ALTER TABLE megachart CHANGE daterangesavedsearchid daterangesavedsearchid int(11) NOT NULL default '0'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("ALTER TABLE account DROP gps");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("ALTER TABLE megalogtype ADD isprivate int(11) NOT NULL default '0'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("DROP TABLE megafielduser");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("CREATE INDEX name_of_index ON table (field1, field2)");
        //-----------------------------------
        //-----------------------------------


}
