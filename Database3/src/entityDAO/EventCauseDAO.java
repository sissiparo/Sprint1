package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.EventCause;

@Stateless
@LocalBean
public class EventCauseDAO {

    @PersistenceContext
    private EntityManager em;
    
    public EventCause getEventCause(int eventcauseCode) {
        return em.find(EventCause.class, eventcauseCode);
    }
    
    public List<EventCause> getAllEventCause(){
	    TypedQuery<EventCause> q = em.createQuery("select o from EventCause o", EventCause.class);
	    List<EventCause> listOfEventCause = q.getResultList();
	    return listOfEventCause;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addEventCauses(List<EventCause> eventCauses) {
        for (EventCause eventCause : eventCauses) {
            em.persist(eventCause);
        }
    }
    
}
