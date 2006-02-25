package reger.dao.validators;

import reger.core.ValidationException;

/**
 * Validation class for a DAO
 */
public interface Validator {

    public boolean validate(Object obj) throws ValidationException;

}
