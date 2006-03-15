package reger.hibernate.eventlisteners;

import org.hibernate.event.def.DefaultUpdateEventListener;
import org.hibernate.event.EventSource;
import org.hibernate.persister.entity.EntityPersister;
import reger.hibernate.ValidateWorker;
import reger.hibernate.HibValEx;

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
