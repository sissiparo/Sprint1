package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.MCCMNC;
import entities.MCCMNC;

@Stateless
@LocalBean
public class MCCMNCDAO {

    @PersistenceContext
    private EntityManager em;
    
    public MCCMNC getMCCMNC(int mccmncID) {
        return em.find(MCCMNC.class, mccmncID);
    }
    
    public List<MCCMNC> getAllMCCMNC(){
	    TypedQuery<MCCMNC> q = em.createQuery("select o from MCCMNC o", MCCMNC.class);
	    List<MCCMNC> listOfMCCMNC = q.getResultList();
	    return listOfMCCMNC;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addMCCMNCs(List<MCCMNC> mccmncs) {
        for (MCCMNC mccmnc : mccmncs) {
            em.persist(mccmnc);
        }
    }
    
}
