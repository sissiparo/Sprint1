package entityDAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class LoadDataDAO {
	
    @PersistenceContext
    private EntityManager em;
    
    public void loadFile(){
    	
    }

}
