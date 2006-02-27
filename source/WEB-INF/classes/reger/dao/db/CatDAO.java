package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'cat' database table
 * 
 * DO NOT EDIT MANUALLY
 * 
 *   ______             ____  _____         _     ________        __   _   _   
 *  |_   _ `.          |_   \|_   _|       / |_  |_   __  |      |  ] (_) / |_ 
 *    | | `. \  .--.     |   \ | |   .--. `| |-'   | |_ \_|  .--.| |  __ `| |-'
 *    | |  | |/ .'`\ \   | |\ \| | / .'`\ \| |     |  _| _ / /'`\' | [  | | |  
 *   _| |_.' /| \__. |  _| |_\   |_| \__. || |,   _| |__/ || \__/  |  | | | |, 
 *  |______.'  '.__.'  |_____|\____|'.__.' \__/  |________| '.__.;__][___]\__/
 * 
 * Validator for this DAO: reger.dao.validators.ValidatorCatDAO.java
 * Finders for this DAO: reger.dao.finders.CatFinder.java
 * 
 */

public class CatDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "catDAO";

    protected int catid = 0;
    protected String name = "";
    protected String sex = "";
    protected double weight = 0;

    public CatDAO (int catid){
        this.catid = catid;
        load();
    }

    public CatDAO(){


    }

    public void load(){
        if (catid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(catid), CACHEGROUP);
            if (obj!=null && (obj instanceof CatDAO)){
                setProperties((CatDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT catid, name, sex, weight  FROM cat WHERE catid='"+catid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        catid = Integer.parseInt(rstData[0][0]);
                    } else {
                        catid = 0;
                    }

                    name = rstData[0][1];

                    sex = rstData[0][2];

                    if (reger.core.Util.isnumeric(rstData[0][3])){
                        weight = Double.parseDouble(rstData[0][3]);
                    } else {
                        weight = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(catid), CACHEGROUP, this);
            }
        }
    }

    public void save() throws reger.core.ValidationException{
        try{
            validate();
        } catch (reger.core.ValidationException vex){
            throw vex;
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT catid FROM cat WHERE catid='"+catid+"' AND catid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE cat SET catid='"+catid+"', name='"+reger.core.Util.cleanForSQL(name)+"', sex='"+reger.core.Util.cleanForSQL(sex)+"', weight='"+String.valueOf(weight)+"'  WHERE catid='"+catid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(catid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            catid = Db.RunSQLInsert("INSERT INTO cat(name, sex, weight ) VALUES('"+catid+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+reger.core.Util.cleanForSQL(sex)+"', '"+String.valueOf(weight)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(catid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM cat WHERE catid='"+catid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(catid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorCatDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "catDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return catid;
    }

    public String getPrimaryKeyName(){
        return "catid";
    }

    public String getTableName(){
        return "cat";
    }

    public void setProperties(CatDAO obj){
        if(obj!=null){
            this.catid = obj.catid;
            this.name = obj.name;
            this.sex = obj.sex;
            this.weight = obj.weight;
        }
    }


    public int getCatid() {
        return catid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public double getWeight() {
        return weight;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }


}