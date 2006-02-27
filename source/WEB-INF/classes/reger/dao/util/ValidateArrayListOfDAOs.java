package reger.dao.util;


import reger.core.ValidationException;
import reger.dao.DAO;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * Calls the validate method on a number of DAOs and throws validation errors that occur
 */
public class ValidateArrayListOfDAOs {

    public static void validate(ArrayList<? extends DAO> daos) throws ValidationException{
        ValidationException vex = new ValidationException();
        for (Iterator it = daos.iterator(); it.hasNext(); ) {
            DAO dao = (DAO)it.next();
            try{
                dao.validate();
            } catch (ValidationException vextmp){
                vex.addErrorsFromAnotherValidationException(vextmp);
            }
        }
        if (vex.getErrors().length>0){
            throw vex;
        }
    }


}
