package reger.dao.util;

import reger.dao.DAO;
import reger.core.ValidationException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Calls the validate method on a number of DAOs and throws validation errors that occur
 */
public class SaveArrayListOfDAOs {

    public static void save(ArrayList<? extends DAO> daos) throws ValidationException {
        ValidationException vex = new ValidationException();
        for (Iterator it = daos.iterator(); it.hasNext(); ) {
            DAO dao = (DAO)it.next();
            try{
                dao.save();
            } catch (ValidationException vextmp){
                vex.addErrorsFromAnotherValidationException(vextmp);
            }
        }
        if (vex.getErrors().length>0){
            throw vex;
        }
    }


}
