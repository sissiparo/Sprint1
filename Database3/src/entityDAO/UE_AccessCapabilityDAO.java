package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.UE_AccessCapability;

@Stateless
@LocalBean
public class UE_AccessCapabilityDAO {

    @PersistenceContext
    private EntityManager em;
    
    public UE_AccessCapability getUE_AccessCapability(String userEquipID) {
        return em.find(UE_AccessCapability.class, userEquipID);
    }
    
    public List<UE_AccessCapability> getAllUE_AccessCapability(){
	    TypedQuery<UE_AccessCapability> q = em.createQuery("select o from UE_AccessCapability o", UE_AccessCapability.class);
	    List<UE_AccessCapability> listOfUE_AccessCapability = q.getResultList();
	    return listOfUE_AccessCapability;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addUE_AccessCapabilitys(List<UE_AccessCapability> ue_accessCapabilities) {
        for (UE_AccessCapability ue_accessCapability : ue_accessCapabilities) {
            em.persist(ue_accessCapability);
        }
    }
    
}
