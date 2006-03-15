package reger.hibernate;

import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.event.EventSource;
import reger.core.ValidationException;

/**
 * Simple validator interface
 */
public interface Validator {

    public void validate(Object entity) throws ValidationException;

}
