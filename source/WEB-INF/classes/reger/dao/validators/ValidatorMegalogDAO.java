package reger.dao.validators;

import reger.dao.DAO;
import reger.dao.db.EventDAO;
import reger.dao.db.MegalogDAO;
import reger.core.ValidationException;
import reger.Account;
import reger.cache.AccountCache;

/**
 * Validator for the megalog dao
 */
public class ValidatorMegalogDAO {

    public void validate(DAO obj) throws ValidationException {
        ValidationException vex = new ValidationException();
        if (obj instanceof MegalogDAO){
            MegalogDAO megalog = (MegalogDAO)obj;
            //Title can't be blank
            if (megalog.getName().equals("")){
                vex.addValidationError("Log name can not be blank.");
            }
            //Get the account
            if (megalog.getAccountid()==0){
                vex.addValidationError("Log must be associated with an account.");
            }
        }
        if (vex.getErrors().length>0){
            throw vex;
        }
    }



}
