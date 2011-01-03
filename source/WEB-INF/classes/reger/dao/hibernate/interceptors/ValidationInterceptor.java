package reger.dao.hibernate.interceptors;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

import reger.dao.hibernate.ValidateWorker;
import reger.dao.hibernate.HibValEx;

/**
 * Intercepts for validation
 */
public class ValidationInterceptor extends EmptyInterceptor {
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types){
        try{
            reger.core.Debug.debug(5, "ValidationInterceptor.java", "Interceptor called for: " + entity.getClass().getName());
            ValidateWorker.validate(entity);
        } catch (HibValEx hex){
            throw hex;
        }
        return false;
    }
}
