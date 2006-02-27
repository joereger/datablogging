package reger.dao.util;

import reger.dao.DAO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Take an arraylist of DAOs called old
 * And an arraylist of DAOs called new
 *
 * Find those in old that aren't in new and call their delete() method
 */
public class DeleteDAOsNoLongerInArrayList {

    public static void delete(ArrayList<? extends DAO> olds, ArrayList<? extends DAO> news){
        for (Iterator it = olds.iterator(); it.hasNext(); ) {
            DAO oldDao = (DAO)it.next();
            if (!isDaoInArrayList(oldDao, news)){
                oldDao.delete();
            }
        }
    }

    private static boolean isDaoInArrayList(DAO dao, ArrayList<? extends DAO> list){
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            DAO listDao = (DAO)it.next();
            if (listDao.getTableName()==dao.getTableName()){
                if(listDao.getPrimaryKeyName().equals(dao.getPrimaryKeyName())){
                    if(listDao.getPrimaryKeyValue()==dao.getPrimaryKeyValue()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
