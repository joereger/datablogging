package reger.dao.validators;

import reger.dao.DAO;
import reger.dao.db.EventDAO;
import reger.core.ValidationException;
import reger.Account;
import reger.cache.AccountCache;

/**
 * Validator for the event dao
 */
public class ValidatorEventDAO {


    public void validate(DAO obj) throws ValidationException{
        ValidationException vex = new ValidationException();
        if (obj instanceof EventDAO){
            EventDAO event = (EventDAO)obj;
            //Title can't be blank
            if (event.getTitle().equals("")){
                vex.addValidationError("Entry title can not be blank.");
            }
            //Get the account
            if (event.getAccountid()>0){
                Account account = AccountCache.get(event.getAccountid());
                //Make sure we have enough space on the account before processing it.
                if (account.getMaxspaceinbytes() > 0 && (long) reger.core.Util.sizeInBytes(event.getComments()) > (account.getMaxspaceinbytes() - account.getSpaceused())) {
                    vex.addValidationError("There is not enough storage space available on this account.");
                }
                if (event.getLogid()>0){
                    //logid must be associated with this account
                    if (!Account.isLogidValidForAccountid(account.getAccountid(), event.getLogid())) {
                        vex.addValidationError("The given log (logid=" + event.getLogid() + ") is not associated with the given account (accountid=" + account.getAccountid() + ").");
                    }
                } else {
                    vex.addValidationError("Entry must be associated with a log.");
                }
            } else {
                vex.addValidationError("Entry must be associated with an account.");
            }
        }
        if (vex.getErrors().length>0){
            throw vex;
        }
    }


}
