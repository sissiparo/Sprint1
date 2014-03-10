package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Country;

@Stateless
@LocalBean
public class CountryDAO {

    @PersistenceContext
    private EntityManager em;
    
    public Country getCountry(int mcc) {
        return em.find(Country.class, mcc);
    }
    
    public List<Country> getAllCountry(){
        TypedQuery<Country> q = em.createQuery("select o from Country o", Country.class);
        List<Country> listOfCountry = q.getResultList();
        return listOfCountry;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addCountrys(List<Country> countries) {
        for (Country country : countries) {
            em.persist(country);
        }
    }
    
}
