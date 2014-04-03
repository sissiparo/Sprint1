package loader;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.AccessCapability;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Stateless
@LocalBean
public class AccessCapabilityConfig {
	String workbookFileName = "/home/group5/workspace/Database3/LargeData.xls";
    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addAccessCapabilities(){
	Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
	Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);
	Cell[] row;
	
	for (int i = 1; i < currentSheet.getRows(); i++) {
		row = currentSheet.getRow(i);

		if (row.length > 0) {
			String concatCapabilities = row[ColumnIndexes.UE_ACCESSCAPABILITY_COLNO]
					.getContents();
			if(concatCapabilities.contains(", ")){
				String[] indivCapabilities = concatCapabilities.split(", ");
				for (int j = 0; j < indivCapabilities.length; j++) {
					
					if(em.createNamedQuery("AccessCapability.findByAccessCapability")
							.setParameter("accessCapability", indivCapabilities[j]).getResultList().size() == 0){
						AccessCapability accessCapability = new AccessCapability(indivCapabilities[j]);
						em.persist(accessCapability);
					}
				}
			}
			else{
				String indivCapabilities = concatCapabilities;
				if(em.createNamedQuery("AccessCapability.findByAccessCapability")
						.setParameter("accessCapability", indivCapabilities).getResultList().size() == 0){
					AccessCapability accessCapability = new AccessCapability(indivCapabilities);
					em.persist(accessCapability);
				}
			}

		}

	}
}
}
