package entityDAO;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
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
//	    TypedQuery<BaseData> q = em.createQuery("select o from BaseData o", BaseData.class);
	    Query q = em.createQuery("select o from BaseData o");
	    List<BaseData> listOfBaseData = q.setMaxResults(10).getResultList();
	    return listOfBaseData;
    }
    
    public List<BaseData> getImsiBaseData(){
    	Query q = em.createQuery("select imsi from BaseData");
    	List<BaseData> listOfBaseData = q.setMaxResults(10).getResultList();
		return listOfBaseData;

    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addBaseDatas(List<BaseData> baseDatas) {
        for (BaseData baseData : baseDatas) {
            em.persist(baseData);
        }
    }
    
    public List<BaseData> userStory4(String imsi){
    	Query q = em.createQuery("select imsi, eventcause.eventID, eventcause.causeCode from BaseData"
    			+ " where imsi=" + imsi);
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
    }
    
    public List<BaseData> userStory5(String imsi, Date startDate, Date endDate){
    	Query q = em.createQuery("select count(*) from BaseData where BaseDate between : startDate '' and endDate '' and imsi="+ imsi)
    	.setParameter("startDate", startDate, TemporalType.DATE)
        .setParameter("endDate", endDate, TemporalType.DATE);
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
    }
    
    public List<BaseData> userStory6(String imsi){
    	Query q = em.createQuery("SELECT imsi, eventcause.eventID, eventcause.eventcauseCode,"
    			+ " eventcause.causeCode, eventcause.causeDescription FROM BaseData where imsi=" + imsi
    			+ " GROUP BY eventcause.causeCode");
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
    }

    
    
}
