package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.CellTable;

@Stateless
@LocalBean
public class CellTableDAO {

    @PersistenceContext
    private EntityManager em;
    
    public CellTable getCellTable(int cellID) {
        return em.find(CellTable.class, cellID);
    }
    
    public List<CellTable> getAllCellTable(){
        TypedQuery<CellTable> q = em.createQuery("select o from CellTable o", CellTable.class);
        List<CellTable> listOfCellTable = q.getResultList();
        return listOfCellTable;
        }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addCellTables(List<CellTable> cellTables) {
        for (CellTable cellTable : cellTables) {
            em.persist(cellTable);
        }
    }
    
}
