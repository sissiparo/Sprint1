package loader;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.EventCause;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Stateless
@LocalBean
public class EventCauseConfig {

	String workbookFileName = "/home/group5/workspace/Database3/LargeData.xls";
    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addEventCauses(){
    	
		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook
				.getSheet(ColumnIndexes.EVENTCAUSE__SHEETNO);
		
		Cell[] row;
		
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);
			Query query = em.createNamedQuery("EventCause.findEventIDAndCauseCode");
			query.setParameter("eventID", Integer.parseInt(row[ColumnIndexes.EVENTCAUSE_EVENTID_COLNO].getContents()));
			query.setParameter("causeCode", Integer.parseInt(row[ColumnIndexes.EVENTCAUSE_CAUSECODE_COLNO].getContents()));
			if(query.getResultList().size() == 0){
			if (row.length > 0) {
				EventCause eventCause = new EventCause(Integer.parseInt(row[ColumnIndexes.EVENTCAUSE_CAUSECODE_COLNO]
						.getContents()),Integer.parseInt(row[ColumnIndexes.EVENTCAUSE_EVENTID_COLNO]
								.getContents()),
						row[ColumnIndexes.EVENTCAUSE_DESCRIPTION_COLNO]
								.getContents());
				em.persist(eventCause);
				System.out.println("EC Round Loop");
			}

		}
			else{
				System.out.println("Loop" + i);
			}
		}
    }
}
