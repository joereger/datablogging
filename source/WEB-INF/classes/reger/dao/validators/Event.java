package reger.dao.validators;


import reger.Account;
import reger.hibernate.Validator;
import reger.hibernate.HibValEx;
import reger.cache.AccountCache;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.event.EventSource;

/**
 * Validator for the event dao
 */
public class Event implements Validator {


    public void validate(Object entity) throws HibValEx {
        HibValEx vex = new HibValEx("");
        if (entity instanceof reger.dao.hibernate.Event){
            reger.dao.hibernate.Event event = (reger.dao.hibernate.Event)entity;
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
            vex.addValidationError("Testing validation error on event object.");
            vex.addValidationError("The event object is broken.");
        }
        if (vex.getErrors().length>0){
            throw vex;
        }
    }


}
