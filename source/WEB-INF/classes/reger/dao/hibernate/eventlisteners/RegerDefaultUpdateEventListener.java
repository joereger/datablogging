package reger.dao.hibernate.eventlisteners;

import org.hibernate.event.def.DefaultUpdateEventListener;
import org.hibernate.event.EventSource;
import org.hibernate.persister.entity.EntityPersister;
import reger.dao.hibernate.ValidateWorker;
import reger.dao.hibernate.HibValEx;

public class RegerDefaultUpdateEventListener extends DefaultUpdateEventListener {

    public void validate(Object entity, EntityPersister persister, EventSource source){
        super.validate(entity, persister, source);
        try{
            ValidateWorker.validate(entity);
        } catch (HibValEx hex){
            throw hex;
        }
    }

}
