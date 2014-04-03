package entityDAO;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import loader.ColumnIndexes;
import loader.CountryConfig;
import loader.WorkbookSingleton;
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
    public void addCountries() {
    	System.out.println("country...");

    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addCountry() {
    	Country country = new Country(555, "Wales");
        em.persist(country);
    }
    
}
