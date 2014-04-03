package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.AccessCapability;

@Stateless
@LocalBean
public class AccessCapabilityDAO {

    @PersistenceContext
    private EntityManager em;
    
    public AccessCapability getAccessCapability(int accessID) {
        return em.find(AccessCapability.class, accessID);
    }
    
    public List<AccessCapability> getAllAccessCapability(){
        TypedQuery<AccessCapability> q = em.createQuery("select o from AccessCapability o", AccessCapability.class);
        List<AccessCapability> listOfAccessCapability = q.getResultList();
        return listOfAccessCapability;
        }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addAccessCapabilities(List<AccessCapability> accessCapabilitys) {
        for (AccessCapability accessCapability : accessCapabilitys) {
            em.persist(accessCapability);
        }
    }
    
}
