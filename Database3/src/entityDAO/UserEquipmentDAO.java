package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.UserEquipment;
import entities.UserEquipment;

@Stateless
@LocalBean
public class UserEquipmentDAO {

    @PersistenceContext
    private EntityManager em;
    
    public UserEquipment getUserEquipment(String modelId) {
        return em.find(UserEquipment.class, modelId);
    }
    
    public List<UserEquipment> getAllUserEquipment(){
	    TypedQuery<UserEquipment> q = em.createQuery("select o from UserEquipment o", UserEquipment.class);
	    List<UserEquipment> listOfUserEquipment = q.getResultList();
	    return listOfUserEquipment;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addUserEquipments(List<UserEquipment> userEquipments) {
        for (UserEquipment userEquipment : userEquipments) {
            em.persist(userEquipment);
        }
    }
    
}
