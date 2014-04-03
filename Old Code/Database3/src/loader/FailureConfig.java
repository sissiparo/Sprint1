package loader;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import entities.Country;
import entities.Failure;

@Stateless
@LocalBean
public class FailureConfig {
	String workbookFileName = "/home/group5/workspace/Database3/LargeData.xls";
    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public  void addFailures(){
		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook
				.getSheet(ColumnIndexes.FAILURECLASS__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);

			if (row.length > 0) {
				Failure f = em.find(Failure.class, Integer.parseInt(row[ColumnIndexes.FAILURECLASS_FAILURECLASS_COLNO]
						.getContents()));
				if(f==null){
				Failure failure = new Failure(Integer.parseInt(row[ColumnIndexes.FAILURECLASS_FAILURECLASS_COLNO]
						.getContents()), row[ColumnIndexes.FAILURECLASS_DESCRIPTION_COLNO]
								.getContents());
				em.persist(failure);
				}
			}
		}
		
    }
}