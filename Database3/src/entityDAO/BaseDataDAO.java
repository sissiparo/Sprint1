package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.BaseData;

@Stateless
@LocalBean
public class BaseDataDAO {

    @PersistenceContext
    private EntityManager em;
    
    public BaseData getBaseData(int baseDataID) {
        return em.find(BaseData.class, baseDataID);
    }
    
    public List<BaseData> getAllBaseData(){
	    TypedQuery<BaseData> q = em.createQuery("select o from BaseData o", BaseData.class);
	    List<BaseData> listOfBaseData = q.getResultList();
	    return listOfBaseData;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addBaseDatas(List<BaseData> baseDatas) {
        for (BaseData baseData : baseDatas) {
            em.persist(baseData);
        }
    }
    
    
}
