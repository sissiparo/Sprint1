package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.UEModel;

@Stateless
@LocalBean
public class UEModelDAO {

    @PersistenceContext
    private EntityManager em;
    
    public UEModel getUEModel(int modelId) {
        return em.find(UEModel.class, modelId);
    }
    
    public List<UEModel> getAllUEModel(){
	    TypedQuery<UEModel> q = em.createQuery("select o from UEModel o", UEModel.class);
	    List<UEModel> listOfUEModel = q.getResultList();
	    return listOfUEModel;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addUEModels(List<UEModel> ueModels) {
        for (UEModel ueModel : ueModels) {
            em.persist(ueModel);
        }
    }
    
}
