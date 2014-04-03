package loader;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.UEModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Stateless
@LocalBean
public class UEModelConfig {
	
	String workbookFileName = "/home/group5/workspace/Database3/LargeData.xls";
    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addUEModels(){
    	
    	Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);
		
		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);
			if (em.createNamedQuery("UEModel.findByName").setParameter("modelName", row[ColumnIndexes.UE_MODEL_COLNO]
							.getContents()).getResultList().size() == 0){
				UEModel ueModel = new UEModel(row[ColumnIndexes.UE_MODEL_COLNO]
							.getContents());
				em.persist(ueModel);
			
			}
		}
    }

}
