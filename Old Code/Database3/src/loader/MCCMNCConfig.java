package loader;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Country;
import entities.MCCMNC;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Stateless
@LocalBean
public class MCCMNCConfig {
	
	String workbookFileName = "/home/group5/workspace/Database3/LargeData.xls";
    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public  void addMCCMNCs(){
    	
    	Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.MCCMNC__SHEETNO);
		
		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);
			int mcc = Integer.parseInt(row[ColumnIndexes.MCCMNC_MCC_COLNO].getContents());
			int mnc = Integer.parseInt(row[ColumnIndexes.MCCMNC_MNC_COLNO].getContents());
			String operator = row[ColumnIndexes.MCCMNC_OPERATOR_COLNO].getContents();
			Query query = em.createNamedQuery("MCCMNC.findMCCMNCByMCCMNC");
			query.setParameter("mnc", mnc);
			query.setParameter("mcc", mcc);
			if(query.getResultList().size() == 0){
			if (row.length > 0) {
				Country c = em.find(Country.class, mcc);
				System.out.println(c.getCountryName());
				MCCMNC mccmnc = new MCCMNC(c, mnc, operator);
				em.persist(mccmnc);
			}
			}
		
		}
		
    	
    }

}
