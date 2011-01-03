package reger.dao.hibernate.eventlisteners;

import org.hibernate.event.def.DefaultSaveEventListener;
import org.hibernate.event.EventSource;
import org.hibernate.persister.entity.EntityPersister;
import reger.dao.hibernate.ValidateWorker;
import reger.dao.hibernate.HibValEx;

public class RegerDefaultSaveEventListener extends DefaultSaveEventListener {

    public void validate(Object entity, EntityPersister persister, EventSource source){
        super.validate(entity, persister, source);
        try{
            ValidateWorker.validate(entity);
        } catch (HibValEx hex){
            throw hex;
        }
    }

}
