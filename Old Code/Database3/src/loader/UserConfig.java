package loader;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.User;

@Stateless
@LocalBean
public class UserConfig {
    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public  void addUsers(){
    	if(em.createNamedQuery("User.findAll").getResultList().size() == 0){
		User user2 = new User("netman", "netman", "EMP002", "Bon", "Scott", "Network Management Engineer");
		System.out.println("User2");
		em.persist(user2);
		User user3 = new User("supeng", "supeng", "EMP003", "Angus", "Young", "Support Engineer");
		em.persist(user3);
		User user4 = new User("custrep", "custrep", "EMP004", "Malcolm", "Young", "Customer Service Rep");
		em.persist(user4);
    	}
	    
    }
}

