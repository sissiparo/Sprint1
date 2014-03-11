package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Failure;

@Stateless
@LocalBean
public class FailureDAO {

    @PersistenceContext
    private EntityManager em;
    
    public Failure getFailure(int failureID) {
        return em.find(Failure.class, failureID);
    }
    
    public List<Failure> getAllFailure(){
	    TypedQuery<Failure> q = em.createQuery("select o from Failure o", Failure.class);
	    List<Failure> listOfFailure = q.getResultList();
	    return listOfFailure;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addFailures(List<Failure> failures) {
        for (Failure failure : failures) {
            em.persist(failure);
        }
    }
    
}
