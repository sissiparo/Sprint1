package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Manufacturer;

@Stateless
@LocalBean
public class ManufacturerDAO {

    @PersistenceContext
    private EntityManager em;
    
    public Manufacturer getManufacturer(int manufacturerID) {
        return em.find(Manufacturer.class, manufacturerID);
    }
    
    public List<Manufacturer> getAllManufacturer(){
	    TypedQuery<Manufacturer> q = em.createQuery("select o from Manufacturer o", Manufacturer.class);
	    List<Manufacturer> listOfManufacturer = q.getResultList();
	    return listOfManufacturer;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addManufacturers(List<Manufacturer> manufacturers) {
        for (Manufacturer manufacturer : manufacturers) {
            em.persist(manufacturer);
        }
    }
    
}
