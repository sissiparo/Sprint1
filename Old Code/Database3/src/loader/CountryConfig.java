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

@Stateless
@LocalBean
public class CountryConfig {
	String workbookFileName = "/home/group5/workspace/Database3/LargeData.xls";
    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public  void addCountries(){
    	System.out.println(" 1");
    	Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.MCCMNC__SHEETNO);
    	
		Cell[] row;
		System.out.println(ColumnIndexes.MCCMNC__SHEETNO);
		for (int i = 1; i < currentSheet.getRows(); i++) {
			System.out.println(i);
			row = currentSheet.getRow(i);
			if (row.length > 0) {
				int mcc = Integer.parseInt(row[ColumnIndexes.MCCMNC_MCC_COLNO]
						.getContents());
				Country c = em.find(Country.class, mcc);
				if(c==null){
					Country country = new Country(mcc,
							row[ColumnIndexes.MCCMNC_COUNTRY_COLNO]
									.getContents());
					System.out.println(mcc + " " + row[ColumnIndexes.MCCMNC_COUNTRY_COLNO]
							.getContents());
				em.persist(country);
				}
			}
		}
		
    }
}
